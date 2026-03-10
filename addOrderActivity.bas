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
	Private CartItems As List
	Private bttnAddOrderActivity As Button
	Private bttnPurchaseNow As Button
	Private clvProducts As CustomListView
	Private etSearchProducts As EditText
	Private lblExitOrderActivity As Label
	Private lblExitSelectItems As Label
	Private lblTotalItems As Label
	Private lblTotalAmount As Label
	Private pnladdOrderActivityTop As Panel
	Private pnladdOrderActivityWhole As Panel
	Private pnlDim As Panel
	Private pnlSelectItems As Panel
	Private svCartSummary As ScrollView
	Private pnlQuantity As Panel
	Private lblQuantityTitle As Label
	Private bttnCancelQty As Button
	Private lblSelectedItem As Label
	Private bttnMinus As Button
	Private lblQuantityValue As Label
	Private bttnAdd As Button
	Private bttnAddToCartQty As Button
	Private SelectedItemID As Int
	Private SelectedItemName As String
	Private SelectedItemPrice As Double
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("addOrderActivity")

	CartItems.Initialize

	bttnPurchaseNow.Enabled = False
	bttnPurchaseNow.Color = Colors.ARGB(80, 0, 0, 255)

	LoadProducts
End Sub

Sub Activity_Resume
End Sub

Sub Activity_Pause(UserClosed As Boolean)
End Sub

' ------------------
' BUTTONS & POPUPS
' ------------------
Private Sub bttnAddOrderActivity_Click
	pnlDim.Visible = True
	pnlSelectItems.Visible = True
	pnlDim.BringToFront
	pnlSelectItems.BringToFront
End Sub

Private Sub lblExitSelectItems_Click
	pnlDim.Visible = False
	pnlSelectItems.Visible = False
End Sub

Private Sub lblExitOrderActivity_Click
	Activity.Finish
End Sub

Private Sub bttnPurchaseNow_Click
	If CartItems.Size = 0 Then
		ToastMessageShow("Add items first", True)
		Return
	End If

	SaveOrderLocally
	CartItems.Clear
	RefreshCartSummary
	bttnPurchaseNow.Color = Colors.ARGB(80, 200, 200, 200)
	bttnPurchaseNow.Enabled = False

	ToastMessageShow("Order added successfully", False)
	Activity.Finish
End Sub

Private Sub pnlDim_Click
End Sub

' ------------------
' PRODUCTS
' ------------------



Private Sub clvProducts_ItemClick(Index As Int, Value As Object)
	Dim itemID As Int = Value
    
	' Get item details from cache
	Dim rs As ResultSet = Main.SQLProducts.ExecQuery2("SELECT * FROM items WHERE item_id=?", Array As String(itemID))
    
	If rs.NextRow Then
		' Store selected item info
		SelectedItemID = itemID
		SelectedItemName = rs.GetString("item_name")
		SelectedItemPrice = rs.GetDouble("unit_price")
        
		' Show item info in quantity selector
		lblSelectedItem.Text = SelectedItemName & Chr(10) & "₱" & SelectedItemPrice
		lblQuantityValue.Text = "1"  ' Reset to 1
        
		' Show quantity panel
		pnlQuantity.Visible = True
		pnlQuantity.BringToFront
		pnlDim.Visible = True
		pnlDim.BringToFront
		pnlQuantity.BringToFront  ' Make sure it's on top
	End If
	rs.Close
End Sub

' Decrease quantity
Private Sub bttnMinus_Click
	Dim currentQty As Int = lblQuantityValue.Text
	If currentQty > 1 Then
		lblQuantityValue.Text = (currentQty - 1)
	Else
		ToastMessageShow("Minimum quantity is 1", False)
	End If
End Sub

' Increase quantity (YOUR BUTTON IS CALLED bttnAdd)
Private Sub bttnAdd_Click
	Dim currentQty As Int = lblQuantityValue.Text
	If currentQty < 999 Then
		lblQuantityValue.Text = (currentQty + 1)
	Else
		ToastMessageShow("Maximum quantity is 999", False)
	End If
End Sub

' Add to cart with selected quantity
Private Sub bttnAddToCartQty_Click
	Dim quantity As Int = lblQuantityValue.Text
    
	' Add item multiple times based on quantity
	For i = 1 To quantity
		CartItems.Add(SelectedItemID)
	Next
    
	RefreshCartSummary
	bttnPurchaseNow.Enabled = True
	bttnPurchaseNow.Color = Colors.Blue
    
	ToastMessageShow("Added " & quantity & "x " & SelectedItemName, False)
    
	' Hide panels
	pnlQuantity.Visible = False
	pnlDim.Visible = False
	pnlSelectItems.Visible = False
End Sub

' Cancel quantity selection
Private Sub bttnCancelQty_Click
	pnlQuantity.Visible = False
	' Keep product list visible
	pnlDim.Visible = False
End Sub

Private Sub RefreshCartSummary
	svCartSummary.Panel.RemoveAllViews
	Dim top As Int = 0
	Dim totalAmount As Double = 0
    
	' Count quantities per item
	Dim itemQuantities As Map
	itemQuantities.Initialize
    
	For Each itemID As Int In CartItems
		If itemQuantities.ContainsKey(itemID) Then
			Dim count As Int = itemQuantities.Get(itemID)
			itemQuantities.Put(itemID, count + 1)
		Else
			itemQuantities.Put(itemID, 1)
		End If
	Next
    
	' Display grouped items with quantities
	For Each itemID As Int In itemQuantities.Keys
		Dim quantity As Int = itemQuantities.Get(itemID)
        
		Dim rs As ResultSet = Main.SQLProducts.ExecQuery2("SELECT * FROM items WHERE item_id=?", Array As String(itemID))
		If rs.NextRow Then
			Dim pnl As Panel
			pnl.Initialize("")
			pnl.Color = Colors.White
			pnl.SetLayout(0, top, svCartSummary.Width, 65dip)

			Dim lblName As Label
			lblName.Initialize("")
			lblName.Text = rs.GetString("item_name")
			lblName.TextSize = 16
			lblName.TextColor = Colors.Black
			lblName.SetLayout(10dip, 5dip, 60%x, 25dip)
            
			Dim lblQty As Label
			lblQty.Initialize("")
			lblQty.Text = "x" & quantity
			lblQty.TextSize = 14
			lblQty.TextColor = Colors.Gray
			lblQty.SetLayout(10dip, 30dip, 30%x, 20dip)

			Dim lblPrice As Label
			lblPrice.Initialize("")
			Dim itemPrice As Double = rs.GetDouble("unit_price")
			Dim lineTotal As Double = itemPrice * quantity
			lblPrice.Text = "₱" & lineTotal
			lblPrice.TextSize = 16
			lblPrice.TextColor = Colors.RGB(0, 120, 0)
			lblPrice.Gravity = Gravity.RIGHT
			lblPrice.SetLayout(65%x, 5dip, 30%x, 25dip)

			pnl.AddView(lblName, lblName.Left, lblName.Top, lblName.Width, lblName.Height)
			pnl.AddView(lblQty, lblQty.Left, lblQty.Top, lblQty.Width, lblQty.Height)
			pnl.AddView(lblPrice, lblPrice.Left, lblPrice.Top, lblPrice.Width, lblPrice.Height)

			svCartSummary.Panel.AddView(pnl, 0, top, pnl.Width, pnl.Height)
			top = top + pnl.Height + 3dip
			totalAmount = totalAmount + lineTotal
		End If
		rs.Close
	Next

	svCartSummary.Panel.Height = top
	lblTotalItems.Text = "Items: " & itemQuantities.Size & " types (" & CartItems.Size & " total)"
	lblTotalAmount.Text = "Total: ₱" & NumberFormat2(totalAmount, 1, 2, 2, False)
End Sub

Private Sub SaveOrderLocally
	Dim total As Double = 0
	For Each productID As Int In CartItems
		Dim rs As ResultSet = Main.SQLProducts.ExecQuery2("SELECT * FROM items WHERE item_id=?", Array As String(productID))
		If rs.NextRow Then total = total + rs.GetDouble("unit_price")
		rs.Close
	Next

	' Insert order
	Main.SQLProducts.ExecNonQuery2("INSERT INTO orders (vendor_id, date_created, status, total_amount) VALUES (?, ?, ?, ?)", _
        Array As String(1, DateTime.Now, "Pending", total))

	' Get last order id
	Dim rsOrder As ResultSet = Main.SQLProducts.ExecQuery("SELECT last_insert_rowid() AS id")
	rsOrder.NextRow
	Dim orderID As Int = rsOrder.GetInt("id")
	rsOrder.Close

	' Insert items
	For Each productID As Int In CartItems
		Dim rs As ResultSet = Main.SQLProducts.ExecQuery2("SELECT * FROM items WHERE item_id=?", Array As String(productID))
		If rs.NextRow Then
			Dim price As Double = rs.GetDouble("unit_price")
			Main.SQLProducts.ExecNonQuery2("INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)", _
                Array As String(orderID, productID, 1, price))
		End If
		rs.Close
	Next
End Sub

Private Sub etSearchProducts_TextChanged (Old As String, New As String)
	LoadProducts  ' Reload with filter
End Sub

Private Sub LoadProducts
	clvProducts.Clear
    
	Dim searchText As String = etSearchProducts.Text.Trim.ToLowerCase
    
	Dim query As String
	If searchText = "" Then
		' Show all products
		query = "SELECT * FROM items WHERE is_active = 1 ORDER BY item_name"
	Else
		' Filter by search term
		query = "SELECT * FROM items WHERE is_active = 1 AND (LOWER(item_name) LIKE '%" & searchText & "%' OR LOWER(item_code) LIKE '%" & searchText & "%') ORDER BY item_name"
	End If
    
	Dim rs As ResultSet = Main.SQLProducts.ExecQuery(query)
    
	If rs.RowCount = 0 Then
		ToastMessageShow("No products found matching '" & searchText & "'", False)
		rs.Close
		Return
	End If
    
	Do While rs.NextRow
		Dim pnl As Panel
		pnl.Initialize("")
		pnl.SetLayout(0, 0, clvProducts.AsView.Width, 70dip)

		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = rs.GetString("item_name")
		lblName.TextSize = 16
		lblName.SetLayout(10dip, 5dip, 70%x, 25dip)

		Dim lblPrice As Label
		lblPrice.Initialize("")
		lblPrice.Text = "₱" & rs.GetDouble("unit_price")
		lblPrice.SetLayout(10dip, 30dip, 70%x, 20dip)

		Dim lblSku As Label
		lblSku.Initialize("")
		lblSku.Text = "SKU: " & rs.GetString("item_code")
		lblSku.TextSize = 12
		lblSku.SetLayout(10dip, 50dip, 70%x, 15dip)

		pnl.AddView(lblName, lblName.Left, lblName.Top, lblName.Width, lblName.Height)
		pnl.AddView(lblPrice, lblPrice.Left, lblPrice.Top, lblPrice.Width, lblPrice.Height)
		pnl.AddView(lblSku, lblSku.Left, lblSku.Top, lblSku.Width, lblSku.Height)

		clvProducts.Add(pnl, rs.GetInt("item_id"))
	Loop
	rs.Close
End Sub