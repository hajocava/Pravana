
package Clases;

import static Clases.Conexion.cn;
import static Frames.Interfaz.jlbCantidadVentaCliente;
import static Frames.Interfaz.jlbTotalVentaCliente;
import static Frames.Interfaz.jsCantidadCliente;
import static Frames.Interfaz.jtProductosVentaCliente;
import static Frames.Interfaz.jtbPrecioMayoreoCliente;
import static Frames.Interfaz.jtxtCodProdCliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InsertarCompras {
    private static ArrayList<Cuenta> arrayCuenta = new ArrayList<Cuenta>();
    private static int contador = 1;
    private static float total = 0;
    
    public static void limpiarTabla(){
        String titulos[] = {"Contador","Código","Nombre del producto","Precio","Cantidad","Importe"};
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        jtProductosVentaCliente.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        jtProductosVentaCliente.setModel(modelo);
    
        jtProductosVentaCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        jtProductosVentaCliente.getColumnModel().getColumn(0).setMinWidth(0);
        jtProductosVentaCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jtProductosVentaCliente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jtProductosVentaCliente.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtProductosVentaCliente.getColumnModel().getColumn(2).setPreferredWidth(170);
        jtProductosVentaCliente.getColumnModel().getColumn(3).setPreferredWidth(40);
        jtProductosVentaCliente.getColumnModel().getColumn(4).setPreferredWidth(50);
        jtProductosVentaCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
    }
    
    public static void inicializarVenta(){
        
        limpiarTabla();
        
        jlbCantidadVentaCliente.setText("0");
        jlbTotalVentaCliente.setText("0.00");
        arrayCuenta.clear();
        contador = 1;
        total = 0;

    }
    
    public static boolean verificarInventario(String idProducto){
        try{
            int cantidad = Integer.parseInt(String.valueOf(jsCantidadCliente.getValue()));
            if(!idProducto.isEmpty()){
                
                String query = "SELECT existencia "
                        + "FROM productos "
                        + "WHERE id_producto = " + idProducto + ";";
                
                ResultSet rs = Conexion.selectFrom(query);
                
                if(rs.next()){
                    return true;
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
            boolean flag = verificarInventario(idProducto);
            if(flag){
                
                String query = null;
                if (jtbPrecioMayoreoCliente.isSelected()) {
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
                    int cant = (int) jsCantidadCliente.getValue();
                    float importe = cant * precio;
                    
                    Cuenta cuenta = new Cuenta(contador,codigo,descripcion,precio,cant,importe);
                    arrayCuenta.add(cuenta);
                    
                    contador++;
                }
            }
            jtxtCodProdCliente.setText("");
            jsCantidadCliente.setValue(1);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No fue posible encontrar el producto");
        }
        
        realizarCuenta();
    }
    
    public static void realizarCuenta(){
        
        String titulos[] = {"Contador","Codigo","Descripcion del producto","Precio","Cantidad","Importe"};
        DefaultTableModel modelo = new DefaultTableModel();
        jtProductosVentaCliente.setRowHeight(23);
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
        
        jtProductosVentaCliente.setModel(modelo);
        
        jtProductosVentaCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        jtProductosVentaCliente.getColumnModel().getColumn(0).setMinWidth(0);
        jtProductosVentaCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jtProductosVentaCliente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jtProductosVentaCliente.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtProductosVentaCliente.getColumnModel().getColumn(2).setPreferredWidth(170);
        jtProductosVentaCliente.getColumnModel().getColumn(3).setPreferredWidth(40);
        jtProductosVentaCliente.getColumnModel().getColumn(4).setPreferredWidth(50);
        jtProductosVentaCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
        
        jlbCantidadVentaCliente.setText(String.valueOf(cantidad));
        jlbTotalVentaCliente.setText(String.valueOf(total));
    }
    
    public static void eliminarProducto(){
        int fila = jtProductosVentaCliente.getSelectedRow();
        if(fila != -1){
            realizarCuenta();
            int idProducto = (int) jtProductosVentaCliente.getValueAt(fila, 0);
            for (int i = 0; i < arrayCuenta.size(); i++) {
                if(arrayCuenta.get(i).getContador() == idProducto){
                    
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
