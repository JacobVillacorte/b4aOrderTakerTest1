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
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

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
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("userDashboard")
	' Display current logged in user
	lblLoggedInUser.Text = "Welcome, " & Main.LoggedInUser

	' ===== SCROLLVIEW INTERNAL PANEL =====
	ScrollView1.Panel.Width = ScrollView1.Width
	ScrollView1.Panel.Height = ScrollView1.Height   ' initial height; grow if you add cards
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbllogout_Click
    
	Main.LoggedInUser = ""   ' Clear session
	StartActivity(Main)
	Controls.SetAnimation("slide_right_in", "slide_right_out")
	
	Activity.Finish
    
End Sub

Private Sub pnlOrders_Click
	StartActivity(userOrders)
End Sub

