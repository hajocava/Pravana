
package Frames;

import Clases.Conexion;
import static Frames.Interfaz.jtCreditosCliente;
import static Frames.Interfaz.jtxtIdCliente;
import static Frames.Interfaz.jtxtIdUsuario;
import static Frames.Interfaz.jtxtNomCliente;
import static Frames.Interfaz.jtxtUsuarioCita;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class productosVenta extends javax.swing.JFrame {

    public productosVenta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void cargarTablaProductosVenta(String query){
        this.setVisible(true);

        String titulos[] = {"Nombre del producto","Cantidad","Precio","Importe"};

        DefaultTableModel modelo = new DefaultTableModel();

        jtProductosVenta.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{

            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("descripcion"),
                    rs.getString("cantidad"),
                    rs.getFloat("precio"),
                    rs.getInt("cantidad") * rs.getFloat("precio")
                });
            }
            jtProductosVenta.setModel(modelo);

            TableColumnModel columnModel = jtProductosVenta.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(200);

        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo cargarTablaProductosVenta");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBuscarProducto = new javax.swing.JPanel();
        jpOpcPuntoVenta = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jpComVenInvActualizar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductosVenta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpBuscarProducto.setBackground(new java.awt.Color(250, 250, 250));

        jpOpcPuntoVenta.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcPuntoVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 470, 10));

        jpComVenInvActualizar.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizarMouseClicked(evt);
            }
        });
        jpComVenInvActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(7, 131, 213));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Cerrar");
        jpComVenInvActualizar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_24px.png"))); // NOI18N
        jpComVenInvActualizar.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcPuntoVenta.add(jpComVenInvActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 10));

        jtProductosVenta.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtProductosVenta.setForeground(new java.awt.Color(80, 80, 80));
        jtProductosVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jtProductosVenta.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jtProductosVenta.setSelectionForeground(new java.awt.Color(30, 30, 30));
        jScrollPane1.setViewportView(jtProductosVenta);

        javax.swing.GroupLayout jpBuscarProductoLayout = new javax.swing.GroupLayout(jpBuscarProducto);
        jpBuscarProducto.setLayout(jpBuscarProductoLayout);
        jpBuscarProductoLayout.setHorizontalGroup(
            jpBuscarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBuscarProductoLayout.createSequentialGroup()
                .addComponent(jpOpcPuntoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpBuscarProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBuscarProductoLayout.setVerticalGroup(
            jpBuscarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBuscarProductoLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpOpcPuntoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        getContentPane().add(jpBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpComVenInvActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jpComVenInvActualizarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpBuscarProducto;
    private javax.swing.JPanel jpComVenInvActualizar;
    private javax.swing.JPanel jpOpcPuntoVenta;
    private javax.swing.JTable jtProductosVenta;
    // End of variables declaration//GEN-END:variables
}
