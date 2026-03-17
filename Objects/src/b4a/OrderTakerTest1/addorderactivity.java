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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.OrderTakerTest1", "b4a.OrderTakerTest1.addorderactivity");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.collections.List _cartitems = null;
public static int _selecteditemid = 0;
public static String _selecteditemname = "";
public static double _selecteditemprice = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pnladdorderactivitytop = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnladdorderactivitywhole = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldim = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svcartsummary = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltotalitems = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltotalamount = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnpurchasenow = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexitorderactivity = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnaddorderactivity = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselectitems = null;
public b4a.example3.customlistview _clvproducts = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etsearchproducts = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexitselectitems = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlquantity = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblquantitytitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblselecteditem = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etquantityvalue = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnminus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnadd = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnaddtocartqty = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttncancelqty = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlpurchasestatus = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpurchasestatustitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpurchasestatusmessage = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rbpaidreceived = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rbpaidbooked = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rbnotpaidbooked = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttnconfirmpurchasestatus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bttncancelpurchasestatus = null;
public b4a.OrderTakerTest1.main _main = null;
public b4a.OrderTakerTest1.controls _controls = null;
public b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
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
 //BA.debugLineNum = 57;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 58;BA.debugLine="Activity.LoadLayout(\"addOrderActivity\")";
mostCurrent._activity.LoadLayout("addOrderActivity",mostCurrent.activityBA);
 //BA.debugLineNum = 60;BA.debugLine="If Main.VENDOR_ID <= 0 Or Main.LoggedInUserID <=";
if (mostCurrent._main._vendor_id /*int*/ <=0 || mostCurrent._main._loggedinuserid /*int*/ <=0) { 
 //BA.debugLineNum = 61;BA.debugLine="ToastMessageShow(\"Session is invalid. Please log";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Session is invalid. Please login again."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 62;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 63;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 66;BA.debugLine="CartItems.Initialize";
mostCurrent._cartitems.Initialize();
 //BA.debugLineNum = 68;BA.debugLine="bttnPurchaseNow.Enabled = False";
mostCurrent._bttnpurchasenow.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 69;BA.debugLine="bttnPurchaseNow.Color = Colors.ARGB(80, 0, 0, 255";
mostCurrent._bttnpurchasenow.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (80),(int) (0),(int) (0),(int) (255)));
 //BA.debugLineNum = 71;BA.debugLine="pnlPurchaseStatus.Visible = False";
mostCurrent._pnlpurchasestatus.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 72;BA.debugLine="rbPaidReceived.Checked = True";
mostCurrent._rbpaidreceived.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 73;BA.debugLine="rbPaidBooked.Checked = False";
mostCurrent._rbpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 74;BA.debugLine="rbNotPaidBooked.Checked = False";
mostCurrent._rbnotpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 76;BA.debugLine="LoadProductsIntoList";
_loadproductsintolist();
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _addcartitemtolist(int _productid,String _itemname,double _unitprice,int _quantity) throws Exception{
anywheresoftware.b4a.objects.collections.Map _cartitem = null;
int _existingproductid = 0;
int _existingquantity = 0;
 //BA.debugLineNum = 528;BA.debugLine="Private Sub AddCartItemToList(ProductID As Int, It";
 //BA.debugLineNum = 529;BA.debugLine="For Each cartItem As Map In CartItems";
_cartitem = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group1 = mostCurrent._cartitems;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_cartitem = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group1.Get(index1)));
 //BA.debugLineNum = 530;BA.debugLine="Dim existingProductID As Int = cartItem.Get(\"pro";
_existingproductid = (int)(BA.ObjectToNumber(_cartitem.Get((Object)("product_id"))));
 //BA.debugLineNum = 531;BA.debugLine="If existingProductID = ProductID Then";
if (_existingproductid==_productid) { 
 //BA.debugLineNum = 532;BA.debugLine="Dim existingQuantity As Int = cartItem.Get(\"qua";
_existingquantity = (int)(BA.ObjectToNumber(_cartitem.Get((Object)("quantity"))));
 //BA.debugLineNum = 533;BA.debugLine="cartItem.Put(\"quantity\", existingQuantity + Qua";
_cartitem.Put((Object)("quantity"),(Object)(_existingquantity+_quantity));
 //BA.debugLineNum = 534;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 538;BA.debugLine="Dim cartItem As Map";
_cartitem = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 539;BA.debugLine="cartItem.Initialize";
_cartitem.Initialize();
 //BA.debugLineNum = 540;BA.debugLine="cartItem.Put(\"product_id\", ProductID)";
_cartitem.Put((Object)("product_id"),(Object)(_productid));
 //BA.debugLineNum = 541;BA.debugLine="cartItem.Put(\"item_name\", ItemName)";
_cartitem.Put((Object)("item_name"),(Object)(_itemname));
 //BA.debugLineNum = 542;BA.debugLine="cartItem.Put(\"unit_price\", UnitPrice)";
_cartitem.Put((Object)("unit_price"),(Object)(_unitprice));
 //BA.debugLineNum = 543;BA.debugLine="cartItem.Put(\"quantity\", Quantity)";
_cartitem.Put((Object)("quantity"),(Object)(_quantity));
 //BA.debugLineNum = 544;BA.debugLine="CartItems.Add(cartItem)";
mostCurrent._cartitems.Add((Object)(_cartitem.getObject()));
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return "";
}
public static String  _bttnadd_click() throws Exception{
int _currentqty = 0;
 //BA.debugLineNum = 347;BA.debugLine="Private Sub bttnAdd_Click";
 //BA.debugLineNum = 348;BA.debugLine="Dim currentQty As Int = etQuantityValue.Text";
_currentqty = (int)(Double.parseDouble(mostCurrent._etquantityvalue.getText()));
 //BA.debugLineNum = 349;BA.debugLine="If currentQty < 999 Then";
if (_currentqty<999) { 
 //BA.debugLineNum = 350;BA.debugLine="etQuantityValue.Text = (currentQty + 1)";
mostCurrent._etquantityvalue.setText(BA.ObjectToCharSequence((_currentqty+1)));
 }else {
 //BA.debugLineNum = 352;BA.debugLine="ToastMessageShow(\"Maximum quantity is 999\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Maximum quantity is 999"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public static String  _bttnaddorderactivity_click() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Private Sub bttnAddOrderActivity_Click";
 //BA.debugLineNum = 129;BA.debugLine="pnlDim.Visible = True";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 130;BA.debugLine="pnlSelectItems.Visible = True";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 131;BA.debugLine="pnlDim.BringToFront";
mostCurrent._pnldim.BringToFront();
 //BA.debugLineNum = 132;BA.debugLine="pnlSelectItems.BringToFront";
mostCurrent._pnlselectitems.BringToFront();
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _bttnaddtocartqty_click() throws Exception{
int _quantity = 0;
 //BA.debugLineNum = 357;BA.debugLine="Private Sub bttnAddToCartQty_Click";
 //BA.debugLineNum = 358;BA.debugLine="If IsNumber(etQuantityValue.Text) = False Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._etquantityvalue.getText())==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 359;BA.debugLine="ToastMessageShow(\"Please enter a valid number\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter a valid number"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 360;BA.debugLine="etQuantityValue.Text = \"1\"";
mostCurrent._etquantityvalue.setText(BA.ObjectToCharSequence("1"));
 //BA.debugLineNum = 361;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 364;BA.debugLine="Dim quantity As Int = etQuantityValue.Text";
_quantity = (int)(Double.parseDouble(mostCurrent._etquantityvalue.getText()));
 //BA.debugLineNum = 366;BA.debugLine="If quantity < 1 Then";
if (_quantity<1) { 
 //BA.debugLineNum = 367;BA.debugLine="ToastMessageShow(\"Minimum quantity is 1\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Minimum quantity is 1"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 368;BA.debugLine="etQuantityValue.Text = \"1\"";
mostCurrent._etquantityvalue.setText(BA.ObjectToCharSequence("1"));
 //BA.debugLineNum = 369;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 372;BA.debugLine="If quantity > 999 Then";
if (_quantity>999) { 
 //BA.debugLineNum = 373;BA.debugLine="ToastMessageShow(\"Maximum quantity is 999\", True";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Maximum quantity is 999"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 374;BA.debugLine="etQuantityValue.Text = \"999\"";
mostCurrent._etquantityvalue.setText(BA.ObjectToCharSequence("999"));
 //BA.debugLineNum = 375;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 378;BA.debugLine="AddCartItemToList(SelectedItemID, SelectedItemNam";
_addcartitemtolist(_selecteditemid,mostCurrent._selecteditemname,_selecteditemprice,_quantity);
 //BA.debugLineNum = 380;BA.debugLine="RefreshCartDisplay";
_refreshcartdisplay();
 //BA.debugLineNum = 381;BA.debugLine="bttnPurchaseNow.Enabled = True";
mostCurrent._bttnpurchasenow.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 382;BA.debugLine="bttnPurchaseNow.Color = Colors.Blue";
mostCurrent._bttnpurchasenow.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 384;BA.debugLine="ToastMessageShow(\"Added \" & quantity & \"x \" & Sel";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Added "+BA.NumberToString(_quantity)+"x "+mostCurrent._selecteditemname),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 386;BA.debugLine="pnlQuantity.Visible = False";
mostCurrent._pnlquantity.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 387;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 388;BA.debugLine="pnlSelectItems.Visible = False";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 389;BA.debugLine="End Sub";
return "";
}
public static String  _bttncancelpurchasestatus_click() throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Private Sub bttnCancelPurchaseStatus_Click";
 //BA.debugLineNum = 200;BA.debugLine="HidePurchaseStatusPopup";
_hidepurchasestatuspopup();
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public static String  _bttncancelqty_click() throws Exception{
 //BA.debugLineNum = 392;BA.debugLine="Private Sub bttnCancelQty_Click";
 //BA.debugLineNum = 393;BA.debugLine="pnlQuantity.Visible = False";
mostCurrent._pnlquantity.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 394;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
return "";
}
public static String  _bttnconfirmpurchasestatus_click() throws Exception{
String _fulfillmentstatus = "";
 //BA.debugLineNum = 184;BA.debugLine="Private Sub bttnConfirmPurchaseStatus_Click";
 //BA.debugLineNum = 185;BA.debugLine="Dim fulfillmentStatus As String = GetSelectedFulf";
_fulfillmentstatus = _getselectedfulfillmentstatus();
 //BA.debugLineNum = 187;BA.debugLine="If fulfillmentStatus = \"\" Then";
if ((_fulfillmentstatus).equals("")) { 
 //BA.debugLineNum = 188;BA.debugLine="ToastMessageShow(\"Please select a fulfillment st";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please select a fulfillment status"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 189;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 192;BA.debugLine="SaveOrderToLocalDatabase(fulfillmentStatus)";
_saveordertolocaldatabase(_fulfillmentstatus);
 //BA.debugLineNum = 193;BA.debugLine="HidePurchaseStatusPopup";
_hidepurchasestatuspopup();
 //BA.debugLineNum = 194;BA.debugLine="ClearCartAndResetUI";
_clearcartandresetui();
 //BA.debugLineNum = 195;BA.debugLine="ToastMessageShow(\"Order added successfully!\", Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Order added successfully!"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 196;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public static String  _bttnminus_click() throws Exception{
int _currentqty = 0;
 //BA.debugLineNum = 337;BA.debugLine="Private Sub bttnMinus_Click";
 //BA.debugLineNum = 338;BA.debugLine="Dim currentQty As Int = etQuantityValue.Text";
_currentqty = (int)(Double.parseDouble(mostCurrent._etquantityvalue.getText()));
 //BA.debugLineNum = 339;BA.debugLine="If currentQty > 1 Then";
if (_currentqty>1) { 
 //BA.debugLineNum = 340;BA.debugLine="etQuantityValue.Text = (currentQty - 1)";
mostCurrent._etquantityvalue.setText(BA.ObjectToCharSequence((_currentqty-1)));
 }else {
 //BA.debugLineNum = 342;BA.debugLine="ToastMessageShow(\"Minimum quantity is 1\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Minimum quantity is 1"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public static String  _bttnpurchasenow_click() throws Exception{
 //BA.debugLineNum = 147;BA.debugLine="Private Sub bttnPurchaseNow_Click";
 //BA.debugLineNum = 148;BA.debugLine="If CartItems.Size = 0 Then";
if (mostCurrent._cartitems.getSize()==0) { 
 //BA.debugLineNum = 149;BA.debugLine="ToastMessageShow(\"Add items first\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Add items first"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 150;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 153;BA.debugLine="ShowPurchaseStatusPopup";
_showpurchasestatuspopup();
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public static String  _clearcartandresetui() throws Exception{
 //BA.debugLineNum = 221;BA.debugLine="Private Sub ClearCartAndResetUI";
 //BA.debugLineNum = 222;BA.debugLine="CartItems.Clear";
mostCurrent._cartitems.Clear();
 //BA.debugLineNum = 223;BA.debugLine="RefreshCartDisplay";
_refreshcartdisplay();
 //BA.debugLineNum = 225;BA.debugLine="bttnPurchaseNow.Color = Colors.ARGB(80, 200, 200,";
mostCurrent._bttnpurchasenow.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (80),(int) (200),(int) (200),(int) (200)));
 //BA.debugLineNum = 226;BA.debugLine="bttnPurchaseNow.Enabled = False";
mostCurrent._bttnpurchasenow.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 228;BA.debugLine="rbPaidReceived.Checked = True";
mostCurrent._rbpaidreceived.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 229;BA.debugLine="rbPaidBooked.Checked = False";
mostCurrent._rbpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 230;BA.debugLine="rbNotPaidBooked.Checked = False";
mostCurrent._rbnotpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return "";
}
public static String  _clvproducts_itemclick(int _index,Object _value) throws Exception{
int _itemid = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
 //BA.debugLineNum = 308;BA.debugLine="Private Sub clvProducts_ItemClick(Index As Int, Va";
 //BA.debugLineNum = 309;BA.debugLine="Dim itemID As Int = Value";
_itemid = (int)(BA.ObjectToNumber(_value));
 //BA.debugLineNum = 311;BA.debugLine="Dim rs As ResultSet = Main.SQLProducts.ExecQuery2";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE item_id=?",new String[]{BA.NumberToString(_itemid)})));
 //BA.debugLineNum = 313;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
 //BA.debugLineNum = 315;BA.debugLine="SelectedItemID = itemID";
_selecteditemid = _itemid;
 //BA.debugLineNum = 316;BA.debugLine="SelectedItemName = rs.GetString(\"item_name\")";
mostCurrent._selecteditemname = _rs.GetString("item_name");
 //BA.debugLineNum = 317;BA.debugLine="SelectedItemPrice = rs.GetDouble(\"unit_price\")";
_selecteditemprice = _rs.GetDouble("unit_price");
 //BA.debugLineNum = 320;BA.debugLine="lblSelectedItem.Text = SelectedItemName & Chr(10";
mostCurrent._lblselecteditem.setText(BA.ObjectToCharSequence(mostCurrent._selecteditemname+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10)))+"₱"+BA.NumberToString(_selecteditemprice)));
 //BA.debugLineNum = 321;BA.debugLine="etQuantityValue.Text = \"1\"";
mostCurrent._etquantityvalue.setText(BA.ObjectToCharSequence("1"));
 //BA.debugLineNum = 324;BA.debugLine="pnlDim.Visible = True";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 325;BA.debugLine="pnlDim.BringToFront";
mostCurrent._pnldim.BringToFront();
 //BA.debugLineNum = 326;BA.debugLine="pnlQuantity.Visible = True";
mostCurrent._pnlquantity.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 327;BA.debugLine="pnlQuantity.BringToFront";
mostCurrent._pnlquantity.BringToFront();
 };
 //BA.debugLineNum = 329;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
return "";
}
public static String  _etsearchproducts_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Private Sub etSearchProducts_TextChanged(Old As St";
 //BA.debugLineNum = 242;BA.debugLine="LoadProductsIntoList";
_loadproductsintolist();
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public static String  _generatetransactionnumber() throws Exception{
String _safedeviceid = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _nextsequence = 0;
String _lasttransaction = "";
String[] _parts = null;
 //BA.debugLineNum = 92;BA.debugLine="Sub GenerateTransactionNumber As String";
 //BA.debugLineNum = 93;BA.debugLine="Try";
try { //BA.debugLineNum = 94;BA.debugLine="Dim safeDeviceID As String = Main.DEVICE_ID";
_safedeviceid = mostCurrent._main._device_id /*String*/ ;
 //BA.debugLineNum = 95;BA.debugLine="If safeDeviceID = Null Or safeDeviceID = \"\" Then";
if (_safedeviceid== null || (_safedeviceid).equals("")) { 
_safedeviceid = "UNKNOWNDEVICE";};
 //BA.debugLineNum = 97;BA.debugLine="Dim cursor As Cursor = Main.SQLProducts.ExecQuer";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT transaction_number FROM orders WHERE device_id = ? ORDER BY order_id DESC LIMIT 1",new String[]{_safedeviceid})));
 //BA.debugLineNum = 101;BA.debugLine="Dim nextSequence As Int = 1";
_nextsequence = (int) (1);
 //BA.debugLineNum = 103;BA.debugLine="If cursor.RowCount > 0 Then";
if (_cursor.getRowCount()>0) { 
 //BA.debugLineNum = 104;BA.debugLine="cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 105;BA.debugLine="Dim lastTransaction As String = cursor.GetStrin";
_lasttransaction = _cursor.GetString("transaction_number");
 //BA.debugLineNum = 106;BA.debugLine="If lastTransaction <> Null And lastTransaction.";
if (_lasttransaction!= null && _lasttransaction.contains("-")) { 
 //BA.debugLineNum = 107;BA.debugLine="Dim parts() As String = Regex.Split(\"-\", lastT";
_parts = anywheresoftware.b4a.keywords.Common.Regex.Split("-",_lasttransaction);
 //BA.debugLineNum = 108;BA.debugLine="If parts.Length >= 2 Then";
if (_parts.length>=2) { 
 //BA.debugLineNum = 109;BA.debugLine="nextSequence = parts(parts.Length - 1) + 1";
_nextsequence = (int) ((double)(Double.parseDouble(_parts[(int) (_parts.length-1)]))+1);
 };
 };
 };
 //BA.debugLineNum = 113;BA.debugLine="cursor.Close";
_cursor.Close();
 //BA.debugLineNum = 115;BA.debugLine="Return safeDeviceID & \"-\" & NumberFormat(nextSeq";
if (true) return _safedeviceid+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_nextsequence,(int) (3),(int) (0));
 } 
       catch (Exception e19) {
			processBA.setLastException(e19); //BA.debugLineNum = 118;BA.debugLine="Log(\"GenerateTransactionNumber error: \" & LastEx";
anywheresoftware.b4a.keywords.Common.LogImpl("03473434","GenerateTransactionNumber error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 //BA.debugLineNum = 119;BA.debugLine="Return Main.DEVICE_ID & \"-ERR\"";
if (true) return mostCurrent._main._device_id /*String*/ +"-ERR";
 };
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static String  _getdeliverystatusfromfulfillmentstatus(String _fulfillmentstatus) throws Exception{
 //BA.debugLineNum = 519;BA.debugLine="Private Sub GetDeliveryStatusFromFulfillmentStatus";
 //BA.debugLineNum = 520;BA.debugLine="If FulfillmentStatus = \"Paid-Received\" Then";
if ((_fulfillmentstatus).equals("Paid-Received")) { 
 //BA.debugLineNum = 521;BA.debugLine="Return \"Received\"";
if (true) return "Received";
 }else {
 //BA.debugLineNum = 523;BA.debugLine="Return \"NotReceived\"";
if (true) return "NotReceived";
 };
 //BA.debugLineNum = 525;BA.debugLine="End Sub";
return "";
}
public static String  _getpaymentstatusfromfulfillmentstatus(String _fulfillmentstatus) throws Exception{
 //BA.debugLineNum = 510;BA.debugLine="Private Sub GetPaymentStatusFromFulfillmentStatus(";
 //BA.debugLineNum = 511;BA.debugLine="If FulfillmentStatus = \"Paid-Received\" Or Fulfill";
if ((_fulfillmentstatus).equals("Paid-Received") || (_fulfillmentstatus).equals("Paid-Booked")) { 
 //BA.debugLineNum = 512;BA.debugLine="Return \"Paid\"";
if (true) return "Paid";
 }else {
 //BA.debugLineNum = 514;BA.debugLine="Return \"NotPaid\"";
if (true) return "NotPaid";
 };
 //BA.debugLineNum = 516;BA.debugLine="End Sub";
return "";
}
public static String  _getselectedfulfillmentstatus() throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Private Sub GetSelectedFulfillmentStatus As String";
 //BA.debugLineNum = 173;BA.debugLine="If rbPaidReceived.Checked Then";
if (mostCurrent._rbpaidreceived.getChecked()) { 
 //BA.debugLineNum = 174;BA.debugLine="Return \"Paid-Received\"";
if (true) return "Paid-Received";
 }else if(mostCurrent._rbpaidbooked.getChecked()) { 
 //BA.debugLineNum = 176;BA.debugLine="Return \"Paid-Booked\"";
if (true) return "Paid-Booked";
 }else if(mostCurrent._rbnotpaidbooked.getChecked()) { 
 //BA.debugLineNum = 178;BA.debugLine="Return \"NotPaid-Booked\"";
if (true) return "NotPaid-Booked";
 }else {
 //BA.debugLineNum = 180;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private CartItems As List";
mostCurrent._cartitems = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 15;BA.debugLine="Private SelectedItemID As Int";
_selecteditemid = 0;
 //BA.debugLineNum = 16;BA.debugLine="Private SelectedItemName As String";
mostCurrent._selecteditemname = "";
 //BA.debugLineNum = 17;BA.debugLine="Private SelectedItemPrice As Double";
_selecteditemprice = 0;
 //BA.debugLineNum = 20;BA.debugLine="Private pnladdOrderActivityTop As Panel";
mostCurrent._pnladdorderactivitytop = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private pnladdOrderActivityWhole As Panel";
mostCurrent._pnladdorderactivitywhole = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private pnlDim As Panel";
mostCurrent._pnldim = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private svCartSummary As ScrollView";
mostCurrent._svcartsummary = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lblTotalItems As Label";
mostCurrent._lbltotalitems = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblTotalAmount As Label";
mostCurrent._lbltotalamount = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private bttnPurchaseNow As Button";
mostCurrent._bttnpurchasenow = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lblExitOrderActivity As Label";
mostCurrent._lblexitorderactivity = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private bttnAddOrderActivity As Button";
mostCurrent._bttnaddorderactivity = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private pnlSelectItems As Panel";
mostCurrent._pnlselectitems = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private clvProducts As CustomListView";
mostCurrent._clvproducts = new b4a.example3.customlistview();
 //BA.debugLineNum = 33;BA.debugLine="Private etSearchProducts As EditText";
mostCurrent._etsearchproducts = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private lblExitSelectItems As Label";
mostCurrent._lblexitselectitems = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private pnlQuantity As Panel";
mostCurrent._pnlquantity = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private lblQuantityTitle As Label";
mostCurrent._lblquantitytitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lblSelectedItem As Label";
mostCurrent._lblselecteditem = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private etQuantityValue As EditText";
mostCurrent._etquantityvalue = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private bttnMinus As Button";
mostCurrent._bttnminus = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private bttnAdd As Button";
mostCurrent._bttnadd = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private bttnAddToCartQty As Button";
mostCurrent._bttnaddtocartqty = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private bttnCancelQty As Button";
mostCurrent._bttncancelqty = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private pnlPurchaseStatus As Panel";
mostCurrent._pnlpurchasestatus = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private lblPurchaseStatusTitle As Label";
mostCurrent._lblpurchasestatustitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private lblPurchaseStatusMessage As Label";
mostCurrent._lblpurchasestatusmessage = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private rbPaidReceived As RadioButton";
mostCurrent._rbpaidreceived = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private rbPaidBooked As RadioButton";
mostCurrent._rbpaidbooked = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private rbNotPaidBooked As RadioButton";
mostCurrent._rbnotpaidbooked = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private bttnConfirmPurchaseStatus As Button";
mostCurrent._bttnconfirmpurchasestatus = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private bttnCancelPurchaseStatus As Button";
mostCurrent._bttncancelpurchasestatus = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _hidepurchasestatuspopup() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Private Sub HidePurchaseStatusPopup";
 //BA.debugLineNum = 168;BA.debugLine="pnlPurchaseStatus.Visible = False";
mostCurrent._pnlpurchasestatus.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 169;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public static String  _lblexitorderactivity_click() throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Private Sub lblExitOrderActivity_Click";
 //BA.debugLineNum = 143;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public static String  _lblexitselectitems_click() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Private Sub lblExitSelectItems_Click";
 //BA.debugLineNum = 137;BA.debugLine="pnlDim.Visible = False";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 138;BA.debugLine="pnlSelectItems.Visible = False";
mostCurrent._pnlselectitems.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _loadproductsintolist() throws Exception{
String _searchtext = "";
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
String _vendoridtext = "";
String _likevalue = "";
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblprice = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsku = null;
 //BA.debugLineNum = 246;BA.debugLine="Private Sub LoadProductsIntoList";
 //BA.debugLineNum = 247;BA.debugLine="clvProducts.Clear";
mostCurrent._clvproducts._clear();
 //BA.debugLineNum = 249;BA.debugLine="If Main.VENDOR_ID <= 0 Then";
if (mostCurrent._main._vendor_id /*int*/ <=0) { 
 //BA.debugLineNum = 250;BA.debugLine="ToastMessageShow(\"No vendor assigned. Please log";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No vendor assigned. Please login again."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 251;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 254;BA.debugLine="Dim searchText As String = etSearchProducts.Text.";
_searchtext = mostCurrent._etsearchproducts.getText().trim().toLowerCase();
 //BA.debugLineNum = 255;BA.debugLine="Dim rs As ResultSet";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
 //BA.debugLineNum = 256;BA.debugLine="Dim vendorIDText As String = Main.VENDOR_ID";
_vendoridtext = BA.NumberToString(mostCurrent._main._vendor_id /*int*/ );
 //BA.debugLineNum = 258;BA.debugLine="If searchText = \"\" Then";
if ((_searchtext).equals("")) { 
 //BA.debugLineNum = 259;BA.debugLine="rs = Main.SQLProducts.ExecQuery2( _";
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE is_active = 1 AND vendor_id = ? ORDER BY item_name",new String[]{_vendoridtext})));
 }else {
 //BA.debugLineNum = 263;BA.debugLine="Dim likeValue As String = \"%\" & searchText & \"%\"";
_likevalue = "%"+_searchtext+"%";
 //BA.debugLineNum = 264;BA.debugLine="rs = Main.SQLProducts.ExecQuery2( _";
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT * FROM items WHERE is_active = 1 AND vendor_id = ? AND (LOWER(item_name) LIKE ? OR LOWER(item_code) LIKE ?) ORDER BY item_name",new String[]{_vendoridtext,_likevalue,_likevalue})));
 };
 //BA.debugLineNum = 269;BA.debugLine="If rs.RowCount = 0 Then";
if (_rs.getRowCount()==0) { 
 //BA.debugLineNum = 270;BA.debugLine="ToastMessageShow(\"No products found for your ven";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No products found for your vendor."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 271;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 272;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 275;BA.debugLine="Do While rs.NextRow";
while (_rs.NextRow()) {
 //BA.debugLineNum = 276;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 277;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 278;BA.debugLine="pnl.SetLayout(0, 0, clvProducts.AsView.Width, 70";
_pnl.SetLayout((int) (0),(int) (0),mostCurrent._clvproducts._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
 //BA.debugLineNum = 280;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 281;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 282;BA.debugLine="lblName.Text = rs.GetString(\"item_name\")";
_lblname.setText(BA.ObjectToCharSequence(_rs.GetString("item_name")));
 //BA.debugLineNum = 283;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
 //BA.debugLineNum = 284;BA.debugLine="lblName.SetLayout(10dip, 5dip, 70%x, 25dip)";
_lblname.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
 //BA.debugLineNum = 286;BA.debugLine="Dim lblPrice As Label";
_lblprice = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 287;BA.debugLine="lblPrice.Initialize(\"\")";
_lblprice.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 288;BA.debugLine="lblPrice.Text = \"₱\" & rs.GetDouble(\"unit_price\")";
_lblprice.setText(BA.ObjectToCharSequence("₱"+BA.NumberToString(_rs.GetDouble("unit_price"))));
 //BA.debugLineNum = 289;BA.debugLine="lblPrice.SetLayout(10dip, 30dip, 70%x, 20dip)";
_lblprice.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 291;BA.debugLine="Dim lblSku As Label";
_lblsku = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 292;BA.debugLine="lblSku.Initialize(\"\")";
_lblsku.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 293;BA.debugLine="lblSku.Text = \"SKU: \" & rs.GetString(\"item_code\"";
_lblsku.setText(BA.ObjectToCharSequence("SKU: "+_rs.GetString("item_code")));
 //BA.debugLineNum = 294;BA.debugLine="lblSku.TextSize = 12";
_lblsku.setTextSize((float) (12));
 //BA.debugLineNum = 295;BA.debugLine="lblSku.SetLayout(10dip, 50dip, 70%x, 15dip)";
_lblsku.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)));
 //BA.debugLineNum = 297;BA.debugLine="pnl.AddView(lblName, lblName.Left, lblName.Top,";
_pnl.AddView((android.view.View)(_lblname.getObject()),_lblname.getLeft(),_lblname.getTop(),_lblname.getWidth(),_lblname.getHeight());
 //BA.debugLineNum = 298;BA.debugLine="pnl.AddView(lblPrice, lblPrice.Left, lblPrice.To";
_pnl.AddView((android.view.View)(_lblprice.getObject()),_lblprice.getLeft(),_lblprice.getTop(),_lblprice.getWidth(),_lblprice.getHeight());
 //BA.debugLineNum = 299;BA.debugLine="pnl.AddView(lblSku, lblSku.Left, lblSku.Top, lbl";
_pnl.AddView((android.view.View)(_lblsku.getObject()),_lblsku.getLeft(),_lblsku.getTop(),_lblsku.getWidth(),_lblsku.getHeight());
 //BA.debugLineNum = 301;BA.debugLine="clvProducts.Add(pnl, rs.GetInt(\"item_id\"))";
mostCurrent._clvproducts._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject())),(Object)(_rs.GetInt("item_id")));
 }
;
 //BA.debugLineNum = 304;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public static String  _pnldim_click() throws Exception{
 //BA.debugLineNum = 233;BA.debugLine="Private Sub pnlDim_Click";
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public static String  _rbnotpaidbooked_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Private Sub rbNotPaidBooked_CheckedChange(Checked";
 //BA.debugLineNum = 215;BA.debugLine="If Checked = False Then Return";
if (_checked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 216;BA.debugLine="rbPaidReceived.Checked = False";
mostCurrent._rbpaidreceived.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 217;BA.debugLine="rbPaidBooked.Checked = False";
mostCurrent._rbpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public static String  _rbpaidbooked_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Private Sub rbPaidBooked_CheckedChange(Checked As";
 //BA.debugLineNum = 210;BA.debugLine="If Checked = False Then Return";
if (_checked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 211;BA.debugLine="rbPaidReceived.Checked = False";
mostCurrent._rbpaidreceived.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 212;BA.debugLine="rbNotPaidBooked.Checked = False";
mostCurrent._rbnotpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public static String  _rbpaidreceived_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Private Sub rbPaidReceived_CheckedChange(Checked A";
 //BA.debugLineNum = 204;BA.debugLine="If Checked = False Then Return";
if (_checked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 205;BA.debugLine="rbPaidBooked.Checked = False";
mostCurrent._rbpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 206;BA.debugLine="rbNotPaidBooked.Checked = False";
mostCurrent._rbnotpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public static String  _refreshcartdisplay() throws Exception{
int _top = 0;
double _totalamount = 0;
int _totalquantity = 0;
anywheresoftware.b4a.objects.collections.Map _cartitem = null;
String _itemname = "";
double _unitprice = 0;
int _quantity = 0;
double _linetotal = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblqty = null;
anywheresoftware.b4a.objects.LabelWrapper _lbllinetotal = null;
 //BA.debugLineNum = 402;BA.debugLine="Private Sub RefreshCartDisplay";
 //BA.debugLineNum = 403;BA.debugLine="svCartSummary.Panel.RemoveAllViews";
mostCurrent._svcartsummary.getPanel().RemoveAllViews();
 //BA.debugLineNum = 404;BA.debugLine="Dim top As Int = 0";
_top = (int) (0);
 //BA.debugLineNum = 405;BA.debugLine="Dim totalAmount As Double = 0";
_totalamount = 0;
 //BA.debugLineNum = 406;BA.debugLine="Dim totalQuantity As Int = 0";
_totalquantity = (int) (0);
 //BA.debugLineNum = 408;BA.debugLine="For Each cartItem As Map In CartItems";
_cartitem = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group5 = mostCurrent._cartitems;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_cartitem = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group5.Get(index5)));
 //BA.debugLineNum = 409;BA.debugLine="Dim itemName As String = cartItem.Get(\"item_name";
_itemname = BA.ObjectToString(_cartitem.Get((Object)("item_name")));
 //BA.debugLineNum = 410;BA.debugLine="Dim unitPrice As Double = cartItem.Get(\"unit_pri";
_unitprice = (double)(BA.ObjectToNumber(_cartitem.Get((Object)("unit_price"))));
 //BA.debugLineNum = 411;BA.debugLine="Dim quantity As Int = cartItem.Get(\"quantity\")";
_quantity = (int)(BA.ObjectToNumber(_cartitem.Get((Object)("quantity"))));
 //BA.debugLineNum = 412;BA.debugLine="Dim lineTotal As Double = unitPrice * quantity";
_linetotal = _unitprice*_quantity;
 //BA.debugLineNum = 414;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 415;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 416;BA.debugLine="pnl.Color = Colors.White";
_pnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 417;BA.debugLine="pnl.SetLayout(0, top, svCartSummary.Width, 70dip";
_pnl.SetLayout((int) (0),_top,mostCurrent._svcartsummary.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
 //BA.debugLineNum = 419;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 420;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 421;BA.debugLine="lblName.Text = itemName";
_lblname.setText(BA.ObjectToCharSequence(_itemname));
 //BA.debugLineNum = 422;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
 //BA.debugLineNum = 423;BA.debugLine="lblName.TextColor = Colors.Black";
_lblname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 424;BA.debugLine="lblName.SetLayout(10dip, 5dip, 60%x, 25dip)";
_lblname.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
 //BA.debugLineNum = 426;BA.debugLine="Dim lblQty As Label";
_lblqty = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 427;BA.debugLine="lblQty.Initialize(\"\")";
_lblqty.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 428;BA.debugLine="lblQty.Text = \"Qty: \" & quantity";
_lblqty.setText(BA.ObjectToCharSequence("Qty: "+BA.NumberToString(_quantity)));
 //BA.debugLineNum = 429;BA.debugLine="lblQty.TextSize = 14";
_lblqty.setTextSize((float) (14));
 //BA.debugLineNum = 430;BA.debugLine="lblQty.TextColor = Colors.Gray";
_lblqty.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 431;BA.debugLine="lblQty.SetLayout(10dip, 32dip, 30%x, 20dip)";
_lblqty.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 433;BA.debugLine="Dim lblLineTotal As Label";
_lbllinetotal = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 434;BA.debugLine="lblLineTotal.Initialize(\"\")";
_lbllinetotal.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 435;BA.debugLine="lblLineTotal.Text = \"₱\" & NumberFormat2(lineTota";
_lbllinetotal.setText(BA.ObjectToCharSequence("₱"+anywheresoftware.b4a.keywords.Common.NumberFormat2(_linetotal,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 436;BA.debugLine="lblLineTotal.TextSize = 16";
_lbllinetotal.setTextSize((float) (16));
 //BA.debugLineNum = 437;BA.debugLine="lblLineTotal.TextColor = Colors.RGB(0, 120, 0)";
_lbllinetotal.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (120),(int) (0)));
 //BA.debugLineNum = 438;BA.debugLine="lblLineTotal.Gravity = Gravity.RIGHT";
_lbllinetotal.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.RIGHT);
 //BA.debugLineNum = 439;BA.debugLine="lblLineTotal.SetLayout(65%x, 10dip, 30%x, 25dip)";
_lbllinetotal.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (65),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
 //BA.debugLineNum = 441;BA.debugLine="pnl.AddView(lblName, lblName.Left, lblName.Top,";
_pnl.AddView((android.view.View)(_lblname.getObject()),_lblname.getLeft(),_lblname.getTop(),_lblname.getWidth(),_lblname.getHeight());
 //BA.debugLineNum = 442;BA.debugLine="pnl.AddView(lblQty, lblQty.Left, lblQty.Top, lbl";
_pnl.AddView((android.view.View)(_lblqty.getObject()),_lblqty.getLeft(),_lblqty.getTop(),_lblqty.getWidth(),_lblqty.getHeight());
 //BA.debugLineNum = 443;BA.debugLine="pnl.AddView(lblLineTotal, lblLineTotal.Left, lbl";
_pnl.AddView((android.view.View)(_lbllinetotal.getObject()),_lbllinetotal.getLeft(),_lbllinetotal.getTop(),_lbllinetotal.getWidth(),_lbllinetotal.getHeight());
 //BA.debugLineNum = 445;BA.debugLine="svCartSummary.Panel.AddView(pnl, 0, top, pnl.Wid";
mostCurrent._svcartsummary.getPanel().AddView((android.view.View)(_pnl.getObject()),(int) (0),_top,_pnl.getWidth(),_pnl.getHeight());
 //BA.debugLineNum = 446;BA.debugLine="top = top + pnl.Height + 3dip";
_top = (int) (_top+_pnl.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
 //BA.debugLineNum = 448;BA.debugLine="totalAmount = totalAmount + lineTotal";
_totalamount = _totalamount+_linetotal;
 //BA.debugLineNum = 449;BA.debugLine="totalQuantity = totalQuantity + quantity";
_totalquantity = (int) (_totalquantity+_quantity);
 }
};
 //BA.debugLineNum = 452;BA.debugLine="svCartSummary.Panel.Height = top";
mostCurrent._svcartsummary.getPanel().setHeight(_top);
 //BA.debugLineNum = 453;BA.debugLine="lblTotalItems.Text = \"Items: \" & CartItems.Size &";
mostCurrent._lbltotalitems.setText(BA.ObjectToCharSequence("Items: "+BA.NumberToString(mostCurrent._cartitems.getSize())+" entries ("+BA.NumberToString(_totalquantity)+" total)"));
 //BA.debugLineNum = 454;BA.debugLine="lblTotalAmount.Text = \"Total: ₱\" & NumberFormat2(";
mostCurrent._lbltotalamount.setText(BA.ObjectToCharSequence("Total: ₱"+anywheresoftware.b4a.keywords.Common.NumberFormat2(_totalamount,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 455;BA.debugLine="End Sub";
return "";
}
public static String  _saveordertolocaldatabase(String _fulfillmentstatus) throws Exception{
String _transactionnumber = "";
double _total = 0;
anywheresoftware.b4a.objects.collections.Map _cartitem = null;
double _unitprice = 0;
int _quantity = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rsneworder = null;
int _neworderid = 0;
int _productid = 0;
String _paymentstatus = "";
String _deliverystatus = "";
 //BA.debugLineNum = 462;BA.debugLine="Private Sub SaveOrderToLocalDatabase(FulfillmentSt";
 //BA.debugLineNum = 463;BA.debugLine="Try";
try { //BA.debugLineNum = 464;BA.debugLine="If Main.VENDOR_ID <= 0 Or Main.LoggedInUserID <=";
if (mostCurrent._main._vendor_id /*int*/ <=0 || mostCurrent._main._loggedinuserid /*int*/ <=0) { 
 //BA.debugLineNum = 465;BA.debugLine="ToastMessageShow(\"Missing user/vendor session.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Missing user/vendor session. Please login again."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 466;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 469;BA.debugLine="Dim transactionNumber As String = GenerateTransa";
_transactionnumber = _generatetransactionnumber();
 //BA.debugLineNum = 470;BA.debugLine="Dim total As Double = 0";
_total = 0;
 //BA.debugLineNum = 472;BA.debugLine="For Each cartItem As Map In CartItems";
_cartitem = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group8 = mostCurrent._cartitems;
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_cartitem = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group8.Get(index8)));
 //BA.debugLineNum = 473;BA.debugLine="Dim unitPrice As Double = cartItem.Get(\"unit_pr";
_unitprice = (double)(BA.ObjectToNumber(_cartitem.Get((Object)("unit_price"))));
 //BA.debugLineNum = 474;BA.debugLine="Dim quantity As Int = cartItem.Get(\"quantity\")";
_quantity = (int)(BA.ObjectToNumber(_cartitem.Get((Object)("quantity"))));
 //BA.debugLineNum = 475;BA.debugLine="total = total + (unitPrice * quantity)";
_total = _total+(_unitprice*_quantity);
 }
};
 //BA.debugLineNum = 478;BA.debugLine="Main.SQLProducts.ExecNonQuery2( _             \"I";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO orders (vendor_id, user_id, transaction_number, device_id, date_created, status, total_amount, sync_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._main._vendor_id /*int*/ ),(Object)(mostCurrent._main._loggedinuserid /*int*/ ),(Object)(_transactionnumber),(Object)(mostCurrent._main._device_id /*String*/ ),(Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()),(Object)("Pending"),(Object)(_total),(Object)("Holding")}));
 //BA.debugLineNum = 482;BA.debugLine="Dim rsNewOrder As ResultSet = Main.SQLProducts.E";
_rsneworder = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rsneworder = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT last_insert_rowid() AS id")));
 //BA.debugLineNum = 483;BA.debugLine="rsNewOrder.NextRow";
_rsneworder.NextRow();
 //BA.debugLineNum = 484;BA.debugLine="Dim newOrderID As Int = rsNewOrder.GetInt(\"id\")";
_neworderid = _rsneworder.GetInt("id");
 //BA.debugLineNum = 485;BA.debugLine="rsNewOrder.Close";
_rsneworder.Close();
 //BA.debugLineNum = 487;BA.debugLine="For Each cartItem As Map In CartItems";
_cartitem = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group18 = mostCurrent._cartitems;
final int groupLen18 = group18.getSize()
;int index18 = 0;
;
for (; index18 < groupLen18;index18++){
_cartitem = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group18.Get(index18)));
 //BA.debugLineNum = 488;BA.debugLine="Dim productID As Int = cartItem.Get(\"product_id";
_productid = (int)(BA.ObjectToNumber(_cartitem.Get((Object)("product_id"))));
 //BA.debugLineNum = 489;BA.debugLine="Dim unitPrice As Double = cartItem.Get(\"unit_pr";
_unitprice = (double)(BA.ObjectToNumber(_cartitem.Get((Object)("unit_price"))));
 //BA.debugLineNum = 490;BA.debugLine="Dim quantity As Int = cartItem.Get(\"quantity\")";
_quantity = (int)(BA.ObjectToNumber(_cartitem.Get((Object)("quantity"))));
 //BA.debugLineNum = 491;BA.debugLine="Dim paymentStatus As String = GetPaymentStatusF";
_paymentstatus = _getpaymentstatusfromfulfillmentstatus(_fulfillmentstatus);
 //BA.debugLineNum = 492;BA.debugLine="Dim deliveryStatus As String = GetDeliveryStatu";
_deliverystatus = _getdeliverystatusfromfulfillmentstatus(_fulfillmentstatus);
 //BA.debugLineNum = 494;BA.debugLine="Main.SQLProducts.ExecNonQuery2( _";
mostCurrent._main._sqlproducts /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT INTO order_items (order_id, product_id, quantity, price, fulfillment_status, payment_status, delivery_status) VALUES (?, ?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_neworderid),(Object)(_productid),(Object)(_quantity),(Object)(_unitprice),(Object)(_fulfillmentstatus),(Object)(_paymentstatus),(Object)(_deliverystatus)}));
 }
};
 //BA.debugLineNum = 499;BA.debugLine="Log(\"Order saved with transaction: \" & transacti";
anywheresoftware.b4a.keywords.Common.LogImpl("04980773","Order saved with transaction: "+_transactionnumber,0);
 } 
       catch (Exception e28) {
			processBA.setLastException(e28); //BA.debugLineNum = 502;BA.debugLine="Log(\"SaveOrderToLocalDatabase error: \" & LastExc";
anywheresoftware.b4a.keywords.Common.LogImpl("04980776","SaveOrderToLocalDatabase error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 //BA.debugLineNum = 503;BA.debugLine="ToastMessageShow(\"Failed to save order. Please t";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Failed to save order. Please try again."),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 505;BA.debugLine="End Sub";
return "";
}
public static String  _showpurchasestatuspopup() throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Private Sub ShowPurchaseStatusPopup";
 //BA.debugLineNum = 157;BA.debugLine="rbPaidReceived.Checked = True";
mostCurrent._rbpaidreceived.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 158;BA.debugLine="rbPaidBooked.Checked = False";
mostCurrent._rbpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 159;BA.debugLine="rbNotPaidBooked.Checked = False";
mostCurrent._rbnotpaidbooked.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 161;BA.debugLine="pnlDim.Visible = True";
mostCurrent._pnldim.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 162;BA.debugLine="pnlDim.BringToFront";
mostCurrent._pnldim.BringToFront();
 //BA.debugLineNum = 163;BA.debugLine="pnlPurchaseStatus.Visible = True";
mostCurrent._pnlpurchasestatus.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 164;BA.debugLine="pnlPurchaseStatus.BringToFront";
mostCurrent._pnlpurchasestatus.BringToFront();
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
}
