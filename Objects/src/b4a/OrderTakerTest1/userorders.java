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

public class userorders extends Activity implements B4AActivity{
	public static userorders mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.userorders");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (userorders).");
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
		activityBA = new BA(this, layout, processBA, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.userorders");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.OrderTakerTest1.userorders", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (userorders) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (userorders) Resume **");
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
		return userorders.class;
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
            BA.LogInfo("** Activity (userorders) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (userorders) Pause event (activity is not paused). **");
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
            userorders mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (userorders) Resume **");
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
public static anywheresoftware.b4a.sql.SQL _sqlproducts = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllogout = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblperson = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblloggedinuser = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbottomnav = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldash = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldashicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblhistory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblhistoryicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinventory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinventoryicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblorders = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblordersicon = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldash = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlhistory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlinventory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlorders = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnaddorder = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnladdorderhometotal = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexitaddorderhome = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldim = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnadditems = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselectitems = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svselectitems = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etsearchitems = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnpurchasenow = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexitselectitems = null;
public b4a.OrderTakerTest1.main _main = null;
public b4a.OrderTakerTest1.controls _controls = null;
public b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public b4a.OrderTakerTest1.starter _starter = null;
public b4a.OrderTakerTest1.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"userOrders\")";
mostCurrent._activity.LoadLayout("userOrders",mostCurrent.activityBA);
 //BA.debugLineNum = 46;BA.debugLine="lblLoggedInUser.Text = \"Welcome, \" & Main.LoggedI";
mostCurrent._lblloggedinuser.setText(BA.ObjectToCharSequence("Welcome, "+mostCurrent._main._loggedinuser /*String*/ ));
 //BA.debugLineNum = 52;BA.debugLine="SQLProducts.Initialize(File.DirInternal, \"product";
_sqlproducts.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"productsTest1.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 55;BA.debugLine="ScrollView1.Panel.Width = ScrollView1.Width";
mostCurrent._scrollview1.getPanel().setWidth(mostCurrent._scrollview1.getWidth());
 //BA.debugLineNum = 56;BA.debugLine="ScrollView1.Panel.Height = ScrollView1.Height   '";
mostCurrent._scrollview1.getPanel().setHeight(mostCurrent._scrollview1.getHeight());
 //BA.debugLineNum = 60;BA.debugLine="svSelectItems = Null";
mostCurrent._svselectitems = (anywheresoftware.b4a.objects.ScrollViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ScrollViewWrapper(), (android.widget.ScrollView)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 61;BA.debugLine="For i = 0 To pnlSelectItems.NumberOfViews - 1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._pnlselectitems.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 62;BA.debugLine="Dim v As View = pnlSelectItems.GetView(i)";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
_v = mostCurrent._pnlselectitems.GetView(_i);
 //BA.debugLineNum = 63;BA.debugLine="If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
 //BA.debugLineNum = 64;BA.debugLine="svSelectItems = v";
mostCurrent._svselectitems = (anywheresoftware.b4a.objects.ScrollViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ScrollViewWrapper(), (android.widget.ScrollView)(_v.getObject()));
 //BA.debugLineNum = 65;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 69;BA.debugLine="If svSelectItems = Null Then";
if (mostCurrent._svselectitems== null) { 
 //BA.debugLineNum = 70;BA.debugLine="Log(\"Error: svSelectItems not found inside pnlSe";
anywheresoftware.b4a.keywords.Common.LogImpl("05767196","Error: svSelectItems not found inside pnlSelectItems!",0);
 }else {
 //BA.debugLineNum = 73;BA.debugLine="svSelectItems.Panel.Width = svSelectItems.Width";
mostCurrent._svselectitems.getPanel().setWidth(mostCurrent._svselectitems.getWidth());
 //BA.debugLineNum = 74;BA.debugLine="svSelectItems.Panel.Height = 10dip";
mostCurrent._svselectitems.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 };
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _btnadditems_click() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Private Sub btnAddItems_Click";
 //BA.debugLineNum = 182;BA.debugLine="pnlDim.Visible = True";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 183;BA.debugLine="pnlDim.BringToFront";
mostCurrent._pnldim.BringToFront();
 //BA.debugLineNum = 185;BA.debugLine="pnlSelectItems.Visible = True";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 186;BA.debugLine="pnlSelectItems.BringToFront";
mostCurrent._pnlselectitems.BringToFront();
 //BA.debugLineNum = 188;BA.debugLine="LoadProductsIntoSelectItems";
_loadproductsintoselectitems();
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _btnpurchasenow_click() throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Private Sub btnPurchaseNow_Click";
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public static String  _bttnaddorder_click() throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Private Sub bttnAddOrder_Click";
 //BA.debugLineNum = 164;BA.debugLine="pnlDim.Visible = True";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 165;BA.debugLine="pnlDim.BringToFront";
mostCurrent._pnldim.BringToFront();
 //BA.debugLineNum = 166;BA.debugLine="pnlAddOrderHomeTotal.Visible = True";
mostCurrent._pnladdorderhometotal.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 167;BA.debugLine="pnlAddOrderHomeTotal.BringToFront";
mostCurrent._pnladdorderhometotal.BringToFront();
 //BA.debugLineNum = 169;BA.debugLine="bttnAddOrder.Visible = False";
mostCurrent._bttnaddorder.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 170;BA.debugLine="lblExitAddOrderHome.Visible = True";
mostCurrent._lblexitaddorderhome.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 171;BA.debugLine="btnAddItems.Visible = True";
mostCurrent._btnadditems.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 172;BA.debugLine="btnPurchaseNow.Visible = True";
mostCurrent._btnpurchasenow.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createproductcard(String _sku,String _name,double _price,int _packnumber) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsku = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblprice = null;
anywheresoftware.b4a.objects.LabelWrapper _lblpack = null;
 //BA.debugLineNum = 97;BA.debugLine="Private Sub CreateProductCard(sku As String, name";
 //BA.debugLineNum = 98;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 99;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 100;BA.debugLine="pnl.Color = Colors.White";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 104;BA.debugLine="Dim lblSKU As Label";
_lblsku = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 105;BA.debugLine="lblSKU.Initialize(\"\")";
_lblsku.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 106;BA.debugLine="lblSKU.Text = \"SKU: \" & sku";
_lblsku.setText(BA.ObjectToCharSequence("SKU: "+_sku));
 //BA.debugLineNum = 107;BA.debugLine="lblSKU.TextSize = 14";
_lblsku.setTextSize((float) (14));
 //BA.debugLineNum = 108;BA.debugLine="pnl.AddView(lblSKU, 10dip, 10dip, 200dip, 20dip)";
_pnl.AddView((android.view.View)(_lblsku.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 111;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 112;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 113;BA.debugLine="lblName.Text = name";
_lblname.setText(BA.ObjectToCharSequence(_name));
 //BA.debugLineNum = 114;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
 //BA.debugLineNum = 115;BA.debugLine="pnl.AddView(lblName, 10dip, 35dip, 200dip, 25dip)";
_pnl.AddView((android.view.View)(_lblname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
 //BA.debugLineNum = 118;BA.debugLine="Dim lblPrice As Label";
_lblprice = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 119;BA.debugLine="lblPrice.Initialize(\"\")";
_lblprice.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 120;BA.debugLine="lblPrice.Text = \"₱\" & price";
_lblprice.setText(BA.ObjectToCharSequence("₱"+BA.NumberToString(_price)));
 //BA.debugLineNum = 121;BA.debugLine="lblPrice.TextSize = 14";
_lblprice.setTextSize((float) (14));
 //BA.debugLineNum = 122;BA.debugLine="pnl.AddView(lblPrice, 10dip, 65dip, 200dip, 20dip";
_pnl.AddView((android.view.View)(_lblprice.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 125;BA.debugLine="Dim lblPack As Label";
_lblpack = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 126;BA.debugLine="lblPack.Initialize(\"\")";
_lblpack.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 127;BA.debugLine="lblPack.Text = \"Pack: \" & packNumber";
_lblpack.setText(BA.ObjectToCharSequence("Pack: "+BA.NumberToString(_packnumber)));
 //BA.debugLineNum = 128;BA.debugLine="lblPack.TextSize = 14";
_lblpack.setTextSize((float) (14));
 //BA.debugLineNum = 129;BA.debugLine="pnl.AddView(lblPack, 10dip, 90dip, 200dip, 20dip)";
_pnl.AddView((android.view.View)(_lblpack.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 131;BA.debugLine="pnl.Height = 120dip";
_pnl.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)));
 //BA.debugLineNum = 132;BA.debugLine="Return pnl";
if (true) return _pnl;
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private lbllogout As Label";
mostCurrent._lbllogout = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private lblperson As Label";
mostCurrent._lblperson = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private lblLoggedInUser As Label";
mostCurrent._lblloggedinuser = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private ScrollView1 As ScrollView";
mostCurrent._scrollview1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private pnlBottomNav As Panel";
mostCurrent._pnlbottomnav = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private lblDash As Label";
mostCurrent._lbldash = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private lblDashIcon As Label";
mostCurrent._lbldashicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lblHistory As Label";
mostCurrent._lblhistory = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private lblHistoryIcon As Label";
mostCurrent._lblhistoryicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lblInventory As Label";
mostCurrent._lblinventory = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lblInventoryIcon As Label";
mostCurrent._lblinventoryicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lblOrders As Label";
mostCurrent._lblorders = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblOrdersIcon As Label";
mostCurrent._lblordersicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private pnlDash As Panel";
mostCurrent._pnldash = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private pnlHistory As Panel";
mostCurrent._pnlhistory = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private pnlInventory As Panel";
mostCurrent._pnlinventory = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private pnlOrders As Panel";
mostCurrent._pnlorders = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private bttnAddOrder As Button";
mostCurrent._bttnaddorder = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private pnlAddOrderHomeTotal As Panel";
mostCurrent._pnladdorderhometotal = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private lblExitAddOrderHome As Label";
mostCurrent._lblexitaddorderhome = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private pnlDim As Panel";
mostCurrent._pnldim = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private btnAddItems As Button";
mostCurrent._btnadditems = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private pnlSelectItems As Panel";
mostCurrent._pnlselectitems = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private svSelectItems As ScrollView";
mostCurrent._svselectitems = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private etSearchItems As EditText";
mostCurrent._etsearchitems = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private btnPurchaseNow As Button";
mostCurrent._btnpurchasenow = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lblExitSelectItems As Label";
mostCurrent._lblexitselectitems = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static String  _lblexitaddorderhome_click() throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Private Sub lblExitAddOrderHome_Click";
 //BA.debugLineNum = 176;BA.debugLine="pnlAddOrderHomeTotal.Visible = False";
mostCurrent._pnladdorderhometotal.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 177;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 178;BA.debugLine="bttnAddOrder.Visible = True";
mostCurrent._bttnaddorder.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public static String  _lblexitselectitems_click() throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Private Sub lblExitSelectItems_Click";
 //BA.debugLineNum = 194;BA.debugLine="pnlSelectItems.Visible = False";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 195;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public static String  _lbllogout_click() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Private Sub lbllogout_Click";
 //BA.debugLineNum = 90;BA.debugLine="Main.LoggedInUser = \"\"";
mostCurrent._main._loggedinuser /*String*/  = "";
 //BA.debugLineNum = 91;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 92;BA.debugLine="Controls.SetAnimation(\"slide_right_in\", \"slide_ri";
mostCurrent._controls._setanimation /*String*/ (mostCurrent.activityBA,"slide_right_in","slide_right_out");
 //BA.debugLineNum = 93;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public static String  _loadproductsintoselectitems() throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _toppos = 0;
int _i = 0;
String _sku = "";
String _name = "";
double _price = 0;
int _packnumber = 0;
anywheresoftware.b4a.objects.PanelWrapper _card = null;
 //BA.debugLineNum = 136;BA.debugLine="Private Sub LoadProductsIntoSelectItems";
 //BA.debugLineNum = 137;BA.debugLine="svSelectItems.Panel.RemoveAllViews";
mostCurrent._svselectitems.getPanel().RemoveAllViews();
 //BA.debugLineNum = 138;BA.debugLine="svSelectItems.Panel.Height = 0";
mostCurrent._svselectitems.getPanel().setHeight((int) (0));
 //BA.debugLineNum = 140;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 141;BA.debugLine="cursor = SQLProducts.ExecQuery(\"SELECT * FROM pro";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sqlproducts.ExecQuery("SELECT * FROM products")));
 //BA.debugLineNum = 142;BA.debugLine="Dim topPos As Int = 10dip";
_toppos = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 144;BA.debugLine="For i = 0 To cursor.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 145;BA.debugLine="cursor.Position = i";
_cursor.setPosition(_i);
 //BA.debugLineNum = 146;BA.debugLine="Dim sku As String = cursor.GetString(\"sku\")";
_sku = _cursor.GetString("sku");
 //BA.debugLineNum = 147;BA.debugLine="Dim name As String = cursor.GetString(\"name\")";
_name = _cursor.GetString("name");
 //BA.debugLineNum = 148;BA.debugLine="Dim price As Double = cursor.GetDouble(\"price\")";
_price = _cursor.GetDouble("price");
 //BA.debugLineNum = 149;BA.debugLine="Dim packNumber As Int = cursor.GetInt(\"pack_numb";
_packnumber = _cursor.GetInt("pack_number");
 //BA.debugLineNum = 151;BA.debugLine="Dim card As Panel";
_card = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 152;BA.debugLine="card = CreateProductCard(sku, name, price, packN";
_card = _createproductcard(_sku,_name,_price,_packnumber);
 //BA.debugLineNum = 154;BA.debugLine="svSelectItems.Panel.AddView(card, 10dip, topPos,";
mostCurrent._svselectitems.getPanel().AddView((android.view.View)(_card.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_toppos,(int) (mostCurrent._svselectitems.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_card.getHeight());
 //BA.debugLineNum = 155;BA.debugLine="topPos = topPos + card.Height + 10dip";
_toppos = (int) (_toppos+_card.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 }
};
 //BA.debugLineNum = 158;BA.debugLine="cursor.Close";
_cursor.Close();
 //BA.debugLineNum = 159;BA.debugLine="svSelectItems.Panel.Height = topPos + 10dip";
mostCurrent._svselectitems.getPanel().setHeight((int) (_toppos+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public static String  _pnldim_click() throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Private Sub pnlDim_Click";
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private SQLProducts As SQL";
_sqlproducts = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 8;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
}
