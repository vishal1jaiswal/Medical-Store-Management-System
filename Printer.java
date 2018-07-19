/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvelsgroup;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Image;
//import java.awt.*;
/**
 *
 * @author hp-pc
 */
public class Printer {
  
    
    public String printPDF(JTable x, FinalBillElement f)
    {
    
               FileOutputStream file = null;
               String URL="C:\\Users\\hp-pc\\Documents\\INVOICES\\"+f.pname+".pdf";
try {
    file = new FileOutputStream(new File(URL));
     
     
} catch (FileNotFoundException e1) {
     
    e1.printStackTrace();
}
 
 
Document document = new Document();
        
        try {
            PdfWriter.getInstance(document, file);
        } catch (DocumentException ex) {
            Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
document.open();

 
Paragraph p = new Paragraph();
try {

//Image img = Image.getInstance("caduceus.jpg");
//img.setAbsolutePosition(100f, 500f);
//img.scaleAbsolute(200,200);
    
    
p.add("\n");
p.add("                              MEDICAL STORE MANAGEMENT SYSTEM               ");
p.add("\n ==========================================================================");
 
p.add("\n Invoice no.:      " + f.billID);
//p.add("\n Invoice date:      " + f.);
p.add("\n Patient Name:      " + f.pname);
p.add("\n Doctor Suggested:      " + f.dname);
p.add("\n Address:      " + f.addr);
p.add("\n ==========================================================================\n\n");

              PdfPTable pdfTable = new PdfPTable(x.getColumnCount());
            //adding table headers
            for (int i = 0; i < x.getColumnCount(); i++) {
                pdfTable.addCell(x.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < x.getRowCount(); rows++) {
                for (int cols = 0; cols < x.getColumnCount(); cols++) {
                    pdfTable.addCell(x.getModel().getValueAt(rows, cols).toString());
                }
            }
            Paragraph ps = new Paragraph();
ps.add("\n ==========================================================================");           
ps.add("\n                                                  Subtotal := Rs."+f.total);
ps.add("\n                                          Discount amount  :="+f.dis+"%");         
ps.add("\n                                                Net Total  := Rs."+f.ntotal);
            
 
document.add(p);
//document.add(img);
document.add(pdfTable);
document.add(ps);
document.close();
 
}
 
catch (Exception e) {
    e.printStackTrace();
    
}
return URL;
    }
}
