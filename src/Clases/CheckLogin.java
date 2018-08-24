
package Clases;

import Frames.Interfaz;
import java.sql.ResultSet;


public class CheckLogin {
    public static boolean checkLog(String usuario, String pass){
       
        try {
             ResultSet rs = Conexion.selectFrom("SELECT * FROM usuarios "
                + "WHERE nombre = '" + usuario + "' AND password = MD5('" + pass + "') AND habilitado = 1;");
            
             if(rs.next()){
                 Interfaz.setUsuario(rs.getInt("id_usuario"));
                 if(Integer.parseInt(rs.getString("tipo"))  == 1){
                     Interfaz.setAdministrador(true);
                 }else{
                     Interfaz.setAdministrador(false);
                 }
                 return true;
            }
        } catch (Exception e) {}

        return false;
    }
    
}
