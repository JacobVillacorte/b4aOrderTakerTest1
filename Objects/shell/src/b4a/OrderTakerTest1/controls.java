
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

public class controls implements IRemote{
	public static controls mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public controls() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, controls.class);
    static {
		mostCurrent = new controls();
        remoteMe = RemoteObject.declareNull("b4a.OrderTakerTest1.controls");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("controls"), "b4a.OrderTakerTest1.controls");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.OrderTakerTest1.controls"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static b4a.OrderTakerTest1.main _main = null;
public static b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public static b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public static b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.userorders _userorders = null;
public static b4a.OrderTakerTest1.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"addOrderActivity",Debug.moduleToString(b4a.OrderTakerTest1.addorderactivity.class),"forgotPass",Debug.moduleToString(b4a.OrderTakerTest1.forgotpass.class),"HttpUtils2Service",Debug.moduleToString(b4a.OrderTakerTest1.httputils2service.class),"Main",Debug.moduleToString(b4a.OrderTakerTest1.main.class),"OrderTakerDashboard",Debug.moduleToString(b4a.OrderTakerTest1.ordertakerdashboard.class),"Starter",Debug.moduleToString(b4a.OrderTakerTest1.starter.class),"userOrders",Debug.moduleToString(b4a.OrderTakerTest1.userorders.class)};
}
}