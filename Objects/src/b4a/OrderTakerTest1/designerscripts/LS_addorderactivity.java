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
//BA.debugLineNum = 34;BA.debugLine="bttnPurchaseNow.Left = 20dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 35;BA.debugLine="bttnPurchaseNow.Width = 100%x - 40dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
//BA.debugLineNum = 36;BA.debugLine="bttnPurchaseNow.Height = 60dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 37;BA.debugLine="bttnPurchaseNow.Top = 100%y - bttnPurchaseNow.Height - 10dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setTop((int)((100d / 100 * height)-(views.get("bttnpurchasenow").vw.getHeight())-(10d * scale)));
//BA.debugLineNum = 44;BA.debugLine="svCartSummary.Top = lblTotalItems.Bottom + 5dip"[addOrderActivity/General script]
views.get("svcartsummary").vw.setTop((int)((views.get("lbltotalitems").vw.getTop() + views.get("lbltotalitems").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 45;BA.debugLine="svCartSummary.Left = 0"[addOrderActivity/General script]
views.get("svcartsummary").vw.setLeft((int)(0d));
//BA.debugLineNum = 46;BA.debugLine="svCartSummary.Width = 100%x"[addOrderActivity/General script]
views.get("svcartsummary").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 47;BA.debugLine="svCartSummary.Height = pnladdOrderActivityWhole.Height - svCartSummary.Top - 73dip ' 70dip reserved for Purchase button"[addOrderActivity/General script]
views.get("svcartsummary").vw.setHeight((int)((views.get("pnladdorderactivitywhole").vw.getHeight())-(views.get("svcartsummary").vw.getTop())-(73d * scale)));
//BA.debugLineNum = 49;BA.debugLine="lblTotalItems.Left = 10dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 50;BA.debugLine="lblTotalItems.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 51;BA.debugLine="lblTotalItems.Width = 50%x"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setWidth((int)((50d / 100 * width)));
//BA.debugLineNum = 52;BA.debugLine="lblTotalItems.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 54;BA.debugLine="lblTotalAmount.Left = 60%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setLeft((int)((60d / 100 * width)));
//BA.debugLineNum = 55;BA.debugLine="lblTotalAmount.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 56;BA.debugLine="lblTotalAmount.Width = 40%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setWidth((int)((40d / 100 * width)));
//BA.debugLineNum = 57;BA.debugLine="lblTotalAmount.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 63;BA.debugLine="pnlSelectItems.Width = 100%x - 20dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setWidth((int)((100d / 100 * width)-(20d * scale)));
//BA.debugLineNum = 64;BA.debugLine="pnlSelectItems.Height = 85%y"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setHeight((int)((85d / 100 * height)));
//BA.debugLineNum = 65;BA.debugLine="pnlSelectItems.Left = 10dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 66;BA.debugLine="pnlSelectItems.Top = 30dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setTop((int)((30d * scale)));
//BA.debugLineNum = 72;BA.debugLine="etSearchProducts.Left = 10dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 73;BA.debugLine="etSearchProducts.Top = 10dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setTop((int)((10d * scale)));
//BA.debugLineNum = 74;BA.debugLine="etSearchProducts.Width = pnlSelectItems.Width - 20dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setWidth((int)((views.get("pnlselectitems").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 75;BA.debugLine="etSearchProducts.Height = 45dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 81;BA.debugLine="clvProducts.Left = 10dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 82;BA.debugLine="clvProducts.Top = etSearchProducts.Bottom + 10dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setTop((int)((views.get("etsearchproducts").vw.getTop() + views.get("etsearchproducts").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 83;BA.debugLine="clvProducts.Width = pnlSelectItems.Width - 20dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setWidth((int)((views.get("pnlselectitems").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 84;BA.debugLine="clvProducts.Height = pnlSelectItems.Height - clvProducts.Top - 15dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setHeight((int)((views.get("pnlselectitems").vw.getHeight())-(views.get("clvproducts").vw.getTop())-(15d * scale)));
//BA.debugLineNum = 89;BA.debugLine="AutoScaleAll"[addOrderActivity/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 94;BA.debugLine="pnlDim.Left = 0"[addOrderActivity/General script]
views.get("pnldim").vw.setLeft((int)(0d));
//BA.debugLineNum = 95;BA.debugLine="pnlDim.Top = 0"[addOrderActivity/General script]
views.get("pnldim").vw.setTop((int)(0d));
//BA.debugLineNum = 96;BA.debugLine="pnlDim.Width = 100%x"[addOrderActivity/General script]
views.get("pnldim").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 97;BA.debugLine="pnlDim.Height = 100%y"[addOrderActivity/General script]
views.get("pnldim").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 103;BA.debugLine="pnladdOrderActivityWhole.Left = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setLeft((int)(0d));
//BA.debugLineNum = 104;BA.debugLine="pnladdOrderActivityWhole.Top = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setTop((int)(0d));
//BA.debugLineNum = 105;BA.debugLine="pnladdOrderActivityWhole.Width = 100%x"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 106;BA.debugLine="pnladdOrderActivityWhole.Height = 100%y"[addOrderActivity/General script]
views.get("pnladdorderactivitywhole").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 112;BA.debugLine="pnladdOrderActivityTop.Left = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setLeft((int)(0d));
//BA.debugLineNum = 113;BA.debugLine="pnladdOrderActivityTop.Top = 0"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setTop((int)(0d));
//BA.debugLineNum = 114;BA.debugLine="pnladdOrderActivityTop.Width = 100%x"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 115;BA.debugLine="pnladdOrderActivityTop.Height = 80dip"[addOrderActivity/General script]
views.get("pnladdorderactivitytop").vw.setHeight((int)((80d * scale)));
//BA.debugLineNum = 121;BA.debugLine="bttnPurchaseNow.Left = 20dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 122;BA.debugLine="bttnPurchaseNow.Width = 100%x - 40dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
//BA.debugLineNum = 123;BA.debugLine="bttnPurchaseNow.Height = 60dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 124;BA.debugLine="bttnPurchaseNow.Top = 100%y - bttnPurchaseNow.Height - 10dip"[addOrderActivity/General script]
views.get("bttnpurchasenow").vw.setTop((int)((100d / 100 * height)-(views.get("bttnpurchasenow").vw.getHeight())-(10d * scale)));
//BA.debugLineNum = 131;BA.debugLine="svCartSummary.Top = lblTotalItems.Bottom + 5dip"[addOrderActivity/General script]
views.get("svcartsummary").vw.setTop((int)((views.get("lbltotalitems").vw.getTop() + views.get("lbltotalitems").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 132;BA.debugLine="svCartSummary.Left = 0"[addOrderActivity/General script]
views.get("svcartsummary").vw.setLeft((int)(0d));
//BA.debugLineNum = 133;BA.debugLine="svCartSummary.Width = 100%x"[addOrderActivity/General script]
views.get("svcartsummary").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 134;BA.debugLine="svCartSummary.Height = pnladdOrderActivityWhole.Height - svCartSummary.Top - 73dip ' 70dip reserved for Purchase button"[addOrderActivity/General script]
views.get("svcartsummary").vw.setHeight((int)((views.get("pnladdorderactivitywhole").vw.getHeight())-(views.get("svcartsummary").vw.getTop())-(73d * scale)));
//BA.debugLineNum = 136;BA.debugLine="lblTotalItems.Left = 10dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 137;BA.debugLine="lblTotalItems.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 138;BA.debugLine="lblTotalItems.Width = 50%x"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setWidth((int)((50d / 100 * width)));
//BA.debugLineNum = 139;BA.debugLine="lblTotalItems.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalitems").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 141;BA.debugLine="lblTotalAmount.Left = 60%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setLeft((int)((60d / 100 * width)));
//BA.debugLineNum = 142;BA.debugLine="lblTotalAmount.Top = 80dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setTop((int)((80d * scale)));
//BA.debugLineNum = 143;BA.debugLine="lblTotalAmount.Width = 40%x"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setWidth((int)((40d / 100 * width)));
//BA.debugLineNum = 144;BA.debugLine="lblTotalAmount.Height = 30dip"[addOrderActivity/General script]
views.get("lbltotalamount").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 150;BA.debugLine="pnlSelectItems.Width = 100%x - 20dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setWidth((int)((100d / 100 * width)-(20d * scale)));
//BA.debugLineNum = 151;BA.debugLine="pnlSelectItems.Height = 85%y"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setHeight((int)((85d / 100 * height)));
//BA.debugLineNum = 152;BA.debugLine="pnlSelectItems.Left = 10dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 153;BA.debugLine="pnlSelectItems.Top = 30dip"[addOrderActivity/General script]
views.get("pnlselectitems").vw.setTop((int)((30d * scale)));
//BA.debugLineNum = 159;BA.debugLine="etSearchProducts.Left = 10dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 160;BA.debugLine="etSearchProducts.Top = 10dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setTop((int)((10d * scale)));
//BA.debugLineNum = 161;BA.debugLine="etSearchProducts.Width = pnlSelectItems.Width - 20dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setWidth((int)((views.get("pnlselectitems").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 162;BA.debugLine="etSearchProducts.Height = 45dip"[addOrderActivity/General script]
views.get("etsearchproducts").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 168;BA.debugLine="clvProducts.Left = 10dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 169;BA.debugLine="clvProducts.Top = etSearchProducts.Bottom + 10dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setTop((int)((views.get("etsearchproducts").vw.getTop() + views.get("etsearchproducts").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 170;BA.debugLine="clvProducts.Width = pnlSelectItems.Width - 20dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setWidth((int)((views.get("pnlselectitems").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 171;BA.debugLine="clvProducts.Height = pnlSelectItems.Height - clvProducts.Top - 15dip"[addOrderActivity/General script]
views.get("clvproducts").vw.setHeight((int)((views.get("pnlselectitems").vw.getHeight())-(views.get("clvproducts").vw.getTop())-(15d * scale)));
//BA.debugLineNum = 176;BA.debugLine="pnlQuantity.Width = 280dip"[addOrderActivity/General script]
views.get("pnlquantity").vw.setWidth((int)((280d * scale)));
//BA.debugLineNum = 177;BA.debugLine="pnlQuantity.Height = 270dip"[addOrderActivity/General script]
views.get("pnlquantity").vw.setHeight((int)((270d * scale)));
//BA.debugLineNum = 178;BA.debugLine="pnlQuantity.Left = (100%x - pnlQuantity.Width) / 2"[addOrderActivity/General script]
views.get("pnlquantity").vw.setLeft((int)(((100d / 100 * width)-(views.get("pnlquantity").vw.getWidth()))/2d));
//BA.debugLineNum = 179;BA.debugLine="pnlQuantity.Top = (100%y - pnlQuantity.Height) / 2"[addOrderActivity/General script]
views.get("pnlquantity").vw.setTop((int)(((100d / 100 * height)-(views.get("pnlquantity").vw.getHeight()))/2d));
//BA.debugLineNum = 181;BA.debugLine="lblQuantityTitle.Left = 0"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setLeft((int)(0d));
//BA.debugLineNum = 182;BA.debugLine="lblQuantityTitle.Top = 10dip"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setTop((int)((10d * scale)));
//BA.debugLineNum = 183;BA.debugLine="lblQuantityTitle.Width = pnlQuantity.Width"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())));
//BA.debugLineNum = 184;BA.debugLine="lblQuantityTitle.Height = 30dip"[addOrderActivity/General script]
views.get("lblquantitytitle").vw.setHeight((int)((30d * scale)));
//BA.debugLineNum = 186;BA.debugLine="lblSelectedItem.Left = 10dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setLeft((int)((10d * scale)));
//BA.debugLineNum = 187;BA.debugLine="lblSelectedItem.Top = lblQuantityTitle.Bottom + 5dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setTop((int)((views.get("lblquantitytitle").vw.getTop() + views.get("lblquantitytitle").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 188;BA.debugLine="lblSelectedItem.Width = pnlQuantity.Width - 20dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 189;BA.debugLine="lblSelectedItem.Height = 45dip"[addOrderActivity/General script]
views.get("lblselecteditem").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 192;BA.debugLine="bttnMinus.Width = 55dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setWidth((int)((55d * scale)));
//BA.debugLineNum = 193;BA.debugLine="bttnMinus.Height = 55dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setHeight((int)((55d * scale)));
//BA.debugLineNum = 194;BA.debugLine="bttnMinus.Left = 30dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setLeft((int)((30d * scale)));
//BA.debugLineNum = 195;BA.debugLine="bttnMinus.Top = lblSelectedItem.Bottom + 15dip"[addOrderActivity/General script]
views.get("bttnminus").vw.setTop((int)((views.get("lblselecteditem").vw.getTop() + views.get("lblselecteditem").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 198;BA.debugLine="lblQuantityValue.Width = 90dip"[addOrderActivity/General script]
views.get("lblquantityvalue").vw.setWidth((int)((90d * scale)));
//BA.debugLineNum = 199;BA.debugLine="lblQuantityValue.Height = 55dip"[addOrderActivity/General script]
views.get("lblquantityvalue").vw.setHeight((int)((55d * scale)));
//BA.debugLineNum = 200;BA.debugLine="lblQuantityValue.Left = bttnMinus.Right + 10dip"[addOrderActivity/General script]
views.get("lblquantityvalue").vw.setLeft((int)((views.get("bttnminus").vw.getLeft() + views.get("bttnminus").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 201;BA.debugLine="lblQuantityValue.Top = bttnMinus.Top"[addOrderActivity/General script]
views.get("lblquantityvalue").vw.setTop((int)((views.get("bttnminus").vw.getTop())));
//BA.debugLineNum = 204;BA.debugLine="bttnAdd.Width = 55dip"[addOrderActivity/General script]
views.get("bttnadd").vw.setWidth((int)((55d * scale)));
//BA.debugLineNum = 205;BA.debugLine="bttnAdd.Height = 55dip"[addOrderActivity/General script]
views.get("bttnadd").vw.setHeight((int)((55d * scale)));
//BA.debugLineNum = 206;BA.debugLine="bttnAdd.Left = lblQuantityValue.Right + 10dip"[addOrderActivity/General script]
views.get("bttnadd").vw.setLeft((int)((views.get("lblquantityvalue").vw.getLeft() + views.get("lblquantityvalue").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 207;BA.debugLine="bttnAdd.Top = bttnMinus.Top"[addOrderActivity/General script]
views.get("bttnadd").vw.setTop((int)((views.get("bttnminus").vw.getTop())));
//BA.debugLineNum = 210;BA.debugLine="bttnAddToCartQty.Width = pnlQuantity.Width - 40dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())-(40d * scale)));
//BA.debugLineNum = 211;BA.debugLine="bttnAddToCartQty.Height = 45dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setHeight((int)((45d * scale)));
//BA.debugLineNum = 212;BA.debugLine="bttnAddToCartQty.Left = 20dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 213;BA.debugLine="bttnAddToCartQty.Top = bttnMinus.Bottom + 15dip"[addOrderActivity/General script]
views.get("bttnaddtocartqty").vw.setTop((int)((views.get("bttnminus").vw.getTop() + views.get("bttnminus").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 216;BA.debugLine="bttnCancelQty.Width = pnlQuantity.Width - 40dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setWidth((int)((views.get("pnlquantity").vw.getWidth())-(40d * scale)));
//BA.debugLineNum = 217;BA.debugLine="bttnCancelQty.Height = 40dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 218;BA.debugLine="bttnCancelQty.Left = 20dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 219;BA.debugLine="bttnCancelQty.Top = bttnAddToCartQty.Bottom + 4dip"[addOrderActivity/General script]
views.get("bttncancelqty").vw.setTop((int)((views.get("bttnaddtocartqty").vw.getTop() + views.get("bttnaddtocartqty").vw.getHeight())+(4d * scale)));

}
}