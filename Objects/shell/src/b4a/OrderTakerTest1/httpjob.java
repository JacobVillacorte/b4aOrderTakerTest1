
package b4a.OrderTakerTest1;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class httpjob {
    public static RemoteObject myClass;
	public httpjob() {
	}
    public static PCBA staticBA = new PCBA(null, httpjob.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _jobname = RemoteObject.createImmutable("");
public static RemoteObject _success = RemoteObject.createImmutable(false);
public static RemoteObject _username = RemoteObject.createImmutable("");
public static RemoteObject _password = RemoteObject.createImmutable("");
public static RemoteObject _errormessage = RemoteObject.createImmutable("");
public static RemoteObject _target = RemoteObject.declareNull("Object");
public static RemoteObject _taskid = RemoteObject.createImmutable("");
public static RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest");
public static RemoteObject _response = RemoteObject.declareNull("anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse");
public static RemoteObject _tag = RemoteObject.declareNull("Object");
public static RemoteObject _invalidurl = RemoteObject.createImmutable("");
public static RemoteObject _defaultscheme = RemoteObject.createImmutable("");
public static b4a.OrderTakerTest1.main _main = null;
public static b4a.OrderTakerTest1.controls _controls = null;
public static b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public static b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public static b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public static b4a.OrderTakerTest1.starter _starter = null;
public static b4a.OrderTakerTest1.userorders _userorders = null;
public static b4a.OrderTakerTest1.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"DefaultScheme",_ref.getField(false, "_defaultscheme"),"ErrorMessage",_ref.getField(false, "_errormessage"),"InvalidURL",_ref.getField(false, "_invalidurl"),"JobName",_ref.getField(false, "_jobname"),"Password",_ref.getField(false, "_password"),"req",_ref.getField(false, "_req"),"Response",_ref.getField(false, "_response"),"Success",_ref.getField(false, "_success"),"Tag",_ref.getField(false, "_tag"),"target",_ref.getField(false, "_target"),"taskId",_ref.getField(false, "_taskid"),"Username",_ref.getField(false, "_username")};
}
}