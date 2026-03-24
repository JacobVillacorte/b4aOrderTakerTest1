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

	' Multi-selection tracking
	Private SelectedItems As List           ' Stores selected items for deletion
	Private SelectedIndices As List         ' Optional, can track indexes if needed for highlighting
	Private SelectionMode As Boolean = False

	' Stores info about the item the user is currently selecting a quantity for
	Private SelectedItemID As Int
	Private SelectedItemName As String
	Private SelectedItemPrice As Double
	
	' Main cart screen
	Private pnladdOrderActivityTop As Panel
	Private pnladdOrderActivityWhole As Panel
	Private pnlDim As Panel
	Private clvCartSummary As CustomListView
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
	
	' Delete selection buttons / popup
	Private btnDeleteSelected As Button
	Private btnNoDelete As Button
	Private btnYesDelete As Button
	Private PnlConfirmDelete As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("addOrderActivity")

	If Main.VENDOR_ID <= 0 Or Main.LoggedInUserID <= 0 Then
		ToastMessageShow("Session is invalid. Please login again.", True)
		Activity.Finish
		Return
	End If

	CartItems.Initialize
	SelectedItems.Initialize
	SelectedIndices.Initialize

	bttnPurchaseNow.Enabled = True
	bttnPurchaseNow.Color = Colors.ARGB(120, 200, 200, 200)

	pnlPurchaseStatus.Visible = False
	rbPaidReceived.Checked = True
	rbPaidBooked.Checked = False
	rbNotPaidBooked.Checked = False
	btnDeleteSelected.Enabled = True
	btnDeleteSelected.Color = Colors.ARGB(80, 200, 200, 200)
	PnlConfirmDelete.Visible = False

	LoadProductsIntoList
End Sub

Sub Activity_Resume
End Sub

Sub Activity_Pause(UserClosed As Boolean)
End Sub

' ======================
' TRANSACTION NUMBER
' ======================

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

	' Make sure dim panel is visible and on top
	pnlDim.Visible = True
	pnlDim.BringToFront

	' Show the purchase status popup
	pnlPurchaseStatus.Visible = True
	pnlPurchaseStatus.BringToFront

	' Reset radio buttons
	rbPaidReceived.Checked = True
	rbPaidBooked.Checked = False
	rbNotPaidBooked.Checked = False
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

Private Sub ClearCartAndResetUI
	CartItems.Clear
	RefreshCartDisplay

	bttnPurchaseNow.Color = Colors.ARGB(80, 200, 200, 200)
	bttnPurchaseNow.Enabled = False

	rbPaidReceived.Checked = True
	rbPaidBooked.Checked = False
	rbNotPaidBooked.Checked = False
	ExitSelectionMode
End Sub

Private Sub pnlDim_Click
End Sub

' ======================
' PRODUCT SELECTION POPUP
' ======================

Private Sub etSearchProducts_TextChanged(Old As String, New As String)
	LoadProductsIntoList
End Sub

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

Private Sub clvProducts_ItemClick(Index As Int, Value As Object)
	Dim itemID As Int = Value

	Dim rs As ResultSet = Main.SQLProducts.ExecQuery2("SELECT * FROM items WHERE item_id=?", Array As String(itemID))

	If rs.NextRow Then
		SelectedItemID = itemID
		SelectedItemName = rs.GetString("item_name")
		SelectedItemPrice = rs.GetDouble("unit_price")

		lblSelectedItem.Text = SelectedItemName & Chr(10) & "₱" & SelectedItemPrice
		etQuantityValue.Text = "1"

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

Private Sub bttnMinus_Click
	Dim currentQty As Int = etQuantityValue.Text
	If currentQty > 1 Then
		etQuantityValue.Text = (currentQty - 1)
	Else
		ToastMessageShow("Minimum quantity is 1", False)
	End If
End Sub

Private Sub bttnAdd_Click
	Dim currentQty As Int = etQuantityValue.Text
	If currentQty < 999 Then
		etQuantityValue.Text = (currentQty + 1)
	Else
		ToastMessageShow("Maximum quantity is 999", False)
	End If
End Sub

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

Private Sub bttnCancelQty_Click
	pnlQuantity.Visible = False
	pnlDim.Visible = False
End Sub

' ======================
' CART DISPLAY (CustomListView version)
' ======================

Private Sub RefreshCartDisplay
	clvCartSummary.Clear

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
		pnl.SetLayout(0, 0, clvCartSummary.AsView.Width, 70dip)

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

		clvCartSummary.Add(pnl, CartItems.IndexOf(cartItem))

		totalAmount = totalAmount + lineTotal
		totalQuantity = totalQuantity + quantity
	Next

	lblTotalItems.Text = "Items: " & CartItems.Size & " entries (" & totalQuantity & " total)"
	lblTotalAmount.Text = "Total: ₱" & NumberFormat2(totalAmount, 1, 2, 2, False)
End Sub

' ======================
' SAVE ORDER
' ======================

Private Sub SaveOrderToLocalDatabase(FulfillmentStatus As String)
	Try
		If Main.VENDOR_ID <= 0 Or Main.LoggedInUserID <= 0 Then
			ToastMessageShow("Missing user/vendor session. Please login again.", True)
			Return
		End If

		Dim transactionNumber As String = GenerateTransactionNumber
		Dim total As Double = 0
		Dim totalQuantity As Int = 0

		For Each cartItem As Map In CartItems
			Dim unitPrice As Double = cartItem.Get("unit_price")
			Dim quantity As Int = cartItem.Get("quantity")
			total = total + (unitPrice * quantity)
			totalQuantity = totalQuantity + quantity
		Next

		Dim bookingValue As Int = GetBookingFromFulfillmentStatus(FulfillmentStatus)
		Dim prepaidValue As Int = GetPrepaidFromFulfillmentStatus(FulfillmentStatus)

		Main.SQLProducts.ExecNonQuery2( _
			"INSERT INTO orders (vendor_id, user_id, convention_id, transaction_number, device_id, date_created, status, total_amount, item_count, booking, prepaid, sync_status, customer_id, customer_code, customer_name, customer_owner, customer_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", _
			Array As Object(Main.VENDOR_ID, Main.LoggedInUserID, Main.LoggedInConventionID, transactionNumber, Main.DEVICE_ID, DateTime.Now, FulfillmentStatus, total, totalQuantity, bookingValue, prepaidValue, "Holding", Main.SELECTED_CUSTOMER_ID, Main.SELECTED_CUSTOMER_CODE, Main.SELECTED_CUSTOMER_NAME, Main.SELECTED_CUSTOMER_OWNER, Main.SELECTED_CUSTOMER_ADDRESS))

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

Private Sub GetBookingFromFulfillmentStatus(FulfillmentStatus As String) As Int
	If FulfillmentStatus = "Paid-Received" Then
		Return 1
	End If
	Return 0
End Sub

Private Sub GetPrepaidFromFulfillmentStatus(FulfillmentStatus As String) As Int
	If FulfillmentStatus = "Paid-Received" Or FulfillmentStatus = "Paid-Booked" Then
		Return 1
	End If
	Return 0
End Sub

Private Sub GetPaymentStatusFromFulfillmentStatus(FulfillmentStatus As String) As String
	If FulfillmentStatus = "Paid-Received" Or FulfillmentStatus = "Paid-Booked" Then
		Return "Paid"
	Else
		Return "NotPaid"
	End If
End Sub

Private Sub GetDeliveryStatusFromFulfillmentStatus(FulfillmentStatus As String) As String
	If FulfillmentStatus = "Paid-Received" Then
		Return "Received"
	Else
		Return "NotReceived"
	End If
End Sub

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


Private Sub ToggleSelection(Index As Int)
	If SelectedIndices.IndexOf(Index) > -1 Then
		SelectedIndices.RemoveAt(SelectedIndices.IndexOf(Index))
		HighlightItem(Index, False)
	Else
		SelectedIndices.Add(Index)
		HighlightItem(Index, True)
	End If

	Dim count As Int = SelectedIndices.Size

	btnDeleteSelected.Text = "Delete (" & count & ")"

	If count > 0 Then
		btnDeleteSelected.Enabled = True
		btnDeleteSelected.Color = Colors.Red
	Else
		btnDeleteSelected.Enabled = False
		btnDeleteSelected.Color = Colors.ARGB(80, 200, 200, 200)
		ExitSelectionMode
	End If
End Sub

Private Sub HighlightItem(Index As Int, Selected As Boolean)
	If Index < 0 Or Index >= clvCartSummary.Size Then Return

	Dim pnl As B4XView = clvCartSummary.GetPanel(Index)

	If Selected Then
		pnl.Color = Colors.LightGray
	Else
		pnl.Color = Colors.White
	End If
End Sub

Private Sub ExitSelectionMode
	SelectionMode = False

	' Remove highlight from all selected indexes
	For Each i As Int In SelectedIndices
		HighlightItem(i, False)
	Next

	SelectedIndices.Clear

	btnDeleteSelected.Enabled = False
	btnDeleteSelected.Color = Colors.ARGB(80, 200, 200, 200)
	btnDeleteSelected.Text = "Delete"
	btnDeleteSelected.Visible = True
End Sub

Private Sub clvCartSummary_ItemLongClick (Index As Int, Value As Object)
	SelectionMode = True
	btnDeleteSelected.Visible = True
	ToggleSelection(Index)
End Sub

Private Sub clvCartSummary_ItemClick (Index As Int, Value As Object)
	If SelectionMode = False Then Return
	ToggleSelection(Index)
End Sub

Private Sub btnCancelSelection_Click
	ExitSelectionMode
End Sub

Private Sub btnDeleteSelected_Click
	' Always allow click, but validate here

	' 1. Check if cart is empty
	If CartItems.Size = 0 Then
		ToastMessageShow("No items to delete", True)
		Return
	End If

	' 2. Check if user selected anything
	If SelectedIndices.Size = 0 Then
		ToastMessageShow("Long press item(s) to select for deletion", True)
		Return
	End If

	' 3. Show confirm delete popup
	PnlConfirmDelete.Visible = True
	PnlConfirmDelete.BringToFront
End Sub

Private Sub btnYesDelete_Click
	' Sort SelectedIndices DESCENDING manually
	For i = 0 To SelectedIndices.Size - 2
		For j = i + 1 To SelectedIndices.Size - 1
			If SelectedIndices.Get(i) < SelectedIndices.Get(j) Then
				Dim temp As Int = SelectedIndices.Get(i)
				SelectedIndices.Set(i, SelectedIndices.Get(j))
				SelectedIndices.Set(j, temp)
			End If
		Next
	Next

	' Now delete safely
	For Each index As Int In SelectedIndices
		If index >= 0 And index < CartItems.Size Then
			CartItems.RemoveAt(index)
		End If
	Next

	SelectedIndices.Clear
	RefreshCartDisplay

	PnlConfirmDelete.Visible = False
	btnDeleteSelected.Enabled = False
	btnDeleteSelected.Color = Colors.ARGB(80, 200, 200, 200)
	btnDeleteSelected.Text = "Delete"
	ExitSelectionMode
End Sub

Private Sub btnNoDelete_Click
	PnlConfirmDelete.Visible = False

End Sub


