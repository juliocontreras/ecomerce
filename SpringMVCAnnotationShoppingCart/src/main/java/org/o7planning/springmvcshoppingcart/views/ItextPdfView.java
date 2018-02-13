package org.o7planning.springmvcshoppingcart.views;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.o7planning.springmvcshoppingcart.model.OrderInfo;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<OrderInfo> orderinfo = (List<OrderInfo>) model.get("orderinfos");

        PdfPTable table = new PdfPTable(4);
        table.setWidths(new int[]{10, 60, 30});
        
        table.addCell("Customer_Address");
        table.addCell("Customer_Email");
        table.addCell("Customer_Name");
        table.addCell("Customer_Phone");

        for (OrderInfo orderinfos : orderinfo){
            table.addCell(orderinfo.get(0).getCustomerAddress());
            table.addCell(orderinfo.get(1).getCustomerEmail());
            table.addCell(orderinfo.get(2).getCustomerName());
            table.addCell(orderinfo.get(3).getCustomerPhone());
        }



        document.add(table);
    }

}