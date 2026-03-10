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

public class addorderactivity extends Activity implements B4AActivity{
	public static addorderactivity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.addorderactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (addorderactivity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.addorderactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.OrderTakerTest1.addorderactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (addorderactivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (addorderactivity) Resume **");
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
		return addorderactivity.class;
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
            BA.LogInfo("** Activity (addorderactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (addorderactivity) Pause event (activity is not paused). **");
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
            addorderactivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (addorderactivity) Resume **");
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
public anywheresoftware.b4a.objects.collections.List _cartitems = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnaddorderactivity = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnpurchasenow = null;
public b4a.example3.customlistview _clvproducts = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etsearchproducts = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexitorderactivity = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexitselectitems = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltotalitems = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltotalamount = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnladdorderactivitytop = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnladdorderactivitywhole = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldim = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselectitems = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svcartsummary = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlquantity = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblquantitytitle = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttncancelqty = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblselecteditem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnminus = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblquantityvalue = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnadd = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnaddtocartqty = null;
public static int _selecteditemid = 0;
public static String _selecteditemname = "";
public static double _selecteditemprice = 0;
public b4a.OrderTakerTest1.main _main = null;
public b4a.OrderTakerTest1.controls _controls = null;
public b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public b4a.OrderTakerTest1.starter _starter = null;
public b4a.OrderTakerTest1.userorders _userorders = null;
public b4a.OrderTakerTest1.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Activity.LoadLayout(\"addOrderActivity\")";
mostCurrent._activity.LoadLayout("addOrderActivity",mostCurrent.activityBA);
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="CartItems.Initialize";
mostCurrent._cartitems.Initialize();
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="bttnPurchaseNow.Enabled = False";
mostCurrent._bttnpurchasenow.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="bttnPurchaseNow.Color = Colors.ARGB(80, 0, 0, 255";
mostCurrent._bttnpurchasenow.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (80),(int) (0),(int) (0),(int) (255)));
RDebugUtils.currentLine=2359304;
 //BA.debugLineNum = 2359304;BA.debugLine="LoadProducts";
_loadproducts();
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="End Sub";
return "";
}
public static String  _loadproducts() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadproducts", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadproducts", null));}
String _searchtext = "";
String _query = "";
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblprice = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsku = null;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Private Sub LoadProducts";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="clvProducts.Clear";
mostCurrent._clvproducts._clear();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Dim searchText As String = etSearchProducts.Text.";
_searchtext = mostCurrent._etsearchproducts.getText().trim().toLowerCase();
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="Dim query As String";
_query = "";
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="If searchText = \"\" Then";
if ((_searchtext).equals("")) { 
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="query = \"SELECT * FROM items WHERE is_active = 1";
_query = "SELECT * FROM items WHERE is_active = 1 ORDER BY item_name";
 }else {
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="query = \"SELECT * FROM items WHERE is_active = 1";
_query = "SELECT * FROM items WHERE is_active = 1 AND (LOWER(item_name) LIKE '%"+_searchtext+"%' OR LOWER(item_code) LIKE '%"+_searchtext+"%') ORDER BY item_name";
 };
RDebugUtils.currentLine=3080206;
 //BA.debugLineNum = 3080206;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery(";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery(_query)));
RDebugUtils.currentLine=3080208;
 //BA.debugLineNum = 3080208;BA.debugLine="If rs.RowCount = 0 Then";
if (_rs.getRowCount()==0) { 
RDebugUtils.currentLine=3080209;
 //BA.debugLineNum = 3080209;BA.debugLine="ToastMessageShow(\"No products found matching '\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No products found matching '"+_searchtext+"'"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3080210;
 //BA.debugLineNum = 3080210;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=3080211;
 //BA.debugLineNum = 3080211;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3080214;
 //BA.debugLineNum = 3080214;BA.debugLine="Do While rs.NextRow";
while (_rs.NextRow()) {
RDebugUtils.currentLine=3080215;
 //BA.debugLineNum = 3080215;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3080216;
 //BA.debugLineNum = 3080216;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3080217;
 //BA.debugLineNum = 3080217;BA.debugLine="pnl.SetLayout(0, 0, clvProducts.AsView.Width, 70";
_pnl.SetLayout((int) (0),(int) (0),mostCurrent._clvproducts._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=3080219;
 //BA.debugLineNum = 3080219;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3080220;
 //BA.debugLineNum = 3080220;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3080221;
 //BA.debugLineNum = 3080221;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
_lblname.setText(BA.ObjectToCharSequence(_rs.GetString("item_name")));
RDebugUtils.currentLine=3080222;
 //BA.debugLineNum = 3080222;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
RDebugUtils.currentLine=3080223;
 //BA.debugLineNum = 3080223;BA.debugLine="lblName.SetLayout(10dip, 5dip, 70%x, 25dip)";
_lblname.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=3080225;
 //BA.debugLineNum = 3080225;BA.debugLine="Dim lblPrice As Label";
_lblprice = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3080226;
 //BA.debugLineNum = 3080226;BA.debugLine="lblPrice.Initialize(\"\")";
_lblprice.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3080227;
 //BA.debugLineNum = 3080227;BA.debugLine="lblPrice.Text = \"₱\" & rs.GetDouble(\"unit_price\")";
_lblprice.setText(BA.ObjectToCharSequence("₱"+BA.NumberToString(_rs.GetDouble("unit_price"))));
RDebugUtils.currentLine=3080228;
 //BA.debugLineNum = 3080228;BA.debugLine="lblPrice.SetLayout(10dip, 30dip, 70%x, 20dip)";
_lblprice.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=3080230;
 //BA.debugLineNum = 3080230;BA.debugLine="Dim lblSku As Label";
_lblsku = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3080231;
 //BA.debugLineNum = 3080231;BA.debugLine="lblSku.Initialize(\"\")";
_lblsku.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3080232;
 //BA.debugLineNum = 3080232;BA.debugLine="lblSku.Text = \"SKU: \" & rs.GetString(\"item_code\"";
_lblsku.setText(BA.ObjectToCharSequence("SKU: "+_rs.GetString("item_code")));
RDebugUtils.currentLine=3080233;
 //BA.debugLineNum = 3080233;BA.debugLine="lblSku.TextSize = 12";
_lblsku.setTextSize((float) (12));
RDebugUtils.currentLine=3080234;
 //BA.debugLineNum = 3080234;BA.debugLine="lblSku.SetLayout(10dip, 50dip, 70%x, 15dip)";
_lblsku.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)));
RDebugUtils.currentLine=3080236;
 //BA.debugLineNum = 3080236;BA.debugLine="pnl.AddView(lblName, lblName.Left, lblName.Top,";
_pnl.AddView((android.view.View)(_lblname.getObject()),_lblname.getLeft(),_lblname.getTop(),_lblname.getWidth(),_lblname.getHeight());
RDebugUtils.currentLine=3080237;
 //BA.debugLineNum = 3080237;BA.debugLine="pnl.AddView(lblPrice, lblPrice.Left, lblPrice.To";
_pnl.AddView((android.view.View)(_lblprice.getObject()),_lblprice.getLeft(),_lblprice.getTop(),_lblprice.getWidth(),_lblprice.getHeight());
RDebugUtils.currentLine=3080238;
 //BA.debugLineNum = 3080238;BA.debugLine="pnl.AddView(lblSku, lblSku.Left, lblSku.Top, lbl";
_pnl.AddView((android.view.View)(_lblsku.getObject()),_lblsku.getLeft(),_lblsku.getTop(),_lblsku.getWidth(),_lblsku.getHeight());
RDebugUtils.currentLine=3080240;
 //BA.debugLineNum = 3080240;BA.debugLine="clvProducts.Add(pnl, rs.GetInt(\"item_id\"))";
mostCurrent._clvproducts._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject())),(Object)(_rs.GetInt("item_id")));
 }
;
RDebugUtils.currentLine=3080242;
 //BA.debugLineNum = 3080242;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=3080243;
 //BA.debugLineNum = 3080243;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="addorderactivity";
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="End Sub";
return "";
}
public static String  _bttnadd_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttnadd_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bttnadd_click", null));}
int _currentqty = 0;
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Private Sub bttnAdd_Click";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="Dim currentQty As Int = lblQuantityValue.Text";
_currentqty = (int)(Double.parseDouble(mostCurrent._lblquantityvalue.getText()));
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="If currentQty < 999 Then";
if (_currentqty<999) { 
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="lblQuantityValue.Text = (currentQty + 1)";
mostCurrent._lblquantityvalue.setText(BA.ObjectToCharSequence((_currentqty+1)));
 }else {
RDebugUtils.currentLine=7798789;
 //BA.debugLineNum = 7798789;BA.debugLine="ToastMessageShow(\"Maximum quantity is 999\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Maximum quantity is 999"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=7798791;
 //BA.debugLineNum = 7798791;BA.debugLine="End Sub";
return "";
}
public static String  _bttnaddorderactivity_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttnaddorderactivity_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bttnaddorderactivity_click", null));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Private Sub bttnAddOrderActivity_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="pnlDim.Visible = True";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="pnlSelectItems.Visible = True";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="pnlDim.BringToFront";
mostCurrent._pnldim.BringToFront();
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="pnlSelectItems.BringToFront";
mostCurrent._pnlselectitems.BringToFront();
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="End Sub";
return "";
}
public static String  _bttnaddtocartqty_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttnaddtocartqty_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bttnaddtocartqty_click", null));}
int _quantity = 0;
int _i = 0;
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub bttnAddToCartQty_Click";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Dim quantity As Int = lblQuantityValue.Text";
_quantity = (int)(Double.parseDouble(mostCurrent._lblquantityvalue.getText()));
RDebugUtils.currentLine=7667716;
 //BA.debugLineNum = 7667716;BA.debugLine="For i = 1 To quantity";
{
final int step2 = 1;
final int limit2 = _quantity;
_i = (int) (1) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=7667717;
 //BA.debugLineNum = 7667717;BA.debugLine="CartItems.Add(SelectedItemID)";
mostCurrent._cartitems.Add((Object)(_selecteditemid));
 }
};
RDebugUtils.currentLine=7667720;
 //BA.debugLineNum = 7667720;BA.debugLine="RefreshCartSummary";
_refreshcartsummary();
RDebugUtils.currentLine=7667721;
 //BA.debugLineNum = 7667721;BA.debugLine="bttnPurchaseNow.Enabled = True";
mostCurrent._bttnpurchasenow.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7667722;
 //BA.debugLineNum = 7667722;BA.debugLine="bttnPurchaseNow.Color = Colors.Blue";
mostCurrent._bttnpurchasenow.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=7667724;
 //BA.debugLineNum = 7667724;BA.debugLine="ToastMessageShow(\"Added \" & quantity & \"x \" & Sel";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Added "+BA.NumberToString(_quantity)+"x "+mostCurrent._selecteditemname),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7667727;
 //BA.debugLineNum = 7667727;BA.debugLine="pnlQuantity.Visible = False";
mostCurrent._pnlquantity.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7667728;
 //BA.debugLineNum = 7667728;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7667729;
 //BA.debugLineNum = 7667729;BA.debugLine="pnlSelectItems.Visible = False";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7667730;
 //BA.debugLineNum = 7667730;BA.debugLine="End Sub";
return "";
}
public static String  _refreshcartsummary() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "refreshcartsummary", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "refreshcartsummary", null));}
int _top = 0;
double _totalamount = 0;
anywheresoftware.b4a.objects.collections.Map _itemquantities = null;
int _itemid = 0;
int _count = 0;
int _quantity = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblqty = null;
anywheresoftware.b4a.objects.LabelWrapper _lblprice = null;
double _itemprice = 0;
double _linetotal = 0;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Private Sub RefreshCartSummary";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="svCartSummary.Panel.RemoveAllViews";
mostCurrent._svcartsummary.getPanel().RemoveAllViews();
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim top As Int = 0";
_top = (int) (0);
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Dim totalAmount As Double = 0";
_totalamount = 0;
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="Dim itemQuantities As Map";
_itemquantities = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="itemQuantities.Initialize";
_itemquantities.Initialize();
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="For Each itemID As Int In CartItems";
{
final anywheresoftware.b4a.BA.IterableList group6 = mostCurrent._cartitems;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_itemid = (int)(BA.ObjectToNumber(group6.Get(index6)));
RDebugUtils.currentLine=2949130;
 //BA.debugLineNum = 2949130;BA.debugLine="If itemQuantities.ContainsKey(itemID) Then";
if (_itemquantities.ContainsKey((Object)(_itemid))) { 
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="Dim count As Int = itemQuantities.Get(itemID)";
_count = (int)(BA.ObjectToNumber(_itemquantities.Get((Object)(_itemid))));
RDebugUtils.currentLine=2949132;
 //BA.debugLineNum = 2949132;BA.debugLine="itemQuantities.Put(itemID, count + 1)";
_itemquantities.Put((Object)(_itemid),(Object)(_count+1));
 }else {
RDebugUtils.currentLine=2949134;
 //BA.debugLineNum = 2949134;BA.debugLine="itemQuantities.Put(itemID, 1)";
_itemquantities.Put((Object)(_itemid),(Object)(1));
 };
 }
};
RDebugUtils.currentLine=2949139;
 //BA.debugLineNum = 2949139;BA.debugLine="For Each itemID As Int In itemQuantities.Keys";
{
final anywheresoftware.b4a.BA.IterableList group14 = _itemquantities.Keys();
final int groupLen14 = group14.getSize()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_itemid = (int)(BA.ObjectToNumber(group14.Get(index14)));
RDebugUtils.currentLine=2949140;
 //BA.debugLineNum = 2949140;BA.debugLine="Dim quantity As Int = itemQuantities.Get(itemID)";
_quantity = (int)(BA.ObjectToNumber(_itemquantities.Get((Object)(_itemid))));
RDebugUtils.currentLine=2949142;
 //BA.debugLineNum = 2949142;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE item_id=?",new String[]{BA.NumberToString(_itemid)})));
RDebugUtils.currentLine=2949143;
 //BA.debugLineNum = 2949143;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
RDebugUtils.currentLine=2949144;
 //BA.debugLineNum = 2949144;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2949145;
 //BA.debugLineNum = 2949145;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2949146;
 //BA.debugLineNum = 2949146;BA.debugLine="pnl.Color = Colors.White";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2949147;
 //BA.debugLineNum = 2949147;BA.debugLine="pnl.SetLayout(0, top, svCartSummary.Width, 65di";
_pnl.SetLayout((int) (0),_top,mostCurrent._svcartsummary.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)));
RDebugUtils.currentLine=2949149;
 //BA.debugLineNum = 2949149;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949150;
 //BA.debugLineNum = 2949150;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2949151;
 //BA.debugLineNum = 2949151;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
_lblname.setText(BA.ObjectToCharSequence(_rs.GetString("item_name")));
RDebugUtils.currentLine=2949152;
 //BA.debugLineNum = 2949152;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
RDebugUtils.currentLine=2949153;
 //BA.debugLineNum = 2949153;BA.debugLine="lblName.TextColor = Colors.Black";
_lblname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2949154;
 //BA.debugLineNum = 2949154;BA.debugLine="lblName.SetLayout(10dip, 5dip, 60%x, 25dip)";
_lblname.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=2949156;
 //BA.debugLineNum = 2949156;BA.debugLine="Dim lblQty As Label";
_lblqty = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949157;
 //BA.debugLineNum = 2949157;BA.debugLine="lblQty.Initialize(\"\")";
_lblqty.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2949158;
 //BA.debugLineNum = 2949158;BA.debugLine="lblQty.Text = \"x\" & quantity";
_lblqty.setText(BA.ObjectToCharSequence("x"+BA.NumberToString(_quantity)));
RDebugUtils.currentLine=2949159;
 //BA.debugLineNum = 2949159;BA.debugLine="lblQty.TextSize = 14";
_lblqty.setTextSize((float) (14));
RDebugUtils.currentLine=2949160;
 //BA.debugLineNum = 2949160;BA.debugLine="lblQty.TextColor = Colors.Gray";
_lblqty.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2949161;
 //BA.debugLineNum = 2949161;BA.debugLine="lblQty.SetLayout(10dip, 30dip, 30%x, 20dip)";
_lblqty.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=2949163;
 //BA.debugLineNum = 2949163;BA.debugLine="Dim lblPrice As Label";
_lblprice = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949164;
 //BA.debugLineNum = 2949164;BA.debugLine="lblPrice.Initialize(\"\")";
_lblprice.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2949165;
 //BA.debugLineNum = 2949165;BA.debugLine="Dim itemPrice As Double = rs.GetDouble(\"unit_pr";
_itemprice = _rs.GetDouble("unit_price");
RDebugUtils.currentLine=2949166;
 //BA.debugLineNum = 2949166;BA.debugLine="Dim lineTotal As Double = itemPrice * quantity";
_linetotal = _itemprice*_quantity;
RDebugUtils.currentLine=2949167;
 //BA.debugLineNum = 2949167;BA.debugLine="lblPrice.Text = \"₱\" & lineTotal";
_lblprice.setText(BA.ObjectToCharSequence("₱"+BA.NumberToString(_linetotal)));
RDebugUtils.currentLine=2949168;
 //BA.debugLineNum = 2949168;BA.debugLine="lblPrice.TextSize = 16";
_lblprice.setTextSize((float) (16));
RDebugUtils.currentLine=2949169;
 //BA.debugLineNum = 2949169;BA.debugLine="lblPrice.TextColor = Colors.RGB(0, 120, 0)";
_lblprice.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (120),(int) (0)));
RDebugUtils.currentLine=2949170;
 //BA.debugLineNum = 2949170;BA.debugLine="lblPrice.Gravity = Gravity.RIGHT";
_lblprice.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
RDebugUtils.currentLine=2949171;
 //BA.debugLineNum = 2949171;BA.debugLine="lblPrice.SetLayout(65%x, 5dip, 30%x, 25dip)";
_lblprice.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (65),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=2949173;
 //BA.debugLineNum = 2949173;BA.debugLine="pnl.AddView(lblName, lblName.Left, lblName.Top,";
_pnl.AddView((android.view.View)(_lblname.getObject()),_lblname.getLeft(),_lblname.getTop(),_lblname.getWidth(),_lblname.getHeight());
RDebugUtils.currentLine=2949174;
 //BA.debugLineNum = 2949174;BA.debugLine="pnl.AddView(lblQty, lblQty.Left, lblQty.Top, lb";
_pnl.AddView((android.view.View)(_lblqty.getObject()),_lblqty.getLeft(),_lblqty.getTop(),_lblqty.getWidth(),_lblqty.getHeight());
RDebugUtils.currentLine=2949175;
 //BA.debugLineNum = 2949175;BA.debugLine="pnl.AddView(lblPrice, lblPrice.Left, lblPrice.T";
_pnl.AddView((android.view.View)(_lblprice.getObject()),_lblprice.getLeft(),_lblprice.getTop(),_lblprice.getWidth(),_lblprice.getHeight());
RDebugUtils.currentLine=2949177;
 //BA.debugLineNum = 2949177;BA.debugLine="svCartSummary.Panel.AddView(pnl, 0, top, pnl.Wi";
mostCurrent._svcartsummary.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_top,_pnl.getWidth(),_pnl.getHeight());
RDebugUtils.currentLine=2949178;
 //BA.debugLineNum = 2949178;BA.debugLine="top = top + pnl.Height + 3dip";
_top = (int) (_top+_pnl.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=2949179;
 //BA.debugLineNum = 2949179;BA.debugLine="totalAmount = totalAmount + lineTotal";
_totalamount = _totalamount+_linetotal;
 };
RDebugUtils.currentLine=2949181;
 //BA.debugLineNum = 2949181;BA.debugLine="rs.Close";
_rs.Close();
 }
};
RDebugUtils.currentLine=2949184;
 //BA.debugLineNum = 2949184;BA.debugLine="svCartSummary.Panel.Height = top";
mostCurrent._svcartsummary.getPanel().setHeight(_top);
RDebugUtils.currentLine=2949185;
 //BA.debugLineNum = 2949185;BA.debugLine="lblTotalItems.Text = \"Items: \" & itemQuantities.S";
mostCurrent._lbltotalitems.setText(BA.ObjectToCharSequence("Items: "+BA.NumberToString(_itemquantities.getSize())+" types ("+BA.NumberToString(mostCurrent._cartitems.getSize())+" total)"));
RDebugUtils.currentLine=2949186;
 //BA.debugLineNum = 2949186;BA.debugLine="lblTotalAmount.Text = \"Total: ₱\" & NumberFormat2(";
mostCurrent._lbltotalamount.setText(BA.ObjectToCharSequence("Total: ₱"+anywheresoftware.b4a.keywords.Common.NumberFormat2(_totalamount,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False)));
RDebugUtils.currentLine=2949187;
 //BA.debugLineNum = 2949187;BA.debugLine="End Sub";
return "";
}
public static String  _bttncancelqty_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttncancelqty_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bttncancelqty_click", null));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Private Sub bttnCancelQty_Click";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="pnlQuantity.Visible = False";
mostCurrent._pnlquantity.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="End Sub";
return "";
}
public static String  _bttnminus_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttnminus_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bttnminus_click", null));}
int _currentqty = 0;
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Private Sub bttnMinus_Click";
RDebugUtils.currentLine=7536641;
 //BA.debugLineNum = 7536641;BA.debugLine="Dim currentQty As Int = lblQuantityValue.Text";
_currentqty = (int)(Double.parseDouble(mostCurrent._lblquantityvalue.getText()));
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="If currentQty > 1 Then";
if (_currentqty>1) { 
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="lblQuantityValue.Text = (currentQty - 1)";
mostCurrent._lblquantityvalue.setText(BA.ObjectToCharSequence((_currentqty-1)));
 }else {
RDebugUtils.currentLine=7536645;
 //BA.debugLineNum = 7536645;BA.debugLine="ToastMessageShow(\"Minimum quantity is 1\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Minimum quantity is 1"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=7536647;
 //BA.debugLineNum = 7536647;BA.debugLine="End Sub";
return "";
}
public static String  _bttnpurchasenow_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bttnpurchasenow_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "bttnpurchasenow_click", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Private Sub bttnPurchaseNow_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="If CartItems.Size = 0 Then";
if (mostCurrent._cartitems.getSize()==0) { 
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="ToastMessageShow(\"Add items first\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Add items first"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="SaveOrderLocally";
_saveorderlocally();
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="CartItems.Clear";
mostCurrent._cartitems.Clear();
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="RefreshCartSummary";
_refreshcartsummary();
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="bttnPurchaseNow.Color = Colors.ARGB(80, 200, 200,";
mostCurrent._bttnpurchasenow.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (80),(int) (200),(int) (200),(int) (200)));
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="bttnPurchaseNow.Enabled = False";
mostCurrent._bttnpurchasenow.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="ToastMessageShow(\"Order added successfully\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Order added successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2752525;
 //BA.debugLineNum = 2752525;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="End Sub";
return "";
}
public static String  _saveorderlocally() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "saveorderlocally", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "saveorderlocally", null));}
double _total = 0;
int _productid = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rsorder = null;
int _orderid = 0;
double _price = 0;
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Private Sub SaveOrderLocally";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Dim total As Double = 0";
_total = 0;
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="For Each productID As Int In CartItems";
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._cartitems;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_productid = (int)(BA.ObjectToNumber(group2.Get(index2)));
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE item_id=?",new String[]{BA.NumberToString(_productid)})));
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="If rs.NextRow Then total = total + rs.GetDouble(";
if (_rs.NextRow()) { 
_total = _total+_rs.GetDouble("unit_price");};
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="rs.Close";
_rs.Close();
 }
};
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="Main.SQLProducts.ExecNonQuery2(\"INSERT INTO order";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO orders (vendor_id, date_created, status, total_amount) VALUES (?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(1),BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow()),"Pending",BA.NumberToString(_total)}));
RDebugUtils.currentLine=3014669;
 //BA.debugLineNum = 3014669;BA.debugLine="Dim rsOrder As ResultSet = Main.SQLProducts.ExecQ";
_rsorder = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rsorder = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT last_insert_rowid() AS id")));
RDebugUtils.currentLine=3014670;
 //BA.debugLineNum = 3014670;BA.debugLine="rsOrder.NextRow";
_rsorder.NextRow();
RDebugUtils.currentLine=3014671;
 //BA.debugLineNum = 3014671;BA.debugLine="Dim orderID As Int = rsOrder.GetInt(\"id\")";
_orderid = _rsorder.GetInt("id");
RDebugUtils.currentLine=3014672;
 //BA.debugLineNum = 3014672;BA.debugLine="rsOrder.Close";
_rsorder.Close();
RDebugUtils.currentLine=3014675;
 //BA.debugLineNum = 3014675;BA.debugLine="For Each productID As Int In CartItems";
{
final anywheresoftware.b4a.BA.IterableList group12 = mostCurrent._cartitems;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_productid = (int)(BA.ObjectToNumber(group12.Get(index12)));
RDebugUtils.currentLine=3014676;
 //BA.debugLineNum = 3014676;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE item_id=?",new String[]{BA.NumberToString(_productid)})));
RDebugUtils.currentLine=3014677;
 //BA.debugLineNum = 3014677;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
RDebugUtils.currentLine=3014678;
 //BA.debugLineNum = 3014678;BA.debugLine="Dim price As Double = rs.GetDouble(\"unit_price\"";
_price = _rs.GetDouble("unit_price");
RDebugUtils.currentLine=3014679;
 //BA.debugLineNum = 3014679;BA.debugLine="Main.SQLProducts.ExecNonQuery2(\"INSERT INTO ord";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(_orderid),BA.NumberToString(_productid),BA.NumberToString(1),BA.NumberToString(_price)}));
 };
RDebugUtils.currentLine=3014682;
 //BA.debugLineNum = 3014682;BA.debugLine="rs.Close";
_rs.Close();
 }
};
RDebugUtils.currentLine=3014684;
 //BA.debugLineNum = 3014684;BA.debugLine="End Sub";
return "";
}
public static String  _clvproducts_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clvproducts_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clvproducts_itemclick", new Object[] {_index,_value}));}
int _itemid = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Private Sub clvProducts_ItemClick(Index As Int, Va";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim itemID As Int = Value";
_itemid = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery2";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE item_id=?",new String[]{BA.NumberToString(_itemid)})));
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="SelectedItemID = itemID";
_selecteditemid = _itemid;
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="SelectedItemName = rs.GetString(\"item_name\")";
mostCurrent._selecteditemname = _rs.GetString("item_name");
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="SelectedItemPrice = rs.GetDouble(\"unit_price\")";
_selecteditemprice = _rs.GetDouble("unit_price");
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="lblSelectedItem.Text = SelectedItemName & Chr(10";
mostCurrent._lblselecteditem.setText(BA.ObjectToCharSequence(mostCurrent._selecteditemname+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10)))+"₱"+BA.NumberToString(_selecteditemprice)));
RDebugUtils.currentLine=2883598;
 //BA.debugLineNum = 2883598;BA.debugLine="lblQuantityValue.Text = \"1\"  ' Reset to 1";
mostCurrent._lblquantityvalue.setText(BA.ObjectToCharSequence("1"));
RDebugUtils.currentLine=2883601;
 //BA.debugLineNum = 2883601;BA.debugLine="pnlQuantity.Visible = True";
mostCurrent._pnlquantity.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2883602;
 //BA.debugLineNum = 2883602;BA.debugLine="pnlQuantity.BringToFront";
mostCurrent._pnlquantity.BringToFront();
RDebugUtils.currentLine=2883603;
 //BA.debugLineNum = 2883603;BA.debugLine="pnlDim.Visible = True";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2883604;
 //BA.debugLineNum = 2883604;BA.debugLine="pnlDim.BringToFront";
mostCurrent._pnldim.BringToFront();
RDebugUtils.currentLine=2883605;
 //BA.debugLineNum = 2883605;BA.debugLine="pnlQuantity.BringToFront  ' Make sure it's on to";
mostCurrent._pnlquantity.BringToFront();
 };
RDebugUtils.currentLine=2883607;
 //BA.debugLineNum = 2883607;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=2883608;
 //BA.debugLineNum = 2883608;BA.debugLine="End Sub";
return "";
}
public static String  _etsearchproducts_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "etsearchproducts_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "etsearchproducts_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Private Sub etSearchProducts_TextChanged (Old As S";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="LoadProducts  ' Reload with filter";
_loadproducts();
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="End Sub";
return "";
}
public static String  _lblexitorderactivity_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblexitorderactivity_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblexitorderactivity_click", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Private Sub lblExitOrderActivity_Click";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _lblexitselectitems_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblexitselectitems_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblexitselectitems_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Private Sub lblExitSelectItems_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="pnlSelectItems.Visible = False";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="End Sub";
return "";
}
public static String  _pnldim_click() throws Exception{
RDebugUtils.currentModule="addorderactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnldim_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnldim_click", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Private Sub pnlDim_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="End Sub";
return "";
}
}