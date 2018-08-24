
package Clases;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Fecha {
    
    
    public static String getFecha(JDateChooser jd){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        if(jd.getDate()!=null){
            return formato.format(jd.getDate());
        }else{
            return null;
        }
    }
    public static java.util.Date SetDate(String fecha){
        SimpleDateFormat formato_del_texto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaE = null;
        try {
            fechaE = formato_del_texto.parse(fecha);
            return fechaE;
        } catch (Exception e) {
            return null;
        }
    }
}
