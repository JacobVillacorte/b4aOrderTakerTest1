package b4a.OrderTakerTest1.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_addorderactivity{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[addOrderActivity/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 7;BA.debugLine="pnlDim.Left = 0"[addOrderActivity/General script]
views.get("pnldim").vw.setLeft((int)(0d));
//BA.debugLineNum = 8;BA.debugLine="pnlDim.Top = 0"[addOrderActivity/General script]
views.get("pnldim").vw.setTop((int)(0d));
//BA.debugLineNum = 9;BA.debugLine="pnlDim.Width = 100%x"[addOrderActivity/General script]
views.get("pnldim").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 10;BA.debugLine="pnlDim.Height = 100%y"[addOrderActivity/General script]
views.get("pnldim").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 16;BA.debugLine="pnladdOrderActivityWhole.Left = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setLeft((int)(0d));
//BA.debugLineNum = 17;BA.debugLine="pnladdOrderActivityWhole.Top = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setTop((int)(0d));
//BA.debugLineNum = 18;BA.debugLine="pnladdOrderActivityWhole.Width = 100%x"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 19;BA.debugLine="pnladdOrderActivityWhole.Height = 100%y"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 25;BA.debugLine="pnladdOrderActivityTop.Left = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setLeft((int)(0d));
//BA.debugLineNum = 26;BA.debugLine="pnladdOrderActivityTop.Top = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setTop((int)(0d));
//BA.debugLineNum = 27;BA.debugLine="pnladdOrderActivityTop.Width = 100%x"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 28;BA.debugLine="pnladdOrderActivityTop.Height = 80dip"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setHeight((int)((80d * scale)));
//BA.debugLineNum = 30;BA.debugLine="bttnAddOrderActivity.Left = 20dip"[addOrderActivity/General script]
views.get("bttnaddorderactivity").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 31;BA.debugLine="bttnAddOrderActivity.Top = 15dip"[addOrderActivity/General script]
views.get("bttnaddorderactivity").vw.setTop((int)((15d * scale)));
//BA.debugLineNum = 32;BA.debugLine="bttnAddOrderActivity.Width = 60%x"[addOrderActivity/General script]
views.get("bttnaddorderactivity").vw.setWidth((int)((60d / 100 * width)));
//BA.debugLineNum = 33;BA.debugLine="bttnAddOrderActivity.Height = 55dip"[addOrderActivity/General script]
views.get("bttnaddorderactivity").vw.setHeight((int)((55d * scale)));
//BA.debugLineNum = 35;BA.debugLine="lblExitOrderActivity.Left = 80%x"[addOrderActivity/General script]
views.get("lblexitorderactivity").vw.setLeft((int)((80d / 100 * width)));
//BA.debugLineNum = 36;BA.debugLine="lblExitOrderActivity.Top = 2"[addOrderActivity/General script]
views.get("lblexitorderactivity").vw.setTop((int)(2d));
//BA.debugLineNum = 37;BA.debugLine="lblExitOrderActivity.Width = 25dip"[addOrderActivity/General script]
views.get("lblexitorderactivity").vw.setWidth((int)((25d * scale)));
//BA.debugLineNum = 38;BA.debugLine="lblExitOrderActivity.Height = 40dip"[addOrderActivity/General script]
views.get("lblexitorderactivity").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 45;BA.debugLine="bttnPurchaseNow.Left = 20dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 46;BA.debugLine="bttnPurchaseNow.Width = 100%x - 40dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
//BA.debugLineNum = 47;BA.debugLine="bttnPurchaseNow.Height = 60dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 48;BA.debugLine="bttnPurchaseNow.Top = 100%y - bttnPurchaseNow.Height - 10dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setTop((int)((100d / 100 * height)-(views.get("bttnpurchasenow").vw.getHeight())-(10d * scale)));
//BA.debugLineNum = 55;BA.debugLine="svCartSummary.Top = lblTotalItems.Bottom + 5dip"[addOrderActivity/General script]
views.get("svcartsummary").vw.setTop((int)((views.get("lbltotalitems").vw.getTop() + views.get("lbltotalitems").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 56;BA.debugLine="svCartSummary.Left = 0"[addOrderActivity/General script]
views.get("svcartsummary").vw.setLeft((int)(0d));
//BA.debugLineNum = 57;BA.debugLine="svCartSummary.Width = 100%x"[addOrderActivity/General script]
views.get("svcartsummary").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 58;BA.debugLine="svCartSummary.Height = pnladdOrderActivityWhole.Height - svCartSummary.Top - 73dip ' 70dip reserved for Purchase button"[addOrderActivity/General script]
views.get("svcartsummary").vw.setHeight((int)((views.get("pnladdorderactivitywhole").vw.getHeight())-(views.get("svcartsummary").vw.getTop())-(73d * scale)));
//BA.debugLineNum = 60;BA.debugLine="lblTotalItems.Left = 10dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 61;BA.debugLine="lblTotalItems.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 62;BA.debugLine="lblTotalItems.Width = 50%x"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setWidth((int)((50d / 100 * width)));
//BA.debugLineNum = 63;BA.debugLine="lblTotalItems.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 65;BA.debugLine="lblTotalAmount.Left = 60%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setLeft((int)((60d / 100 * width)));
//BA.debugLineNum = 66;BA.debugLine="lblTotalAmount.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 67;BA.debugLine="lblTotalAmount.Width = 40%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setWidth((int)((40d / 100 * width)));
//BA.debugLineNum = 68;BA.debugLine="lblTotalAmount.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 74;BA.debugLine="pnlSelectItems.Width = 100%x - 20dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setWidth((int)((100d / 100 * width)-(20d * scale)));
//BA.debugLineNum = 75;BA.debugLine="pnlSelectItems.Height = 85%y"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setHeight((int)((85d / 100 * height)));
//BA.debugLineNum = 76;BA.debugLine="pnlSelectItems.Left = 10dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 77;BA.debugLine="pnlSelectItems.Top = 30dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setTop((int)((30d * scale)));
//BA.debugLineNum = 87;BA.debugLine="lblExitSelectItems.Width = 20dip"[addOrderActivity/General script]
views.get("lblexitselectitems").vw.setWidth((int)((20d * scale)));
//BA.debugLineNum = 88;BA.debugLine="lblExitSelectItems.Height = 45dip"[addOrderActivity/General script]
views.get("lblexitselectitems").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 89;BA.debugLine="lblExitSelectItems.Top = 10dip"[addOrderActivity/General script]
views.get("lblexitselectitems").vw.setTop((int)((10d * scale)));
//BA.debugLineNum = 90;BA.debugLine="lblExitSelectItems.Left = 75%x"[addOrderActivity/General script]
views.get("lblexitselectitems").vw.setLeft((int)((75d / 100 * width)));
//BA.debugLineNum = 92;BA.debugLine="etSearchProducts.Left = 10dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 93;BA.debugLine="etSearchProducts.Top = 10dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setTop((int)((10d * scale)));
//BA.debugLineNum = 94;BA.debugLine="etSearchProducts.Height = 45dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 95;BA.debugLine="etSearchProducts.Width = 70%x"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setWidth((int)((70d / 100 * width)));
//BA.debugLineNum = 101;BA.debugLine="clvProducts.Left = 5dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setLeft((int)((5d * scale)));
//BA.debugLineNum = 102;BA.debugLine="clvProducts.Top = etSearchProducts.Bottom + 10dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setTop((int)((views.get("etsearchproducts").vw.getTop() + views.get("etsearchproducts").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 103;BA.debugLine="clvProducts.Width = pnlSelectItems.Width - 20dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setWidth((int)((views.get("pnlselectitems").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 104;BA.debugLine="clvProducts.Height = pnlSelectItems.Height - clvProducts.Top - 15dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setHeight((int)((views.get("pnlselectitems").vw.getHeight())-(views.get("clvproducts").vw.getTop())-(15d * scale)));
//BA.debugLineNum = 109;BA.debugLine="AutoScaleAll"[addOrderActivity/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 114;BA.debugLine="pnlDim.Left = 0"[addOrderActivity/General script]
views.get("pnldim").vw.setLeft((int)(0d));
//BA.debugLineNum = 115;BA.debugLine="pnlDim.Top = 0"[addOrderActivity/General script]
views.get("pnldim").vw.setTop((int)(0d));
//BA.debugLineNum = 116;BA.debugLine="pnlDim.Width = 100%x"[addOrderActivity/General script]
views.get("pnldim").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 117;BA.debugLine="pnlDim.Height = 100%y"[addOrderActivity/General script]
views.get("pnldim").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 123;BA.debugLine="pnladdOrderActivityWhole.Left = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setLeft((int)(0d));
//BA.debugLineNum = 124;BA.debugLine="pnladdOrderActivityWhole.Top = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setTop((int)(0d));
//BA.debugLineNum = 125;BA.debugLine="pnladdOrderActivityWhole.Width = 100%x"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 126;BA.debugLine="pnladdOrderActivityWhole.Height = 100%y"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 132;BA.debugLine="pnladdOrderActivityTop.Left = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setLeft((int)(0d));
//BA.debugLineNum = 133;BA.debugLine="pnladdOrderActivityTop.Top = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setTop((int)(0d));
//BA.debugLineNum = 134;BA.debugLine="pnladdOrderActivityTop.Width = 100%x"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 135;BA.debugLine="pnladdOrderActivityTop.Height = 80dip"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setHeight((int)((80d * scale)));
//BA.debugLineNum = 141;BA.debugLine="bttnPurchaseNow.Left = 20dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 142;BA.debugLine="bttnPurchaseNow.Width = 100%x - 40dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
//BA.debugLineNum = 143;BA.debugLine="bttnPurchaseNow.Height = 60dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 144;BA.debugLine="bttnPurchaseNow.Top = 100%y - bttnPurchaseNow.Height - 10dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setTop((int)((100d / 100 * height)-(views.get("bttnpurchasenow").vw.getHeight())-(10d * scale)));
//BA.debugLineNum = 151;BA.debugLine="svCartSummary.Top = lblTotalItems.Bottom + 5dip"[addOrderActivity/General script]
views.get("svcartsummary").vw.setTop((int)((views.get("lbltotalitems").vw.getTop() + views.get("lbltotalitems").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 152;BA.debugLine="svCartSummary.Left = 0"[addOrderActivity/General script]
views.get("svcartsummary").vw.setLeft((int)(0d));
//BA.debugLineNum = 153;BA.debugLine="svCartSummary.Width = 100%x"[addOrderActivity/General script]
views.get("svcartsummary").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 154;BA.debugLine="svCartSummary.Height = pnladdOrderActivityWhole.Height - svCartSummary.Top - 73dip ' 70dip reserved for Purchase button"[addOrderActivity/General script]
views.get("svcartsummary").vw.setHeight((int)((views.get("pnladdorderactivitywhole").vw.getHeight())-(views.get("svcartsummary").vw.getTop())-(73d * scale)));
//BA.debugLineNum = 156;BA.debugLine="lblTotalItems.Left = 10dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 157;BA.debugLine="lblTotalItems.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 158;BA.debugLine="lblTotalItems.Width = 50%x"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setWidth((int)((50d / 100 * width)));
//BA.debugLineNum = 159;BA.debugLine="lblTotalItems.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 161;BA.debugLine="lblTotalAmount.Left = 60%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setLeft((int)((60d / 100 * width)));
//BA.debugLineNum = 162;BA.debugLine="lblTotalAmount.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 163;BA.debugLine="lblTotalAmount.Width = 40%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setWidth((int)((40d / 100 * width)));
//BA.debugLineNum = 164;BA.debugLine="lblTotalAmount.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 170;BA.debugLine="pnlSelectItems.Width = 100%x - 20dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setWidth((int)((100d / 100 * width)-(20d * scale)));
//BA.debugLineNum = 171;BA.debugLine="pnlSelectItems.Height = 85%y"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setHeight((int)((85d / 100 * height)));
//BA.debugLineNum = 172;BA.debugLine="pnlSelectItems.Left = 10dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 173;BA.debugLine="pnlSelectItems.Top = 30dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setTop((int)((30d * scale)));
//BA.debugLineNum = 179;BA.debugLine="pnlQuantity.Width = 280dip"[addOrderActivity/General script]
views.get("pnlquantity").vw.setWidth((int)((280d * scale)));
//BA.debugLineNum = 180;BA.debugLine="pnlQuantity.Height = 270dip"[addOrderActivity/General script]
views.get("pnlquantity").vw.setHeight((int)((270d * scale)));
//BA.debugLineNum = 181;BA.debugLine="pnlQuantity.Left = (100%x - pnlQuantity.Width) / 2"[addOrderActivity/General script]
views.get("pnlquantity").vw.setLeft((int)(((100d / 100 * width)-(views.get("pnlquantity").vw.getWidth()))/2d));
//BA.debugLineNum = 182;BA.debugLine="pnlQuantity.Top = (100%y - pnlQuantity.Height) / 2"[addOrderActivity/General script]
views.get("pnlquantity").vw.setTop((int)(((100d / 100 * height)-(views.get("pnlquantity").vw.getHeight()))/2d));
//BA.debugLineNum = 184;BA.debugLine="lblQuantityTitle.Left = 0"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setLeft((int)(0d));
//BA.debugLineNum = 185;BA.debugLine="lblQuantityTitle.Top = 10dip"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setTop((int)((10d * scale)));
//BA.debugLineNum = 186;BA.debugLine="lblQuantityTitle.Width = pnlQuantity.Width"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())));
//BA.debugLineNum = 187;BA.debugLine="lblQuantityTitle.Height = 30dip"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 189;BA.debugLine="lblSelectedItem.Left = 10dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 190;BA.debugLine="lblSelectedItem.Top = lblQuantityTitle.Bottom + 5dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setTop((int)((views.get("lblquantitytitle").vw.getTop() + views.get("lblquantitytitle").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 191;BA.debugLine="lblSelectedItem.Width = pnlQuantity.Width - 20dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 192;BA.debugLine="lblSelectedItem.Height = 45dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 195;BA.debugLine="bttnMinus.Width = 55dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setWidth((int)((55d * scale)));
//BA.debugLineNum = 196;BA.debugLine="bttnMinus.Height = 55dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setHeight((int)((55d * scale)));
//BA.debugLineNum = 197;BA.debugLine="bttnMinus.Left = 30dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setLeft((int)((30d * scale)));
//BA.debugLineNum = 198;BA.debugLine="bttnMinus.Top = lblSelectedItem.Bottom + 15dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setTop((int)((views.get("lblselecteditem").vw.getTop() + views.get("lblselecteditem").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 201;BA.debugLine="etQuantityValue.Width = 90dip"[addOrderActivity/General script]
views.get("etquantityvalue").vw.setWidth((int)((90d * scale)));
//BA.debugLineNum = 202;BA.debugLine="etQuantityValue.Height = 55dip"[addOrderActivity/General script]
views.get("etquantityvalue").vw.setHeight((int)((55d * scale)));
//BA.debugLineNum = 203;BA.debugLine="etQuantityValue.Left = bttnMinus.Right + 10dip"[addOrderActivity/General script]
views.get("etquantityvalue").vw.setLeft((int)((views.get("bttnminus").vw.getLeft() + views.get("bttnminus").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 204;BA.debugLine="etQuantityValue.Top = bttnMinus.Top"[addOrderActivity/General script]
views.get("etquantityvalue").vw.setTop((int)((views.get("bttnminus").vw.getTop())));
//BA.debugLineNum = 207;BA.debugLine="bttnAdd.Width = 55dip"[addOrderActivity/General script]
views.get("bttnadd").vw.setWidth((int)((55d * scale)));
//BA.debugLineNum = 208;BA.debugLine="bttnAdd.Height = 55dip"[addOrderActivity/General script]
views.get("bttnadd").vw.setHeight((int)((55d * scale)));
//BA.debugLineNum = 209;BA.debugLine="bttnAdd.Left = etQuantityValue.Right + 10dip"[addOrderActivity/General script]
views.get("bttnadd").vw.setLeft((int)((views.get("etquantityvalue").vw.getLeft() + views.get("etquantityvalue").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 210;BA.debugLine="bttnAdd.Top = bttnMinus.Top"[addOrderActivity/General script]
views.get("bttnadd").vw.setTop((int)((views.get("bttnminus").vw.getTop())));
//BA.debugLineNum = 213;BA.debugLine="bttnAddToCartQty.Width = pnlQuantity.Width - 40dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())-(40d * scale)));
//BA.debugLineNum = 214;BA.debugLine="bttnAddToCartQty.Height = 45dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 215;BA.debugLine="bttnAddToCartQty.Left = 20dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 216;BA.debugLine="bttnAddToCartQty.Top = bttnMinus.Bottom + 15dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setTop((int)((views.get("bttnminus").vw.getTop() + views.get("bttnminus").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 219;BA.debugLine="bttnCancelQty.Width = pnlQuantity.Width - 40dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())-(40d * scale)));
//BA.debugLineNum = 220;BA.debugLine="bttnCancelQty.Height = 40dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 221;BA.debugLine="bttnCancelQty.Left = 20dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 222;BA.debugLine="bttnCancelQty.Top = bttnAddToCartQty.Bottom + 4dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setTop((int)((views.get("bttnaddtocartqty").vw.getTop() + views.get("bttnaddtocartqty").vw.getHeight())+(4d * scale)));
//BA.debugLineNum = 228;BA.debugLine="pnlPurchaseStatus.Width = 300dip"[addOrderActivity/General script]
views.get("pnlpurchasestatus").vw.setWidth((int)((300d * scale)));
//BA.debugLineNum = 229;BA.debugLine="pnlPurchaseStatus.Height = 240dip"[addOrderActivity/General script]
views.get("pnlpurchasestatus").vw.setHeight((int)((240d * scale)));
//BA.debugLineNum = 230;BA.debugLine="pnlPurchaseStatus.Left = (100%x - pnlPurchaseStatus.Width) / 2"[addOrderActivity/General script]
views.get("pnlpurchasestatus").vw.setLeft((int)(((100d / 100 * width)-(views.get("pnlpurchasestatus").vw.getWidth()))/2d));
//BA.debugLineNum = 231;BA.debugLine="pnlPurchaseStatus.Top = (100%y - pnlPurchaseStatus.Height) / 2"[addOrderActivity/General script]
views.get("pnlpurchasestatus").vw.setTop((int)(((100d / 100 * height)-(views.get("pnlpurchasestatus").vw.getHeight()))/2d));
//BA.debugLineNum = 233;BA.debugLine="lblPurchaseStatusTitle.Left = 10dip"[addOrderActivity/General script]
views.get("lblpurchasestatustitle").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 234;BA.debugLine="lblPurchaseStatusTitle.Top = 10dip"[addOrderActivity/General script]
views.get("lblpurchasestatustitle").vw.setTop((int)((10d * scale)));
//BA.debugLineNum = 235;BA.debugLine="lblPurchaseStatusTitle.Width = pnlPurchaseStatus.Width - 20dip"[addOrderActivity/General script]
views.get("lblpurchasestatustitle").vw.setWidth((int)((views.get("pnlpurchasestatus").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 236;BA.debugLine="lblPurchaseStatusTitle.Height = 30dip"[addOrderActivity/General script]
views.get("lblpurchasestatustitle").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 238;BA.debugLine="lblPurchaseStatusMessage.Left = 10dip"[addOrderActivity/General script]
views.get("lblpurchasestatusmessage").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 239;BA.debugLine="lblPurchaseStatusMessage.Top = lblPurchaseStatusTitle.Bottom + 5dip"[addOrderActivity/General script]
views.get("lblpurchasestatusmessage").vw.setTop((int)((views.get("lblpurchasestatustitle").vw.getTop() + views.get("lblpurchasestatustitle").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 240;BA.debugLine="lblPurchaseStatusMessage.Width = pnlPurchaseStatus.Width - 20dip"[addOrderActivity/General script]
views.get("lblpurchasestatusmessage").vw.setWidth((int)((views.get("pnlpurchasestatus").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 241;BA.debugLine="lblPurchaseStatusMessage.Height = 35dip"[addOrderActivity/General script]
views.get("lblpurchasestatusmessage").vw.setHeight((int)((35d * scale)));
//BA.debugLineNum = 243;BA.debugLine="rbPaidReceived.Left = 20dip"[addOrderActivity/General script]
views.get("rbpaidreceived").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 244;BA.debugLine="rbPaidReceived.Top = lblPurchaseStatusMessage.Bottom + 10dip"[addOrderActivity/General script]
views.get("rbpaidreceived").vw.setTop((int)((views.get("lblpurchasestatusmessage").vw.getTop() + views.get("lblpurchasestatusmessage").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 245;BA.debugLine="rbPaidReceived.Width = pnlPurchaseStatus.Width - 40dip"[addOrderActivity/General script]
views.get("rbpaidreceived").vw.setWidth((int)((views.get("pnlpurchasestatus").vw.getWidth())-(40d * scale)));
//BA.debugLineNum = 246;BA.debugLine="rbPaidReceived.Height = 25dip"[addOrderActivity/General script]
views.get("rbpaidreceived").vw.setHeight((int)((25d * scale)));
//BA.debugLineNum = 248;BA.debugLine="rbPaidBooked.Left = 20dip"[addOrderActivity/General script]
views.get("rbpaidbooked").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 249;BA.debugLine="rbPaidBooked.Top = rbPaidReceived.Bottom + 8dip"[addOrderActivity/General script]
views.get("rbpaidbooked").vw.setTop((int)((views.get("rbpaidreceived").vw.getTop() + views.get("rbpaidreceived").vw.getHeight())+(8d * scale)));
//BA.debugLineNum = 250;BA.debugLine="rbPaidBooked.Width = pnlPurchaseStatus.Width - 40dip"[addOrderActivity/General script]
views.get("rbpaidbooked").vw.setWidth((int)((views.get("pnlpurchasestatus").vw.getWidth())-(40d * scale)));
//BA.debugLineNum = 251;BA.debugLine="rbPaidBooked.Height = 25dip"[addOrderActivity/General script]
views.get("rbpaidbooked").vw.setHeight((int)((25d * scale)));
//BA.debugLineNum = 253;BA.debugLine="rbNotPaidBooked.Left = 20dip"[addOrderActivity/General script]
views.get("rbnotpaidbooked").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 254;BA.debugLine="rbNotPaidBooked.Top = rbPaidBooked.Bottom + 8dip"[addOrderActivity/General script]
views.get("rbnotpaidbooked").vw.setTop((int)((views.get("rbpaidbooked").vw.getTop() + views.get("rbpaidbooked").vw.getHeight())+(8d * scale)));
//BA.debugLineNum = 255;BA.debugLine="rbNotPaidBooked.Width = pnlPurchaseStatus.Width - 40dip"[addOrderActivity/General script]
views.get("rbnotpaidbooked").vw.setWidth((int)((views.get("pnlpurchasestatus").vw.getWidth())-(40d * scale)));
//BA.debugLineNum = 256;BA.debugLine="rbNotPaidBooked.Height = 25dip"[addOrderActivity/General script]
views.get("rbnotpaidbooked").vw.setHeight((int)((25d * scale)));
//BA.debugLineNum = 258;BA.debugLine="bttnConfirmPurchaseStatus.Left = 20dip"[addOrderActivity/General script]
views.get("bttnconfirmpurchasestatus").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 259;BA.debugLine="bttnConfirmPurchaseStatus.Top = rbNotPaidBooked.Bottom + 15dip"[addOrderActivity/General script]
views.get("bttnconfirmpurchasestatus").vw.setTop((int)((views.get("rbnotpaidbooked").vw.getTop() + views.get("rbnotpaidbooked").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 260;BA.debugLine="bttnConfirmPurchaseStatus.Width = (pnlPurchaseStatus.Width - 50dip) / 2"[addOrderActivity/General script]
views.get("bttnconfirmpurchasestatus").vw.setWidth((int)(((views.get("pnlpurchasestatus").vw.getWidth())-(50d * scale))/2d));
//BA.debugLineNum = 261;BA.debugLine="bttnConfirmPurchaseStatus.Height = 40dip"[addOrderActivity/General script]
views.get("bttnconfirmpurchasestatus").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 265;BA.debugLine="bttnCancelPurchaseStatus.Left = bttnConfirmPurchaseStatus.Right + 10dip"[addOrderActivity/General script]
views.get("bttncancelpurchasestatus").vw.setLeft((int)((views.get("bttnconfirmpurchasestatus").vw.getLeft() + views.get("bttnconfirmpurchasestatus").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 266;BA.debugLine="bttnCancelPurchaseStatus.Top = bttnConfirmPurchaseStatus.Top"[addOrderActivity/General script]
views.get("bttncancelpurchasestatus").vw.setTop((int)((views.get("bttnconfirmpurchasestatus").vw.getTop())));
//BA.debugLineNum = 267;BA.debugLine="bttnCancelPurchaseStatus.Width = bttnConfirmPurchaseStatus.Width"[addOrderActivity/General script]
views.get("bttncancelpurchasestatus").vw.setWidth((int)((views.get("bttnconfirmpurchasestatus").vw.getWidth())));
//BA.debugLineNum = 268;BA.debugLine="bttnCancelPurchaseStatus.Height = 40dip"[addOrderActivity/General script]
views.get("bttncancelpurchasestatus").vw.setHeight((int)((40d * scale)));

}
}