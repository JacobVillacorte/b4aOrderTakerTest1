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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.OrderTakerTest1.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
public static anywheresoftware.b4a.phone.Phone _p = null;
public static int _vendor_id = 0;
public static String _device_id = "";
public static anywheresoftware.b4a.sql.SQL _sqllogin = null;
public static anywheresoftware.b4a.sql.SQL _sqlproducts = null;
public static String _loggedinuser = "";
public static int _loggedinuserid = 0;
public static String _loggedinuserfullname = "";
public static int _loggedingroupid = 0;
public static int _loggedinconventionid = 0;
public static boolean _loggedinrequiresvendorselection = false;
public static anywheresoftware.b4a.objects.collections.List _assignedvendors = null;
public static String _api_url = "";
public static long _items_last_sync = 0L;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnlogin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etuser = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etpassword = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbluser = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpass = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblforgot = null;
public b4a.OrderTakerTest1.controls _controls = null;
public b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public b4a.OrderTakerTest1.starter _starter = null;
public b4a.OrderTakerTest1.userorders _userorders = null;
public b4a.OrderTakerTest1.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (forgotpass.mostCurrent != null);
vis = vis | (ordertakerdashboard.mostCurrent != null);
vis = vis | (addorderactivity.mostCurrent != null);
vis = vis | (userorders.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 52;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
 //BA.debugLineNum = 53;BA.debugLine="etpassword.PasswordMode = True";
mostCurrent._etpassword.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 55;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 56;BA.debugLine="GetAndSaveDeviceID";
_getandsavedeviceid();
 //BA.debugLineNum = 57;BA.debugLine="SetupLoginDatabase";
_setuplogindatabase();
 };
 //BA.debugLineNum = 60;BA.debugLine="SetupProductsDatabase";
_setupproductsdatabase();
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static void  _bttnlogin_click() throws Exception{
ResumableSub_bttnLogin_Click rsub = new ResumableSub_bttnLogin_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_bttnLogin_Click extends BA.ResumableSub {
public ResumableSub_bttnLogin_Click(b4a.OrderTakerTest1.main parent) {
this.parent = parent;
}
b4a.OrderTakerTest1.main parent;
String _username = "";
String _password = "";
anywheresoftware.b4a.objects.collections.Map _payload = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jg = null;
b4a.OrderTakerTest1.httpjob _j = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _status = "";
String _msg = "";
anywheresoftware.b4a.objects.collections.Map _data = null;
anywheresoftware.b4a.objects.collections.Map _firstvendor = null;

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
 //BA.debugLineNum = 108;BA.debugLine="Dim username As String = etuser.Text.Trim";
_username = parent.mostCurrent._etuser.getText().trim();
 //BA.debugLineNum = 109;BA.debugLine="Dim password As String = etpassword.Text.Trim";
_password = parent.mostCurrent._etpassword.getText().trim();
 //BA.debugLineNum = 111;BA.debugLine="If username = \"\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((_username).equals("")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 112;BA.debugLine="etuser.RequestFocus";
parent.mostCurrent._etuser.RequestFocus();
 //BA.debugLineNum = 113;BA.debugLine="ToastMessageShow(\"Please enter your username\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your username"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 114;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 117;BA.debugLine="If password = \"\" Then";

case 4:
//if
this.state = 7;
if ((_password).equals("")) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 118;BA.debugLine="etpassword.RequestFocus";
parent.mostCurrent._etpassword.RequestFocus();
 //BA.debugLineNum = 119;BA.debugLine="ToastMessageShow(\"Please enter your password\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your password"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 120;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 123;BA.debugLine="Dim payload As Map";
_payload = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 124;BA.debugLine="payload.Initialize";
_payload.Initialize();
 //BA.debugLineNum = 125;BA.debugLine="payload.Put(\"login_name\", username)";
_payload.Put((Object)("login_name"),(Object)(_username));
 //BA.debugLineNum = 126;BA.debugLine="payload.Put(\"password\", password)";
_payload.Put((Object)("password"),(Object)(_password));
 //BA.debugLineNum = 127;BA.debugLine="payload.Put(\"convention_id\", LoggedInConventionID";
_payload.Put((Object)("convention_id"),(Object)(parent._loggedinconventionid));
 //BA.debugLineNum = 129;BA.debugLine="Dim jg As JSONGenerator";
_jg = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 130;BA.debugLine="jg.Initialize(payload)";
_jg.Initialize(_payload);
 //BA.debugLineNum = 132;BA.debugLine="ProgressDialogShow(\"Logging in...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Logging in..."));
 //BA.debugLineNum = 134;BA.debugLine="Dim j As HttpJob";
_j = new b4a.OrderTakerTest1.httpjob();
 //BA.debugLineNum = 135;BA.debugLine="j.Initialize(\"LoginOrderTaker\", Me)";
_j._initialize /*String*/ (processBA,"LoginOrderTaker",main.getObject());
 //BA.debugLineNum = 136;BA.debugLine="j.PostString(API_URL & \"login_order_taker.php\", j";
_j._poststring /*String*/ (parent._api_url+"login_order_taker.php",_jg.ToString());
 //BA.debugLineNum = 137;BA.debugLine="j.GetRequest.SetContentType(\"application/json\")";
_j._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 139;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 61;
return;
case 61:
//C
this.state = 8;
_j = (b4a.OrderTakerTest1.httpjob) result[0];
;
 //BA.debugLineNum = 140;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 142;BA.debugLine="If j.Success = False Then";
if (true) break;

case 8:
//if
this.state = 17;
if (_j._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 143;BA.debugLine="If TryOfflineLogin(username, password) Then";
if (true) break;

case 11:
//if
this.state = 16;
if (_tryofflinelogin(_username,_password)) { 
this.state = 13;
}else {
this.state = 15;
}if (true) break;

case 13:
//C
this.state = 16;
 //BA.debugLineNum = 144;BA.debugLine="ToastMessageShow(\"Offline login mode.\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Offline login mode."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 145;BA.debugLine="StartActivity(OrderTakerDashboard)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._ordertakerdashboard.getObject()));
 //BA.debugLineNum = 146;BA.debugLine="Controls.SetAnimation(\"slide_left_in\", \"slide_l";
parent.mostCurrent._controls._setanimation /*String*/ (mostCurrent.activityBA,"slide_left_in","slide_left_out");
 //BA.debugLineNum = 147;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 149;BA.debugLine="ToastMessageShow(\"Cannot reach server and no of";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Cannot reach server and no offline login found."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 16:
//C
this.state = 17;
;
 //BA.debugLineNum = 151;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 152;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 155;BA.debugLine="Try";

case 17:
//try
this.state = 60;
this.catchState = 59;
this.state = 19;
if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 59;
 //BA.debugLineNum = 156;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 157;BA.debugLine="parser.Initialize(j.GetString)";
_parser.Initialize(_j._getstring /*String*/ ());
 //BA.debugLineNum = 158;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 160;BA.debugLine="Dim status As String = root.Get(\"status\")";
_status = BA.ObjectToString(_root.Get((Object)("status")));
 //BA.debugLineNum = 161;BA.debugLine="Dim msg As String = \"\"";
_msg = "";
 //BA.debugLineNum = 162;BA.debugLine="If root.ContainsKey(\"message\") And root.Get(\"mes";
if (true) break;

case 20:
//if
this.state = 25;
if (_root.ContainsKey((Object)("message")) && _root.Get((Object)("message"))!= null) { 
this.state = 22;
;}if (true) break;

case 22:
//C
this.state = 25;
_msg = BA.ObjectToString(_root.Get((Object)("message")));
if (true) break;

case 25:
//C
this.state = 26;
;
 //BA.debugLineNum = 164;BA.debugLine="If status <> \"success\" Then";
if (true) break;

case 26:
//if
this.state = 35;
if ((_status).equals("success") == false) { 
this.state = 28;
}if (true) break;

case 28:
//C
this.state = 29;
 //BA.debugLineNum = 165;BA.debugLine="If msg = \"\" Then msg = \"Login failed.\"";
if (true) break;

case 29:
//if
this.state = 34;
if ((_msg).equals("")) { 
this.state = 31;
;}if (true) break;

case 31:
//C
this.state = 34;
_msg = "Login failed.";
if (true) break;

case 34:
//C
this.state = 35;
;
 //BA.debugLineNum = 166;BA.debugLine="ToastMessageShow(msg, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_msg),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 167;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 168;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 35:
//C
this.state = 36;
;
 //BA.debugLineNum = 171;BA.debugLine="Dim data As Map = root.Get(\"data\")";
_data = new anywheresoftware.b4a.objects.collections.Map();
_data = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_root.Get((Object)("data"))));
 //BA.debugLineNum = 173;BA.debugLine="LoggedInUser = data.Get(\"login_name\")";
parent._loggedinuser = BA.ObjectToString(_data.Get((Object)("login_name")));
 //BA.debugLineNum = 174;BA.debugLine="LoggedInUserID = data.Get(\"user_id\")";
parent._loggedinuserid = (int)(BA.ObjectToNumber(_data.Get((Object)("user_id"))));
 //BA.debugLineNum = 175;BA.debugLine="LoggedInUserFullName = data.Get(\"full_name\")";
parent._loggedinuserfullname = BA.ObjectToString(_data.Get((Object)("full_name")));
 //BA.debugLineNum = 176;BA.debugLine="LoggedInGroupID = data.Get(\"group_id\")";
parent._loggedingroupid = (int)(BA.ObjectToNumber(_data.Get((Object)("group_id"))));
 //BA.debugLineNum = 178;BA.debugLine="If data.ContainsKey(\"convention_id\") And data.Ge";
if (true) break;

case 36:
//if
this.state = 39;
if (_data.ContainsKey((Object)("convention_id")) && _data.Get((Object)("convention_id"))!= null) { 
this.state = 38;
}if (true) break;

case 38:
//C
this.state = 39;
 //BA.debugLineNum = 179;BA.debugLine="LoggedInConventionID = data.Get(\"convention_id\"";
parent._loggedinconventionid = (int)(BA.ObjectToNumber(_data.Get((Object)("convention_id"))));
 if (true) break;

case 39:
//C
this.state = 40;
;
 //BA.debugLineNum = 182;BA.debugLine="LoggedInRequiresVendorSelection = False";
parent._loggedinrequiresvendorselection = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 183;BA.debugLine="If data.ContainsKey(\"requires_vendor_selection\")";
if (true) break;

case 40:
//if
this.state = 43;
if (_data.ContainsKey((Object)("requires_vendor_selection")) && _data.Get((Object)("requires_vendor_selection"))!= null) { 
this.state = 42;
}if (true) break;

case 42:
//C
this.state = 43;
 //BA.debugLineNum = 184;BA.debugLine="LoggedInRequiresVendorSelection = data.Get(\"req";
parent._loggedinrequiresvendorselection = BA.ObjectToBoolean(_data.Get((Object)("requires_vendor_selection")));
 if (true) break;

case 43:
//C
this.state = 44;
;
 //BA.debugLineNum = 187;BA.debugLine="VENDOR_ID = 0";
parent._vendor_id = (int) (0);
 //BA.debugLineNum = 188;BA.debugLine="If data.ContainsKey(\"vendor_id\") And data.Get(\"v";
if (true) break;

case 44:
//if
this.state = 47;
if (_data.ContainsKey((Object)("vendor_id")) && _data.Get((Object)("vendor_id"))!= null) { 
this.state = 46;
}if (true) break;

case 46:
//C
this.state = 47;
 //BA.debugLineNum = 189;BA.debugLine="VENDOR_ID = data.Get(\"vendor_id\")";
parent._vendor_id = (int)(BA.ObjectToNumber(_data.Get((Object)("vendor_id"))));
 if (true) break;

case 47:
//C
this.state = 48;
;
 //BA.debugLineNum = 192;BA.debugLine="AssignedVendors.Initialize";
parent._assignedvendors.Initialize();
 //BA.debugLineNum = 193;BA.debugLine="If data.ContainsKey(\"assigned_vendors\") And data";
if (true) break;

case 48:
//if
this.state = 51;
if (_data.ContainsKey((Object)("assigned_vendors")) && _data.Get((Object)("assigned_vendors"))!= null) { 
this.state = 50;
}if (true) break;

case 50:
//C
this.state = 51;
 //BA.debugLineNum = 194;BA.debugLine="AssignedVendors = data.Get(\"assigned_vendors\")";
parent._assignedvendors = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_data.Get((Object)("assigned_vendors"))));
 if (true) break;
;
 //BA.debugLineNum = 197;BA.debugLine="If VENDOR_ID = 0 And AssignedVendors.IsInitializ";

case 51:
//if
this.state = 54;
if (parent._vendor_id==0 && parent._assignedvendors.IsInitialized() && parent._assignedvendors.getSize()>0) { 
this.state = 53;
}if (true) break;

case 53:
//C
this.state = 54;
 //BA.debugLineNum = 198;BA.debugLine="Dim firstVendor As Map = AssignedVendors.Get(0)";
_firstvendor = new anywheresoftware.b4a.objects.collections.Map();
_firstvendor = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent._assignedvendors.Get((int) (0))));
 //BA.debugLineNum = 199;BA.debugLine="VENDOR_ID = firstVendor.Get(\"vendor_id\")";
parent._vendor_id = (int)(BA.ObjectToNumber(_firstvendor.Get((Object)("vendor_id"))));
 //BA.debugLineNum = 200;BA.debugLine="ToastMessageShow(\"Multiple vendor assignments f";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Multiple vendor assignments found. Using first vendor for now."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
 //BA.debugLineNum = 203;BA.debugLine="If VENDOR_ID <= 0 Then";

case 54:
//if
this.state = 57;
if (parent._vendor_id<=0) { 
this.state = 56;
}if (true) break;

case 56:
//C
this.state = 57;
 //BA.debugLineNum = 204;BA.debugLine="ToastMessageShow(\"No vendor assignment found fo";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No vendor assignment found for this user."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 205;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 206;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 57:
//C
this.state = 60;
;
 //BA.debugLineNum = 209;BA.debugLine="SaveOfflineLoginCache(username, password, Logged";
_saveofflinelogincache(_username,_password,parent._loggedinuserid,parent._loggedinuserfullname,parent._loggedingroupid,parent._vendor_id,parent._loggedinconventionid);
 //BA.debugLineNum = 210;BA.debugLine="HandleUserSwitchCacheReset(LoggedInUserID)";
_handleuserswitchcachereset(parent._loggedinuserid);
 //BA.debugLineNum = 212;BA.debugLine="ToastMessageShow(\"Login Successful!\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Login Successful!"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 213;BA.debugLine="StartActivity(OrderTakerDashboard)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._ordertakerdashboard.getObject()));
 //BA.debugLineNum = 214;BA.debugLine="Controls.SetAnimation(\"slide_left_in\", \"slide_le";
parent.mostCurrent._controls._setanimation /*String*/ (mostCurrent.activityBA,"slide_left_in","slide_left_out");
 //BA.debugLineNum = 215;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 59:
//C
this.state = 60;
this.catchState = 0;
 //BA.debugLineNum = 218;BA.debugLine="ToastMessageShow(\"Invalid login response from se";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Invalid login response from server."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;
if (true) break;

case 60:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 221;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
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
public static void  _jobdone(b4a.OrderTakerTest1.httpjob _j) throws Exception{
}
public static String  _getandsavedeviceid() throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Private Sub GetAndSaveDeviceID";
 //BA.debugLineNum = 71;BA.debugLine="DEVICE_ID = p.GetSettings(\"android_id\")";
_device_id = _p.GetSettings("android_id");
 //BA.debugLineNum = 72;BA.debugLine="Log(\"Device ID: \" & DEVICE_ID)";
anywheresoftware.b4a.keywords.Common.LogImpl("0327682","Device ID: "+_device_id,0);
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 41;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private bttnLogin As Button";
mostCurrent._bttnlogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private etuser As EditText";
mostCurrent._etuser = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private etpassword As EditText";
mostCurrent._etpassword = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private lbluser As Label";
mostCurrent._lbluser = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private lblpass As Label";
mostCurrent._lblpass = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private lblforgot As Label";
mostCurrent._lblforgot = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String  _handleuserswitchcachereset(int _newuserid) throws Exception{
int _lastuserid = 0;
String _txt = "";
 //BA.debugLineNum = 261;BA.debugLine="Private Sub HandleUserSwitchCacheReset(newUserID A";
 //BA.debugLineNum = 262;BA.debugLine="Dim lastUserID As Int = 0";
_lastuserid = (int) (0);
 //BA.debugLineNum = 264;BA.debugLine="If File.Exists(File.DirInternal, \"last_user_id.tx";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"last_user_id.txt")) { 
 //BA.debugLineNum = 265;BA.debugLine="Dim txt As String = File.ReadString(File.DirInte";
_txt = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"last_user_id.txt");
 //BA.debugLineNum = 266;BA.debugLine="If txt <> \"\" Then lastUserID = txt";
if ((_txt).equals("") == false) { 
_lastuserid = (int)(Double.parseDouble(_txt));};
 };
 //BA.debugLineNum = 270;BA.debugLine="If lastUserID > 0 And lastUserID <> newUserID The";
if (_lastuserid>0 && _lastuserid!=_newuserid) { 
 //BA.debugLineNum = 271;BA.debugLine="Log(\"User switched. Keeping cached items for off";
anywheresoftware.b4a.keywords.Common.LogImpl("0720906","User switched. Keeping cached items for offline use.",0);
 };
 //BA.debugLineNum = 274;BA.debugLine="File.WriteString(File.DirInternal, \"last_user_id.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"last_user_id.txt",BA.NumberToString(_newuserid));
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public static String  _lblforgot_click() throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Private Sub lblforgot_Click";
 //BA.debugLineNum = 281;BA.debugLine="StartActivity(forgotPass)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._forgotpass.getObject()));
 //BA.debugLineNum = 282;BA.debugLine="Controls.SetAnimation(\"slide_up_in\", \"slide_up_ou";
mostCurrent._controls._setanimation /*String*/ (mostCurrent.activityBA,"slide_up_in","slide_up_out");
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
controls._process_globals();
forgotpass._process_globals();
ordertakerdashboard._process_globals();
addorderactivity._process_globals();
starter._process_globals();
userorders._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 17;BA.debugLine="Public VENDOR_ID As Int = 0";
_vendor_id = (int) (0);
 //BA.debugLineNum = 18;BA.debugLine="Public DEVICE_ID As String";
_device_id = "";
 //BA.debugLineNum = 21;BA.debugLine="Public SQLLogin As SQL";
_sqllogin = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 22;BA.debugLine="Public SQLProducts As SQL";
_sqlproducts = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 25;BA.debugLine="Public LoggedInUser As String";
_loggedinuser = "";
 //BA.debugLineNum = 26;BA.debugLine="Public LoggedInUserID As Int";
_loggedinuserid = 0;
 //BA.debugLineNum = 27;BA.debugLine="Public LoggedInUserFullName As String";
_loggedinuserfullname = "";
 //BA.debugLineNum = 28;BA.debugLine="Public LoggedInGroupID As Int";
_loggedingroupid = 0;
 //BA.debugLineNum = 29;BA.debugLine="Public LoggedInConventionID As Int = 5";
_loggedinconventionid = (int) (5);
 //BA.debugLineNum = 30;BA.debugLine="Public LoggedInRequiresVendorSelection As Boolean";
_loggedinrequiresvendorselection = false;
 //BA.debugLineNum = 31;BA.debugLine="Public AssignedVendors As List";
_assignedvendors = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 34;BA.debugLine="Public API_URL As String = \"http://192.168.8.225/";
_api_url = "http://192.168.8.225/ordertaker_api/";
 //BA.debugLineNum = 35;BA.debugLine="Public ITEMS_LAST_SYNC As Long = 0";
_items_last_sync = (long) (0);
 //BA.debugLineNum = 37;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _saveofflinelogincache(String _loginname,String _plainpassword,int _userid,String _fullname,int _groupid,int _vendorid,int _conventionid) throws Exception{
 //BA.debugLineNum = 224;BA.debugLine="Private Sub SaveOfflineLoginCache(loginName As Str";
 //BA.debugLineNum = 225;BA.debugLine="SQLLogin.ExecNonQuery2( _         \"INSERT OR REPL";
_sqllogin.ExecNonQuery2("INSERT OR REPLACE INTO offline_login_cache (login_name, password, user_id, full_name, group_id, vendor_id, convention_id, last_verified) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_loginname),(Object)(_plainpassword),(Object)(_userid),(Object)(_fullname),(Object)(_groupid),(Object)(_vendorid),(Object)(_conventionid),(Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow())}));
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public static String  _setuplogindatabase() throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Sub SetupLoginDatabase";
 //BA.debugLineNum = 77;BA.debugLine="If File.Exists(File.DirInternal, \"loginTest1.db\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"loginTest1.db")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 78;BA.debugLine="File.Copy(File.DirAssets, \"loginTest1.db\", File.";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"loginTest1.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"loginTest1.db");
 };
 //BA.debugLineNum = 80;BA.debugLine="SQLLogin.Initialize(File.DirInternal, \"loginTest1";
_sqllogin.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"loginTest1.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 82;BA.debugLine="SQLLogin.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS";
_sqllogin.ExecNonQuery("CREATE TABLE IF NOT EXISTS offline_login_cache ("+"login_name TEXT PRIMARY KEY, "+"password TEXT, "+"user_id INTEGER, "+"full_name TEXT, "+"group_id INTEGER, "+"vendor_id INTEGER, "+"convention_id INTEGER, "+"last_verified INTEGER)");
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _setupproductsdatabase() throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Private Sub SetupProductsDatabase";
 //BA.debugLineNum = 95;BA.debugLine="SQLProducts.Initialize(File.DirInternal, \"product";
_sqlproducts.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"productsTest1.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 96;BA.debugLine="SQLProducts.ExecNonQuery(\"CREATE TABLE IF NOT EXI";
_sqlproducts.ExecNonQuery("CREATE TABLE IF NOT EXISTS items ("+"item_id INTEGER PRIMARY KEY, "+"item_code TEXT, "+"item_name TEXT, "+"unit_price REAL, "+"barcode TEXT, "+"vendor_id INTEGER, "+"is_active INTEGER)");
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public static boolean  _tryofflinelogin(String _loginname,String _plainpassword) throws Exception{
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
 //BA.debugLineNum = 230;BA.debugLine="Private Sub TryOfflineLogin(loginName As String, p";
 //BA.debugLineNum = 231;BA.debugLine="Try";
try { //BA.debugLineNum = 232;BA.debugLine="Dim rs As ResultSet = SQLLogin.ExecQuery2( _";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sqllogin.ExecQuery2("SELECT * FROM offline_login_cache WHERE login_name = ? AND password = ? AND group_id = 4",new String[]{_loginname,_plainpassword})));
 //BA.debugLineNum = 236;BA.debugLine="If rs.RowCount = 0 Then";
if (_rs.getRowCount()==0) { 
 //BA.debugLineNum = 237;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 238;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 241;BA.debugLine="rs.Position = 0";
_rs.setPosition((int) (0));
 //BA.debugLineNum = 242;BA.debugLine="LoggedInUser = rs.GetString(\"login_name\")";
_loggedinuser = _rs.GetString("login_name");
 //BA.debugLineNum = 243;BA.debugLine="LoggedInUserID = rs.GetInt(\"user_id\")";
_loggedinuserid = _rs.GetInt("user_id");
 //BA.debugLineNum = 244;BA.debugLine="LoggedInUserFullName = rs.GetString(\"full_name\")";
_loggedinuserfullname = _rs.GetString("full_name");
 //BA.debugLineNum = 245;BA.debugLine="LoggedInGroupID = rs.GetInt(\"group_id\")";
_loggedingroupid = _rs.GetInt("group_id");
 //BA.debugLineNum = 246;BA.debugLine="LoggedInConventionID = rs.GetInt(\"convention_id\"";
_loggedinconventionid = _rs.GetInt("convention_id");
 //BA.debugLineNum = 247;BA.debugLine="VENDOR_ID = rs.GetInt(\"vendor_id\")";
_vendor_id = _rs.GetInt("vendor_id");
 //BA.debugLineNum = 248;BA.debugLine="LoggedInRequiresVendorSelection = False";
_loggedinrequiresvendorselection = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 249;BA.debugLine="AssignedVendors.Initialize";
_assignedvendors.Initialize();
 //BA.debugLineNum = 250;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 252;BA.debugLine="If VENDOR_ID <= 0 Then Return False";
if (_vendor_id<=0) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 254;BA.debugLine="HandleUserSwitchCacheReset(LoggedInUserID)";
_handleuserswitchcachereset(_loggedinuserid);
 //BA.debugLineNum = 255;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e21) {
			processBA.setLastException(e21); //BA.debugLineNum = 257;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return false;
}
}
