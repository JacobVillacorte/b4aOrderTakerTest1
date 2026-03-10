package b4a.OrderTakerTest1;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class userorders_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,42);
if (RapidSub.canDelegate("activity_create")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","activity_create", _firsttime);}
int _i = 0;
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"userOrders\")";
Debug.ShouldStop(1024);
userorders.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("userOrders")),userorders.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="lblLoggedInUser.Text = \"Welcome, \" & Main.LoggedI";
Debug.ShouldStop(8192);
userorders.mostCurrent._lblloggedinuser.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Welcome, "),userorders.mostCurrent._main._loggedinuser /*RemoteObject*/ )));
 BA.debugLineNum = 52;BA.debugLine="SQLProducts.Initialize(File.DirInternal, \"product";
Debug.ShouldStop(524288);
userorders._sqlproducts.runVoidMethod ("Initialize",(Object)(userorders.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("productsTest1.db")),(Object)(userorders.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 55;BA.debugLine="ScrollView1.Panel.Width = ScrollView1.Width";
Debug.ShouldStop(4194304);
userorders.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setWidth",userorders.mostCurrent._scrollview1.runMethod(true,"getWidth"));
 BA.debugLineNum = 56;BA.debugLine="ScrollView1.Panel.Height = ScrollView1.Height   '";
Debug.ShouldStop(8388608);
userorders.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",userorders.mostCurrent._scrollview1.runMethod(true,"getHeight"));
 BA.debugLineNum = 60;BA.debugLine="svSelectItems = Null";
Debug.ShouldStop(134217728);
userorders.mostCurrent._svselectitems = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ScrollViewWrapper"), userorders.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 61;BA.debugLine="For i = 0 To pnlSelectItems.NumberOfViews - 1";
Debug.ShouldStop(268435456);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {userorders.mostCurrent._pnlselectitems.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 62;BA.debugLine="Dim v As View = pnlSelectItems.GetView(i)";
Debug.ShouldStop(536870912);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
_v = userorders.mostCurrent._pnlselectitems.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("v", _v);Debug.locals.put("v", _v);
 BA.debugLineNum = 63;BA.debugLine="If v Is ScrollView Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ScrollView"))) { 
 BA.debugLineNum = 64;BA.debugLine="svSelectItems = v";
Debug.ShouldStop(-2147483648);
userorders.mostCurrent._svselectitems = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ScrollViewWrapper"), _v.getObject());
 BA.debugLineNum = 65;BA.debugLine="Exit";
Debug.ShouldStop(1);
if (true) break;
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 69;BA.debugLine="If svSelectItems = Null Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("n",userorders.mostCurrent._svselectitems)) { 
 BA.debugLineNum = 70;BA.debugLine="Log(\"Error: svSelectItems not found inside pnlSe";
Debug.ShouldStop(32);
userorders.mostCurrent.__c.runVoidMethod ("LogImpl","23670044",RemoteObject.createImmutable("Error: svSelectItems not found inside pnlSelectItems!"),0);
 }else {
 BA.debugLineNum = 73;BA.debugLine="svSelectItems.Panel.Width = svSelectItems.Width";
Debug.ShouldStop(256);
userorders.mostCurrent._svselectitems.runMethod(false,"getPanel").runMethod(true,"setWidth",userorders.mostCurrent._svselectitems.runMethod(true,"getWidth"));
 BA.debugLineNum = 74;BA.debugLine="svSelectItems.Panel.Height = 10dip";
Debug.ShouldStop(512);
userorders.mostCurrent._svselectitems.runMethod(false,"getPanel").runMethod(true,"setHeight",userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))));
 };
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Pause (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,82);
if (RapidSub.canDelegate("activity_pause")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,78);
if (RapidSub.canDelegate("activity_resume")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","activity_resume");}
 BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
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
public static RemoteObject  _btnadditems_click() throws Exception{
try {
		Debug.PushSubsStack("btnAddItems_Click (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,181);
if (RapidSub.canDelegate("btnadditems_click")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","btnadditems_click");}
 BA.debugLineNum = 181;BA.debugLine="Private Sub btnAddItems_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 182;BA.debugLine="pnlDim.Visible = True";
Debug.ShouldStop(2097152);
userorders.mostCurrent._pnldim.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 183;BA.debugLine="pnlDim.BringToFront";
Debug.ShouldStop(4194304);
userorders.mostCurrent._pnldim.runVoidMethod ("BringToFront");
 BA.debugLineNum = 185;BA.debugLine="pnlSelectItems.Visible = True";
Debug.ShouldStop(16777216);
userorders.mostCurrent._pnlselectitems.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 186;BA.debugLine="pnlSelectItems.BringToFront";
Debug.ShouldStop(33554432);
userorders.mostCurrent._pnlselectitems.runVoidMethod ("BringToFront");
 BA.debugLineNum = 188;BA.debugLine="LoadProductsIntoSelectItems";
Debug.ShouldStop(134217728);
_loadproductsintoselectitems();
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnpurchasenow_click() throws Exception{
try {
		Debug.PushSubsStack("btnPurchaseNow_Click (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,199);
if (RapidSub.canDelegate("btnpurchasenow_click")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","btnpurchasenow_click");}
 BA.debugLineNum = 199;BA.debugLine="Private Sub btnPurchaseNow_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 201;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("bttnAddOrder_Click (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,163);
if (RapidSub.canDelegate("bttnaddorder_click")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","bttnaddorder_click");}
 BA.debugLineNum = 163;BA.debugLine="Private Sub bttnAddOrder_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="pnlDim.Visible = True";
Debug.ShouldStop(8);
userorders.mostCurrent._pnldim.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 165;BA.debugLine="pnlDim.BringToFront";
Debug.ShouldStop(16);
userorders.mostCurrent._pnldim.runVoidMethod ("BringToFront");
 BA.debugLineNum = 166;BA.debugLine="pnlAddOrderHomeTotal.Visible = True";
Debug.ShouldStop(32);
userorders.mostCurrent._pnladdorderhometotal.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 167;BA.debugLine="pnlAddOrderHomeTotal.BringToFront";
Debug.ShouldStop(64);
userorders.mostCurrent._pnladdorderhometotal.runVoidMethod ("BringToFront");
 BA.debugLineNum = 169;BA.debugLine="bttnAddOrder.Visible = False";
Debug.ShouldStop(256);
userorders.mostCurrent._bttnaddorder.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 170;BA.debugLine="lblExitAddOrderHome.Visible = True";
Debug.ShouldStop(512);
userorders.mostCurrent._lblexitaddorderhome.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 171;BA.debugLine="btnAddItems.Visible = True";
Debug.ShouldStop(1024);
userorders.mostCurrent._btnadditems.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 172;BA.debugLine="btnPurchaseNow.Visible = True";
Debug.ShouldStop(2048);
userorders.mostCurrent._btnpurchasenow.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createproductcard(RemoteObject _sku,RemoteObject _name,RemoteObject _price,RemoteObject _packnumber) throws Exception{
try {
		Debug.PushSubsStack("CreateProductCard (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,97);
if (RapidSub.canDelegate("createproductcard")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","createproductcard", _sku, _name, _price, _packnumber);}
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblsku = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblprice = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblpack = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("sku", _sku);
Debug.locals.put("name", _name);
Debug.locals.put("price", _price);
Debug.locals.put("packNumber", _packnumber);
 BA.debugLineNum = 97;BA.debugLine="Private Sub CreateProductCard(sku As String, name";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(2);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 99;BA.debugLine="pnl.Initialize(\"\")";
Debug.ShouldStop(4);
_pnl.runVoidMethod ("Initialize",userorders.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 100;BA.debugLine="pnl.Color = Colors.White";
Debug.ShouldStop(8);
_pnl.runVoidMethod ("setColor",userorders.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 104;BA.debugLine="Dim lblSKU As Label";
Debug.ShouldStop(128);
_lblsku = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblSKU", _lblsku);
 BA.debugLineNum = 105;BA.debugLine="lblSKU.Initialize(\"\")";
Debug.ShouldStop(256);
_lblsku.runVoidMethod ("Initialize",userorders.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 106;BA.debugLine="lblSKU.Text = \"SKU: \" & sku";
Debug.ShouldStop(512);
_lblsku.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("SKU: "),_sku)));
 BA.debugLineNum = 107;BA.debugLine="lblSKU.TextSize = 14";
Debug.ShouldStop(1024);
_lblsku.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 108;BA.debugLine="pnl.AddView(lblSKU, 10dip, 10dip, 200dip, 20dip)";
Debug.ShouldStop(2048);
_pnl.runVoidMethod ("AddView",(Object)((_lblsku.getObject())),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 111;BA.debugLine="Dim lblName As Label";
Debug.ShouldStop(16384);
_lblname = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblName", _lblname);
 BA.debugLineNum = 112;BA.debugLine="lblName.Initialize(\"\")";
Debug.ShouldStop(32768);
_lblname.runVoidMethod ("Initialize",userorders.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 113;BA.debugLine="lblName.Text = name";
Debug.ShouldStop(65536);
_lblname.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 114;BA.debugLine="lblName.TextSize = 16";
Debug.ShouldStop(131072);
_lblname.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 115;BA.debugLine="pnl.AddView(lblName, 10dip, 35dip, 200dip, 25dip)";
Debug.ShouldStop(262144);
_pnl.runVoidMethod ("AddView",(Object)((_lblname.getObject())),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))));
 BA.debugLineNum = 118;BA.debugLine="Dim lblPrice As Label";
Debug.ShouldStop(2097152);
_lblprice = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblPrice", _lblprice);
 BA.debugLineNum = 119;BA.debugLine="lblPrice.Initialize(\"\")";
Debug.ShouldStop(4194304);
_lblprice.runVoidMethod ("Initialize",userorders.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 120;BA.debugLine="lblPrice.Text = \"₱\" & price";
Debug.ShouldStop(8388608);
_lblprice.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("₱"),_price)));
 BA.debugLineNum = 121;BA.debugLine="lblPrice.TextSize = 14";
Debug.ShouldStop(16777216);
_lblprice.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 122;BA.debugLine="pnl.AddView(lblPrice, 10dip, 65dip, 200dip, 20dip";
Debug.ShouldStop(33554432);
_pnl.runVoidMethod ("AddView",(Object)((_lblprice.getObject())),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 65)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 125;BA.debugLine="Dim lblPack As Label";
Debug.ShouldStop(268435456);
_lblpack = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblPack", _lblpack);
 BA.debugLineNum = 126;BA.debugLine="lblPack.Initialize(\"\")";
Debug.ShouldStop(536870912);
_lblpack.runVoidMethod ("Initialize",userorders.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 127;BA.debugLine="lblPack.Text = \"Pack: \" & packNumber";
Debug.ShouldStop(1073741824);
_lblpack.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Pack: "),_packnumber)));
 BA.debugLineNum = 128;BA.debugLine="lblPack.TextSize = 14";
Debug.ShouldStop(-2147483648);
_lblpack.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 129;BA.debugLine="pnl.AddView(lblPack, 10dip, 90dip, 200dip, 20dip)";
Debug.ShouldStop(1);
_pnl.runVoidMethod ("AddView",(Object)((_lblpack.getObject())),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 131;BA.debugLine="pnl.Height = 120dip";
Debug.ShouldStop(4);
_pnl.runMethod(true,"setHeight",userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))));
 BA.debugLineNum = 132;BA.debugLine="Return pnl";
Debug.ShouldStop(8);
if (true) return _pnl;
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private Panel1 As Panel";
userorders.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private lbllogout As Label";
userorders.mostCurrent._lbllogout = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private lblperson As Label";
userorders.mostCurrent._lblperson = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private lblLoggedInUser As Label";
userorders.mostCurrent._lblloggedinuser = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private ScrollView1 As ScrollView";
userorders.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private pnlBottomNav As Panel";
userorders.mostCurrent._pnlbottomnav = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lblDash As Label";
userorders.mostCurrent._lbldash = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private lblDashIcon As Label";
userorders.mostCurrent._lbldashicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private lblHistory As Label";
userorders.mostCurrent._lblhistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lblHistoryIcon As Label";
userorders.mostCurrent._lblhistoryicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lblInventory As Label";
userorders.mostCurrent._lblinventory = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblInventoryIcon As Label";
userorders.mostCurrent._lblinventoryicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lblOrders As Label";
userorders.mostCurrent._lblorders = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lblOrdersIcon As Label";
userorders.mostCurrent._lblordersicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private pnlDash As Panel";
userorders.mostCurrent._pnldash = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private pnlHistory As Panel";
userorders.mostCurrent._pnlhistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private pnlInventory As Panel";
userorders.mostCurrent._pnlinventory = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private pnlOrders As Panel";
userorders.mostCurrent._pnlorders = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private bttnAddOrder As Button";
userorders.mostCurrent._bttnaddorder = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private pnlAddOrderHomeTotal As Panel";
userorders.mostCurrent._pnladdorderhometotal = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lblExitAddOrderHome As Label";
userorders.mostCurrent._lblexitaddorderhome = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private pnlDim As Panel";
userorders.mostCurrent._pnldim = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private btnAddItems As Button";
userorders.mostCurrent._btnadditems = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private pnlSelectItems As Panel";
userorders.mostCurrent._pnlselectitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private svSelectItems As ScrollView";
userorders.mostCurrent._svselectitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private etSearchItems As EditText";
userorders.mostCurrent._etsearchitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private btnPurchaseNow As Button";
userorders.mostCurrent._btnpurchasenow = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lblExitSelectItems As Label";
userorders.mostCurrent._lblexitselectitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblexitaddorderhome_click() throws Exception{
try {
		Debug.PushSubsStack("lblExitAddOrderHome_Click (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,175);
if (RapidSub.canDelegate("lblexitaddorderhome_click")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","lblexitaddorderhome_click");}
 BA.debugLineNum = 175;BA.debugLine="Private Sub lblExitAddOrderHome_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 176;BA.debugLine="pnlAddOrderHomeTotal.Visible = False";
Debug.ShouldStop(32768);
userorders.mostCurrent._pnladdorderhometotal.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 177;BA.debugLine="pnlDim.Visible = False";
Debug.ShouldStop(65536);
userorders.mostCurrent._pnldim.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 178;BA.debugLine="bttnAddOrder.Visible = True";
Debug.ShouldStop(131072);
userorders.mostCurrent._bttnaddorder.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 179;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("lblExitSelectItems_Click (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,193);
if (RapidSub.canDelegate("lblexitselectitems_click")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","lblexitselectitems_click");}
 BA.debugLineNum = 193;BA.debugLine="Private Sub lblExitSelectItems_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="pnlSelectItems.Visible = False";
Debug.ShouldStop(2);
userorders.mostCurrent._pnlselectitems.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 195;BA.debugLine="pnlDim.Visible = False";
Debug.ShouldStop(4);
userorders.mostCurrent._pnldim.runMethod(true,"setVisible",userorders.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 197;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbllogout_click() throws Exception{
try {
		Debug.PushSubsStack("lbllogout_Click (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,89);
if (RapidSub.canDelegate("lbllogout_click")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","lbllogout_click");}
 BA.debugLineNum = 89;BA.debugLine="Private Sub lbllogout_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="Main.LoggedInUser = \"\"";
Debug.ShouldStop(33554432);
userorders.mostCurrent._main._loggedinuser /*RemoteObject*/  = BA.ObjectToString("");
 BA.debugLineNum = 91;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(67108864);
userorders.mostCurrent.__c.runVoidMethod ("StartActivity",userorders.processBA,(Object)((userorders.mostCurrent._main.getObject())));
 BA.debugLineNum = 92;BA.debugLine="Controls.SetAnimation(\"slide_right_in\", \"slide_ri";
Debug.ShouldStop(134217728);
userorders.mostCurrent._controls.runVoidMethod ("_setanimation" /*RemoteObject*/ ,userorders.mostCurrent.activityBA,(Object)(BA.ObjectToString("slide_right_in")),(Object)(RemoteObject.createImmutable("slide_right_out")));
 BA.debugLineNum = 93;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
userorders.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadproductsintoselectitems() throws Exception{
try {
		Debug.PushSubsStack("LoadProductsIntoSelectItems (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,136);
if (RapidSub.canDelegate("loadproductsintoselectitems")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","loadproductsintoselectitems");}
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _toppos = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _sku = RemoteObject.createImmutable("");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _price = RemoteObject.createImmutable(0);
RemoteObject _packnumber = RemoteObject.createImmutable(0);
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 136;BA.debugLine="Private Sub LoadProductsIntoSelectItems";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="svSelectItems.Panel.RemoveAllViews";
Debug.ShouldStop(256);
userorders.mostCurrent._svselectitems.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 138;BA.debugLine="svSelectItems.Panel.Height = 0";
Debug.ShouldStop(512);
userorders.mostCurrent._svselectitems.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, 0));
 BA.debugLineNum = 140;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(2048);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 141;BA.debugLine="cursor = SQLProducts.ExecQuery(\"SELECT * FROM pro";
Debug.ShouldStop(4096);
_cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), userorders._sqlproducts.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM products"))));Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 142;BA.debugLine="Dim topPos As Int = 10dip";
Debug.ShouldStop(8192);
_toppos = userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("topPos", _toppos);Debug.locals.put("topPos", _toppos);
 BA.debugLineNum = 144;BA.debugLine="For i = 0 To cursor.RowCount - 1";
Debug.ShouldStop(32768);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 145;BA.debugLine="cursor.Position = i";
Debug.ShouldStop(65536);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 146;BA.debugLine="Dim sku As String = cursor.GetString(\"sku\")";
Debug.ShouldStop(131072);
_sku = _cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("sku")));Debug.locals.put("sku", _sku);Debug.locals.put("sku", _sku);
 BA.debugLineNum = 147;BA.debugLine="Dim name As String = cursor.GetString(\"name\")";
Debug.ShouldStop(262144);
_name = _cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("name")));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 148;BA.debugLine="Dim price As Double = cursor.GetDouble(\"price\")";
Debug.ShouldStop(524288);
_price = _cursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("price")));Debug.locals.put("price", _price);Debug.locals.put("price", _price);
 BA.debugLineNum = 149;BA.debugLine="Dim packNumber As Int = cursor.GetInt(\"pack_numb";
Debug.ShouldStop(1048576);
_packnumber = _cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("pack_number")));Debug.locals.put("packNumber", _packnumber);Debug.locals.put("packNumber", _packnumber);
 BA.debugLineNum = 151;BA.debugLine="Dim card As Panel";
Debug.ShouldStop(4194304);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("card", _card);
 BA.debugLineNum = 152;BA.debugLine="card = CreateProductCard(sku, name, price, packN";
Debug.ShouldStop(8388608);
_card = _createproductcard(_sku,_name,_price,_packnumber);Debug.locals.put("card", _card);
 BA.debugLineNum = 154;BA.debugLine="svSelectItems.Panel.AddView(card, 10dip, topPos,";
Debug.ShouldStop(33554432);
userorders.mostCurrent._svselectitems.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_card.getObject())),(Object)(userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_toppos),(Object)(RemoteObject.solve(new RemoteObject[] {userorders.mostCurrent._svselectitems.runMethod(true,"getWidth"),userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(_card.runMethod(true,"getHeight")));
 BA.debugLineNum = 155;BA.debugLine="topPos = topPos + card.Height + 10dip";
Debug.ShouldStop(67108864);
_toppos = RemoteObject.solve(new RemoteObject[] {_toppos,_card.runMethod(true,"getHeight"),userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1);Debug.locals.put("topPos", _toppos);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 158;BA.debugLine="cursor.Close";
Debug.ShouldStop(536870912);
_cursor.runVoidMethod ("Close");
 BA.debugLineNum = 159;BA.debugLine="svSelectItems.Panel.Height = topPos + 10dip";
Debug.ShouldStop(1073741824);
userorders.mostCurrent._svselectitems.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_toppos,userorders.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1));
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pnlDim_Click (userorders) ","userorders",6,userorders.mostCurrent.activityBA,userorders.mostCurrent,203);
if (RapidSub.canDelegate("pnldim_click")) { return b4a.OrderTakerTest1.userorders.remoteMe.runUserSub(false, "userorders","pnldim_click");}
 BA.debugLineNum = 203;BA.debugLine="Private Sub pnlDim_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
 //BA.debugLineNum = 7;BA.debugLine="Private SQLProducts As SQL";
userorders._sqlproducts = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 8;BA.debugLine="Private xui As XUI";
userorders._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}