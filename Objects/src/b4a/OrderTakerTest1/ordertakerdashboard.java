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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.ordertakerdashboard");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnaddorder = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldash = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldashicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblhistory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblhistoryicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinventory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinventoryicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblloggedinuser = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllogout = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblorders = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblordersicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblperson = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbottomnav = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontent = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontentdash = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontenthistory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontentinventory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontentorders = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldash = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldim = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlhistory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlinventory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlorders = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnltop = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etcontentsearchorder = null;
public b4a.example3.customlistview _clvcontentorders = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfetchstatus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnfetchproducts = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svinventory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcacheinfo = null;
public b4a.OrderTakerTest1.main _main = null;
public b4a.OrderTakerTest1.controls _controls = null;
public b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public b4a.OrderTakerTest1.starter _starter = null;
public b4a.OrderTakerTest1.userorders _userorders = null;
public b4a.OrderTakerTest1.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Activity.LoadLayout(\"OrderTakerDashboard\")";
mostCurrent._activity.LoadLayout("OrderTakerDashboard",mostCurrent.activityBA);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="lblLoggedInUser.Text = \"Welcome, \" & Main.LoggedI";
mostCurrent._lblloggedinuser.setText(BA.ObjectToCharSequence("Welcome, "+mostCurrent._main._loggedinuser /*String*/ ));
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"CREATE TABLE IF NO";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("CREATE TABLE IF NOT EXISTS orders (order_id INTEGER PRIMARY KEY AUTOINCREMENT, vendor_id INTEGER, date_created TEXT, status TEXT, total_amount REAL)");
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"CREATE TABLE IF NO";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("CREATE TABLE IF NOT EXISTS order_items (order_item_id INTEGER PRIMARY KEY AUTOINCREMENT, order_id INTEGER, product_id INTEGER, quantity INTEGER, price REAL)");
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="ShowPanel(pnlContentDash)";
_showpanel(mostCurrent._pnlcontentdash);
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="UpdateDashboardStatus";
_updatedashboardstatus();
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="End Sub";
return "";
}
public static String  _showpanel(anywheresoftware.b4a.objects.PanelWrapper _paneltoshow) throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showpanel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showpanel", new Object[] {_paneltoshow}));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub ShowPanel(panelToShow As Panel)";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="pnlContentDash.Visible = False";
mostCurrent._pnlcontentdash.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="pnlContentOrders.Visible = False";
mostCurrent._pnlcontentorders.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="pnlContentInventory.Visible = False";
mostCurrent._pnlcontentinventory.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="pnlContentHistory.Visible = False";
mostCurrent._pnlcontenthistory.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="panelToShow.Visible = True";
_paneltoshow.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="End Sub";
return "";
}
public static String  _updatedashboardstatus() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatedashboardstatus", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatedashboardstatus", null));}
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
int _itemcount = 0;
long _minutesago = 0L;
String _timeago = "";
int _hoursago = 0;
int _daysago = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rsorders = null;
int _pendingcount = 0;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Private Sub UpdateDashboardStatus";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery(";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT COUNT(*) as count FROM items WHERE is_active = 1")));
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="rs.NextRow";
_rs.NextRow();
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Dim itemCount As Int = rs.GetInt(\"count\")";
_itemcount = _rs.GetInt("count");
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="If itemCount > 0 Then";
if (_itemcount>0) { 
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="If Main.ITEMS_LAST_SYNC > 0 Then";
if (mostCurrent._main._items_last_sync /*long*/ >0) { 
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="Dim minutesAgo As Long = (DateTime.Now - Main.I";
_minutesago = (long) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-mostCurrent._main._items_last_sync /*long*/ )/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="Dim timeAgo As String";
_timeago = "";
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="If minutesAgo < 1 Then";
if (_minutesago<1) { 
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="timeAgo = \"Just now\"";
_timeago = "Just now";
 }else 
{RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="Else If minutesAgo < 60 Then";
if (_minutesago<60) { 
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="timeAgo = minutesAgo & \" minutes ago\"";
_timeago = BA.NumberToString(_minutesago)+" minutes ago";
 }else 
{RDebugUtils.currentLine=2162706;
 //BA.debugLineNum = 2162706;BA.debugLine="Else If minutesAgo < 1440 Then  ' Less than 24";
if (_minutesago<1440) { 
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="Dim hoursAgo As Int = minutesAgo / 60";
_hoursago = (int) (_minutesago/(double)60);
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="timeAgo = hoursAgo & \" hours ago\"";
_timeago = BA.NumberToString(_hoursago)+" hours ago";
 }else {
RDebugUtils.currentLine=2162710;
 //BA.debugLineNum = 2162710;BA.debugLine="Dim daysAgo As Int = minutesAgo / 1440";
_daysago = (int) (_minutesago/(double)1440);
RDebugUtils.currentLine=2162711;
 //BA.debugLineNum = 2162711;BA.debugLine="timeAgo = daysAgo & \" days ago\"";
_timeago = BA.NumberToString(_daysago)+" days ago";
 }}}
;
RDebugUtils.currentLine=2162714;
 //BA.debugLineNum = 2162714;BA.debugLine="lblCacheInfo.Text = \"📦 \" & itemCount & \" produ";
mostCurrent._lblcacheinfo.setText(BA.ObjectToCharSequence("📦 "+BA.NumberToString(_itemcount)+" products cached | Last sync: "+_timeago));
RDebugUtils.currentLine=2162715;
 //BA.debugLineNum = 2162715;BA.debugLine="lblCacheInfo.TextColor = Colors.RGB(0, 100, 0)";
mostCurrent._lblcacheinfo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (100),(int) (0)));
RDebugUtils.currentLine=2162716;
 //BA.debugLineNum = 2162716;BA.debugLine="lblFetchStatus.Text = \"✓ Ready to take orders\"";
mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("✓ Ready to take orders"));
RDebugUtils.currentLine=2162717;
 //BA.debugLineNum = 2162717;BA.debugLine="lblFetchStatus.TextColor = Colors.RGB(0, 150, 0";
mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (150),(int) (0)));
 }else {
RDebugUtils.currentLine=2162719;
 //BA.debugLineNum = 2162719;BA.debugLine="lblCacheInfo.Text = \"📦 \" & itemCount & \" produ";
mostCurrent._lblcacheinfo.setText(BA.ObjectToCharSequence("📦 "+BA.NumberToString(_itemcount)+" products cached (sync time unknown)"));
RDebugUtils.currentLine=2162720;
 //BA.debugLineNum = 2162720;BA.debugLine="lblCacheInfo.TextColor = Colors.Gray";
mostCurrent._lblcacheinfo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
 }else {
RDebugUtils.currentLine=2162723;
 //BA.debugLineNum = 2162723;BA.debugLine="lblCacheInfo.Text = \"⚠ No products synced yet\"";
mostCurrent._lblcacheinfo.setText(BA.ObjectToCharSequence("⚠ No products synced yet"));
RDebugUtils.currentLine=2162724;
 //BA.debugLineNum = 2162724;BA.debugLine="lblCacheInfo.TextColor = Colors.RGB(200, 100, 0)";
mostCurrent._lblcacheinfo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (200),(int) (100),(int) (0)));
RDebugUtils.currentLine=2162725;
 //BA.debugLineNum = 2162725;BA.debugLine="lblFetchStatus.Text = \"Tap button above to sync";
mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("Tap button above to sync products"));
RDebugUtils.currentLine=2162726;
 //BA.debugLineNum = 2162726;BA.debugLine="lblFetchStatus.TextColor = Colors.Gray";
mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
RDebugUtils.currentLine=2162730;
 //BA.debugLineNum = 2162730;BA.debugLine="Dim rsOrders As ResultSet = Main.SQLProducts.Exec";
_rsorders = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rsorders = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT COUNT(*) as count FROM orders WHERE status = 'Pending'")));
RDebugUtils.currentLine=2162731;
 //BA.debugLineNum = 2162731;BA.debugLine="rsOrders.NextRow";
_rsorders.NextRow();
RDebugUtils.currentLine=2162732;
 //BA.debugLineNum = 2162732;BA.debugLine="Dim pendingCount As Int = rsOrders.GetInt(\"count\"";
_pendingcount = _rsorders.GetInt("count");
RDebugUtils.currentLine=2162733;
 //BA.debugLineNum = 2162733;BA.debugLine="rsOrders.Close";
_rsorders.Close();
RDebugUtils.currentLine=2162735;
 //BA.debugLineNum = 2162735;BA.debugLine="If pendingCount > 0 Then";
if (_pendingcount>0) { 
RDebugUtils.currentLine=2162736;
 //BA.debugLineNum = 2162736;BA.debugLine="ToastMessageShow(\"You have \" & pendingCount & \"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("You have "+BA.NumberToString(_pendingcount)+" pending orders to sync"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=2162738;
 //BA.debugLineNum = 2162738;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="LoadOrders";
_loadorders();
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static String  _loadorders() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadorders", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadorders", null));}
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rsorders = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblorderid = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltotal = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub LoadOrders";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="clvContentOrders.Clear";
mostCurrent._clvcontentorders._clear();
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Dim rsOrders As ResultSet = Main.SQLProducts.Exec";
_rsorders = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rsorders = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM orders ORDER BY order_id DESC")));
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Do While rsOrders.NextRow";
while (_rsorders.NextRow()) {
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="pnl.SetLayout(0, 0, clvContentOrders.AsView.Widt";
_pnl.SetLayout((int) (0),(int) (0),mostCurrent._clvcontentorders._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="Dim lblOrderID As Label";
_lblorderid = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1703945;
 //BA.debugLineNum = 1703945;BA.debugLine="lblOrderID.Initialize(\"\")";
_lblorderid.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="lblOrderID.Text = \"Order #\" & rsOrders.GetInt(\"o";
_lblorderid.setText(BA.ObjectToCharSequence("Order #"+BA.NumberToString(_rsorders.GetInt("order_id"))));
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="lblOrderID.TextSize = 16";
_lblorderid.setTextSize((float) (16));
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="lblOrderID.SetLayout(10dip, 5dip, 50%x, 25dip)";
_lblorderid.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=1703950;
 //BA.debugLineNum = 1703950;BA.debugLine="Dim lblTotal As Label";
_lbltotal = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1703951;
 //BA.debugLineNum = 1703951;BA.debugLine="lblTotal.Initialize(\"\")";
_lbltotal.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="lblTotal.Text = \"Total: ₱\" & rsOrders.GetDouble(";
_lbltotal.setText(BA.ObjectToCharSequence("Total: ₱"+BA.NumberToString(_rsorders.GetDouble("total_amount"))));
RDebugUtils.currentLine=1703953;
 //BA.debugLineNum = 1703953;BA.debugLine="lblTotal.SetLayout(10dip, 30dip, 50%x, 25dip)";
_lbltotal.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=1703955;
 //BA.debugLineNum = 1703955;BA.debugLine="pnl.AddView(lblOrderID, lblOrderID.Left, lblOrde";
_pnl.AddView((android.view.View)(_lblorderid.getObject()),_lblorderid.getLeft(),_lblorderid.getTop(),_lblorderid.getWidth(),_lblorderid.getHeight());
RDebugUtils.currentLine=1703956;
 //BA.debugLineNum = 1703956;BA.debugLine="pnl.AddView(lblTotal, lblTotal.Left, lblTotal.To";
_pnl.AddView((android.view.View)(_lbltotal.getObject()),_lbltotal.getLeft(),_lbltotal.getTop(),_lbltotal.getWidth(),_lbltotal.getHeight());
RDebugUtils.currentLine=1703958;
 //BA.debugLineNum = 1703958;BA.debugLine="clvContentOrders.Add(pnl, rsOrders.GetInt(\"order";
mostCurrent._clvcontentorders._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject())),(Object)(_rsorders.GetInt("order_id")));
 }
;
RDebugUtils.currentLine=1703960;
 //BA.debugLineNum = 1703960;BA.debugLine="rsOrders.Close";
_rsorders.Close();
RDebugUtils.currentLine=1703961;
 //BA.debugLineNum = 1703961;BA.debugLine="End Sub";
return "";
}
public static String  _bttnaddorder_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttnaddorder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bttnaddorder_click", null));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub bttnAddOrder_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="StartActivity(addOrderActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._addorderactivity.getObject()));
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="End Sub";
return "";
}
public static void  _bttnfetchproducts_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttnfetchproducts_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "bttnfetchproducts_click", null); return;}
ResumableSub_bttnFetchProducts_Click rsub = new ResumableSub_bttnFetchProducts_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_bttnFetchProducts_Click extends BA.ResumableSub {
public ResumableSub_bttnFetchProducts_Click(b4a.OrderTakerTest1.ordertakerdashboard parent) {
this.parent = parent;
}
b4a.OrderTakerTest1.ordertakerdashboard parent;
b4a.OrderTakerTest1.httpjob _j = null;
String _response = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _statusvalue = "";
anywheresoftware.b4a.objects.collections.List _items = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
int _itemid = 0;
String _itemcode = "";
String _itemname = "";
double _unitprice = 0;
String _barcode = "";
int _vendorid = 0;
int _isactive = 0;
int step27;
int limit27;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="bttnFetchProducts.Enabled = False";
parent.mostCurrent._bttnfetchproducts.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="bttnFetchProducts.Color = Colors.LightGray";
parent.mostCurrent._bttnfetchproducts.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="lblFetchStatus.Text = \"Connecting to server...\"";
parent.mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("Connecting to server..."));
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="lblFetchStatus.TextColor = Colors.Blue";
parent.mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="Dim j As HttpJob";
_j = new b4a.OrderTakerTest1.httpjob();
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",ordertakerdashboard.getObject());
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="j.Download(Main.API_URL)";
_j._download /*String*/ (null,parent.mostCurrent._main._api_url /*String*/ );
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ordertakerdashboard", "bttnfetchproducts_click"), (Object)(_j));
this.state = 35;
return;
case 35:
//C
this.state = 1;
_j = (b4a.OrderTakerTest1.httpjob) result[0];
;
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="If j.Success Then";
if (true) break;

case 1:
//if
this.state = 34;
if (_j._success /*boolean*/ ) { 
this.state = 3;
}else {
this.state = 33;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="Try";
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
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="Dim response As String = j.GetString";
_response = _j._getstring /*String*/ (null);
RDebugUtils.currentLine=2031632;
 //BA.debugLineNum = 2031632;BA.debugLine="If response = \"\" Or response = Null Then";
if (true) break;

case 7:
//if
this.state = 10;
if ((_response).equals("") || _response== null) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=2031633;
 //BA.debugLineNum = 2031633;BA.debugLine="lblFetchStatus.Text = \"ERROR: Empty response\"";
parent.mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("ERROR: Empty response"));
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
parent.mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="bttnFetchProducts.Enabled = True";
parent.mostCurrent._bttnfetchproducts.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031636;
 //BA.debugLineNum = 2031636;BA.debugLine="bttnFetchProducts.Color = Colors.Blue";
parent.mostCurrent._bttnfetchproducts.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=2031637;
 //BA.debugLineNum = 2031637;BA.debugLine="j.Release";
_j._release /*String*/ (null);
RDebugUtils.currentLine=2031638;
 //BA.debugLineNum = 2031638;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 10:
//C
this.state = 11;
;
RDebugUtils.currentLine=2031641;
 //BA.debugLineNum = 2031641;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2031642;
 //BA.debugLineNum = 2031642;BA.debugLine="parser.Initialize(response)";
_parser.Initialize(_response);
RDebugUtils.currentLine=2031643;
 //BA.debugLineNum = 2031643;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=2031645;
 //BA.debugLineNum = 2031645;BA.debugLine="Dim statusValue As String = root.Get(\"status\")";
_statusvalue = BA.ObjectToString(_root.Get((Object)("status")));
RDebugUtils.currentLine=2031647;
 //BA.debugLineNum = 2031647;BA.debugLine="If statusValue = \"success\" Then";
if (true) break;

case 11:
//if
this.state = 28;
if ((_statusvalue).equals("success")) { 
this.state = 13;
}else {
this.state = 27;
}if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=2031649;
 //BA.debugLineNum = 2031649;BA.debugLine="Main.SQLProducts.ExecNonQuery(\"DELETE FROM ite";
parent.mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DELETE FROM items");
RDebugUtils.currentLine=2031652;
 //BA.debugLineNum = 2031652;BA.debugLine="Dim items As List = root.Get(\"data\")";
_items = new anywheresoftware.b4a.objects.collections.List();
_items = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("data"))));
RDebugUtils.currentLine=2031654;
 //BA.debugLineNum = 2031654;BA.debugLine="For i = 0 To items.Size - 1";
if (true) break;

case 14:
//for
this.state = 25;
step27 = 1;
limit27 = (int) (_items.getSize()-1);
_i = (int) (0) ;
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
if (true) break;

case 16:
//C
this.state = 17;
RDebugUtils.currentLine=2031655;
 //BA.debugLineNum = 2031655;BA.debugLine="Dim item As Map = items.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_items.Get(_i)));
RDebugUtils.currentLine=2031657;
 //BA.debugLineNum = 2031657;BA.debugLine="Dim itemID As Int = item.Get(\"item_id\")";
_itemid = (int)(BA.ObjectToNumber(_item.Get((Object)("item_id"))));
RDebugUtils.currentLine=2031658;
 //BA.debugLineNum = 2031658;BA.debugLine="Dim itemCode As String = item.Get(\"item_code\"";
_itemcode = BA.ObjectToString(_item.Get((Object)("item_code")));
RDebugUtils.currentLine=2031659;
 //BA.debugLineNum = 2031659;BA.debugLine="Dim itemName As String = item.Get(\"item_name\"";
_itemname = BA.ObjectToString(_item.Get((Object)("item_name")));
RDebugUtils.currentLine=2031660;
 //BA.debugLineNum = 2031660;BA.debugLine="Dim unitPrice As Double = item.Get(\"unit_pric";
_unitprice = (double)(BA.ObjectToNumber(_item.Get((Object)("unit_price"))));
RDebugUtils.currentLine=2031662;
 //BA.debugLineNum = 2031662;BA.debugLine="Dim barcode As String = \"\"";
_barcode = "";
RDebugUtils.currentLine=2031663;
 //BA.debugLineNum = 2031663;BA.debugLine="If item.ContainsKey(\"barcode\") And item.Get(\"";
if (true) break;

case 17:
//if
this.state = 20;
if (_item.ContainsKey((Object)("barcode")) && _item.Get((Object)("barcode"))!= null) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
RDebugUtils.currentLine=2031664;
 //BA.debugLineNum = 2031664;BA.debugLine="barcode = item.Get(\"barcode\")";
_barcode = BA.ObjectToString(_item.Get((Object)("barcode")));
 if (true) break;

case 20:
//C
this.state = 21;
;
RDebugUtils.currentLine=2031667;
 //BA.debugLineNum = 2031667;BA.debugLine="Dim vendorID As Int = 0";
_vendorid = (int) (0);
RDebugUtils.currentLine=2031668;
 //BA.debugLineNum = 2031668;BA.debugLine="If item.ContainsKey(\"vendor_id\") And item.Get";
if (true) break;

case 21:
//if
this.state = 24;
if (_item.ContainsKey((Object)("vendor_id")) && _item.Get((Object)("vendor_id"))!= null) { 
this.state = 23;
}if (true) break;

case 23:
//C
this.state = 24;
RDebugUtils.currentLine=2031669;
 //BA.debugLineNum = 2031669;BA.debugLine="vendorID = item.Get(\"vendor_id\")";
_vendorid = (int)(BA.ObjectToNumber(_item.Get((Object)("vendor_id"))));
 if (true) break;

case 24:
//C
this.state = 37;
;
RDebugUtils.currentLine=2031672;
 //BA.debugLineNum = 2031672;BA.debugLine="Dim isActive As Int = 1";
_isactive = (int) (1);
RDebugUtils.currentLine=2031674;
 //BA.debugLineNum = 2031674;BA.debugLine="Main.SQLProducts.ExecNonQuery2(\"INSERT INTO i";
parent.mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO items VALUES (?, ?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_itemid),(Object)(_itemcode),(Object)(_itemname),(Object)(_unitprice),(Object)(_barcode),(Object)(_vendorid),(Object)(_isactive)}));
 if (true) break;
if (true) break;

case 25:
//C
this.state = 28;
;
RDebugUtils.currentLine=2031679;
 //BA.debugLineNum = 2031679;BA.debugLine="Main.ITEMS_LAST_SYNC = DateTime.Now";
parent.mostCurrent._main._items_last_sync /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=2031682;
 //BA.debugLineNum = 2031682;BA.debugLine="lblFetchStatus.Text = \"✓ Sync completed succes";
parent.mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("✓ Sync completed successfully!"));
RDebugUtils.currentLine=2031683;
 //BA.debugLineNum = 2031683;BA.debugLine="lblFetchStatus.TextColor = Colors.RGB(0, 150,";
parent.mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (150),(int) (0)));
RDebugUtils.currentLine=2031685;
 //BA.debugLineNum = 2031685;BA.debugLine="UpdateDashboardStatus";
_updatedashboardstatus();
RDebugUtils.currentLine=2031687;
 //BA.debugLineNum = 2031687;BA.debugLine="ToastMessageShow(\"Synced \" & items.Size & \" pr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Synced "+BA.NumberToString(_items.getSize())+" products"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 27:
//C
this.state = 28;
RDebugUtils.currentLine=2031689;
 //BA.debugLineNum = 2031689;BA.debugLine="lblFetchStatus.Text = \"ERROR: Server returned";
parent.mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("ERROR: Server returned error"));
RDebugUtils.currentLine=2031690;
 //BA.debugLineNum = 2031690;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
parent.mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 if (true) break;

case 28:
//C
this.state = 31;
;
 if (true) break;

case 30:
//C
this.state = 31;
this.catchState = 0;
RDebugUtils.currentLine=2031693;
 //BA.debugLineNum = 2031693;BA.debugLine="lblFetchStatus.Text = \"ERROR: \" & LastException";
parent.mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("ERROR: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()));
RDebugUtils.currentLine=2031694;
 //BA.debugLineNum = 2031694;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
parent.mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
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
RDebugUtils.currentLine=2031697;
 //BA.debugLineNum = 2031697;BA.debugLine="lblFetchStatus.Text = \"✗ Cannot connect. Check W";
parent.mostCurrent._lblfetchstatus.setText(BA.ObjectToCharSequence("✗ Cannot connect. Check WiFi and server."));
RDebugUtils.currentLine=2031698;
 //BA.debugLineNum = 2031698;BA.debugLine="lblFetchStatus.TextColor = Colors.Red";
parent.mostCurrent._lblfetchstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031699;
 //BA.debugLineNum = 2031699;BA.debugLine="ToastMessageShow(\"Network error. Using cached da";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Network error. Using cached data."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 34:
//C
this.state = -1;
;
RDebugUtils.currentLine=2031703;
 //BA.debugLineNum = 2031703;BA.debugLine="bttnFetchProducts.Enabled = True";
parent.mostCurrent._bttnfetchproducts.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031704;
 //BA.debugLineNum = 2031704;BA.debugLine="bttnFetchProducts.Color = Colors.Blue";
parent.mostCurrent._bttnfetchproducts.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=2031705;
 //BA.debugLineNum = 2031705;BA.debugLine="j.Release";
_j._release /*String*/ (null);
RDebugUtils.currentLine=2031706;
 //BA.debugLineNum = 2031706;BA.debugLine="End Sub";
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
public static String  _clvcontentorders_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clvcontentorders_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clvcontentorders_itemclick", new Object[] {_index,_value}));}
int _orderid = 0;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub clvContentOrders_ItemClick(Index As In";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim orderID As Int = Value";
_orderid = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="ToastMessageShow(\"Order #\" & orderID & \" clicked\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Order #"+BA.NumberToString(_orderid)+" clicked"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="End Sub";
return "";
}
public static String  _clvcontentorders_itemlongclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clvcontentorders_itemlongclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clvcontentorders_itemlongclick", new Object[] {_index,_value}));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub clvContentOrders_ItemLongClick(Index A";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="End Sub";
return "";
}
public static String  _lbllogout_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbllogout_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbllogout_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub lbllogout_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Main.LoggedInUser = \"\"";
mostCurrent._main._loggedinuser /*String*/  = "";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="End Sub";
return "";
}
public static String  _loadinventoryitems() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadinventoryitems", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadinventoryitems", null));}
int _top = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
anywheresoftware.b4a.objects.LabelWrapper _lblempty = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblprice = null;
anywheresoftware.b4a.objects.LabelWrapper _lblcode = null;
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Private Sub LoadInventoryItems";
RDebugUtils.currentLine=7208961;
 //BA.debugLineNum = 7208961;BA.debugLine="svInventory.Panel.RemoveAllViews";
mostCurrent._svinventory.getPanel().RemoveAllViews();
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="Dim top As Int = 0";
_top = (int) (0);
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery(";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM items WHERE is_active = 1 ORDER BY item_name")));
RDebugUtils.currentLine=7208966;
 //BA.debugLineNum = 7208966;BA.debugLine="If rs.RowCount = 0 Then";
if (_rs.getRowCount()==0) { 
RDebugUtils.currentLine=7208968;
 //BA.debugLineNum = 7208968;BA.debugLine="Dim lblEmpty As Label";
_lblempty = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7208969;
 //BA.debugLineNum = 7208969;BA.debugLine="lblEmpty.Initialize(\"\")";
_lblempty.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7208970;
 //BA.debugLineNum = 7208970;BA.debugLine="lblEmpty.Text = \"No products cached. Go to Dashb";
_lblempty.setText(BA.ObjectToCharSequence("No products cached. Go to Dashboard and sync first."));
RDebugUtils.currentLine=7208971;
 //BA.debugLineNum = 7208971;BA.debugLine="lblEmpty.TextSize = 14";
_lblempty.setTextSize((float) (14));
RDebugUtils.currentLine=7208972;
 //BA.debugLineNum = 7208972;BA.debugLine="lblEmpty.TextColor = Colors.Gray";
_lblempty.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7208973;
 //BA.debugLineNum = 7208973;BA.debugLine="lblEmpty.Gravity = Gravity.CENTER";
_lblempty.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=7208974;
 //BA.debugLineNum = 7208974;BA.debugLine="svInventory.Panel.AddView(lblEmpty, 0, 20dip, sv";
mostCurrent._svinventory.getPanel().AddView((android.view.View)(_lblempty.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),mostCurrent._svinventory.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7208975;
 //BA.debugLineNum = 7208975;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=7208976;
 //BA.debugLineNum = 7208976;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=7208979;
 //BA.debugLineNum = 7208979;BA.debugLine="Do While rs.NextRow";
while (_rs.NextRow()) {
RDebugUtils.currentLine=7208980;
 //BA.debugLineNum = 7208980;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=7208981;
 //BA.debugLineNum = 7208981;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7208982;
 //BA.debugLineNum = 7208982;BA.debugLine="pnl.Color = Colors.White";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=7208984;
 //BA.debugLineNum = 7208984;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7208985;
 //BA.debugLineNum = 7208985;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7208986;
 //BA.debugLineNum = 7208986;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
_lblname.setText(BA.ObjectToCharSequence(_rs.GetString("item_name")));
RDebugUtils.currentLine=7208987;
 //BA.debugLineNum = 7208987;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
RDebugUtils.currentLine=7208988;
 //BA.debugLineNum = 7208988;BA.debugLine="lblName.TextColor = Colors.Black";
_lblname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7208990;
 //BA.debugLineNum = 7208990;BA.debugLine="Dim lblPrice As Label";
_lblprice = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7208991;
 //BA.debugLineNum = 7208991;BA.debugLine="lblPrice.Initialize(\"\")";
_lblprice.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7208992;
 //BA.debugLineNum = 7208992;BA.debugLine="lblPrice.Text = \"₱\" & rs.GetDouble(\"unit_price\")";
_lblprice.setText(BA.ObjectToCharSequence("₱"+BA.NumberToString(_rs.GetDouble("unit_price"))));
RDebugUtils.currentLine=7208993;
 //BA.debugLineNum = 7208993;BA.debugLine="lblPrice.TextSize = 14";
_lblprice.setTextSize((float) (14));
RDebugUtils.currentLine=7208994;
 //BA.debugLineNum = 7208994;BA.debugLine="lblPrice.TextColor = Colors.RGB(0, 120, 0)  ' Gr";
_lblprice.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (120),(int) (0)));
RDebugUtils.currentLine=7208996;
 //BA.debugLineNum = 7208996;BA.debugLine="Dim lblCode As Label";
_lblcode = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7208997;
 //BA.debugLineNum = 7208997;BA.debugLine="lblCode.Initialize(\"\")";
_lblcode.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7208998;
 //BA.debugLineNum = 7208998;BA.debugLine="lblCode.Text = \"Code: \" & rs.GetString(\"item_cod";
_lblcode.setText(BA.ObjectToCharSequence("Code: "+_rs.GetString("item_code")));
RDebugUtils.currentLine=7208999;
 //BA.debugLineNum = 7208999;BA.debugLine="lblCode.TextSize = 12";
_lblcode.setTextSize((float) (12));
RDebugUtils.currentLine=7209000;
 //BA.debugLineNum = 7209000;BA.debugLine="lblCode.TextColor = Colors.Gray";
_lblcode.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7209002;
 //BA.debugLineNum = 7209002;BA.debugLine="pnl.AddView(lblName, 10dip, 5dip, svInventory.Wi";
_pnl.AddView((android.view.View)(_lblname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._svinventory.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=7209003;
 //BA.debugLineNum = 7209003;BA.debugLine="pnl.AddView(lblPrice, 10dip, 30dip, svInventory.";
_pnl.AddView((android.view.View)(_lblprice.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (mostCurrent._svinventory.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=7209004;
 //BA.debugLineNum = 7209004;BA.debugLine="pnl.AddView(lblCode, 10dip, 50dip, svInventory.W";
_pnl.AddView((android.view.View)(_lblcode.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._svinventory.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)));
RDebugUtils.currentLine=7209006;
 //BA.debugLineNum = 7209006;BA.debugLine="svInventory.Panel.AddView(pnl, 0, top, svInvento";
mostCurrent._svinventory.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_top,mostCurrent._svinventory.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)));
RDebugUtils.currentLine=7209007;
 //BA.debugLineNum = 7209007;BA.debugLine="top = top + 80dip";
_top = (int) (_top+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
 }
;
RDebugUtils.currentLine=7209009;
 //BA.debugLineNum = 7209009;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=7209011;
 //BA.debugLineNum = 7209011;BA.debugLine="svInventory.Panel.Height = top";
mostCurrent._svinventory.getPanel().setHeight(_top);
RDebugUtils.currentLine=7209012;
 //BA.debugLineNum = 7209012;BA.debugLine="End Sub";
return "";
}
public static String  _pnldash_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnldash_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnldash_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub pnlDash_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="ShowPanel(pnlContentDash)";
_showpanel(mostCurrent._pnlcontentdash);
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="UpdateDashboardStatus";
_updatedashboardstatus();
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="End Sub";
return "";
}
public static String  _pnldim_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnldim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnldim_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub pnlDim_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="End Sub";
return "";
}
public static String  _pnlhistory_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlhistory_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlhistory_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub pnlHistory_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="ShowPanel(pnlContentHistory)";
_showpanel(mostCurrent._pnlcontenthistory);
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
public static String  _pnlinventory_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlinventory_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlinventory_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub pnlInventory_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="ShowPanel(pnlContentInventory)";
_showpanel(mostCurrent._pnlcontentinventory);
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="LoadInventoryItems";
_loadinventoryitems();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="End Sub";
return "";
}
public static String  _pnlorders_click() throws Exception{
RDebugUtils.currentModule="ordertakerdashboard";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlorders_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlorders_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub pnlOrders_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="ShowPanel(pnlContentOrders)";
_showpanel(mostCurrent._pnlcontentorders);
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="bttnAddOrder.Visible = True";
mostCurrent._bttnaddorder.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="bttnAddOrder.BringToFront";
mostCurrent._bttnaddorder.BringToFront();
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="End Sub";
return "";
}
}