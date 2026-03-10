
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.OrderTakerTest1.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _sqllogin = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _sqlproducts = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _loggedinuser = RemoteObject.createImmutable("");
public static RemoteObject _api_url = RemoteObject.createImmutable("");
public static RemoteObject _items_last_sync = RemoteObject.createImmutable(0L);
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _bttnlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _etuser = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _etpassword = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbluser = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblpass = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblforgot = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.OrderTakerTest1.controls _controls = null;
public static b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public static b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public static b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.userorders _userorders = null;
public static b4a.OrderTakerTest1.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"addOrderActivity",Debug.moduleToString(b4a.OrderTakerTest1.addorderactivity.class),"API_URL",main._api_url,"bttnLogin",main.mostCurrent._bttnlogin,"Controls",Debug.moduleToString(b4a.OrderTakerTest1.controls.class),"etpassword",main.mostCurrent._etpassword,"etuser",main.mostCurrent._etuser,"forgotPass",Debug.moduleToString(b4a.OrderTakerTest1.forgotpass.class),"HttpUtils2Service",Debug.moduleToString(b4a.OrderTakerTest1.httputils2service.class),"ITEMS_LAST_SYNC",main._items_last_sync,"Label1",main.mostCurrent._label1,"Label2",main.mostCurrent._label2,"lblforgot",main.mostCurrent._lblforgot,"lblpass",main.mostCurrent._lblpass,"lbluser",main.mostCurrent._lbluser,"LoggedInUser",main._loggedinuser,"OrderTakerDashboard",Debug.moduleToString(b4a.OrderTakerTest1.ordertakerdashboard.class),"SQLLogin",main._sqllogin,"SQLProducts",main._sqlproducts,"Starter",Debug.moduleToString(b4a.OrderTakerTest1.starter.class),"userOrders",Debug.moduleToString(b4a.OrderTakerTest1.userorders.class),"xui",main._xui};
}
}