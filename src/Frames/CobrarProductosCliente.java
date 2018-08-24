
package Frames;

import Clases.Clientes;
import Clases.Conexion;
import static Clases.Conexion.cn;
import Clases.Creditos;
import Clases.Cuenta;
import Clases.Fecha;
import Clases.InsertarCompras;
import Clases.Ventas;
import Clases.VentasClientes;
import Clases.puntoVenta;
import static Frames.Interfaz.jdcFechaCompraCliente;
import static Frames.Interfaz.jdcFechaFinal;
import static Frames.Interfaz.jtClientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CobrarProductosCliente extends javax.swing.JFrame {
    
    private static String metodoActual = "inicio";
    private static String metodoAnterior = "";
    
    public CobrarProductosCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        jlbTotal.setText(String.valueOf(InsertarCompras.getTotal()));
        
        int fila = jtClientes.getSelectedRow();
        jlbNombreCliente.setText(String.valueOf(jtClientes.getValueAt(fila, 1)));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCliente = new javax.swing.JPanel();
        jpOpcPuntoVenta1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jpEliminar1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jpComVenInvActualizar = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jlbNombreCliente = new javax.swing.JLabel();
        jlbTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpCliente.setBackground(new java.awt.Color(250, 250, 250));
        jpCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpOpcPuntoVenta1.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcPuntoVenta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 480, 10));

        jpEliminar1.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar1MouseClicked(evt);
            }
        });
        jpEliminar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(7, 131, 213));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Cancelar");
        jpEliminar1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 20));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_24px_1.png"))); // NOI18N
        jpEliminar1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta1.add(jpEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jpComVenInvActualizar.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizarMouseClicked(evt);
            }
        });
        jpComVenInvActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(7, 131, 213));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cobrar");
        jpComVenInvActualizar.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_24px.png"))); // NOI18N
        jpComVenInvActualizar.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta1.add(jpComVenInvActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, -1));

        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 480, 10));

        jpCliente.add(jpOpcPuntoVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 520, -1));

        jlbNombreCliente.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbNombreCliente.setForeground(new java.awt.Color(80, 80, 80));
        jlbNombreCliente.setText("Nombre del cliente");
        jpCliente.add(jlbNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 400, -1));

        jlbTotal.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jlbTotal.setForeground(new java.awt.Color(209, 73, 114));
        jlbTotal.setText("0.00");
        jpCliente.add(jlbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 170, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(209, 73, 114));
        jLabel5.setText("$");
        jpCliente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(80, 80, 80));
        jLabel6.setText("Total a cobrar");
        jpCliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Decker", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(80, 80, 80));
        jLabel7.setText("Compra credito");
        jpCliente.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(80, 80, 80));
        jLabel8.setText("Cliente:");
        jpCliente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        getContentPane().add(jpCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jpEliminar1MouseClicked

    private void jpComVenInvActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizarMouseClicked
        VentasClientes.insertarVenta("credito");
        
        if(Conexion.commit()){
            JOptionPane.showMessageDialog(null,"Venta realizada");
        }else{
            JOptionPane.showMessageDialog(null,"Venta no realizada \n"
                    + "Ocurrio un error al procesar la venta");
        }
        
        InsertarCompras.inicializarVenta();
        this.dispose();
    }//GEN-LAST:event_jpComVenInvActualizarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jlbNombreCliente;
    private javax.swing.JLabel jlbTotal;
    private javax.swing.JPanel jpCliente;
    private javax.swing.JPanel jpComVenInvActualizar;
    private javax.swing.JPanel jpEliminar1;
    private javax.swing.JPanel jpOpcPuntoVenta1;
    // End of variables declaration//GEN-END:variables
}
