package b4a.OrderTakerTest1.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_ordertakerdashboard{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pnldim").vw.setWidth((int)((100d / 100 * width)));
views.get("pnldim").vw.setHeight((int)((100d / 100 * height)));
views.get("pnldim").vw.setLeft((int)((0d * scale)));
views.get("pnldim").vw.setTop((int)((0d * scale)));
views.get("pnltop").vw.setTop((int)(0d));
views.get("pnltop").vw.setLeft((int)(0d));
views.get("pnltop").vw.setWidth((int)((100d / 100 * width)));
views.get("pnltop").vw.setHeight((int)((70d * scale)));
views.get("pnlcontent").vw.setLeft((int)(0d));
views.get("pnlcontent").vw.setTop((int)((views.get("pnltop").vw.getTop() + views.get("pnltop").vw.getHeight())));
views.get("pnlcontent").vw.setWidth((int)((100d / 100 * width)));
views.get("pnlcontent").vw.setHeight((int)((100d / 100 * height)-(130d * scale)));
views.get("pnlcontentdash").vw.setLeft((int)(0d));
views.get("pnlcontentdash").vw.setTop((int)(0d));
views.get("pnlcontentdash").vw.setWidth((int)((100d / 100 * width)));
views.get("pnlcontentdash").vw.setHeight((int)((100d / 100 * height)-(130d * scale)));
views.get("pnlcontentorders").vw.setLeft((int)(0d));
views.get("pnlcontentorders").vw.setTop((int)(0d));
views.get("pnlcontentorders").vw.setWidth((int)((100d / 100 * width)));
views.get("pnlcontentorders").vw.setHeight((int)((100d / 100 * height)-(130d * scale)));
views.get("bttnaddorder").vw.setLeft((int)((80d / 100 * width)));
views.get("bttnaddorder").vw.setTop((int)((10d * scale)));
views.get("bttnaddorder").vw.setWidth((int)((60d * scale)));
views.get("bttnaddorder").vw.setHeight((int)((50d * scale)));
views.get("etcontentsearchorder").vw.setLeft((int)((10d * scale)));
views.get("etcontentsearchorder").vw.setTop((int)((10d * scale)));
views.get("etcontentsearchorder").vw.setWidth((int)((views.get("pnlcontentorders").vw.getWidth())-(80d * scale)));
views.get("etcontentsearchorder").vw.setHeight((int)((50d * scale)));
views.get("clvcontentorders").vw.setLeft((int)(0d));
views.get("clvcontentorders").vw.setTop((int)((views.get("etcontentsearchorder").vw.getTop() + views.get("etcontentsearchorder").vw.getHeight())+(10d * scale)));
views.get("clvcontentorders").vw.setWidth((int)((views.get("pnlcontentorders").vw.getWidth())));
views.get("clvcontentorders").vw.setHeight((int)((views.get("pnlcontentorders").vw.getHeight())-(views.get("clvcontentorders").vw.getTop())));
views.get("pnlcontentinventory").vw.setLeft((int)(0d));
views.get("pnlcontentinventory").vw.setTop((int)(0d));
views.get("pnlcontentinventory").vw.setWidth((int)((100d / 100 * width)));
views.get("pnlcontentinventory").vw.setHeight((int)((100d / 100 * height)-(130d * scale)));
views.get("pnlcontenthistory").vw.setLeft((int)(0d));
views.get("pnlcontenthistory").vw.setTop((int)(0d));
views.get("pnlcontenthistory").vw.setWidth((int)((100d / 100 * width)));
views.get("pnlcontenthistory").vw.setHeight((int)((100d / 100 * height)-(130d * scale)));
views.get("lblperson").vw.setLeft((int)((10d * scale)));
views.get("lblperson").vw.setWidth((int)((30d * scale)));
views.get("lblperson").vw.setHeight((int)((30d * scale)));
views.get("lblperson").vw.setTop((int)(((views.get("pnltop").vw.getHeight())-(views.get("lblperson").vw.getHeight()))/2d));
views.get("lblloggedinuser").vw.setLeft((int)((views.get("lblperson").vw.getLeft() + views.get("lblperson").vw.getWidth())+(8d * scale)));
views.get("lblloggedinuser").vw.setWidth((int)((25d / 100 * width)));
views.get("lblloggedinuser").vw.setTop((int)(((views.get("pnltop").vw.getHeight())-(views.get("lblloggedinuser").vw.getHeight()))/2d));
views.get("lbllogout").vw.setWidth((int)((50d * scale)));
views.get("lbllogout").vw.setTop((int)(((views.get("pnltop").vw.getHeight())-(views.get("lbllogout").vw.getHeight()))/2d));
views.get("lbllogout").vw.setLeft((int)((100d / 100 * width)-(views.get("lbllogout").vw.getWidth())-(10d * scale)));
views.get("pnlbottomnav").vw.setHeight((int)((60d * scale)));
views.get("pnlbottomnav").vw.setLeft((int)(0d));
views.get("pnlbottomnav").vw.setWidth((int)((100d / 100 * width)));
views.get("pnlbottomnav").vw.setTop((int)((100d / 100 * height)-(views.get("pnlbottomnav").vw.getHeight())));
views.get("pnldash").vw.setLeft((int)(0d));
views.get("pnldash").vw.setWidth((int)((views.get("pnlbottomnav").vw.getWidth())/4d));
views.get("pnldash").vw.setHeight((int)((views.get("pnlbottomnav").vw.getHeight())));
views.get("pnldash").vw.setTop((int)(0d));
((anywheresoftware.b4a.keywords.LayoutBuilder.DesignerTextSizeMethod)views.get("lbldashicon").vw).setTextSize((float)(22d));
views.get("lbldashicon").vw.setWidth((int)((views.get("pnldash").vw.getWidth())));
views.get("lbldashicon").vw.setLeft((int)(0d));
views.get("lbldashicon").vw.setTop((int)((6d * scale)));
views.get("lbldashicon").vw.setHeight((int)((26d * scale)));
views.get("lbldash").vw.setWidth((int)((views.get("pnldash").vw.getWidth())));
views.get("lbldash").vw.setLeft((int)(0d));
views.get("lbldash").vw.setTop((int)((views.get("lbldashicon").vw.getTop() + views.get("lbldashicon").vw.getHeight())+(2d * scale)));
views.get("lbldash").vw.setHeight((int)((20d * scale)));
views.get("pnlorders").vw.setLeft((int)((views.get("pnlbottomnav").vw.getWidth())/4d));
views.get("pnlorders").vw.setWidth((int)((views.get("pnlbottomnav").vw.getWidth())/4d));
views.get("pnlorders").vw.setHeight((int)((views.get("pnlbottomnav").vw.getHeight())));
views.get("pnlorders").vw.setTop((int)(0d));
((anywheresoftware.b4a.keywords.LayoutBuilder.DesignerTextSizeMethod)views.get("lblordersicon").vw).setTextSize((float)(22d));
views.get("lblordersicon").vw.setWidth((int)((views.get("pnlorders").vw.getWidth())));
views.get("lblordersicon").vw.setLeft((int)(0d));
views.get("lblordersicon").vw.setTop((int)((6d * scale)));
views.get("lblordersicon").vw.setHeight((int)((26d * scale)));
views.get("lblorders").vw.setWidth((int)((views.get("pnlorders").vw.getWidth())));
views.get("lblorders").vw.setLeft((int)(0d));
views.get("lblorders").vw.setTop((int)((views.get("lblordersicon").vw.getTop() + views.get("lblordersicon").vw.getHeight())+(2d * scale)));
views.get("lblorders").vw.setHeight((int)((20d * scale)));
views.get("pnlinventory").vw.setLeft((int)((views.get("pnlbottomnav").vw.getWidth())/2d));
views.get("pnlinventory").vw.setWidth((int)((views.get("pnlbottomnav").vw.getWidth())/4d));
views.get("pnlinventory").vw.setHeight((int)((views.get("pnlbottomnav").vw.getHeight())));
views.get("pnlinventory").vw.setTop((int)(0d));
((anywheresoftware.b4a.keywords.LayoutBuilder.DesignerTextSizeMethod)views.get("lblinventoryicon").vw).setTextSize((float)(22d));
views.get("lblinventoryicon").vw.setWidth((int)((views.get("pnlinventory").vw.getWidth())));
views.get("lblinventoryicon").vw.setLeft((int)(0d));
views.get("lblinventoryicon").vw.setTop((int)((6d * scale)));
views.get("lblinventoryicon").vw.setHeight((int)((26d * scale)));
views.get("lblinventory").vw.setWidth((int)((views.get("pnlinventory").vw.getWidth())));
views.get("lblinventory").vw.setLeft((int)(0d));
views.get("lblinventory").vw.setTop((int)((views.get("lblinventoryicon").vw.getTop() + views.get("lblinventoryicon").vw.getHeight())+(2d * scale)));
views.get("lblinventory").vw.setHeight((int)((20d * scale)));
views.get("pnlhistory").vw.setLeft((int)((views.get("pnlbottomnav").vw.getWidth())*3d/4d));
views.get("pnlhistory").vw.setWidth((int)((views.get("pnlbottomnav").vw.getWidth())/4d));
views.get("pnlhistory").vw.setHeight((int)((views.get("pnlbottomnav").vw.getHeight())));
views.get("pnlhistory").vw.setTop((int)(0d));
((anywheresoftware.b4a.keywords.LayoutBuilder.DesignerTextSizeMethod)views.get("lblhistoryicon").vw).setTextSize((float)(22d));
views.get("lblhistoryicon").vw.setWidth((int)((views.get("pnlhistory").vw.getWidth())));
views.get("lblhistoryicon").vw.setLeft((int)(0d));
views.get("lblhistoryicon").vw.setTop((int)((6d * scale)));
views.get("lblhistoryicon").vw.setHeight((int)((26d * scale)));
views.get("lblhistory").vw.setWidth((int)((views.get("pnlhistory").vw.getWidth())));
views.get("lblhistory").vw.setLeft((int)(0d));
views.get("lblhistory").vw.setTop((int)((views.get("lblhistoryicon").vw.getTop() + views.get("lblhistoryicon").vw.getHeight())+(2d * scale)));
views.get("lblhistory").vw.setHeight((int)((20d * scale)));
views.get("bttnfetchproducts").vw.setLeft((int)(0d));
views.get("lblcacheinfo").vw.setLeft((int)(0d));
views.get("lblfetchstatus").vw.setLeft((int)(0d));
views.get("lblcacheinfo").vw.setTop((int)(0d));
views.get("lblfetchstatus").vw.setTop((int)((140d * scale)));
views.get("lblfetchstatus").vw.setTop((int)((170d * scale)));
//BA.debugLineNum = 158;BA.debugLine="svInventory.Left=0"[OrderTakerDashboard/General script]
views.get("svinventory").vw.setLeft((int)(0d));
//BA.debugLineNum = 159;BA.debugLine="svInventory.Top=0"[OrderTakerDashboard/General script]
views.get("svinventory").vw.setTop((int)(0d));
//BA.debugLineNum = 160;BA.debugLine="svInventory.Width=100%x"[OrderTakerDashboard/General script]
views.get("svinventory").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 161;BA.debugLine="svInventory.Height=100%y"[OrderTakerDashboard/General script]
views.get("svinventory").vw.setHeight((int)((100d / 100 * height)));

}
}