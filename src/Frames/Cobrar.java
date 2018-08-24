
package Frames;

import Clases.Clientes;
import Clases.Conexion;
import static Clases.Conexion.cn;
import Clases.Creditos;
import Clases.Ventas;
import Clases.iTextPDF;
import Clases.puntoVenta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cobrar extends javax.swing.JFrame {
    
    private static String metodoActual = "inicio";
    private static String metodoAnterior = "";
    
    public Cobrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        jpCliente.setVisible(false);
        jlbTotal.setText(String.valueOf(puntoVenta.getTotal()));
        
        seleccionarMetodoPago("efectivo");
    }
    
    void cargarTabla(String query){
        DefaultTableModel modelo = Clientes.cargarTablaClientes(query);
        jtBuscarCliente.setModel(modelo);
        
        jtBuscarCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        jtBuscarCliente.getColumnModel().getColumn(0).setMinWidth(0);
        jtBuscarCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jtBuscarCliente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jtBuscarCliente.getColumnModel().getColumn(2).setMaxWidth(0);
        jtBuscarCliente.getColumnModel().getColumn(2).setMinWidth(0);
        jtBuscarCliente.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        jtBuscarCliente.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        
        jtBuscarCliente.getColumnModel().getColumn(1).setPreferredWidth(130);
    }
    
    void cambiarVentana(String ventana){
        if(ventana.equals("cobrar")){
            jpCliente.setVisible(false);
            jpCobrar.setVisible(true);
        }else if(ventana.equals("cliente")){
            jpCliente.setVisible(true);
            jpCobrar.setVisible(false);
        }
    }
    
    void seleccionarMetodoPago(String ventana){
        metodoAnterior = metodoActual;
        exited(metodoActual);
        
        switch(ventana)
        {
            case "efectivo":
            {
                jpEfectivo.setBackground(new java.awt.Color(240, 240, 240));
                metodoActual = "efectivo";
                break;
            }
            case "tarjeta":
            {
                jpTarjeta.setBackground(new java.awt.Color(240, 240, 240));
                metodoActual = "tarjeta";
                break;
            }
            case "credito":
            {
                jpCredito.setBackground(new java.awt.Color(240, 240, 240));
                metodoActual = "credito";
                break;
            }
        }
        
    }
    
    void moved(String ventana){
        switch(ventana)
        {
            case "efectivo":
            {
                jpEfectivo.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "tarjeta":
            {
                jpTarjeta.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "credito":
            {
                jpCredito.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
        }
    }
    
    void exited(String ventana){
        switch(ventana)
        {
            case "efectivo":
            {
                jpEfectivo.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "tarjeta":
            {
                jpTarjeta.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "credito":
            {
                jpCredito.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCobrar = new javax.swing.JPanel();
        jpOpcPuntoVenta = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jpEliminar = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jpComVenInvNuevo = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpTarjeta = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jpCredito = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jpEfectivo = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jlbTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtBuscarCliente = new javax.swing.JTable();
        jpOpcPuntoVenta1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jpEliminar1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jpComVenInvActualizar = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jtxtBuscarCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpCobrar.setBackground(new java.awt.Color(250, 250, 250));
        jpCobrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpOpcPuntoVenta.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcPuntoVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 480, 10));

        jpEliminar.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminarMouseClicked(evt);
            }
        });
        jpEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(7, 131, 213));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Cancelar");
        jpEliminar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcPuntoVenta.add(jpEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jpComVenInvNuevo.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevoMouseClicked(evt);
            }
        });
        jpComVenInvNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(7, 131, 213));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Cobrar");
        jpComVenInvNuevo.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 20));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Buying_24px.png"))); // NOI18N
        jpComVenInvNuevo.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta.add(jpComVenInvNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, -1));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 480, 10));

        jpCobrar.add(jpOpcPuntoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 520, -1));

        jpTarjeta.setBackground(new java.awt.Color(250, 250, 250));
        jpTarjeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpTarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTarjeta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpTarjetaMouseMoved(evt);
            }
        });
        jpTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTarjetaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpTarjetaMouseExited(evt);
            }
        });
        jpTarjeta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 153, 153));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Credit_Card_80px.png"))); // NOI18N
        jpTarjeta.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel75.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(153, 153, 153));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Tarjeta");
        jpTarjeta.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jpCobrar.add(jpTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 140, 130));

        jpCredito.setBackground(new java.awt.Color(250, 250, 250));
        jpCredito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCredito.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpCreditoMouseMoved(evt);
            }
        });
        jpCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpCreditoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpCreditoMouseExited(evt);
            }
        });
        jpCredito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(153, 153, 153));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_User_80px.png"))); // NOI18N
        jpCredito.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel77.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(153, 153, 153));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Crédito");
        jpCredito.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jpCobrar.add(jpCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 140, 130));

        jpEfectivo.setBackground(new java.awt.Color(250, 250, 250));
        jpEfectivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpEfectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEfectivo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpEfectivoMouseMoved(evt);
            }
        });
        jpEfectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEfectivoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpEfectivoMouseExited(evt);
            }
        });
        jpEfectivo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(153, 153, 153));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Coins_80px.png"))); // NOI18N
        jpEfectivo.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel79.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(153, 153, 153));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Efectivo");
        jpEfectivo.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jpCobrar.add(jpEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 140, 130));

        jlbTotal.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jlbTotal.setForeground(new java.awt.Color(209, 73, 114));
        jlbTotal.setText("0.00");
        jpCobrar.add(jlbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 170, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(80, 80, 80));
        jLabel2.setText("Método de pago");
        jpCobrar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(80, 80, 80));
        jLabel4.setText("Total a cobrar");
        jpCobrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(209, 73, 114));
        jLabel5.setText("$");
        jpCobrar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        getContentPane().add(jpCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 430));

        jpCliente.setBackground(new java.awt.Color(250, 250, 250));
        jpCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtBuscarCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtBuscarCliente.setForeground(new java.awt.Color(80, 80, 80));
        jtBuscarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtBuscarCliente.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jtBuscarCliente.setSelectionForeground(new java.awt.Color(30, 30, 30));
        jScrollPane1.setViewportView(jtBuscarCliente);

        jpCliente.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 200));

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

        jpCliente.add(jpOpcPuntoVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 520, -1));

        jtxtBuscarCliente.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtBuscarCliente.setForeground(new java.awt.Color(80, 80, 80));
        jtxtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarClienteKeyReleased(evt);
            }
        });
        jpCliente.add(jtxtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 450, -1));

        jLabel1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setText("Escribe el nombre del cliente y seleccionalo en la tabla");
        jpCliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        getContentPane().add(jpCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpComVenInvNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevoMouseClicked
        Ventas.insertarVenta(metodoActual);
        if(Conexion.commit()){
            JOptionPane.showMessageDialog(null,"Venta realizada");
            
            //Pregunta si desea imprimir nota
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Deseas imprimir nota de venta?","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                iTextPDF.generarNota(metodoActual,0);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Venta no realizada \n"
                    + "Ocurrio un error al procesar la venta");
        }
        
        puntoVenta.inicializarVenta();
        this.dispose();
    }//GEN-LAST:event_jpComVenInvNuevoMouseClicked

    private void jpEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jpEliminarMouseClicked

    private void jpEfectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEfectivoMouseClicked
        seleccionarMetodoPago("efectivo");
    }//GEN-LAST:event_jpEfectivoMouseClicked

    private void jpTarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTarjetaMouseClicked
        seleccionarMetodoPago("tarjeta");
    }//GEN-LAST:event_jpTarjetaMouseClicked

    private void jpCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCreditoMouseClicked
        seleccionarMetodoPago("credito");
        cargarTabla("SELECT * FROM clientes;");
        cambiarVentana("cliente");
    }//GEN-LAST:event_jpCreditoMouseClicked

    private void jpEfectivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEfectivoMouseExited
        if(!metodoActual.equalsIgnoreCase("efectivo"))
            exited("efectivo");        // TODO add your handling code here:
    }//GEN-LAST:event_jpEfectivoMouseExited

    private void jpTarjetaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTarjetaMouseExited
        if(!metodoActual.equalsIgnoreCase("tarjeta"))
            exited("tarjeta");        // TODO add your handling code here:
    }//GEN-LAST:event_jpTarjetaMouseExited

    private void jpCreditoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCreditoMouseExited
        if(!metodoActual.equalsIgnoreCase("credito"))
            exited("credito");        // TODO add your handling code here:
    }//GEN-LAST:event_jpCreditoMouseExited

    private void jpEfectivoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEfectivoMouseMoved
        moved("efectivo");        // TODO add your handling code here:
    }//GEN-LAST:event_jpEfectivoMouseMoved

    private void jpTarjetaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTarjetaMouseMoved
        moved("tarjeta");        // TODO add your handling code here:
    }//GEN-LAST:event_jpTarjetaMouseMoved

    private void jpCreditoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCreditoMouseMoved
        moved("credito");        // TODO add your handling code here:
    }//GEN-LAST:event_jpCreditoMouseMoved

    private void jpEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jpEliminar1MouseClicked

    private void jpComVenInvActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizarMouseClicked
        int fila = jtBuscarCliente.getSelectedRow();
        if(fila != -1){
            int id_cliente = Integer.parseInt(jtBuscarCliente.getValueAt(fila, 0).toString());
            
            int id_venta = Ventas.insertarVenta(metodoActual);
            Creditos.insertarCredito(id_cliente, id_venta);
            
            if(Conexion.commit()){
                JOptionPane.showMessageDialog(null,"Venta realizada");
                //Pregunta si desea imprimir nota
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Deseas imprimir nota de venta?","Warning",dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){
                    iTextPDF.generarNota(metodoActual, id_cliente);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Venta no realizada \n"
                        + "Ocurrio un error al procesar la venta");
            }
            
            puntoVenta.inicializarVenta();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"No seleccionaste ningun cliente");
        }
    }//GEN-LAST:event_jpComVenInvActualizarMouseClicked

    private void jtxtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarClienteKeyReleased
        cargarTabla("SELECT * FROM clientes "
                + "WHERE nombre LIKE '%"+jtxtBuscarCliente.getText()+"%';");
    }//GEN-LAST:event_jtxtBuscarClienteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jlbTotal;
    private javax.swing.JPanel jpCliente;
    private javax.swing.JPanel jpCobrar;
    private javax.swing.JPanel jpComVenInvActualizar;
    private javax.swing.JPanel jpComVenInvNuevo;
    private javax.swing.JPanel jpCredito;
    private javax.swing.JPanel jpEfectivo;
    private javax.swing.JPanel jpEliminar;
    private javax.swing.JPanel jpEliminar1;
    private javax.swing.JPanel jpOpcPuntoVenta;
    private javax.swing.JPanel jpOpcPuntoVenta1;
    private javax.swing.JPanel jpTarjeta;
    private javax.swing.JTable jtBuscarCliente;
    private javax.swing.JTextField jtxtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}
