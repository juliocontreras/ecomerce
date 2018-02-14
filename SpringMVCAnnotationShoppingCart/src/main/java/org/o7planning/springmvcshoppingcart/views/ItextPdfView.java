package org.o7planning.springmvcshoppingcart.views;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.model.CartLineInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
//        List<OrderInfo> orderinfo = (List<OrderInfo>) model.get("orderinfos");
        	
               
        CartInfo cartInfo = Utils.getCartInSession(request);
        
        
        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{10, 60, 30});
        
        table.addCell("" + cartInfo.getOrderNum());
        table.addCell("" + cartInfo.getAmountTotal());
        table.addCell("Date");
        

        for (CartLineInfo orderinfos : cartInfo.getCartLines()){
        	
            table.addCell(orderinfos.getProductInfo().getCode());
            table.addCell(orderinfos.getProductInfo().getName());
            
        }



        document.add(table);
    }

}