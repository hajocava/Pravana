
package Clases;

import Frames.Interfaz;
import static Frames.Interfaz.jDateChooser2;
import static Frames.Interfaz.jTextArea1;
import static Frames.Interfaz.jTextArea2;
import static Frames.Interfaz.jTextField2;
import static Frames.Interfaz.jTextField3;
import static Frames.Interfaz.jtGastos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Gastos {
    public static void insertarGasto(){
        try {
            String fecha = Fecha.getFecha(jDateChooser2);
            String concepto = jTextField3.getText();
            String notas = jTextArea1.getText();
            float cantidad = 0;

            if(!concepto.isEmpty() && !fecha.isEmpty()){
                try {
                    cantidad = Float.parseFloat(jTextField2.getText());
                    if(cantidad > 0){
                    Conexion.queryExecute("INSERT INTO gastos (fecha,concepto,cantidad,fk_usuario,notas) "
                        + "VALUES ('"+fecha+"','"+concepto+"',"+cantidad+","+Interfaz.getUsuario()+",'"+notas+"');");
                        Conexion.commit();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ingresa cantidades mayores que cero");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"Verifica el campo cantidad");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ingresa los campos obligatorios");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Selecciona la fecha de cuando se realizo el gasto");
        }
        
    }
    
    public static void cargarNota(String query){
        try{
            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
                jTextArea2.setText(rs.getString("notas"));
            
        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo cargarNota");
        }
    }
    
    public static void cargarTablaGastos(String query){
        String titulos[] = {"Id","Concepto","Cantidad","Fecha","Usuario"};
        
        DefaultTableModel modelo = new DefaultTableModel();

        jtGastos.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("id_gasto"),
                    rs.getString("concepto"),
                    rs.getString("cantidad"),
                    rs.getString("fecha"),
                    rs.getString("nombre")
                });
            }
            jtGastos.setModel(modelo);
            
            jtGastos.getColumnModel().getColumn(0).setMaxWidth(0);
            jtGastos.getColumnModel().getColumn(0).setMinWidth(0);
            jtGastos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jtGastos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo cargarTablaGastos");
        }
    }
}
