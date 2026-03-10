
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

public class userorders implements IRemote{
	public static userorders mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public userorders() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("userorders"), "b4a.OrderTakerTest1.userorders");
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
		pcBA = new PCBA(this, userorders.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sqlproducts = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbllogout = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblperson = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblloggedinuser = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _pnlbottomnav = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbldash = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbldashicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblhistory = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblhistoryicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblinventory = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblinventoryicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblorders = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblordersicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnldash = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlhistory = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlinventory = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlorders = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _bttnaddorder = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pnladdorderhometotal = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lblexitaddorderhome = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnldim = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btnadditems = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pnlselectitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _svselectitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _etsearchitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _btnpurchasenow = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lblexitselectitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.OrderTakerTest1.main _main = null;
public static b4a.OrderTakerTest1.controls _controls = null;
public static b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public static b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public static b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",userorders.mostCurrent._activity,"addOrderActivity",Debug.moduleToString(b4a.OrderTakerTest1.addorderactivity.class),"btnAddItems",userorders.mostCurrent._btnadditems,"btnPurchaseNow",userorders.mostCurrent._btnpurchasenow,"bttnAddOrder",userorders.mostCurrent._bttnaddorder,"Controls",Debug.moduleToString(b4a.OrderTakerTest1.controls.class),"etSearchItems",userorders.mostCurrent._etsearchitems,"forgotPass",Debug.moduleToString(b4a.OrderTakerTest1.forgotpass.class),"HttpUtils2Service",Debug.moduleToString(b4a.OrderTakerTest1.httputils2service.class),"lblDash",userorders.mostCurrent._lbldash,"lblDashIcon",userorders.mostCurrent._lbldashicon,"lblExitAddOrderHome",userorders.mostCurrent._lblexitaddorderhome,"lblExitSelectItems",userorders.mostCurrent._lblexitselectitems,"lblHistory",userorders.mostCurrent._lblhistory,"lblHistoryIcon",userorders.mostCurrent._lblhistoryicon,"lblInventory",userorders.mostCurrent._lblinventory,"lblInventoryIcon",userorders.mostCurrent._lblinventoryicon,"lblLoggedInUser",userorders.mostCurrent._lblloggedinuser,"lbllogout",userorders.mostCurrent._lbllogout,"lblOrders",userorders.mostCurrent._lblorders,"lblOrdersIcon",userorders.mostCurrent._lblordersicon,"lblperson",userorders.mostCurrent._lblperson,"Main",Debug.moduleToString(b4a.OrderTakerTest1.main.class),"OrderTakerDashboard",Debug.moduleToString(b4a.OrderTakerTest1.ordertakerdashboard.class),"Panel1",userorders.mostCurrent._panel1,"pnlAddOrderHomeTotal",userorders.mostCurrent._pnladdorderhometotal,"pnlBottomNav",userorders.mostCurrent._pnlbottomnav,"pnlDash",userorders.mostCurrent._pnldash,"pnlDim",userorders.mostCurrent._pnldim,"pnlHistory",userorders.mostCurrent._pnlhistory,"pnlInventory",userorders.mostCurrent._pnlinventory,"pnlOrders",userorders.mostCurrent._pnlorders,"pnlSelectItems",userorders.mostCurrent._pnlselectitems,"ScrollView1",userorders.mostCurrent._scrollview1,"SQLProducts",userorders._sqlproducts,"Starter",Debug.moduleToString(b4a.OrderTakerTest1.starter.class),"svSelectItems",userorders.mostCurrent._svselectitems,"xui",userorders._xui};
}
}