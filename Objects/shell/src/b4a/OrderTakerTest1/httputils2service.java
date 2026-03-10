
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

public class httputils2service implements IRemote{
	public static httputils2service mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public httputils2service() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("httputils2service"), "b4a.OrderTakerTest1.httputils2service");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _receiver;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _receiver = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.OrderTakerTest1.httputils2service");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, httputils2service.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _hc = RemoteObject.declareNull("anywheresoftware.b4h.okhttp.OkHttpClientWrapper");
public static RemoteObject _taskidtojob = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _tempfolder = RemoteObject.createImmutable("");
public static RemoteObject _taskcounter = RemoteObject.createImmutable(0);
public static b4a.OrderTakerTest1.main _main = null;
public static b4a.OrderTakerTest1.controls _controls = null;
public static b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public static b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public static b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.userorders _userorders = null;
  public Object[] GetGlobals() {
		return new Object[] {"addOrderActivity",Debug.moduleToString(b4a.OrderTakerTest1.addorderactivity.class),"Controls",Debug.moduleToString(b4a.OrderTakerTest1.controls.class),"forgotPass",Debug.moduleToString(b4a.OrderTakerTest1.forgotpass.class),"hc",httputils2service._hc,"Main",Debug.moduleToString(b4a.OrderTakerTest1.main.class),"OrderTakerDashboard",Debug.moduleToString(b4a.OrderTakerTest1.ordertakerdashboard.class),"Receiver",httputils2service.mostCurrent._receiver,"Starter",Debug.moduleToString(b4a.OrderTakerTest1.starter.class),"taskCounter",httputils2service._taskcounter,"TaskIdToJob",httputils2service._taskidtojob,"TempFolder",httputils2service._tempfolder,"userOrders",Debug.moduleToString(b4a.OrderTakerTest1.userorders.class)};
}
}