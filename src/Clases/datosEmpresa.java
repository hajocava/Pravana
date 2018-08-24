
package Clases;

import static Frames.Interfaz.jlbLogo;
import static Frames.Interfaz.jtaAnotacionesEmpresa;
import static Frames.Interfaz.jtxtDireccionEmpresa;
import static Frames.Interfaz.jtxtEmailEmpresa;
import static Frames.Interfaz.jtxtFacebookEmpresa;
import static Frames.Interfaz.jtxtNombreEmpresa;
import static Frames.Interfaz.jtxtPaginaEmpresa;
import static Frames.Interfaz.jtxtTelefonoEmpresa;
import static Frames.Interfaz.rutaLogo;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class datosEmpresa {
    public static Icon cargarIcono(File file){
        FileInputStream entrada;
        byte[] bytesImg = new byte[1024*100];
        try {
            entrada = new FileInputStream(file);
            entrada.read(bytesImg);
        } catch (Exception e) {
            System.out.println(e);
        }
        ImageIcon imagen = new ImageIcon(bytesImg);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(jlbLogo.getWidth(), jlbLogo.getHeight(), Image.SCALE_DEFAULT));
        return icon;
    }
    
    public static void buscarImagen(){
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes","JPG","PNG");
        fc.setFileFilter(filtro);
        
        File file;
        byte[] bytesImg;
        
        if(fc.showDialog(null, "Seleccionar") == JFileChooser.APPROVE_OPTION){
            file = fc.getSelectedFile();
            rutaLogo = fc.getSelectedFile().getAbsolutePath();
            if(file.canRead()){
                if(file.getName().endsWith("JPG")||file.getName().endsWith("PNG")||file.getName().endsWith("jpg")||file.getName().endsWith("png"))
                {
                    jlbLogo.setIcon(cargarIcono(file));
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione un archivo de imagen.");
                }
            }
        }
    }
    
    public static void cargarDatosEmpresa(){
        Empresa datosEmpresa = obtenerEmpresa(true);
        
        if(datosEmpresa != null){
            jtxtNombreEmpresa.setText(datosEmpresa.getNombre());
            jtxtDireccionEmpresa.setText(datosEmpresa.getDireccion());
            jtxtTelefonoEmpresa.setText(datosEmpresa.getTelefono());
            jtxtEmailEmpresa.setText(datosEmpresa.getCorreo());
            jtxtPaginaEmpresa.setText(datosEmpresa.getPagina());
            jtxtFacebookEmpresa.setText(datosEmpresa.getFacebook());
            rutaLogo = datosEmpresa.getRutaLogo();
            File file = new File(rutaLogo);
            jlbLogo.setIcon(cargarIcono(file));
            jtaAnotacionesEmpresa.setText(datosEmpresa.getNotas());
        }
        
    }
    
    public static Empresa obtenerEmpresa(boolean ventanaAjustes){
        String datos[] = new String [8];
        Empresa empresa;
        try {
            File archivo = new File ("\\datosEmpresa.txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            
            int contador = 0;
            String linea;
            
            while((linea=br.readLine())!=null){
                if(contador < 7){
                    datos[contador] = linea;
                    contador++;
                    if(contador == 7) datos[contador] = "";
                    
                }else datos[contador] += linea;
            }
            empresa = new Empresa(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
            
            fr.close();
            return empresa;
            
        }catch(Exception e){
            System.out.println(e);
            if(!ventanaAjustes)
                 JOptionPane.showMessageDialog(null,"Para poder imprimir su registro necesita\n"
                         + "configurar los datos de la empresa en la ventana Administrador/Empresa");
            return null;
        }
        
    }
    
    public static void escribirDatosEmpresa(){
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try
        {
            fichero = new FileWriter("\\datosEmpresa.txt");
            pw = new PrintWriter(fichero);

            pw.println(jtxtNombreEmpresa.getText());
            pw.println(jtxtDireccionEmpresa.getText());
            pw.println(jtxtTelefonoEmpresa.getText());
            pw.println(jtxtEmailEmpresa.getText());
            pw.println(jtxtPaginaEmpresa.getText());
            pw.println(jtxtFacebookEmpresa.getText());
            pw.println(rutaLogo);
            pw.print(jtaAnotacionesEmpresa.getText());
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
           try{
                if (null != fichero){
                    fichero.close();
                    JOptionPane.showMessageDialog(null,"Datos guardados");
                }
           } catch (Exception e2) {
               System.out.println(e2);
           }
        }
    }
}
