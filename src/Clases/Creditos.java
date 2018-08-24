
package Clases;

import static Frames.Interfaz.jlbDeudaTotal;
import static Frames.Interfaz.jtAbonosCredito;
import static Frames.Interfaz.jtCreditosCliente;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Creditos {
    
    public static void insertarCredito(int id_cliente, int id_venta){
        Conexion.queryExecute("INSERT INTO creditos (fk_venta,fk_cliente,liquidado) "
                + "VALUES ("+id_venta+","+id_cliente+",0);");
    }
    
    public static void cargarTablaAbonos(int id_cliente){
        String titulosAbono[] = {"id abono","fecha","cantidad"};
        DefaultTableModel modeloAbonos = new DefaultTableModel();
        jtAbonosCredito.setRowHeight(23);
        modeloAbonos.setColumnIdentifiers(titulosAbono);
        
        try {
            ResultSet rs = Conexion.selectFrom("SELECT * FROM abonosgeneral WHERE fk_cliente = "+id_cliente+";");
            while(rs.next()){
                    modeloAbonos.addRow(new Object[]{
                    rs.getInt("id_abono"),
                    rs.getDate("fecha"),
                    rs.getFloat("cantidad")});
            }
            jtAbonosCredito.setModel(modeloAbonos);
            
            jtAbonosCredito.getColumnModel().getColumn(0).setMaxWidth(0);
            jtAbonosCredito.getColumnModel().getColumn(0).setMinWidth(0);
            jtAbonosCredito.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jtAbonosCredito.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        } catch (Exception e) {
            System.out.println("Ocurrio un error en el metodo cargarTablaAbonos");
        }
    }
    
    public static float balanceCredito(int id_cliente){
        float deudaTotal = 0;
        float totalAbonos = 0;
        
        String titulosCredito[] = {"id credito","Fecha","Total","Liquidado"};
        DefaultTableModel modeloCredito = new DefaultTableModel();
        jtCreditosCliente.setRowHeight(23);
        modeloCredito.setColumnIdentifiers(titulosCredito);
        
        Conexion.commit();
        
        try{
            ResultSet rsCredito = Conexion.selectFrom("SELECT id_credito, liquidado, date , total "
                    + "FROM creditos INNER JOIN ventas "
                    + "ON creditos.fk_venta = ventas.id_venta  "
                    + "WHERE fk_cliente = "+id_cliente+";");
            
            while(rsCredito.next())
            {
                modeloCredito.addRow(new Object[]{
                    rsCredito.getInt("id_credito"),
                    rsCredito.getDate("date"),
                    rsCredito.getFloat("total"),
                    rsCredito.getInt("liquidado")
                });
                
                deudaTotal += rsCredito.getFloat("total");
                
                ResultSet rsAbono = Conexion.selectFrom("SELECT id_abono, fecha, cantidad "
                    + "FROM abonos WHERE fk_credito = "+rsCredito.getInt("id_credito")+";");
                
                while(rsAbono.next()){
                    totalAbonos += rsAbono.getFloat("cantidad");
                }
                
            }
            jtCreditosCliente.setModel(modeloCredito);
            
            jtCreditosCliente.getColumnModel().getColumn(0).setMaxWidth(0);
            jtCreditosCliente.getColumnModel().getColumn(0).setMinWidth(0);
            jtCreditosCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jtCreditosCliente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            jtCreditosCliente.getColumnModel().getColumn(3).setMaxWidth(0);
            jtCreditosCliente.getColumnModel().getColumn(3).setMinWidth(0);
            jtCreditosCliente.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
            jtCreditosCliente.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
            
            deudaTotal -= totalAbonos;
            jlbDeudaTotal.setText(String.valueOf(deudaTotal));
            
        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo balanceCredito");
        }
        return deudaTotal;
    }
    
    public static boolean agregarAbono(int id_cliente, float abono){
        try {
            float balance = balanceCredito(id_cliente);
            if(abono <= balance){
                
                Conexion.queryExecute("INSERT INTO abonosgeneral(cantidad,fk_cliente) VALUES("+abono+","+id_cliente+");");
                
                ResultSet rsId = Conexion.selectFrom("SELECT MAX(id_abono) AS id FROM abonosgeneral");
                rsId.next();
                
                ResultSet rs = Conexion.selectFrom("SELECT id_credito,total "
                    + "FROM creditos INNER JOIN ventas "
                    + "ON creditos.fk_venta = ventas.id_venta WHERE fk_cliente = "+id_cliente+" AND liquidado = 0;");
                
                while(rs.next()){
                    float abonado = 0;
                    ResultSet consulta = Conexion.selectFrom("SELECT SUM(cantidad) AS abonado FROM abonos "
                            + "WHERE fk_credito = "+rs.getInt("id_credito")+";");
                    
                    consulta.next();
                    abonado = consulta.getFloat("abonado");
                    
                    float restante = rs.getFloat("total") - abonado;
                    
                    if(abono >= restante && abono > 0){
                        Conexion.queryExecute("INSERT INTO abonos (cantidad,fk_credito,fk_abonogeneral) "
                                + "VALUES(" + restante + "," + rs.getInt("id_credito") + "," + rsId.getInt("id") + ");");
                        
                        Conexion.queryExecute("UPDATE creditos "
                                + "SET liquidado = 1 "
                                + "WHERE id_credito = " + rs.getInt("id_credito") + ";");
                        
                        abono -= restante;
                        
                    }else if(abono < restante){
                        Conexion.queryExecute("INSERT INTO abonos (cantidad,fk_credito,fk_abonogeneral) "
                                + "VALUES(" + abono + "," + rs.getInt("id_credito") + "," + rsId.getInt("id") + ");");
                        break;
                    }
                }
                Conexion.commit();
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"El abono supera la deuda del cliente");
            }
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error en el metodo agregarAbono");
        }
        
        return false;
    }
    
    public static void eliminarCredito(){
        int fila = jtCreditosCliente.getSelectedRow();
        if(fila != -1){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                    + "de eliminar este credito?","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                int id = Integer.parseInt(jtCreditosCliente.getValueAt(fila, 0).toString());
                String query = "DELETE FROM abonos WHERE fk_credito = " + id + ";";
                Conexion.queryExecute(query);

                query = "DELETE FROM creditos WHERE id_credito = " + id + ";";
                Conexion.queryExecute(query);

                Conexion.commit();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un credito");
        }
    }
    
    public static void eliminarAbono(){
        int fila = jtAbonosCredito.getSelectedRow();
        if(fila != -1){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                    + "de eliminar este abono?","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                int id = Integer.parseInt(String.valueOf(jtAbonosCredito.getValueAt(fila, 0)));
                String query = "DELETE FROM abonos WHERE fk_abonogeneral = " + id + ";";
                Conexion.queryExecute(query);
                
                query = "DELETE FROM abonosgeneral WHERE id_abono = " + id + ";";
                Conexion.queryExecute(query);
                
                Conexion.commit();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Selecciona un abono");
        }
    }
    
    
    
}