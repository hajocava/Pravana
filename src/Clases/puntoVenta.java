
package Clases;

import static Clases.Conexion.cn;
import static Frames.Interfaz.jlbCantidad;
import static Frames.Interfaz.jlbTotal;
import static Frames.Interfaz.jsCantidad;
import static Frames.Interfaz.jtPuntoVenta;
import static Frames.Interfaz.jtbPrecio;
import static Frames.Interfaz.jtxtIdProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class puntoVenta {
    
    private static ArrayList<Cuenta> arrayCuenta = new ArrayList<Cuenta>();
    private static int contador = 1;
    private static float total = 0;
    
    public static void limpiarTabla(){
        String titulos[] = {"Contador","Código","Nombre del producto","Precio","Cantidad","Importe"};
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        jtPuntoVenta.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        jtPuntoVenta.setModel(modelo);
    
        jtPuntoVenta.getColumnModel().getColumn(0).setMaxWidth(0);
        jtPuntoVenta.getColumnModel().getColumn(0).setMinWidth(0);
        jtPuntoVenta.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jtPuntoVenta.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jtPuntoVenta.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtPuntoVenta.getColumnModel().getColumn(2).setPreferredWidth(170);
        jtPuntoVenta.getColumnModel().getColumn(3).setPreferredWidth(40);
        jtPuntoVenta.getColumnModel().getColumn(4).setPreferredWidth(50);
        jtPuntoVenta.getColumnModel().getColumn(5).setPreferredWidth(50);
    }
    
    public static void inicializarVenta(){
        
        limpiarTabla();
        
        jlbCantidad.setText("0");
        jlbTotal.setText("0.00");
        arrayCuenta.clear();
        contador = 1;
        total = 0;

    }
    
    public static boolean verificarInventario(String idProducto){
        try{
            int cantidad = Integer.parseInt(String.valueOf(jsCantidad.getValue()));
            System.out.println("idProducto en verificarInventario: "+idProducto);
            if(!idProducto.isEmpty()){
                
                String query = "SELECT existencia "
                        + "FROM productos "
                        + "WHERE id_producto = " + idProducto + ";";
                
                ResultSet rs = Conexion.selectFrom(query);
                
                System.out.println(query);

                if(rs.next()){
                    System.out.println("entre al if");
                    
                    int existencia = rs.getInt("existencia");
                    
                    System.out.println("pase existencia: "+ existencia);
                    
                    if(existencia > 0){
                        System.out.println("entre al if de existencia");
                        if(existencia >= cantidad){
                            System.out.println("pase existencia > cantidad");
                            try {
                                System.out.println("entre al try");
                                Conexion.queryUpdate("UPDATE productos "
                                        + "SET existencia = existencia - " + cantidad + " "
                                        + "WHERE id_producto = '" + idProducto + "';");
//                                cn.commit();
                                
                                System.out.println("ejecutando la consulta");
                                return true;
                            } catch (Exception e) {
                                cn.rollback();
                                e.printStackTrace();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"La cantidad supera existencias, "
                                    + "tenemos "+existencia+" piezas disponibles");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Producto agotado");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Producto no identificado");
                }
            }else{
                JOptionPane.showMessageDialog(null,"No ingresaste el codigo de barras");
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No fue posible conectarse a la base de datos");
        }
        return false;
    }
    
    public static void agregarProducto(String idProducto){
        
        try{
            System.out.println("idProducto en agregarProducto: "+idProducto);
            boolean flag = verificarInventario(idProducto);
            if(flag){
                
                String query = null;
                if (jtbPrecio.isSelected()) {
                    query = "SELECT id_producto, descripcion, mayoreo AS precio "
                            + "FROM productos "
                            + "WHERE id_producto = " + idProducto +";";
                }else{
                    query = "SELECT id_producto, descripcion, publico AS precio "
                            + "FROM productos "
                            + "WHERE id_producto = " + idProducto +";";
                }
                
                ResultSet rs = Conexion.selectFrom(query);
                while(rs.next())
                {
                    String codigo = rs.getString("id_producto");
                    String descripcion = rs.getString("descripcion");
                    float precio = rs.getFloat("precio");
                    int cant = (int) jsCantidad.getValue();
                    float importe = cant * precio;
                    
                    Cuenta cuenta = new Cuenta(contador,codigo,descripcion,precio,cant,importe);
                    arrayCuenta.add(cuenta);
                    
                    contador++;
                }
            }
            jtxtIdProducto.setText("");
            jsCantidad.setValue(1);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No fue posible encontrar el producto");
        }
        
        realizarCuenta();
    }
    
    public static void realizarCuenta(){
        
        String titulos[] = {"Contador","Codigo","Descripcion del producto","Precio","Cantidad","Importe"};
        DefaultTableModel modelo = new DefaultTableModel();
        jtPuntoVenta.setRowHeight(23);
        modelo.setColumnIdentifiers(titulos);
        
        int cantidad = 0;
        total = 0;
        
        for (int i = 0; i < arrayCuenta.size(); i++) {
            cantidad += arrayCuenta.get(i).getCantidad();
            total += arrayCuenta.get(i).getImporte();
            
            modelo.addRow(new Object[]{
                arrayCuenta.get(i).getContador(),
                arrayCuenta.get(i).getCodigoProducto(),
                arrayCuenta.get(i).getNombreProducto(),
                arrayCuenta.get(i).getPrecio(),
                arrayCuenta.get(i).getCantidad(),
                arrayCuenta.get(i).getImporte()
            });
        }
        
        jtPuntoVenta.setModel(modelo);
        
        jtPuntoVenta.getColumnModel().getColumn(0).setMaxWidth(0);
        jtPuntoVenta.getColumnModel().getColumn(0).setMinWidth(0);
        jtPuntoVenta.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jtPuntoVenta.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jtPuntoVenta.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtPuntoVenta.getColumnModel().getColumn(2).setPreferredWidth(170);
        jtPuntoVenta.getColumnModel().getColumn(3).setPreferredWidth(40);
        jtPuntoVenta.getColumnModel().getColumn(4).setPreferredWidth(50);
        jtPuntoVenta.getColumnModel().getColumn(5).setPreferredWidth(50);
        
        jlbCantidad.setText(String.valueOf(cantidad));
        jlbTotal.setText(String.valueOf(total));
    }
    
    public static void eliminarProducto(){
        int fila = jtPuntoVenta.getSelectedRow();
        if(fila != -1){
            realizarCuenta();
            int idProducto = (int) jtPuntoVenta.getValueAt(fila, 0);
            for (int i = 0; i < arrayCuenta.size(); i++) {
                if(arrayCuenta.get(i).getContador() == idProducto){
                    
                    try {
                        Conexion.queryUpdate("UPDATE productos "
                        + "SET existencia = existencia + " + arrayCuenta.get(i).getCantidad() + " "
                        + "WHERE id_producto = "+ arrayCuenta.get(i).getCodigoProducto() + ";");
                    } catch (Exception e) {
                        System.out.println("No se actualizo la cantidad del producto en inventario");
                    }
                    arrayCuenta.remove(i);
                    realizarCuenta();
                    break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un producto");
        }
    }

    public static float getTotal() {
        return total;
    }

    public static ArrayList<Cuenta> getArrayCuenta() {
        return arrayCuenta;
    }
    
    
}
