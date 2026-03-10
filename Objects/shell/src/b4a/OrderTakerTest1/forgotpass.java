
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

public class forgotpass implements IRemote{
	public static forgotpass mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public forgotpass() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("forgotpass"), "b4a.OrderTakerTest1.forgotpass");
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
		pcBA = new PCBA(this, forgotpass.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static b4a.OrderTakerTest1.main _main = null;
public static b4a.OrderTakerTest1.controls _controls = null;
public static b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public static b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.userorders _userorders = null;
public static b4a.OrderTakerTest1.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",forgotpass.mostCurrent._activity,"addOrderActivity",Debug.moduleToString(b4a.OrderTakerTest1.addorderactivity.class),"Controls",Debug.moduleToString(b4a.OrderTakerTest1.controls.class),"HttpUtils2Service",Debug.moduleToString(b4a.OrderTakerTest1.httputils2service.class),"Main",Debug.moduleToString(b4a.OrderTakerTest1.main.class),"OrderTakerDashboard",Debug.moduleToString(b4a.OrderTakerTest1.ordertakerdashboard.class),"Starter",Debug.moduleToString(b4a.OrderTakerTest1.starter.class),"userOrders",Debug.moduleToString(b4a.OrderTakerTest1.userorders.class)};
}
}