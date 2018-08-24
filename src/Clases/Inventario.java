package Clases;

import static Clases.Conexion.cn;
import static Frames.Interfaz.jcbDepartamento;
import static Frames.Interfaz.jcbDepartamentos;
import static Frames.Interfaz.jlbCantidadProductos;
import static Frames.Interfaz.jlbCostoInversion;
import static Frames.Interfaz.jtInventario;
import static Frames.Interfaz.jtxtCodigo;
import static Frames.Interfaz.jtxtCosto;
import static Frames.Interfaz.jtxtDescripcion;
import static Frames.Interfaz.jtxtExistencia;
import static Frames.Interfaz.jtxtMayoreo;
import static Frames.Interfaz.jtxtMinimo;
import static Frames.Interfaz.jtxtPublico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Inventario {
    
    private static boolean actualizarProducto = false;
    
    public static void cargarTablaProductos(String consulta){
        

        String titulos[] = {"Id","Nombre del producto","Costo","Mayoreo","Público","Mínimo","Existencia"};
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        jtInventario.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom(consulta);

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("id_producto"),
                    rs.getString("descripcion"),
                    rs.getString("costo"),
                    rs.getString("mayoreo"),
                    rs.getString("publico"),
                    rs.getString("minimo"),
                    rs.getString("existencia")
                });
                
            }
            jtInventario.setModel(modelo);
            
            TableColumnModel columnModel = jtInventario.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(60);
            columnModel.getColumn(1).setPreferredWidth(170);
            columnModel.getColumn(5).setPreferredWidth(40);
            columnModel.getColumn(6).setPreferredWidth(50);
            
            contarProductos("SELECT costo, existencia, (costo*existencia) AS total FROM productos;");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No fue posible conectar a la base de datos");
        }
        
    }
    
    public static void cargarDepartamentos( ) {
        try {
            jcbDepartamento.removeAllItems();
            jcbDepartamentos.removeAllItems();
            ResultSet rs = Conexion.selectFrom("SELECT * FROM departamento");
            while(rs.next()){
                jcbDepartamento.addItem(rs.getString("nombre_departamento"));
                jcbDepartamentos.addItem(rs.getString("nombre_departamento"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al cargar los departamentos");
        }
    } 
   
    public static void contarProductos(String query){
        int existencia = 0;
        int costo = 0;
        
        try{
            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                costo += rs.getFloat("total");
                existencia += rs.getInt("existencia");
            }
            jlbCostoInversion.setText(String.valueOf(costo));
            jlbCantidadProductos.setText(String.valueOf(existencia));
        }catch(Exception e){
            
        }
    }
    
    public static void insertarProducto(){
        
        if(!(jtxtCodigo.getText().isEmpty() && jtxtDescripcion.getText().isEmpty()
                && jtxtCosto.getText().isEmpty())){
            
            try {
                ResultSet rs = Conexion.selectFrom("SELECT * FROM departamento");
                int idDepartamento = 0;

                while(rs.next())
                {
                    if(rs.getString("nombre_departamento").equals(jcbDepartamento.getSelectedItem())){
                        idDepartamento = rs.getInt("id_departamento");
                        break;
                    }
                }
                
                if(actualizarProducto){
                    Conexion.queryUpdate("UPDATE productos "
                        + "SET id_producto = '" + jtxtCodigo.getText() + "', "
                        + "descripcion = '" + jtxtDescripcion.getText() + "', "
                        + "costo = " + jtxtCosto.getText() + ", "
                        + "mayoreo = " + jtxtMayoreo.getText() + ", "
                        + "publico = " + jtxtPublico.getText() + ", "
                        + "minimo = " + jtxtMinimo.getText() + ", "
                        + "existencia = " + jtxtExistencia.getText() + ", "
                        + "fk_departamento = " + idDepartamento + " "
                        + "WHERE id_producto = "+ jtInventario.getValueAt(jtInventario.getSelectedRow(), 0) + ";");
                    Conexion.commit();
                }else{
                    Conexion.queryExecute("INSERT INTO productos(id_producto,descripcion,"
                        + "costo,mayoreo,publico,minimo,existencia,fk_departamento) "+ "VALUES('"
                        +jtxtCodigo.getText()+"','"
                        +jtxtDescripcion.getText()+"',"
                        +Float.parseFloat(jtxtCosto.getText())+","
                        +Float.parseFloat(jtxtMayoreo.getText())+","
                        +Float.parseFloat(jtxtPublico.getText())+","
                        +Integer.parseInt(jtxtMinimo.getText())+","
                        +Integer.parseInt(jtxtExistencia.getText())+","
                        +idDepartamento+");");
                    Conexion.commit();
                }
                Inventario.cargarTablaProductos("SELECT * FROM productos");
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Ocurrio un error al intentar insertar o actualizar el producto");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Inserta los campos obligatorios");
        }
    }
    
    public static void eliminarProducto() throws SQLException{
        int fila = jtInventario.getSelectedRow();
        if(fila != -1){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                    + "de eliminar este producto?","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                String id = String.valueOf(jtInventario.getValueAt(fila, 0));
                String query = "DELETE FROM productos WHERE id_producto = '" + id + "';";
                Conexion.queryExecute(query);
                Conexion.commit();
                
                cargarTablaProductos("SELECT * FROM productos;");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Selecciona un producto");
        }
    }
    
    public static void cargarProducto(){
        try{
            ResultSet rs = Conexion.selectFrom("SELECT * FROM productos WHERE id_producto = " + String.valueOf(jtInventario.getValueAt(jtInventario.getSelectedRow(), 0)) + ";");
            int id_departamento;
            
            while(rs.next()){
                jtxtCodigo.setText(rs.getString("id_producto"));
                jtxtDescripcion.setText(rs.getString("descripcion"));
                jtxtCosto.setText(rs.getString("costo"));
                jtxtMayoreo.setText(rs.getString("mayoreo"));
                jtxtPublico.setText(rs.getString("publico"));
                jtxtMinimo.setText(rs.getString("minimo"));
                jtxtExistencia.setText(rs.getString("existencia"));
                
                cargarDepartamentos();

                rs = Conexion.selectFrom("SELECT nombre_departamento FROM departamento WHERE id_departamento = " + rs.getInt("fk_departamento") + ";");
                String nombre;

                while(rs.next()){
                    nombre = rs.getString("nombre_departamento");
                    for (int i = 0; i < jcbDepartamento.getItemCount(); i++) {
                        if(nombre.equals(jcbDepartamento.getItemAt(i))){
                            jcbDepartamento.setSelectedIndex(i);
                        }
                    }
                }
                
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No fue posible cargar el producto al formulario");
        }
    }
    
    public static void buscarFiltrado(){
        try {
            if(jcbDepartamentos.getSelectedItem().equals("Sin filtro")){
                cargarTablaProductos("SELECT * FROM productos;");
            }else{
                ResultSet rs = Conexion.selectFrom("select * from departamento");
                int idDepartamento = 0;

                while(rs.next()){
                    if(rs.getString("nombre_departamento").equals(jcbDepartamentos.getSelectedItem())){
                        idDepartamento = rs.getInt("id_departamento");
                        cargarTablaProductos("SELECT * FROM productos WHERE fk_departamento = " + idDepartamento +";");
                        contarProductos("SELECT costo, existencia, (costo*existencia) AS total FROM productos WHERE fk_departamento = " + idDepartamento +";");
                        break;
                    }
                }
            }   
        } catch (Exception e) {}
    }
    
    public static void setActualizarProducto(boolean actualizarProducto) {
        Inventario.actualizarProducto = actualizarProducto;
    }

    public static boolean isActualizarProducto() {
        return actualizarProducto;
    }

    

    
    
}
