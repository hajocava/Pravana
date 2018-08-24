
package Frames;

import Clases.Conexion;
import static Frames.Interfaz.jtxtIdCliente;
import static Frames.Interfaz.jtxtIdUsuario;
import static Frames.Interfaz.jtxtNomCliente;
import static Frames.Interfaz.jtxtUsuarioCita;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuariosFrame extends javax.swing.JFrame {

    public UsuariosFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTablaUsuarios("SELECT id_usuario,nombre FROM usuarios;");
    }
    
    void cargarTablaUsuarios(String query){
        String titulos[] = {"Id","Nombre"};
        
        DefaultTableModel modelo = new DefaultTableModel();

        jtUsuarios.setRowHeight(23);

        modelo.setColumnIdentifiers(titulos);

        try{
            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                modelo.addRow(new Object[]{
                    rs.getString("id_usuario"),
                    rs.getString("nombre")
                });
            }
            jtUsuarios.setModel(modelo);
            
            jtUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
            jtUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
            jtUsuarios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jtUsuarios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            
        }catch (Exception e){
            System.out.println("Ocurrio un error en el metodo cargarTablaClientes del Frame ClietnesFrame");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBuscarProducto = new javax.swing.JPanel();
        jpOpcPuntoVenta = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jpEliminar = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jpComVenInvActualizar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpBuscarProducto.setBackground(new java.awt.Color(250, 250, 250));

        jpOpcPuntoVenta.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcPuntoVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 470, 10));

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
        jpEliminar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_24px.png"))); // NOI18N
        jpEliminar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta.add(jpEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

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
        jLabel22.setText("Agregar");
        jpComVenInvActualizar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_24px.png"))); // NOI18N
        jpComVenInvActualizar.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcPuntoVenta.add(jpComVenInvActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 140, -1));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 10));

        jtUsuarios.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtUsuarios.setForeground(new java.awt.Color(80, 80, 80));
        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jtUsuarios.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jtUsuarios.setSelectionForeground(new java.awt.Color(30, 30, 30));
        jScrollPane1.setViewportView(jtUsuarios);

        jLabel1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setText("Seleccione un usuario");

        jtxtBuscar.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtBuscar.setForeground(new java.awt.Color(80, 80, 80));
        jtxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jpBuscarProductoLayout = new javax.swing.GroupLayout(jpBuscarProducto);
        jpBuscarProducto.setLayout(jpBuscarProductoLayout);
        jpBuscarProductoLayout.setHorizontalGroup(
            jpBuscarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBuscarProductoLayout.createSequentialGroup()
                .addComponent(jpOpcPuntoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpBuscarProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpBuscarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addComponent(jtxtBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBuscarProductoLayout.setVerticalGroup(
            jpBuscarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBuscarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpOpcPuntoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        getContentPane().add(jpBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jpEliminarMouseClicked

    private void jpComVenInvActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizarMouseClicked
        int fila = jtUsuarios.getSelectedRow();
        if(fila != -1){
            jtxtIdUsuario.setText(jtUsuarios.getValueAt(fila, 0).toString());
            jtxtUsuarioCita.setText(jtUsuarios.getValueAt(fila, 1).toString());
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Debes seleccionar un usuario");
        }
    }//GEN-LAST:event_jpComVenInvActualizarMouseClicked

    private void jtxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyReleased
        cargarTablaUsuarios("SELECT id_usuario,nombre "
                + "FROM usuarios "
                + "WHERE nombre LIKE '%"+jtxtBuscar.getText()+"%';");
    }//GEN-LAST:event_jtxtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpBuscarProducto;
    private javax.swing.JPanel jpComVenInvActualizar;
    private javax.swing.JPanel jpEliminar;
    private javax.swing.JPanel jpOpcPuntoVenta;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTextField jtxtBuscar;
    // End of variables declaration//GEN-END:variables
}
