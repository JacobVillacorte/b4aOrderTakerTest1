package b4a.OrderTakerTest1;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class addorderactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"addOrderActivity\")";
Debug.ShouldStop(64);
addorderactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("addOrderActivity")),addorderactivity.mostCurrent.activityBA);
 BA.debugLineNum = 41;BA.debugLine="CartItems.Initialize";
Debug.ShouldStop(256);
addorderactivity.mostCurrent._cartitems.runVoidMethod ("Initialize");
 BA.debugLineNum = 43;BA.debugLine="bttnPurchaseNow.Enabled = False";
Debug.ShouldStop(1024);
addorderactivity.mostCurrent._bttnpurchasenow.runMethod(true,"setEnabled",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 44;BA.debugLine="bttnPurchaseNow.Color = Colors.ARGB(80, 0, 0, 255";
Debug.ShouldStop(2048);
addorderactivity.mostCurrent._bttnpurchasenow.runVoidMethod ("setColor",addorderactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 80)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 46;BA.debugLine="LoadProducts";
Debug.ShouldStop(8192);
_loadproducts();
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Pause (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,52);
if (RapidSub.canDelegate("activity_pause")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Activity_Resume (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,49);
if (RapidSub.canDelegate("activity_resume")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","activity_resume");}
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
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
public static RemoteObject  _bttnadd_click() throws Exception{
try {
		Debug.PushSubsStack("bttnAdd_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,136);
if (RapidSub.canDelegate("bttnadd_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","bttnadd_click");}
RemoteObject _currentqty = RemoteObject.createImmutable(0);
 BA.debugLineNum = 136;BA.debugLine="Private Sub bttnAdd_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="Dim currentQty As Int = lblQuantityValue.Text";
Debug.ShouldStop(256);
_currentqty = BA.numberCast(int.class, addorderactivity.mostCurrent._lblquantityvalue.runMethod(true,"getText"));Debug.locals.put("currentQty", _currentqty);Debug.locals.put("currentQty", _currentqty);
 BA.debugLineNum = 138;BA.debugLine="If currentQty < 999 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("<",_currentqty,BA.numberCast(double.class, 999))) { 
 BA.debugLineNum = 139;BA.debugLine="lblQuantityValue.Text = (currentQty + 1)";
Debug.ShouldStop(1024);
addorderactivity.mostCurrent._lblquantityvalue.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.solve(new RemoteObject[] {_currentqty,RemoteObject.createImmutable(1)}, "+",1, 1))));
 }else {
 BA.debugLineNum = 141;BA.debugLine="ToastMessageShow(\"Maximum quantity is 999\", Fals";
Debug.ShouldStop(4096);
addorderactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Maximum quantity is 999")),(Object)(addorderactivity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bttnaddorderactivity_click() throws Exception{
try {
		Debug.PushSubsStack("bttnAddOrderActivity_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,58);
if (RapidSub.canDelegate("bttnaddorderactivity_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","bttnaddorderactivity_click");}
 BA.debugLineNum = 58;BA.debugLine="Private Sub bttnAddOrderActivity_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="pnlDim.Visible = True";
Debug.ShouldStop(67108864);
addorderactivity.mostCurrent._pnldim.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 60;BA.debugLine="pnlSelectItems.Visible = True";
Debug.ShouldStop(134217728);
addorderactivity.mostCurrent._pnlselectitems.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 61;BA.debugLine="pnlDim.BringToFront";
Debug.ShouldStop(268435456);
addorderactivity.mostCurrent._pnldim.runVoidMethod ("BringToFront");
 BA.debugLineNum = 62;BA.debugLine="pnlSelectItems.BringToFront";
Debug.ShouldStop(536870912);
addorderactivity.mostCurrent._pnlselectitems.runVoidMethod ("BringToFront");
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bttnaddtocartqty_click() throws Exception{
try {
		Debug.PushSubsStack("bttnAddToCartQty_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,146);
if (RapidSub.canDelegate("bttnaddtocartqty_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","bttnaddtocartqty_click");}
RemoteObject _quantity = RemoteObject.createImmutable(0);
int _i = 0;
 BA.debugLineNum = 146;BA.debugLine="Private Sub bttnAddToCartQty_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="Dim quantity As Int = lblQuantityValue.Text";
Debug.ShouldStop(262144);
_quantity = BA.numberCast(int.class, addorderactivity.mostCurrent._lblquantityvalue.runMethod(true,"getText"));Debug.locals.put("quantity", _quantity);Debug.locals.put("quantity", _quantity);
 BA.debugLineNum = 150;BA.debugLine="For i = 1 To quantity";
Debug.ShouldStop(2097152);
{
final int step2 = 1;
final int limit2 = _quantity.<Integer>get().intValue();
_i = 1 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 151;BA.debugLine="CartItems.Add(SelectedItemID)";
Debug.ShouldStop(4194304);
addorderactivity.mostCurrent._cartitems.runVoidMethod ("Add",(Object)((addorderactivity._selecteditemid)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 154;BA.debugLine="RefreshCartSummary";
Debug.ShouldStop(33554432);
_refreshcartsummary();
 BA.debugLineNum = 155;BA.debugLine="bttnPurchaseNow.Enabled = True";
Debug.ShouldStop(67108864);
addorderactivity.mostCurrent._bttnpurchasenow.runMethod(true,"setEnabled",addorderactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 156;BA.debugLine="bttnPurchaseNow.Color = Colors.Blue";
Debug.ShouldStop(134217728);
addorderactivity.mostCurrent._bttnpurchasenow.runVoidMethod ("setColor",addorderactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 158;BA.debugLine="ToastMessageShow(\"Added \" & quantity & \"x \" & Sel";
Debug.ShouldStop(536870912);
addorderactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Added "),_quantity,RemoteObject.createImmutable("x "),addorderactivity.mostCurrent._selecteditemname))),(Object)(addorderactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 161;BA.debugLine="pnlQuantity.Visible = False";
Debug.ShouldStop(1);
addorderactivity.mostCurrent._pnlquantity.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 162;BA.debugLine="pnlDim.Visible = False";
Debug.ShouldStop(2);
addorderactivity.mostCurrent._pnldim.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 163;BA.debugLine="pnlSelectItems.Visible = False";
Debug.ShouldStop(4);
addorderactivity.mostCurrent._pnlselectitems.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bttncancelqty_click() throws Exception{
try {
		Debug.PushSubsStack("bttnCancelQty_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,167);
if (RapidSub.canDelegate("bttncancelqty_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","bttncancelqty_click");}
 BA.debugLineNum = 167;BA.debugLine="Private Sub bttnCancelQty_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="pnlQuantity.Visible = False";
Debug.ShouldStop(128);
addorderactivity.mostCurrent._pnlquantity.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 170;BA.debugLine="pnlDim.Visible = False";
Debug.ShouldStop(512);
addorderactivity.mostCurrent._pnldim.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bttnminus_click() throws Exception{
try {
		Debug.PushSubsStack("bttnMinus_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,126);
if (RapidSub.canDelegate("bttnminus_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","bttnminus_click");}
RemoteObject _currentqty = RemoteObject.createImmutable(0);
 BA.debugLineNum = 126;BA.debugLine="Private Sub bttnMinus_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 127;BA.debugLine="Dim currentQty As Int = lblQuantityValue.Text";
Debug.ShouldStop(1073741824);
_currentqty = BA.numberCast(int.class, addorderactivity.mostCurrent._lblquantityvalue.runMethod(true,"getText"));Debug.locals.put("currentQty", _currentqty);Debug.locals.put("currentQty", _currentqty);
 BA.debugLineNum = 128;BA.debugLine="If currentQty > 1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",_currentqty,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 129;BA.debugLine="lblQuantityValue.Text = (currentQty - 1)";
Debug.ShouldStop(1);
addorderactivity.mostCurrent._lblquantityvalue.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.solve(new RemoteObject[] {_currentqty,RemoteObject.createImmutable(1)}, "-",1, 1))));
 }else {
 BA.debugLineNum = 131;BA.debugLine="ToastMessageShow(\"Minimum quantity is 1\", False)";
Debug.ShouldStop(4);
addorderactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Minimum quantity is 1")),(Object)(addorderactivity.mostCurrent.__c.getField(true,"False")));
 };
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
public static RemoteObject  _bttnpurchasenow_click() throws Exception{
try {
		Debug.PushSubsStack("bttnPurchaseNow_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,74);
if (RapidSub.canDelegate("bttnpurchasenow_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","bttnpurchasenow_click");}
 BA.debugLineNum = 74;BA.debugLine="Private Sub bttnPurchaseNow_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="If CartItems.Size = 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",addorderactivity.mostCurrent._cartitems.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 76;BA.debugLine="ToastMessageShow(\"Add items first\", True)";
Debug.ShouldStop(2048);
addorderactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Add items first")),(Object)(addorderactivity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 77;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 80;BA.debugLine="SaveOrderLocally";
Debug.ShouldStop(32768);
_saveorderlocally();
 BA.debugLineNum = 81;BA.debugLine="CartItems.Clear";
Debug.ShouldStop(65536);
addorderactivity.mostCurrent._cartitems.runVoidMethod ("Clear");
 BA.debugLineNum = 82;BA.debugLine="RefreshCartSummary";
Debug.ShouldStop(131072);
_refreshcartsummary();
 BA.debugLineNum = 83;BA.debugLine="bttnPurchaseNow.Color = Colors.ARGB(80, 200, 200,";
Debug.ShouldStop(262144);
addorderactivity.mostCurrent._bttnpurchasenow.runVoidMethod ("setColor",addorderactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 80)),(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 200))));
 BA.debugLineNum = 84;BA.debugLine="bttnPurchaseNow.Enabled = False";
Debug.ShouldStop(524288);
addorderactivity.mostCurrent._bttnpurchasenow.runMethod(true,"setEnabled",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 86;BA.debugLine="ToastMessageShow(\"Order added successfully\", Fals";
Debug.ShouldStop(2097152);
addorderactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Order added successfully")),(Object)(addorderactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 87;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4194304);
addorderactivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clvproducts_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("clvProducts_ItemClick (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,99);
if (RapidSub.canDelegate("clvproducts_itemclick")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","clvproducts_itemclick", _index, _value);}
RemoteObject _itemid = RemoteObject.createImmutable(0);
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 99;BA.debugLine="Private Sub clvProducts_ItemClick(Index As Int, Va";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="Dim itemID As Int = Value";
Debug.ShouldStop(8);
_itemid = BA.numberCast(int.class, _value);Debug.locals.put("itemID", _itemid);Debug.locals.put("itemID", _itemid);
 BA.debugLineNum = 103;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery2";
Debug.ShouldStop(64);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT * FROM items WHERE item_id=?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_itemid)}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 105;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(256);
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 107;BA.debugLine="SelectedItemID = itemID";
Debug.ShouldStop(1024);
addorderactivity._selecteditemid = _itemid;
 BA.debugLineNum = 108;BA.debugLine="SelectedItemName = rs.GetString(\"item_name\")";
Debug.ShouldStop(2048);
addorderactivity.mostCurrent._selecteditemname = _rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("item_name")));
 BA.debugLineNum = 109;BA.debugLine="SelectedItemPrice = rs.GetDouble(\"unit_price\")";
Debug.ShouldStop(4096);
addorderactivity._selecteditemprice = _rs.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("unit_price")));
 BA.debugLineNum = 112;BA.debugLine="lblSelectedItem.Text = SelectedItemName & Chr(10";
Debug.ShouldStop(32768);
addorderactivity.mostCurrent._lblselecteditem.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(addorderactivity.mostCurrent._selecteditemname,addorderactivity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable("₱"),addorderactivity._selecteditemprice)));
 BA.debugLineNum = 113;BA.debugLine="lblQuantityValue.Text = \"1\"  ' Reset to 1";
Debug.ShouldStop(65536);
addorderactivity.mostCurrent._lblquantityvalue.runMethod(true,"setText",BA.ObjectToCharSequence("1"));
 BA.debugLineNum = 116;BA.debugLine="pnlQuantity.Visible = True";
Debug.ShouldStop(524288);
addorderactivity.mostCurrent._pnlquantity.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 117;BA.debugLine="pnlQuantity.BringToFront";
Debug.ShouldStop(1048576);
addorderactivity.mostCurrent._pnlquantity.runVoidMethod ("BringToFront");
 BA.debugLineNum = 118;BA.debugLine="pnlDim.Visible = True";
Debug.ShouldStop(2097152);
addorderactivity.mostCurrent._pnldim.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 119;BA.debugLine="pnlDim.BringToFront";
Debug.ShouldStop(4194304);
addorderactivity.mostCurrent._pnldim.runVoidMethod ("BringToFront");
 BA.debugLineNum = 120;BA.debugLine="pnlQuantity.BringToFront  ' Make sure it's on to";
Debug.ShouldStop(8388608);
addorderactivity.mostCurrent._pnlquantity.runVoidMethod ("BringToFront");
 };
 BA.debugLineNum = 122;BA.debugLine="rs.Close";
Debug.ShouldStop(33554432);
_rs.runVoidMethod ("Close");
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _etsearchproducts_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("etSearchProducts_TextChanged (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,272);
if (RapidSub.canDelegate("etsearchproducts_textchanged")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","etsearchproducts_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 272;BA.debugLine="Private Sub etSearchProducts_TextChanged (Old As S";
Debug.ShouldStop(32768);
 BA.debugLineNum = 273;BA.debugLine="LoadProducts  ' Reload with filter";
Debug.ShouldStop(65536);
_loadproducts();
 BA.debugLineNum = 274;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
 //BA.debugLineNum = 11;BA.debugLine="Private CartItems As List";
addorderactivity.mostCurrent._cartitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 12;BA.debugLine="Private bttnAddOrderActivity As Button";
addorderactivity.mostCurrent._bttnaddorderactivity = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private bttnPurchaseNow As Button";
addorderactivity.mostCurrent._bttnpurchasenow = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private clvProducts As CustomListView";
addorderactivity.mostCurrent._clvproducts = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 15;BA.debugLine="Private etSearchProducts As EditText";
addorderactivity.mostCurrent._etsearchproducts = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private lblExitOrderActivity As Label";
addorderactivity.mostCurrent._lblexitorderactivity = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private lblExitSelectItems As Label";
addorderactivity.mostCurrent._lblexitselectitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lblTotalItems As Label";
addorderactivity.mostCurrent._lbltotalitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private lblTotalAmount As Label";
addorderactivity.mostCurrent._lbltotalamount = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private pnladdOrderActivityTop As Panel";
addorderactivity.mostCurrent._pnladdorderactivitytop = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pnladdOrderActivityWhole As Panel";
addorderactivity.mostCurrent._pnladdorderactivitywhole = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private pnlDim As Panel";
addorderactivity.mostCurrent._pnldim = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pnlSelectItems As Panel";
addorderactivity.mostCurrent._pnlselectitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private svCartSummary As ScrollView";
addorderactivity.mostCurrent._svcartsummary = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pnlQuantity As Panel";
addorderactivity.mostCurrent._pnlquantity = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lblQuantityTitle As Label";
addorderactivity.mostCurrent._lblquantitytitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private bttnCancelQty As Button";
addorderactivity.mostCurrent._bttncancelqty = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private lblSelectedItem As Label";
addorderactivity.mostCurrent._lblselecteditem = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private bttnMinus As Button";
addorderactivity.mostCurrent._bttnminus = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private lblQuantityValue As Label";
addorderactivity.mostCurrent._lblquantityvalue = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private bttnAdd As Button";
addorderactivity.mostCurrent._bttnadd = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private bttnAddToCartQty As Button";
addorderactivity.mostCurrent._bttnaddtocartqty = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private SelectedItemID As Int";
addorderactivity._selecteditemid = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 34;BA.debugLine="Private SelectedItemName As String";
addorderactivity.mostCurrent._selecteditemname = RemoteObject.createImmutable("");
 //BA.debugLineNum = 35;BA.debugLine="Private SelectedItemPrice As Double";
addorderactivity._selecteditemprice = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblexitorderactivity_click() throws Exception{
try {
		Debug.PushSubsStack("lblExitOrderActivity_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,70);
if (RapidSub.canDelegate("lblexitorderactivity_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","lblexitorderactivity_click");}
 BA.debugLineNum = 70;BA.debugLine="Private Sub lblExitOrderActivity_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="Activity.Finish";
Debug.ShouldStop(64);
addorderactivity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lblexitselectitems_click() throws Exception{
try {
		Debug.PushSubsStack("lblExitSelectItems_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,65);
if (RapidSub.canDelegate("lblexitselectitems_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","lblexitselectitems_click");}
 BA.debugLineNum = 65;BA.debugLine="Private Sub lblExitSelectItems_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="pnlDim.Visible = False";
Debug.ShouldStop(2);
addorderactivity.mostCurrent._pnldim.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 67;BA.debugLine="pnlSelectItems.Visible = False";
Debug.ShouldStop(4);
addorderactivity.mostCurrent._pnlselectitems.runMethod(true,"setVisible",addorderactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadproducts() throws Exception{
try {
		Debug.PushSubsStack("LoadProducts (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,276);
if (RapidSub.canDelegate("loadproducts")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","loadproducts");}
RemoteObject _searchtext = RemoteObject.createImmutable("");
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblprice = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblsku = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 276;BA.debugLine="Private Sub LoadProducts";
Debug.ShouldStop(524288);
 BA.debugLineNum = 277;BA.debugLine="clvProducts.Clear";
Debug.ShouldStop(1048576);
addorderactivity.mostCurrent._clvproducts.runVoidMethod ("_clear");
 BA.debugLineNum = 279;BA.debugLine="Dim searchText As String = etSearchProducts.Text.";
Debug.ShouldStop(4194304);
_searchtext = addorderactivity.mostCurrent._etsearchproducts.runMethod(true,"getText").runMethod(true,"trim").runMethod(true,"toLowerCase");Debug.locals.put("searchText", _searchtext);Debug.locals.put("searchText", _searchtext);
 BA.debugLineNum = 281;BA.debugLine="Dim query As String";
Debug.ShouldStop(16777216);
_query = RemoteObject.createImmutable("");Debug.locals.put("query", _query);
 BA.debugLineNum = 282;BA.debugLine="If searchText = \"\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_searchtext,BA.ObjectToString(""))) { 
 BA.debugLineNum = 284;BA.debugLine="query = \"SELECT * FROM items WHERE is_active = 1";
Debug.ShouldStop(134217728);
_query = BA.ObjectToString("SELECT * FROM items WHERE is_active = 1 ORDER BY item_name");Debug.locals.put("query", _query);
 }else {
 BA.debugLineNum = 287;BA.debugLine="query = \"SELECT * FROM items WHERE is_active = 1";
Debug.ShouldStop(1073741824);
_query = RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM items WHERE is_active = 1 AND (LOWER(item_name) LIKE '%"),_searchtext,RemoteObject.createImmutable("%' OR LOWER(item_code) LIKE '%"),_searchtext,RemoteObject.createImmutable("%') ORDER BY item_name"));Debug.locals.put("query", _query);
 };
 BA.debugLineNum = 290;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery(";
Debug.ShouldStop(2);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(_query)));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 292;BA.debugLine="If rs.RowCount = 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_rs.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 293;BA.debugLine="ToastMessageShow(\"No products found matching '\"";
Debug.ShouldStop(16);
addorderactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("No products found matching '"),_searchtext,RemoteObject.createImmutable("'")))),(Object)(addorderactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 294;BA.debugLine="rs.Close";
Debug.ShouldStop(32);
_rs.runVoidMethod ("Close");
 BA.debugLineNum = 295;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 298;BA.debugLine="Do While rs.NextRow";
Debug.ShouldStop(512);
while (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 299;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(1024);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 300;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(2048);
_pnl.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 301;BA.debugLine="pnl.SetLayout(0, 0, clvProducts.AsView.Width, 70";
Debug.ShouldStop(4096);
_pnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(addorderactivity.mostCurrent._clvproducts.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 303;BA.debugLine="Dim lblName As Label";
Debug.ShouldStop(16384);
_lblname = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblName", _lblname);
 BA.debugLineNum = 304;BA.debugLine="lblName.Initialize(\"\")";
Debug.ShouldStop(32768);
_lblname.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 305;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
Debug.ShouldStop(65536);
_lblname.runMethod(true,"setText",BA.ObjectToCharSequence(_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("item_name")))));
 BA.debugLineNum = 306;BA.debugLine="lblName.TextSize = 16";
Debug.ShouldStop(131072);
_lblname.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 307;BA.debugLine="lblName.SetLayout(10dip, 5dip, 70%x, 25dip)";
Debug.ShouldStop(262144);
_lblname.runVoidMethod ("SetLayout",(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),addorderactivity.mostCurrent.activityBA)),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 BA.debugLineNum = 309;BA.debugLine="Dim lblPrice As Label";
Debug.ShouldStop(1048576);
_lblprice = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblPrice", _lblprice);
 BA.debugLineNum = 310;BA.debugLine="lblPrice.Initialize(\"\")";
Debug.ShouldStop(2097152);
_lblprice.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 311;BA.debugLine="lblPrice.Text = \"₱\" & rs.GetDouble(\"unit_price\")";
Debug.ShouldStop(4194304);
_lblprice.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("₱"),_rs.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("unit_price"))))));
 BA.debugLineNum = 312;BA.debugLine="lblPrice.SetLayout(10dip, 30dip, 70%x, 20dip)";
Debug.ShouldStop(8388608);
_lblprice.runVoidMethod ("SetLayout",(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),addorderactivity.mostCurrent.activityBA)),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 314;BA.debugLine="Dim lblSku As Label";
Debug.ShouldStop(33554432);
_lblsku = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblSku", _lblsku);
 BA.debugLineNum = 315;BA.debugLine="lblSku.Initialize(\"\")";
Debug.ShouldStop(67108864);
_lblsku.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 316;BA.debugLine="lblSku.Text = \"SKU: \" & rs.GetString(\"item_code\"";
Debug.ShouldStop(134217728);
_lblsku.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("SKU: "),_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("item_code"))))));
 BA.debugLineNum = 317;BA.debugLine="lblSku.TextSize = 12";
Debug.ShouldStop(268435456);
_lblsku.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 318;BA.debugLine="lblSku.SetLayout(10dip, 50dip, 70%x, 15dip)";
Debug.ShouldStop(536870912);
_lblsku.runVoidMethod ("SetLayout",(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 70)),addorderactivity.mostCurrent.activityBA)),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))));
 BA.debugLineNum = 320;BA.debugLine="pnl.AddView(lblName, lblName.Left, lblName.Top,";
Debug.ShouldStop(-2147483648);
_pnl.runVoidMethod ("AddView",(Object)((_lblname.getObject())),(Object)(_lblname.runMethod(true,"getLeft")),(Object)(_lblname.runMethod(true,"getTop")),(Object)(_lblname.runMethod(true,"getWidth")),(Object)(_lblname.runMethod(true,"getHeight")));
 BA.debugLineNum = 321;BA.debugLine="pnl.AddView(lblPrice, lblPrice.Left, lblPrice.To";
Debug.ShouldStop(1);
_pnl.runVoidMethod ("AddView",(Object)((_lblprice.getObject())),(Object)(_lblprice.runMethod(true,"getLeft")),(Object)(_lblprice.runMethod(true,"getTop")),(Object)(_lblprice.runMethod(true,"getWidth")),(Object)(_lblprice.runMethod(true,"getHeight")));
 BA.debugLineNum = 322;BA.debugLine="pnl.AddView(lblSku, lblSku.Left, lblSku.Top, lbl";
Debug.ShouldStop(2);
_pnl.runVoidMethod ("AddView",(Object)((_lblsku.getObject())),(Object)(_lblsku.runMethod(true,"getLeft")),(Object)(_lblsku.runMethod(true,"getTop")),(Object)(_lblsku.runMethod(true,"getWidth")),(Object)(_lblsku.runMethod(true,"getHeight")));
 BA.debugLineNum = 324;BA.debugLine="clvProducts.Add(pnl, rs.GetInt(\"item_id\"))";
Debug.ShouldStop(8);
addorderactivity.mostCurrent._clvproducts.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _pnl.getObject()),(Object)((_rs.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("item_id"))))));
 }
;
 BA.debugLineNum = 326;BA.debugLine="rs.Close";
Debug.ShouldStop(32);
_rs.runVoidMethod ("Close");
 BA.debugLineNum = 327;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("pnlDim_Click (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,90);
if (RapidSub.canDelegate("pnldim_click")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","pnldim_click");}
 BA.debugLineNum = 90;BA.debugLine="Private Sub pnlDim_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
addorderactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _refreshcartsummary() throws Exception{
try {
		Debug.PushSubsStack("RefreshCartSummary (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,173);
if (RapidSub.canDelegate("refreshcartsummary")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","refreshcartsummary");}
RemoteObject _top = RemoteObject.createImmutable(0);
RemoteObject _totalamount = RemoteObject.createImmutable(0);
RemoteObject _itemquantities = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _itemid = RemoteObject.createImmutable(0);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _quantity = RemoteObject.createImmutable(0);
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblqty = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblprice = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _itemprice = RemoteObject.createImmutable(0);
RemoteObject _linetotal = RemoteObject.createImmutable(0);
 BA.debugLineNum = 173;BA.debugLine="Private Sub RefreshCartSummary";
Debug.ShouldStop(4096);
 BA.debugLineNum = 174;BA.debugLine="svCartSummary.Panel.RemoveAllViews";
Debug.ShouldStop(8192);
addorderactivity.mostCurrent._svcartsummary.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 175;BA.debugLine="Dim top As Int = 0";
Debug.ShouldStop(16384);
_top = BA.numberCast(int.class, 0);Debug.locals.put("top", _top);Debug.locals.put("top", _top);
 BA.debugLineNum = 176;BA.debugLine="Dim totalAmount As Double = 0";
Debug.ShouldStop(32768);
_totalamount = BA.numberCast(double.class, 0);Debug.locals.put("totalAmount", _totalamount);Debug.locals.put("totalAmount", _totalamount);
 BA.debugLineNum = 179;BA.debugLine="Dim itemQuantities As Map";
Debug.ShouldStop(262144);
_itemquantities = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("itemQuantities", _itemquantities);
 BA.debugLineNum = 180;BA.debugLine="itemQuantities.Initialize";
Debug.ShouldStop(524288);
_itemquantities.runVoidMethod ("Initialize");
 BA.debugLineNum = 182;BA.debugLine="For Each itemID As Int In CartItems";
Debug.ShouldStop(2097152);
{
final RemoteObject group6 = addorderactivity.mostCurrent._cartitems;
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_itemid = BA.numberCast(int.class, group6.runMethod(false,"Get",index6));Debug.locals.put("itemID", _itemid);
Debug.locals.put("itemID", _itemid);
 BA.debugLineNum = 183;BA.debugLine="If itemQuantities.ContainsKey(itemID) Then";
Debug.ShouldStop(4194304);
if (_itemquantities.runMethod(true,"ContainsKey",(Object)((_itemid))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 184;BA.debugLine="Dim count As Int = itemQuantities.Get(itemID)";
Debug.ShouldStop(8388608);
_count = BA.numberCast(int.class, _itemquantities.runMethod(false,"Get",(Object)((_itemid))));Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 185;BA.debugLine="itemQuantities.Put(itemID, count + 1)";
Debug.ShouldStop(16777216);
_itemquantities.runVoidMethod ("Put",(Object)((_itemid)),(Object)((RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1))));
 }else {
 BA.debugLineNum = 187;BA.debugLine="itemQuantities.Put(itemID, 1)";
Debug.ShouldStop(67108864);
_itemquantities.runVoidMethod ("Put",(Object)((_itemid)),(Object)(RemoteObject.createImmutable((1))));
 };
 }
}Debug.locals.put("itemID", _itemid);
;
 BA.debugLineNum = 192;BA.debugLine="For Each itemID As Int In itemQuantities.Keys";
Debug.ShouldStop(-2147483648);
{
final RemoteObject group14 = _itemquantities.runMethod(false,"Keys");
final int groupLen14 = group14.runMethod(true,"getSize").<Integer>get()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_itemid = BA.numberCast(int.class, group14.runMethod(false,"Get",index14));Debug.locals.put("itemID", _itemid);
Debug.locals.put("itemID", _itemid);
 BA.debugLineNum = 193;BA.debugLine="Dim quantity As Int = itemQuantities.Get(itemID)";
Debug.ShouldStop(1);
_quantity = BA.numberCast(int.class, _itemquantities.runMethod(false,"Get",(Object)((_itemid))));Debug.locals.put("quantity", _quantity);Debug.locals.put("quantity", _quantity);
 BA.debugLineNum = 195;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery";
Debug.ShouldStop(4);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT * FROM items WHERE item_id=?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_itemid)}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 196;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(8);
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 197;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(16);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 198;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(32);
_pnl.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 199;BA.debugLine="pnl.Color = Colors.White";
Debug.ShouldStop(64);
_pnl.runVoidMethod ("setColor",addorderactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 200;BA.debugLine="pnl.SetLayout(0, top, svCartSummary.Width, 65di";
Debug.ShouldStop(128);
_pnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(addorderactivity.mostCurrent._svcartsummary.runMethod(true,"getWidth")),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 65)))));
 BA.debugLineNum = 202;BA.debugLine="Dim lblName As Label";
Debug.ShouldStop(512);
_lblname = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblName", _lblname);
 BA.debugLineNum = 203;BA.debugLine="lblName.Initialize(\"\")";
Debug.ShouldStop(1024);
_lblname.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 204;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
Debug.ShouldStop(2048);
_lblname.runMethod(true,"setText",BA.ObjectToCharSequence(_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("item_name")))));
 BA.debugLineNum = 205;BA.debugLine="lblName.TextSize = 16";
Debug.ShouldStop(4096);
_lblname.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 206;BA.debugLine="lblName.TextColor = Colors.Black";
Debug.ShouldStop(8192);
_lblname.runMethod(true,"setTextColor",addorderactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 207;BA.debugLine="lblName.SetLayout(10dip, 5dip, 60%x, 25dip)";
Debug.ShouldStop(16384);
_lblname.runVoidMethod ("SetLayout",(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),addorderactivity.mostCurrent.activityBA)),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 BA.debugLineNum = 209;BA.debugLine="Dim lblQty As Label";
Debug.ShouldStop(65536);
_lblqty = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblQty", _lblqty);
 BA.debugLineNum = 210;BA.debugLine="lblQty.Initialize(\"\")";
Debug.ShouldStop(131072);
_lblqty.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 211;BA.debugLine="lblQty.Text = \"x\" & quantity";
Debug.ShouldStop(262144);
_lblqty.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("x"),_quantity)));
 BA.debugLineNum = 212;BA.debugLine="lblQty.TextSize = 14";
Debug.ShouldStop(524288);
_lblqty.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 213;BA.debugLine="lblQty.TextColor = Colors.Gray";
Debug.ShouldStop(1048576);
_lblqty.runMethod(true,"setTextColor",addorderactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 214;BA.debugLine="lblQty.SetLayout(10dip, 30dip, 30%x, 20dip)";
Debug.ShouldStop(2097152);
_lblqty.runVoidMethod ("SetLayout",(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),addorderactivity.mostCurrent.activityBA)),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 216;BA.debugLine="Dim lblPrice As Label";
Debug.ShouldStop(8388608);
_lblprice = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblPrice", _lblprice);
 BA.debugLineNum = 217;BA.debugLine="lblPrice.Initialize(\"\")";
Debug.ShouldStop(16777216);
_lblprice.runVoidMethod ("Initialize",addorderactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 218;BA.debugLine="Dim itemPrice As Double = rs.GetDouble(\"unit_pr";
Debug.ShouldStop(33554432);
_itemprice = _rs.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("unit_price")));Debug.locals.put("itemPrice", _itemprice);Debug.locals.put("itemPrice", _itemprice);
 BA.debugLineNum = 219;BA.debugLine="Dim lineTotal As Double = itemPrice * quantity";
Debug.ShouldStop(67108864);
_linetotal = RemoteObject.solve(new RemoteObject[] {_itemprice,_quantity}, "*",0, 0);Debug.locals.put("lineTotal", _linetotal);Debug.locals.put("lineTotal", _linetotal);
 BA.debugLineNum = 220;BA.debugLine="lblPrice.Text = \"₱\" & lineTotal";
Debug.ShouldStop(134217728);
_lblprice.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("₱"),_linetotal)));
 BA.debugLineNum = 221;BA.debugLine="lblPrice.TextSize = 16";
Debug.ShouldStop(268435456);
_lblprice.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 222;BA.debugLine="lblPrice.TextColor = Colors.RGB(0, 120, 0)";
Debug.ShouldStop(536870912);
_lblprice.runMethod(true,"setTextColor",addorderactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 120)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 223;BA.debugLine="lblPrice.Gravity = Gravity.RIGHT";
Debug.ShouldStop(1073741824);
_lblprice.runMethod(true,"setGravity",addorderactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"RIGHT"));
 BA.debugLineNum = 224;BA.debugLine="lblPrice.SetLayout(65%x, 5dip, 30%x, 25dip)";
Debug.ShouldStop(-2147483648);
_lblprice.runVoidMethod ("SetLayout",(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 65)),addorderactivity.mostCurrent.activityBA)),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),addorderactivity.mostCurrent.activityBA)),(Object)(addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 BA.debugLineNum = 226;BA.debugLine="pnl.AddView(lblName, lblName.Left, lblName.Top,";
Debug.ShouldStop(2);
_pnl.runVoidMethod ("AddView",(Object)((_lblname.getObject())),(Object)(_lblname.runMethod(true,"getLeft")),(Object)(_lblname.runMethod(true,"getTop")),(Object)(_lblname.runMethod(true,"getWidth")),(Object)(_lblname.runMethod(true,"getHeight")));
 BA.debugLineNum = 227;BA.debugLine="pnl.AddView(lblQty, lblQty.Left, lblQty.Top, lb";
Debug.ShouldStop(4);
_pnl.runVoidMethod ("AddView",(Object)((_lblqty.getObject())),(Object)(_lblqty.runMethod(true,"getLeft")),(Object)(_lblqty.runMethod(true,"getTop")),(Object)(_lblqty.runMethod(true,"getWidth")),(Object)(_lblqty.runMethod(true,"getHeight")));
 BA.debugLineNum = 228;BA.debugLine="pnl.AddView(lblPrice, lblPrice.Left, lblPrice.T";
Debug.ShouldStop(8);
_pnl.runVoidMethod ("AddView",(Object)((_lblprice.getObject())),(Object)(_lblprice.runMethod(true,"getLeft")),(Object)(_lblprice.runMethod(true,"getTop")),(Object)(_lblprice.runMethod(true,"getWidth")),(Object)(_lblprice.runMethod(true,"getHeight")));
 BA.debugLineNum = 230;BA.debugLine="svCartSummary.Panel.AddView(pnl, 0, top, pnl.Wi";
Debug.ShouldStop(32);
addorderactivity.mostCurrent._svcartsummary.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(_pnl.runMethod(true,"getWidth")),(Object)(_pnl.runMethod(true,"getHeight")));
 BA.debugLineNum = 231;BA.debugLine="top = top + pnl.Height + 3dip";
Debug.ShouldStop(64);
_top = RemoteObject.solve(new RemoteObject[] {_top,_pnl.runMethod(true,"getHeight"),addorderactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))}, "++",2, 1);Debug.locals.put("top", _top);
 BA.debugLineNum = 232;BA.debugLine="totalAmount = totalAmount + lineTotal";
Debug.ShouldStop(128);
_totalamount = RemoteObject.solve(new RemoteObject[] {_totalamount,_linetotal}, "+",1, 0);Debug.locals.put("totalAmount", _totalamount);
 };
 BA.debugLineNum = 234;BA.debugLine="rs.Close";
Debug.ShouldStop(512);
_rs.runVoidMethod ("Close");
 }
}Debug.locals.put("itemID", _itemid);
;
 BA.debugLineNum = 237;BA.debugLine="svCartSummary.Panel.Height = top";
Debug.ShouldStop(4096);
addorderactivity.mostCurrent._svcartsummary.runMethod(false,"getPanel").runMethod(true,"setHeight",_top);
 BA.debugLineNum = 238;BA.debugLine="lblTotalItems.Text = \"Items: \" & itemQuantities.S";
Debug.ShouldStop(8192);
addorderactivity.mostCurrent._lbltotalitems.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Items: "),_itemquantities.runMethod(true,"getSize"),RemoteObject.createImmutable(" types ("),addorderactivity.mostCurrent._cartitems.runMethod(true,"getSize"),RemoteObject.createImmutable(" total)"))));
 BA.debugLineNum = 239;BA.debugLine="lblTotalAmount.Text = \"Total: ₱\" & NumberFormat2(";
Debug.ShouldStop(16384);
addorderactivity.mostCurrent._lbltotalamount.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Total: ₱"),addorderactivity.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(_totalamount),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(addorderactivity.mostCurrent.__c.getField(true,"False"))))));
 BA.debugLineNum = 240;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _saveorderlocally() throws Exception{
try {
		Debug.PushSubsStack("SaveOrderLocally (addorderactivity) ","addorderactivity",4,addorderactivity.mostCurrent.activityBA,addorderactivity.mostCurrent,242);
if (RapidSub.canDelegate("saveorderlocally")) { return b4a.OrderTakerTest1.addorderactivity.remoteMe.runUserSub(false, "addorderactivity","saveorderlocally");}
RemoteObject _total = RemoteObject.createImmutable(0);
RemoteObject _productid = RemoteObject.createImmutable(0);
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _rsorder = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _orderid = RemoteObject.createImmutable(0);
RemoteObject _price = RemoteObject.createImmutable(0);
 BA.debugLineNum = 242;BA.debugLine="Private Sub SaveOrderLocally";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="Dim total As Double = 0";
Debug.ShouldStop(262144);
_total = BA.numberCast(double.class, 0);Debug.locals.put("total", _total);Debug.locals.put("total", _total);
 BA.debugLineNum = 244;BA.debugLine="For Each productID As Int In CartItems";
Debug.ShouldStop(524288);
{
final RemoteObject group2 = addorderactivity.mostCurrent._cartitems;
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_productid = BA.numberCast(int.class, group2.runMethod(false,"Get",index2));Debug.locals.put("productID", _productid);
Debug.locals.put("productID", _productid);
 BA.debugLineNum = 245;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery";
Debug.ShouldStop(1048576);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT * FROM items WHERE item_id=?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_productid)}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 246;BA.debugLine="If rs.NextRow Then total = total + rs.GetDouble(";
Debug.ShouldStop(2097152);
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
_total = RemoteObject.solve(new RemoteObject[] {_total,_rs.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("unit_price")))}, "+",1, 0);Debug.locals.put("total", _total);};
 BA.debugLineNum = 247;BA.debugLine="rs.Close";
Debug.ShouldStop(4194304);
_rs.runVoidMethod ("Close");
 }
}Debug.locals.put("productID", _productid);
;
 BA.debugLineNum = 251;BA.debugLine="Main.SQLProducts.ExecNonQuery2(\"INSERT INTO order";
Debug.ShouldStop(67108864);
addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO orders (vendor_id, date_created, status, total_amount) VALUES (?, ?, ?, ?)")),(Object)(addorderactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.NumberToString(1),BA.NumberToString(addorderactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")),BA.ObjectToString("Pending"),BA.NumberToString(_total)})))));
 BA.debugLineNum = 255;BA.debugLine="Dim rsOrder As ResultSet = Main.SQLProducts.ExecQ";
Debug.ShouldStop(1073741824);
_rsorder = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rsorder = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT last_insert_rowid() AS id"))));Debug.locals.put("rsOrder", _rsorder);Debug.locals.put("rsOrder", _rsorder);
 BA.debugLineNum = 256;BA.debugLine="rsOrder.NextRow";
Debug.ShouldStop(-2147483648);
_rsorder.runVoidMethod ("NextRow");
 BA.debugLineNum = 257;BA.debugLine="Dim orderID As Int = rsOrder.GetInt(\"id\")";
Debug.ShouldStop(1);
_orderid = _rsorder.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id")));Debug.locals.put("orderID", _orderid);Debug.locals.put("orderID", _orderid);
 BA.debugLineNum = 258;BA.debugLine="rsOrder.Close";
Debug.ShouldStop(2);
_rsorder.runVoidMethod ("Close");
 BA.debugLineNum = 261;BA.debugLine="For Each productID As Int In CartItems";
Debug.ShouldStop(16);
{
final RemoteObject group12 = addorderactivity.mostCurrent._cartitems;
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_productid = BA.numberCast(int.class, group12.runMethod(false,"Get",index12));Debug.locals.put("productID", _productid);
Debug.locals.put("productID", _productid);
 BA.debugLineNum = 262;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery";
Debug.ShouldStop(32);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT * FROM items WHERE item_id=?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_productid)}))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 263;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(64);
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 264;BA.debugLine="Dim price As Double = rs.GetDouble(\"unit_price\"";
Debug.ShouldStop(128);
_price = _rs.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("unit_price")));Debug.locals.put("price", _price);Debug.locals.put("price", _price);
 BA.debugLineNum = 265;BA.debugLine="Main.SQLProducts.ExecNonQuery2(\"INSERT INTO ord";
Debug.ShouldStop(256);
addorderactivity.mostCurrent._main._sqlproducts /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)")),(Object)(addorderactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.NumberToString(_orderid),BA.NumberToString(_productid),BA.NumberToString(1),BA.NumberToString(_price)})))));
 };
 BA.debugLineNum = 268;BA.debugLine="rs.Close";
Debug.ShouldStop(2048);
_rs.runVoidMethod ("Close");
 }
}Debug.locals.put("productID", _productid);
;
 BA.debugLineNum = 270;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}