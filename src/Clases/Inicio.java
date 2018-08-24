
package Clases;

import static Frames.Interfaz.jpNotificacionesCitas;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import static Frames.Interfaz.jpNotificacionesProductos;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Inicio {
    public static void cargarNotificaciones(){
        jpNotificacionesProductos.removeAll();
        jpNotificacionesCitas.removeAll();
        try {
            int contadorProductos = 0;
            int contadorCitas = 0;
            String query = "SELECT descripcion,existencia FROM productos WHERE existencia <= minimo;";
            ResultSet rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                JPanel panel = new JPanel();
                panel.setBackground(new java.awt.Color(250, 250, 250));
                JLabel label;
                
                if(rs.getInt("existencia") > 0){
                    label = new JLabel("El producto "+rs.getString("descripcion")+" esta escaso");
                }else{
                    label = new JLabel("El producto "+rs.getString("descripcion")+" esta agotado");
                }
                
 
                label.setFont(new java.awt.Font("Decker", 1, 14));
                label.setForeground(new java.awt.Color(80, 80, 80));
                label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                label.setSize(panel.getSize());
                

                panel.add(label);

                panel.setBorder(BorderFactory.createLineBorder(Color.black));

                jpNotificacionesProductos.add(panel);
                jpNotificacionesProductos.updateUI();
                contadorProductos++;
            }
            if(contadorProductos == 0){
                JPanel panel = new JPanel();

                JLabel label = new JLabel("Sin notificaciones");

                panel.add(label);

                panel.setBorder(BorderFactory.createLineBorder(Color.black));

                jpNotificacionesProductos.add(panel);
                jpNotificacionesProductos.updateUI();
            }
            
            query = "SELECT fecha,clientes.nombre AS nombre "
                    + "FROM citas "
                    + "INNER JOIN clientes ON citas.fk_cliente = clientes.id_cliente "
                    + "WHERE fecha >= CURDATE() AND fecha <= DATE_ADD(CURDATE(), INTERVAL 1 DAY);";
            
            rs = Conexion.selectFrom(query);

            while(rs.next())
            {
                JPanel panel = new JPanel();
                panel.setBackground(new java.awt.Color(250, 250, 250));
                JLabel label;
                
                label = new JLabel("Tienes una cita mañana con "+rs.getString("nombre"));
                
                label.setFont(new java.awt.Font("Decker", 1, 14));
                label.setForeground(new java.awt.Color(80, 80, 80));
                label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                label.setSize(panel.getSize());

                panel.add(label);

                panel.setBorder(BorderFactory.createLineBorder(Color.black));

                jpNotificacionesCitas.add(panel);
                jpNotificacionesCitas.updateUI();
                contadorCitas++;
            }
            
            if(contadorCitas == 0){
                JPanel panel = new JPanel();

                JLabel label = new JLabel("Sin notificaciones");

                panel.add(label);

                panel.setBorder(BorderFactory.createLineBorder(Color.black));

                jpNotificacionesCitas.add(panel);
                jpNotificacionesCitas.updateUI();
            }
        } catch (Exception e) {
            
        }     
        
        
    }
}
