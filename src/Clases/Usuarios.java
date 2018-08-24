
package Clases;

import static Frames.Interfaz.buttonGroupAdmin;
import static Frames.Interfaz.jRadioNo;
import static Frames.Interfaz.jRadioSi;
import static Frames.Interfaz.jtUsuarios;
import static Frames.Interfaz.jtxtPass;
import static Frames.Interfaz.jtxtPassRepeat;
import static Frames.Interfaz.jtxtUsuario;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Usuarios {
    
    public static void crearUsuario(){
        if(!jtxtUsuario.getText().isEmpty() && !jtxtPass.getText().isEmpty() && 
                !jtxtPassRepeat.getText().isEmpty() && (jRadioSi.isSelected() || jRadioNo.isSelected()))
        {
            if(jtxtPass.getText().equals(jtxtPassRepeat.getText()))
            {
                if(jRadioSi.isSelected()){
                    Conexion.queryExecute("INSERT INTO usuarios (nombre,password,tipo,habilitado) "
                        + "VALUES('"+ jtxtUsuario.getText() +"', MD5('"+ jtxtPass.getText() +"'),1,1);");
                }else if(jRadioNo.isSelected()){
                    Conexion.queryExecute("INSERT INTO usuarios (nombre,password,tipo,habilitado) "
                        + "VALUES('"+ jtxtUsuario.getText() +"', MD5('"+ jtxtPass.getText() +"'),0,1);");
                }
                
                Conexion.commit();
                
                jtxtUsuario.setText("");
                jtxtPass.setText("");
                jtxtPassRepeat.setText("");
                buttonGroupAdmin.clearSelection();
            }
            else
                JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
            
        }else{
            JOptionPane.showMessageDialog(null,"Ingresa todos los campos");
        }
        
       
    }
    
    public static void cargarUsuarios(){
        String titulos[] = {"Id","Nombre de usuario","Tipo"};
        
        DefaultTableModel modelo = new DefaultTableModel();

        jtUsuarios.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom("SELECT * FROM usuarios WHERE habilitado = 1;");
            String tipo;
            
            while(rs.next())
            {
                
                if(rs.getInt("tipo") == 1) tipo = "Administrador";
                else tipo = "Normal";
                
                modelo.addRow(new Object[]{
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    tipo
                });
            }
            jtUsuarios.setModel(modelo);
            
            jtUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
            jtUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
            jtUsuarios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jtUsuarios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo cargarUsuarios");
        }
    }
    
    public static void cambiarNombre(){
        int fila = jtUsuarios.getSelectedRow();
        if(fila != -1){
            int id = Integer.parseInt(jtUsuarios.getValueAt(fila, 0).toString());
            String nombre = JOptionPane.showInputDialog(null,"Escriba el nuevo nombre de usuario");
            Conexion.queryExecute("UPDATE usuarios SET nombre = '"+nombre+"' WHERE id_usuario = "+id+";");
            
            Conexion.commit();
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un usuario");
        }     
    }
    
    public static void cambiarPassword(){
        int fila = jtUsuarios.getSelectedRow();
        if(fila != -1){
            int id = Integer.parseInt(jtUsuarios.getValueAt(fila, 0).toString());
            
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Ingrese la nueva contraseña: ");
            JPasswordField pass = new JPasswordField(10);
            panel.add(label);
            panel.add(pass);
            String[] options = new String[]{"Cancelar", "Aceptar"};
            int option = JOptionPane.showOptionDialog(null, panel, "Cambiar password",
                             JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                             null, options, options[1]);
            if(option == 1)//Si presionan aceptar
            {
                char[] password = pass.getPassword();
                String pass1 = new String(password);
                System.out.println(pass1);
                
                panel.remove(label);
                panel.remove(pass);
                
                label = new JLabel("Repita la contraseña: ");
                pass.setText("");
                
                panel.add(label);
                panel.add(pass);
                
                option = JOptionPane.showOptionDialog(null, panel, "Cambiar password",
                             JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                             null, options, options[1]);
                if(option == 1)//Si presionan aceptar
                {
                    char[] password2 = pass.getPassword();
                    String pass2 = new String(password2);
                    
                    if(pass1.equals(pass2)){
                        Conexion.queryExecute("UPDATE usuarios SET password = MD5('"+pass1+"') "
                                + "WHERE id_usuario = "+id+";");
                        Conexion.commit();
                    }else{
                        JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
                    }
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un usuario");
        } 
    }
    
    public static void cambiarPermisos(){
        int fila = jtUsuarios.getSelectedRow();
        if(fila != -1){
            cargarUsuarios();
            
            int idUsuario = Integer.parseInt(jtUsuarios.getValueAt(fila, 0).toString());
            String tipo = jtUsuarios.getValueAt(fila, 2).toString();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            
            if(tipo.equalsIgnoreCase("Administrador")){
                
                int dialogResult = JOptionPane.showConfirmDialog (null, "Los permisos se van a cambiar a Normal sin privilegios","Confirmacion",dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION)
                {
                    Conexion.queryExecute("UPDATE usuarios SET tipo = 0 WHERE id_usuario = "+idUsuario+";");
                    Conexion.commit();
                }
                
            }else if(tipo.equalsIgnoreCase("Normal")){
                int dialogResult = JOptionPane.showConfirmDialog (null, "Los permisos se van a cambiar a Administrador","Confirmacion",dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION)
                {
                    Conexion.queryExecute("UPDATE usuarios SET tipo = 1 WHERE id_usuario = "+idUsuario+";");
                    Conexion.commit();
                }
                
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un usuario");
        }    
        cargarUsuarios();
    }
    
    public static void eliminarUsuario(){
        int fila = jtUsuarios.getSelectedRow();
        if(fila != -1){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro de eliminar este usuario?","Confirmacion",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Conexion.queryExecute("UPDATE usuarios SET habilitado = 0 WHERE id_usuario = " + jtUsuarios.getValueAt(fila, 0) + ";");
                Conexion.commit();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un usuario");
        }  
        cargarUsuarios();
    }
    
}
