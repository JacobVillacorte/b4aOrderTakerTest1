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
	Private bttnAddOrder As Button
	Private lblDash As Label, lblDashIcon As Label
	Private lblHistory As Label, lblHistoryIcon As Label
	Private lblInventory As Label, lblInventoryIcon As Label
	Private lblLoggedInUser As Label
	Private lbllogout As Label
	Private lblOrders As Label, lblOrdersIcon As Label
	Private lblperson As Label
	Private pnlBottomNav As Panel
	Private pnlContent As Panel
	Private pnlContentDash As Panel
	Private pnlContentHistory As Panel
	Private pnlContentInventory As Panel
	Private pnlContentOrders As Panel
	Private pnlDash As Panel
	Private pnlDim As Panel
	Private pnlHistory As Panel
	Private pnlInventory As Panel
	Private pnlOrders As Panel
	Private pnlTop As Panel
	Private etContentSearchOrder As EditText
	Private clvContentOrders As CustomListView
	Private lblFetchStatus As Label
	Private bttnFetchProducts As Button
	Private svInventory As ScrollView
	Private lblCacheInfo As Label
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("OrderTakerDashboard")
	lblLoggedInUser.Text = "Welcome, " & Main.LoggedInUser

	' Ensure orders tables exist
	Main.SQLProducts.ExecNonQuery("CREATE TABLE IF NOT EXISTS orders (order_id INTEGER PRIMARY KEY AUTOINCREMENT, vendor_id INTEGER, date_created TEXT, status TEXT, total_amount REAL)")
	Main.SQLProducts.ExecNonQuery("CREATE TABLE IF NOT EXISTS order_items (order_item_id INTEGER PRIMARY KEY AUTOINCREMENT, order_id INTEGER, product_id INTEGER, quantity INTEGER, price REAL)")

	ShowPanel(pnlContentDash)
	UpdateDashboardStatus
End Sub

Sub Activity_Resume
	LoadOrders
End Sub

Sub Activity_Pause(UserClosed As Boolean)
End Sub

' ------------------
' PANEL LOGIC
' ------------------
Private Sub ShowPanel(panelToShow As Panel)
	pnlContentDash.Visible = False
	pnlContentOrders.Visible = False
	pnlContentInventory.Visible = False
	pnlContentHistory.Visible = False

	panelToShow.Visible = True
End Sub

Private Sub pnlDash_Click
	ShowPanel(pnlContentDash)
	UpdateDashboardStatus
End Sub

Private Sub pnlOrders_Click
	ShowPanel(pnlContentOrders)
	bttnAddOrder.Visible = True
	bttnAddOrder.BringToFront
End Sub

Private Sub pnlInventory_Click
	ShowPanel(pnlContentInventory)
	LoadInventoryItems
End Sub

Private Sub pnlHistory_Click
	ShowPanel(pnlContentHistory)
End Sub

Private Sub lbllogout_Click
	Main.LoggedInUser = ""
	StartActivity(Main)
	Activity.Finish
End Sub

' ------------------
' ORDERS
' ------------------
Private Sub LoadOrders
	clvContentOrders.Clear
	Dim rsOrders As ResultSet = Main.SQLProducts.ExecQuery("SELECT * FROM orders ORDER BY order_id DESC")
	Do While rsOrders.NextRow
		Dim pnl As Panel
		pnl.Initialize("")
		pnl.SetLayout(0, 0, clvContentOrders.AsView.Width, 80dip)

		Dim lblOrderID As Label
		lblOrderID.Initialize("")
		lblOrderID.Text = "Order #" & rsOrders.GetInt("order_id")
		lblOrderID.TextSize = 16
		lblOrderID.SetLayout(10dip, 5dip, 50%x, 25dip)

		Dim lblTotal As Label
		lblTotal.Initialize("")
		lblTotal.Text = "Total: ₱" & rsOrders.GetDouble("total_amount")
		lblTotal.SetLayout(10dip, 30dip, 50%x, 25dip)

		pnl.AddView(lblOrderID, lblOrderID.Left, lblOrderID.Top, lblOrderID.Width, lblOrderID.Height)
		pnl.AddView(lblTotal, lblTotal.Left, lblTotal.Top, lblTotal.Width, lblTotal.Height)

		clvContentOrders.Add(pnl, rsOrders.GetInt("order_id"))
	Loop
	rsOrders.Close
End Sub

Private Sub clvContentOrders_ItemClick(Index As Int, Value As Object)
	Dim orderID As Int = Value
	ToastMessageShow("Order #" & orderID & " clicked", False)
End Sub

Private Sub clvContentOrders_ItemLongClick(Index As Int, Value As Object)
End Sub

Private Sub bttnAddOrder_Click
	StartActivity(addOrderActivity)
End Sub

Private Sub pnlDim_Click
End Sub

' ------------------
' FETCH PRODUCTS FROM API
' ------------------	
' ------------------
' FETCH PRODUCTS FROM API
' ------------------
Private Sub bttnFetchProducts_Click
	' Disable button during fetch
	bttnFetchProducts.Enabled = False
	bttnFetchProducts.Color = Colors.LightGray
	lblFetchStatus.Text = "Connecting to server..."
	lblFetchStatus.TextColor = Colors.Blue
    
	Dim j As HttpJob
	j.Initialize("", Me)
	j.Download(Main.API_URL)
	Wait For (j) JobDone(j As HttpJob)
    
	If j.Success Then
		Try
			Dim response As String = j.GetString
            
			If response = "" Or response = Null Then
				lblFetchStatus.Text = "ERROR: Empty response"
				lblFetchStatus.TextColor = Colors.Red
				bttnFetchProducts.Enabled = True
				bttnFetchProducts.Color = Colors.Blue
				j.Release
				Return
			End If
            
			Dim parser As JSONParser
			parser.Initialize(response)
			Dim root As Map = parser.NextObject
            
			Dim statusValue As String = root.Get("status")
            
			If statusValue = "success" Then
				' Clear old cache
				Main.SQLProducts.ExecNonQuery("DELETE FROM items")
                
				' Parse and save items
				Dim items As List = root.Get("data")
                
				For i = 0 To items.Size - 1
					Dim item As Map = items.Get(i)
                    
					Dim itemID As Int = item.Get("item_id")
					Dim itemCode As String = item.Get("item_code")
					Dim itemName As String = item.Get("item_name")
					Dim unitPrice As Double = item.Get("unit_price")
                    
					Dim barcode As String = ""
					If item.ContainsKey("barcode") And item.Get("barcode") <> Null Then
						barcode = item.Get("barcode")
					End If
                    
					Dim vendorID As Int = 0
					If item.ContainsKey("vendor_id") And item.Get("vendor_id") <> Null Then
						vendorID = item.Get("vendor_id")
					End If
                    
					Dim isActive As Int = 1
                    
					Main.SQLProducts.ExecNonQuery2("INSERT INTO items VALUES (?, ?, ?, ?, ?, ?, ?)", _
                        Array As Object(itemID, itemCode, itemName, unitPrice, barcode, vendorID, isActive))
				Next
                
				' Save sync timestamp
				Main.ITEMS_LAST_SYNC = DateTime.Now
                
				' Update UI
				lblFetchStatus.Text = "✓ Sync completed successfully!"
				lblFetchStatus.TextColor = Colors.RGB(0, 150, 0)
                
				UpdateDashboardStatus
                
				ToastMessageShow("Synced " & items.Size & " products", False)
			Else
				lblFetchStatus.Text = "ERROR: Server returned error"
				lblFetchStatus.TextColor = Colors.Red
			End If
		Catch
			lblFetchStatus.Text = "ERROR: " & LastException.Message
			lblFetchStatus.TextColor = Colors.Red
		End Try
	Else
		lblFetchStatus.Text = "✗ Cannot connect. Check WiFi and server."
		lblFetchStatus.TextColor = Colors.Red
		ToastMessageShow("Network error. Using cached data.", True)
	End If
    
	' Re-enable button
	bttnFetchProducts.Enabled = True
	bttnFetchProducts.Color = Colors.Blue
	j.Release
End Sub


Private Sub LoadInventoryItems
	svInventory.Panel.RemoveAllViews
	Dim top As Int = 0
    
	Dim rs As ResultSet = Main.SQLProducts.ExecQuery("SELECT * FROM items WHERE is_active = 1 ORDER BY item_name")
    
	If rs.RowCount = 0 Then
		' Show message if no products
		Dim lblEmpty As Label
		lblEmpty.Initialize("")
		lblEmpty.Text = "No products cached. Go to Dashboard and sync first."
		lblEmpty.TextSize = 14
		lblEmpty.TextColor = Colors.Gray
		lblEmpty.Gravity = Gravity.CENTER
		svInventory.Panel.AddView(lblEmpty, 0, 20dip, svInventory.Width, 40dip)
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
		lblPrice.TextColor = Colors.RGB(0, 120, 0)  ' Green
        
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

' ------------------
' DASHBOARD STATUS
' ------------------
' ------------------
' DASHBOARD STATUS
' ------------------
Private Sub UpdateDashboardStatus
	' Check cached items
	Dim rs As ResultSet = Main.SQLProducts.ExecQuery("SELECT COUNT(*) as count FROM items WHERE is_active = 1")
	rs.NextRow
	Dim itemCount As Int = rs.GetInt("count")
	rs.Close
    
	If itemCount > 0 Then
		' Show cache info
		If Main.ITEMS_LAST_SYNC > 0 Then
			' Calculate time ago
			Dim minutesAgo As Long = (DateTime.Now - Main.ITEMS_LAST_SYNC) / DateTime.TicksPerMinute
			Dim timeAgo As String
            
			If minutesAgo < 1 Then
				timeAgo = "Just now"
			Else If minutesAgo < 60 Then
				timeAgo = minutesAgo & " minutes ago"
			Else If minutesAgo < 1440 Then  ' Less than 24 hours
				Dim hoursAgo As Int = minutesAgo / 60
				timeAgo = hoursAgo & " hours ago"
			Else
				Dim daysAgo As Int = minutesAgo / 1440
				timeAgo = daysAgo & " days ago"
			End If
            
			lblCacheInfo.Text = "📦 " & itemCount & " products cached | Last sync: " & timeAgo
			lblCacheInfo.TextColor = Colors.RGB(0, 100, 0)  ' Dark green
			lblFetchStatus.Text = "✓ Ready to take orders"
			lblFetchStatus.TextColor = Colors.RGB(0, 150, 0)
		Else
			lblCacheInfo.Text = "📦 " & itemCount & " products cached (sync time unknown)"
			lblCacheInfo.TextColor = Colors.Gray
		End If
	Else
		lblCacheInfo.Text = "⚠ No products synced yet"
		lblCacheInfo.TextColor = Colors.RGB(200, 100, 0)  ' Orange
		lblFetchStatus.Text = "Tap button above to sync products"
		lblFetchStatus.TextColor = Colors.Gray
	End If
    
	' Update pending orders count
	Dim rsOrders As ResultSet = Main.SQLProducts.ExecQuery("SELECT COUNT(*) as count FROM orders WHERE status = 'Pending'")
	rsOrders.NextRow
	Dim pendingCount As Int = rsOrders.GetInt("count")
	rsOrders.Close
    
	If pendingCount > 0 Then
		ToastMessageShow("You have " & pendingCount & " pending orders to sync", False)
	End If
End Sub
