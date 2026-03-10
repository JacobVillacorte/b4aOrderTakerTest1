
package b4a.OrderTakerTest1;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class addorderactivity implements IRemote{
	public static addorderactivity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public addorderactivity() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("addorderactivity"), "b4a.OrderTakerTest1.addorderactivity");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, addorderactivity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _cartitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _bttnaddorderactivity = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _bttnpurchasenow = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _clvproducts = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _etsearchproducts = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lblexitorderactivity = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblexitselectitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbltotalitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbltotalamount = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnladdorderactivitytop = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnladdorderactivitywhole = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnldim = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlselectitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _svcartsummary = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _pnlquantity = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lblquantitytitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _bttncancelqty = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lblselecteditem = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _bttnminus = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lblquantityvalue = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _bttnadd = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _bttnaddtocartqty = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _selecteditemid = RemoteObject.createImmutable(0);
public static RemoteObject _selecteditemname = RemoteObject.createImmutable("");
public static RemoteObject _selecteditemprice = RemoteObject.createImmutable(0);
public static b4a.OrderTakerTest1.main _main = null;
public static b4a.OrderTakerTest1.controls _controls = null;
public static b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public static b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.userorders _userorders = null;
public static b4a.OrderTakerTest1.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",addorderactivity.mostCurrent._activity,"bttnAdd",addorderactivity.mostCurrent._bttnadd,"bttnAddOrderActivity",addorderactivity.mostCurrent._bttnaddorderactivity,"bttnAddToCartQty",addorderactivity.mostCurrent._bttnaddtocartqty,"bttnCancelQty",addorderactivity.mostCurrent._bttncancelqty,"bttnMinus",addorderactivity.mostCurrent._bttnminus,"bttnPurchaseNow",addorderactivity.mostCurrent._bttnpurchasenow,"CartItems",addorderactivity.mostCurrent._cartitems,"clvProducts",addorderactivity.mostCurrent._clvproducts,"Controls",Debug.moduleToString(b4a.OrderTakerTest1.controls.class),"etSearchProducts",addorderactivity.mostCurrent._etsearchproducts,"forgotPass",Debug.moduleToString(b4a.OrderTakerTest1.forgotpass.class),"HttpUtils2Service",Debug.moduleToString(b4a.OrderTakerTest1.httputils2service.class),"lblExitOrderActivity",addorderactivity.mostCurrent._lblexitorderactivity,"lblExitSelectItems",addorderactivity.mostCurrent._lblexitselectitems,"lblQuantityTitle",addorderactivity.mostCurrent._lblquantitytitle,"lblQuantityValue",addorderactivity.mostCurrent._lblquantityvalue,"lblSelectedItem",addorderactivity.mostCurrent._lblselecteditem,"lblTotalAmount",addorderactivity.mostCurrent._lbltotalamount,"lblTotalItems",addorderactivity.mostCurrent._lbltotalitems,"Main",Debug.moduleToString(b4a.OrderTakerTest1.main.class),"OrderTakerDashboard",Debug.moduleToString(b4a.OrderTakerTest1.ordertakerdashboard.class),"pnladdOrderActivityTop",addorderactivity.mostCurrent._pnladdorderactivitytop,"pnladdOrderActivityWhole",addorderactivity.mostCurrent._pnladdorderactivitywhole,"pnlDim",addorderactivity.mostCurrent._pnldim,"pnlQuantity",addorderactivity.mostCurrent._pnlquantity,"pnlSelectItems",addorderactivity.mostCurrent._pnlselectitems,"SelectedItemID",addorderactivity._selecteditemid,"SelectedItemName",addorderactivity.mostCurrent._selecteditemname,"SelectedItemPrice",addorderactivity._selecteditemprice,"Starter",Debug.moduleToString(b4a.OrderTakerTest1.starter.class),"svCartSummary",addorderactivity.mostCurrent._svcartsummary,"userOrders",Debug.moduleToString(b4a.OrderTakerTest1.userorders.class),"xui",addorderactivity._xui};
}
}