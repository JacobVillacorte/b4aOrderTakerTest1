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
	' Cart - holds cart item maps with product info and quantity
	Private CartItems As List

	' Stores info about the item the user is currently selecting a quantity for
	Private SelectedItemID As Int
	Private SelectedItemName As String
	Private SelectedItemPrice As Double

	' Main cart screen
	Private pnladdOrderActivityTop As Panel
	Private pnladdOrderActivityWhole As Panel
	Private pnlDim As Panel
	Private svCartSummary As ScrollView
	Private lblTotalItems As Label
	Private lblTotalAmount As Label
	Private bttnPurchaseNow As Button
	Private lblExitOrderActivity As Label
	Private bttnAddOrderActivity As Button

	' Product selection popup
	Private pnlSelectItems As Panel
	Private clvProducts As CustomListView
	Private etSearchProducts As EditText
	Private lblExitSelectItems As Label	

	' Quantity selector popup
	Private pnlQuantity As Panel
	Private lblQuantityTitle As Label
	Private lblSelectedItem As Label
	Private etQuantityValue As EditText
	Private bttnMinus As Button
	Private bttnAdd As Button
	Private bttnAddToCartQty As Button
	Private bttnCancelQty As Button

	' Purchase status popup
	Private pnlPurchaseStatus As Panel
	Private lblPurchaseStatusTitle As Label
	Private lblPurchaseStatusMessage As Label
	Private rbPaidReceived As RadioButton
	Private rbPaidBooked As RadioButton
	Private rbNotPaidBooked As RadioButton
	Private bttnConfirmPurchaseStatus As Button
	Private bttnCancelPurchaseStatus As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("addOrderActivity")

	If Main.VENDOR_ID <= 0 Or Main.LoggedInUserID <= 0 Then
		ToastMessageShow("Session is invalid. Please login again.", True)
		Activity.Finish
		Return
	End If

	CartItems.Initialize

	bttnPurchaseNow.Enabled = False
	bttnPurchaseNow.Color = Colors.ARGB(80, 0, 0, 255)

	pnlPurchaseStatus.Visible = False
	rbPaidReceived.Checked = True
	rbPaidBooked.Checked = False
	rbNotPaidBooked.Checked = False

	LoadProductsIntoList
End Sub

Sub Activity_Resume
End Sub

Sub Activity_Pause(UserClosed As Boolean)
End Sub

' ======================
' TRANSACTION NUMBER
' ======================

' Creates a unique transaction number for this vendor
' Format: V1-001, V1-002, V2-001 (vendor ID + sequence)
' Each vendor has their own sequence so there are NO collisions between devices
Sub GenerateTransactionNumber As String
	Try
		Dim safeDeviceID As String = Main.DEVICE_ID
		If safeDeviceID = Null Or safeDeviceID = "" Then safeDeviceID = "UNKNOWNDEVICE"

		Dim cursor As Cursor = Main.SQLProducts.ExecQuery2( _
            "SELECT transaction_number FROM orders WHERE device_id = ? ORDER BY order_id DESC LIMIT 1", _
            Array As String(safeDeviceID))

		Dim nextSequence As Int = 1

		If cursor.RowCount > 0 Then
			cursor.Position = 0
			Dim lastTransaction As String = cursor.GetString("transaction_number")
			If lastTransaction <> Null And lastTransaction.Contains("-") Then
				Dim parts() As String = Regex.Split("-", lastTransaction)
				If parts.Length >= 2 Then
					nextSequence = parts(parts.Length - 1) + 1
				End If
			End If
		End If
		cursor.Close

		Return safeDeviceID & "-" & NumberFormat(nextSequence, 3, 0)

	Catch
		Log("GenerateTransactionNumber error: " & LastException.Message)
		Return Main.DEVICE_ID & "-ERR"
	End Try
End Sub

' ======================
' MAIN CART SCREEN
' ======================

' Opens the product selection popup
Private Sub bttnAddOrderActivity_Click
	pnlDim.Visible = True
	pnlSelectItems.Visible = True
	pnlDim.BringToFront
	pnlSelectItems.BringToFront
End Sub

' Closes the product selection popup
Private Sub lblExitSelectItems_Click
	pnlDim.Visible = False
	pnlSelectItems.Visible = False
End Sub

' Goes back to the dashboard without saving
Private Sub lblExitOrderActivity_Click
	Activity.Finish
End Sub

' Saves the order and returns to dashboard
Private Sub bttnPurchaseNow_Click
	If CartItems.Size = 0 Then
		ToastMessageShow("Add items first", True)
		Return
	End If

	ShowPurchaseStatusPopup
End Sub

Private Sub ShowPurchaseStatusPopup
	rbPaidReceived.Checked = True
	rbPaidBooked.Checked = False
	rbNotPaidBooked.Checked = False

	pnlDim.Visible = True
	pnlDim.BringToFront
	pnlPurchaseStatus.Visible = True
	pnlPurchaseStatus.BringToFront
End Sub

Private Sub HidePurchaseStatusPopup
	pnlPurchaseStatus.Visible = False
	pnlDim.Visible = False
End Sub

Private Sub GetSelectedFulfillmentStatus As String
	If rbPaidReceived.Checked Then
		Return "Paid-Received"
	Else If rbPaidBooked.Checked Then
		Return "Paid-Booked"
	Else If rbNotPaidBooked.Checked Then
		Return "NotPaid-Booked"
	Else
		Return ""
	End If
End Sub

Private Sub bttnConfirmPurchaseStatus_Click
	Dim fulfillmentStatus As String = GetSelectedFulfillmentStatus

	If fulfillmentStatus = "" Then
		ToastMessageShow("Please select a fulfillment status", True)
		Return
	End If

	SaveOrderToLocalDatabase(fulfillmentStatus)
	HidePurchaseStatusPopup
	ClearCartAndResetUI
	ToastMessageShow("Order added successfully!", False)
	Activity.Finish
End Sub

Private Sub bttnCancelPurchaseStatus_Click
	HidePurchaseStatusPopup
End Sub

Private Sub rbPaidReceived_CheckedChange(Checked As Boolean)
	If Checked = False Then Return
	rbPaidBooked.Checked = False
	rbNotPaidBooked.Checked = False
End Sub

Private Sub rbPaidBooked_CheckedChange(Checked As Boolean)
	If Checked = False Then Return
	rbPaidReceived.Checked = False
	rbNotPaidBooked.Checked = False
End Sub
Private Sub rbNotPaidBooked_CheckedChange(Checked As Boolean)
	If Checked = False Then Return
	rbPaidReceived.Checked = False
	rbPaidBooked.Checked = False
End Sub

' Clears the cart list and resets the Purchase button back to disabled
Private Sub ClearCartAndResetUI
	CartItems.Clear
	RefreshCartDisplay

	bttnPurchaseNow.Color = Colors.ARGB(80, 200, 200, 200)
	bttnPurchaseNow.Enabled = False

	rbPaidReceived.Checked = True
	rbPaidBooked.Checked = False
	rbNotPaidBooked.Checked = False
End Sub

Private Sub pnlDim_Click
End Sub

' ======================
' PRODUCT SELECTION POPUP
' ======================

' Triggered when user types in the search box - reloads the list with filter
Private Sub etSearchProducts_TextChanged(Old As String, New As String)
	LoadProductsIntoList
End Sub

' Loads active products into the product list, filtered by the search box if needed
Private Sub LoadProductsIntoList
	clvProducts.Clear

	If Main.VENDOR_ID <= 0 Then
		ToastMessageShow("No vendor assigned. Please login again.", True)
		Return
	End If

	Dim searchText As String = etSearchProducts.Text.Trim.ToLowerCase
	Dim rs As ResultSet
	Dim vendorIDText As String = Main.VENDOR_ID

	If searchText = "" Then
		rs = Main.SQLProducts.ExecQuery2( _
            "SELECT * FROM items WHERE is_active = 1 AND vendor_id = ? ORDER BY item_name", _
            Array As String(vendorIDText))
	Else
		Dim likeValue As String = "%" & searchText & "%"
		rs = Main.SQLProducts.ExecQuery2( _
            "SELECT * FROM items WHERE is_active = 1 AND vendor_id = ? AND (LOWER(item_name) LIKE ? OR LOWER(item_code) LIKE ?) ORDER BY item_name", _
            Array As String(vendorIDText, likeValue, likeValue))
	End If

	If rs.RowCount = 0 Then
		ToastMessageShow("No products found for your vendor.", False)
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

' Triggered when user taps a product - opens the quantity selector popup
Private Sub clvProducts_ItemClick(Index As Int, Value As Object)
	Dim itemID As Int = Value

	Dim rs As ResultSet = Main.SQLProducts.ExecQuery2("SELECT * FROM items WHERE item_id=?", Array As String(itemID))

	If rs.NextRow Then
		' Remember which item was selected
		SelectedItemID = itemID
		SelectedItemName = rs.GetString("item_name")
		SelectedItemPrice = rs.GetDouble("unit_price")

		' Show item info and reset quantity to 1
		lblSelectedItem.Text = SelectedItemName & Chr(10) & "₱" & SelectedItemPrice
		etQuantityValue.Text = "1"

		' Open quantity popup on top of the dim overlay
		pnlDim.Visible = True
		pnlDim.BringToFront
		pnlQuantity.Visible = True
		pnlQuantity.BringToFront
	End If
	rs.Close
End Sub

' ======================
' QUANTITY SELECTOR POPUP
' ======================

' Decreases quantity by 1 (minimum is 1)
Private Sub bttnMinus_Click
	Dim currentQty As Int = etQuantityValue.Text
	If currentQty > 1 Then
		etQuantityValue.Text = (currentQty - 1)
	Else
		ToastMessageShow("Minimum quantity is 1", False)
	End If
End Sub

' Increases quantity by 1 (maximum is 999)
Private Sub bttnAdd_Click
	Dim currentQty As Int = etQuantityValue.Text
	If currentQty < 999 Then
		etQuantityValue.Text = (currentQty + 1)
	Else
		ToastMessageShow("Maximum quantity is 999", False)
	End If
End Sub

' Adds the selected item to the cart with the chosen quantity
Private Sub bttnAddToCartQty_Click
	If IsNumber(etQuantityValue.Text) = False Then
		ToastMessageShow("Please enter a valid number", True)
		etQuantityValue.Text = "1"
		Return
	End If

	Dim quantity As Int = etQuantityValue.Text

	If quantity < 1 Then
		ToastMessageShow("Minimum quantity is 1", True)
		etQuantityValue.Text = "1"
		Return
	End If

	If quantity > 999 Then
		ToastMessageShow("Maximum quantity is 999", True)
		etQuantityValue.Text = "999"
		Return
	End If

	AddCartItemToList(SelectedItemID, SelectedItemName, SelectedItemPrice, quantity)

	RefreshCartDisplay
	bttnPurchaseNow.Enabled = True
	bttnPurchaseNow.Color = Colors.Blue

	ToastMessageShow("Added " & quantity & "x " & SelectedItemName, False)

	pnlQuantity.Visible = False
	pnlDim.Visible = False
	pnlSelectItems.Visible = False
End Sub

' Closes the quantity selector without adding to cart
Private Sub bttnCancelQty_Click
	pnlQuantity.Visible = False
	pnlDim.Visible = False
End Sub

' ======================
' CART DISPLAY
' ======================

' Rebuilds the cart summary showing all items, quantities, statuses, and the running total
Private Sub RefreshCartDisplay
	svCartSummary.Panel.RemoveAllViews
	Dim top As Int = 0
	Dim totalAmount As Double = 0
	Dim totalQuantity As Int = 0

	For Each cartItem As Map In CartItems
		Dim itemName As String = cartItem.Get("item_name")
		Dim unitPrice As Double = cartItem.Get("unit_price")
		Dim quantity As Int = cartItem.Get("quantity")
		Dim lineTotal As Double = unitPrice * quantity

		Dim pnl As Panel
		pnl.Initialize("")
		pnl.Color = Colors.White
		pnl.SetLayout(0, top, svCartSummary.Width, 70dip)

		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = itemName
		lblName.TextSize = 16
		lblName.TextColor = Colors.Black
		lblName.SetLayout(10dip, 5dip, 60%x, 25dip)

		Dim lblQty As Label
		lblQty.Initialize("")
		lblQty.Text = "Qty: " & quantity
		lblQty.TextSize = 14
		lblQty.TextColor = Colors.Gray
		lblQty.SetLayout(10dip, 32dip, 30%x, 20dip)

		Dim lblLineTotal As Label
		lblLineTotal.Initialize("")
		lblLineTotal.Text = "₱" & NumberFormat2(lineTotal, 1, 2, 2, False)
		lblLineTotal.TextSize = 16
		lblLineTotal.TextColor = Colors.RGB(0, 120, 0)
		lblLineTotal.Gravity = Gravity.RIGHT
		lblLineTotal.SetLayout(65%x, 10dip, 30%x, 25dip)

		pnl.AddView(lblName, lblName.Left, lblName.Top, lblName.Width, lblName.Height)
		pnl.AddView(lblQty, lblQty.Left, lblQty.Top, lblQty.Width, lblQty.Height)
		pnl.AddView(lblLineTotal, lblLineTotal.Left, lblLineTotal.Top, lblLineTotal.Width, lblLineTotal.Height)

		svCartSummary.Panel.AddView(pnl, 0, top, pnl.Width, pnl.Height)
		top = top + pnl.Height + 3dip

		totalAmount = totalAmount + lineTotal
		totalQuantity = totalQuantity + quantity
	Next

	svCartSummary.Panel.Height = top
	lblTotalItems.Text = "Items: " & CartItems.Size & " entries (" & totalQuantity & " total)"
	lblTotalAmount.Text = "Total: ₱" & NumberFormat2(totalAmount, 1, 2, 2, False)
End Sub

' ======================
' SAVE ORDER
' ======================

' Saves the current cart as a new order in the local database
Private Sub SaveOrderToLocalDatabase(FulfillmentStatus As String)
	Try
		If Main.VENDOR_ID <= 0 Or Main.LoggedInUserID <= 0 Then
			ToastMessageShow("Missing user/vendor session. Please login again.", True)
			Return
		End If

		Dim transactionNumber As String = GenerateTransactionNumber
		Dim total As Double = 0

		For Each cartItem As Map In CartItems
			Dim unitPrice As Double = cartItem.Get("unit_price")
			Dim quantity As Int = cartItem.Get("quantity")
			total = total + (unitPrice * quantity)
		Next

		Main.SQLProducts.ExecNonQuery2( _
            "INSERT INTO orders (vendor_id, user_id, transaction_number, device_id, date_created, status, total_amount, sync_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", _
            Array As Object(Main.VENDOR_ID, Main.LoggedInUserID, transactionNumber, Main.DEVICE_ID, DateTime.Now, "Pending", total, "Holding"))

		Dim rsNewOrder As ResultSet = Main.SQLProducts.ExecQuery("SELECT last_insert_rowid() AS id")
		rsNewOrder.NextRow
		Dim newOrderID As Int = rsNewOrder.GetInt("id")
		rsNewOrder.Close

		For Each cartItem As Map In CartItems
			Dim productID As Int = cartItem.Get("product_id")
			Dim unitPrice As Double = cartItem.Get("unit_price")
			Dim quantity As Int = cartItem.Get("quantity")
			Dim paymentStatus As String = GetPaymentStatusFromFulfillmentStatus(FulfillmentStatus)
			Dim deliveryStatus As String = GetDeliveryStatusFromFulfillmentStatus(FulfillmentStatus)

			Main.SQLProducts.ExecNonQuery2( _
                "INSERT INTO order_items (order_id, product_id, quantity, price, fulfillment_status, payment_status, delivery_status) VALUES (?, ?, ?, ?, ?, ?, ?)", _
                Array As Object(newOrderID, productID, quantity, unitPrice, FulfillmentStatus, paymentStatus, deliveryStatus))
		Next

		Log("Order saved with transaction: " & transactionNumber)

	Catch
		Log("SaveOrderToLocalDatabase error: " & LastException.Message)
		ToastMessageShow("Failed to save order. Please try again.", True)
	End Try
End Sub



' Converts fulfillment status to payment status
Private Sub GetPaymentStatusFromFulfillmentStatus(FulfillmentStatus As String) As String
	If FulfillmentStatus = "Paid-Received" Or FulfillmentStatus = "Paid-Booked" Then
		Return "Paid"
	Else
		Return "NotPaid"
	End If
End Sub

' Converts fulfillment status to delivery status
Private Sub GetDeliveryStatusFromFulfillmentStatus(FulfillmentStatus As String) As String
	If FulfillmentStatus = "Paid-Received" Then
		Return "Received"
	Else
		Return "NotReceived"
	End If
End Sub

' Adds one cart entry with quantity and fulfillment status
Private Sub AddCartItemToList(ProductID As Int, ItemName As String, UnitPrice As Double, Quantity As Int)
	For Each cartItem As Map In CartItems
		Dim existingProductID As Int = cartItem.Get("product_id")
		If existingProductID = ProductID Then
			Dim existingQuantity As Int = cartItem.Get("quantity")
			cartItem.Put("quantity", existingQuantity + Quantity)
			Return
		End If
	Next

	Dim cartItem As Map
	cartItem.Initialize
	cartItem.Put("product_id", ProductID)
	cartItem.Put("item_name", ItemName)
	cartItem.Put("unit_price", UnitPrice)
	cartItem.Put("quantity", Quantity)
	CartItems.Add(cartItem)
End Sub
