
package Frames;

import Clases.CheckLogin;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    private void checkLogin(){
        if(!jtxtUsuario.getText().isEmpty() && !jtxtPassword.getText().isEmpty()){
            if(CheckLogin.checkLog(jtxtUsuario.getText(), jtxtPassword.getText())){
                Interfaz inicio = new Interfaz();
                inicio.setVisible(true);
                this.dispose();
            }
            else JOptionPane.showMessageDialog(null,"Acceso denegado, revise sus datos");
            
        }
        else JOptionPane.showMessageDialog(null,"Ingresa usuario y contraseña para iniciar sesion");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jpIniciar = new javax.swing.JPanel();
        jlbInicio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 178, 170));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Contacts_100px_1.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jtxtUsuario.setBackground(new java.awt.Color(32, 178, 170));
        jtxtUsuario.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtUsuario.setForeground(new java.awt.Color(250, 250, 250));
        jtxtUsuario.setBorder(null);
        jPanel1.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 200, 30));

        jLabel11.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(250, 250, 250));
        jLabel11.setText("Usuario");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(250, 250, 250));
        jLabel12.setText("Contraseña");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jtxtPassword.setBackground(new java.awt.Color(32, 178, 170));
        jtxtPassword.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtPassword.setForeground(new java.awt.Color(250, 250, 250));
        jtxtPassword.setBorder(null);
        jtxtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(jtxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 200, 30));

        jSeparator1.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator1.setForeground(new java.awt.Color(250, 250, 250));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 200, 10));

        jSeparator2.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator2.setForeground(new java.awt.Color(250, 250, 250));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 200, 10));

        jpIniciar.setBackground(new java.awt.Color(32, 178, 170));
        jpIniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 250, 250)));
        jpIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpIniciar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpIniciarMouseMoved(evt);
            }
        });
        jpIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpIniciarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpIniciarMouseExited(evt);
            }
        });
        jpIniciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbInicio.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jlbInicio.setForeground(new java.awt.Color(250, 250, 250));
        jlbInicio.setText("Iniciar");
        jpIniciar.add(jlbInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 0, 50, 40));

        jPanel1.add(jpIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 440));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pravana.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Barber_Scissors_80px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Hair_Dryer_80px.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Mirror_80px.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 178, 170));
        jLabel1.setText("...");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 40, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 90, 90));
        jLabel2.setText("nuestras manos");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(90, 90, 90));
        jLabel8.setText("El arte de la belleza en");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_32px.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 420, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jpIniciarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpIniciarMouseMoved
        jpIniciar.setBackground(new java.awt.Color(32, 139, 141));
    }//GEN-LAST:event_jpIniciarMouseMoved

    private void jpIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpIniciarMouseClicked
        checkLogin();
    }//GEN-LAST:event_jpIniciarMouseClicked

    private void jpIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpIniciarMouseExited
       jpIniciar.setBackground(new java.awt.Color(32, 178, 170));
    }//GEN-LAST:event_jpIniciarMouseExited

    private void jtxtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPasswordKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) checkLogin();
        
    }//GEN-LAST:event_jtxtPasswordKeyReleased

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlbInicio;
    private javax.swing.JPanel jpIniciar;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
