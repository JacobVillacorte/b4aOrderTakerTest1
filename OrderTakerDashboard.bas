B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
#Region  Activity Attributes
    #FullScreen: False
    #IncludeTitle: False
#End Region

Sub Process_Globals
	Private xui As XUI
End Sub

Sub Globals
	' Bottom navigation bar panels and labels
	Private pnlBottomNav As Panel
	Private pnlDash As Panel, lblDash As Label, lblDashIcon As Label
	Private pnlOrders As Panel, lblOrders As Label, lblOrdersIcon As Label
	Private pnlInventory As Panel, lblInventory As Label, lblInventoryIcon As Label
	Private pnlHistory As Panel, lblHistory As Label, lblHistoryIcon As Label

	' Content panels (one per tab)
	Private pnlContent As Panel
	Private pnlContentDash As Panel
	Private pnlContentOrders As Panel
	Private pnlContentInventory As Panel
	Private pnlContentHistory As Panel

	' Top bar
	Private pnlTop As Panel
	Private pnlDim As Panel
	Private lblLoggedInUser As Label
	Private lbllogout As Label
	Private lblperson As Label

	' Dashboard tab
	Private lblFetchStatus As Label
	Private lblCacheInfo As Label
	Private bttnFetchProducts As Button

	' Orders tab
	Private clvContentOrders As CustomListView
	Private etContentSearchOrder As EditText
	Private bttnAddOrder As Button

	' Inventory tab
	Private svInventory As ScrollView
	' Track active HTTP jobs so we can release/cancel them on pause
	Private currentFetchJob As HttpJob
	Private currentCustomerJob As HttpJob
	Private currentSyncJob As HttpJob
	Private syncOrdersCompletedCount As Int
	'Dashboard Status
	Private lblPendingSync As Label
	Private lblTodaySales As Label
	Private lblTodaysOrders As Label
	Private bttnSyncOrdersNow As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("OrderTakerDashboard")

	Dim displayName As String = Main.LoggedInUser
	If Main.LoggedInUserFullName <> "" Then
		displayName = Main.LoggedInUserFullName
	End If
	lblLoggedInUser.Text = "Welcome, " & displayName

	SetupOrdersDatabaseTables
	ShowPanel(pnlContentDash)
	UpdateDashboardStatusLabels
End Sub

Sub Activity_Resume
	LoadOrdersIntoList
End Sub

Sub Activity_Pause(UserClosed As Boolean)
	' Release any pending network jobs to avoid events firing after activity is paused/closed
	If currentFetchJob <> Null Then
		Try
			If currentFetchJob.IsInitialized Then currentFetchJob.Release
		Catch
			Log(LastException.Message)
		End Try
		currentFetchJob = Null
	End If

	If currentCustomerJob <> Null Then
		Try
			If currentCustomerJob.IsInitialized Then currentCustomerJob.Release
		Catch
			Log(LastException.Message)
		End Try
		currentCustomerJob = Null
	End If

	If currentSyncJob <> Null Then
		Try
			If currentSyncJob.IsInitialized Then currentSyncJob.Release
		Catch
			Log("Activity_Pause currentSyncJob release error: " & LastException.Message)
		End Try
		currentSyncJob = Null
	End If
End Sub

' Creates orders/order_items tables if they don't exist
Private Sub SetupOrdersDatabaseTables
	Main.SQLProducts.ExecNonQuery( _
        "CREATE TABLE IF NOT EXISTS orders (" & _
        "order_id INTEGER PRIMARY KEY AUTOINCREMENT, " & _
        "vendor_id INTEGER, " & _
        "user_id INTEGER, " & _
        "date_created TEXT, " & _
        "status TEXT, " & _
        "total_amount REAL)")
        
	Main.SQLProducts.ExecNonQuery( _
        "CREATE TABLE IF NOT EXISTS order_items (" & _
        "order_item_id INTEGER PRIMARY KEY AUTOINCREMENT, " & _
        "order_id INTEGER, " & _
        "product_id INTEGER, " & _
        "quantity INTEGER, " & _
        "price REAL)")

	EnsureLocalSchema
End Sub

' Safe schema migration: add only missing columns one by one
Sub EnsureLocalSchema
	If Main.SQLProducts.IsInitialized = False Then
		Log("EnsureLocalSchema skipped: SQLProducts not initialized")
		Return
	End If

	' orders table
	AddColumnIfMissing("orders", "user_id", "INTEGER DEFAULT 0")
	AddColumnIfMissing("orders", "vendor_id", "INTEGER DEFAULT 0")
	AddColumnIfMissing("orders", "convention_id", "INTEGER DEFAULT 0")
	AddColumnIfMissing("orders", "sync_status", "TEXT DEFAULT 'Holding'")
	AddColumnIfMissing("orders", "synced_at", "INTEGER DEFAULT 0")
	AddColumnIfMissing("orders", "transaction_number", "TEXT")
	AddColumnIfMissing("orders", "device_id", "TEXT")
	' customer fields for orders (added safely if missing)
	AddColumnIfMissing("orders", "customer_id", "INTEGER DEFAULT 0")
	AddColumnIfMissing("orders", "customer_code", "TEXT DEFAULT ''")
	AddColumnIfMissing("orders", "customer_name", "TEXT DEFAULT ''")
	AddColumnIfMissing("orders", "customer_owner", "TEXT DEFAULT ''")
	AddColumnIfMissing("orders", "customer_address", "TEXT DEFAULT ''")
	AddColumnIfMissing("orders", "item_count", "INTEGER DEFAULT 0")
	AddColumnIfMissing("orders", "booking", "INTEGER DEFAULT 0")
	AddColumnIfMissing("orders", "prepaid", "INTEGER DEFAULT 0")

	' order_items table
	AddColumnIfMissing("order_items", "fulfillment_status", "TEXT DEFAULT ''")
	AddColumnIfMissing("order_items", "payment_status", "TEXT DEFAULT ''")
	AddColumnIfMissing("order_items", "delivery_status", "TEXT DEFAULT ''")
End Sub

Sub AddColumnIfMissing(TableName As String, ColumnName As String, ColumnDef As String)
	If HasColumn(TableName, ColumnName) Then Return

	Try
		Main.SQLProducts.ExecNonQuery("ALTER TABLE " & TableName & " ADD COLUMN " & ColumnName & " " & ColumnDef)
		Log("Added column: " & TableName & "." & ColumnName)
	Catch
		Log("AddColumnIfMissing error on " & TableName & "." & ColumnName & ": " & LastException.Message)
	End Try
End Sub

Sub HasColumn(TableName As String, ColumnName As String) As Boolean
	Dim rs As ResultSet
	Try
		rs = Main.SQLProducts.ExecQuery("PRAGMA table_info(" & TableName & ")")
		Do While rs.NextRow
			If rs.GetString("name").ToLowerCase = ColumnName.ToLowerCase Then
				rs.Close
				Return True
			End If
		Loop
		rs.Close
		Return False
	Catch
		If rs.IsInitialized Then rs.Close
		Log("HasColumn error on " & TableName & "." & ColumnName & ": " & LastException.Message)
		Return False
	End Try
End Sub

' ======================
' BOTTOM NAVIGATION
' ======================

Private Sub ShowPanel(panelToShow As Panel)
	pnlContentDash.Visible = False
	pnlContentOrders.Visible = False
	pnlContentInventory.Visible = False
	pnlContentHistory.Visible = False

	panelToShow.Visible = True

	Dim inactiveColor As Int = Colors.RGB(158, 158, 158)
	lblDashIcon.TextColor = inactiveColor
	lblDash.TextColor = inactiveColor
	lblOrdersIcon.TextColor = inactiveColor
	lblOrders.TextColor = inactiveColor
	lblInventoryIcon.TextColor = inactiveColor
	lblInventory.TextColor = inactiveColor
	lblHistoryIcon.TextColor = inactiveColor
	lblHistory.TextColor = inactiveColor

	Dim activeColor As Int = Colors.RGB(33, 150, 243)
	If panelToShow = pnlContentDash Then
		lblDashIcon.TextColor = activeColor
		lblDash.TextColor = activeColor
	Else If panelToShow = pnlContentOrders Then
		lblOrdersIcon.TextColor = activeColor
		lblOrders.TextColor = activeColor
	Else If panelToShow = pnlContentInventory Then
		lblInventoryIcon.TextColor = activeColor
		lblInventory.TextColor = activeColor
	Else If panelToShow = pnlContentHistory Then
		lblHistoryIcon.TextColor = activeColor
		lblHistory.TextColor = activeColor
	End If
End Sub

Private Sub pnlDash_Click
	ShowPanel(pnlContentDash)
	UpdateDashboardStatusLabels
End Sub

Private Sub pnlOrders_Click
	ShowPanel(pnlContentOrders)
	bttnAddOrder.Visible = True
	bttnAddOrder.BringToFront
End Sub

Private Sub pnlInventory_Click
	ShowPanel(pnlContentInventory)
	LoadInventoryItemsIntoScrollView
End Sub

Private Sub pnlHistory_Click
	ShowPanel(pnlContentHistory)
End Sub

Private Sub lbllogout_Click
	Main.LoggedInUser = ""
	Main.LoggedInUserID = 0
	Main.LoggedInUserFullName = ""
	Main.LoggedInGroupID = 0
	Main.VENDOR_ID = 0
	Main.LoggedInRequiresVendorSelection = False
	Main.AssignedVendors.Initialize

	StartActivity(Main)
	Activity.Finish
End Sub

Private Sub pnlDim_Click
End Sub

' ======================
' ORDERS TAB
' ======================

Private Sub LoadOrdersIntoList
	clvContentOrders.Clear

	Dim searchText As String = etContentSearchOrder.Text.Trim.ToLowerCase ' new
	Dim rs As ResultSet

	If searchText = "" Then ' new
		rs = Main.SQLProducts.ExecQuery2( _
	        "SELECT * FROM orders " & _
	        "WHERE vendor_id = ? AND user_id = ? " & _
	        "ORDER BY order_id DESC", _
	        Array As String(Main.VENDOR_ID, Main.LoggedInUserID))
	Else
		Dim likeValue As String = "%" & searchText & "%" ' new

		rs = Main.SQLProducts.ExecQuery2( _
	        "SELECT * FROM orders " & _
	        "WHERE vendor_id = ? AND user_id = ? " & _
	        "AND LOWER('order #' || CAST(order_id AS TEXT)) LIKE ? " & _
	        "ORDER BY order_id DESC", _
	        Array As String(Main.VENDOR_ID, Main.LoggedInUserID, likeValue))
	End If

	If rs.RowCount = 0 Then ' new
		Dim pnlEmpty As Panel ' new
		pnlEmpty.Initialize("") ' new
		pnlEmpty.Color = Colors.Transparent ' new
		pnlEmpty.SetLayout(0, 0, clvContentOrders.AsView.Width, 70dip) ' new

		Dim lblEmpty As Label ' new
		lblEmpty.Initialize("") ' new
		lblEmpty.Text = "No matching order found" ' new
		lblEmpty.TextColor = Colors.Gray ' new
		lblEmpty.TextSize = 14 ' new
		lblEmpty.Gravity = Gravity.CENTER ' new

		pnlEmpty.AddView(lblEmpty, 0, 15dip, clvContentOrders.AsView.Width, 30dip) ' new
		clvContentOrders.Add(pnlEmpty, 0) ' new

		rs.Close ' new
		Return ' new
	End If

	Do While rs.NextRow
		Dim pnl As Panel
		pnl.Initialize("")
		pnl.SetLayout(0, 0, clvContentOrders.AsView.Width, 80dip)
		pnl.Color = Colors.White ' new

		Dim lblOrderID As Label
		lblOrderID.Initialize("")
		lblOrderID.Text = "Order #" & rs.GetInt("order_id")
		lblOrderID.TextSize = 16
		lblOrderID.Typeface = Typeface.DEFAULT_BOLD ' new
		lblOrderID.SetLayout(10dip, 5dip, 60%x, 25dip) ' new

		Dim lblTotal As Label
		lblTotal.Initialize("")
		lblTotal.Text = "Total: ₱" & NumberFormat2(rs.GetDouble("total_amount"), 1, 2, 2, False) ' new
		lblTotal.SetLayout(10dip, 30dip, 50%x, 25dip)

		Dim lblSync As Label ' new
		lblSync.Initialize("") ' new
		lblSync.Text = rs.GetString("sync_status") ' new
		lblSync.TextColor = Colors.Gray ' new
		lblSync.Gravity = Gravity.RIGHT ' new
		lblSync.SetLayout(60%x, 30dip, 35%x, 25dip) ' new

		pnl.AddView(lblOrderID, lblOrderID.Left, lblOrderID.Top, lblOrderID.Width, lblOrderID.Height)
		pnl.AddView(lblTotal, lblTotal.Left, lblTotal.Top, lblTotal.Width, lblTotal.Height)
		pnl.AddView(lblSync, lblSync.Left, lblSync.Top, lblSync.Width, lblSync.Height) ' new

		clvContentOrders.Add(pnl, rs.GetInt("order_id"))
	Loop
	rs.Close
End Sub


Private Sub clvContentOrders_ItemClick(Index As Int, Value As Object)
	Dim orderID As Int = Value
	ShowOrderDetails(orderID)
End Sub

Private Sub clvContentOrders_ItemLongClick(Index As Int, Value As Object)
End Sub

Private Sub ShowOrderDetails(orderID As Int)
	Try
		Dim cursorOrder As Cursor = Main.SQLProducts.ExecQuery2( _
	            "SELECT order_id, transaction_number, date_created, total_amount, status, sync_status, customer_id, customer_name, customer_owner, customer_address " & _
	            "FROM orders WHERE order_id = ?", _
	            Array As String(orderID))

		If cursorOrder.RowCount = 0 Then
			ToastMessageShow("Order not found", False)
			cursorOrder.Close
			Return
		End If

		cursorOrder.Position = 0

		Dim transactionNumber As String = ""
		Try
			transactionNumber = cursorOrder.GetString("transaction_number")
			If transactionNumber = Null Then transactionNumber = ""
		Catch
			transactionNumber = ""
		End Try

		Dim orderDate As Long = 0
		Try
			orderDate = cursorOrder.GetLong("date_created")
		Catch
			orderDate = 0
		End Try
		Dim totalAmount As Double = 0
		Try
			totalAmount = cursorOrder.GetDouble("total_amount")
		Catch
			totalAmount = 0
		End Try
		Dim orderStatus As String = ""
		Try
			orderStatus = cursorOrder.GetString("status")
			If orderStatus = Null Then orderStatus = ""
		Catch
			orderStatus = ""
		End Try
		orderStatus = GetOrderDisplayStatus(orderID, orderStatus)

		' Try to read customer fields if present (EnsureLocalSchema adds them)
		Dim customerName As String = ""
		Dim customerOwner As String = ""
		Dim customerAddress As String = ""
		Try
			If HasColumn("orders", "customer_name") Then
				customerName = cursorOrder.GetString("customer_name")
				If customerName = Null Then customerName = ""
				customerOwner = cursorOrder.GetString("customer_owner")
				If customerOwner = Null Then customerOwner = ""
				customerAddress = cursorOrder.GetString("customer_address")
				If customerAddress = Null Then customerAddress = ""
			End If
		Catch
			customerName = ""
			customerOwner = ""
			customerAddress = ""
		End Try

		cursorOrder.Close

		Dim cursorItems As Cursor = Main.SQLProducts.ExecQuery2( _
            "SELECT oi.product_id, oi.quantity, oi.price, oi.fulfillment_status, i.item_name " & _
            "FROM order_items oi " & _
            "LEFT JOIN items i ON oi.product_id = i.item_id " & _
            "WHERE oi.order_id = ?", _
            Array As String(orderID))

		Dim itemsText As String = ""

		If cursorItems.RowCount = 0 Then
			itemsText = "(No item lines found)"
		Else
			For i = 0 To cursorItems.RowCount - 1
				cursorItems.Position = i

				Dim itemName As String = cursorItems.GetString("item_name")
				If itemName = Null Or itemName = "" Then
					itemName = "Item #" & cursorItems.GetInt("product_id")
				End If

				Dim quantity As Int = cursorItems.GetInt("quantity")
				Dim price As Double = cursorItems.GetDouble("price")

				itemsText = itemsText & _
                    "• " & itemName & " x" & quantity & " (@₱" & NumberFormat2(price, 1, 2, 2, False) & ")" & CRLF & _
					""
			Next
		End If

		cursorItems.Close

		Dim message As String = _
			"Transaction: " & transactionNumber & CRLF & _
			(IIf(customerName <> "", "Customer: " & customerName & CRLF, "")) & _
			(IIf(customerOwner <> "", "Owner: " & customerOwner & CRLF, "")) & _
			(IIf(customerAddress <> "", "Address: " & customerAddress & CRLF, "")) & _
			"Date: " & DateTime.Date(orderDate) & CRLF & _
			"Status: " & orderStatus & CRLF & _
			"Total: ₱" & NumberFormat2(totalAmount, 1, 2, 2, False) & CRLF & CRLF & _
			"Items:" & CRLF & itemsText

		Msgbox2Async(message, "Order #" & orderID, "OK", "", "", Null, False)
		Wait For Msgbox_Result (Result As Int)

	Catch
		Log("ShowOrderDetails error: " & LastException.Message)
		ToastMessageShow("Could not load order details. Please try again.", True)
	End Try
End Sub

Private Sub bttnAddOrder_Click
	' Open customer selection first so chosen customer is attached to the order
	StartActivity(CustomerSelection)
End Sub

' ======================
' DASHBOARD TAB - FETCH PRODUCTS
' ======================

Private Sub bttnFetchProducts_Click
	If Main.VENDOR_ID <= 0 Then
		ShowFetchErrorMessage("No vendor assigned to current login")
		ToastMessageShow("Please log in again.", True)
		Return
	End If

	SetFetchButtonBusyState(True)
	lblFetchStatus.Text = "Connecting to server..."
	lblFetchStatus.TextColor = Colors.Blue
	' Create a local HttpJob and track it in currentFetchJob so we can release on pause
	Dim fetchJob As HttpJob
	fetchJob.Initialize("FetchProducts", Me)
	currentFetchJob = fetchJob

	Dim fetchUrl As String = Main.API_URL & "get_items.php?vendor_id=" & Main.VENDOR_ID
	fetchJob.Download(fetchUrl)

	Wait For (fetchJob) JobDone(jobFetch As HttpJob)

	If jobFetch.Success Then
		Dim response As String = jobFetch.GetString
		If response = "" Or response = Null Then
			ShowFetchErrorMessage("Server returned empty response")
		Else
			ParseAndSaveProductsFromServerResponse(response)
		End If
	Else
		ShowFetchErrorMessage("Cannot connect. Check WiFi and server.")
		ToastMessageShow("Network error. Using cached data.", True)
	End If

	' After items are fetched, attempt to fetch & cache customers for offline use
	Dim custJob As HttpJob
	custJob.Initialize("FetchCustomers", Me)
	currentCustomerJob = custJob
	Dim custUrl As String = Main.API_URL & "search_customers.php?limit=1000"
	custJob.Download(custUrl)

	Wait For (custJob) JobDone(jobCust As HttpJob)
	If jobCust.Success Then
		Dim custResp As String = jobCust.GetString
		If custResp <> "" And custResp <> Null Then
			ParseAndSaveCustomersFromServerResponse(custResp)
		End If
	Else
		Log("Customer fetch failed: " & jobCust.ErrorMessage)
	End If
	jobCust.Release
	currentCustomerJob = Null

	SetFetchButtonBusyState(False)
	jobFetch.Release
	currentFetchJob = Null
End Sub

Private Sub SetFetchButtonBusyState(isBusy As Boolean)
	If isBusy Then
		bttnFetchProducts.Enabled = False
		bttnFetchProducts.Color = Colors.LightGray
	Else
		bttnFetchProducts.Enabled = True
		bttnFetchProducts.Color = Colors.Blue
	End If
End Sub

Private Sub ParseAndSaveProductsFromServerResponse(response As String)
	Try
		Dim parser As JSONParser
		parser.Initialize(response)
		Dim root As Map = parser.NextObject

		If root.Get("status") <> "success" Then
			ShowFetchErrorMessage("Server returned an error")
			Return
		End If

		Dim items As List = root.Get("data")
		DeleteOldCacheAndSaveFreshProducts(items)

		Main.ITEMS_LAST_SYNC = DateTime.Now
		lblFetchStatus.Text = "✓ Sync completed successfully!"
		lblFetchStatus.TextColor = Colors.RGB(0, 150, 0)
		UpdateDashboardStatusLabels
		ToastMessageShow("Synced " & items.Size & " products", False)

	Catch
		ShowFetchErrorMessage("Failed to read server response: " & LastException.Message)
	End Try
End Sub

Private Sub DeleteOldCacheAndSaveFreshProducts(items As List)
	Dim currentVendor As Int = Main.VENDOR_ID
	If currentVendor <= 0 Then
		Log("Skip cache save: invalid vendor")
		Return
	End If

	' Use a transaction for bulk writes to avoid per-insert commits (much faster and avoids UI blocking)
	Try
		Main.SQLProducts.ExecNonQuery("BEGIN TRANSACTION")
		Main.SQLProducts.ExecNonQuery2("DELETE FROM items WHERE vendor_id = ?", Array As Object(currentVendor))

		For i = 0 To items.Size - 1
			Dim item As Map = items.Get(i)

			Dim barcode As String = ""
			If item.ContainsKey("barcode") And item.Get("barcode") <> Null Then
				barcode = item.Get("barcode")
			End If

			Dim vendorID As Int = currentVendor
			If item.ContainsKey("vendor_id") And item.Get("vendor_id") <> Null Then
				vendorID = item.Get("vendor_id")
			End If

			Main.SQLProducts.ExecNonQuery2( _
				"INSERT OR REPLACE INTO items (item_id, item_code, item_name, unit_price, barcode, vendor_id, is_active) VALUES (?, ?, ?, ?, ?, ?, ?)", _
				Array As Object(item.Get("item_id"), item.Get("item_code"), item.Get("item_name"), item.Get("unit_price"), barcode, vendorID, 1))
		Next

		Main.SQLProducts.ExecNonQuery("COMMIT")
	Catch
		Try
			Main.SQLProducts.ExecNonQuery("ROLLBACK")
		Catch
			Log(LastException.Message)
		End Try
		Log("DeleteOldCacheAndSaveFreshProducts error: " & LastException.Message)
	End Try
End Sub


Private Sub ParseAndSaveCustomersFromServerResponse(response As String)
	Try
		Dim parser As JSONParser
		parser.Initialize(response)
		Dim root As Map = parser.NextObject

		If root.Get("status") <> "success" Then
			Log("Customer fetch returned no success status")
			Return
		End If

		Dim customers As List = root.Get("data")
		If customers.IsInitialized = False Then Return

		' Replace local customer cache using a transaction for bulk writes
		Try
			Main.SQLProducts.ExecNonQuery("BEGIN TRANSACTION")
			Main.SQLProducts.ExecNonQuery("DELETE FROM mst_customers")

			For i = 0 To customers.Size - 1
				Dim c As Map = customers.Get(i)
				Dim cid As Int = 0
				If c.ContainsKey("customer_id") Then cid = c.Get("customer_id")
				Dim code As String = ""
				If c.ContainsKey("customer_code") Then code = c.Get("customer_code")
				Dim name As String = ""
				If c.ContainsKey("customer_name") Then name = c.Get("customer_name")
				Dim owner As String = ""
				If c.ContainsKey("business_owner") Then owner = c.Get("business_owner")
				Dim addr As String = ""
				If c.ContainsKey("address") Then addr = c.Get("address")
				Dim cat As String = ""
				If c.ContainsKey("category") Then cat = c.Get("category")
				Dim branchId As Int = 0
				If c.ContainsKey("branch_id") Then branchId = c.Get("branch_id")

				Main.SQLProducts.ExecNonQuery2( _
					"INSERT OR REPLACE INTO mst_customers (customer_id, customer_code, customer_name, business_owner, address, is_active, branch_id, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", _
					Array As Object(cid, code, name, owner, addr, 1, branchId, cat))
			Next

			Main.SQLProducts.ExecNonQuery("COMMIT")
			Log("Cached " & customers.Size & " customers locally")
		Catch
			Try
				Main.SQLProducts.ExecNonQuery("ROLLBACK")
			Catch
				Log(LastException.Message)
			End Try
			Log("ParseAndSaveCustomersFromServerResponse error while saving: " & LastException.Message)
		End Try
	Catch
		Log("ParseAndSaveCustomersFromServerResponse error: " & LastException.Message)
	End Try
End Sub

Private Sub bttnSyncOrdersNow_Click
	SyncNextPendingOrder
End Sub

Private Sub SyncNextPendingOrder
	If Main.SQLProducts.IsInitialized = False Then
		ToastMessageShow("Local database is not ready.", True)
		Return
	End If

	If syncOrdersCompletedCount < 0 Then syncOrdersCompletedCount = 0

	Dim rsOrder As ResultSet = Main.SQLProducts.ExecQuery("SELECT * FROM orders WHERE IFNULL(sync_status, '') <> 'Synced' ORDER BY date_created ASC LIMIT 1")
	If rsOrder.RowCount = 0 Then
		rsOrder.Close
		If syncOrdersCompletedCount > 0 Then
			ToastMessageShow("Successfully synced.", False)
		Else
			ToastMessageShow("No pending orders to sync.", False)
		End If
		syncOrdersCompletedCount = 0
		LoadOrdersIntoList
		UpdateDashboardStatusLabels
		Return
	End If

	rsOrder.Position = 0
	Dim localOrderID As Int = rsOrder.GetInt("order_id")
	Dim payload As String = BuildOrderSyncPayload(rsOrder)
	rsOrder.Close

	Dim syncJob As HttpJob
	syncJob.Initialize("SyncOrder", Me)
	currentSyncJob = syncJob
	syncJob.PostString(Main.API_URL & "sync_order.php", payload)

	Wait For (syncJob) JobDone(jobSync As HttpJob)
	If jobSync.Success Then
		Try
			Dim parser As JSONParser
			parser.Initialize(jobSync.GetString)
			Dim root As Map = parser.NextObject
			Dim status As String = root.Get("status")
			If status = "success" Then
				Main.SQLProducts.ExecNonQuery2("UPDATE orders SET sync_status = 'Synced', synced_at = ? WHERE order_id = ?", Array As Object(DateTime.Now, localOrderID))
				syncOrdersCompletedCount = syncOrdersCompletedCount + 1
				LoadOrdersIntoList
				UpdateDashboardStatusLabels
				jobSync.Release
				currentSyncJob = Null
				SyncNextPendingOrder
				Return
			Else
				syncOrdersCompletedCount = 0
				ToastMessageShow("Sync failed: " & root.Get("message"), True)
			End If
		Catch
			syncOrdersCompletedCount = 0
			ToastMessageShow("Sync response parse failed: " & LastException.Message, True)
		End Try
	Else
		syncOrdersCompletedCount = 0
		ToastMessageShow("Sync network error: " & jobSync.ErrorMessage, True)
	End If

	jobSync.Release
	currentSyncJob = Null
End Sub

Private Sub BuildOrderSyncPayload(rsOrder As ResultSet) As String
	Dim localOrderID As Int = rsOrder.GetInt("order_id")
	Dim createdAt As Long = DateTime.Now
	Try
		createdAt = rsOrder.GetLong("date_created")
	Catch
		createdAt = DateTime.Now
	End Try
	If createdAt <= 0 Then createdAt = DateTime.Now

	Dim itemCount As Int = 0
	If HasColumn("orders", "item_count") Then itemCount = rsOrder.GetInt("item_count")
	If itemCount <= 0 Then itemCount = GetLocalOrderItemCount(localOrderID)

	Dim bookingValue As Int = 0
	If HasColumn("orders", "booking") Then bookingValue = rsOrder.GetInt("booking")

	Dim prepaidValue As Int = 0
	If HasColumn("orders", "prepaid") Then prepaidValue = rsOrder.GetInt("prepaid")

	Dim customerCode As String = "0"
	If HasColumn("orders", "customer_code") Then customerCode = rsOrder.GetString("customer_code")
	If customerCode = Null Or customerCode.Trim = "" Then customerCode = "0"

	Dim orderHeader As Map
	orderHeader.Initialize
	orderHeader.Put("vendor_id", rsOrder.GetInt("vendor_id"))
	orderHeader.Put("user_id", rsOrder.GetInt("user_id"))
	orderHeader.Put("convention_id", GetOrderConventionID(rsOrder))
	orderHeader.Put("order_date", FormatSqlDate(createdAt))
	orderHeader.Put("order_dt", FormatSqlDateTime(createdAt))
	orderHeader.Put("item_count", itemCount)
	orderHeader.Put("total_amount", rsOrder.GetDouble("total_amount"))
	orderHeader.Put("booking", bookingValue)
	orderHeader.Put("customer_code", customerCode)
	orderHeader.Put("status", "O")
	orderHeader.Put("transaction_number", rsOrder.GetString("transaction_number"))
	orderHeader.Put("device_id", rsOrder.GetString("device_id"))
	orderHeader.Put("prepaid", prepaidValue)

	Dim details As List
	details.Initialize

	Dim rsItems As ResultSet = Main.SQLProducts.ExecQuery2( _
		"SELECT oi.product_id, oi.quantity, oi.price " & _
		"FROM order_items oi " & _
		"WHERE oi.order_id = ? ORDER BY oi.order_item_id", _
		Array As String(localOrderID))

	Do While rsItems.NextRow
		Dim itemMap As Map
		itemMap.Initialize
		Dim quantity As Int = rsItems.GetInt("quantity")
		Dim unitPrice As Double = rsItems.GetDouble("price")

		itemMap.Put("item_id", rsItems.GetInt("product_id"))
		itemMap.Put("quantity", quantity)
		itemMap.Put("unit_price", unitPrice)
		details.Add(itemMap)
	Loop
	rsItems.Close

	Dim root As Map
	root.Initialize
	root.Put("order_header", orderHeader)
	root.Put("order_details", details)

	Dim gen As JSONGenerator
	gen.Initialize(root)
	Return gen.ToString
End Sub

Private Sub FormatSqlDate(ticks As Long) As String
	Dim oldDateFormat As String = DateTime.DateFormat
	DateTime.DateFormat = "yyyy-MM-dd"
	Dim value As String = DateTime.Date(ticks)
	DateTime.DateFormat = oldDateFormat
	Return value
End Sub

Private Sub FormatSqlDateTime(ticks As Long) As String
	Dim oldDateFormat As String = DateTime.DateFormat
	Dim oldTimeFormat As String = DateTime.TimeFormat
	DateTime.DateFormat = "yyyy-MM-dd"
	DateTime.TimeFormat = "HH:mm:ss"
	Dim value As String = DateTime.Date(ticks) & " " & DateTime.Time(ticks)
	DateTime.DateFormat = oldDateFormat
	DateTime.TimeFormat = oldTimeFormat
	Return value
End Sub

Private Sub GetLocalOrderItemCount(orderId As Int) As Int
	Dim totalQuantity As Int = 0
	Dim rs As ResultSet = Main.SQLProducts.ExecQuery2("SELECT IFNULL(SUM(quantity), 0) AS total_qty FROM order_items WHERE order_id = ?", Array As String(orderId))
	If rs.NextRow Then
		totalQuantity = rs.GetInt("total_qty")
	End If
	rs.Close
	Return totalQuantity
End Sub

Private Sub GetOrderConventionID(rsOrder As ResultSet) As Int
	If HasColumn("orders", "convention_id") Then
		Dim conventionId As Int = rsOrder.GetInt("convention_id")
		If conventionId > 0 Then Return conventionId
	End If
	Return Main.LoggedInConventionID
End Sub

Private Sub ShowFetchErrorMessage(errorMessage As String)
	lblFetchStatus.Text = "✗ " & errorMessage
	lblFetchStatus.TextColor = Colors.Red
End Sub

Private Sub GetOrderDisplayStatus(orderID As Int, fallbackStatus As String) As String
	If fallbackStatus <> "" And fallbackStatus <> "Pending" Then
		Return fallbackStatus
	End If

	Try
		Dim rs As ResultSet = Main.SQLProducts.ExecQuery2( _
			"SELECT fulfillment_status FROM order_items WHERE order_id = ? LIMIT 1", _
			Array As String(orderID))
		If rs.NextRow Then
			Dim fulfillmentStatus As String = rs.GetString("fulfillment_status")
			If fulfillmentStatus <> Null And fulfillmentStatus <> "" Then
				rs.Close
				Return fulfillmentStatus
			End If
		End If
		rs.Close
	Catch
		Log("GetOrderDisplayStatus error: " & LastException.Message)
	End Try

	Return fallbackStatus
End Sub

' ======================
' INVENTORY TAB
' ======================

Private Sub LoadInventoryItemsIntoScrollView
	svInventory.Panel.RemoveAllViews
	Dim top As Int = 0

	Dim rs As ResultSet = Main.SQLProducts.ExecQuery2( _
        "SELECT * FROM items WHERE is_active = 1 AND vendor_id = ? ORDER BY item_name", _
        Array As String(Main.VENDOR_ID))

	If rs.RowCount = 0 Then
		ShowEmptyInventoryMessage
		rs.Close
		Return
	End If

	Do While rs.NextRow
		Dim pnl As Panel
		pnl.Initialize("")
		pnl.Color = Colors.White

		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = rs.GetString("item_name")
		lblName.TextSize = 16
		lblName.TextColor = Colors.Black

		Dim lblPrice As Label
		lblPrice.Initialize("")
		lblPrice.Text = "₱" & rs.GetDouble("unit_price")
		lblPrice.TextSize = 14
		lblPrice.TextColor = Colors.RGB(0, 120, 0)

		Dim lblCode As Label
		lblCode.Initialize("")
		lblCode.Text = "Code: " & rs.GetString("item_code")
		lblCode.TextSize = 12
		lblCode.TextColor = Colors.Gray

		pnl.AddView(lblName, 10dip, 5dip, svInventory.Width - 20dip, 25dip)
		pnl.AddView(lblPrice, 10dip, 30dip, svInventory.Width - 20dip, 20dip)
		pnl.AddView(lblCode, 10dip, 50dip, svInventory.Width - 20dip, 15dip)

		svInventory.Panel.AddView(pnl, 0, top, svInventory.Width, 75dip)
		top = top + 80dip
	Loop
	rs.Close

	svInventory.Panel.Height = top
End Sub

Private Sub ShowEmptyInventoryMessage
	Dim lblEmpty As Label
	lblEmpty.Initialize("")
	lblEmpty.Text = "No products cached. Go to Dashboard and sync first."
	lblEmpty.TextSize = 14
	lblEmpty.TextColor = Colors.Gray
	lblEmpty.Gravity = Gravity.CENTER
	svInventory.Panel.AddView(lblEmpty, 0, 20dip, svInventory.Width, 40dip)
End Sub

' ======================
' DASHBOARD TAB - STATUS
' ======================

Private Sub UpdateDashboardStatusLabels
	EnsureLocalSchema

	Dim cachedProductCount As Int = 0
	Dim rs As ResultSet
	Try
		rs = Main.SQLProducts.ExecQuery2( _
            "SELECT COUNT(*) as count FROM items WHERE is_active = 1 AND vendor_id = ?", _
            Array As String(Main.VENDOR_ID))
		If rs.NextRow Then
			cachedProductCount = rs.GetInt("count")
		End If
		rs.Close
	Catch
		If rs.IsInitialized Then rs.Close
		cachedProductCount = 0
	End Try

	If cachedProductCount > 0 Then
		If Main.ITEMS_LAST_SYNC > 0 Then
			lblCacheInfo.Text = "📦 " & cachedProductCount & " products cached | Last sync: " & FormatTimeAgo(Main.ITEMS_LAST_SYNC)
			lblCacheInfo.TextColor = Colors.RGB(0, 100, 0)
			lblFetchStatus.Text = "✓ Ready to take orders"
			lblFetchStatus.TextColor = Colors.RGB(0, 150, 0)
		Else
			lblCacheInfo.Text = "📦 " & cachedProductCount & " products cached (sync time unknown)"
			lblCacheInfo.TextColor = Colors.Gray
		End If
	Else
		lblCacheInfo.Text = "⚠ No products synced yet"
		lblCacheInfo.TextColor = Colors.RGB(200, 100, 0)
		lblFetchStatus.Text = "Tap button above to sync products"
		lblFetchStatus.TextColor = Colors.Gray
	End If

	' pending order count is shown in history summary labels (no toast)
	' Refresh history summary labels as well
	UpdateHistorySummary
End Sub

Private Sub FormatTimeAgo(syncTimestamp As Long) As String
	Dim minutesAgo As Long = (DateTime.Now - syncTimestamp) / DateTime.TicksPerMinute

	If minutesAgo < 1 Then
		Return "Just now"
	Else If minutesAgo < 60 Then
		Return minutesAgo & " minutes ago"
	Else If minutesAgo < 1440 Then
		Return (minutesAgo / 60) & " hours ago"
	Else
		Return (minutesAgo / 1440) & " days ago"
	End If
End Sub


Private Sub UpdateHistorySummary
	Dim todayStart As Long = DateTime.DateParse(DateTime.Date(DateTime.Now))
	Dim todayEnd As Long = todayStart + DateTime.TicksPerDay

	Dim rs As ResultSet

	rs = Main.SQLProducts.ExecQuery2( _
			"SELECT COUNT(*) AS total_orders, IFNULL(SUM(total_amount), 0) AS total_sales " & _
			"FROM orders " & _
			"WHERE vendor_id = ? AND user_id = ? AND date_created >= ? AND date_created < ?", _
			Array As String(Main.VENDOR_ID, Main.LoggedInUserID, todayStart, todayEnd))

	If rs.NextRow Then
		lblTodaysOrders.Text = "Today's Orders: " & rs.GetInt("total_orders")
		lblTodaySales.Text = "Today's Sales: ₱" & NumberFormat2(rs.GetDouble("total_sales"), 1, 2, 2, False)
	End If
	rs.Close

	rs = Main.SQLProducts.ExecQuery( _
			"SELECT COUNT(*) AS pending_count " & _
			"FROM orders " & _
			"WHERE IFNULL(sync_status, '') <> 'Synced'")

	If rs.NextRow Then
		lblPendingSync.Text = "Pending Sync: " & rs.GetInt("pending_count")
	End If
	rs.Close
End Sub

'search bar
Private Sub etContentSearchOrder_TextChanged (Old As String, New As String)
	LoadOrdersIntoList
End Sub


