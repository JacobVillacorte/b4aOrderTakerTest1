
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

public class ordertakerdashboard implements IRemote{
	public static ordertakerdashboard mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public ordertakerdashboard() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("ordertakerdashboard"), "b4a.OrderTakerTest1.ordertakerdashboard");
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
		pcBA = new PCBA(this, ordertakerdashboard.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _bttnaddorder = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lbldash = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbldashicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblhistory = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblhistoryicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblinventory = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblinventoryicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblloggedinuser = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbllogout = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblorders = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblordersicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblperson = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlbottomnav = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlcontent = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlcontentdash = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlcontenthistory = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlcontentinventory = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlcontentorders = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnldash = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnldim = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlhistory = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlinventory = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlorders = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnltop = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _etcontentsearchorder = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _clvcontentorders = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _lblfetchstatus = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _bttnfetchproducts = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _svinventory = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _lblcacheinfo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.OrderTakerTest1.main _main = null;
public static b4a.OrderTakerTest1.controls _controls = null;
public static b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public static b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.userorders _userorders = null;
public static b4a.OrderTakerTest1.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",ordertakerdashboard.mostCurrent._activity,"addOrderActivity",Debug.moduleToString(b4a.OrderTakerTest1.addorderactivity.class),"bttnAddOrder",ordertakerdashboard.mostCurrent._bttnaddorder,"bttnFetchProducts",ordertakerdashboard.mostCurrent._bttnfetchproducts,"clvContentOrders",ordertakerdashboard.mostCurrent._clvcontentorders,"Controls",Debug.moduleToString(b4a.OrderTakerTest1.controls.class),"etContentSearchOrder",ordertakerdashboard.mostCurrent._etcontentsearchorder,"forgotPass",Debug.moduleToString(b4a.OrderTakerTest1.forgotpass.class),"HttpUtils2Service",Debug.moduleToString(b4a.OrderTakerTest1.httputils2service.class),"lblCacheInfo",ordertakerdashboard.mostCurrent._lblcacheinfo,"lblDash",ordertakerdashboard.mostCurrent._lbldash,"lblDashIcon",ordertakerdashboard.mostCurrent._lbldashicon,"lblFetchStatus",ordertakerdashboard.mostCurrent._lblfetchstatus,"lblHistory",ordertakerdashboard.mostCurrent._lblhistory,"lblHistoryIcon",ordertakerdashboard.mostCurrent._lblhistoryicon,"lblInventory",ordertakerdashboard.mostCurrent._lblinventory,"lblInventoryIcon",ordertakerdashboard.mostCurrent._lblinventoryicon,"lblLoggedInUser",ordertakerdashboard.mostCurrent._lblloggedinuser,"lbllogout",ordertakerdashboard.mostCurrent._lbllogout,"lblOrders",ordertakerdashboard.mostCurrent._lblorders,"lblOrdersIcon",ordertakerdashboard.mostCurrent._lblordersicon,"lblperson",ordertakerdashboard.mostCurrent._lblperson,"Main",Debug.moduleToString(b4a.OrderTakerTest1.main.class),"pnlBottomNav",ordertakerdashboard.mostCurrent._pnlbottomnav,"pnlContent",ordertakerdashboard.mostCurrent._pnlcontent,"pnlContentDash",ordertakerdashboard.mostCurrent._pnlcontentdash,"pnlContentHistory",ordertakerdashboard.mostCurrent._pnlcontenthistory,"pnlContentInventory",ordertakerdashboard.mostCurrent._pnlcontentinventory,"pnlContentOrders",ordertakerdashboard.mostCurrent._pnlcontentorders,"pnlDash",ordertakerdashboard.mostCurrent._pnldash,"pnlDim",ordertakerdashboard.mostCurrent._pnldim,"pnlHistory",ordertakerdashboard.mostCurrent._pnlhistory,"pnlInventory",ordertakerdashboard.mostCurrent._pnlinventory,"pnlOrders",ordertakerdashboard.mostCurrent._pnlorders,"pnlTop",ordertakerdashboard.mostCurrent._pnltop,"Starter",Debug.moduleToString(b4a.OrderTakerTest1.starter.class),"svInventory",ordertakerdashboard.mostCurrent._svinventory,"userOrders",Debug.moduleToString(b4a.OrderTakerTest1.userorders.class),"xui",ordertakerdashboard._xui};
}
}