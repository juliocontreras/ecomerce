package org.o7planning.springmvcshoppingcart.views;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.o7planning.springmvcshoppingcart.model.OrderInfo;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

public class LowagiePdfView extends AbstractPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<OrderInfo> orderinfo = (List<OrderInfo>) model.get("OrderInfos");

        PdfPTable table = new PdfPTable(4);

        table.addCell("Customer_Address");
        table.addCell("Customer_Email");
        table.addCell("Customer_Name");
        table.addCell("Customer_Phone");
//        table.addCell("Order_Date");
//        table.addCell("Quanity");
//        table.addCell("Price");

        for (OrderInfo orderinfos : orderinfo){
            table.addCell(orderinfo.get(0).getCustomerAddress());
            table.addCell(orderinfo.get(0).getCustomerEmail());
            table.addCell(orderinfo.get(0).getCustomerName());
            table.addCell(orderinfo.get(0).getCustomerPhone());
//            table.addCell(DATE_FORMAT.format(OrderInfo.getDate()));
        }

        document.add(table);
    }
}