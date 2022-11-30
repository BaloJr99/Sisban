package clases;

import cl.model.dao.CuentaDao;
import cl.model.db.EstadoCuenta;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ReportePdf {
    
    public void generarReporte(String DES, String titulo, int idCliente, Date fecha, String numCuenta, String banco, boolean ejecutivo) throws SQLException, FileNotFoundException, IOException{
        
        try {
            PdfWriter writer = new PdfWriter(DES);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.LETTER);

            EventoPdf evento = new EventoPdf(document, titulo, banco);
            pdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);

            document.setMargins(20, 20, 20, 20);

            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

            String tituloTabla[] = {"Fecha", "Descripcion", "Cargo", "Abono", "Saldo"};
            float[] anchoColumn = {3,3,3,2,1};

            Table table = new Table(anchoColumn);
            table.setWidth(UnitValue.createPercentValue(100));

            ArrayList<EstadoCuenta> estadoCuenta = null;
            
            if(ejecutivo){
                estadoCuenta = new CuentaDao().estadoCuentaGeneral(idCliente);
            }else{
                estadoCuenta = new CuentaDao().estadoCuenta(idCliente, fecha, numCuenta);
            }

            for(String encabezadoTabla: tituloTabla){
                process(table, encabezadoTabla, bold, true);
            }

            if(estadoCuenta.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hubo movimientos en ese mes");
            }  
            else{
                for(EstadoCuenta estado: estadoCuenta){

                    process(table, String.valueOf(estado.getFecha()), font, false);
                    process(table, estado.getDescripcion(), font, false);

                    if(estado.getNumeroCuenta().equals(estado.getCuenta_numeroCuenta())){
                        process(table, String.valueOf(estado.getMonto() + ";"), font, false);
                        process(table, "0;", font, false);
                    }else{
                        process(table, "0;", font, false);
                        process(table, String.valueOf(estado.getMonto()) + ";", font, false);
                    }

                    process(table, String.valueOf(estado.getSaldo()) + ";", font, false);
                }
                document.add(new Paragraph("\n\n").add("IdCliente: " + estadoCuenta.get(0).getIdCliente() + "\n" + estadoCuenta.get(0).getNombre()));
                document.add(table);
                document.close();  
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "El documento se encuentra abierto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void process(Table table, String line, PdfFont font, boolean isHeader){
        StringTokenizer tokenizer = new StringTokenizer(line,";");
        while(tokenizer.hasMoreTokens()){
            if(isHeader){
                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            }else{
                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            }
        }
    }
    
}
