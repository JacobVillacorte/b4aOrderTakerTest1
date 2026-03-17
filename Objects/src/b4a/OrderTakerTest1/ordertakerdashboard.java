package b4a.OrderTakerTest1;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class ordertakerdashboard extends Activity implements B4AActivity{
	public static ordertakerdashboard mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.ordertakerdashboard");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ordertakerdashboard).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.ordertakerdashboard");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.OrderTakerTest1.ordertakerdashboard", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ordertakerdashboard) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ordertakerdashboard) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return ordertakerdashboard.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (ordertakerdashboard) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (ordertakerdashboard) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            ordertakerdashboard mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ordertakerdashboard) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbottomnav = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldash = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldash = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldashicon = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlorders = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblorders = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblordersicon = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlinventory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinventory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinventoryicon = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlhistory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblhistory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblhistoryicon = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontent = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontentdash = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontentorders = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontentinventory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontenthistory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnltop = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldim = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblloggedinuser = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllogout = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblperson = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfetchstatus = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcacheinfo = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnfetchproducts = null;
public b4a.example3.customlistview _clvcontentorders = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etcontentsearchorder = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnaddorder = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svinventory = null;
public b4a.OrderTakerTest1.main _main = null;
public b4a.OrderTakerTest1.controls _controls = null;
public b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public b4a.OrderTakerTest1.starter _starter = null;
public b4a.OrderTakerTest1.userorders _userorders = null;
public b4a.OrderTakerTest1.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
String _displayname = "";
 //BA.debugLineNum = 46;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 47;BA.debugLine="Activity.LoadLayout(\"OrderTakerDashboard\")";
mostCurrent._activity.LoadLayout("OrderTakerDashboard",mostCurrent.activityBA);
 //BA.debugLineNum = 49;BA.debugLine="Dim displayName As String = Main.LoggedInUser";
_displayname = mostCurrent._main._loggedinuser /*String*/ ;
 //BA.debugLineNum = 50;BA.debugLine="If Main.LoggedInUserFullName <> \"\" Then";
if ((mostCurrent._main._loggedinuserfullname /*String*/ ).equals("") == false) { 
 //BA.debugLineNum = 51;BA.debugLine="displayName = Main.LoggedInUserFullName";
_displayname = mostCurrent._main._loggedinuserfullname /*String*/ ;
 };
 //BA.debugLineNum = 53;BA.debugLine="lblLoggedInUser.Text = \"Welcome, \" & displayName";
mostCurrent._lblloggedinuser.setText(BA.ObjectToCharSequence("Welcome, "+_displayname));
 //BA.debugLineNum = 55;BA.debugLine="SetupOrdersDatabaseTables";
_setupordersdatabasetables();
 //BA.debugLineNum = 56;BA.debugLine="ShowPanel(pnlContentDash)";
_showpanel(mostCurrent._pnlcontentdash);
 //BA.debugLineNum = 57;BA.debugLine="UpdateDashboardStatusLabels";
_updatedashboardstatuslabels();
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 61;BA.debugLine="LoadOrdersIntoList";
_loadordersintolist();
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _bttnaddorder_click() throws Exception{
 //BA.debugLineNum = 296;BA.debugLine="Private Sub bttnAddOrder_Click";
 //BA.debugLineNum = 297;BA.debugLine="StartActivity(addOrderActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._addorderactivity.getObject()));
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public static void  _bttnfetchproducts_click() throws Exception{
ResumableSub_bttnFetchProducts_Click rsub = new ResumableSub_bttnFetchProducts_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_bttnFetchProducts_Click extends BA.ResumableSub {
public ResumableSub_bttnFetchProducts_Click(b4a.OrderTakerTest1.ordertakerdashboard parent) {
this.parent = parent;
}
b4a.OrderTakerTest1.ordertakerdashboard parent;
b4a.OrderTakerTest1.httpjob _j = null;
String _fetchurl = "";
String _response = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 307;BA.debugLine="If Main.VENDOR_ID <= 0 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent.mostCurrent._main._vendor_id /*int*/ <=0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 308;BA.debugLine="ShowFetchErrorMessage(\"No vendor assigned to cur";
_showfetcherrormessage("No vendor assigned to current login");
 //BA.debugLineNum = 309;BA.debugLine="ToastMessageShow(\"Please log in again.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please log in again."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 310;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 313;BA.debugLine="SetFetchButtonBusyState(True)";
_setfetchbuttonbusystate(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 314;BA.debugLine="lblFetchStatus.Text = \"Connecting to server...\"";
parent.mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("Connecting to server..."));
 //BA.debugLineNum = 315;BA.debugLine="lblFetchStatus.TextColor = Colors.Blue";
parent.mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 317;BA.debugLine="Dim j As HttpJob";
_j = new b4a.OrderTakerTest1.httpjob();
 //BA.debugLineNum = 318;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (processBA,"",ordertakerdashboard.getObject());
 //BA.debugLineNum = 320;BA.debugLine="Dim fetchUrl As String = Main.API_URL & \"get_item";
_fetchurl = parent.mostCurrent._main._api_url /*String*/ +"get_items.php?vendor_id="+BA.NumberToString(parent.mostCurrent._main._vendor_id /*int*/ );
 //BA.debugLineNum = 321;BA.debugLine="j.Download(fetchUrl)";
_j._download /*String*/ (_fetchurl);
 //BA.debugLineNum = 323;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 17;
return;
case 17:
//C
this.state = 5;
_j = (b4a.OrderTakerTest1.httpjob) result[0];
;
 //BA.debugLineNum = 325;BA.debugLine="If j.Success Then";
if (true) break;

case 5:
//if
this.state = 16;
if (_j._success /*boolean*/ ) { 
this.state = 7;
}else {
this.state = 15;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 326;BA.debugLine="Dim response As String = j.GetString";
_response = _j._getstring /*String*/ ();
 //BA.debugLineNum = 327;BA.debugLine="If response = \"\" Or response = Null Then";
if (true) break;

case 8:
//if
this.state = 13;
if ((_response).equals("") || _response== null) { 
this.state = 10;
}else {
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 13;
 //BA.debugLineNum = 328;BA.debugLine="ShowFetchErrorMessage(\"Server returned empty re";
_showfetcherrormessage("Server returned empty response");
 if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 330;BA.debugLine="ParseAndSaveProductsFromServerResponse(response";
_parseandsaveproductsfromserverresponse(_response);
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 333;BA.debugLine="ShowFetchErrorMessage(\"Cannot connect. Check WiF";
_showfetcherrormessage("Cannot connect. Check WiFi and server.");
 //BA.debugLineNum = 334;BA.debugLine="ToastMessageShow(\"Network error. Using cached da";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Network error. Using cached data."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 16:
//C
this.state = -1;
;
 //BA.debugLineNum = 337;BA.debugLine="SetFetchButtonBusyState(False)";
_setfetchbuttonbusystate(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 338;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 339;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _jobdone(b4a.OrderTakerTest1.httpjob _j) throws Exception{
}
public static String  _clvcontentorders_itemclick(int _index,Object _value) throws Exception{
int _orderid = 0;
 //BA.debugLineNum = 208;BA.debugLine="Private Sub clvContentOrders_ItemClick(Index As In";
 //BA.debugLineNum = 209;BA.debugLine="Dim orderID As Int = Value";
_orderid = (int)(BA.ObjectToNumber(_value));
 //BA.debugLineNum = 210;BA.debugLine="ShowOrderDetails(orderID)";
_showorderdetails(_orderid);
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public static String  _clvcontentorders_itemlongclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Private Sub clvContentOrders_ItemLongClick(Index A";
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public static String  _deleteoldcacheandsavefreshproducts(anywheresoftware.b4a.objects.collections.List _items) throws Exception{
int _currentvendor = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _barcode = "";
int _vendorid = 0;
 //BA.debugLineNum = 379;BA.debugLine="Private Sub DeleteOldCacheAndSaveFreshProducts(ite";
 //BA.debugLineNum = 380;BA.debugLine="Dim currentVendor As Int = Main.VENDOR_ID";
_currentvendor = mostCurrent._main._vendor_id /*int*/ ;
 //BA.debugLineNum = 381;BA.debugLine="If currentVendor <= 0 Then";
if (_currentvendor<=0) { 
 //BA.debugLineNum = 382;BA.debugLine="Log(\"Skip cache save: invalid vendor\")";
anywheresoftware.b4a.keywords.Common.LogImpl("02752515","Skip cache save: invalid vendor",0);
 //BA.debugLineNum = 383;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 387;BA.debugLine="Main.SQLProducts.ExecNonQuery2(\"DELETE FROM items";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("DELETE FROM items WHERE vendor_id = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_currentvendor)}));
 //BA.debugLineNum = 389;BA.debugLine="For i = 0 To items.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_items.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 390;BA.debugLine="Dim item As Map = items.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_items.Get(_i)));
 //BA.debugLineNum = 392;BA.debugLine="Dim barcode As String = \"\"";
_barcode = "";
 //BA.debugLineNum = 393;BA.debugLine="If item.ContainsKey(\"barcode\") And item.Get(\"bar";
if (_item.ContainsKey((Object)("barcode")) && _item.Get((Object)("barcode"))!= null) { 
 //BA.debugLineNum = 394;BA.debugLine="barcode = item.Get(\"barcode\")";
_barcode = BA.ObjectToString(_item.Get((Object)("barcode")));
 };
 //BA.debugLineNum = 397;BA.debugLine="Dim vendorID As Int = currentVendor";
_vendorid = _currentvendor;
 //BA.debugLineNum = 398;BA.debugLine="If item.ContainsKey(\"vendor_id\") And item.Get(\"v";
if (_item.ContainsKey((Object)("vendor_id")) && _item.Get((Object)("vendor_id"))!= null) { 
 //BA.debugLineNum = 399;BA.debugLine="vendorID = item.Get(\"vendor_id\")";
_vendorid = (int)(BA.ObjectToNumber(_item.Get((Object)("vendor_id"))));
 };
 //BA.debugLineNum = 402;BA.debugLine="Main.SQLProducts.ExecNonQuery2( _             \"I";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT OR REPLACE INTO items (item_id, item_code, item_name, unit_price, barcode, vendor_id, is_active) VALUES (?, ?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_item.Get((Object)("item_id")),_item.Get((Object)("item_code")),_item.Get((Object)("item_name")),_item.Get((Object)("unit_price")),(Object)(_barcode),(Object)(_vendorid),(Object)(1)}));
 }
};
 //BA.debugLineNum = 406;BA.debugLine="End Sub";
return "";
}
public static String  _formattimeago(long _synctimestamp) throws Exception{
long _minutesago = 0L;
 //BA.debugLineNum = 522;BA.debugLine="Private Sub FormatTimeAgo(syncTimestamp As Long) A";
 //BA.debugLineNum = 523;BA.debugLine="Dim minutesAgo As Long = (DateTime.Now - syncTime";
_minutesago = (long) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_synctimestamp)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
 //BA.debugLineNum = 525;BA.debugLine="If minutesAgo < 1 Then";
if (_minutesago<1) { 
 //BA.debugLineNum = 526;BA.debugLine="Return \"Just now\"";
if (true) return "Just now";
 }else if(_minutesago<60) { 
 //BA.debugLineNum = 528;BA.debugLine="Return minutesAgo & \" minutes ago\"";
if (true) return BA.NumberToString(_minutesago)+" minutes ago";
 }else if(_minutesago<1440) { 
 //BA.debugLineNum = 530;BA.debugLine="Return (minutesAgo / 60) & \" hours ago\"";
if (true) return BA.NumberToString((_minutesago/(double)60))+" hours ago";
 }else {
 //BA.debugLineNum = 532;BA.debugLine="Return (minutesAgo / 1440) & \" days ago\"";
if (true) return BA.NumberToString((_minutesago/(double)1440))+" days ago";
 };
 //BA.debugLineNum = 534;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private pnlBottomNav As Panel";
mostCurrent._pnlbottomnav = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private pnlDash As Panel, lblDash As Label, lblDa";
mostCurrent._pnldash = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._lbldash = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._lbldashicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private pnlOrders As Panel, lblOrders As Label, l";
mostCurrent._pnlorders = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._lblorders = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._lblordersicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private pnlInventory As Panel, lblInventory As La";
mostCurrent._pnlinventory = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._lblinventory = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._lblinventoryicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private pnlHistory As Panel, lblHistory As Label,";
mostCurrent._pnlhistory = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._lblhistory = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._lblhistoryicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private pnlContent As Panel";
mostCurrent._pnlcontent = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private pnlContentDash As Panel";
mostCurrent._pnlcontentdash = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private pnlContentOrders As Panel";
mostCurrent._pnlcontentorders = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private pnlContentInventory As Panel";
mostCurrent._pnlcontentinventory = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private pnlContentHistory As Panel";
mostCurrent._pnlcontenthistory = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private pnlTop As Panel";
mostCurrent._pnltop = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private pnlDim As Panel";
mostCurrent._pnldim = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private lblLoggedInUser As Label";
mostCurrent._lblloggedinuser = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private lbllogout As Label";
mostCurrent._lbllogout = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private lblperson As Label";
mostCurrent._lblperson = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private lblFetchStatus As Label";
mostCurrent._lblfetchstatus = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private lblCacheInfo As Label";
mostCurrent._lblcacheinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private bttnFetchProducts As Button";
mostCurrent._bttnfetchproducts = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private clvContentOrders As CustomListView";
mostCurrent._clvcontentorders = new b4a.example3.customlistview();
 //BA.debugLineNum = 39;BA.debugLine="Private etContentSearchOrder As EditText";
mostCurrent._etcontentsearchorder = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private bttnAddOrder As Button";
mostCurrent._bttnaddorder = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private svInventory As ScrollView";
mostCurrent._svinventory = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _lbllogout_click() throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Private Sub lbllogout_Click";
 //BA.debugLineNum = 156;BA.debugLine="Main.LoggedInUser = \"\"";
mostCurrent._main._loggedinuser /*String*/  = "";
 //BA.debugLineNum = 157;BA.debugLine="Main.LoggedInUserID = 0";
mostCurrent._main._loggedinuserid /*int*/  = (int) (0);
 //BA.debugLineNum = 158;BA.debugLine="Main.LoggedInUserFullName = \"\"";
mostCurrent._main._loggedinuserfullname /*String*/  = "";
 //BA.debugLineNum = 159;BA.debugLine="Main.LoggedInGroupID = 0";
mostCurrent._main._loggedingroupid /*int*/  = (int) (0);
 //BA.debugLineNum = 160;BA.debugLine="Main.VENDOR_ID = 0";
mostCurrent._main._vendor_id /*int*/  = (int) (0);
 //BA.debugLineNum = 161;BA.debugLine="Main.LoggedInRequiresVendorSelection = False";
mostCurrent._main._loggedinrequiresvendorselection /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 162;BA.debugLine="Main.AssignedVendors.Initialize";
mostCurrent._main._assignedvendors /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
 //BA.debugLineNum = 164;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 165;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _loadinventoryitemsintoscrollview() throws Exception{
int _top = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblprice = null;
anywheresoftware.b4a.objects.LabelWrapper _lblcode = null;
 //BA.debugLineNum = 419;BA.debugLine="Private Sub LoadInventoryItemsIntoScrollView";
 //BA.debugLineNum = 420;BA.debugLine="svInventory.Panel.RemoveAllViews";
mostCurrent._svinventory.getPanel().RemoveAllViews();
 //BA.debugLineNum = 421;BA.debugLine="Dim top As Int = 0";
_top = (int) (0);
 //BA.debugLineNum = 423;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery2";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE is_active = 1 AND vendor_id = ? ORDER BY item_name",new String[]{BA.NumberToString(mostCurrent._main._vendor_id /*int*/ )})));
 //BA.debugLineNum = 427;BA.debugLine="If rs.RowCount = 0 Then";
if (_rs.getRowCount()==0) { 
 //BA.debugLineNum = 428;BA.debugLine="ShowEmptyInventoryMessage";
_showemptyinventorymessage();
 //BA.debugLineNum = 429;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 430;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 433;BA.debugLine="Do While rs.NextRow";
while (_rs.NextRow()) {
 //BA.debugLineNum = 434;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 435;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 436;BA.debugLine="pnl.Color = Colors.White";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 438;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 439;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 440;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
_lblname.setText(BA.ObjectToCharSequence(_rs.GetString("item_name")));
 //BA.debugLineNum = 441;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
 //BA.debugLineNum = 442;BA.debugLine="lblName.TextColor = Colors.Black";
_lblname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 444;BA.debugLine="Dim lblPrice As Label";
_lblprice = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 445;BA.debugLine="lblPrice.Initialize(\"\")";
_lblprice.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 446;BA.debugLine="lblPrice.Text = \"₱\" & rs.GetDouble(\"unit_price\")";
_lblprice.setText(BA.ObjectToCharSequence("₱"+BA.NumberToString(_rs.GetDouble("unit_price"))));
 //BA.debugLineNum = 447;BA.debugLine="lblPrice.TextSize = 14";
_lblprice.setTextSize((float) (14));
 //BA.debugLineNum = 448;BA.debugLine="lblPrice.TextColor = Colors.RGB(0, 120, 0)";
_lblprice.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (120),(int) (0)));
 //BA.debugLineNum = 450;BA.debugLine="Dim lblCode As Label";
_lblcode = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 451;BA.debugLine="lblCode.Initialize(\"\")";
_lblcode.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 452;BA.debugLine="lblCode.Text = \"Code: \" & rs.GetString(\"item_cod";
_lblcode.setText(BA.ObjectToCharSequence("Code: "+_rs.GetString("item_code")));
 //BA.debugLineNum = 453;BA.debugLine="lblCode.TextSize = 12";
_lblcode.setTextSize((float) (12));
 //BA.debugLineNum = 454;BA.debugLine="lblCode.TextColor = Colors.Gray";
_lblcode.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 456;BA.debugLine="pnl.AddView(lblName, 10dip, 5dip, svInventory.Wi";
_pnl.AddView((android.view.View)(_lblname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._svinventory.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
 //BA.debugLineNum = 457;BA.debugLine="pnl.AddView(lblPrice, 10dip, 30dip, svInventory.";
_pnl.AddView((android.view.View)(_lblprice.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (mostCurrent._svinventory.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 458;BA.debugLine="pnl.AddView(lblCode, 10dip, 50dip, svInventory.W";
_pnl.AddView((android.view.View)(_lblcode.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._svinventory.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)));
 //BA.debugLineNum = 460;BA.debugLine="svInventory.Panel.AddView(pnl, 0, top, svInvento";
mostCurrent._svinventory.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_top,mostCurrent._svinventory.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)));
 //BA.debugLineNum = 461;BA.debugLine="top = top + 80dip";
_top = (int) (_top+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
 }
;
 //BA.debugLineNum = 463;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 465;BA.debugLine="svInventory.Panel.Height = top";
mostCurrent._svinventory.getPanel().setHeight(_top);
 //BA.debugLineNum = 466;BA.debugLine="End Sub";
return "";
}
public static String  _loadordersintolist() throws Exception{
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblorderid = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltotal = null;
 //BA.debugLineNum = 176;BA.debugLine="Private Sub LoadOrdersIntoList";
 //BA.debugLineNum = 177;BA.debugLine="clvContentOrders.Clear";
mostCurrent._clvcontentorders._clear();
 //BA.debugLineNum = 179;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery2";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM orders WHERE vendor_id = ? AND user_id = ? ORDER BY order_id DESC",new String[]{BA.NumberToString(mostCurrent._main._vendor_id /*int*/ ),BA.NumberToString(mostCurrent._main._loggedinuserid /*int*/ )})));
 //BA.debugLineNum = 183;BA.debugLine="Do While rs.NextRow";
while (_rs.NextRow()) {
 //BA.debugLineNum = 184;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 185;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 186;BA.debugLine="pnl.SetLayout(0, 0, clvContentOrders.AsView.Widt";
_pnl.SetLayout((int) (0),(int) (0),mostCurrent._clvcontentorders._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
 //BA.debugLineNum = 188;BA.debugLine="Dim lblOrderID As Label";
_lblorderid = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 189;BA.debugLine="lblOrderID.Initialize(\"\")";
_lblorderid.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 190;BA.debugLine="lblOrderID.Text = \"Order #\" & rs.GetInt(\"order_i";
_lblorderid.setText(BA.ObjectToCharSequence("Order #"+BA.NumberToString(_rs.GetInt("order_id"))));
 //BA.debugLineNum = 191;BA.debugLine="lblOrderID.TextSize = 16";
_lblorderid.setTextSize((float) (16));
 //BA.debugLineNum = 192;BA.debugLine="lblOrderID.SetLayout(10dip, 5dip, 50%x, 25dip)";
_lblorderid.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
 //BA.debugLineNum = 194;BA.debugLine="Dim lblTotal As Label";
_lbltotal = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 195;BA.debugLine="lblTotal.Initialize(\"\")";
_lbltotal.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 196;BA.debugLine="lblTotal.Text = \"Total: ₱\" & rs.GetDouble(\"total";
_lbltotal.setText(BA.ObjectToCharSequence("Total: ₱"+BA.NumberToString(_rs.GetDouble("total_amount"))));
 //BA.debugLineNum = 197;BA.debugLine="lblTotal.SetLayout(10dip, 30dip, 50%x, 25dip)";
_lbltotal.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
 //BA.debugLineNum = 199;BA.debugLine="pnl.AddView(lblOrderID, lblOrderID.Left, lblOrde";
_pnl.AddView((android.view.View)(_lblorderid.getObject()),_lblorderid.getLeft(),_lblorderid.getTop(),_lblorderid.getWidth(),_lblorderid.getHeight());
 //BA.debugLineNum = 200;BA.debugLine="pnl.AddView(lblTotal, lblTotal.Left, lblTotal.To";
_pnl.AddView((android.view.View)(_lbltotal.getObject()),_lbltotal.getLeft(),_lbltotal.getTop(),_lbltotal.getWidth(),_lbltotal.getHeight());
 //BA.debugLineNum = 202;BA.debugLine="clvContentOrders.Add(pnl, rs.GetInt(\"order_id\"))";
mostCurrent._clvcontentorders._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject())),(Object)(_rs.GetInt("order_id")));
 }
;
 //BA.debugLineNum = 204;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _parseandsaveproductsfromserverresponse(String _response) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _items = null;
 //BA.debugLineNum = 353;BA.debugLine="Private Sub ParseAndSaveProductsFromServerResponse";
 //BA.debugLineNum = 354;BA.debugLine="Try";
try { //BA.debugLineNum = 355;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 356;BA.debugLine="parser.Initialize(response)";
_parser.Initialize(_response);
 //BA.debugLineNum = 357;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 359;BA.debugLine="If root.Get(\"status\") <> \"success\" Then";
if ((_root.Get((Object)("status"))).equals((Object)("success")) == false) { 
 //BA.debugLineNum = 360;BA.debugLine="ShowFetchErrorMessage(\"Server returned an error";
_showfetcherrormessage("Server returned an error");
 //BA.debugLineNum = 361;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 364;BA.debugLine="Dim items As List = root.Get(\"data\")";
_items = new anywheresoftware.b4a.objects.collections.List();
_items = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("data"))));
 //BA.debugLineNum = 365;BA.debugLine="DeleteOldCacheAndSaveFreshProducts(items)";
_deleteoldcacheandsavefreshproducts(_items);
 //BA.debugLineNum = 367;BA.debugLine="Main.ITEMS_LAST_SYNC = DateTime.Now";
mostCurrent._main._items_last_sync /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 368;BA.debugLine="lblFetchStatus.Text = \"✓ Sync completed successf";
mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("✓ Sync completed successfully!"));
 //BA.debugLineNum = 369;BA.debugLine="lblFetchStatus.TextColor = Colors.RGB(0, 150, 0)";
mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (150),(int) (0)));
 //BA.debugLineNum = 370;BA.debugLine="UpdateDashboardStatusLabels";
_updatedashboardstatuslabels();
 //BA.debugLineNum = 371;BA.debugLine="ToastMessageShow(\"Synced \" & items.Size & \" prod";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Synced "+BA.NumberToString(_items.getSize())+" products"),anywheresoftware.b4a.keywords.Common.False);
 } 
       catch (Exception e17) {
			processBA.setLastException(e17); //BA.debugLineNum = 374;BA.debugLine="ShowFetchErrorMessage(\"Failed to read server res";
_showfetcherrormessage("Failed to read server response: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public static String  _pnldash_click() throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Private Sub pnlDash_Click";
 //BA.debugLineNum = 136;BA.debugLine="ShowPanel(pnlContentDash)";
_showpanel(mostCurrent._pnlcontentdash);
 //BA.debugLineNum = 137;BA.debugLine="UpdateDashboardStatusLabels";
_updatedashboardstatuslabels();
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public static String  _pnldim_click() throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Private Sub pnlDim_Click";
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public static String  _pnlhistory_click() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Private Sub pnlHistory_Click";
 //BA.debugLineNum = 152;BA.debugLine="ShowPanel(pnlContentHistory)";
_showpanel(mostCurrent._pnlcontenthistory);
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static String  _pnlinventory_click() throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Private Sub pnlInventory_Click";
 //BA.debugLineNum = 147;BA.debugLine="ShowPanel(pnlContentInventory)";
_showpanel(mostCurrent._pnlcontentinventory);
 //BA.debugLineNum = 148;BA.debugLine="LoadInventoryItemsIntoScrollView";
_loadinventoryitemsintoscrollview();
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _pnlorders_click() throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Private Sub pnlOrders_Click";
 //BA.debugLineNum = 141;BA.debugLine="ShowPanel(pnlContentOrders)";
_showpanel(mostCurrent._pnlcontentorders);
 //BA.debugLineNum = 142;BA.debugLine="bttnAddOrder.Visible = True";
mostCurrent._bttnaddorder.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 143;BA.debugLine="bttnAddOrder.BringToFront";
mostCurrent._bttnaddorder.BringToFront();
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public static String  _setfetchbuttonbusystate(boolean _isbusy) throws Exception{
 //BA.debugLineNum = 342;BA.debugLine="Private Sub SetFetchButtonBusyState(isBusy As Bool";
 //BA.debugLineNum = 343;BA.debugLine="If isBusy Then";
if (_isbusy) { 
 //BA.debugLineNum = 344;BA.debugLine="bttnFetchProducts.Enabled = False";
mostCurrent._bttnfetchproducts.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 345;BA.debugLine="bttnFetchProducts.Color = Colors.LightGray";
mostCurrent._bttnfetchproducts.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 }else {
 //BA.debugLineNum = 347;BA.debugLine="bttnFetchProducts.Enabled = True";
mostCurrent._bttnfetchproducts.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 348;BA.debugLine="bttnFetchProducts.Color = Colors.Blue";
mostCurrent._bttnfetchproducts.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 };
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public static String  _setupordersdatabasetables() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Private Sub SetupOrdersDatabaseTables";
 //BA.debugLineNum = 70;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"CREATE TABLE IF NO";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("CREATE TABLE IF NOT EXISTS orders ("+"order_id INTEGER PRIMARY KEY AUTOINCREMENT, "+"vendor_id INTEGER, user_id INTEGER, date_created TEXT, status TEXT, total_amount REAL)");
 //BA.debugLineNum = 73;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"CREATE TABLE IF NO";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("CREATE TABLE IF NOT EXISTS order_items ("+"order_item_id INTEGER PRIMARY KEY AUTOINCREMENT, "+"order_id INTEGER, product_id INTEGER, quantity INTEGER, price REAL)");
 //BA.debugLineNum = 77;BA.debugLine="Try";
try { //BA.debugLineNum = 78;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE orders ADD COLUMN user_id INTEGER DEFAULT 0");
 //BA.debugLineNum = 79;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE orders ADD COLUMN transaction_number TEXT");
 //BA.debugLineNum = 80;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE orders ADD COLUMN device_id TEXT");
 //BA.debugLineNum = 81;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE orders ADD COLUMN sync_status TEXT DEFAULT 'Holding'");
 //BA.debugLineNum = 82;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE orders ADD COLUMN synced_at INTEGER DEFAULT 0");
 //BA.debugLineNum = 84;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE order_items ADD COLUMN fulfillment_status TEXT DEFAULT 'Paid-Received'");
 //BA.debugLineNum = 85;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE order_items ADD COLUMN payment_status TEXT DEFAULT 'Paid'");
 //BA.debugLineNum = 86;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"ALTER TABLE order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("ALTER TABLE order_items ADD COLUMN delivery_status TEXT DEFAULT 'Received'");
 //BA.debugLineNum = 87;BA.debugLine="Log(\"Database schema ready for multi-vendor + us";
anywheresoftware.b4a.keywords.Common.LogImpl("01703954","Database schema ready for multi-vendor + user tracking",0);
 } 
       catch (Exception e14) {
			processBA.setLastException(e14); //BA.debugLineNum = 89;BA.debugLine="Log(\"Database columns already exist (OK): \" & La";
anywheresoftware.b4a.keywords.Common.LogImpl("01703956","Database columns already exist (OK): "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _showemptyinventorymessage() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lblempty = null;
 //BA.debugLineNum = 469;BA.debugLine="Private Sub ShowEmptyInventoryMessage";
 //BA.debugLineNum = 470;BA.debugLine="Dim lblEmpty As Label";
_lblempty = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 471;BA.debugLine="lblEmpty.Initialize(\"\")";
_lblempty.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 472;BA.debugLine="lblEmpty.Text = \"No products cached. Go to Dashbo";
_lblempty.setText(BA.ObjectToCharSequence("No products cached. Go to Dashboard and sync first."));
 //BA.debugLineNum = 473;BA.debugLine="lblEmpty.TextSize = 14";
_lblempty.setTextSize((float) (14));
 //BA.debugLineNum = 474;BA.debugLine="lblEmpty.TextColor = Colors.Gray";
_lblempty.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 475;BA.debugLine="lblEmpty.Gravity = Gravity.CENTER";
_lblempty.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 476;BA.debugLine="svInventory.Panel.AddView(lblEmpty, 0, 20dip, svI";
mostCurrent._svinventory.getPanel().AddView((android.view.View)(_lblempty.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),mostCurrent._svinventory.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
return "";
}
public static String  _showfetcherrormessage(String _errormessage) throws Exception{
 //BA.debugLineNum = 409;BA.debugLine="Private Sub ShowFetchErrorMessage(errorMessage As";
 //BA.debugLineNum = 410;BA.debugLine="lblFetchStatus.Text = \"✗ \" & errorMessage";
mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("✗ "+_errormessage));
 //BA.debugLineNum = 411;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 412;BA.debugLine="End Sub";
return "";
}
public static void  _showorderdetails(int _orderid) throws Exception{
ResumableSub_ShowOrderDetails rsub = new ResumableSub_ShowOrderDetails(null,_orderid);
rsub.resume(processBA, null);
}
public static class ResumableSub_ShowOrderDetails extends BA.ResumableSub {
public ResumableSub_ShowOrderDetails(b4a.OrderTakerTest1.ordertakerdashboard parent,int _orderid) {
this.parent = parent;
this._orderid = _orderid;
}
b4a.OrderTakerTest1.ordertakerdashboard parent;
int _orderid;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursororder = null;
String _transactionnumber = "";
String _syncstatus = "";
long _orderdate = 0L;
double _totalamount = 0;
String _orderstatus = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursoritems = null;
String _itemstext = "";
int _i = 0;
String _itemname = "";
int _quantity = 0;
double _price = 0;
String _fulfillmentstatus = "";
String _message = "";
int _result = 0;
int step22;
int limit22;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 218;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 42;
this.catchState = 41;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 41;
 //BA.debugLineNum = 219;BA.debugLine="Dim cursorOrder As Cursor = Main.SQLProducts.Exe";
_cursororder = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_cursororder = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent.mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT order_id, transaction_number, date_created, total_amount, status, sync_status "+"FROM orders WHERE order_id = ?",new String[]{BA.NumberToString(_orderid)})));
 //BA.debugLineNum = 224;BA.debugLine="If cursorOrder.RowCount = 0 Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_cursororder.getRowCount()==0) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 225;BA.debugLine="ToastMessageShow(\"Order not found\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Order not found"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 226;BA.debugLine="cursorOrder.Close";
_cursororder.Close();
 //BA.debugLineNum = 227;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 230;BA.debugLine="cursorOrder.Position = 0";
_cursororder.setPosition((int) (0));
 //BA.debugLineNum = 232;BA.debugLine="Dim transactionNumber As String = cursorOrder.Ge";
_transactionnumber = _cursororder.GetString("transaction_number");
 //BA.debugLineNum = 233;BA.debugLine="If transactionNumber = Null Then transactionNumb";
if (true) break;

case 8:
//if
this.state = 13;
if (_transactionnumber== null) { 
this.state = 10;
;}if (true) break;

case 10:
//C
this.state = 13;
_transactionnumber = "";
if (true) break;

case 13:
//C
this.state = 14;
;
 //BA.debugLineNum = 235;BA.debugLine="Dim syncStatus As String = cursorOrder.GetString";
_syncstatus = _cursororder.GetString("sync_status");
 //BA.debugLineNum = 236;BA.debugLine="If syncStatus = Null Then syncStatus = \"\"";
if (true) break;

case 14:
//if
this.state = 19;
if (_syncstatus== null) { 
this.state = 16;
;}if (true) break;

case 16:
//C
this.state = 19;
_syncstatus = "";
if (true) break;

case 19:
//C
this.state = 20;
;
 //BA.debugLineNum = 238;BA.debugLine="Dim orderDate As Long = cursorOrder.GetLong(\"dat";
_orderdate = _cursororder.GetLong("date_created");
 //BA.debugLineNum = 239;BA.debugLine="Dim totalAmount As Double = cursorOrder.GetDoubl";
_totalamount = _cursororder.GetDouble("total_amount");
 //BA.debugLineNum = 240;BA.debugLine="Dim orderStatus As String = cursorOrder.GetStrin";
_orderstatus = _cursororder.GetString("status");
 //BA.debugLineNum = 241;BA.debugLine="cursorOrder.Close";
_cursororder.Close();
 //BA.debugLineNum = 244;BA.debugLine="Dim cursorItems As Cursor = Main.SQLProducts.Exe";
_cursoritems = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_cursoritems = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent.mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT oi.product_id, oi.quantity, oi.price, oi.fulfillment_status, i.item_name "+"FROM order_items oi "+"LEFT JOIN items i ON oi.product_id = i.item_id "+"WHERE oi.order_id = ?",new String[]{BA.NumberToString(_orderid)})));
 //BA.debugLineNum = 251;BA.debugLine="Dim itemsText As String = \"\"";
_itemstext = "";
 //BA.debugLineNum = 253;BA.debugLine="If cursorItems.RowCount = 0 Then";
if (true) break;

case 20:
//if
this.state = 39;
if (_cursoritems.getRowCount()==0) { 
this.state = 22;
}else {
this.state = 24;
}if (true) break;

case 22:
//C
this.state = 39;
 //BA.debugLineNum = 254;BA.debugLine="itemsText = \"(No item lines found)\"";
_itemstext = "(No item lines found)";
 if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 256;BA.debugLine="For i = 0 To cursorItems.RowCount - 1";
if (true) break;

case 25:
//for
this.state = 38;
step22 = 1;
limit22 = (int) (_cursoritems.getRowCount()-1);
_i = (int) (0) ;
this.state = 43;
if (true) break;

case 43:
//C
this.state = 38;
if ((step22 > 0 && _i <= limit22) || (step22 < 0 && _i >= limit22)) this.state = 27;
if (true) break;

case 44:
//C
this.state = 43;
_i = ((int)(0 + _i + step22)) ;
if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 257;BA.debugLine="cursorItems.Position = i";
_cursoritems.setPosition(_i);
 //BA.debugLineNum = 259;BA.debugLine="Dim itemName As String = cursorItems.GetString";
_itemname = _cursoritems.GetString("item_name");
 //BA.debugLineNum = 260;BA.debugLine="If itemName = Null Or itemName = \"\" Then";
if (true) break;

case 28:
//if
this.state = 31;
if (_itemname== null || (_itemname).equals("")) { 
this.state = 30;
}if (true) break;

case 30:
//C
this.state = 31;
 //BA.debugLineNum = 261;BA.debugLine="itemName = \"Item #\" & cursorItems.GetInt(\"pro";
_itemname = "Item #"+BA.NumberToString(_cursoritems.GetInt("product_id"));
 if (true) break;

case 31:
//C
this.state = 32;
;
 //BA.debugLineNum = 264;BA.debugLine="Dim quantity As Int = cursorItems.GetInt(\"quan";
_quantity = _cursoritems.GetInt("quantity");
 //BA.debugLineNum = 265;BA.debugLine="Dim price As Double = cursorItems.GetDouble(\"p";
_price = _cursoritems.GetDouble("price");
 //BA.debugLineNum = 267;BA.debugLine="Dim fulfillmentStatus As String = cursorItems.";
_fulfillmentstatus = _cursoritems.GetString("fulfillment_status");
 //BA.debugLineNum = 268;BA.debugLine="If fulfillmentStatus = Null Then fulfillmentSt";
if (true) break;

case 32:
//if
this.state = 37;
if (_fulfillmentstatus== null) { 
this.state = 34;
;}if (true) break;

case 34:
//C
this.state = 37;
_fulfillmentstatus = "Unknown";
if (true) break;

case 37:
//C
this.state = 44;
;
 //BA.debugLineNum = 270;BA.debugLine="itemsText = itemsText & _";
_itemstext = _itemstext+"• "+_itemname+" x"+BA.NumberToString(_quantity)+" (@₱"+anywheresoftware.b4a.keywords.Common.NumberFormat2(_price,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False)+")"+anywheresoftware.b4a.keywords.Common.CRLF+"  Status: "+_fulfillmentstatus+anywheresoftware.b4a.keywords.Common.CRLF;
 if (true) break;
if (true) break;

case 38:
//C
this.state = 39;
;
 if (true) break;

case 39:
//C
this.state = 42;
;
 //BA.debugLineNum = 276;BA.debugLine="cursorItems.Close";
_cursoritems.Close();
 //BA.debugLineNum = 278;BA.debugLine="Dim message As String = _             \"Transacti";
_message = "Transaction: "+_transactionnumber+anywheresoftware.b4a.keywords.Common.CRLF+"Date: "+anywheresoftware.b4a.keywords.Common.DateTime.Date(_orderdate)+anywheresoftware.b4a.keywords.Common.CRLF+"Status: "+_orderstatus+anywheresoftware.b4a.keywords.Common.CRLF+"Sync: "+_syncstatus+anywheresoftware.b4a.keywords.Common.CRLF+"Total: ₱"+anywheresoftware.b4a.keywords.Common.NumberFormat2(_totalamount,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False)+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Items:"+anywheresoftware.b4a.keywords.Common.CRLF+_itemstext;
 //BA.debugLineNum = 286;BA.debugLine="Msgbox2Async(message, \"Order #\" & orderID, \"OK\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence(_message),BA.ObjectToCharSequence("Order #"+BA.NumberToString(_orderid)),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 287;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 45;
return;
case 45:
//C
this.state = 42;
_result = (Integer) result[0];
;
 if (true) break;

case 41:
//C
this.state = 42;
this.catchState = 0;
 //BA.debugLineNum = 290;BA.debugLine="Log(\"ShowOrderDetails error: \" & LastException.M";
anywheresoftware.b4a.keywords.Common.LogImpl("02424905","ShowOrderDetails error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 //BA.debugLineNum = 291;BA.debugLine="ToastMessageShow(\"Could not load order details.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Could not load order details. Please try again."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;
if (true) break;

case 42:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _showpanel(anywheresoftware.b4a.objects.PanelWrapper _paneltoshow) throws Exception{
int _inactivecolor = 0;
int _activecolor = 0;
 //BA.debugLineNum = 98;BA.debugLine="Private Sub ShowPanel(panelToShow As Panel)";
 //BA.debugLineNum = 100;BA.debugLine="pnlContentDash.Visible = False";
mostCurrent._pnlcontentdash.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 101;BA.debugLine="pnlContentOrders.Visible = False";
mostCurrent._pnlcontentorders.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 102;BA.debugLine="pnlContentInventory.Visible = False";
mostCurrent._pnlcontentinventory.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 103;BA.debugLine="pnlContentHistory.Visible = False";
mostCurrent._pnlcontenthistory.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 105;BA.debugLine="panelToShow.Visible = True";
_paneltoshow.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 108;BA.debugLine="Dim inactiveColor As Int = Colors.RGB(158, 158, 1";
_inactivecolor = anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (158),(int) (158),(int) (158));
 //BA.debugLineNum = 109;BA.debugLine="lblDashIcon.TextColor = inactiveColor";
mostCurrent._lbldashicon.setTextColor(_inactivecolor);
 //BA.debugLineNum = 110;BA.debugLine="lblDash.TextColor = inactiveColor";
mostCurrent._lbldash.setTextColor(_inactivecolor);
 //BA.debugLineNum = 111;BA.debugLine="lblOrdersIcon.TextColor = inactiveColor";
mostCurrent._lblordersicon.setTextColor(_inactivecolor);
 //BA.debugLineNum = 112;BA.debugLine="lblOrders.TextColor = inactiveColor";
mostCurrent._lblorders.setTextColor(_inactivecolor);
 //BA.debugLineNum = 113;BA.debugLine="lblInventoryIcon.TextColor = inactiveColor";
mostCurrent._lblinventoryicon.setTextColor(_inactivecolor);
 //BA.debugLineNum = 114;BA.debugLine="lblInventory.TextColor = inactiveColor";
mostCurrent._lblinventory.setTextColor(_inactivecolor);
 //BA.debugLineNum = 115;BA.debugLine="lblHistoryIcon.TextColor = inactiveColor";
mostCurrent._lblhistoryicon.setTextColor(_inactivecolor);
 //BA.debugLineNum = 116;BA.debugLine="lblHistory.TextColor = inactiveColor";
mostCurrent._lblhistory.setTextColor(_inactivecolor);
 //BA.debugLineNum = 119;BA.debugLine="Dim activeColor As Int = Colors.RGB(33, 150, 243)";
_activecolor = anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (33),(int) (150),(int) (243));
 //BA.debugLineNum = 120;BA.debugLine="If panelToShow = pnlContentDash Then";
if ((_paneltoshow).equals(mostCurrent._pnlcontentdash)) { 
 //BA.debugLineNum = 121;BA.debugLine="lblDashIcon.TextColor = activeColor";
mostCurrent._lbldashicon.setTextColor(_activecolor);
 //BA.debugLineNum = 122;BA.debugLine="lblDash.TextColor = activeColor";
mostCurrent._lbldash.setTextColor(_activecolor);
 }else if((_paneltoshow).equals(mostCurrent._pnlcontentorders)) { 
 //BA.debugLineNum = 124;BA.debugLine="lblOrdersIcon.TextColor = activeColor";
mostCurrent._lblordersicon.setTextColor(_activecolor);
 //BA.debugLineNum = 125;BA.debugLine="lblOrders.TextColor = activeColor";
mostCurrent._lblorders.setTextColor(_activecolor);
 }else if((_paneltoshow).equals(mostCurrent._pnlcontentinventory)) { 
 //BA.debugLineNum = 127;BA.debugLine="lblInventoryIcon.TextColor = activeColor";
mostCurrent._lblinventoryicon.setTextColor(_activecolor);
 //BA.debugLineNum = 128;BA.debugLine="lblInventory.TextColor = activeColor";
mostCurrent._lblinventory.setTextColor(_activecolor);
 }else if((_paneltoshow).equals(mostCurrent._pnlcontenthistory)) { 
 //BA.debugLineNum = 130;BA.debugLine="lblHistoryIcon.TextColor = activeColor";
mostCurrent._lblhistoryicon.setTextColor(_activecolor);
 //BA.debugLineNum = 131;BA.debugLine="lblHistory.TextColor = activeColor";
mostCurrent._lblhistory.setTextColor(_activecolor);
 };
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _updatedashboardstatuslabels() throws Exception{
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
int _cachedproductcount = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rsorders = null;
int _pendingordercount = 0;
 //BA.debugLineNum = 484;BA.debugLine="Private Sub UpdateDashboardStatusLabels";
 //BA.debugLineNum = 485;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery2";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT COUNT(*) as count FROM items WHERE is_active = 1 AND vendor_id = ?",new String[]{BA.NumberToString(mostCurrent._main._vendor_id /*int*/ )})));
 //BA.debugLineNum = 488;BA.debugLine="rs.NextRow";
_rs.NextRow();
 //BA.debugLineNum = 489;BA.debugLine="Dim cachedProductCount As Int = rs.GetInt(\"count\"";
_cachedproductcount = _rs.GetInt("count");
 //BA.debugLineNum = 490;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 492;BA.debugLine="If cachedProductCount > 0 Then";
if (_cachedproductcount>0) { 
 //BA.debugLineNum = 493;BA.debugLine="If Main.ITEMS_LAST_SYNC > 0 Then";
if (mostCurrent._main._items_last_sync /*long*/ >0) { 
 //BA.debugLineNum = 494;BA.debugLine="lblCacheInfo.Text = \"📦 \" & cachedProductCount";
mostCurrent._lblcacheinfo.setText(BA.ObjectToCharSequence("📦 "+BA.NumberToString(_cachedproductcount)+" products cached | Last sync: "+_formattimeago(mostCurrent._main._items_last_sync /*long*/ )));
 //BA.debugLineNum = 495;BA.debugLine="lblCacheInfo.TextColor = Colors.RGB(0, 100, 0)";
mostCurrent._lblcacheinfo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (100),(int) (0)));
 //BA.debugLineNum = 496;BA.debugLine="lblFetchStatus.Text = \"✓ Ready to take orders\"";
mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("✓ Ready to take orders"));
 //BA.debugLineNum = 497;BA.debugLine="lblFetchStatus.TextColor = Colors.RGB(0, 150, 0";
mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (150),(int) (0)));
 }else {
 //BA.debugLineNum = 499;BA.debugLine="lblCacheInfo.Text = \"📦 \" & cachedProductCount";
mostCurrent._lblcacheinfo.setText(BA.ObjectToCharSequence("📦 "+BA.NumberToString(_cachedproductcount)+" products cached (sync time unknown)"));
 //BA.debugLineNum = 500;BA.debugLine="lblCacheInfo.TextColor = Colors.Gray";
mostCurrent._lblcacheinfo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
 }else {
 //BA.debugLineNum = 503;BA.debugLine="lblCacheInfo.Text = \"⚠ No products synced yet\"";
mostCurrent._lblcacheinfo.setText(BA.ObjectToCharSequence("⚠ No products synced yet"));
 //BA.debugLineNum = 504;BA.debugLine="lblCacheInfo.TextColor = Colors.RGB(200, 100, 0)";
mostCurrent._lblcacheinfo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (200),(int) (100),(int) (0)));
 //BA.debugLineNum = 505;BA.debugLine="lblFetchStatus.Text = \"Tap button above to sync";
mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("Tap button above to sync products"));
 //BA.debugLineNum = 506;BA.debugLine="lblFetchStatus.TextColor = Colors.Gray";
mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
 //BA.debugLineNum = 509;BA.debugLine="Dim rsOrders As ResultSet = Main.SQLProducts.Exec";
_rsorders = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rsorders = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT COUNT(*) as count FROM orders WHERE sync_status = 'Holding' AND vendor_id = ? AND user_id = ?",new String[]{BA.NumberToString(mostCurrent._main._vendor_id /*int*/ ),BA.NumberToString(mostCurrent._main._loggedinuserid /*int*/ )})));
 //BA.debugLineNum = 512;BA.debugLine="rsOrders.NextRow";
_rsorders.NextRow();
 //BA.debugLineNum = 513;BA.debugLine="Dim pendingOrderCount As Int = rsOrders.GetInt(\"c";
_pendingordercount = _rsorders.GetInt("count");
 //BA.debugLineNum = 514;BA.debugLine="rsOrders.Close";
_rsorders.Close();
 //BA.debugLineNum = 516;BA.debugLine="If pendingOrderCount > 0 Then";
if (_pendingordercount>0) { 
 //BA.debugLineNum = 517;BA.debugLine="ToastMessageShow(\"You have \" & pendingOrderCount";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("You have "+BA.NumberToString(_pendingordercount)+" orders waiting to sync"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 519;BA.debugLine="End Sub";
return "";
}
}
