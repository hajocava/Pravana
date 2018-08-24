
package Clases;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;


public class iTextPDF{
   
    public static void generarRecibo(String rutaPDF,String nombreCliente, float deudaCliente,float abonoCliente){
        try {
            Document document = new Document(PageSize.A4,50,50,25,25);
            PdfWriter.getInstance(document, new FileOutputStream(rutaPDF));
            document.open();
            
            Font Bold = new Font(Font.FontFamily.COURIER,20,Font.BOLD);
            Font Normal = new Font(Font.FontFamily.COURIER,11,Font.NORMAL);
            
            //NOMBRE DE LA EMPRESA
            document.add(getHeader("PRAVANA",Bold,0,25)); //ATRIBUTOS SON EMPRESA,FUENTE,INTERLIENADO
            
            //TITULO
            document.add(getHeader("RECIBO DE ABONO",Bold,0,25)); //ATRIBUTOS SON EMPRESA,FUENTE,INTERLIENADO
            
            //NOMBRE DEL CLIENTE
            document.add(getParagraphCenter("* " + nombreCliente.toUpperCase() + " *",Normal,0,18));
            
            //FECHA
            Date fecha = null;
            Calendar c = Calendar.getInstance();
            int dia = c.get(Calendar.DATE);
            int mes = c.get(Calendar.MONTH)+1;
            int annio = c.get(Calendar.YEAR);
            document.add(getParagraphCenter(String.valueOf(annio+"/"+mes+"/"+dia),Normal,0,18));
            
            //SEPARADOR =
            document.add(getParagraphJustify("==================================",Normal,0,18));
            
            //CONTENIDO TICKET
            document.add(getParagraphLeft("ADEUDO ANTERIOR",Normal,0,18));
            document.add(getParagraphRight(String.valueOf(deudaCliente),Normal,0,18));
            
            document.add(getParagraphLeft("ABONO",Normal,0,18));
            document.add(getParagraphRight(String.valueOf(abonoCliente),Normal,0,18));
            
            //SEPARADOR =
            document.add(getParagraphJustify("==================================",Normal,0,18));
            
            //FOOTER
            document.add(footer("SALDO PENDIENTE: ",Bold,0,15));
            float saldo = deudaCliente - abonoCliente;
            document.add(getParagraphRight(String.valueOf(saldo),Normal,0,18));
            
            
            document.close();
            
            
        } catch (Exception e) {
            
        }
    }
    
    public static void generarHistorialCliente(String rutaPDF,int idCliente,String nombreCliente){
        try {
            Document document = new Document(PageSize.A4,50,50,25,25);
            PdfWriter.getInstance(document, new FileOutputStream(rutaPDF));
            document.open();
            
            Font Bold = new Font(Font.FontFamily.COURIER,20,Font.BOLD);
            Font Normal = new Font(Font.FontFamily.COURIER,11,Font.NORMAL);
            
            //NOMBRE DE LA EMPRESA
            document.add(getHeader("PRAVANA",Bold,0,25)); //ATRIBUTOS SON EMPRESA,FUENTE,INTERLIENADO
            
            //TITULO
            document.add(getHeader("HISTORIAL DE MOVIMIENTOS",Bold,0,25)); //ATRIBUTOS SON EMPRESA,FUENTE,INTERLIENADO
            
            //NOMBRE DEL CLIENTE
            document.add(getParagraphCenter("* " + nombreCliente.toUpperCase() + " *",Normal,0,18));
            
            //FECHA
            Date fecha = null;
            Calendar c = Calendar.getInstance();
            int dia = c.get(Calendar.DATE);
            int mes = c.get(Calendar.MONTH)+1;
            int annio = c.get(Calendar.YEAR);
            document.add(getParagraphCenter(String.valueOf(annio+"/"+mes+"/"+dia),Normal,0,18));
            
            //SEPARADOR =
            document.add(getParagraphJustify("--------------------------------------------------------------------------",Normal,0,18));
            
            try{
                ResultSet rsCredito = Conexion.selectFrom("SELECT id_credito, date, total "
                        + "FROM creditos INNER JOIN ventas ON creditos.fk_venta = ventas.id_venta "
                        + "WHERE fk_cliente = "+idCliente+" AND liquidado = 0;");

                while(rsCredito.next()){
                    document.add(getParagraphLeft(rsCredito.getDate("date").toString(),Normal,0,18));
                    document.add(getParagraphCenter("COMPRA DE PROD. ",Normal,0,18));
                    document.add(getParagraphRight("+$ "+String.valueOf(rsCredito.getFloat("total")),Normal,0,18));
                    
                    ResultSet rsAbonos = Conexion.selectFrom("SELECT abonosgeneral.cantidad AS totalAbono, abonosgeneral.fecha AS fechaAbono "
                        + "FROM abonosgeneral INNER JOIN abonos ON abonos.fk_abonogeneral = abonosgeneral.id_abono "
                        + "INNER JOIN creditos on abonos.fk_credito = creditos.id_credito "
                        + "WHERE fk_credito = "+rsCredito.getInt("id_credito")+";");

                    while(rsAbonos.next()){
                        document.add(getParagraphLeft(rsAbonos.getDate("fechaAbono").toString(),Normal,0,18));
                        document.add(getParagraphCenter("ABONO. ",Normal,0,18));
                        document.add(getParagraphRight("-$ "+String.valueOf(rsAbonos.getFloat("totalAbono")),Normal,0,18));
                    }
                }
            }catch (Exception e){
                System.out.println("Ocurrio un error en el metodo GenerarHistorialCliente");
            }
            //SEPARADOR =
            document.add(getParagraphJustify("--------------------------------------------------------------------------",Normal,0,18));
            
            //FOOTER
            document.add(getParagraphLeft("SALDO PENDIENTE: ",Normal,0,18));
            document.add(getParagraphRight("$ "+String.valueOf(Creditos.balanceCredito(idCliente)),Normal,0,18));
            
            document.close();
            
            
        } catch (Exception e) {
            
        }
    }
    
    public static void generarNota(String metodoPago, int idCliente){
        try {
            Document document = new Document(PageSize.A4,50,50,25,25);
            
            String sDirectorioTrabajo = System.getProperty("user.dir");
            PdfWriter.getInstance(document, new FileOutputStream(sDirectorioTrabajo+"\\notaVenta.pdf"));
            
            document.open();
            
            Font Bold = new Font(Font.FontFamily.COURIER,20,Font.BOLD);
            Font Normal = new Font(Font.FontFamily.COURIER,11,Font.NORMAL);
            
            
            document.add(getImageLeft(sDirectorioTrabajo+"\\Pravana medium.png", 180, 31,20,0));
            
            document.add(getHeaderRight("NOTA DE VENTA",Bold,0,-10));
            document.add(getParagraphRight("Expedida en Morelia, Michoacán. México",Normal,0,18));
            document.add(getParagraphRight("PRODUCTOS DE BELLEZA EN GENERAL",Normal,0,18));
            
            Calendar c = Calendar.getInstance();
            int dia = c.get(Calendar.DATE);
            int mes = c.get(Calendar.MONTH)+1;
            int annio = c.get(Calendar.YEAR);
            String mesPalabra = "";
            switch(mes){
                case 1:{
                    mesPalabra = "Enero";
                    break;
                }
                case 2:{
                    mesPalabra = "Febrero";
                    break;
                }
                case 3:{
                    mesPalabra = "Marzo";
                    break;
                }
                case 4:{
                    mesPalabra = "Abril";
                    break;
                }
                case 5:{
                    mesPalabra = "Mayo";
                    break;
                }
                case 6:{
                    mesPalabra = "Junio";
                    break;
                }
                case 7:{
                    mesPalabra = "Julio";
                    break;
                }
                case 8:{
                    mesPalabra = "Agosto";
                    break;
                }
                case 9:{
                    mesPalabra = "Septiembre";
                    break;
                }
                case 10:{
                    mesPalabra = "Octubre";
                    break;
                }
                case 11:{
                    mesPalabra = "Noviembre";
                    break;
                }
                case 12:{
                    mesPalabra = "Diciembre";
                    break;
                }
            }
            
            document.add(getParagraphRight("Morelia, Michoacán. a " + dia + " de " + mesPalabra + " del "+ annio +".",Normal,0,18));
            
            
            
            ResultSet rs = Conexion.selectFrom("SELECT * FROM clientes WHERE id_cliente = " + idCliente + ";");
            
            if(metodoPago.equals("credito")){
                if(rs.next())
                {
                    Bold = new Font(Font.FontFamily.COURIER,15,Font.BOLD);
                    document.add(getParagraphLeft("DATOS DEL CLIENTE",Bold,0,30));
                    document.add(getParagraphLeft("Nombre: "+rs.getString("nombre"),Normal,0,20));
                    document.add(getParagraphLeft("Direccion: "+rs.getString("direccion"),Normal,0,15));
                    document.add(getParagraphLeft("C.P: "+rs.getString("codigoPostal"),Normal,0,15));
                    document.add(getParagraphLeft("Telefono: "+rs.getString("telefono"),Normal,0,15));
                    document.add(getParagraphLeft("RFC: "+rs.getString("RFC"),Normal,0,15));
                    document.add(getParagraphLeft("e-mail: "+rs.getString("email"),Normal,0,15));
                }   
            }
            
            document.add(getParagraphLeft("Condiciones de pago: " + metodoPago,Normal,10,20));
            
            PdfPTable table = simpleTable(4,new int[]{2,4,2,2},15,100,0,8);
            table.getDefaultCell().setMinimumHeight(20);//ALTO DE CELDA
            Bold = new Font(Font.FontFamily.COURIER,15,Font.BOLD);
            table.addCell(new Phrase("Cantidad",Bold));
            table.addCell(new Phrase("Articulo",Bold));
            table.addCell(new Phrase("Precio",Bold));
            table.addCell(new Phrase("Importe",Bold));
            
            int cantidad = 0;
            float total = 0;
            ArrayList<Cuenta> arrayCuenta = puntoVenta.getArrayCuenta();
            for (int i = 0; i < arrayCuenta.size(); i++) {
                cantidad += arrayCuenta.get(i).getCantidad();
                total += arrayCuenta.get(i).getImporte();
                
                table.addCell(new Phrase(String.valueOf(arrayCuenta.get(i).getCantidad()),Normal));
                table.addCell(new Phrase(String.valueOf(arrayCuenta.get(i).getNombreProducto()),Normal));
                table.addCell(new Phrase(String.valueOf(arrayCuenta.get(i).getPrecio()),Normal));
                table.addCell(new Phrase(String.valueOf(arrayCuenta.get(i).getImporte()),Normal));
            }
            table.addCell(cellRight(Bold,"Importe Total: ",3,25));
            table.addCell(cellLeft(Bold,"$"+String.valueOf(total),1,25));
            document.add(table);
            
            int entero = (int) total;
            int decimales = (int) ((total - entero)*100);
            
            n2t numero = new n2t(entero);
            String resEntero = numero.convertirLetras(entero);
            String resDecimales = numero.convertirLetras(decimales);
            if(resDecimales.isEmpty()){
                document.add(getParagraphLeft("Importe total con letra: "+resEntero+" pesos",Normal,15,15));
            }else{
                document.add(getParagraphLeft("Importe total con letra: "+resEntero+" pesos con "+ resDecimales + "centavos.",Normal,15,15));
            }
            
            if(metodoPago.equals("credito")){
                
//                document.add(getParagraphJustify("--------------------------------------------------------------------------",Normal,0,60));
                document.newPage();

                document.add(getParagraphLeft("",Bold,0,100));
                Bold = new Font(Font.FontFamily.COURIER,15,Font.BOLD);
                document.add(getParagraphLeft("PAGARÉ",Bold,0,30));
                document.add(getParagraphRight("BUENO POR $"+total,Bold,0,0));

                Bold = new Font(Font.FontFamily.COURIER,10,Font.BOLD);
                if(resDecimales.isEmpty()){
                    document.add(getParagraphLeft("Debo (emos) y pagaré (mos) incondicionalmente por este pagaré a la orden de MERCEDES EUGENIA "
                        + "FINCK PASTRANA, en Morelia, Michoacán. Mexico, el _________________. La cantidad de: "+resEntero+" pesos.",Bold,10,15));
                }else{
                    document.add(getParagraphLeft("Debo (emos) y pagaré (mos) incondicionalmente por este pagaré a la orden de MERCEDES EUGENIA "
                        + "FINCK PASTRANA, en Morelia, Michoacán. Mexico, el _________________. La cantidad de: "+resEntero+" pesos con "+ resDecimales + "centavos.",Bold,10,15));
                }
                
                Normal = new Font(Font.FontFamily.COURIER,8,Font.NORMAL);
                document.add(getParagraphLeft("Valor recibido a mi (nuestra) entera satisfacción. Este pagaré forma parte de una serie numerada del 1 al ______ y todos estan sujetos "
                        + "a la condicion de que, al no pagarse cualquiera de ellos a su vencimiento, seran exigibles todos los que le sigan en número, "
                        + "ademas de los ya vencidos, desde la fecha de vencimiento de este documento, hasta el dia de su liquidación, causaran intereses moratorios "
                        + "al tipo de ____________% mensual. Pagadero en esta ciudad justamente con el principal.",Normal,10,15));
                
                
                Bold = new Font(Font.FontFamily.COURIER,15,Font.BOLD);
                document.add(getParagraphLeft("DATOS DEL CLIENTE",Bold,0,30));
                document.add(getParagraphLeft("Nombre: "+rs.getString("nombre"),Normal,0,20));
                document.add(getParagraphLeft("Direccion: "+rs.getString("direccion"),Normal,0,10));
                document.add(getParagraphLeft("C.P: "+rs.getString("codigoPostal"),Normal,0,10));
                document.add(getParagraphLeft("Telefono: "+rs.getString("telefono"),Normal,0,10));
                document.add(getParagraphLeft("RFC: "+rs.getString("RFC"),Normal,0,10));
                document.add(getParagraphLeft("e-mail: "+rs.getString("email"),Normal,0,10));
                
                document.add(getParagraphRight("Acepto (amos)",Bold,0,-60));
                document.add(getParagraphRight("_________________________",Normal,0,40));
                document.add(getParagraphRight("Firma",Normal,0,15));
                
            }
            
            
            
            
            document.close();
            
            try{
                File objetofile = new File(sDirectorioTrabajo+"\\notaVenta.pdf");
                Desktop.getDesktop().open(objetofile);
            }catch (IOException ex) {
                System.out.println(ex);
            }
        } catch (Exception e) {
            
        }
    }
 
    
    public static Image getImage(String rutaImagen, int width, int height, int interlineado, int separacion){
        try {
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(width, height);
            imagen.setSpacingBefore(interlineado);
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.setSpacingBefore(separacion);
            return imagen;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    
    public static Image getImageLeft(String rutaImagen, int width, int height, int interlineado, int separacion){
        try {
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(width, height);
            imagen.setSpacingBefore(interlineado);
            imagen.setAlignment(Element.ALIGN_LEFT);
            imagen.setSpacingBefore(separacion);
            return imagen;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    public static Image getImageRight(String rutaImagen, int width, int height, int interlineado, int separacion){
        try {
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(width, height);
            imagen.setSpacingBefore(interlineado);
            imagen.setAlignment(Element.ALIGN_RIGHT);
            imagen.setSpacingBefore(separacion);
            return imagen;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    
    public static PdfPCell cellLeft(Font font, String title, int Colspan, int Height){
        PdfPCell cell = new PdfPCell(new Phrase(title,font));
        cell.setBackgroundColor(new GrayColor(0.85f));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setColspan(Colspan);
        cell.setMinimumHeight(Height);
        return cell;
    }
    
    public static PdfPCell cellCenter(Font font, String title, int Colspan, int Height){
        PdfPCell cell = new PdfPCell(new Phrase(title,font));
        cell.setBackgroundColor(new GrayColor(0.85f));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(Colspan);
        cell.setMinimumHeight(Height);
        return cell;
    }
    
    public static PdfPCell cellRight(Font font, String title, int Colspan, int Height){
        PdfPCell cell = new PdfPCell(new Phrase(title,font));
        cell.setBackgroundColor(new GrayColor(0.85f));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setColspan(Colspan);
        cell.setMinimumHeight(Height);
        return cell;
    }
    
    public static PdfPTable simpleTable(int totalColumns, int columnWidths[], int interlineado, int widthPercentage, int fixedHeight, int separacion){
        try {
            PdfPTable table = new PdfPTable(totalColumns);
            table.setSpacingBefore(interlineado);
            table.setWidthPercentage(widthPercentage);
            table.setWidths(columnWidths);
            table.getDefaultCell().setFixedHeight(fixedHeight);
            table.setSpacingBefore(separacion);
            
            return table;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    private static Paragraph getHeader(String text, Font font, int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingBefore(separacion);
        p.add(c);
        return p;
    }
    private static Paragraph getHeaderLeft(String text, Font font, int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_LEFT);
        p.setSpacingBefore(separacion);
        p.add(c);
        return p;
    }
    private static Paragraph getHeaderRight(String text, Font font, int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_RIGHT);
        p.setSpacingBefore(separacion);
        p.add(c);
        return p;
    }
    
    private static Paragraph getParagraphLeft(String text, Font font, int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_LEFT);
        p.setSpacingBefore(separacion);
        p.add(c);
        return p;
    }
    
    private static Paragraph getParagraphRight(String text, Font font, int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_RIGHT);
        p.setSpacingBefore(separacion);
        p.add(c);
        return p;
    }
    
    private static Paragraph getParagraphJustify(String text, Font font, int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
        p.setSpacingBefore(separacion);
        p.add(c);
        return p;
    }
    
    private static Paragraph getParagraphCenter(String text, Font font, int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingBefore(separacion);
        p.add(c);
        return p;
    }
    
    private static Paragraph footer(String text,Font font,int interlineado, int separacion){
        Paragraph p = new Paragraph(interlineado);
        Chunk c = new Chunk();
        c.append(text);
        c.setFont(font);
        p.setAlignment(Element.ALIGN_BASELINE);
        p.setSpacingBefore(separacion);
        p.add(c);
        
        return p;
    }

    
}
