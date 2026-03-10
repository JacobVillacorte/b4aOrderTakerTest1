package b4a.OrderTakerTest1;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class forgotpass_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (forgotpass) ","forgotpass",2,forgotpass.mostCurrent.activityBA,forgotpass.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.OrderTakerTest1.forgotpass.remoteMe.runUserSub(false, "forgotpass","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"forgotPass\")";
Debug.ShouldStop(524288);
forgotpass.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("forgotPass")),forgotpass.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (forgotpass) ","forgotpass",2,forgotpass.mostCurrent.activityBA,forgotpass.mostCurrent,28);
if (RapidSub.canDelegate("activity_pause")) { return b4a.OrderTakerTest1.forgotpass.remoteMe.runUserSub(false, "forgotpass","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (forgotpass) ","forgotpass",2,forgotpass.mostCurrent.activityBA,forgotpass.mostCurrent,24);
if (RapidSub.canDelegate("activity_resume")) { return b4a.OrderTakerTest1.forgotpass.remoteMe.runUserSub(false, "forgotpass","activity_resume");}
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bttn1_click() throws Exception{
try {
		Debug.PushSubsStack("bttn1_Click (forgotpass) ","forgotpass",2,forgotpass.mostCurrent.activityBA,forgotpass.mostCurrent,33);
if (RapidSub.canDelegate("bttn1_click")) { return b4a.OrderTakerTest1.forgotpass.remoteMe.runUserSub(false, "forgotpass","bttn1_click");}
 BA.debugLineNum = 33;BA.debugLine="Private Sub bttn1_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(2);
forgotpass.mostCurrent.__c.runVoidMethod ("StartActivity",forgotpass.processBA,(Object)((forgotpass.mostCurrent._main.getObject())));
 BA.debugLineNum = 35;BA.debugLine="Controls.SetAnimation(\"slide_down_in\", \"slide_dow";
Debug.ShouldStop(4);
forgotpass.mostCurrent._controls.runVoidMethod ("_setanimation" /*RemoteObject*/ ,forgotpass.mostCurrent.activityBA,(Object)(BA.ObjectToString("slide_down_in")),(Object)(RemoteObject.createImmutable("slide_down_out")));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}