package b4a.OrderTakerTest1.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_main{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("label2").vw.setTop((int)((19d / 100 * height)));
views.get("label1").vw.setTop((int)((20d / 100 * height)));
views.get("lbluser").vw.setTop((int)((44d / 100 * height)));
views.get("lbluser").vw.setLeft((int)((30d * scale)));
views.get("lbluser").vw.setWidth((int)((100d / 100 * width)-(60d * scale)));
views.get("etuser").vw.setTop((int)((47d / 100 * height)));
views.get("etuser").vw.setLeft((int)((30d * scale)));
views.get("etuser").vw.setWidth((int)((100d / 100 * width)-(60d * scale)));
views.get("lblpass").vw.setTop((int)((57d / 100 * height)));
views.get("lblpass").vw.setLeft((int)((30d * scale)));
views.get("lblpass").vw.setWidth((int)((100d / 100 * width)-(60d * scale)));
views.get("etpassword").vw.setTop((int)((60d / 100 * height)));
views.get("etpassword").vw.setLeft((int)((30d * scale)));
views.get("etpassword").vw.setWidth((int)((100d / 100 * width)-(60d * scale)));
views.get("lblforgot").vw.setTop((int)((72d / 100 * height)));
views.get("lblforgot").vw.setLeft((int)((145d * scale)));
views.get("bttnlogin").vw.setLeft((int)((30d * scale)));
views.get("bttnlogin").vw.setTop((int)((80d / 100 * height)));
views.get("bttnlogin").vw.setHeight((int)((60d * scale)));
views.get("bttnlogin").vw.setWidth((int)((100d / 100 * width)-(60d * scale)));

}
}