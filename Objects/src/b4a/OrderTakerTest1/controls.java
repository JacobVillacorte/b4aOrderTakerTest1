package b4a.OrderTakerTest1;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class controls {
private static controls mostCurrent = new controls();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.OrderTakerTest1.main _main = null;
public b4a.OrderTakerTest1.forgotpass _forgotpass = null;
public b4a.OrderTakerTest1.ordertakerdashboard _ordertakerdashboard = null;
public b4a.OrderTakerTest1.addorderactivity _addorderactivity = null;
public b4a.OrderTakerTest1.starter _starter = null;
public b4a.OrderTakerTest1.userorders _userorders = null;
public b4a.OrderTakerTest1.httputils2service _httputils2service = null;
public static String  _setanimation(anywheresoftware.b4a.BA _ba,String _inanimation,String _outanimation) throws Exception{
RDebugUtils.currentModule="controls";
if (Debug.shouldDelegate(null, "setanimation", false))
	 {return ((String) Debug.delegate(null, "setanimation", new Object[] {_ba,_inanimation,_outanimation}));}
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
String _package = "";
int _in = 0;
int _out = 0;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Public Sub SetAnimation(InAnimation As String, Out";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Dim package As String";
_package = "";
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Dim in, out As Int";
_in = 0;
_out = 0;
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="package = r.GetStaticField(\"anywheresoftware.b4a.";
_package = BA.ObjectToString(_r.GetStaticField("anywheresoftware.b4a.BA","packageName"));
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="in = r.GetStaticField(package & \".R$anim\", InAnim";
_in = (int)(BA.ObjectToNumber(_r.GetStaticField(_package+".R$anim",_inanimation)));
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="out = r.GetStaticField(package & \".R$anim\", OutAn";
_out = (int)(BA.ObjectToNumber(_r.GetStaticField(_package+".R$anim",_outanimation)));
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="r.Target = r.GetActivity";
_r.Target = (Object)(_r.GetActivity((_ba.processBA == null ? _ba : _ba.processBA)));
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="r.RunMethod4(\"overridePendingTransition\", Array A";
_r.RunMethod4("overridePendingTransition",new Object[]{(Object)(_in),(Object)(_out)},new String[]{"java.lang.int","java.lang.int"});
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="End Sub";
return "";
}
}