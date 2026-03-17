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
End Sub

' Creates orders/order_items tables if they don't exist
' Also safely adds multi-vendor columns (safe to run multiple times)
Private Sub SetupOrdersDatabaseTables
	Main.SQLProducts.ExecNonQuery("CREATE TABLE IF NOT EXISTS orders (" & _
        "order_id INTEGER PRIMARY KEY AUTOINCREMENT, " & _
        "vendor_id INTEGER, user_id INTEGER, date_created TEXT, status TEXT, total_amount REAL)")
	Main.SQLProducts.ExecNonQuery("CREATE TABLE IF NOT EXISTS order_items (" & _
        "order_item_id INTEGER PRIMARY KEY AUTOINCREMENT, " & _
        "order_id INTEGER, product_id INTEGER, quantity INTEGER, price REAL)")

	Try
		Main.SQLProducts.ExecNonQuery("ALTER TABLE orders ADD COLUMN user_id INTEGER DEFAULT 0")
		Main.SQLProducts.ExecNonQuery("ALTER TABLE orders ADD COLUMN transaction_number TEXT")
		Main.SQLProducts.ExecNonQuery("ALTER TABLE orders ADD COLUMN device_id TEXT")
		Main.SQLProducts.ExecNonQuery("ALTER TABLE orders ADD COLUMN sync_status TEXT DEFAULT 'Holding'")
		Main.SQLProducts.ExecNonQuery("ALTER TABLE orders ADD COLUMN synced_at INTEGER DEFAULT 0")

		Main.SQLProducts.ExecNonQuery("ALTER TABLE order_items ADD COLUMN fulfillment_status TEXT DEFAULT 'Paid-Received'")
		Main.SQLProducts.ExecNonQuery("ALTER TABLE order_items ADD COLUMN payment_status TEXT DEFAULT 'Paid'")
		Main.SQLProducts.ExecNonQuery("ALTER TABLE order_items ADD COLUMN delivery_status TEXT DEFAULT 'Received'")
		Log("Database schema ready for multi-vendor + user tracking")
	Catch
		Log("Database columns already exist (OK): " & LastException.Message)
	End Try
End Sub

' ======================
' BOTTOM NAVIGATION
' ======================

' Hides all panels and shows only the selected one, then highlights its tab
Private Sub ShowPanel(panelToShow As Panel)
	' Hide all content panels first
	pnlContentDash.Visible = False
	pnlContentOrders.Visible = False
	pnlContentInventory.Visible = False
	pnlContentHistory.Visible = False

	panelToShow.Visible = True

	' Reset all nav tabs to gray (inactive)
	Dim inactiveColor As Int = Colors.RGB(158, 158, 158)
	lblDashIcon.TextColor = inactiveColor
	lblDash.TextColor = inactiveColor
	lblOrdersIcon.TextColor = inactiveColor
	lblOrders.TextColor = inactiveColor
	lblInventoryIcon.TextColor = inactiveColor
	lblInventory.TextColor = inactiveColor
	lblHistoryIcon.TextColor = inactiveColor
	lblHistory.TextColor = inactiveColor

	' Highlight the active tab in blue
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

' Loads all orders from the local database and displays them in the list
Private Sub LoadOrdersIntoList
	clvContentOrders.Clear

	Dim rs As ResultSet = Main.SQLProducts.ExecQuery2( _
        "SELECT * FROM orders WHERE vendor_id = ? AND user_id = ? ORDER BY order_id DESC", _
        Array As String(Main.VENDOR_ID, Main.LoggedInUserID))

	Do While rs.NextRow
		Dim pnl As Panel
		pnl.Initialize("")
		pnl.SetLayout(0, 0, clvContentOrders.AsView.Width, 80dip)

		Dim lblOrderID As Label
		lblOrderID.Initialize("")
		lblOrderID.Text = "Order #" & rs.GetInt("order_id")
		lblOrderID.TextSize = 16
		lblOrderID.SetLayout(10dip, 5dip, 50%x, 25dip)

		Dim lblTotal As Label
		lblTotal.Initialize("")
		lblTotal.Text = "Total: ₱" & rs.GetDouble("total_amount")
		lblTotal.SetLayout(10dip, 30dip, 50%x, 25dip)

		pnl.AddView(lblOrderID, lblOrderID.Left, lblOrderID.Top, lblOrderID.Width, lblOrderID.Height)
		pnl.AddView(lblTotal, lblTotal.Left, lblTotal.Top, lblTotal.Width, lblTotal.Height)

		clvContentOrders.Add(pnl, rs.GetInt("order_id"))
	Loop
	rs.Close
End Sub

' Triggered when user taps an order in the list
Private Sub clvContentOrders_ItemClick(Index As Int, Value As Object)
	Dim orderID As Int = Value
	ShowOrderDetails(orderID)
End Sub

Private Sub clvContentOrders_ItemLongClick(Index As Int, Value As Object)
End Sub

' Shows a popup dialog with full details of the tapped order
Private Sub ShowOrderDetails(orderID As Int)
	Try
		Dim cursorOrder As Cursor = Main.SQLProducts.ExecQuery2( _
            "SELECT order_id, transaction_number, date_created, total_amount, status, sync_status " & _
            "FROM orders WHERE order_id = ?", _
            Array As String(orderID))

		If cursorOrder.RowCount = 0 Then
			ToastMessageShow("Order not found", False)
			cursorOrder.Close
			Return
		End If

		cursorOrder.Position = 0

		Dim transactionNumber As String = cursorOrder.GetString("transaction_number")
		If transactionNumber = Null Then transactionNumber = ""

		Dim syncStatus As String = cursorOrder.GetString("sync_status")
		If syncStatus = Null Then syncStatus = ""

		Dim orderDate As Long = cursorOrder.GetLong("date_created")
		Dim totalAmount As Double = cursorOrder.GetDouble("total_amount")
		Dim orderStatus As String = cursorOrder.GetString("status")
		cursorOrder.Close

		' LEFT JOIN keeps order lines visible even if item master cache changed.
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

				Dim fulfillmentStatus As String = cursorItems.GetString("fulfillment_status")
				If fulfillmentStatus = Null Then fulfillmentStatus = "Unknown"

				itemsText = itemsText & _
                    "• " & itemName & " x" & quantity & " (@₱" & NumberFormat2(price, 1, 2, 2, False) & ")" & CRLF & _
                    "  Status: " & fulfillmentStatus & CRLF
			Next
		End If

		cursorItems.Close

		Dim message As String = _
            "Transaction: " & transactionNumber & CRLF & _
            "Date: " & DateTime.Date(orderDate) & CRLF & _
            "Status: " & orderStatus & CRLF & _
            "Sync: " & syncStatus & CRLF & _
            "Total: ₱" & NumberFormat2(totalAmount, 1, 2, 2, False) & CRLF & CRLF & _
            "Items:" & CRLF & itemsText

		Msgbox2Async(message, "Order #" & orderID, "OK", "", "", Null, False)
		Wait For Msgbox_Result (Result As Int)

	Catch
		Log("ShowOrderDetails error: " & LastException.Message)
		ToastMessageShow("Could not load order details. Please try again.", True)
	End Try
End Sub

' Navigates to the Add Order screen
Private Sub bttnAddOrder_Click
	StartActivity(addOrderActivity)
End Sub

' ======================
' DASHBOARD TAB - FETCH PRODUCTS
' ======================

' Triggered when user taps Fetch Products
' Downloads fresh product list from server and saves it locally
Private Sub bttnFetchProducts_Click
	If Main.VENDOR_ID <= 0 Then
		ShowFetchErrorMessage("No vendor assigned to current login")
		ToastMessageShow("Please log in again.", True)
		Return
	End If

	SetFetchButtonBusyState(True)
	lblFetchStatus.Text = "Connecting to server..."
	lblFetchStatus.TextColor = Colors.Blue

	Dim j As HttpJob
	j.Initialize("", Me)

	Dim fetchUrl As String = Main.API_URL & "get_items.php?vendor_id=" & Main.VENDOR_ID
	j.Download(fetchUrl)

	Wait For (j) JobDone(j As HttpJob)

	If j.Success Then
		Dim response As String = j.GetString
		If response = "" Or response = Null Then
			ShowFetchErrorMessage("Server returned empty response")
		Else
			ParseAndSaveProductsFromServerResponse(response)
		End If
	Else
		ShowFetchErrorMessage("Cannot connect. Check WiFi and server.")
		ToastMessageShow("Network error. Using cached data.", True)
	End If

	SetFetchButtonBusyState(False)
	j.Release
End Sub

' Disables/enables the fetch button to prevent tapping while loading
Private Sub SetFetchButtonBusyState(isBusy As Boolean)
	If isBusy Then
		bttnFetchProducts.Enabled = False
		bttnFetchProducts.Color = Colors.LightGray
	Else
		bttnFetchProducts.Enabled = True
		bttnFetchProducts.Color = Colors.Blue
	End If
End Sub

' Parses the JSON response from the server and saves all products to local database
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

' Clears the old cached products and inserts the fresh ones from the server
Private Sub DeleteOldCacheAndSaveFreshProducts(items As List)
	Dim currentVendor As Int = Main.VENDOR_ID
	If currentVendor <= 0 Then
		Log("Skip cache save: invalid vendor")
		Return
	End If

	' Replace only current vendor's cache, not all items.
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
End Sub

' Shows a red error message on the dashboard status label
Private Sub ShowFetchErrorMessage(errorMessage As String)
	lblFetchStatus.Text = "✗ " & errorMessage
	lblFetchStatus.TextColor = Colors.Red
End Sub

' ======================
' INVENTORY TAB
' ======================

' Loads all active products into the inventory scroll view
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

' Shows a message when there are no products cached yet
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

' Updates the dashboard labels: product count, last sync time, pending orders
Private Sub UpdateDashboardStatusLabels
	Dim rs As ResultSet = Main.SQLProducts.ExecQuery2( _
        "SELECT COUNT(*) as count FROM items WHERE is_active = 1 AND vendor_id = ?", _
        Array As String(Main.VENDOR_ID))
	rs.NextRow
	Dim cachedProductCount As Int = rs.GetInt("count")
	rs.Close

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

	Dim rsOrders As ResultSet = Main.SQLProducts.ExecQuery2( _
        "SELECT COUNT(*) as count FROM orders WHERE sync_status = 'Holding' AND vendor_id = ? AND user_id = ?", _
        Array As String(Main.VENDOR_ID, Main.LoggedInUserID))
	rsOrders.NextRow
	Dim pendingOrderCount As Int = rsOrders.GetInt("count")
	rsOrders.Close

	If pendingOrderCount > 0 Then
		ToastMessageShow("You have " & pendingOrderCount & " orders waiting to sync", False)
	End If
End Sub

' Converts a timestamp to human-readable text like "5 minutes ago" or "2 hours ago"
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