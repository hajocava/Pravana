
package Clases;

import static Frames.Interfaz.jCalendario;
import static Frames.Interfaz.jDateChooser1;
import static Frames.Interfaz.jtCitas;
import static Frames.Interfaz.jtaNotas;
import static Frames.Interfaz.jtaNotasCita;
import static Frames.Interfaz.jtxtCliente;
import static Frames.Interfaz.jtxtDirCliente;
import static Frames.Interfaz.jtxtIdCliente;
import static Frames.Interfaz.jtxtIdUsuario;
import static Frames.Interfaz.jtxtTelefono;
import static Frames.Interfaz.jtxtUser;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Citas {
    
    public static void insertarCita(){
        String fecha = Fecha.getFecha(jDateChooser1);
        String id_usuario = jtxtIdUsuario.getText();
        String id_cliente = jtxtIdCliente.getText();
        String notas = jtaNotasCita.getText();
        
        if(!fecha.isEmpty() && !id_usuario.isEmpty() && !id_cliente.isEmpty()){
            Conexion.queryExecute("INSERT INTO citas (fecha,fk_cliente,fk_usuario,notas) "
                + "VALUES ('"+fecha+"',"+id_cliente+","+id_usuario+",'"+notas+"');");
            Conexion.commit();
            JOptionPane.showMessageDialog(null,"Cita guardada");
        }else{
            JOptionPane.showMessageDialog(null,"Ingresa los campos obligatorios");
        }
    }
    
    public static void cargarCamposCita(int id_cita){
        try {
            ResultSet rs = Conexion.selectFrom("SELECT fecha,clientes.nombre,telefono,direccion,usuarios.nombre,notas "
                    + "FROM citas "
                    + "INNER JOIN clientes ON citas.fk_cliente = clientes.id_cliente "
                    + "INNER JOIN usuarios ON citas.fk_usuario = usuarios.id_usuario "
                    + "WHERE id_cita = "+id_cita+";");
            rs.next();
            
            jCalendario.setDate(Fecha.SetDate(rs.getDate("fecha").toString()));
            jtxtCliente.setText(rs.getString("clientes.nombre"));
            jtxtTelefono.setText(rs.getString("telefono"));
            jtxtDirCliente.setText(rs.getString("direccion"));
            jtxtUser.setText(rs.getString("usuarios.nombre"));
            jtaNotas.setText(rs.getString("notas"));
        } catch (Exception e) {
            System.out.println("Ocurrio un error en el metodo cargarCamposCita");
        }
    }
    
    public static void cargarTablaCitas(String query){
        String titulos[] = {"Id cita","Fecha","Nombre del cliente"};
        
        DefaultTableModel modelo = new DefaultTableModel();

        jtCitas.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("id_cita"),
                    rs.getString("fecha"),
                    rs.getString("nombre")
                });
            }
            jtCitas.setModel(modelo);
            
            TableColumnModel columnModel = jtCitas.getColumnModel();
            
            jtCitas.getColumnModel().getColumn(0).setMaxWidth(0);
            jtCitas.getColumnModel().getColumn(0).setMinWidth(0);
            jtCitas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jtCitas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            columnModel.getColumn(1).setPreferredWidth(60);
            
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en el metodo cargarTablaCitas");
        }
    }
    
    public static void eliminarCita(int id_cita){
        Conexion.queryExecute("DELETE FROM citas WHERE id_cita = "+id_cita+";");
        Conexion.commit();
        limpiarFormulario();
    }
    
    public static void limpiarFormulario(){
        jtxtCliente.setText("");
        jtxtTelefono.setText("");
        jtaNotas.setText("");
        jtxtDirCliente.setText("");
        jtxtUser.setText("");
    }
}
