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
	Private SQLProducts As SQL
	Private xui As XUI
End Sub

Sub Globals
	Private Panel1 As Panel
	Private lbllogout As Label
	Private lblperson As Label
	Private lblLoggedInUser As Label
	Private ScrollView1 As ScrollView
	Private pnlBottomNav As Panel
	Private lblDash As Label
	Private lblDashIcon As Label
	Private lblHistory As Label
	Private lblHistoryIcon As Label
	Private lblInventory As Label
	Private lblInventoryIcon As Label
	Private lblOrders As Label
	Private lblOrdersIcon As Label
	Private pnlDash As Panel
	Private pnlHistory As Panel
	Private pnlInventory As Panel
	Private pnlOrders As Panel
	Private bttnAddOrder As Button
	Private pnlAddOrderHomeTotal As Panel
	Private lblExitAddOrderHome As Label
	Private pnlDim As Panel
	Private btnAddItems As Button
	Private pnlSelectItems As Panel
	Private svSelectItems As ScrollView
	Private etSearchItems As EditText
	Private btnPurchaseNow As Button
	Private lblExitSelectItems As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("userOrders")
    
	' Display current logged in user
	lblLoggedInUser.Text = "Welcome, " & Main.LoggedInUser
    
	' Copy database if first time
	
    
	' Initialize local SQLite
	SQLProducts.Initialize(File.DirInternal, "productsTest1.db", True)
    
	' ===== SCROLLVIEW INTERNAL PANEL =====
	ScrollView1.Panel.Width = ScrollView1.Width
	ScrollView1.Panel.Height = ScrollView1.Height   ' initial height
  

	' ===== Find ScrollView inside pnlSelectItems =====
	svSelectItems = Null
	For i = 0 To pnlSelectItems.NumberOfViews - 1
		Dim v As View = pnlSelectItems.GetView(i)
		If v Is ScrollView Then
			svSelectItems = v
			Exit
		End If
	Next
    
	If svSelectItems = Null Then
		Log("Error: svSelectItems not found inside pnlSelectItems!")
	Else
		' Set initial size for internal panel
		svSelectItems.Panel.Width = svSelectItems.Width
		svSelectItems.Panel.Height = 10dip
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

' ================== NAVIGATION ==================


Private Sub lbllogout_Click
	Main.LoggedInUser = ""
	StartActivity(Main)
	Controls.SetAnimation("slide_right_in", "slide_right_out")
	Activity.Finish
End Sub

' ================== PRODUCT CARD ==================
Private Sub CreateProductCard(sku As String, name As String, price As Double, packNumber As Int) As Panel
	Dim pnl As Panel
	pnl.Initialize("")
	pnl.Color = Colors.White
	' Corner radius requires B4XPages or XUIViews, otherwise omit

	' SKU
	Dim lblSKU As Label
	lblSKU.Initialize("")
	lblSKU.Text = "SKU: " & sku
	lblSKU.TextSize = 14
	pnl.AddView(lblSKU, 10dip, 10dip, 200dip, 20dip)

	' Name
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = name
	lblName.TextSize = 16
	pnl.AddView(lblName, 10dip, 35dip, 200dip, 25dip)

	' Price
	Dim lblPrice As Label
	lblPrice.Initialize("")
	lblPrice.Text = "₱" & price
	lblPrice.TextSize = 14
	pnl.AddView(lblPrice, 10dip, 65dip, 200dip, 20dip)

	' Pack
	Dim lblPack As Label
	lblPack.Initialize("")
	lblPack.Text = "Pack: " & packNumber
	lblPack.TextSize = 14
	pnl.AddView(lblPack, 10dip, 90dip, 200dip, 20dip)

	pnl.Height = 120dip
	Return pnl
End Sub

' ================== LOAD PRODUCTS ==================
Private Sub LoadProductsIntoSelectItems
	svSelectItems.Panel.RemoveAllViews
	svSelectItems.Panel.Height = 0

	Dim cursor As Cursor
	cursor = SQLProducts.ExecQuery("SELECT * FROM products")
	Dim topPos As Int = 10dip

	For i = 0 To cursor.RowCount - 1
		cursor.Position = i
		Dim sku As String = cursor.GetString("sku")
		Dim name As String = cursor.GetString("name")
		Dim price As Double = cursor.GetDouble("price")
		Dim packNumber As Int = cursor.GetInt("pack_number")

		Dim card As Panel
		card = CreateProductCard(sku, name, price, packNumber)

		svSelectItems.Panel.AddView(card, 10dip, topPos, svSelectItems.Width - 20dip, card.Height)
		topPos = topPos + card.Height + 10dip
	Next

	cursor.Close
	svSelectItems.Panel.Height = topPos + 10dip
End Sub

' ================== BUTTON EVENTS ==================
Private Sub bttnAddOrder_Click
	pnlDim.Visible = True
	pnlDim.BringToFront
	pnlAddOrderHomeTotal.Visible = True
	pnlAddOrderHomeTotal.BringToFront

	bttnAddOrder.Visible = False
	lblExitAddOrderHome.Visible = True
	btnAddItems.Visible = True
	btnPurchaseNow.Visible = True
End Sub

Private Sub lblExitAddOrderHome_Click
	pnlAddOrderHomeTotal.Visible = False
	pnlDim.Visible = False
	bttnAddOrder.Visible = True
End Sub

Private Sub btnAddItems_Click
	pnlDim.Visible = True
	pnlDim.BringToFront
    
	pnlSelectItems.Visible = True
	pnlSelectItems.BringToFront
	
	LoadProductsIntoSelectItems
    

End Sub

Private Sub lblExitSelectItems_Click
	pnlSelectItems.Visible = False
	pnlDim.Visible = False
	
End Sub

Private Sub btnPurchaseNow_Click
	' Implement purchase logic here
End Sub

Private Sub pnlDim_Click
	' Catch click to block underlying views
End Sub