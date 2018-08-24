
package Clases;

import static Clases.Conexion.cn;
import static Clases.Inventario.contarProductos;
import static Frames.Interfaz.jcbDepartamento;
import static Frames.Interfaz.jtClientes;
import static Frames.Interfaz.jtInventario;
import static Frames.Interfaz.jtxtCodigo;
import static Frames.Interfaz.jtxtCodigoPostal;
import static Frames.Interfaz.jtxtCosto;
import static Frames.Interfaz.jtxtDescripcion;
import static Frames.Interfaz.jtxtExistencia;
import static Frames.Interfaz.jtxtMayoreo;
import static Frames.Interfaz.jtxtMinimo;
import static Frames.Interfaz.jtxtNombreCliente;
import static Frames.Interfaz.jtxtPublico;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static Frames.Interfaz.jtxtDireccionCliente;
import static Frames.Interfaz.jtxtEmail;
import static Frames.Interfaz.jtxtFactura;
import static Frames.Interfaz.jtxtMetodoPago;
import static Frames.Interfaz.jtxtRFC;
import static Frames.Interfaz.jtxtTelefonoCliente;


public class Clientes {
    private static boolean actualizarCliente = false;
    
    public static DefaultTableModel cargarTablaClientes(String consulta){
        
        String titulos[] = {"Id","Nombre","Telefono","Deuda"};
        
        DefaultTableModel modelo = new DefaultTableModel();

        jtClientes.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom(consulta);

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    Creditos.balanceCredito(Integer.parseInt(rs.getString("id_cliente")))
                });
            }
            jtClientes.setModel(modelo);
            
            jtClientes.getColumnModel().getColumn(0).setMaxWidth(0);
            jtClientes.getColumnModel().getColumn(0).setMinWidth(0);
            jtClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jtClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            TableColumnModel columnModel = jtClientes.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(30);
            columnModel.getColumn(1).setPreferredWidth(170);
            
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No fue posible conectar a la base de datos");
        }
        return modelo;
    }
    
    public static void insertarCliente(){

        if(!(jtxtNombreCliente.getText().isEmpty() && jtxtTelefonoCliente.getText().isEmpty())){
            
            try {
                
                if(actualizarCliente){
                    Conexion.queryUpdate("UPDATE clientes "
                        + "SET nombre = '" + jtxtNombreCliente.getText() + "', "
                        + "direccion = '" + jtxtDireccionCliente.getText() + "', "
                        + "codigoPostal = '" + jtxtCodigoPostal.getText() + "', "
                        + "telefono = '" + jtxtTelefonoCliente.getText() + "', "
                        + "RFC = '" + jtxtRFC.getText() + "', "
                        + "usoFactura = '" + jtxtFactura.getText() + "', "
                        + "metodoPago = '" + jtxtMetodoPago.getText() + "', "
                        + "email = '" + jtxtEmail.getText() + "' "
                        + "WHERE id_cliente = "+ jtClientes.getValueAt(jtClientes.getSelectedRow(), 0) + ";");
                    Conexion.commit();
                }else{
                    Conexion.queryExecute("INSERT INTO clientes"
                            + "(nombre,direccion,codigoPostal,telefono,RFC,usoFactura,metodoPago,email) "
                            + "VALUES('"+jtxtNombreCliente.getText()+"','"
                            +jtxtDireccionCliente.getText()+"','"
                            +jtxtCodigoPostal.getText()+"','"
                            +jtxtTelefonoCliente.getText()+"','"
                            +jtxtRFC.getText()+"','"
                            +jtxtFactura.getText()+"','"
                            +jtxtMetodoPago.getText()+"','"
                            +jtxtEmail.getText()+"');");
                    Conexion.commit();
                }
                Clientes.cargarTablaClientes("SELECT * FROM clientes");
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Ocurrio un error al intentar insertar o actualizar el cliente");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Inserta los campos obligatorios");
        }
    }
     
    public static void eliminarCliente() throws SQLException{
        int fila = jtClientes.getSelectedRow();
        if(fila != -1){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                    + "de eliminar este cliente? \nSe eliminara tambien sus creditos y movimientos","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                int id = Integer.parseInt(String.valueOf(jtClientes.getValueAt(fila, 0)));
                
                ResultSet rs = Conexion.selectFrom("SELECT id_credito from creditos WHERE fk_cliente = "+id+";");
                
                while(rs.next()){
                    Conexion.queryExecute("DELETE FROM abonos WHERE fk_credito = "+rs.getInt("id_credito")+";"); //ELIMINAMOS LOS ABONOS DEL CLIENTE
                }
                
                Conexion.queryExecute("DELETE FROM abonosgeneral WHERE fk_cliente = "+id+";");//ELIMINAMOS LOS ABONOSGENERAL DEL CLIENTE
                
                Conexion.queryExecute("DELETE FROM creditos WHERE fk_cliente = "+id+";"); // ELIMINAMOS LOS CREDITOS DEL CLIENTE
                
                Conexion.queryExecute("DELETE FROM citas WHERE fk_cliente = "+id+";"); // ELIMINAMOS LOS CREDITOS DEL CLIENTE
                
                Conexion.queryExecute("DELETE FROM clientes WHERE id_cliente = " + id + ";");//ELIMINAMOS AL CLIENTE
                
                Conexion.commit();
                
                cargarTablaClientes("SELECT * FROM clientes;");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Selecciona un cliente");
        }
    }
    
    public static void cargarCliente(){
        try{
            ResultSet rs = Conexion.selectFrom("SELECT * FROM clientes WHERE id_cliente = " + String.valueOf(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0)) + ";");
            int id_departamento;
            
            while(rs.next()){
                jtxtNombreCliente.setText(rs.getString("nombre"));
                jtxtDireccionCliente.setText(rs.getString("direccion"));
                jtxtCodigoPostal.setText(rs.getString("codigoPostal"));
                jtxtTelefonoCliente.setText(rs.getString("telefono"));
                jtxtRFC.setText(rs.getString("RFC"));
                jtxtFactura.setText(rs.getString("usoFactura"));
                jtxtMetodoPago.setText(rs.getString("metodoPago"));
                jtxtEmail.setText(rs.getString("email"));
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No fue posible cargar el producto al formulario");
        }
    }

    public static boolean isActualizarCliente() {
        return actualizarCliente;
    }

    public static void setActualizarCliente(boolean actualizarCliente) {
        Clientes.actualizarCliente = actualizarCliente;
    }
    
}
