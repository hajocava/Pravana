
package Clases;

import static Clases.Conexion.cn;
import Frames.Cobrar;
import Frames.Interfaz;
import static Frames.Interfaz.jdcFechaCompraCliente;
import static Frames.Interfaz.jtClientes;
import static Frames.Interfaz.jtVentas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class VentasClientes {
    
    public static int insertarVenta(String metodoPago){
        int id_venta = 0;
        try {
            InsertarCompras.realizarCuenta();
            
            String query = "INSERT INTO ventas"
                            + "(total,metodoPago,fk_usuario) "
                            + "VALUES("+ InsertarCompras.getTotal() 
                            +",'"+ metodoPago +"',"
                            + Interfaz.getUsuario() + ");";
            
            PreparedStatement statement = cn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.execute();
            
            ResultSet resultado = statement.getGeneratedKeys();
            
            if(resultado.next()){
                id_venta = resultado.getInt(1);
                Conexion.queryExecute("UPDATE ventas SET date = '" + Fecha.getFecha(jdcFechaCompraCliente) + "' WHERE id_venta = " + id_venta + ";");
                
                
                ArrayList<Cuenta> arrayCuenta = InsertarCompras.getArrayCuenta();
                String id_producto = null;
                int cantidad = 0;
                float precio = 0;
                
                for (int i = 0; i < arrayCuenta.size(); i++) {
                    id_producto = arrayCuenta.get(i).getCodigoProducto();
                    cantidad = arrayCuenta.get(i).getCantidad();
                    precio = arrayCuenta.get(i).getPrecio();
                    
                    Conexion.queryExecute("INSERT INTO venta_productos "
                    + "(fk_producto,fk_venta,cantidad,precio) VALUES ('" + id_producto + "'," + id_venta + "," + cantidad + "," + precio +");");
                }
                
                int id_cliente = Integer.parseInt(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
                Creditos.insertarCredito(id_cliente, id_venta);
            }
            
            
            
        }catch (SQLException ex) {
            Logger.getLogger(Cobrar.class.getName()).log(Level.SEVERE, null, ex);
            try {
                    cn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Cobrar.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(null,"No se pudo completar la venta");
        }
        return id_venta;
    }
    
    
    public static void cargarTablaVentas(String query){
        String titulos[] = {"Id venta","Fecha","Metodo de pago","Usuario en sesion","Total"};
        
        DefaultTableModel modelo = new DefaultTableModel();

        jtVentas.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("id_venta"),
                    rs.getString("date"),
                    rs.getString("metodoPago"),
                    rs.getString("nombre"),
                    rs.getString("total")
                });
            }
            jtVentas.setModel(modelo);
            
            TableColumnModel columnModel = jtVentas.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(30);
            
        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo cargarTablaVentas");
        }
    }
    
    public static void cargarTablaProductosVenta(int id_venta){
        String titulos[] = {"Nombre del producto","cantidad"};
        
        DefaultTableModel modelo = new DefaultTableModel();

        jtVentas.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom("SELECT descripcion,cantidad "
                    + "FROM venta_productos INNER JOIN productos "
                    + "ON venta_productos.fk_producto = productos.id_producto "
                    + "WHERE fk_venta = "+id_venta+";");

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("descripcion"),
                    rs.getString("cantidad")
                });
            }
            jtVentas.setModel(modelo);
            
            TableColumnModel columnModel = jtVentas.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(30);
            
        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo cargarTablaProductosVenta");
        }
    }
    
    public static void eliminarVenta() throws SQLException{
        int fila = jtVentas.getSelectedRow();
        if(fila != -1){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                    + "de eliminar esta venta? \nSe eliminara tambien sus creditos y movimientos","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                int id_venta = Integer.parseInt(String.valueOf(jtVentas.getValueAt(fila, 0)));
                
                ResultSet rs = Conexion.selectFrom("SELECT id_credito from creditos WHERE fk_venta = "+id_venta+";");
                
                if(rs.next()){
                    Conexion.queryExecute("DELETE FROM abonos WHERE fk_credito = "+rs.getInt("id_credito")+";");
                }
                
                
                Conexion.queryExecute("DELETE FROM creditos WHERE fk_venta = "+id_venta+";"); 
                
                Conexion.queryExecute("DELETE FROM venta_productos WHERE fk_venta = "+id_venta+";"); 
                
                Conexion.queryExecute("DELETE FROM ventas WHERE id_venta = " + id_venta + ";");
                
                Conexion.commit();
                
                cargarTablaVentas("SELECT id_venta, date, total, metodoPago, nombre "
                    + "FROM ventas INNER JOIN usuarios "
                + "ON ventas.fk_usuario = usuarios.id_usuario "
                + "WHERE date > (SELECT DATE_SUB(NOW(),INTERVAL 7 DAY));");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Selecciona un cliente");
        }
    }
    
}
