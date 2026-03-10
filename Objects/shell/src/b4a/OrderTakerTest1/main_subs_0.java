package b4a.OrderTakerTest1;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,35);
if (RapidSub.canDelegate("activity_create")) { return b4a.OrderTakerTest1.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"main\")";
Debug.ShouldStop(8);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 39;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(64);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 40;BA.debugLine="If File.Exists(File.DirInternal, \"loginTest1.db\"";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("loginTest1.db"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 41;BA.debugLine="File.Copy(File.DirAssets, \"loginTest1.db\", File";
Debug.ShouldStop(256);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("loginTest1.db")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("loginTest1.db")));
 };
 BA.debugLineNum = 43;BA.debugLine="SQLLogin.Initialize(File.DirInternal, \"loginTest";
Debug.ShouldStop(1024);
main._sqllogin.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("loginTest1.db")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 48;BA.debugLine="SQLProducts.Initialize(File.DirInternal, \"product";
Debug.ShouldStop(32768);
main._sqlproducts.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("productsTest1.db")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 51;BA.debugLine="SQLProducts.ExecNonQuery(\"CREATE TABLE IF NOT EXI";
Debug.ShouldStop(262144);
main._sqlproducts.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS items ("),RemoteObject.createImmutable("item_id INTEGER PRIMARY KEY, "),RemoteObject.createImmutable("item_code TEXT, "),RemoteObject.createImmutable("item_name TEXT, "),RemoteObject.createImmutable("unit_price REAL, "),RemoteObject.createImmutable("barcode TEXT, "),RemoteObject.createImmutable("vendor_id INTEGER, "),RemoteObject.createImmutable("is_active INTEGER)"))));
 BA.debugLineNum = 62;BA.debugLine="etpassword.PasswordMode = True";
Debug.ShouldStop(536870912);
main.mostCurrent._etpassword.runVoidMethod ("setPasswordMode",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("activity_pause")) { return b4a.OrderTakerTest1.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,68);
if (RapidSub.canDelegate("activity_resume")) { return b4a.OrderTakerTest1.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bttnlogin_click() throws Exception{
try {
		Debug.PushSubsStack("bttnLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("bttnlogin_click")) { return b4a.OrderTakerTest1.main.remoteMe.runUserSub(false, "main","bttnlogin_click");}
RemoteObject _username = RemoteObject.createImmutable("");
RemoteObject _password = RemoteObject.createImmutable("");
RemoteObject _cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 BA.debugLineNum = 74;BA.debugLine="Private Sub bttnLogin_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Dim username As String = etuser.Text.Trim";
Debug.ShouldStop(1024);
_username = main.mostCurrent._etuser.runMethod(true,"getText").runMethod(true,"trim");Debug.locals.put("username", _username);Debug.locals.put("username", _username);
 BA.debugLineNum = 76;BA.debugLine="Dim password As String = etpassword.Text.Trim";
Debug.ShouldStop(2048);
_password = main.mostCurrent._etpassword.runMethod(true,"getText").runMethod(true,"trim");Debug.locals.put("password", _password);Debug.locals.put("password", _password);
 BA.debugLineNum = 78;BA.debugLine="If username = \"\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_username,BA.ObjectToString(""))) { 
 BA.debugLineNum = 79;BA.debugLine="etuser.RequestFocus";
Debug.ShouldStop(16384);
main.mostCurrent._etuser.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"Please enter your username\", F";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter your username")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 81;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 84;BA.debugLine="If password = \"\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_password,BA.ObjectToString(""))) { 
 BA.debugLineNum = 85;BA.debugLine="etpassword.RequestFocus";
Debug.ShouldStop(1048576);
main.mostCurrent._etpassword.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 86;BA.debugLine="ToastMessageShow(\"Please enter your password\", F";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter your password")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 87;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 90;BA.debugLine="Dim Cursor1 As Cursor";
Debug.ShouldStop(33554432);
_cursor1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor1", _cursor1);
 BA.debugLineNum = 91;BA.debugLine="Cursor1 = SQLLogin.ExecQuery2(\"SELECT * FROM user";
Debug.ShouldStop(67108864);
_cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqllogin.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT * FROM user WHERE username = ? AND password = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {_username,_password}))));Debug.locals.put("Cursor1", _cursor1);
 BA.debugLineNum = 93;BA.debugLine="If Cursor1.RowCount > 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(">",_cursor1.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(\"Login Successful!\", False)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Login Successful!")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 95;BA.debugLine="LoggedInUser = username";
Debug.ShouldStop(1073741824);
main._loggedinuser = _username;
 BA.debugLineNum = 96;BA.debugLine="StartActivity(OrderTakerDashboard)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._ordertakerdashboard.getObject())));
 BA.debugLineNum = 97;BA.debugLine="Controls.SetAnimation(\"slide_left_in\", \"slide_le";
Debug.ShouldStop(1);
main.mostCurrent._controls.runVoidMethod ("_setanimation" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("slide_left_in")),(Object)(RemoteObject.createImmutable("slide_left_out")));
 BA.debugLineNum = 98;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 100;BA.debugLine="ToastMessageShow(\"Invalid username or password\",";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Invalid username or password")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 102;BA.debugLine="Cursor1.Close";
Debug.ShouldStop(32);
_cursor1.runVoidMethod ("Close");
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private bttnLogin As Button";
main.mostCurrent._bttnlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private etuser As EditText";
main.mostCurrent._etuser = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private etpassword As EditText";
main.mostCurrent._etpassword = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private lbluser As Label";
main.mostCurrent._lbluser = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private lblpass As Label";
main.mostCurrent._lblpass = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lblforgot As Label";
main.mostCurrent._lblforgot = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblforgot_click() throws Exception{
try {
		Debug.PushSubsStack("lblforgot_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,105);
if (RapidSub.canDelegate("lblforgot_click")) { return b4a.OrderTakerTest1.main.remoteMe.runUserSub(false, "main","lblforgot_click");}
 BA.debugLineNum = 105;BA.debugLine="Private Sub lblforgot_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 106;BA.debugLine="StartActivity(forgotPass)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._forgotpass.getObject())));
 BA.debugLineNum = 107;BA.debugLine="Controls.SetAnimation(\"slide_up_in\", \"slide_up_ou";
Debug.ShouldStop(1024);
main.mostCurrent._controls.runVoidMethod ("_setanimation" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("slide_up_in")),(Object)(RemoteObject.createImmutable("slide_up_out")));
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
controls_subs_0._process_globals();
forgotpass_subs_0._process_globals();
ordertakerdashboard_subs_0._process_globals();
addorderactivity_subs_0._process_globals();
starter_subs_0._process_globals();
userorders_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.main");
controls.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.controls");
forgotpass.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.forgotpass");
ordertakerdashboard.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.ordertakerdashboard");
addorderactivity.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.addorderactivity");
starter.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.starter");
userorders.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.userorders");
httputils2service.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.OrderTakerTest1.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Public SQLLogin As SQL       ' login DB";
main._sqllogin = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 17;BA.debugLine="Public SQLProducts As SQL    ' products/orders DB";
main._sqlproducts = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 18;BA.debugLine="Public LoggedInUser As String";
main._loggedinuser = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Public API_URL As String = \"http://192.168.8.225/";
main._api_url = BA.ObjectToString("http://192.168.8.225/ordertaker_api/fetching_items_test1.php");
 //BA.debugLineNum = 21;BA.debugLine="Public ITEMS_LAST_SYNC As Long = 0";
main._items_last_sync = BA.numberCast(long.class, 0);
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}