package b4a.OrderTakerTest1;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ordertakerdashboard_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,40);
if (RapidSub.canDelegate("activity_create")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="Activity.LoadLayout(\"OrderTakerDashboard\")";
Debug.ShouldStop(256);
ordertakerdashboard.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("OrderTakerDashboard")),ordertakerdashboard.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="lblLoggedInUser.Text = \"Welcome, \" & Main.LoggedI";
Debug.ShouldStop(512);
ordertakerdashboard.mostCurrent._lblloggedinuser.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Welcome, "),ordertakerdashboard.mostCurrent._main._loggedinuser /*RemoteObject*/ )));
 BA.debugLineNum = 45;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"CREATE TABLE IF NO";
Debug.ShouldStop(4096);
ordertakerdashboard.mostCurrent._main._sqlproducts /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS orders (order_id INTEGER PRIMARY KEY AUTOINCREMENT, vendor_id INTEGER, date_created TEXT, status TEXT, total_amount REAL)")));
 BA.debugLineNum = 46;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"CREATE TABLE IF NO";
Debug.ShouldStop(8192);
ordertakerdashboard.mostCurrent._main._sqlproducts /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS order_items (order_item_id INTEGER PRIMARY KEY AUTOINCREMENT, order_id INTEGER, product_id INTEGER, quantity INTEGER, price REAL)")));
 BA.debugLineNum = 48;BA.debugLine="ShowPanel(pnlContentDash)";
Debug.ShouldStop(32768);
_showpanel(ordertakerdashboard.mostCurrent._pnlcontentdash);
 BA.debugLineNum = 49;BA.debugLine="UpdateDashboardStatus";
Debug.ShouldStop(65536);
_updatedashboardstatus();
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,56);
if (RapidSub.canDelegate("activity_pause")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Resume (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,52);
if (RapidSub.canDelegate("activity_resume")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","activity_resume");}
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="LoadOrders";
Debug.ShouldStop(1048576);
_loadorders();
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bttnaddorder_click() throws Exception{
try {
		Debug.PushSubsStack("bttnAddOrder_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,135);
if (RapidSub.canDelegate("bttnaddorder_click")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","bttnaddorder_click");}
 BA.debugLineNum = 135;BA.debugLine="Private Sub bttnAddOrder_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 136;BA.debugLine="StartActivity(addOrderActivity)";
Debug.ShouldStop(128);
ordertakerdashboard.mostCurrent.__c.runVoidMethod ("StartActivity",ordertakerdashboard.processBA,(Object)((ordertakerdashboard.mostCurrent._addorderactivity.getObject())));
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _bttnfetchproducts_click() throws Exception{
try {
		Debug.PushSubsStack("bttnFetchProducts_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,148);
if (RapidSub.canDelegate("bttnfetchproducts_click")) { b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","bttnfetchproducts_click"); return;}
ResumableSub_bttnFetchProducts_Click rsub = new ResumableSub_bttnFetchProducts_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_bttnFetchProducts_Click extends BA.ResumableSub {
public ResumableSub_bttnFetchProducts_Click(b4a.OrderTakerTest1.ordertakerdashboard parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.OrderTakerTest1.ordertakerdashboard parent;
RemoteObject _j = RemoteObject.declareNull("b4a.OrderTakerTest1.httpjob");
RemoteObject _response = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _statusvalue = RemoteObject.createImmutable("");
RemoteObject _items = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _item = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _itemid = RemoteObject.createImmutable(0);
RemoteObject _itemcode = RemoteObject.createImmutable("");
RemoteObject _itemname = RemoteObject.createImmutable("");
RemoteObject _unitprice = RemoteObject.createImmutable(0);
RemoteObject _barcode = RemoteObject.createImmutable("");
RemoteObject _vendorid = RemoteObject.createImmutable(0);
RemoteObject _isactive = RemoteObject.createImmutable(0);
int step27;
int limit27;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("bttnFetchProducts_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,148);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 150;BA.debugLine="bttnFetchProducts.Enabled = False";
Debug.ShouldStop(2097152);
parent.mostCurrent._bttnfetchproducts.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 151;BA.debugLine="bttnFetchProducts.Color = Colors.LightGray";
Debug.ShouldStop(4194304);
parent.mostCurrent._bttnfetchproducts.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 BA.debugLineNum = 152;BA.debugLine="lblFetchStatus.Text = \"Connecting to server...\"";
Debug.ShouldStop(8388608);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence("Connecting to server..."));
 BA.debugLineNum = 153;BA.debugLine="lblFetchStatus.TextColor = Colors.Blue";
Debug.ShouldStop(16777216);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 155;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(67108864);
_j = RemoteObject.createNew ("b4a.OrderTakerTest1.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 156;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(134217728);
_j.runClassMethod (b4a.OrderTakerTest1.httpjob.class, "_initialize" /*RemoteObject*/ ,ordertakerdashboard.processBA,(Object)(BA.ObjectToString("")),(Object)(ordertakerdashboard.getObject()));
 BA.debugLineNum = 157;BA.debugLine="j.Download(Main.API_URL)";
Debug.ShouldStop(268435456);
_j.runClassMethod (b4a.OrderTakerTest1.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(parent.mostCurrent._main._api_url /*RemoteObject*/ ));
 BA.debugLineNum = 158;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ordertakerdashboard.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ordertakerdashboard", "bttnfetchproducts_click"), (_j));
this.state = 35;
return;
case 35:
//C
this.state = 1;
_j = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("j", _j);
;
 BA.debugLineNum = 160;BA.debugLine="If j.Success Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 1:
//if
this.state = 34;
if (_j.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 33;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 161;BA.debugLine="Try";
Debug.ShouldStop(1);
if (true) break;

case 4:
//try
this.state = 31;
this.catchState = 30;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 7;
this.catchState = 30;
 BA.debugLineNum = 162;BA.debugLine="Dim response As String = j.GetString";
Debug.ShouldStop(2);
_response = _j.runClassMethod (b4a.OrderTakerTest1.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("response", _response);Debug.locals.put("response", _response);
 BA.debugLineNum = 164;BA.debugLine="If response = \"\" Or response = Null Then";
Debug.ShouldStop(8);
if (true) break;

case 7:
//if
this.state = 10;
if (RemoteObject.solveBoolean("=",_response,BA.ObjectToString("")) || RemoteObject.solveBoolean("n",_response)) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 165;BA.debugLine="lblFetchStatus.Text = \"ERROR: Empty response\"";
Debug.ShouldStop(16);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence("ERROR: Empty response"));
 BA.debugLineNum = 166;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
Debug.ShouldStop(32);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 167;BA.debugLine="bttnFetchProducts.Enabled = True";
Debug.ShouldStop(64);
parent.mostCurrent._bttnfetchproducts.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 168;BA.debugLine="bttnFetchProducts.Color = Colors.Blue";
Debug.ShouldStop(128);
parent.mostCurrent._bttnfetchproducts.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 169;BA.debugLine="j.Release";
Debug.ShouldStop(256);
_j.runClassMethod (b4a.OrderTakerTest1.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 170;BA.debugLine="Return";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) return ;
 if (true) break;

case 10:
//C
this.state = 11;
;
 BA.debugLineNum = 173;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(4096);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 174;BA.debugLine="parser.Initialize(response)";
Debug.ShouldStop(8192);
_parser.runVoidMethod ("Initialize",(Object)(_response));
 BA.debugLineNum = 175;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(16384);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 177;BA.debugLine="Dim statusValue As String = root.Get(\"status\")";
Debug.ShouldStop(65536);
_statusvalue = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status")))));Debug.locals.put("statusValue", _statusvalue);Debug.locals.put("statusValue", _statusvalue);
 BA.debugLineNum = 179;BA.debugLine="If statusValue = \"success\" Then";
Debug.ShouldStop(262144);
if (true) break;

case 11:
//if
this.state = 28;
if (RemoteObject.solveBoolean("=",_statusvalue,BA.ObjectToString("success"))) { 
this.state = 13;
}else {
this.state = 27;
}if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 181;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"DELETE FROM ite";
Debug.ShouldStop(1048576);
parent.mostCurrent._main._sqlproducts /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("DELETE FROM items")));
 BA.debugLineNum = 184;BA.debugLine="Dim items As List = root.Get(\"data\")";
Debug.ShouldStop(8388608);
_items = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_items = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("data")))));Debug.locals.put("items", _items);Debug.locals.put("items", _items);
 BA.debugLineNum = 186;BA.debugLine="For i = 0 To items.Size - 1";
Debug.ShouldStop(33554432);
if (true) break;

case 14:
//for
this.state = 25;
step27 = 1;
limit27 = RemoteObject.solve(new RemoteObject[] {_items.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 36;
if (true) break;

case 36:
//C
this.state = 25;
if ((step27 > 0 && _i <= limit27) || (step27 < 0 && _i >= limit27)) this.state = 16;
if (true) break;

case 37:
//C
this.state = 36;
_i = ((int)(0 + _i + step27)) ;
Debug.locals.put("i", _i);
if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 187;BA.debugLine="Dim item As Map = items.Get(i)";
Debug.ShouldStop(67108864);
_item = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_item = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _items.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("item", _item);Debug.locals.put("item", _item);
 BA.debugLineNum = 189;BA.debugLine="Dim itemID As Int = item.Get(\"item_id\")";
Debug.ShouldStop(268435456);
_itemid = BA.numberCast(int.class, _item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("item_id")))));Debug.locals.put("itemID", _itemid);Debug.locals.put("itemID", _itemid);
 BA.debugLineNum = 190;BA.debugLine="Dim itemCode As String = item.Get(\"item_code\"";
Debug.ShouldStop(536870912);
_itemcode = BA.ObjectToString(_item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("item_code")))));Debug.locals.put("itemCode", _itemcode);Debug.locals.put("itemCode", _itemcode);
 BA.debugLineNum = 191;BA.debugLine="Dim itemName As String = item.Get(\"item_name\"";
Debug.ShouldStop(1073741824);
_itemname = BA.ObjectToString(_item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("item_name")))));Debug.locals.put("itemName", _itemname);Debug.locals.put("itemName", _itemname);
 BA.debugLineNum = 192;BA.debugLine="Dim unitPrice As Double = item.Get(\"unit_pric";
Debug.ShouldStop(-2147483648);
_unitprice = BA.numberCast(double.class, _item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("unit_price")))));Debug.locals.put("unitPrice", _unitprice);Debug.locals.put("unitPrice", _unitprice);
 BA.debugLineNum = 194;BA.debugLine="Dim barcode As String = \"\"";
Debug.ShouldStop(2);
_barcode = BA.ObjectToString("");Debug.locals.put("barcode", _barcode);Debug.locals.put("barcode", _barcode);
 BA.debugLineNum = 195;BA.debugLine="If item.ContainsKey(\"barcode\") And item.Get(\"";
Debug.ShouldStop(4);
if (true) break;

case 17:
//if
this.state = 20;
if (RemoteObject.solveBoolean(".",_item.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("barcode"))))) && RemoteObject.solveBoolean("N",_item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("barcode")))))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 196;BA.debugLine="barcode = item.Get(\"barcode\")";
Debug.ShouldStop(8);
_barcode = BA.ObjectToString(_item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("barcode")))));Debug.locals.put("barcode", _barcode);
 if (true) break;

case 20:
//C
this.state = 21;
;
 BA.debugLineNum = 199;BA.debugLine="Dim vendorID As Int = 0";
Debug.ShouldStop(64);
_vendorid = BA.numberCast(int.class, 0);Debug.locals.put("vendorID", _vendorid);Debug.locals.put("vendorID", _vendorid);
 BA.debugLineNum = 200;BA.debugLine="If item.ContainsKey(\"vendor_id\") And item.Get";
Debug.ShouldStop(128);
if (true) break;

case 21:
//if
this.state = 24;
if (RemoteObject.solveBoolean(".",_item.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("vendor_id"))))) && RemoteObject.solveBoolean("N",_item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("vendor_id")))))) { 
this.state = 23;
}if (true) break;

case 23:
//C
this.state = 24;
 BA.debugLineNum = 201;BA.debugLine="vendorID = item.Get(\"vendor_id\")";
Debug.ShouldStop(256);
_vendorid = BA.numberCast(int.class, _item.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("vendor_id")))));Debug.locals.put("vendorID", _vendorid);
 if (true) break;

case 24:
//C
this.state = 37;
;
 BA.debugLineNum = 204;BA.debugLine="Dim isActive As Int = 1";
Debug.ShouldStop(2048);
_isactive = BA.numberCast(int.class, 1);Debug.locals.put("isActive", _isactive);Debug.locals.put("isActive", _isactive);
 BA.debugLineNum = 206;BA.debugLine="Main.SQLProducts.ExecNonQuery2(\"INSERT INTO i";
Debug.ShouldStop(8192);
parent.mostCurrent._main._sqlproducts /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO items VALUES (?, ?, ?, ?, ?, ?, ?)")),(Object)(parent.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {7},new Object[] {(_itemid),(_itemcode),(_itemname),(_unitprice),(_barcode),(_vendorid),(_isactive)})))));
 if (true) break;
if (true) break;

case 25:
//C
this.state = 28;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 211;BA.debugLine="Main.ITEMS_LAST_SYNC = DateTime.Now";
Debug.ShouldStop(262144);
parent.mostCurrent._main._items_last_sync /*RemoteObject*/  = parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");
 BA.debugLineNum = 214;BA.debugLine="lblFetchStatus.Text = \"✓ Sync completed succes";
Debug.ShouldStop(2097152);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence("✓ Sync completed successfully!"));
 BA.debugLineNum = 215;BA.debugLine="lblFetchStatus.TextColor = Colors.RGB(0, 150,";
Debug.ShouldStop(4194304);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 217;BA.debugLine="UpdateDashboardStatus";
Debug.ShouldStop(16777216);
_updatedashboardstatus();
 BA.debugLineNum = 219;BA.debugLine="ToastMessageShow(\"Synced \" & items.Size & \" pr";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Synced "),_items.runMethod(true,"getSize"),RemoteObject.createImmutable(" products")))),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 27:
//C
this.state = 28;
 BA.debugLineNum = 221;BA.debugLine="lblFetchStatus.Text = \"ERROR: Server returned";
Debug.ShouldStop(268435456);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence("ERROR: Server returned error"));
 BA.debugLineNum = 222;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
Debug.ShouldStop(536870912);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 if (true) break;

case 28:
//C
this.state = 31;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 30:
//C
this.state = 31;
this.catchState = 0;
 BA.debugLineNum = 225;BA.debugLine="lblFetchStatus.Text = \"ERROR: \" & LastException";
Debug.ShouldStop(1);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("ERROR: "),parent.mostCurrent.__c.runMethod(false,"LastException",ordertakerdashboard.mostCurrent.activityBA).runMethod(true,"getMessage"))));
 BA.debugLineNum = 226;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
Debug.ShouldStop(2);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 if (true) break;
if (true) break;

case 31:
//C
this.state = 34;
this.catchState = 0;
;
 if (true) break;

case 33:
//C
this.state = 34;
 BA.debugLineNum = 229;BA.debugLine="lblFetchStatus.Text = \"✗ Cannot connect. Check W";
Debug.ShouldStop(16);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence("✗ Cannot connect. Check WiFi and server."));
 BA.debugLineNum = 230;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
Debug.ShouldStop(32);
parent.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 231;BA.debugLine="ToastMessageShow(\"Network error. Using cached da";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Network error. Using cached data.")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 34:
//C
this.state = -1;
;
 BA.debugLineNum = 235;BA.debugLine="bttnFetchProducts.Enabled = True";
Debug.ShouldStop(1024);
parent.mostCurrent._bttnfetchproducts.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 236;BA.debugLine="bttnFetchProducts.Color = Colors.Blue";
Debug.ShouldStop(2048);
parent.mostCurrent._bttnfetchproducts.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 237;BA.debugLine="j.Release";
Debug.ShouldStop(4096);
_j.runClassMethod (b4a.OrderTakerTest1.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 238;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",ordertakerdashboard.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _jobdone(RemoteObject _j) throws Exception{
}
public static RemoteObject  _clvcontentorders_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("clvContentOrders_ItemClick (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,127);
if (RapidSub.canDelegate("clvcontentorders_itemclick")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","clvcontentorders_itemclick", _index, _value);}
RemoteObject _orderid = RemoteObject.createImmutable(0);
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 127;BA.debugLine="Private Sub clvContentOrders_ItemClick(Index As In";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="Dim orderID As Int = Value";
Debug.ShouldStop(-2147483648);
_orderid = BA.numberCast(int.class, _value);Debug.locals.put("orderID", _orderid);Debug.locals.put("orderID", _orderid);
 BA.debugLineNum = 129;BA.debugLine="ToastMessageShow(\"Order #\" & orderID & \" clicked\"";
Debug.ShouldStop(1);
ordertakerdashboard.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Order #"),_orderid,RemoteObject.createImmutable(" clicked")))),(Object)(ordertakerdashboard.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clvcontentorders_itemlongclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("clvContentOrders_ItemLongClick (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,132);
if (RapidSub.canDelegate("clvcontentorders_itemlongclick")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","clvcontentorders_itemlongclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 132;BA.debugLine="Private Sub clvContentOrders_ItemLongClick(Index A";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private bttnAddOrder As Button";
ordertakerdashboard.mostCurrent._bttnaddorder = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Private lblDash As Label, lblDashIcon As Label";
ordertakerdashboard.mostCurrent._lbldash = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
ordertakerdashboard.mostCurrent._lbldashicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private lblHistory As Label, lblHistoryIcon As La";
ordertakerdashboard.mostCurrent._lblhistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
ordertakerdashboard.mostCurrent._lblhistoryicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private lblInventory As Label, lblInventoryIcon A";
ordertakerdashboard.mostCurrent._lblinventory = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
ordertakerdashboard.mostCurrent._lblinventoryicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private lblLoggedInUser As Label";
ordertakerdashboard.mostCurrent._lblloggedinuser = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private lbllogout As Label";
ordertakerdashboard.mostCurrent._lbllogout = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private lblOrders As Label, lblOrdersIcon As Labe";
ordertakerdashboard.mostCurrent._lblorders = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
ordertakerdashboard.mostCurrent._lblordersicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lblperson As Label";
ordertakerdashboard.mostCurrent._lblperson = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private pnlBottomNav As Panel";
ordertakerdashboard.mostCurrent._pnlbottomnav = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private pnlContent As Panel";
ordertakerdashboard.mostCurrent._pnlcontent = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pnlContentDash As Panel";
ordertakerdashboard.mostCurrent._pnlcontentdash = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private pnlContentHistory As Panel";
ordertakerdashboard.mostCurrent._pnlcontenthistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pnlContentInventory As Panel";
ordertakerdashboard.mostCurrent._pnlcontentinventory = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pnlContentOrders As Panel";
ordertakerdashboard.mostCurrent._pnlcontentorders = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pnlDash As Panel";
ordertakerdashboard.mostCurrent._pnldash = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private pnlDim As Panel";
ordertakerdashboard.mostCurrent._pnldim = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private pnlHistory As Panel";
ordertakerdashboard.mostCurrent._pnlhistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private pnlInventory As Panel";
ordertakerdashboard.mostCurrent._pnlinventory = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private pnlOrders As Panel";
ordertakerdashboard.mostCurrent._pnlorders = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private pnlTop As Panel";
ordertakerdashboard.mostCurrent._pnltop = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private etContentSearchOrder As EditText";
ordertakerdashboard.mostCurrent._etcontentsearchorder = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private clvContentOrders As CustomListView";
ordertakerdashboard.mostCurrent._clvcontentorders = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 33;BA.debugLine="Private lblFetchStatus As Label";
ordertakerdashboard.mostCurrent._lblfetchstatus = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private bttnFetchProducts As Button";
ordertakerdashboard.mostCurrent._bttnfetchproducts = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private svInventory As ScrollView";
ordertakerdashboard.mostCurrent._svinventory = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblCacheInfo As Label";
ordertakerdashboard.mostCurrent._lblcacheinfo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbllogout_click() throws Exception{
try {
		Debug.PushSubsStack("lbllogout_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,91);
if (RapidSub.canDelegate("lbllogout_click")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","lbllogout_click");}
 BA.debugLineNum = 91;BA.debugLine="Private Sub lbllogout_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="Main.LoggedInUser = \"\"";
Debug.ShouldStop(134217728);
ordertakerdashboard.mostCurrent._main._loggedinuser /*RemoteObject*/  = BA.ObjectToString("");
 BA.debugLineNum = 93;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(268435456);
ordertakerdashboard.mostCurrent.__c.runVoidMethod ("StartActivity",ordertakerdashboard.processBA,(Object)((ordertakerdashboard.mostCurrent._main.getObject())));
 BA.debugLineNum = 94;BA.debugLine="Activity.Finish";
Debug.ShouldStop(536870912);
ordertakerdashboard.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadinventoryitems() throws Exception{
try {
		Debug.PushSubsStack("LoadInventoryItems (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,241);
if (RapidSub.canDelegate("loadinventoryitems")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","loadinventoryitems");}
RemoteObject _top = RemoteObject.createImmutable(0);
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _lblempty = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblprice = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblcode = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 241;BA.debugLine="Private Sub LoadInventoryItems";
Debug.ShouldStop(65536);
 BA.debugLineNum = 242;BA.debugLine="svInventory.Panel.RemoveAllViews";
Debug.ShouldStop(131072);
ordertakerdashboard.mostCurrent._svinventory.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 243;BA.debugLine="Dim top As Int = 0";
Debug.ShouldStop(262144);
_top = BA.numberCast(int.class, 0);Debug.locals.put("top", _top);Debug.locals.put("top", _top);
 BA.debugLineNum = 245;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery(";
Debug.ShouldStop(1048576);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), ordertakerdashboard.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM items WHERE is_active = 1 ORDER BY item_name"))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 247;BA.debugLine="If rs.RowCount = 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_rs.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 249;BA.debugLine="Dim lblEmpty As Label";
Debug.ShouldStop(16777216);
_lblempty = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblEmpty", _lblempty);
 BA.debugLineNum = 250;BA.debugLine="lblEmpty.Initialize(\"\")";
Debug.ShouldStop(33554432);
_lblempty.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 251;BA.debugLine="lblEmpty.Text = \"No products cached. Go to Dashb";
Debug.ShouldStop(67108864);
_lblempty.runMethod(true,"setText",BA.ObjectToCharSequence("No products cached. Go to Dashboard and sync first."));
 BA.debugLineNum = 252;BA.debugLine="lblEmpty.TextSize = 14";
Debug.ShouldStop(134217728);
_lblempty.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 253;BA.debugLine="lblEmpty.TextColor = Colors.Gray";
Debug.ShouldStop(268435456);
_lblempty.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 254;BA.debugLine="lblEmpty.Gravity = Gravity.CENTER";
Debug.ShouldStop(536870912);
_lblempty.runMethod(true,"setGravity",ordertakerdashboard.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 255;BA.debugLine="svInventory.Panel.AddView(lblEmpty, 0, 20dip, sv";
Debug.ShouldStop(1073741824);
ordertakerdashboard.mostCurrent._svinventory.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lblempty.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(ordertakerdashboard.mostCurrent._svinventory.runMethod(true,"getWidth")),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 256;BA.debugLine="rs.Close";
Debug.ShouldStop(-2147483648);
_rs.runVoidMethod ("Close");
 BA.debugLineNum = 257;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 260;BA.debugLine="Do While rs.NextRow";
Debug.ShouldStop(8);
while (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 261;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(16);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 262;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(32);
_pnl.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 263;BA.debugLine="pnl.Color = Colors.White";
Debug.ShouldStop(64);
_pnl.runVoidMethod ("setColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 265;BA.debugLine="Dim lblName As Label";
Debug.ShouldStop(256);
_lblname = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblName", _lblname);
 BA.debugLineNum = 266;BA.debugLine="lblName.Initialize(\"\")";
Debug.ShouldStop(512);
_lblname.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 267;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
Debug.ShouldStop(1024);
_lblname.runMethod(true,"setText",BA.ObjectToCharSequence(_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("item_name")))));
 BA.debugLineNum = 268;BA.debugLine="lblName.TextSize = 16";
Debug.ShouldStop(2048);
_lblname.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 269;BA.debugLine="lblName.TextColor = Colors.Black";
Debug.ShouldStop(4096);
_lblname.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 271;BA.debugLine="Dim lblPrice As Label";
Debug.ShouldStop(16384);
_lblprice = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblPrice", _lblprice);
 BA.debugLineNum = 272;BA.debugLine="lblPrice.Initialize(\"\")";
Debug.ShouldStop(32768);
_lblprice.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 273;BA.debugLine="lblPrice.Text = \"₱\" & rs.GetDouble(\"unit_price\")";
Debug.ShouldStop(65536);
_lblprice.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("₱"),_rs.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("unit_price"))))));
 BA.debugLineNum = 274;BA.debugLine="lblPrice.TextSize = 14";
Debug.ShouldStop(131072);
_lblprice.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 275;BA.debugLine="lblPrice.TextColor = Colors.RGB(0, 120, 0)  ' Gr";
Debug.ShouldStop(262144);
_lblprice.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 120)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 277;BA.debugLine="Dim lblCode As Label";
Debug.ShouldStop(1048576);
_lblcode = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblCode", _lblcode);
 BA.debugLineNum = 278;BA.debugLine="lblCode.Initialize(\"\")";
Debug.ShouldStop(2097152);
_lblcode.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 279;BA.debugLine="lblCode.Text = \"Code: \" & rs.GetString(\"item_cod";
Debug.ShouldStop(4194304);
_lblcode.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Code: "),_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("item_code"))))));
 BA.debugLineNum = 280;BA.debugLine="lblCode.TextSize = 12";
Debug.ShouldStop(8388608);
_lblcode.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 281;BA.debugLine="lblCode.TextColor = Colors.Gray";
Debug.ShouldStop(16777216);
_lblcode.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 283;BA.debugLine="pnl.AddView(lblName, 10dip, 5dip, svInventory.Wi";
Debug.ShouldStop(67108864);
_pnl.runVoidMethod ("AddView",(Object)((_lblname.getObject())),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(RemoteObject.solve(new RemoteObject[] {ordertakerdashboard.mostCurrent._svinventory.runMethod(true,"getWidth"),ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 BA.debugLineNum = 284;BA.debugLine="pnl.AddView(lblPrice, 10dip, 30dip, svInventory.";
Debug.ShouldStop(134217728);
_pnl.runVoidMethod ("AddView",(Object)((_lblprice.getObject())),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(RemoteObject.solve(new RemoteObject[] {ordertakerdashboard.mostCurrent._svinventory.runMethod(true,"getWidth"),ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 285;BA.debugLine="pnl.AddView(lblCode, 10dip, 50dip, svInventory.W";
Debug.ShouldStop(268435456);
_pnl.runVoidMethod ("AddView",(Object)((_lblcode.getObject())),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(RemoteObject.solve(new RemoteObject[] {ordertakerdashboard.mostCurrent._svinventory.runMethod(true,"getWidth"),ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))));
 BA.debugLineNum = 287;BA.debugLine="svInventory.Panel.AddView(pnl, 0, top, svInvento";
Debug.ShouldStop(1073741824);
ordertakerdashboard.mostCurrent._svinventory.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(ordertakerdashboard.mostCurrent._svinventory.runMethod(true,"getWidth")),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))));
 BA.debugLineNum = 288;BA.debugLine="top = top + 80dip";
Debug.ShouldStop(-2147483648);
_top = RemoteObject.solve(new RemoteObject[] {_top,ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))}, "+",1, 1);Debug.locals.put("top", _top);
 }
;
 BA.debugLineNum = 290;BA.debugLine="rs.Close";
Debug.ShouldStop(2);
_rs.runVoidMethod ("Close");
 BA.debugLineNum = 292;BA.debugLine="svInventory.Panel.Height = top";
Debug.ShouldStop(8);
ordertakerdashboard.mostCurrent._svinventory.runMethod(false,"getPanel").runMethod(true,"setHeight",_top);
 BA.debugLineNum = 293;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadorders() throws Exception{
try {
		Debug.PushSubsStack("LoadOrders (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,100);
if (RapidSub.canDelegate("loadorders")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","loadorders");}
RemoteObject _rsorders = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblorderid = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lbltotal = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 100;BA.debugLine="Private Sub LoadOrders";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="clvContentOrders.Clear";
Debug.ShouldStop(16);
ordertakerdashboard.mostCurrent._clvcontentorders.runVoidMethod ("_clear");
 BA.debugLineNum = 102;BA.debugLine="Dim rsOrders As ResultSet = Main.SQLProducts.Exec";
Debug.ShouldStop(32);
_rsorders = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rsorders = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), ordertakerdashboard.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM orders ORDER BY order_id DESC"))));Debug.locals.put("rsOrders", _rsorders);Debug.locals.put("rsOrders", _rsorders);
 BA.debugLineNum = 103;BA.debugLine="Do While rsOrders.NextRow";
Debug.ShouldStop(64);
while (_rsorders.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 104;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(128);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 105;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(256);
_pnl.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 106;BA.debugLine="pnl.SetLayout(0, 0, clvContentOrders.AsView.Widt";
Debug.ShouldStop(512);
_pnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(ordertakerdashboard.mostCurrent._clvcontentorders.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))));
 BA.debugLineNum = 108;BA.debugLine="Dim lblOrderID As Label";
Debug.ShouldStop(2048);
_lblorderid = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblOrderID", _lblorderid);
 BA.debugLineNum = 109;BA.debugLine="lblOrderID.Initialize(\"\")";
Debug.ShouldStop(4096);
_lblorderid.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 110;BA.debugLine="lblOrderID.Text = \"Order #\" & rsOrders.GetInt(\"o";
Debug.ShouldStop(8192);
_lblorderid.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Order #"),_rsorders.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("order_id"))))));
 BA.debugLineNum = 111;BA.debugLine="lblOrderID.TextSize = 16";
Debug.ShouldStop(16384);
_lblorderid.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 112;BA.debugLine="lblOrderID.SetLayout(10dip, 5dip, 50%x, 25dip)";
Debug.ShouldStop(32768);
_lblorderid.runVoidMethod ("SetLayout",(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),ordertakerdashboard.mostCurrent.activityBA)),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 BA.debugLineNum = 114;BA.debugLine="Dim lblTotal As Label";
Debug.ShouldStop(131072);
_lbltotal = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblTotal", _lbltotal);
 BA.debugLineNum = 115;BA.debugLine="lblTotal.Initialize(\"\")";
Debug.ShouldStop(262144);
_lbltotal.runVoidMethod ("Initialize",ordertakerdashboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 116;BA.debugLine="lblTotal.Text = \"Total: ₱\" & rsOrders.GetDouble(";
Debug.ShouldStop(524288);
_lbltotal.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Total: ₱"),_rsorders.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("total_amount"))))));
 BA.debugLineNum = 117;BA.debugLine="lblTotal.SetLayout(10dip, 30dip, 50%x, 25dip)";
Debug.ShouldStop(1048576);
_lbltotal.runVoidMethod ("SetLayout",(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),ordertakerdashboard.mostCurrent.activityBA)),(Object)(ordertakerdashboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 BA.debugLineNum = 119;BA.debugLine="pnl.AddView(lblOrderID, lblOrderID.Left, lblOrde";
Debug.ShouldStop(4194304);
_pnl.runVoidMethod ("AddView",(Object)((_lblorderid.getObject())),(Object)(_lblorderid.runMethod(true,"getLeft")),(Object)(_lblorderid.runMethod(true,"getTop")),(Object)(_lblorderid.runMethod(true,"getWidth")),(Object)(_lblorderid.runMethod(true,"getHeight")));
 BA.debugLineNum = 120;BA.debugLine="pnl.AddView(lblTotal, lblTotal.Left, lblTotal.To";
Debug.ShouldStop(8388608);
_pnl.runVoidMethod ("AddView",(Object)((_lbltotal.getObject())),(Object)(_lbltotal.runMethod(true,"getLeft")),(Object)(_lbltotal.runMethod(true,"getTop")),(Object)(_lbltotal.runMethod(true,"getWidth")),(Object)(_lbltotal.runMethod(true,"getHeight")));
 BA.debugLineNum = 122;BA.debugLine="clvContentOrders.Add(pnl, rsOrders.GetInt(\"order";
Debug.ShouldStop(33554432);
ordertakerdashboard.mostCurrent._clvcontentorders.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _pnl.getObject()),(Object)((_rsorders.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("order_id"))))));
 }
;
 BA.debugLineNum = 124;BA.debugLine="rsOrders.Close";
Debug.ShouldStop(134217728);
_rsorders.runVoidMethod ("Close");
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnldash_click() throws Exception{
try {
		Debug.PushSubsStack("pnlDash_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,71);
if (RapidSub.canDelegate("pnldash_click")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","pnldash_click");}
 BA.debugLineNum = 71;BA.debugLine="Private Sub pnlDash_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="ShowPanel(pnlContentDash)";
Debug.ShouldStop(128);
_showpanel(ordertakerdashboard.mostCurrent._pnlcontentdash);
 BA.debugLineNum = 73;BA.debugLine="UpdateDashboardStatus";
Debug.ShouldStop(256);
_updatedashboardstatus();
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnldim_click() throws Exception{
try {
		Debug.PushSubsStack("pnlDim_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,139);
if (RapidSub.canDelegate("pnldim_click")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","pnldim_click");}
 BA.debugLineNum = 139;BA.debugLine="Private Sub pnlDim_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlhistory_click() throws Exception{
try {
		Debug.PushSubsStack("pnlHistory_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,87);
if (RapidSub.canDelegate("pnlhistory_click")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","pnlhistory_click");}
 BA.debugLineNum = 87;BA.debugLine="Private Sub pnlHistory_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="ShowPanel(pnlContentHistory)";
Debug.ShouldStop(8388608);
_showpanel(ordertakerdashboard.mostCurrent._pnlcontenthistory);
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlinventory_click() throws Exception{
try {
		Debug.PushSubsStack("pnlInventory_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,82);
if (RapidSub.canDelegate("pnlinventory_click")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","pnlinventory_click");}
 BA.debugLineNum = 82;BA.debugLine="Private Sub pnlInventory_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="ShowPanel(pnlContentInventory)";
Debug.ShouldStop(262144);
_showpanel(ordertakerdashboard.mostCurrent._pnlcontentinventory);
 BA.debugLineNum = 84;BA.debugLine="LoadInventoryItems";
Debug.ShouldStop(524288);
_loadinventoryitems();
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlorders_click() throws Exception{
try {
		Debug.PushSubsStack("pnlOrders_Click (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,76);
if (RapidSub.canDelegate("pnlorders_click")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","pnlorders_click");}
 BA.debugLineNum = 76;BA.debugLine="Private Sub pnlOrders_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="ShowPanel(pnlContentOrders)";
Debug.ShouldStop(4096);
_showpanel(ordertakerdashboard.mostCurrent._pnlcontentorders);
 BA.debugLineNum = 78;BA.debugLine="bttnAddOrder.Visible = True";
Debug.ShouldStop(8192);
ordertakerdashboard.mostCurrent._bttnaddorder.runMethod(true,"setVisible",ordertakerdashboard.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 79;BA.debugLine="bttnAddOrder.BringToFront";
Debug.ShouldStop(16384);
ordertakerdashboard.mostCurrent._bttnaddorder.runVoidMethod ("BringToFront");
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
ordertakerdashboard._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showpanel(RemoteObject _paneltoshow) throws Exception{
try {
		Debug.PushSubsStack("ShowPanel (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,62);
if (RapidSub.canDelegate("showpanel")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","showpanel", _paneltoshow);}
Debug.locals.put("panelToShow", _paneltoshow);
 BA.debugLineNum = 62;BA.debugLine="Private Sub ShowPanel(panelToShow As Panel)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="pnlContentDash.Visible = False";
Debug.ShouldStop(1073741824);
ordertakerdashboard.mostCurrent._pnlcontentdash.runMethod(true,"setVisible",ordertakerdashboard.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 64;BA.debugLine="pnlContentOrders.Visible = False";
Debug.ShouldStop(-2147483648);
ordertakerdashboard.mostCurrent._pnlcontentorders.runMethod(true,"setVisible",ordertakerdashboard.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 65;BA.debugLine="pnlContentInventory.Visible = False";
Debug.ShouldStop(1);
ordertakerdashboard.mostCurrent._pnlcontentinventory.runMethod(true,"setVisible",ordertakerdashboard.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 66;BA.debugLine="pnlContentHistory.Visible = False";
Debug.ShouldStop(2);
ordertakerdashboard.mostCurrent._pnlcontenthistory.runMethod(true,"setVisible",ordertakerdashboard.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 68;BA.debugLine="panelToShow.Visible = True";
Debug.ShouldStop(8);
_paneltoshow.runMethod(true,"setVisible",ordertakerdashboard.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _updatedashboardstatus() throws Exception{
try {
		Debug.PushSubsStack("UpdateDashboardStatus (ordertakerdashboard) ","ordertakerdashboard",3,ordertakerdashboard.mostCurrent.activityBA,ordertakerdashboard.mostCurrent,301);
if (RapidSub.canDelegate("updatedashboardstatus")) { return b4a.OrderTakerTest1.ordertakerdashboard.remoteMe.runUserSub(false, "ordertakerdashboard","updatedashboardstatus");}
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _itemcount = RemoteObject.createImmutable(0);
RemoteObject _minutesago = RemoteObject.createImmutable(0L);
RemoteObject _timeago = RemoteObject.createImmutable("");
RemoteObject _hoursago = RemoteObject.createImmutable(0);
RemoteObject _daysago = RemoteObject.createImmutable(0);
RemoteObject _rsorders = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _pendingcount = RemoteObject.createImmutable(0);
 BA.debugLineNum = 301;BA.debugLine="Private Sub UpdateDashboardStatus";
Debug.ShouldStop(4096);
 BA.debugLineNum = 303;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery(";
Debug.ShouldStop(16384);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), ordertakerdashboard.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT COUNT(*) as count FROM items WHERE is_active = 1"))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 304;BA.debugLine="rs.NextRow";
Debug.ShouldStop(32768);
_rs.runVoidMethod ("NextRow");
 BA.debugLineNum = 305;BA.debugLine="Dim itemCount As Int = rs.GetInt(\"count\")";
Debug.ShouldStop(65536);
_itemcount = _rs.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("count")));Debug.locals.put("itemCount", _itemcount);Debug.locals.put("itemCount", _itemcount);
 BA.debugLineNum = 306;BA.debugLine="rs.Close";
Debug.ShouldStop(131072);
_rs.runVoidMethod ("Close");
 BA.debugLineNum = 308;BA.debugLine="If itemCount > 0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",_itemcount,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 310;BA.debugLine="If Main.ITEMS_LAST_SYNC > 0 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean(">",ordertakerdashboard.mostCurrent._main._items_last_sync /*RemoteObject*/ ,BA.numberCast(long.class, 0))) { 
 BA.debugLineNum = 312;BA.debugLine="Dim minutesAgo As Long = (DateTime.Now - Main.I";
Debug.ShouldStop(8388608);
_minutesago = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {ordertakerdashboard.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"),ordertakerdashboard.mostCurrent._main._items_last_sync /*RemoteObject*/ }, "-",1, 2)),ordertakerdashboard.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "/",0, 0));Debug.locals.put("minutesAgo", _minutesago);Debug.locals.put("minutesAgo", _minutesago);
 BA.debugLineNum = 313;BA.debugLine="Dim timeAgo As String";
Debug.ShouldStop(16777216);
_timeago = RemoteObject.createImmutable("");Debug.locals.put("timeAgo", _timeago);
 BA.debugLineNum = 315;BA.debugLine="If minutesAgo < 1 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("<",_minutesago,BA.numberCast(long.class, 1))) { 
 BA.debugLineNum = 316;BA.debugLine="timeAgo = \"Just now\"";
Debug.ShouldStop(134217728);
_timeago = BA.ObjectToString("Just now");Debug.locals.put("timeAgo", _timeago);
 }else 
{ BA.debugLineNum = 317;BA.debugLine="Else If minutesAgo < 60 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("<",_minutesago,BA.numberCast(long.class, 60))) { 
 BA.debugLineNum = 318;BA.debugLine="timeAgo = minutesAgo & \" minutes ago\"";
Debug.ShouldStop(536870912);
_timeago = RemoteObject.concat(_minutesago,RemoteObject.createImmutable(" minutes ago"));Debug.locals.put("timeAgo", _timeago);
 }else 
{ BA.debugLineNum = 319;BA.debugLine="Else If minutesAgo < 1440 Then  ' Less than 24";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("<",_minutesago,BA.numberCast(long.class, 1440))) { 
 BA.debugLineNum = 320;BA.debugLine="Dim hoursAgo As Int = minutesAgo / 60";
Debug.ShouldStop(-2147483648);
_hoursago = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_minutesago,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("hoursAgo", _hoursago);Debug.locals.put("hoursAgo", _hoursago);
 BA.debugLineNum = 321;BA.debugLine="timeAgo = hoursAgo & \" hours ago\"";
Debug.ShouldStop(1);
_timeago = RemoteObject.concat(_hoursago,RemoteObject.createImmutable(" hours ago"));Debug.locals.put("timeAgo", _timeago);
 }else {
 BA.debugLineNum = 323;BA.debugLine="Dim daysAgo As Int = minutesAgo / 1440";
Debug.ShouldStop(4);
_daysago = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_minutesago,RemoteObject.createImmutable(1440)}, "/",0, 0));Debug.locals.put("daysAgo", _daysago);Debug.locals.put("daysAgo", _daysago);
 BA.debugLineNum = 324;BA.debugLine="timeAgo = daysAgo & \" days ago\"";
Debug.ShouldStop(8);
_timeago = RemoteObject.concat(_daysago,RemoteObject.createImmutable(" days ago"));Debug.locals.put("timeAgo", _timeago);
 }}}
;
 BA.debugLineNum = 327;BA.debugLine="lblCacheInfo.Text = \"📦 \" & itemCount & \" produ";
Debug.ShouldStop(64);
ordertakerdashboard.mostCurrent._lblcacheinfo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("📦 "),_itemcount,RemoteObject.createImmutable(" products cached | Last sync: "),_timeago)));
 BA.debugLineNum = 328;BA.debugLine="lblCacheInfo.TextColor = Colors.RGB(0, 100, 0)";
Debug.ShouldStop(128);
ordertakerdashboard.mostCurrent._lblcacheinfo.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 329;BA.debugLine="lblFetchStatus.Text = \"✓ Ready to take orders\"";
Debug.ShouldStop(256);
ordertakerdashboard.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence("✓ Ready to take orders"));
 BA.debugLineNum = 330;BA.debugLine="lblFetchStatus.TextColor = Colors.RGB(0, 150, 0";
Debug.ShouldStop(512);
ordertakerdashboard.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0))));
 }else {
 BA.debugLineNum = 332;BA.debugLine="lblCacheInfo.Text = \"📦 \" & itemCount & \" produ";
Debug.ShouldStop(2048);
ordertakerdashboard.mostCurrent._lblcacheinfo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("📦 "),_itemcount,RemoteObject.createImmutable(" products cached (sync time unknown)"))));
 BA.debugLineNum = 333;BA.debugLine="lblCacheInfo.TextColor = Colors.Gray";
Debug.ShouldStop(4096);
ordertakerdashboard.mostCurrent._lblcacheinfo.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 };
 }else {
 BA.debugLineNum = 336;BA.debugLine="lblCacheInfo.Text = \"⚠ No products synced yet\"";
Debug.ShouldStop(32768);
ordertakerdashboard.mostCurrent._lblcacheinfo.runMethod(true,"setText",BA.ObjectToCharSequence("⚠ No products synced yet"));
 BA.debugLineNum = 337;BA.debugLine="lblCacheInfo.TextColor = Colors.RGB(200, 100, 0)";
Debug.ShouldStop(65536);
ordertakerdashboard.mostCurrent._lblcacheinfo.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 338;BA.debugLine="lblFetchStatus.Text = \"Tap button above to sync";
Debug.ShouldStop(131072);
ordertakerdashboard.mostCurrent._lblfetchstatus.runMethod(true,"setText",BA.ObjectToCharSequence("Tap button above to sync products"));
 BA.debugLineNum = 339;BA.debugLine="lblFetchStatus.TextColor = Colors.Gray";
Debug.ShouldStop(262144);
ordertakerdashboard.mostCurrent._lblfetchstatus.runMethod(true,"setTextColor",ordertakerdashboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 };
 BA.debugLineNum = 343;BA.debugLine="Dim rsOrders As ResultSet = Main.SQLProducts.Exec";
Debug.ShouldStop(4194304);
_rsorders = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rsorders = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), ordertakerdashboard.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT COUNT(*) as count FROM orders WHERE status = 'Pending'"))));Debug.locals.put("rsOrders", _rsorders);Debug.locals.put("rsOrders", _rsorders);
 BA.debugLineNum = 344;BA.debugLine="rsOrders.NextRow";
Debug.ShouldStop(8388608);
_rsorders.runVoidMethod ("NextRow");
 BA.debugLineNum = 345;BA.debugLine="Dim pendingCount As Int = rsOrders.GetInt(\"count\"";
Debug.ShouldStop(16777216);
_pendingcount = _rsorders.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("count")));Debug.locals.put("pendingCount", _pendingcount);Debug.locals.put("pendingCount", _pendingcount);
 BA.debugLineNum = 346;BA.debugLine="rsOrders.Close";
Debug.ShouldStop(33554432);
_rsorders.runVoidMethod ("Close");
 BA.debugLineNum = 348;BA.debugLine="If pendingCount > 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",_pendingcount,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 349;BA.debugLine="ToastMessageShow(\"You have \" & pendingCount & \"";
Debug.ShouldStop(268435456);
ordertakerdashboard.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("You have "),_pendingcount,RemoteObject.createImmutable(" pending orders to sync")))),(Object)(ordertakerdashboard.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 351;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}