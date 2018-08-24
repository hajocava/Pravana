package Clases;

import Frames.Cobrar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Conexion {
    private static String dataBase = "pravana";
    private static String user = "root";
    private static String pass = "";
    private static String host = "localhost:3306";
    private static String server = "jdbc:mysql://"+host+"/"+dataBase;
    public static Connection cn = getConexionTransact();
    
    
    public static Connection getConexionTransact(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(server,user,pass);
            cn.setAutoCommit(false);
        }catch(Exception e){
            System.out.println(e);
        }
        return cn;
    }
    
    public static ResultSet selectFrom(String consulta){
        Statement st;
        ResultSet datos = null;
        try{
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
    public static void queryExecute(String query){
        try {
            Statement statement = cn.createStatement();
            statement.execute(query);
            System.out.println("Comando ejecutado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al ejecutar el comando");
        }
    }
    
    public static boolean queryUpdate(String query){
        try {
            Statement statement = cn.createStatement();
            statement.executeUpdate(query);
            System.out.println("update ejecutado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error al ejecutar update ");
            return false;
        }
    }
    
    public static boolean commit(){
        try {
            cn.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cobrar.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            rollback();
            return false;
        }
    }
    
    public static boolean rollback(){
        try {
            cn.rollback();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void respaldarBD(){
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            String ruta = fc.getSelectedFile().getAbsolutePath() + ".sql";
            try {
                String comando = "C:\\xampp\\mysql\\bin\\mysqldump --opt -u" + user + " -B " + dataBase + " -r " + ruta;
                Runtime rt = Runtime.getRuntime();
                rt.exec(comando);
                JOptionPane.showMessageDialog(null,"Exportado correctamente");
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ocurrio un error al realizar el Backup");
            }
        }
    }
    
    public static void restaurarBD(){
        
    }
    
    public static void reiniciarBD(){
        queryExecute("DROP DATABASE pravana;");
        commit();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/","root","");
            Statement statement = cn.createStatement();
            statement.executeUpdate("CREATE DATABASE pravana;");
            System.out.println("Base de datos creada");
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error al crear la base de datos");
        }
        cn = getConexionTransact();
        queryExecute("CREATE TABLE clientes(" +
            "    id_cliente INT PRIMARY KEY AUTO_INCREMENT," +
            "    nombre VARCHAR(255)," +
            "    direccion VARCHAR(255)," +
            "    codigoPostal VARCHAR(255)," +
            "    telefono VARCHAR(255)," +
            "    rfc VARCHAR(255)," +
            "    usoFactura VARCHAR(255)," +
            "    metodoPago VARCHAR(255)," +
            "    email VARCHAR(255)" +
            ");");
        queryExecute("CREATE TABLE departamento(" +
            "    id_departamento INT PRIMARY KEY AUTO_INCREMENT," +
            "    nombre_departamento VARCHAR(255)" +
            ");");
        queryExecute("CREATE TABLE productos(" +
            "    id_producto VARCHAR(255) PRIMARY KEY," +
            "    descripcion VARCHAR(255)," +
            "    costo FLOAT(25,2)," +
            "    mayoreo FLOAT(25,2)," +
            "    publico FLOAT(25,2)," +
            "    minimo INT(25)," +
            "    existencia INT(25)," +
            "    fk_departamento INT," +
            "    FOREIGN KEY (fk_departamento) REFERENCES departamento (id_departamento)" +
            ");");
        queryExecute("CREATE TABLE usuarios(" +
            "    id_usuario INT PRIMARY KEY AUTO_INCREMENT," +
            "    nombre VARCHAR(255)," +
            "    password VARCHAR(40)," +
            "    habilitado TINYINT(1)," +
            "    tipo TINYINT(1)" +
            ");");
        queryExecute("CREATE TABLE ventas(" +
            "    id_venta INT PRIMARY KEY AUTO_INCREMENT," +
            "    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "    total FLOAT(25,2)," +
            "    metodoPago VARCHAR(255)," +
            "    fk_usuario INT," +
            "    FOREIGN KEY (fk_usuario) REFERENCES usuarios (id_usuario)" +
            ");");
        queryExecute("CREATE TABLE venta_productos(" +
            "    fk_producto VARCHAR(255) NOT NULL," +
            "    cantidad INT(11)," +
            "    precio FLOAT(25,2)," +
            "    fk_venta INT NOT NULL," +
            "    FOREIGN KEY (fk_producto) REFERENCES productos (id_producto)," +
            "    FOREIGN KEY (fk_venta) REFERENCES ventas (id_venta)" +
            ");");
        queryExecute("CREATE TABLE creditos(" +
            "    id_credito INT PRIMARY KEY AUTO_INCREMENT," +
            "    fk_venta INT NOT NULL," +
            "    fk_cliente INT NOT NULL," +
            "    liquidado TINYINT(1)," +
            "    FOREIGN KEY (fk_venta) REFERENCES ventas (id_venta)," +
            "    FOREIGN KEY (fk_cliente) REFERENCES clientes (id_cliente)" +
            ");");
        queryExecute("CREATE TABLE abonosgeneral(" +
            "    id_abono INT PRIMARY KEY AUTO_INCREMENT," +
            "    cantidad FLOAT(25,2)," +
            "    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "    fk_cliente INT NOT NULL," +
            "    FOREIGN KEY (fk_cliente) REFERENCES clientes (id_cliente)" +
            ");");
        queryExecute("CREATE TABLE abonos(" +
            "    id_abono INT PRIMARY KEY AUTO_INCREMENT," +
            "    cantidad FLOAT(25,2)," +
            "    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "    fk_credito INT NOT NULL," +
            "    fk_abonogeneral INT NOT NULL," +
            "    FOREIGN KEY (fk_credito) REFERENCES creditos(id_credito)," +
            "    FOREIGN KEY (fk_abonogeneral) REFERENCES abonosgeneral(id_abono)" +
            ");");
        queryExecute("CREATE TABLE movimientos(" +
            "    id_movimiento INT PRIMARY KEY AUTO_INCREMENT," +
            "    tipo VARCHAR(255)," +
            "    fecha DATE," +
            "    fk_usuario INT," +
            "    FOREIGN KEY (fk_usuario) REFERENCES usuarios (id_usuario)" +
            ");");
        queryExecute("CREATE TABLE citas(" +
            "    id_cita INT PRIMARY KEY AUTO_INCREMENT," +
            "    fecha DATE," +
            "    fk_cliente INT," +
            "    fk_usuario INT," +
            "    notas VARCHAR(255)," +
            "    FOREIGN KEY (fk_cliente) REFERENCES clientes (id_cliente)," +
            "    FOREIGN KEY (fk_usuario) REFERENCES usuarios (id_usuario)" +
            ");");
        queryExecute("CREATE TABLE gastos(" +
            "    id_gasto INT PRIMARY KEY AUTO_INCREMENT," +
            "    concepto VARCHAR(255)," +
            "    cantidad FLOAT(25,2)," +
            "    fecha DATE," +
            "    fk_usuario INT," +
            "    notas VARCHAR(255)," +
            "    FOREIGN KEY (fk_usuario) REFERENCES usuarios (id_usuario)" +
            ");");
        
        queryExecute("INSERT INTO usuarios (nombre,password,tipo,habilitado) VALUES ('admin',MD5('123456'),1,1);");
        commit();
    }
    
}
