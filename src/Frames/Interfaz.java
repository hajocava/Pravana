
package Frames;

import Clases.Citas;
import Clases.Clientes;
import Clases.Conexion;
import Clases.Creditos;
import Clases.datosEmpresa;
import Clases.Fecha;
import Clases.Gastos;
import Clases.ImageRender;
import Clases.Inicio;
import Clases.InsertarCompras;
import Clases.Inventario;
import static Clases.Inventario.contarProductos;
import Clases.Usuarios;
import Clases.Ventas;
import Clases.iTextPDF;
import Clases.puntoVenta;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Interfaz extends javax.swing.JFrame {
    
    private static String ventanaActual = "inicio";
    private static String ventanaAnterior = "";
    boolean productosBajos = false;
    boolean buscarFiltrado = false;
    boolean ventasMes = false;
    private static int usuario;
    private static boolean administrador;
    public static String rutaLogo = "";
    
    public Interfaz() {
        initComponents();
        iniciarInterfaz();
        Inicio.cargarNotificaciones();

    }
    
    void iniciarInterfaz(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jtCreditosCliente.setDefaultRenderer(Object.class, new ImageRender());
        
        jpInicio.setVisible(false);
        jpPuntoVenta.setVisible(false);
        jpInventario.setVisible(false);
        jpClientes.setVisible(false);
        jpAgenda.setVisible(false);
        jpNuevoProducto.setVisible(false);
        jpEstadoCuenta.setVisible(false);
        jpNuevoCliente.setVisible(false);
        jpCorte.setVisible(false);
        jpGastos.setVisible(false);
        jpEmpresa.setVisible(false);
        jpUsuarios.setVisible(false);
        jpBaseDatos.setVisible(false);
        jpLicencia.setVisible(false);
        jpVentas.setVisible(false);
        jpNuevaCita.setVisible(false);
        jpAdministrador.setVisible(false);
        jpInsertarCompras.setVisible(false);
        
        if(administrador){
            jpmAdministrador.setVisible(true);
        }else{
            jpmAdministrador.setVisible(false);
        }
        
        
        
        puntoVenta.inicializarVenta();
        
        cambiarVentana("inicio");
    }
    
    void cambiarVentana(String ventana){
        ventanaAnterior = ventanaActual;
        exited(ventanaActual);
        
        switch(ventanaActual)
        {
            case "inicio":
            {
                jpInicio.setVisible(false);
                break;
            }
            case "puntoVenta":
            {
                jpPuntoVenta.setVisible(false);
                break;
            }
            case "inventario":
            {
                jpInventario.setVisible(false);
                break;
            }
            case "clientes":
            {
                jpClientes.setVisible(false);
                break;
            }
            case "agenda":
            {
                jpAgenda.setVisible(false);
                break;
            }
            case "administrador":
            {
                jpAdministrador.setVisible(false);
                break;
            }
            case "nuevoProducto":
            {
                jpNuevoProducto.setVisible(false);
                break;
            }
            case "estadoCuenta":
            {
                jpEstadoCuenta.setVisible(false);
                break;
            }
            case "nuevoCliente":
            {
                jpNuevoCliente.setVisible(false);
                break;
            }
            case "corte":
            {
                jpCorte.setVisible(false);
                break;
            }
            case "gastos":
            {
                jpGastos.setVisible(false);
                break;
            }
            case "empresa":
            {
                jpEmpresa.setVisible(false);
                break;
            }
            case "usuarios":
            {
                jpUsuarios.setVisible(false);
                break;
            }
            case "baseDatos":
            {
                jpBaseDatos.setVisible(false);
                break;
            }
            case "licencia":
            {
                jpLicencia.setVisible(false);
                break;
            }
            case "ventas":
            {
                jpVentas.setVisible(false);
                break;
            }
            case "nuevaCita":
            {
                jpNuevaCita.setVisible(false);
                break;
            }
            case "insertarCompras":
            {
                jpInsertarCompras.setVisible(false);
                break;
            }
        }
        
        switch(ventana)
        {
            case "inicio":
            {
                jpmInicio.setBackground(new java.awt.Color(240, 240, 240));
                jpInicio.setVisible(true);
                ventanaActual = "inicio";
                break;
            }
            case "puntoVenta":
            {
                jpmPuntoVenta.setBackground(new java.awt.Color(240, 240, 240));
                jpPuntoVenta.setVisible(true);
                ventanaActual = "puntoVenta";
                break;
            }
            case "inventario":
            {
                jpmInventario.setBackground(new java.awt.Color(240, 240, 240));
                jpInventario.setVisible(true);
                ventanaActual = "inventario";
                break;
            }
            case "clientes":
            {
                jpmClientes.setBackground(new java.awt.Color(240, 240, 240));
                jpClientes.setVisible(true);
                ventanaActual = "clientes";
                break;
            }
            case "agenda":
            {
                jpmAgenda.setBackground(new java.awt.Color(240, 240, 240));
                jpAgenda.setVisible(true);
                ventanaActual = "agenda";
                break;
            }
            case "administrador":
            {
                jpmAdministrador.setBackground(new java.awt.Color(240, 240, 240));
                jpAdministrador.setVisible(true);
                ventanaActual = "administrador";
                break;
            }
            case "nuevoProducto":
            {
                jpNuevoProducto.setVisible(true);
                ventanaActual = "nuevoProducto";
                break;
            }
            case "estadoCuenta":
            {
                jpEstadoCuenta.setVisible(true);
                ventanaActual = "estadoCuenta";
                break;
            }
            case "nuevoCliente":
            {
                jpNuevoCliente.setVisible(true);
                ventanaActual = "nuevoCliente";
                break;
            }
            case "corte":
            {
                jpCorte.setVisible(true);
                ventanaActual = "corte";
                break;
            }
            case "gastos":
            {
                jpGastos.setVisible(true);
                ventanaActual = "gastos";
                break;
            }
            case "empresa":
            {
                jpEmpresa.setVisible(true);
                ventanaActual = "empresa";
                datosEmpresa.cargarDatosEmpresa();
                break;
            }
            case "usuarios":
            {
                jpUsuarios.setVisible(true);
                ventanaActual = "usuarios";
                break;
            }
            case "baseDatos":
            {
                jpBaseDatos.setVisible(true);
                ventanaActual = "baseDatos";
                break;
            }
            case "licencia":
            {
                jpLicencia.setVisible(true);
                ventanaActual = "licencia";
                break;
            }
            case "ventas":
            {
                jpVentas.setVisible(true);
                ventanaActual = "ventas";
                break;
            }
            case "nuevaCita":
            {
                jpNuevaCita.setVisible(true);
                ventanaActual = "nuevaCita";
                break;
            }
            case "insertarCompras":
            {
                jpInsertarCompras.setVisible(true);
                ventanaActual = "insertarCompras";
                break;
            }
        }
        
    }
    
    void moved(String ventana){
        switch(ventana)
        {
            case "inicio":
            {
                jpmInicio.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "puntoVenta":
            {
                jpmPuntoVenta.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "inventario":
            {
                jpmInventario.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "clientes":
            {
                jpmClientes.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "agenda":
            {
                jpmAgenda.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "administrador":
            {
                jpmAdministrador.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "corte":
            {
                jpmCorte.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "gastos":
            {
                jpmGastos.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "empresa":
            {
                jpmEmpresa.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "usuarios":
            {
                jpmUsuarios.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "baseDatos":
            {
                jpmBaseDatos.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "licencia":
            {
                jpmLicencia.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "ventas":
            {
                jpmVentas.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
            case "nuevaCita":
            {
                jpNuevaCita.setBackground(new java.awt.Color(240, 240, 240));
                break;
            }
        }
    }
    
    void exited(String ventana){
        switch(ventana)
        {
            case "inicio":
            {
                jpmInicio.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "puntoVenta":
            {
                jpmPuntoVenta.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "inventario":
            {
                jpmInventario.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "clientes":
            {
                jpmClientes.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "agenda":
            {
                jpmAgenda.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "administrador":
            {
                jpmAdministrador.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "corte":
            {
                jpmCorte.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "gastos":
            {
                jpmGastos.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "empresa":
            {
                jpmEmpresa.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "usuarios":
            {
                jpmUsuarios.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "baseDatos":
            {
                jpmBaseDatos.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "licencia":
            {
                jpmLicencia.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "ventas":
            {
                jpmVentas.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
            case "nuevaCita":
            {
                jpNuevaCita.setBackground(new java.awt.Color(250, 250, 250));
                break;
            }
        }
    }
    
    void limpiarFormularios(){
        //FORMULARIO NUEVO PRODUCTO
        
        
        //FORMULARIO NUEVO CLIENTE
        
    }    
    
    public void abonar(){
        int fila = jtClientes.getSelectedRow();
        int id_cliente = Integer.parseInt(jtClientes.getValueAt(fila, 0).toString());
        float deuda = Creditos.balanceCredito(id_cliente);
        
        if (deuda > 0) {
            try {
                float abono = Float.parseFloat(JOptionPane.showInputDialog(null,"Cantidad"));
                if(abono > 0){
                    boolean flag = Creditos.agregarAbono(id_cliente,abono);
                    if (flag) {
                        Creditos.balanceCredito(id_cliente);
                        Creditos.cargarTablaAbonos(id_cliente);
                        
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog (null, "Deseas imprimir recibo de abono?","Warning",dialogButton);

                        if(dialogResult == JOptionPane.YES_OPTION){
                            JFileChooser fc = new JFileChooser();
                            fc.setSelectedFile(new File("Recibo"));
                            if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                                String ruta = fc.getSelectedFile().getAbsolutePath()+".pdf";
                                iTextPDF.generarRecibo(ruta, jtClientes.getValueAt(fila, 1).toString(), deuda, abono);
                                
                                try{
                                    File objetofile = new File (ruta);
                                    Desktop.getDesktop().open(objetofile);
                                }catch (IOException ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Ingresa cantidades positivas");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Ingresa solo numeros");
            }
        }else{
            JOptionPane.showMessageDialog(null,"El cliente no tiene adeudos");
        }
    }

    public static int getUsuario() {
        return usuario;
    }

    public static void setUsuario(int usuario) {
        Interfaz.usuario = usuario;
    }

    public static boolean isAdministrador() {
        return administrador;
    }

    public static void setAdministrador(boolean administrador) {
        Interfaz.administrador = administrador;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenu = new javax.swing.JPanel();
        jpmAdministrador = new javax.swing.JPanel();
        jlbAdministrador = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jpmPuntoVenta = new javax.swing.JPanel();
        jlbPuntoVenta = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jpmInventario = new javax.swing.JPanel();
        jlbInventario = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jpmClientes = new javax.swing.JPanel();
        jlbClientes = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jpmInicio = new javax.swing.JPanel();
        jlbInicio = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jpmAgenda = new javax.swing.JPanel();
        jlbAgenda = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jlbInicio2 = new javax.swing.JLabel();
        jpmVentas = new javax.swing.JPanel();
        jlbAdministrador1 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jpEstadoCuenta = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jpOpcInventario6 = new javax.swing.JPanel();
        jSeparator15 = new javax.swing.JSeparator();
        jpComVenInvNuevo9 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jpComVenInvActualizar6 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jpEliminar15 = new javax.swing.JPanel();
        jLabel175 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jpEliminar16 = new javax.swing.JPanel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jlbalgo = new javax.swing.JLabel();
        jlbNombreCliente = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jpEliminarAbono = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jpEliminarCredito = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jpVerProductosCredito = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jpEliminar14 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jpVentas = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        btnProductosBajos5 = new javax.swing.JPanel();
        jlbVerVentas = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        btnProductosVenta = new javax.swing.JPanel();
        jlbVerVentas1 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JPanel();
        jlbVerVentas2 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JPanel();
        jlbVerVentas7 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jpPuntoVenta = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpOpcPuntoVenta = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jpEliminar = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jpComVenInvNuevo = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbBuscar = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jbtnCancelarVenta = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jpComVenInvActualizar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jpClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jpOpcInventario2 = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jpEliminar6 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jpComVenInvNuevo4 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jpComVenInvActualizar3 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jpComVenInvNuevo5 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jtxtBuscarCliente = new javax.swing.JTextField();
        jpBaseDatos = new javax.swing.JPanel();
        jpRestaurar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpReiniciar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpRespaldar = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jpInicio = new javax.swing.JPanel();
        btnProductosBajos2 = new javax.swing.JPanel();
        jlbProductosBajos2 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jlbNotificaciones = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jlbNotificaciones1 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jlbNotificaciones2 = new javax.swing.JLabel();
        jpGastos = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        btnProductosVenta1 = new javax.swing.JPanel();
        jlbVerVentas3 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        btnProductosVenta2 = new javax.swing.JPanel();
        jlbVerVentas4 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        btnProductosVenta3 = new javax.swing.JPanel();
        jlbVerVentas5 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jLabel68 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jLabel159 = new javax.swing.JLabel();
        btnProductosVenta4 = new javax.swing.JPanel();
        jlbVerVentas6 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jpInsertarCompras = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jpOpcPuntoVenta1 = new javax.swing.JPanel();
        jSeparator22 = new javax.swing.JSeparator();
        jpEliminar1 = new javax.swing.JPanel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jpComVenInvNuevo1 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jbBuscar1 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jbtnCancelarVenta1 = new javax.swing.JPanel();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jpBtnAgregarProductoCliente = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jpAdministrador = new javax.swing.JPanel();
        jpmLicencia = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jpmCorte = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jpmBaseDatos = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jpmGastos = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jpmEmpresa = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jpmUsuarios = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jpCorte = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel217 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel182 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel179 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel215 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel216 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jpOpcInventario7 = new javax.swing.JPanel();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jpEliminar9 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jpEliminar10 = new javax.swing.JPanel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jpInventario = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpOpcInventario1 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jpEliminar4 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jpComVenInvNuevo2 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jpComVenInvActualizar2 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jpEliminar5 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        btnProductosBajos = new javax.swing.JPanel();
        jlbProductosBajos = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jpNuevoProducto = new javax.swing.JPanel();
        jpOpcInventario4 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        btnRegresarInventario = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        btnGuardarProducto = new javax.swing.JPanel();
        jlbGuardarProducto = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jpDatosProducto = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnProductosBajos1 = new javax.swing.JPanel();
        jlbProductosBajos1 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jpAgenda = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jpOpcInventario3 = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        jpEliminar8 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jpComVenInvNuevo6 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jScrollPane10 = new javax.swing.JScrollPane();
        jpNuevaCita = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        btnProductosBajos3 = new javax.swing.JPanel();
        jlbProductosBajos3 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        btnProductosBajos4 = new javax.swing.JPanel();
        jlbProductosBajos4 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        btnProductosBajos6 = new javax.swing.JPanel();
        jlbProductosBajos5 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jpNuevoCliente = new javax.swing.JPanel();
        jpOpcInventario5 = new javax.swing.JPanel();
        jSeparator13 = new javax.swing.JSeparator();
        btnRegresarInventario1 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        btnGuardarProducto1 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jpDatosProducto1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jpUsuarios = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jpComVenInvNuevo3 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jpCambiarPass = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jpComVenInvActualizar5 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jpComVenInvActualizar7 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jpComVenInvActualizar8 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jpEmpresa = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jpComVenInvNuevo7 = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jpLicencia = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel136 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpMenu.setBackground(new java.awt.Color(250, 250, 250));
        jpMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpmAdministrador.setBackground(new java.awt.Color(250, 250, 250));
        jpmAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmAdministrador.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmAdministradorMouseMoved(evt);
            }
        });
        jpmAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmAdministradorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmAdministradorMouseExited(evt);
            }
        });
        jpmAdministrador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbAdministrador.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbAdministrador.setForeground(new java.awt.Color(153, 153, 153));
        jlbAdministrador.setText("Administrador");
        jpmAdministrador.add(jlbAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Customer_24px.png"))); // NOI18N
        jpmAdministrador.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jpMenu.add(jpmAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 40));

        jpmPuntoVenta.setBackground(new java.awt.Color(250, 250, 250));
        jpmPuntoVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmPuntoVenta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmPuntoVentaMouseMoved(evt);
            }
        });
        jpmPuntoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmPuntoVentaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmPuntoVentaMouseExited(evt);
            }
        });
        jpmPuntoVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbPuntoVenta.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbPuntoVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlbPuntoVenta.setText("Punto de venta");
        jpmPuntoVenta.add(jlbPuntoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Buying_24px.png"))); // NOI18N
        jpmPuntoVenta.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpMenu.add(jpmPuntoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 40));

        jpmInventario.setBackground(new java.awt.Color(250, 250, 250));
        jpmInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmInventarioMouseMoved(evt);
            }
        });
        jpmInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmInventarioMouseExited(evt);
            }
        });
        jpmInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbInventario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbInventario.setForeground(new java.awt.Color(153, 153, 153));
        jlbInventario.setText("Inventario");
        jpmInventario.add(jlbInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trolley_24px_1.png"))); // NOI18N
        jpmInventario.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jpMenu.add(jpmInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 40));

        jpmClientes.setBackground(new java.awt.Color(250, 250, 250));
        jpmClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmClientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmClientesMouseMoved(evt);
            }
        });
        jpmClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmClientesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmClientesMouseExited(evt);
            }
        });
        jpmClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbClientes.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbClientes.setForeground(new java.awt.Color(153, 153, 153));
        jlbClientes.setText("Clientes");
        jpmClientes.add(jlbClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Business_Building_24px.png"))); // NOI18N
        jpmClientes.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jpMenu.add(jpmClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, 40));

        jpmInicio.setBackground(new java.awt.Color(250, 250, 250));
        jpmInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmInicio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmInicioMouseMoved(evt);
            }
        });
        jpmInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmInicioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmInicioMouseExited(evt);
            }
        });
        jpmInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbInicio.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbInicio.setForeground(new java.awt.Color(153, 153, 153));
        jlbInicio.setText("Inicio");
        jpmInicio.add(jlbInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Home_24px_1.png"))); // NOI18N
        jpmInicio.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpMenu.add(jpmInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, 40));

        jpmAgenda.setBackground(new java.awt.Color(250, 250, 250));
        jpmAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmAgenda.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmAgendaMouseMoved(evt);
            }
        });
        jpmAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmAgendaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmAgendaMouseExited(evt);
            }
        });
        jpmAgenda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbAgenda.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbAgenda.setForeground(new java.awt.Color(153, 153, 153));
        jlbAgenda.setText("Agenda");
        jpmAgenda.add(jlbAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Calendar_24px.png"))); // NOI18N
        jpmAgenda.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jpMenu.add(jpmAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 40));

        jlbInicio2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbInicio2.setForeground(new java.awt.Color(153, 153, 153));
        jlbInicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pravana small.png"))); // NOI18N
        jpMenu.add(jlbInicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jpmVentas.setBackground(new java.awt.Color(250, 250, 250));
        jpmVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmVentas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmVentasMouseMoved(evt);
            }
        });
        jpmVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmVentasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmVentasMouseExited(evt);
            }
        });
        jpmVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbAdministrador1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbAdministrador1.setForeground(new java.awt.Color(153, 153, 153));
        jlbAdministrador1.setText("Ventas");
        jpmVentas.add(jlbAdministrador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Price_Tag_24px_1.png"))); // NOI18N
        jpmVentas.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jpMenu.add(jpmVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 180, 40));

        getContentPane().add(jpMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 600));

        jpEstadoCuenta.setBackground(new java.awt.Color(250, 250, 250));
        jpEstadoCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtCreditosCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCreditosCliente.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jScrollPane6.setViewportView(jtCreditosCliente);

        jpEstadoCuenta.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 350, 290));

        jpOpcInventario6.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcInventario6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator15.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario6.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        jpComVenInvNuevo9.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo9MouseClicked(evt);
            }
        });
        jpComVenInvNuevo9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(7, 131, 213));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Abonar");
        jpComVenInvNuevo9.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 20));

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Cash_in_Hand_24px.png"))); // NOI18N
        jpComVenInvNuevo9.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario6.add(jpComVenInvNuevo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jSeparator16.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario6.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jpComVenInvActualizar6.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizar6MouseClicked(evt);
            }
        });
        jpComVenInvActualizar6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(7, 131, 213));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Liquidar");
        jpComVenInvActualizar6.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 20));

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_US_Dollar_24px.png"))); // NOI18N
        jpComVenInvActualizar6.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario6.add(jpComVenInvActualizar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, -1));

        jpEliminar15.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar15MouseClicked(evt);
            }
        });
        jpEliminar15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel175.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(7, 131, 213));
        jLabel175.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel175.setText("Regresar");
        jpEliminar15.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Back_24px.png"))); // NOI18N
        jpEliminar15.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario6.add(jpEliminar15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, -1));

        jpEliminar16.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar16MouseClicked(evt);
            }
        });
        jpEliminar16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel206.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(7, 131, 213));
        jLabel206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel206.setText("Imprimir");
        jpEliminar16.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Print_24px.png"))); // NOI18N
        jpEliminar16.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario6.add(jpEliminar16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 140, -1));

        jpEstadoCuenta.add(jpOpcInventario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 700, -1));

        jtAbonosCredito.setModel(new javax.swing.table.DefaultTableModel(
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
        jtAbonosCredito.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jScrollPane7.setViewportView(jtAbonosCredito);

        jpEstadoCuenta.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 260, 290));

        jLabel105.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(80, 80, 80));
        jLabel105.setText("Abonos");
        jpEstadoCuenta.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jLabel106.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(80, 80, 80));
        jLabel106.setText("Cliente:");
        jpEstadoCuenta.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jlbalgo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbalgo.setForeground(new java.awt.Color(80, 80, 80));
        jlbalgo.setText("Deuda total restante");
        jpEstadoCuenta.add(jlbalgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jlbNombreCliente.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbNombreCliente.setForeground(new java.awt.Color(80, 80, 80));
        jlbNombreCliente.setText("Nombre del cliente");
        jpEstadoCuenta.add(jlbNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel107.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(209, 73, 114));
        jLabel107.setText("$");
        jpEstadoCuenta.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 20, -1));

        jlbDeudaTotal.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jlbDeudaTotal.setForeground(new java.awt.Color(209, 73, 114));
        jlbDeudaTotal.setText("0.00");
        jpEstadoCuenta.add(jlbDeudaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 130, -1));

        jpEliminarAbono.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminarAbono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpEliminarAbono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminarAbono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminarAbonoMouseClicked(evt);
            }
        });
        jpEliminarAbono.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(7, 131, 213));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Eliminar abono");
        jpEliminarAbono.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 20));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminarAbono.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpEstadoCuenta.add(jpEliminarAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 210, -1));

        jpEliminarCredito.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminarCredito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpEliminarCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminarCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminarCreditoMouseClicked(evt);
            }
        });
        jpEliminarCredito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(7, 131, 213));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Eliminar credito");
        jpEliminarCredito.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 20));

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminarCredito.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpEstadoCuenta.add(jpEliminarCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 180, -1));

        jLabel109.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(80, 80, 80));
        jLabel109.setText("Créditos");
        jpEstadoCuenta.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jpVerProductosCredito.setBackground(new java.awt.Color(250, 250, 250));
        jpVerProductosCredito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpVerProductosCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpVerProductosCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpVerProductosCreditoMouseClicked(evt);
            }
        });
        jpVerProductosCredito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel171.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(7, 131, 213));
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setText("Productos");
        jpVerProductosCredito.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Eye_24px.png"))); // NOI18N
        jpVerProductosCredito.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpEstadoCuenta.add(jpVerProductosCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 150, -1));

        jpEliminar14.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpEliminar14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar14MouseClicked(evt);
            }
        });
        jpEliminar14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(7, 131, 213));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("Insertar compras");
        jpEliminar14.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 150, 20));

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Buying_24px.png"))); // NOI18N
        jpEliminar14.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpEstadoCuenta.add(jpEliminar14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 210, -1));

        getContentPane().add(jpEstadoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpVentas.setBackground(new java.awt.Color(250, 250, 250));
        jpVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtVentas.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jScrollPane9.setViewportView(jtVentas);

        jpVentas.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 630, 400));
        jpVentas.add(jdcFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 140, 30));

        jLabel143.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(80, 80, 80));
        jLabel143.setText("Fecha inicial");
        jpVentas.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel144.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(80, 80, 80));
        jLabel144.setText("A");
        jpVentas.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));
        jpVentas.add(jdcFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 140, 30));

        jLabel145.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(80, 80, 80));
        jLabel145.setText("Fecha final");
        jpVentas.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        btnProductosBajos5.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosBajos5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosBajos5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosBajos5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosBajos5MouseClicked(evt);
            }
        });
        btnProductosBajos5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas.setText("Todas las ventas");
        btnProductosBajos5.add(jlbVerVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 20));

        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Eye_24px.png"))); // NOI18N
        btnProductosBajos5.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpVentas.add(btnProductosBajos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 220, -1));

        btnProductosVenta.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosVentaMouseClicked(evt);
            }
        });
        btnProductosVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas1.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas1.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas1.setText("Productos");
        btnProductosVenta.add(jlbVerVentas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, 20));

        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Paper_24px.png"))); // NOI18N
        btnProductosVenta.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpVentas.add(btnProductosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 170, -1));

        btnBuscar.setBackground(new java.awt.Color(250, 250, 250));
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas2.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas2.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas2.setText("Buscar");
        btnBuscar.add(jlbVerVentas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 70, 20));

        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_24px.png"))); // NOI18N
        btnBuscar.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        jpVentas.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 200, -1));

        btnEliminarVenta.setBackground(new java.awt.Color(250, 250, 250));
        btnEliminarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnEliminarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarVentaMouseClicked(evt);
            }
        });
        btnEliminarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas7.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas7.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas7.setText("Eliminar");
        btnEliminarVenta.add(jlbVerVentas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, 20));

        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        btnEliminarVenta.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpVentas.add(btnEliminarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 170, -1));

        getContentPane().add(jpVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpPuntoVenta.setBackground(new java.awt.Color(250, 250, 250));
        jpPuntoVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(80, 80, 80));
        jLabel6.setText("Cantidad");
        jpPuntoVenta.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, 30));

        jtxtIdProducto.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtIdProductoKeyReleased(evt);
            }
        });
        jpPuntoVenta.add(jtxtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 250, 30));

        jsCantidad.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jsCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jsCantidad.setValue(1);
        jsCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsCantidadMouseClicked(evt);
            }
        });
        jpPuntoVenta.add(jsCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 70, 30));

        jtPuntoVenta.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtPuntoVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPuntoVenta.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jScrollPane1.setViewportView(jtPuntoVenta);

        jpPuntoVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 620, 310));

        jpOpcPuntoVenta.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcPuntoVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

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
        jLabel21.setText("Eliminar");
        jpEliminar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta.add(jpEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 140, -1));

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
        jpComVenInvNuevo.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Buying_24px.png"))); // NOI18N
        jpComVenInvNuevo.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta.add(jpComVenInvNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jbBuscar.setBackground(new java.awt.Color(250, 250, 250));
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBuscarMouseClicked(evt);
            }
        });
        jbBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(7, 131, 213));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Buscar");
        jbBuscar.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_24px.png"))); // NOI18N
        jbBuscar.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, -1));

        jbtnCancelarVenta.setBackground(new java.awt.Color(250, 250, 250));
        jbtnCancelarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCancelarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnCancelarVentaMouseClicked(evt);
            }
        });
        jbtnCancelarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(7, 131, 213));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Cancelar");
        jbtnCancelarVenta.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_32px.png"))); // NOI18N
        jbtnCancelarVenta.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcPuntoVenta.add(jbtnCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, -1));

        jpPuntoVenta.add(jpOpcPuntoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 700, -1));

        jLabel29.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(80, 80, 80));
        jLabel29.setText("Código del producto");
        jpPuntoVenta.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        jlbCantidad.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbCantidad.setForeground(new java.awt.Color(80, 80, 80));
        jlbCantidad.setText("0");
        jpPuntoVenta.add(jlbCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 30, 30));

        jLabel31.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(80, 80, 80));
        jLabel31.setText("Total");
        jpPuntoVenta.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 40, 30));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(209, 73, 114));
        jLabel2.setText("$");
        jpPuntoVenta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 20, 30));

        jLabel32.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(80, 80, 80));
        jLabel32.setText("Cantidad de productos en la venta actual");
        jpPuntoVenta.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, 30));

        jlbTotal.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jlbTotal.setForeground(new java.awt.Color(209, 73, 114));
        jlbTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTotal.setText("0.00");
        jpPuntoVenta.add(jlbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 150, 30));

        jtbPrecio.setText("Precio mayoreo");
        jtbPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbPrecioActionPerformed(evt);
            }
        });
        jpPuntoVenta.add(jtbPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 160, 40));

        jpComVenInvActualizar.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
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
        jpComVenInvActualizar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_24px.png"))); // NOI18N
        jpComVenInvActualizar.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpPuntoVenta.add(jpComVenInvActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 150, -1));

        getContentPane().add(jpPuntoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpClientes.setBackground(new java.awt.Color(250, 250, 250));
        jpClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpClientesMouseClicked(evt);
            }
        });
        jpClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtClientes.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtClientes.setForeground(new java.awt.Color(80, 80, 80));
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtClientes.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jScrollPane2.setViewportView(jtClientes);

        jpClientes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 650, 390));

        jpOpcInventario2.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcInventario2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        jpEliminar6.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar6MouseClicked(evt);
            }
        });
        jpEliminar6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(7, 131, 213));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Eliminar");
        jpEliminar6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminar6.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario2.add(jpEliminar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jpComVenInvNuevo4.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo4MouseClicked(evt);
            }
        });
        jpComVenInvNuevo4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(7, 131, 213));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Nuevo");
        jpComVenInvNuevo4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_24px.png"))); // NOI18N
        jpComVenInvNuevo4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario2.add(jpComVenInvNuevo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jpComVenInvActualizar3.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizar3MouseClicked(evt);
            }
        });
        jpComVenInvActualizar3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(7, 131, 213));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Actualizar");
        jpComVenInvActualizar3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 20));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Refresh_24px.png"))); // NOI18N
        jpComVenInvActualizar3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario2.add(jpComVenInvActualizar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, -1));

        jSeparator8.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jpComVenInvNuevo5.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo5MouseClicked(evt);
            }
        });
        jpComVenInvNuevo5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(7, 131, 213));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Creditos");
        jpComVenInvNuevo5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Paper_24px.png"))); // NOI18N
        jpComVenInvNuevo5.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario2.add(jpComVenInvNuevo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 130, -1));

        jpClientes.add(jpOpcInventario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 700, -1));

        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_24px.png"))); // NOI18N
        jpClientes.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));

        jtxtBuscarCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtBuscarCliente.setForeground(new java.awt.Color(80, 80, 80));
        jtxtBuscarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtBuscarCliente.setText("Buscar por nombre");
        jtxtBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtBuscarClienteMouseClicked(evt);
            }
        });
        jtxtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBuscarClienteKeyTyped(evt);
            }
        });
        jpClientes.add(jtxtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 250, 30));

        getContentPane().add(jpClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpBaseDatos.setBackground(new java.awt.Color(250, 250, 250));
        jpBaseDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRestaurar.setBackground(new java.awt.Color(250, 250, 250));
        jpRestaurar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpRestaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRestaurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpRestaurarMouseClicked(evt);
            }
        });
        jpRestaurar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_Database_80px.png"))); // NOI18N
        jpRestaurar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(80, 80, 80));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Restaurar");
        jpRestaurar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 100, -1));

        jpBaseDatos.add(jpRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 180, 170));

        jpReiniciar.setBackground(new java.awt.Color(250, 250, 250));
        jpReiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpReiniciarMouseClicked(evt);
            }
        });
        jpReiniciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Data_Backup_80px.png"))); // NOI18N
        jpReiniciar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(80, 80, 80));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Reiniciar");
        jpReiniciar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 90, -1));

        jpBaseDatos.add(jpReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 180, 170));

        jpRespaldar.setBackground(new java.awt.Color(250, 250, 250));
        jpRespaldar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpRespaldar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRespaldar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpRespaldarMouseClicked(evt);
            }
        });
        jpRespaldar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Database_View_80px.png"))); // NOI18N
        jpRespaldar.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel141.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(80, 80, 80));
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setText("Respaldar");
        jpRespaldar.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 90, -1));

        jpBaseDatos.add(jpRespaldar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 180, 170));

        getContentPane().add(jpBaseDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpInicio.setBackground(new java.awt.Color(250, 250, 250));
        jpInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProductosBajos2.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosBajos2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosBajos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosBajos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosBajos2MouseClicked(evt);
            }
        });
        btnProductosBajos2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbProductosBajos2.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbProductosBajos2.setForeground(new java.awt.Color(7, 131, 213));
        jlbProductosBajos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProductosBajos2.setText("Cerrar sesion");
        btnProductosBajos2.add(jlbProductosBajos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 20));

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Contacts_24px.png"))); // NOI18N
        btnProductosBajos2.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpInicio.add(btnProductosBajos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 210, -1));

        jlbNotificaciones.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbNotificaciones.setForeground(new java.awt.Color(0, 153, 153));
        jlbNotificaciones.setText("Citas");
        jpInicio.add(jlbNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jpNotificacionesProductos.setBackground(new java.awt.Color(250, 250, 250));
        jpNotificacionesProductos.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane16.setViewportView(jpNotificacionesProductos);

        jpInicio.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 650, 260));

        jlbNotificaciones1.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbNotificaciones1.setForeground(new java.awt.Color(209, 73, 114));
        jlbNotificaciones1.setText("Notificaciones");
        jpInicio.add(jlbNotificaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jpNotificacionesCitas.setBackground(new java.awt.Color(250, 250, 250));
        jpNotificacionesCitas.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane17.setViewportView(jpNotificacionesCitas);

        jpInicio.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 650, 90));

        jlbNotificaciones2.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbNotificaciones2.setForeground(new java.awt.Color(0, 153, 153));
        jlbNotificaciones2.setText("Productos");
        jpInicio.add(jlbNotificaciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        getContentPane().add(jpInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpGastos.setBackground(new java.awt.Color(250, 250, 250));
        jpGastos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(60, 60, 60));
        jLabel12.setText("Fecha");
        jpGastos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(60, 60, 60));
        jLabel15.setText("Concepto");
        jpGastos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel65.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(60, 60, 60));
        jLabel65.setText("Notas");
        jpGastos.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));
        jpGastos.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 180, 30));
        jpGastos.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 180, 30));
        jpGastos.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 180, 30));

        jtGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtGastosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtGastos);

        jpGastos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 390, 170));

        btnProductosVenta1.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosVenta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosVenta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosVenta1MouseClicked(evt);
            }
        });
        btnProductosVenta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas3.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas3.setText("Buscar");
        btnProductosVenta1.add(jlbVerVentas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_24px.png"))); // NOI18N
        btnProductosVenta1.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpGastos.add(btnProductosVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 120, -1));

        btnProductosVenta2.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosVenta2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosVenta2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosVenta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosVenta2MouseClicked(evt);
            }
        });
        btnProductosVenta2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas4.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas4.setText("Ver todos los gastos");
        btnProductosVenta2.add(jlbVerVentas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, 20));

        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Eye_24px.png"))); // NOI18N
        btnProductosVenta2.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpGastos.add(btnProductosVenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 240, -1));

        jLabel66.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(80, 80, 80));
        jLabel66.setText("Puedes buscar en un periodo especifico");
        jpGastos.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));
        jpGastos.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 110, 30));
        jpGastos.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 110, 30));

        btnProductosVenta3.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosVenta3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosVenta3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosVenta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosVenta3MouseClicked(evt);
            }
        });
        btnProductosVenta3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas5.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas5.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas5.setText("Agregar gasto");
        btnProductosVenta3.add(jlbVerVentas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, 20));

        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Initiate_Money_Transfer_24px.png"))); // NOI18N
        btnProductosVenta3.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpGastos.add(btnProductosVenta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 180, -1));

        jSeparator17.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpGastos.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 10, 550));

        jLabel67.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(80, 80, 80));
        jLabel67.setText("Registrar nuevo gasto");
        jpGastos.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane11.setViewportView(jTextArea1);

        jpGastos.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 180, 150));

        jLabel68.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(60, 60, 60));
        jLabel68.setText("Cantidad");
        jpGastos.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane13.setViewportView(jTextArea2);

        jpGastos.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 390, 150));

        jLabel159.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(60, 60, 60));
        jLabel159.setText("Notas");
        jpGastos.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        btnProductosVenta4.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosVenta4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosVenta4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosVenta4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosVenta4MouseClicked(evt);
            }
        });
        btnProductosVenta4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbVerVentas6.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbVerVentas6.setForeground(new java.awt.Color(7, 131, 213));
        jlbVerVentas6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVerVentas6.setText("Limpiar");
        btnProductosVenta4.add(jlbVerVentas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, 20));

        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Broom_24px.png"))); // NOI18N
        btnProductosVenta4.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpGastos.add(btnProductosVenta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 130, 40));

        getContentPane().add(jpGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpInsertarCompras.setBackground(new java.awt.Color(250, 250, 250));
        jpInsertarCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel181.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(80, 80, 80));
        jLabel181.setText("Cantidad");
        jpInsertarCompras.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, 30));

        jtxtCodProdCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtCodProdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCodProdClienteKeyReleased(evt);
            }
        });
        jpInsertarCompras.add(jtxtCodProdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 250, 30));

        jsCantidadCliente.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jsCantidadCliente.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jsCantidadCliente.setValue(1);
        jsCantidadCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsCantidadClienteMouseClicked(evt);
            }
        });
        jpInsertarCompras.add(jsCantidadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 70, 30));

        jtProductosVentaCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtProductosVentaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jtProductosVentaCliente.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jScrollPane15.setViewportView(jtProductosVentaCliente);

        jpInsertarCompras.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 620, 310));

        jpOpcPuntoVenta1.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcPuntoVenta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator22.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        jpEliminar1.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar1MouseClicked(evt);
            }
        });
        jpEliminar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel184.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(7, 131, 213));
        jLabel184.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel184.setText("Eliminar");
        jpEliminar1.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel185.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminar1.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta1.add(jpEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 140, -1));

        jpComVenInvNuevo1.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo1MouseClicked(evt);
            }
        });
        jpComVenInvNuevo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel186.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(7, 131, 213));
        jLabel186.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel186.setText("Cobrar");
        jpComVenInvNuevo1.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Buying_24px.png"))); // NOI18N
        jpComVenInvNuevo1.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta1.add(jpComVenInvNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jSeparator23.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcPuntoVenta1.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jbBuscar1.setBackground(new java.awt.Color(250, 250, 250));
        jbBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBuscar1MouseClicked(evt);
            }
        });
        jbBuscar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel194.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(7, 131, 213));
        jLabel194.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel194.setText("Buscar");
        jbBuscar1.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel196.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_24px.png"))); // NOI18N
        jbBuscar1.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcPuntoVenta1.add(jbBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, -1));

        jbtnCancelarVenta1.setBackground(new java.awt.Color(250, 250, 250));
        jbtnCancelarVenta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCancelarVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnCancelarVenta1MouseClicked(evt);
            }
        });
        jbtnCancelarVenta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel197.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(7, 131, 213));
        jLabel197.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel197.setText("Cancelar");
        jbtnCancelarVenta1.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        jLabel198.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_32px.png"))); // NOI18N
        jbtnCancelarVenta1.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcPuntoVenta1.add(jbtnCancelarVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, -1));

        jpInsertarCompras.add(jpOpcPuntoVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 700, -1));

        jLabel199.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(80, 80, 80));
        jLabel199.setText("Código del producto");
        jpInsertarCompras.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        jlbCantidadVentaCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jlbCantidadVentaCliente.setForeground(new java.awt.Color(80, 80, 80));
        jlbCantidadVentaCliente.setText("0");
        jpInsertarCompras.add(jlbCantidadVentaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 30, 30));

        jLabel200.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(80, 80, 80));
        jLabel200.setText("Total");
        jpInsertarCompras.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 40, 30));

        jLabel201.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(209, 73, 114));
        jLabel201.setText("$");
        jpInsertarCompras.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 20, 30));

        jLabel202.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(80, 80, 80));
        jLabel202.setText("Cantidad de productos en la venta actual");
        jpInsertarCompras.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, 30));

        jlbTotalVentaCliente.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jlbTotalVentaCliente.setForeground(new java.awt.Color(209, 73, 114));
        jlbTotalVentaCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTotalVentaCliente.setText("0.00");
        jpInsertarCompras.add(jlbTotalVentaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 150, 30));

        jtbPrecioMayoreoCliente.setText("Precio mayoreo");
        jtbPrecioMayoreoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbPrecioMayoreoClienteActionPerformed(evt);
            }
        });
        jpInsertarCompras.add(jtbPrecioMayoreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 160, 40));

        jpBtnAgregarProductoCliente.setBackground(new java.awt.Color(250, 250, 250));
        jpBtnAgregarProductoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpBtnAgregarProductoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpBtnAgregarProductoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpBtnAgregarProductoClienteMouseClicked(evt);
            }
        });
        jpBtnAgregarProductoCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel203.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(7, 131, 213));
        jLabel203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel203.setText("Agregar");
        jpBtnAgregarProductoCliente.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        jLabel204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_24px.png"))); // NOI18N
        jpBtnAgregarProductoCliente.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpInsertarCompras.add(jpBtnAgregarProductoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 150, -1));
        jpInsertarCompras.add(jdcFechaCompraCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 160, 30));

        getContentPane().add(jpInsertarCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpAdministrador.setBackground(new java.awt.Color(250, 250, 250));
        jpAdministrador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpmLicencia.setBackground(new java.awt.Color(250, 250, 250));
        jpmLicencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpmLicencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmLicencia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmLicenciaMouseMoved(evt);
            }
        });
        jpmLicencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmLicenciaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmLicenciaMouseExited(evt);
            }
        });
        jpmLicencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(153, 153, 153));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Key_80px.png"))); // NOI18N
        jpmLicencia.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel73.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 153, 153));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Licencia");
        jpmLicencia.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jpAdministrador.add(jpmLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 140, 130));

        jpmCorte.setBackground(new java.awt.Color(250, 250, 250));
        jpmCorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpmCorte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmCorte.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmCorteMouseMoved(evt);
            }
        });
        jpmCorte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmCorteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmCorteMouseExited(evt);
            }
        });
        jpmCorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 153, 153));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Coins_80px.png"))); // NOI18N
        jpmCorte.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel75.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(153, 153, 153));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Corte");
        jpmCorte.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 60, -1));

        jpAdministrador.add(jpmCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 140, 130));

        jpmBaseDatos.setBackground(new java.awt.Color(250, 250, 250));
        jpmBaseDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpmBaseDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmBaseDatos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmBaseDatosMouseMoved(evt);
            }
        });
        jpmBaseDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmBaseDatosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmBaseDatosMouseExited(evt);
            }
        });
        jpmBaseDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(153, 153, 153));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Database_Administrator_80px_1.png"))); // NOI18N
        jpmBaseDatos.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel77.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(153, 153, 153));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Base de datos");
        jpmBaseDatos.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jpAdministrador.add(jpmBaseDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 140, 130));

        jpmGastos.setBackground(new java.awt.Color(250, 250, 250));
        jpmGastos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpmGastos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmGastos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmGastosMouseMoved(evt);
            }
        });
        jpmGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmGastosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmGastosMouseExited(evt);
            }
        });
        jpmGastos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(153, 153, 153));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Money_80px.png"))); // NOI18N
        jpmGastos.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel79.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(153, 153, 153));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Gastos");
        jpmGastos.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 60, -1));

        jpAdministrador.add(jpmGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 140, 130));

        jpmEmpresa.setBackground(new java.awt.Color(250, 250, 250));
        jpmEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpmEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmEmpresa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmEmpresaMouseMoved(evt);
            }
        });
        jpmEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmEmpresaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmEmpresaMouseExited(evt);
            }
        });
        jpmEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(153, 153, 153));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Permanent_Job_80px.png"))); // NOI18N
        jpmEmpresa.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel81.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(153, 153, 153));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Empresa");
        jpmEmpresa.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jpAdministrador.add(jpmEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 140, 130));

        jpmUsuarios.setBackground(new java.awt.Color(250, 250, 250));
        jpmUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jpmUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpmUsuarios.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpmUsuariosMouseMoved(evt);
            }
        });
        jpmUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpmUsuariosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpmUsuariosMouseExited(evt);
            }
        });
        jpmUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(153, 153, 153));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_User_80px.png"))); // NOI18N
        jpmUsuarios.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel83.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(153, 153, 153));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Usuarios");
        jpmUsuarios.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jpAdministrador.add(jpmUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 140, 130));

        getContentPane().add(jpAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpCorte.setBackground(new java.awt.Color(250, 250, 250));
        jpCorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Hacer corte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpCorte.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 130, 30));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel176.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(0, 77, 90));
        jLabel176.setText("Pagos de contado");
        jPanel8.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel10.setBackground(new java.awt.Color(159, 207, 233));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel217.setText("Ventas en efectivo");
        jPanel10.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, 20));

        jPanel17.setBackground(new java.awt.Color(159, 207, 233));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setText("Pagos de clientes");
        jPanel17.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jPanel8.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 170, -1));

        jlbPagosClientes.setText("0.00");
        jPanel8.add(jlbPagosClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 60, 20));

        jlbVentasEfectivo.setText("0.00");
        jPanel8.add(jlbVentasEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 60, 20));

        jLabel223.setText("$");
        jPanel8.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 20));

        jLabel224.setText("$");
        jPanel8.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, 20));

        jPanel19.setBackground(new java.awt.Color(159, 207, 233));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel182.setText("Ventas con tarjeta");
        jPanel19.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jPanel8.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, -1));

        jLabel237.setText("$");
        jPanel8.add(jLabel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, 20));

        jlbVentasTarjeta.setText("0.00");
        jPanel8.add(jlbVentasTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 60, 20));

        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(0, 77, 90));
        jLabel183.setText("Gastos");
        jPanel8.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jPanel13.setBackground(new java.awt.Color(255, 195, 195));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel178.setText("Otros gastos");
        jPanel13.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 170, -1));

        jlbOtrosGastos.setText("0.00");
        jPanel8.add(jlbOtrosGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 60, 20));

        jLabel225.setText("$");
        jPanel8.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, 20));

        jpCorte.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 300, 220));
        jpCorte.add(jdcCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 140, 30));

        jLabel213.setText("Dia");
        jpCorte.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 60, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(0, 77, 90));
        jLabel179.setText("Dinero en caja");
        jPanel2.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel12.setBackground(new java.awt.Color(146, 225, 207));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel215.setText("Pagos de contado                    +");
        jPanel12.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, -1));

        jPanel15.setBackground(new java.awt.Color(146, 225, 207));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel216.setText("Gastos                                       -");
        jPanel15.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, -1));

        jLabel218.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel218.setText("Total:");
        jPanel2.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jlbTotalCaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbTotalCaja.setText("0.00");
        jPanel2.add(jlbTotalCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 60, -1));

        jLabel195.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel195.setText("$");
        jPanel2.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jLabel193.setText("$");
        jPanel2.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, 20));

        jLabel189.setText("$");
        jPanel2.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 20));

        jlbPagosContado.setText("0.00");
        jPanel2.add(jlbPagosContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 60, 20));

        jlbGastos.setText("0.00");
        jPanel2.add(jlbGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 60, 20));

        jLabel208.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(0, 77, 90));
        jLabel208.setText("Ganancia del dia");
        jPanel2.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel205.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(0, 77, 90));
        jLabel205.setText("$");
        jPanel2.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 30, -1));

        jlbGananciaDia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbGananciaDia.setForeground(new java.awt.Color(0, 77, 90));
        jlbGananciaDia.setText("0.00");
        jPanel2.add(jlbGananciaDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 90, -1));

        jpCorte.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 310, 220));

        jpOpcInventario7.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcInventario7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator20.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario7.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        jSeparator21.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario7.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jpEliminar9.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar9MouseClicked(evt);
            }
        });
        jpEliminar9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel187.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(7, 131, 213));
        jLabel187.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel187.setText("Regresar");
        jpEliminar9.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jLabel188.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Back_24px.png"))); // NOI18N
        jpEliminar9.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario7.add(jpEliminar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, -1));

        jpEliminar10.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar10MouseClicked(evt);
            }
        });
        jpEliminar10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel190.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(7, 131, 213));
        jLabel190.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel190.setText("Imprimir corte");
        jpEliminar10.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 150, 20));

        jLabel191.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Print_24px.png"))); // NOI18N
        jpEliminar10.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario7.add(jpEliminar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 210, -1));

        jpCorte.add(jpOpcInventario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 700, -1));

        getContentPane().add(jpCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpInventario.setBackground(new java.awt.Color(250, 250, 250));
        jpInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpInventarioMouseClicked(evt);
            }
        });
        jpInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtInventario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtInventario.setForeground(new java.awt.Color(80, 80, 80));
        jtInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jtInventario.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jtInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtInventarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtInventario);

        jpInventario.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 650, 340));

        jpOpcInventario1.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcInventario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        jpEliminar4.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar4MouseClicked(evt);
            }
        });
        jpEliminar4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(7, 131, 213));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Eliminar");
        jpEliminar4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminar4.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario1.add(jpEliminar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jpComVenInvNuevo2.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo2MouseClicked(evt);
            }
        });
        jpComVenInvNuevo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(7, 131, 213));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Nuevo");
        jpComVenInvNuevo2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_24px.png"))); // NOI18N
        jpComVenInvNuevo2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario1.add(jpComVenInvNuevo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jpComVenInvActualizar2.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizar2MouseClicked(evt);
            }
        });
        jpComVenInvActualizar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(7, 131, 213));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Actualizar");
        jpComVenInvActualizar2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 20));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Refresh_24px.png"))); // NOI18N
        jpComVenInvActualizar2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario1.add(jpComVenInvActualizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, -1));

        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jpEliminar5.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar5MouseClicked(evt);
            }
        });
        jpEliminar5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(7, 131, 213));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Limpiar");
        jpEliminar5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Broom_24px.png"))); // NOI18N
        jpEliminar5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario1.add(jpEliminar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 140, -1));

        jpInventario.add(jpOpcInventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 700, -1));

        btnProductosBajos.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosBajos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosBajos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosBajos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosBajosMouseClicked(evt);
            }
        });
        btnProductosBajos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbProductosBajos.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbProductosBajos.setForeground(new java.awt.Color(7, 131, 213));
        jlbProductosBajos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProductosBajos.setText("Productos bajos");
        btnProductosBajos.add(jlbProductosBajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 150, 20));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Minus_24px.png"))); // NOI18N
        btnProductosBajos.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpInventario.add(btnProductosBajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 210, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel4.setText("$");
        jpInventario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 20, 20));

        jLabel7.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(80, 80, 80));
        jLabel7.setText("Cantidad de productos");
        jpInventario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, 20));

        jlbCostoInversion.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbCostoInversion.setText("0.00");
        jpInventario.add(jlbCostoInversion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 110, 20));

        jLabel33.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(80, 80, 80));
        jLabel33.setText("Costo del inventario");
        jpInventario.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 20));

        jlbCantidadProductos.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbCantidadProductos.setText("0");
        jpInventario.add(jlbCantidadProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 60, 20));

        jcbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDepartamentosMouseClicked(evt);
            }
        });
        jcbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDepartamentosActionPerformed(evt);
            }
        });
        jpInventario.add(jcbDepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 160, 30));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(80, 80, 80));
        jLabel17.setText("Filtrar productos por");
        jpInventario.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 30));

        jtxtBuscar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtBuscar.setForeground(new java.awt.Color(80, 80, 80));
        jtxtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtBuscar.setText("Buscar por código o descripcion");
        jtxtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtBuscarMouseClicked(evt);
            }
        });
        jtxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyTyped(evt);
            }
        });
        jpInventario.add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 260, 30));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_24px.png"))); // NOI18N
        jpInventario.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        getContentPane().add(jpInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpNuevoProducto.setBackground(new java.awt.Color(250, 250, 250));
        jpNuevoProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpOpcInventario4.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcInventario4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator11.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario4.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        btnRegresarInventario.setBackground(new java.awt.Color(250, 250, 250));
        btnRegresarInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarInventarioMouseClicked(evt);
            }
        });
        btnRegresarInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(7, 131, 213));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Regresar");
        btnRegresarInventario.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Back_24px.png"))); // NOI18N
        btnRegresarInventario.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario4.add(btnRegresarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        btnGuardarProducto.setBackground(new java.awt.Color(250, 250, 250));
        btnGuardarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarProductoMouseClicked(evt);
            }
        });
        btnGuardarProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbGuardarProducto.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbGuardarProducto.setForeground(new java.awt.Color(7, 131, 213));
        jlbGuardarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbGuardarProducto.setText("Guardar");
        btnGuardarProducto.add(jlbGuardarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 20));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Save_24px_3.png"))); // NOI18N
        btnGuardarProducto.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario4.add(btnGuardarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jSeparator12.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario4.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jpNuevoProducto.add(jpOpcInventario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 700, -1));

        jpDatosProducto.setBackground(new java.awt.Color(250, 250, 250));
        jpDatosProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpDatosProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtCodigo.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtCodigo.setForeground(new java.awt.Color(80, 80, 80));
        jpDatosProducto.add(jtxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 30));

        jtxtDescripcion.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtDescripcion.setForeground(new java.awt.Color(80, 80, 80));
        jpDatosProducto.add(jtxtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 180, 30));

        jtxtCosto.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtCosto.setForeground(new java.awt.Color(80, 80, 80));
        jpDatosProducto.add(jtxtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 110, 30));

        jLabel35.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(80, 80, 80));
        jLabel35.setText("Codigo");
        jpDatosProducto.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 30));

        jLabel37.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(80, 80, 80));
        jLabel37.setText("Descripcion");
        jpDatosProducto.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        jLabel86.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(80, 80, 80));
        jLabel86.setText("Costo");
        jpDatosProducto.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 30));

        jLabel87.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(80, 80, 80));
        jLabel87.setText("Departamento");
        jpDatosProducto.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 30));

        jcbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Sin departamento -", " ", "Item 2", "Item 3", "Item 4" }));
        jpDatosProducto.add(jcbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 140, 30));

        jpNuevoProducto.add(jpDatosProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 660, 130));

        jPanel5.setBackground(new java.awt.Color(250, 250, 250));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(80, 80, 80));
        jLabel85.setText("Producto minimo");
        jPanel5.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, 30));

        jLabel40.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(80, 80, 80));
        jLabel40.setText("Precio a publico");
        jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        jLabel39.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(80, 80, 80));
        jLabel39.setText("Precio a mayoreo");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jtxtMinimo.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtMinimo.setForeground(new java.awt.Color(80, 80, 80));
        jPanel5.add(jtxtMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 140, 30));

        jtxtExistencia.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtExistencia.setForeground(new java.awt.Color(80, 80, 80));
        jPanel5.add(jtxtExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 140, 30));

        jtxtPublico.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtPublico.setForeground(new java.awt.Color(80, 80, 80));
        jPanel5.add(jtxtPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, 30));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(80, 80, 80));
        jLabel5.setText("Existencia");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 30));

        jtxtMayoreo.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtMayoreo.setForeground(new java.awt.Color(80, 80, 80));
        jPanel5.add(jtxtMayoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 140, 30));

        jpNuevoProducto.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 660, 130));

        btnProductosBajos1.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosBajos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosBajos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosBajos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosBajos1MouseClicked(evt);
            }
        });
        btnProductosBajos1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbProductosBajos1.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbProductosBajos1.setForeground(new java.awt.Color(7, 131, 213));
        jlbProductosBajos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProductosBajos1.setText("Nuevo departamento");
        btnProductosBajos1.add(jlbProductosBajos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, 20));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Bulleted_List_24px.png"))); // NOI18N
        btnProductosBajos1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpNuevoProducto.add(btnProductosBajos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 240, -1));

        getContentPane().add(jpNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpAgenda.setBackground(new java.awt.Color(250, 250, 250));
        jpAgenda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(80, 80, 80));
        jLabel8.setText("Notas");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 40, 20));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(80, 80, 80));
        jLabel18.setText("Cliente");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 30));

        jtxtCliente.setEditable(false);
        jtxtCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 260, 30));

        jtaNotas.setColumns(20);
        jtaNotas.setRows(5);
        jScrollPane8.setViewportView(jtaNotas);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 260, 130));

        jLabel146.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(80, 80, 80));
        jLabel146.setText("Telefono");
        jPanel1.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 60, 30));

        jtxtTelefono.setEditable(false);
        jtxtTelefono.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 150, 30));

        jtxtDirCliente.setEditable(false);
        jtxtDirCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtDirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDirClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtDirCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 150, 30));

        jLabel147.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(80, 80, 80));
        jLabel147.setText("Direccion");
        jPanel1.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 60, 30));

        jLabel149.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(80, 80, 80));
        jLabel149.setText("Usuario");
        jPanel1.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 60, 30));

        jtxtUser.setEditable(false);
        jtxtUser.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jtxtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtUserActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 150, 30));

        jpAgenda.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 630, 250));

        jpOpcInventario3.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcInventario3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator9.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        jpEliminar8.setBackground(new java.awt.Color(250, 250, 250));
        jpEliminar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEliminar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminar8MouseClicked(evt);
            }
        });
        jpEliminar8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(7, 131, 213));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Eliminar");
        jpEliminar8.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Trash_24px.png"))); // NOI18N
        jpEliminar8.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario3.add(jpEliminar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jpComVenInvNuevo6.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo6MouseClicked(evt);
            }
        });
        jpComVenInvNuevo6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(7, 131, 213));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Nuevo");
        jpComVenInvNuevo6.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_24px.png"))); // NOI18N
        jpComVenInvNuevo6.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario3.add(jpComVenInvNuevo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jSeparator10.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario3.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jpAgenda.add(jpOpcInventario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 700, -1));

        jCalendario.setBackground(new java.awt.Color(250, 250, 250));
        jCalendario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpAgenda.add(jCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 270, 180));

        jtCitas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCitas.setSelectionBackground(new java.awt.Color(216, 238, 243));
        jtCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCitasMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jtCitas);

        jpAgenda.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 330, 180));

        getContentPane().add(jpAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpNuevaCita.setBackground(new java.awt.Color(250, 250, 250));
        jpNuevaCita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(80, 80, 80));
        jLabel95.setText("Selecciona la fecha");
        jpNuevaCita.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 20));
        jpNuevaCita.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 140, 30));

        jLabel110.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(80, 80, 80));
        jLabel110.setText("Selecciona el cliente");
        jpNuevaCita.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jtxtUsuarioCita.setEditable(false);
        jpNuevaCita.add(jtxtUsuarioCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 170, 30));

        jLabel142.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(80, 80, 80));
        jLabel142.setText("Usuario que va a realizar la visita");
        jpNuevaCita.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jtxtNomCliente.setEditable(false);
        jpNuevaCita.add(jtxtNomCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 170, 30));

        jLabel148.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(80, 80, 80));
        jLabel148.setText("Notas");
        jpNuevaCita.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jtaNotasCita.setColumns(20);
        jtaNotasCita.setRows(5);
        jScrollPane12.setViewportView(jtaNotasCita);

        jpNuevaCita.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 420, 200));

        btnProductosBajos3.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosBajos3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosBajos3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosBajos3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosBajos3MouseClicked(evt);
            }
        });
        btnProductosBajos3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbProductosBajos3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbProductosBajos3.setForeground(new java.awt.Color(7, 131, 213));
        jlbProductosBajos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProductosBajos3.setText("Guardar");
        btnProductosBajos3.add(jlbProductosBajos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, 20));

        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Save_24px_3.png"))); // NOI18N
        btnProductosBajos3.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        jpNuevaCita.add(btnProductosBajos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 170, -1));

        btnProductosBajos4.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosBajos4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosBajos4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosBajos4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosBajos4MouseClicked(evt);
            }
        });
        btnProductosBajos4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbProductosBajos4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbProductosBajos4.setForeground(new java.awt.Color(7, 131, 213));
        jlbProductosBajos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProductosBajos4.setText("Usuarios");
        btnProductosBajos4.add(jlbProductosBajos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 20));

        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Contacts_24px.png"))); // NOI18N
        btnProductosBajos4.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpNuevaCita.add(btnProductosBajos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 170, -1));

        btnProductosBajos6.setBackground(new java.awt.Color(250, 250, 250));
        btnProductosBajos6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnProductosBajos6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosBajos6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosBajos6MouseClicked(evt);
            }
        });
        btnProductosBajos6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbProductosBajos5.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jlbProductosBajos5.setForeground(new java.awt.Color(7, 131, 213));
        jlbProductosBajos5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProductosBajos5.setText("Clientes");
        btnProductosBajos6.add(jlbProductosBajos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 20));

        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Business_Building_24px.png"))); // NOI18N
        btnProductosBajos6.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        jpNuevaCita.add(btnProductosBajos6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 170, -1));

        jtxtIdUsuario.setEditable(false);
        jpNuevaCita.add(jtxtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 30, 30));

        jtxtIdCliente.setEditable(false);
        jpNuevaCita.add(jtxtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 30, 30));

        getContentPane().add(jpNuevaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpNuevoCliente.setBackground(new java.awt.Color(250, 250, 250));
        jpNuevoCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpOpcInventario5.setBackground(new java.awt.Color(250, 250, 250));
        jpOpcInventario5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator13.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario5.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 10));

        btnRegresarInventario1.setBackground(new java.awt.Color(250, 250, 250));
        btnRegresarInventario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarInventario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarInventario1MouseClicked(evt);
            }
        });
        btnRegresarInventario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(7, 131, 213));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Regresar");
        btnRegresarInventario1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Back_24px.png"))); // NOI18N
        btnRegresarInventario1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpOpcInventario5.add(btnRegresarInventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        btnGuardarProducto1.setBackground(new java.awt.Color(250, 250, 250));
        btnGuardarProducto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarProducto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarProducto1MouseClicked(evt);
            }
        });
        btnGuardarProducto1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(7, 131, 213));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Guardar");
        btnGuardarProducto1.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 20));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Save_24px_3.png"))); // NOI18N
        btnGuardarProducto1.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jpOpcInventario5.add(btnGuardarProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, -1));

        jSeparator14.setForeground(new java.awt.Color(153, 153, 153));
        jpOpcInventario5.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 10));

        jpNuevoCliente.add(jpOpcInventario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 700, -1));

        jpDatosProducto1.setBackground(new java.awt.Color(250, 250, 250));
        jpDatosProducto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpDatosProducto1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtNombreCliente.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtNombreCliente.setForeground(new java.awt.Color(80, 80, 80));
        jpDatosProducto1.add(jtxtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 430, 30));

        jtxtDireccionCliente.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtDireccionCliente.setForeground(new java.awt.Color(80, 80, 80));
        jpDatosProducto1.add(jtxtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 430, 30));

        jLabel38.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(80, 80, 80));
        jLabel38.setText("Nombre");
        jpDatosProducto1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, 30));

        jLabel49.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(80, 80, 80));
        jLabel49.setText("Dirección");
        jpDatosProducto1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, 30));

        jtxtTelefonoCliente.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtTelefonoCliente.setForeground(new java.awt.Color(80, 80, 80));
        jpDatosProducto1.add(jtxtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 190, 30));

        jLabel93.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(80, 80, 80));
        jLabel93.setText("Teléfono");
        jpDatosProducto1.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, 30));

        jLabel94.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(80, 80, 80));
        jLabel94.setText("RFC");
        jpDatosProducto1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 30));

        jtxtRFC.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtRFC.setForeground(new java.awt.Color(80, 80, 80));
        jtxtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtRFCActionPerformed(evt);
            }
        });
        jpDatosProducto1.add(jtxtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 190, 30));

        jLabel111.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(80, 80, 80));
        jLabel111.setText("Uso de factura");
        jpDatosProducto1.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 30));

        jtxtFactura.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtFactura.setForeground(new java.awt.Color(80, 80, 80));
        jtxtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFacturaActionPerformed(evt);
            }
        });
        jpDatosProducto1.add(jtxtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 190, 30));

        jLabel112.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(80, 80, 80));
        jLabel112.setText("C.P");
        jpDatosProducto1.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, 30));

        jtxtEmail.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtEmail.setForeground(new java.awt.Color(80, 80, 80));
        jtxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtEmailActionPerformed(evt);
            }
        });
        jpDatosProducto1.add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 190, 30));

        jLabel113.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(80, 80, 80));
        jLabel113.setText("Método de pago");
        jpDatosProducto1.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 30));

        jtxtMetodoPago.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtMetodoPago.setForeground(new java.awt.Color(80, 80, 80));
        jtxtMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMetodoPagoActionPerformed(evt);
            }
        });
        jpDatosProducto1.add(jtxtMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 190, 30));

        jLabel169.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(80, 80, 80));
        jLabel169.setText("Email");
        jpDatosProducto1.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, 30));

        jtxtCodigoPostal.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jtxtCodigoPostal.setForeground(new java.awt.Color(80, 80, 80));
        jpDatosProducto1.add(jtxtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 190, 30));

        jpNuevoCliente.add(jpDatosProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 660, 450));

        getContentPane().add(jpNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpUsuarios.setBackground(new java.awt.Color(250, 250, 250));
        jpUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane5.setViewportView(jtUsuarios);

        jpUsuarios.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 320, 180));

        jPanel7.setBackground(new java.awt.Color(250, 250, 250));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(80, 80, 80));
        jLabel122.setText("Nombre de usuario");
        jPanel7.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        jPanel7.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 170, 30));

        jLabel123.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(80, 80, 80));
        jLabel123.setText("Contraseña");
        jPanel7.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        jPanel7.add(jtxtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 170, 30));
        jPanel7.add(jtxtPassRepeat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 170, 30));

        jLabel124.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(80, 80, 80));
        jLabel124.setText("Permisos de administrador");
        jPanel7.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jRadioNo.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroupAdmin.add(jRadioNo);
        jRadioNo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jRadioNo.setForeground(new java.awt.Color(80, 80, 80));
        jRadioNo.setText("No");
        jRadioNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Unchecked_Radio_Button_24px_1.png"))); // NOI18N
        jRadioNo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Checked_Radio_Button_24px.png"))); // NOI18N
        jPanel7.add(jRadioNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jRadioSi.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroupAdmin.add(jRadioSi);
        jRadioSi.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jRadioSi.setForeground(new java.awt.Color(80, 80, 80));
        jRadioSi.setText("Si");
        jRadioSi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Unchecked_Radio_Button_24px_1.png"))); // NOI18N
        jRadioSi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Checked_Radio_Button_24px.png"))); // NOI18N
        jPanel7.add(jRadioSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel125.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(80, 80, 80));
        jLabel125.setText("Repetir contraseña");
        jPanel7.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jpComVenInvNuevo3.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpComVenInvNuevo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo3MouseClicked(evt);
            }
        });
        jpComVenInvNuevo3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(7, 131, 213));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("Guardar");
        jpComVenInvNuevo3.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Save_24px_3.png"))); // NOI18N
        jpComVenInvNuevo3.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jPanel7.add(jpComVenInvNuevo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 150, -1));

        jpUsuarios.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 250, 430));

        jpCambiarPass.setBackground(new java.awt.Color(250, 250, 250));
        jpCambiarPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpCambiarPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCambiarPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpCambiarPassMouseClicked(evt);
            }
        });
        jpCambiarPass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(7, 131, 213));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("Cambiar contraseña");
        jpCambiarPass.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 180, 20));

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Password_24px.png"))); // NOI18N
        jpCambiarPass.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpUsuarios.add(jpCambiarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 320, -1));

        jpComVenInvActualizar5.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpComVenInvActualizar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizar5MouseClicked(evt);
            }
        });
        jpComVenInvActualizar5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(7, 131, 213));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("Eliminar usuario");
        jpComVenInvActualizar5.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 20));

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_24px.png"))); // NOI18N
        jpComVenInvActualizar5.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpUsuarios.add(jpComVenInvActualizar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 320, -1));

        jpComVenInvActualizar7.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpComVenInvActualizar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizar7MouseClicked(evt);
            }
        });
        jpComVenInvActualizar7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(7, 131, 213));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("Cambiar nombre de usuario");
        jpComVenInvActualizar7.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 260, 20));

        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Name_24px.png"))); // NOI18N
        jpComVenInvActualizar7.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpUsuarios.add(jpComVenInvActualizar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 320, -1));

        jpComVenInvActualizar8.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvActualizar8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpComVenInvActualizar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvActualizar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvActualizar8MouseClicked(evt);
            }
        });
        jpComVenInvActualizar8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(7, 131, 213));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("Actualizar permisos");
        jpComVenInvActualizar8.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 20));

        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Access_24px.png"))); // NOI18N
        jpComVenInvActualizar8.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jpUsuarios.add(jpComVenInvActualizar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 320, -1));

        jLabel130.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(80, 80, 80));
        jLabel130.setText("Usurios registrados");
        jpUsuarios.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel131.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(80, 80, 80));
        jLabel131.setText("Dar de alta nuevo usuario");
        jpUsuarios.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        getContentPane().add(jpUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpEmpresa.setBackground(new java.awt.Color(250, 250, 250));
        jpEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpEmpresa.add(jtxtNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, -1));

        jLabel161.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(60, 60, 60));
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel161.setText("Nombre:");
        jpEmpresa.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 60, 20));

        jLabel162.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(60, 60, 60));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel162.setText("Direccion:");
        jpEmpresa.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 70, 20));
        jpEmpresa.add(jtxtDireccionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 190, -1));
        jpEmpresa.add(jtxtTelefonoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 190, -1));

        jLabel163.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(60, 60, 60));
        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel163.setText("Telefono:");
        jpEmpresa.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 80, 20));

        jLabel164.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(60, 60, 60));
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel164.setText("Email:");
        jpEmpresa.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 50, 20));
        jpEmpresa.add(jtxtEmailEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, -1));
        jpEmpresa.add(jtxtPaginaEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 190, -1));

        jLabel165.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(60, 60, 60));
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel165.setText("Pagina de internet:");
        jpEmpresa.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, 20));

        jLabel166.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(60, 60, 60));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel166.setText("Pagina de facebook:");
        jpEmpresa.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 140, 20));
        jpEmpresa.add(jtxtFacebookEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 190, -1));

        jtaAnotacionesEmpresa.setColumns(20);
        jtaAnotacionesEmpresa.setLineWrap(true);
        jtaAnotacionesEmpresa.setRows(5);
        jScrollPane14.setViewportView(jtaAnotacionesEmpresa);

        jpEmpresa.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 640, 140));

        jLabel167.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(60, 60, 60));
        jLabel167.setText("Anotacion en el pie del reporte");
        jpEmpresa.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel168.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(60, 60, 60));
        jLabel168.setText("Insertar logo");
        jpEmpresa.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 60, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel6KeyPressed(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Pravana medium.png"))); // NOI18N
        jlbLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbLogo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jlbLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbLogoMouseClicked(evt);
            }
        });
        jPanel6.add(jlbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 180));

        jpEmpresa.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 270, 200));

        jpComVenInvNuevo7.setBackground(new java.awt.Color(250, 250, 250));
        jpComVenInvNuevo7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpComVenInvNuevo7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpComVenInvNuevo7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpComVenInvNuevo7MouseClicked(evt);
            }
        });
        jpComVenInvNuevo7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel173.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(7, 131, 213));
        jLabel173.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel173.setText("Guardar");
        jpComVenInvNuevo7.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 20));

        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Save_24px_3.png"))); // NOI18N
        jpComVenInvNuevo7.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        jpEmpresa.add(jpComVenInvNuevo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 180, -1));

        jSeparator18.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpEmpresa.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 10, 230));

        jSeparator19.setForeground(new java.awt.Color(153, 153, 153));
        jpEmpresa.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 640, 10));

        getContentPane().add(jpEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        jpLicencia.setBackground(new java.awt.Color(250, 250, 250));
        jpLicencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Icons8_100px.png"))); // NOI18N
        jpLicencia.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel57.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(80, 80, 80));
        jLabel57.setText("Todos los iconos mostrados son gracias a la plataforma ICON8 bajo licencia gratuita");
        jpLicencia.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel58.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(80, 80, 80));
        jLabel58.setText("Puedes acceder a su contenido en la pagina https://iconos8.es/");
        jpLicencia.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pravana.png"))); // NOI18N
        jpLicencia.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jLabel133.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(80, 80, 80));
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("Pravana es una marca registrada,  este software no es propiedad de dicha marca");
        jpLicencia.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 570, -1));

        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AvatarReducidoRedondeado.png"))); // NOI18N
        jpLicencia.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));

        jLabel134.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(80, 80, 80));
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setText("solo es una representacion.");
        jpLicencia.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 180, -1));

        jLabel137.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(50, 50, 50));
        jLabel137.setText("Este software fue desarrollado por Haziel Castillo");
        jpLicencia.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, -1, -1));

        jLabel138.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(50, 50, 50));
        jLabel138.setText("Para mas proyectos puedes visitar mi Github haciendo click");
        jpLicencia.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));
        jpLicencia.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 630, 10));

        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jpLicencia.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 630, 10));

        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_GitHub_50px.png"))); // NOI18N
        jLabel136.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel136.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel136MouseClicked(evt);
            }
        });
        jpLicencia.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, -1, -1));

        getContentPane().add(jpLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpmPuntoVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmPuntoVentaMouseClicked
        cambiarVentana("puntoVenta");
    }//GEN-LAST:event_jpmPuntoVentaMouseClicked

    private void jpmInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmInventarioMouseClicked
        cambiarVentana("inventario");
        Inventario.cargarTablaProductos("SELECT * FROM productos");
        
        Inventario.cargarDepartamentos();
        jcbDepartamentos.addItem("Sin filtro");
        jcbDepartamentos.setSelectedIndex(jcbDepartamentos.getItemCount()-1);
    }//GEN-LAST:event_jpmInventarioMouseClicked

    private void jpmClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmClientesMouseClicked
        cambiarVentana("clientes");
        Clientes.cargarTablaClientes("SELECT id_cliente,nombre,telefono FROM clientes");
    }//GEN-LAST:event_jpmClientesMouseClicked

    private void jpmAdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmAdministradorMouseClicked
        cambiarVentana("administrador");
    }//GEN-LAST:event_jpmAdministradorMouseClicked

    private void jpmPuntoVentaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmPuntoVentaMouseMoved
        moved("puntoVenta");
    }//GEN-LAST:event_jpmPuntoVentaMouseMoved

    private void jpmInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmInventarioMouseMoved
        moved("inventario");
    }//GEN-LAST:event_jpmInventarioMouseMoved

    private void jpmClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmClientesMouseMoved
        moved("clientes");
    }//GEN-LAST:event_jpmClientesMouseMoved

    private void jpmAdministradorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmAdministradorMouseMoved
        moved("administrador");
    }//GEN-LAST:event_jpmAdministradorMouseMoved

    private void jpComVenInvNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevoMouseClicked
        if(puntoVenta.getTotal() > 0){
            Cobrar cobrar = new Cobrar();
            cobrar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"No hay nada que cobrar");
        }
        
    }//GEN-LAST:event_jpComVenInvNuevoMouseClicked

    private void jpmInicioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmInicioMouseMoved
        moved("inicio");
    }//GEN-LAST:event_jpmInicioMouseMoved

    private void jpmInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmInicioMouseClicked
        cambiarVentana("inicio");
        Inicio.cargarNotificaciones();
    }//GEN-LAST:event_jpmInicioMouseClicked

    private void jpmInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmInicioMouseExited
        if(!ventanaActual.equalsIgnoreCase("inicio"))
            exited("inicio");
    }//GEN-LAST:event_jpmInicioMouseExited

    private void jpmPuntoVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmPuntoVentaMouseExited
        if(!ventanaActual.equalsIgnoreCase("puntoVenta"))
            exited("puntoVenta");
    }//GEN-LAST:event_jpmPuntoVentaMouseExited

    private void jpmInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmInventarioMouseExited
        if(!ventanaActual.equalsIgnoreCase("inventario"))
            exited("inventario");
    }//GEN-LAST:event_jpmInventarioMouseExited

    private void jpmClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmClientesMouseExited
        if(!ventanaActual.equalsIgnoreCase("clientes"))
            exited("clientes");
    }//GEN-LAST:event_jpmClientesMouseExited

    private void jpmAdministradorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmAdministradorMouseExited
        if(!ventanaActual.equalsIgnoreCase("administrador"))
            exited("administrador");
    }//GEN-LAST:event_jpmAdministradorMouseExited

    private void jpmAgendaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmAgendaMouseMoved
        moved("agenda");
    }//GEN-LAST:event_jpmAgendaMouseMoved

    private void jpmAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmAgendaMouseClicked
        cambiarVentana("agenda");
        Citas.cargarTablaCitas("SELECT id_cita,fecha,nombre "
                + "FROM citas INNER JOIN clientes ON citas.fk_cliente = clientes.id_cliente "
                + "WHERE fecha >= NOW();");
        Citas.limpiarFormulario();
    }//GEN-LAST:event_jpmAgendaMouseClicked

    private void jpmAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmAgendaMouseExited
        if(!ventanaActual.equalsIgnoreCase("agenda"))
            exited("agenda"); 
    }//GEN-LAST:event_jpmAgendaMouseExited

    private void jpComVenInvNuevo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo2MouseClicked
        cambiarVentana("nuevoProducto");
        jtxtCodigo.setText("");
        jtxtDescripcion.setText("");
        jtxtCosto.setText("");
        jtxtMayoreo.setText("");
        jtxtExistencia.setText("");
        jtxtPublico.setText("");
        jtxtMinimo.setText("");
        jcbDepartamento.setSelectedIndex(0);
        Inventario.cargarDepartamentos();
        Inventario.setActualizarProducto(false);
    }//GEN-LAST:event_jpComVenInvNuevo2MouseClicked

    private void btnProductosBajosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosBajosMouseClicked
        
        if(productosBajos){
            jlbProductosBajos.setText("Productos Bajos");
            Inventario.cargarTablaProductos("SELECT * FROM productos;");
            productosBajos = false;
        }else{
            jlbProductosBajos.setText("Ver todos");
            Inventario.cargarTablaProductos("SELECT * FROM productos WHERE existencia <= minimo;");
            productosBajos = true;
        }
        jtxtBuscar.setText("Buscar por codigo o nombre");
    }//GEN-LAST:event_btnProductosBajosMouseClicked

    private void jpComVenInvNuevo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo4MouseClicked
        cambiarVentana("nuevoCliente");
        jtxtNombreCliente.setText("");
        jtxtDireccionCliente.setText("");
        jtxtCodigoPostal.setText("");
        jtxtTelefonoCliente.setText("");
        jtxtRFC.setText("");
        jtxtFactura.setText("");
        jtxtMetodoPago.setText("");
        jtxtEmail.setText("");
        Clientes.setActualizarCliente(false);
    }//GEN-LAST:event_jpComVenInvNuevo4MouseClicked

    private void jpComVenInvNuevo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo5MouseClicked
        
        int fila = jtClientes.getSelectedRow();
        if(fila != -1){
            cambiarVentana("estadoCuenta");
            int id_cliente = Integer.parseInt(jtClientes.getValueAt(fila, 0).toString());
            Creditos.balanceCredito(id_cliente);
            Creditos.cargarTablaAbonos(id_cliente);
            jlbNombreCliente.setText(String.valueOf(jtClientes.getValueAt(fila, 1)));
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un cliente");
        }
        
    }//GEN-LAST:event_jpComVenInvNuevo5MouseClicked

    private void jpComVenInvNuevo6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo6MouseClicked
        cambiarVentana("nuevaCita");
        jDateChooser1.setDate(null);
        jtxtUsuarioCita.setText("");
        jtxtNomCliente.setText("");
        jtxtIdUsuario.setText("");
        jtxtIdCliente.setText("");
        jtaNotasCita.setText("");
        
    }//GEN-LAST:event_jpComVenInvNuevo6MouseClicked

    private void jbBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscarMouseClicked
        Buscar buscar = new Buscar();
        buscar.setVisible(true);
    }//GEN-LAST:event_jbBuscarMouseClicked

    private void btnGuardarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarProductoMouseClicked
        Inventario.insertarProducto();
        cambiarVentana("inventario");
        
        Inventario.cargarDepartamentos();
        jcbDepartamentos.addItem("Sin filtro");
        jcbDepartamentos.setSelectedIndex(jcbDepartamentos.getItemCount()-1);
    }//GEN-LAST:event_btnGuardarProductoMouseClicked

    private void btnRegresarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarInventarioMouseClicked
        cambiarVentana("inventario");
        
        Inventario.cargarDepartamentos();
        jcbDepartamentos.addItem("Sin filtro");
        jcbDepartamentos.setSelectedIndex(jcbDepartamentos.getItemCount()-1);
    }//GEN-LAST:event_btnRegresarInventarioMouseClicked

    private void jpComVenInvNuevo9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo9MouseClicked
        abonar();
    }//GEN-LAST:event_jpComVenInvNuevo9MouseClicked

    private void btnProductosBajos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosBajos1MouseClicked
        nuevoDepartamento departamento = new nuevoDepartamento();
        departamento.setVisible(true);
    }//GEN-LAST:event_btnProductosBajos1MouseClicked

    private void jtInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtInventarioMouseClicked
        jtxtBuscar.setText("Buscar por codigo o nombre");
    }//GEN-LAST:event_jtInventarioMouseClicked

    private void jpComVenInvActualizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizar2MouseClicked
        if(jtInventario.getSelectedRow() != -1){
            cambiarVentana("nuevoProducto");
            buscarFiltrado = false;
            Inventario.cargarProducto();
            Inventario.setActualizarProducto(true);
        }else{
            JOptionPane.showMessageDialog(null,"No tienes ningun registro seleccionado");
        }
    }//GEN-LAST:event_jpComVenInvActualizar2MouseClicked

    private void btnRegresarInventario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarInventario1MouseClicked
        cambiarVentana("clientes");
    }//GEN-LAST:event_btnRegresarInventario1MouseClicked

    private void btnGuardarProducto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarProducto1MouseClicked
        Clientes.insertarCliente();
        cambiarVentana("clientes");
    }//GEN-LAST:event_btnGuardarProducto1MouseClicked

    private void jtxtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtRFCActionPerformed

    private void jtxtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtFacturaActionPerformed

    private void jtxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtEmailActionPerformed

    private void jtxtMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMetodoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMetodoPagoActionPerformed

    private void jpEliminar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar4MouseClicked
        try {
            Inventario.eliminarProducto();
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jpEliminar4MouseClicked

    private void jcbDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDepartamentosMouseClicked
        buscarFiltrado = true;
    }//GEN-LAST:event_jcbDepartamentosMouseClicked

    private void jcbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDepartamentosActionPerformed
        if(buscarFiltrado){
            Inventario.buscarFiltrado();
            buscarFiltrado = false;
        }
    }//GEN-LAST:event_jcbDepartamentosActionPerformed

    private void jtxtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyTyped
        
    }//GEN-LAST:event_jtxtBuscarKeyTyped

    private void jtxtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtBuscarMouseClicked
        jtxtBuscar.setText("");
    }//GEN-LAST:event_jtxtBuscarMouseClicked

    private void jpInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInventarioMouseClicked
        jtxtBuscar.setText("Buscar por codigo o nombre");
    }//GEN-LAST:event_jpInventarioMouseClicked

    private void jtxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyReleased
        Inventario.cargarTablaProductos("SELECT * FROM productos "
                + "WHERE id_producto LIKE '%"+jtxtBuscar.getText()+"%' "
                        + "OR descripcion LIKE '%"+jtxtBuscar.getText()+"%';");
    }//GEN-LAST:event_jtxtBuscarKeyReleased

    private void jpEliminar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar5MouseClicked
        Inventario.cargarTablaProductos("SELECT * FROM productos");
        jtxtBuscar.setText("Buscar por codigo o nombre");
        Inventario.cargarDepartamentos();
        jcbDepartamentos.addItem("Sin filtro");
        jcbDepartamentos.setSelectedIndex(jcbDepartamentos.getItemCount()-1);
    }//GEN-LAST:event_jpEliminar5MouseClicked

    private void jpEliminar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar6MouseClicked
        try {
            Clientes.eliminarCliente();
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jpEliminar6MouseClicked

    private void jpComVenInvActualizar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizar3MouseClicked
        if(jtClientes.getSelectedRow() != -1){
            cambiarVentana("nuevoCliente");
            Clientes.cargarCliente();
            Clientes.setActualizarCliente(true);
        }else{
            JOptionPane.showMessageDialog(null,"No tienes ningun registro seleccionado");
        }
    }//GEN-LAST:event_jpComVenInvActualizar3MouseClicked

    private void jtxtBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtBuscarClienteMouseClicked
        jtxtBuscarCliente.setText("");
    }//GEN-LAST:event_jtxtBuscarClienteMouseClicked

    private void jtxtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarClienteKeyReleased
        Clientes.cargarTablaClientes("SELECT id_cliente,nombre,telefono FROM clientes "
                + "WHERE nombre LIKE '%"+jtxtBuscarCliente.getText()+"%';");
    }//GEN-LAST:event_jtxtBuscarClienteKeyReleased

    private void jtxtBuscarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBuscarClienteKeyTyped

    private void jpClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpClientesMouseClicked
        jtxtBuscarCliente.setText("Buscar por nombre");
    }//GEN-LAST:event_jpClientesMouseClicked

    private void jtbPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbPrecioActionPerformed

    private void jtxtIdProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtIdProductoKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            puntoVenta.agregarProducto(jtxtIdProducto.getText());
        }
    }//GEN-LAST:event_jtxtIdProductoKeyReleased

    private void jsCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsCantidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jsCantidadMouseClicked

    private void jpComVenInvActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizarMouseClicked
        puntoVenta.agregarProducto(jtxtIdProducto.getText());
    }//GEN-LAST:event_jpComVenInvActualizarMouseClicked

    private void jbtnCancelarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarVentaMouseClicked
         if(puntoVenta.getTotal() > 0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                    + "de cancelar la venta?","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                puntoVenta.inicializarVenta();
                Conexion.rollback();
            }
        }else{
            JOptionPane.showMessageDialog(null,"No se a iniciado una venta");
        }
    }//GEN-LAST:event_jbtnCancelarVentaMouseClicked

    private void jpEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarMouseClicked
        puntoVenta.eliminarProducto();
    }//GEN-LAST:event_jpEliminarMouseClicked

    private void jpmCorteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmCorteMouseExited
        exited("corte");
    }//GEN-LAST:event_jpmCorteMouseExited

    private void jpmGastosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmGastosMouseExited
        exited("gastos");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmGastosMouseExited

    private void jpmEmpresaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmEmpresaMouseExited
        exited("empresa");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmEmpresaMouseExited

    private void jpmUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmUsuariosMouseExited
        exited("usuarios");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmUsuariosMouseExited

    private void jpmBaseDatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmBaseDatosMouseExited
        exited("baseDatos");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmBaseDatosMouseExited

    private void jpmLicenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmLicenciaMouseExited
        exited("licencia");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmLicenciaMouseExited

    private void jpmCorteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmCorteMouseMoved
        moved("corte");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmCorteMouseMoved

    private void jpmGastosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmGastosMouseMoved
        moved("gastos");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmGastosMouseMoved

    private void jpmEmpresaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmEmpresaMouseMoved
        moved("empresa");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmEmpresaMouseMoved

    private void jpmUsuariosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmUsuariosMouseMoved
        moved("usuarios");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmUsuariosMouseMoved

    private void jpmBaseDatosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmBaseDatosMouseMoved
        moved("baseDatos");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmBaseDatosMouseMoved

    private void jpmLicenciaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmLicenciaMouseMoved
        moved("licencia");        // TODO add your handling code here:
    }//GEN-LAST:event_jpmLicenciaMouseMoved

    private void jpmUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmUsuariosMouseClicked
       cambiarVentana("usuarios");
       jtxtUsuario.setText("");
       jtxtPass.setText("");
       jtxtPassRepeat.setText("");
       buttonGroupAdmin.clearSelection();
       
       Usuarios.cargarUsuarios();
    }//GEN-LAST:event_jpmUsuariosMouseClicked

    private void jpComVenInvNuevo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo3MouseClicked
        Usuarios.crearUsuario();
        Usuarios.cargarUsuarios();
    }//GEN-LAST:event_jpComVenInvNuevo3MouseClicked

    private void jpComVenInvActualizar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizar5MouseClicked
        Usuarios.eliminarUsuario();
    }//GEN-LAST:event_jpComVenInvActualizar5MouseClicked

    private void jpCambiarPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCambiarPassMouseClicked
        Usuarios.cambiarPassword();
    }//GEN-LAST:event_jpCambiarPassMouseClicked

    private void btnProductosBajos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosBajos2MouseClicked
        this.dispose();
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_btnProductosBajos2MouseClicked

    private void jpComVenInvActualizar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizar6MouseClicked
        
        int id_cliente = Integer.parseInt(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
        float deuda = Creditos.balanceCredito(id_cliente);
        if(deuda > 0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Confirme la operacion, desea liquidar el adeudo","Confirmacion",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                Creditos.agregarAbono(id_cliente, deuda);
                Creditos.balanceCredito(id_cliente);
                Creditos.cargarTablaAbonos(id_cliente);
            }
        }else{
            JOptionPane.showMessageDialog(null,"El cliente no tiene adeudos");
        }
        
        
    }//GEN-LAST:event_jpComVenInvActualizar6MouseClicked

    private void jpEliminarCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarCreditoMouseClicked
        Creditos.eliminarCredito();
        
        int id_cliente = Integer.parseInt(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
        Creditos.balanceCredito(id_cliente);
        Creditos.cargarTablaAbonos(id_cliente);
    }//GEN-LAST:event_jpEliminarCreditoMouseClicked

    private void jpEliminarAbonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarAbonoMouseClicked
        
        Creditos.eliminarAbono();
        
        int id_cliente = Integer.parseInt(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
        Creditos.balanceCredito(id_cliente);
        Creditos.cargarTablaAbonos(id_cliente);
    }//GEN-LAST:event_jpEliminarAbonoMouseClicked

    private void jpComVenInvActualizar7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizar7MouseClicked
        Usuarios.cambiarNombre();
        Usuarios.cargarUsuarios();
    }//GEN-LAST:event_jpComVenInvActualizar7MouseClicked

    private void jpComVenInvActualizar8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvActualizar8MouseClicked
        Usuarios.cambiarPermisos();
    }//GEN-LAST:event_jpComVenInvActualizar8MouseClicked

    private void jpmBaseDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmBaseDatosMouseClicked
        cambiarVentana("baseDatos");
    }//GEN-LAST:event_jpmBaseDatosMouseClicked

    private void jpmLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmLicenciaMouseClicked
        cambiarVentana("licencia");
    }//GEN-LAST:event_jpmLicenciaMouseClicked

    private void jLabel136MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel136MouseClicked
        Desktop enlace = Desktop.getDesktop();
        try {
                enlace.browse(new URI("https://github.com/hajocava"));
        } catch (IOException e) {
            e.getMessage();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel136MouseClicked

    private void jpmVentasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmVentasMouseMoved
        moved("ventas");
    }//GEN-LAST:event_jpmVentasMouseMoved

    private void jpmVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmVentasMouseClicked
        cambiarVentana("ventas");
        
        Date fecha = null;
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH)+1;
        int annio = c.get(Calendar.YEAR);
        
        try {
            ResultSet rs = Conexion.selectFrom("SELECT DATE_SUB(NOW(),INTERVAL 7 DAY) AS fecha;");
            rs.next();
            
            fecha = rs.getDate("fecha");
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jdcFechaInicial.setDate(Fecha.SetDate(fecha.toString())); //FECHA 7 DIAS ANTES DE LA ACTUAL
        jdcFechaFinal.setDate(Fecha.SetDate(annio+"-"+mes+"-"+dia)); //FECHA ACTUAL
        
        Ventas.cargarTablaVentas("SELECT id_venta, date, total, metodoPago, nombre "
                    + "FROM ventas INNER JOIN usuarios "
                + "ON ventas.fk_usuario = usuarios.id_usuario "
                + "WHERE date > (SELECT DATE_SUB(NOW(),INTERVAL 7 DAY));");
    }//GEN-LAST:event_jpmVentasMouseClicked

    private void jpmVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmVentasMouseExited
        exited("ventas");
    }//GEN-LAST:event_jpmVentasMouseExited

    private void jpRespaldarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRespaldarMouseClicked
        Conexion.respaldarBD();
    }//GEN-LAST:event_jpRespaldarMouseClicked

    private void jpRestaurarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRestaurarMouseClicked
        Conexion.restaurarBD();
    }//GEN-LAST:event_jpRestaurarMouseClicked

    private void jpReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpReiniciarMouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                + "de reiniciar la base de datos?\n No quedaran registros de ningun tipo","Warning",dialogButton);

        if(dialogResult == JOptionPane.YES_OPTION){
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Ingrese password de administrador: ");
            JPasswordField pass = new JPasswordField(10);
            panel.add(label);
            panel.add(pass);
            String[] options = new String[]{"Cancelar", "Aceptar"};
            int option = JOptionPane.showOptionDialog(null, panel, "Reiniciar base de datos",
                             JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                             null, options, options[1]);
            if(option == 1)//Si presionan aceptar
            {
                char[] password = pass.getPassword();
                String pass1 = new String(password);
                
                try {
                    ResultSet rs = Conexion.selectFrom("SELECT * FROM usuarios "
                        + "WHERE password = MD5('" + pass1 + "') AND habilitado = 1 AND tipo = 1;");
            
                    if(rs.next()){
                        Conexion.reiniciarBD();
                        JOptionPane.showMessageDialog(null,"Listo");
                    }else{
                        JOptionPane.showMessageDialog(null,"Password incorrecto o no tiene permisos para tal accion");
                    }
                } catch (Exception e) {}
                
                
            }
            
        }
        
    }//GEN-LAST:event_jpReiniciarMouseClicked

    private void btnProductosBajos5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosBajos5MouseClicked
        
        if (ventasMes) {
            jlbVerVentas.setText("Todas las ventas");
            Ventas.cargarTablaVentas("SELECT id_venta, date, total, metodoPago, nombre "
                    + "FROM ventas INNER JOIN usuarios "
                + "ON ventas.fk_usuario = usuarios.id_usuario "
                + "WHERE date > (SELECT DATE_SUB(NOW(),INTERVAL 7 DAY));");
            
            Date fecha = null;
            Calendar c = Calendar.getInstance();
            int dia = c.get(Calendar.DATE);
            int mes = c.get(Calendar.MONTH)+1;
            int annio = c.get(Calendar.YEAR);

            try {
                ResultSet rs = Conexion.selectFrom("SELECT DATE_SUB(NOW(),INTERVAL 7 DAY) AS fecha;");
                rs.next();

                fecha = rs.getDate("fecha");
            } catch (SQLException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }

            jdcFechaInicial.setDate(Fecha.SetDate(fecha.toString())); //FECHA 7 DIAS ANTES DE LA ACTUAL
            jdcFechaFinal.setDate(Fecha.SetDate(annio+"-"+mes+"-"+dia)); //FECHA ACTUAL
            
            ventasMes = false;
        }else{
            jlbVerVentas.setText("Ventas semanal");
            Ventas.cargarTablaVentas("SELECT id_venta, date, total, metodoPago, nombre "
                + "FROM ventas INNER JOIN usuarios "
                + "ON ventas.fk_usuario = usuarios.id_usuario;");
            
            jdcFechaInicial.setDate(null); //FECHA 7 DIAS ANTES DE LA ACTUAL
            jdcFechaFinal.setDate(null); //FECHA ACTUAL
            ventasMes = true;
        }
        
    }//GEN-LAST:event_btnProductosBajos5MouseClicked

    private void btnProductosVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosVentaMouseClicked
//        int fila = jtVentas.getSelectedRow();
//        if(fila != -1){
//            int id_venta = Integer.parseInt(jtVentas.getValueAt(fila, 0).toString());
//            System.out.println(id_venta);
//            Ventas.cargarTablaProductosVenta(id_venta);
//        }else{
//            JOptionPane.showMessageDialog(null,"Selecciona una venta");
//        }
        int fila = jtVentas.getSelectedRow();
        if(fila != -1){
            int id_venta = Integer.parseInt(jtVentas.getValueAt(fila, 0).toString());
            productosVenta productos = new productosVenta();
            productos.cargarTablaProductosVenta("SELECT descripcion,cantidad,precio "
                    + "FROM venta_productos INNER JOIN productos "
                    + "ON venta_productos.fk_producto = productos.id_producto "
                    + "WHERE fk_venta = "+id_venta+";");
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona una venta");
        }
        
    }//GEN-LAST:event_btnProductosVentaMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        String fechaInicial = Fecha.getFecha(jdcFechaInicial);
        String fechaFinal = Fecha.getFecha(jdcFechaFinal);
        
        Ventas.cargarTablaVentas("SELECT id_venta, date, total, metodoPago, nombre "
                + "FROM ventas INNER JOIN usuarios "
                + "ON ventas.fk_usuario = usuarios.id_usuario "
                + "WHERE date >= '" + fechaInicial + "' AND date <= '" + fechaFinal + "';");
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void jtxtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtClienteActionPerformed

    private void btnProductosBajos3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosBajos3MouseClicked
        Citas.insertarCita();
        Citas.cargarTablaCitas("SELECT id_cita,fecha,nombre "
                + "FROM citas INNER JOIN clientes ON citas.fk_cliente = clientes.id_cliente "
                + "WHERE fecha >= NOW();");
        cambiarVentana("agenda");
    }//GEN-LAST:event_btnProductosBajos3MouseClicked

    private void btnProductosBajos4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosBajos4MouseClicked
        UsuariosFrame usuarios = new UsuariosFrame();
        usuarios.setVisible(true);
    }//GEN-LAST:event_btnProductosBajos4MouseClicked

    private void btnProductosBajos6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosBajos6MouseClicked
        ClientesFrame cliente = new ClientesFrame();
        cliente.setVisible(true);
    }//GEN-LAST:event_btnProductosBajos6MouseClicked

    private void jtxtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTelefonoActionPerformed

    private void jtxtDirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDirClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDirClienteActionPerformed

    private void jtxtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtUserActionPerformed

    private void jtCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCitasMouseClicked
        int fila = jtCitas.getSelectedRow();
        if(fila != -1){
            int id_cita = Integer.parseInt(jtCitas.getValueAt(fila, 0).toString());
            Citas.cargarCamposCita(id_cita);
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona una cita");
        }
        
    }//GEN-LAST:event_jtCitasMouseClicked

    private void btnProductosVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosVenta1MouseClicked
        String fechaInicial = Fecha.getFecha(jDateChooser4);
        String fechaFinal = Fecha.getFecha(jDateChooser3);
        Gastos.cargarTablaGastos("SELECT id_gasto,concepto,cantidad,fecha,nombre "
                + "FROM gastos INNER JOIN usuarios ON gastos.fk_usuario = usuarios.id_usuario "
                + "WHERE fecha >= '"+fechaInicial+"' AND fecha <= '"+fechaFinal+"';");
    }//GEN-LAST:event_btnProductosVenta1MouseClicked

    private void btnProductosVenta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosVenta2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosVenta2MouseClicked

    private void btnProductosVenta3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosVenta3MouseClicked
        Gastos.insertarGasto();
        Gastos.cargarTablaGastos("SELECT id_gasto,concepto,cantidad,fecha,nombre "
                + "FROM gastos INNER JOIN usuarios ON gastos.fk_usuario = usuarios.id_usuario;");
        
    }//GEN-LAST:event_btnProductosVenta3MouseClicked

    private void jpmGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmGastosMouseClicked
        cambiarVentana("gastos");
        Gastos.cargarTablaGastos("SELECT id_gasto,concepto,cantidad,fecha,nombre "
                + "FROM gastos INNER JOIN usuarios ON gastos.fk_usuario = usuarios.id_usuario;");
    }//GEN-LAST:event_jpmGastosMouseClicked

    private void jtGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtGastosMouseClicked
        int fila = jtGastos.getSelectedRow();
        if(fila != -1){
            int id_gasto = Integer.parseInt(jtGastos.getValueAt(fila, 0).toString());
            Gastos.cargarNota("SELECT notas FROM gastos "
                    + "WHERE id_gasto = "+id_gasto+";");
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un registro");
        }
    }//GEN-LAST:event_jtGastosMouseClicked

    private void btnProductosVenta4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosVenta4MouseClicked
        Gastos.cargarTablaGastos("SELECT id_gasto,concepto,cantidad,fecha,nombre "
                + "FROM gastos INNER JOIN usuarios ON gastos.fk_usuario = usuarios.id_usuario;");
    }//GEN-LAST:event_btnProductosVenta4MouseClicked

    private void jlbLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLogoMouseClicked
        datosEmpresa.buscarImagen();
    }//GEN-LAST:event_jlbLogoMouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel6KeyPressed

    }//GEN-LAST:event_jPanel6KeyPressed

    private void jpComVenInvNuevo7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo7MouseClicked
        datosEmpresa.escribirDatosEmpresa();
    }//GEN-LAST:event_jpComVenInvNuevo7MouseClicked

    private void jpmEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmEmpresaMouseClicked
        cambiarVentana("empresa");
    }//GEN-LAST:event_jpmEmpresaMouseClicked

    private void jpEliminar8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar8MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro de eliminar esta cita?","Confirmacion",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            int fila = jtCitas.getSelectedRow();
            if(fila != -1){
                int id_cita = Integer.parseInt(jtCitas.getValueAt(fila, 0).toString());
                Citas.eliminarCita(id_cita);
                Citas.cargarTablaCitas("SELECT id_cita,fecha,nombre "
                    + "FROM citas INNER JOIN clientes ON citas.fk_cliente = clientes.id_cliente "
                    + "WHERE fecha >= NOW();");
            }else{
                JOptionPane.showMessageDialog(null,"Selecciona una cita");
            }
        }
    }//GEN-LAST:event_jpEliminar8MouseClicked

    private void btnEliminarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarVentaMouseClicked
        try {
            Ventas.eliminarVenta();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnEliminarVentaMouseClicked

    private void jpVerProductosCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpVerProductosCreditoMouseClicked
        productosVenta productos = new productosVenta();
        int fila = jtCreditosCliente.getSelectedRow();
        if(fila != -1){
            int id_credito = Integer.parseInt(String.valueOf(jtCreditosCliente.getValueAt(fila, 0)));
            productos.cargarTablaProductosVenta("SELECT descripcion,cantidad,precio "
                            + "FROM venta_productos INNER JOIN productos "
                            + "ON venta_productos.fk_producto = productos.id_producto "
                            + "WHERE fk_venta = (SELECT fk_venta FROM creditos WHERE id_credito = " + id_credito + ");");
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un credito");
        }
    }//GEN-LAST:event_jpVerProductosCreditoMouseClicked

    private void jpmCorteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpmCorteMouseClicked
        cambiarVentana("corte");
        
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH)+1;
        int annio = c.get(Calendar.YEAR);
        
        
        jdcCorte.setDate(Fecha.SetDate(annio+"-"+mes+"-"+dia)); //FECHA ACTUAL
        
        jlbGananciaDia.setText("0.00");
        jlbVentasEfectivo.setText("0.00");
        jlbVentasTarjeta.setText("0.00");
        jlbPagosClientes.setText("0.00");
        jlbOtrosGastos.setText("0.00");
        jlbPagosContado.setText("0.00");
        jlbGastos.setText("0.00");    
        jlbTotalCaja.setText("0.00");
    }//GEN-LAST:event_jpmCorteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        float ventasEfectivo = 0;
        float ventasTarjeta = 0;
        float totalAbonos = 0;
        float totalGastos = 0;
        
        float pagosContado = 0;
        float totalCaja = 0;
        
        float gananciaVenta = 0;
        float totalGanancia = 0;
        
        try {
            ResultSet rs = Conexion.selectFrom("SELECT id_venta, total, metodoPago FROM ventas WHERE DATE(date) = '" + Fecha.getFecha(jdcCorte) + "';");
            
            while(rs.next()){
                if (rs.getString("metodoPago").equalsIgnoreCase("efectivo")) ventasEfectivo += rs.getFloat("total");
                    
                else if(rs.getString("metodoPago").equalsIgnoreCase("tarjeta")) ventasTarjeta += rs.getFloat("total");
                    
                
                
                if (rs.getString("metodoPago").equalsIgnoreCase("efectivo") || rs.getString("metodoPago").equalsIgnoreCase("tarjeta")) {
                    gananciaVenta = rs.getFloat("total"); //Obtenemos el total de esa venta
                    
                    ResultSet r = Conexion.selectFrom("SELECT fk_venta, cantidad, costo "
                    + "FROM venta_productos INNER JOIN productos "
                    + "ON venta_productos.fk_producto = productos.id_producto "
                    + "WHERE fk_venta = "+rs.getInt("id_venta")+";");
                    while(r.next()){
                        //vamos a restar lo que costaron los productos y esa seria la ganancia
                        gananciaVenta = gananciaVenta - (r.getInt("cantidad") * r.getFloat("costo"));
                    }
                    totalGanancia += gananciaVenta;
                }
                
            }
            jlbGananciaDia.setText(String.valueOf(totalGanancia));
            jlbVentasEfectivo.setText(String.valueOf(ventasEfectivo));
            jlbVentasTarjeta.setText(String.valueOf(ventasTarjeta));
            
            
            rs = Conexion.selectFrom("SELECT cantidad FROM abonosgeneral WHERE DATE(fecha) = '" + Fecha.getFecha(jdcCorte) + "';");
            while(rs.next()){
                totalAbonos += rs.getFloat("cantidad");
            }
            jlbPagosClientes.setText(String.valueOf(totalAbonos));
            
            
            rs = Conexion.selectFrom("SELECT cantidad FROM gastos WHERE DATE(fecha) = '" + Fecha.getFecha(jdcCorte) + "';");
            while(rs.next()){
                totalGastos += rs.getFloat("cantidad");
            }
            jlbOtrosGastos.setText(String.valueOf(totalGastos));
            
            
            pagosContado = ventasEfectivo + ventasTarjeta + totalAbonos;
            jlbPagosContado.setText(String.valueOf(pagosContado));
            jlbGastos.setText(String.valueOf(totalGastos));    
                    
            totalCaja = pagosContado - totalGastos;
            jlbTotalCaja.setText(String.valueOf(totalCaja));
            
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpEliminar9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar9MouseClicked
        cambiarVentana("administrador");
    }//GEN-LAST:event_jpEliminar9MouseClicked

    private void jpEliminar10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpEliminar10MouseClicked

    private void jtxtCodProdClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodProdClienteKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            InsertarCompras.agregarProducto(jtxtCodProdCliente.getText());
        }
    }//GEN-LAST:event_jtxtCodProdClienteKeyReleased

    private void jsCantidadClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsCantidadClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jsCantidadClienteMouseClicked

    private void jpEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar1MouseClicked
        InsertarCompras.eliminarProducto();
    }//GEN-LAST:event_jpEliminar1MouseClicked

    private void jpComVenInvNuevo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpComVenInvNuevo1MouseClicked
        
        if(InsertarCompras.getTotal() > 0){
            String fechaCompra = Fecha.getFecha(jdcFechaCompraCliente);
            if (fechaCompra != null) {
                CobrarProductosCliente cobrar = new CobrarProductosCliente();
                cobrar.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Tienes que seleccionar una fecha de compra");
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"No hay nada que cobrar");
        }
        
        
    }//GEN-LAST:event_jpComVenInvNuevo1MouseClicked

    private void jbBuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscar1MouseClicked
        BuscarProductoCliente buscar = new BuscarProductoCliente();
        buscar.setVisible(true);
    }//GEN-LAST:event_jbBuscar1MouseClicked

    private void jbtnCancelarVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarVenta1MouseClicked
        if(InsertarCompras.getTotal() > 0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Estas seguro "
                    + "de cancelar la venta?","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                InsertarCompras.inicializarVenta();
                Conexion.rollback();
            }
        }else{
            JOptionPane.showMessageDialog(null,"No se a iniciado una venta");
        }
    }//GEN-LAST:event_jbtnCancelarVenta1MouseClicked

    private void jtbPrecioMayoreoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbPrecioMayoreoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbPrecioMayoreoClienteActionPerformed

    private void jpBtnAgregarProductoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpBtnAgregarProductoClienteMouseClicked
        InsertarCompras.agregarProducto(jtxtCodProdCliente.getText());
    }//GEN-LAST:event_jpBtnAgregarProductoClienteMouseClicked

    private void jpEliminar14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar14MouseClicked
        cambiarVentana("insertarCompras");
        InsertarCompras.inicializarVenta();
    }//GEN-LAST:event_jpEliminar14MouseClicked

    private void jpEliminar15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar15MouseClicked
        cambiarVentana("clientes");
    }//GEN-LAST:event_jpEliminar15MouseClicked

    private void jpEliminar16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminar16MouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("Historial"));
        if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            String ruta = fc.getSelectedFile().getAbsolutePath()+".pdf";
            int id_cliente = Integer.parseInt(String.valueOf(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0)));
            String nombreCliente = String.valueOf(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1));
            iTextPDF.generarHistorialCliente(ruta, id_cliente, nombreCliente);

            try{
                File objetofile = new File (ruta);
                Desktop.getDesktop().open(objetofile);
            }catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_jpEliminar16MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBuscar;
    private javax.swing.JPanel btnEliminarVenta;
    private javax.swing.JPanel btnGuardarProducto;
    private javax.swing.JPanel btnGuardarProducto1;
    private javax.swing.JPanel btnProductosBajos;
    private javax.swing.JPanel btnProductosBajos1;
    private javax.swing.JPanel btnProductosBajos2;
    private javax.swing.JPanel btnProductosBajos3;
    private javax.swing.JPanel btnProductosBajos4;
    private javax.swing.JPanel btnProductosBajos5;
    private javax.swing.JPanel btnProductosBajos6;
    private javax.swing.JPanel btnProductosVenta;
    private javax.swing.JPanel btnProductosVenta1;
    private javax.swing.JPanel btnProductosVenta2;
    private javax.swing.JPanel btnProductosVenta3;
    private javax.swing.JPanel btnProductosVenta4;
    private javax.swing.JPanel btnRegresarInventario;
    private javax.swing.JPanel btnRegresarInventario1;
    public static final javax.swing.ButtonGroup buttonGroupAdmin = new javax.swing.ButtonGroup();
    private javax.swing.JButton jButton1;
    public static final com.toedter.calendar.JCalendar jCalendario = new com.toedter.calendar.JCalendar();
    public static final com.toedter.calendar.JDateChooser jDateChooser1 = new com.toedter.calendar.JDateChooser();
    public static final com.toedter.calendar.JDateChooser jDateChooser2 = new com.toedter.calendar.JDateChooser();
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    public static final javax.swing.JLabel jLabel171 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public static final javax.swing.JRadioButton jRadioNo = new javax.swing.JRadioButton();
    public static final javax.swing.JRadioButton jRadioSi = new javax.swing.JRadioButton();
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public static final javax.swing.JTextArea jTextArea1 = new javax.swing.JTextArea();
    public static final javax.swing.JTextArea jTextArea2 = new javax.swing.JTextArea();
    public static final javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
    public static final javax.swing.JTextField jTextField3 = new javax.swing.JTextField();
    private javax.swing.JPanel jbBuscar;
    private javax.swing.JPanel jbBuscar1;
    private javax.swing.JPanel jbtnCancelarVenta;
    private javax.swing.JPanel jbtnCancelarVenta1;
    public static final javax.swing.JComboBox<String> jcbDepartamento = new javax.swing.JComboBox<>();
    public static final javax.swing.JComboBox<String> jcbDepartamentos = new javax.swing.JComboBox<>();
    public static final com.toedter.calendar.JDateChooser jdcCorte = new com.toedter.calendar.JDateChooser();
    public static final com.toedter.calendar.JDateChooser jdcFechaCompraCliente = new com.toedter.calendar.JDateChooser();
    public static final com.toedter.calendar.JDateChooser jdcFechaFinal = new com.toedter.calendar.JDateChooser();
    public static final com.toedter.calendar.JDateChooser jdcFechaInicial = new com.toedter.calendar.JDateChooser();
    private javax.swing.JLabel jlbAdministrador;
    private javax.swing.JLabel jlbAdministrador1;
    private javax.swing.JLabel jlbAgenda;
    public static final javax.swing.JLabel jlbCantidad = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbCantidadProductos = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbCantidadVentaCliente = new javax.swing.JLabel();
    private javax.swing.JLabel jlbClientes;
    public static final javax.swing.JLabel jlbCostoInversion = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbDeudaTotal = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbGananciaDia = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbGastos = new javax.swing.JLabel();
    private javax.swing.JLabel jlbGuardarProducto;
    private javax.swing.JLabel jlbInicio;
    private javax.swing.JLabel jlbInicio2;
    private javax.swing.JLabel jlbInventario;
    public static final javax.swing.JLabel jlbLogo = new javax.swing.JLabel();
    private javax.swing.JLabel jlbNombreCliente;
    private javax.swing.JLabel jlbNotificaciones;
    private javax.swing.JLabel jlbNotificaciones1;
    private javax.swing.JLabel jlbNotificaciones2;
    public static final javax.swing.JLabel jlbOtrosGastos = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbPagosClientes = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbPagosContado = new javax.swing.JLabel();
    private javax.swing.JLabel jlbProductosBajos;
    private javax.swing.JLabel jlbProductosBajos1;
    private javax.swing.JLabel jlbProductosBajos2;
    private javax.swing.JLabel jlbProductosBajos3;
    private javax.swing.JLabel jlbProductosBajos4;
    private javax.swing.JLabel jlbProductosBajos5;
    private javax.swing.JLabel jlbPuntoVenta;
    public static final javax.swing.JLabel jlbTotal = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbTotalCaja = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbTotalVentaCliente = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbVentasEfectivo = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbVentasTarjeta = new javax.swing.JLabel();
    private javax.swing.JLabel jlbVerVentas;
    private javax.swing.JLabel jlbVerVentas1;
    private javax.swing.JLabel jlbVerVentas2;
    private javax.swing.JLabel jlbVerVentas3;
    private javax.swing.JLabel jlbVerVentas4;
    private javax.swing.JLabel jlbVerVentas5;
    private javax.swing.JLabel jlbVerVentas6;
    private javax.swing.JLabel jlbVerVentas7;
    private javax.swing.JLabel jlbalgo;
    private javax.swing.JPanel jpAdministrador;
    private javax.swing.JPanel jpAgenda;
    private javax.swing.JPanel jpBaseDatos;
    private javax.swing.JPanel jpBtnAgregarProductoCliente;
    private javax.swing.JPanel jpCambiarPass;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpComVenInvActualizar;
    private javax.swing.JPanel jpComVenInvActualizar2;
    private javax.swing.JPanel jpComVenInvActualizar3;
    private javax.swing.JPanel jpComVenInvActualizar5;
    private javax.swing.JPanel jpComVenInvActualizar6;
    private javax.swing.JPanel jpComVenInvActualizar7;
    private javax.swing.JPanel jpComVenInvActualizar8;
    private javax.swing.JPanel jpComVenInvNuevo;
    private javax.swing.JPanel jpComVenInvNuevo1;
    private javax.swing.JPanel jpComVenInvNuevo2;
    private javax.swing.JPanel jpComVenInvNuevo3;
    private javax.swing.JPanel jpComVenInvNuevo4;
    private javax.swing.JPanel jpComVenInvNuevo5;
    private javax.swing.JPanel jpComVenInvNuevo6;
    private javax.swing.JPanel jpComVenInvNuevo7;
    private javax.swing.JPanel jpComVenInvNuevo9;
    private javax.swing.JPanel jpCorte;
    private javax.swing.JPanel jpDatosProducto;
    private javax.swing.JPanel jpDatosProducto1;
    private javax.swing.JPanel jpEliminar;
    private javax.swing.JPanel jpEliminar1;
    private javax.swing.JPanel jpEliminar10;
    private javax.swing.JPanel jpEliminar14;
    private javax.swing.JPanel jpEliminar15;
    private javax.swing.JPanel jpEliminar16;
    private javax.swing.JPanel jpEliminar4;
    private javax.swing.JPanel jpEliminar5;
    private javax.swing.JPanel jpEliminar6;
    private javax.swing.JPanel jpEliminar8;
    private javax.swing.JPanel jpEliminar9;
    private javax.swing.JPanel jpEliminarAbono;
    private javax.swing.JPanel jpEliminarCredito;
    private javax.swing.JPanel jpEmpresa;
    private javax.swing.JPanel jpEstadoCuenta;
    private javax.swing.JPanel jpGastos;
    private javax.swing.JPanel jpInicio;
    private javax.swing.JPanel jpInsertarCompras;
    private javax.swing.JPanel jpInventario;
    private javax.swing.JPanel jpLicencia;
    private javax.swing.JPanel jpMenu;
    public static final javax.swing.JPanel jpNotificacionesCitas = new javax.swing.JPanel();
    public static final javax.swing.JPanel jpNotificacionesProductos = new javax.swing.JPanel();
    private javax.swing.JPanel jpNuevaCita;
    private javax.swing.JPanel jpNuevoCliente;
    private javax.swing.JPanel jpNuevoProducto;
    private javax.swing.JPanel jpOpcInventario1;
    private javax.swing.JPanel jpOpcInventario2;
    private javax.swing.JPanel jpOpcInventario3;
    private javax.swing.JPanel jpOpcInventario4;
    private javax.swing.JPanel jpOpcInventario5;
    private javax.swing.JPanel jpOpcInventario6;
    private javax.swing.JPanel jpOpcInventario7;
    private javax.swing.JPanel jpOpcPuntoVenta;
    private javax.swing.JPanel jpOpcPuntoVenta1;
    private javax.swing.JPanel jpPuntoVenta;
    private javax.swing.JPanel jpReiniciar;
    private javax.swing.JPanel jpRespaldar;
    private javax.swing.JPanel jpRestaurar;
    private javax.swing.JPanel jpUsuarios;
    private javax.swing.JPanel jpVentas;
    private javax.swing.JPanel jpVerProductosCredito;
    private javax.swing.JPanel jpmAdministrador;
    private javax.swing.JPanel jpmAgenda;
    private javax.swing.JPanel jpmBaseDatos;
    private javax.swing.JPanel jpmClientes;
    private javax.swing.JPanel jpmCorte;
    private javax.swing.JPanel jpmEmpresa;
    private javax.swing.JPanel jpmGastos;
    private javax.swing.JPanel jpmInicio;
    private javax.swing.JPanel jpmInventario;
    private javax.swing.JPanel jpmLicencia;
    private javax.swing.JPanel jpmPuntoVenta;
    private javax.swing.JPanel jpmUsuarios;
    private javax.swing.JPanel jpmVentas;
    public static final javax.swing.JSpinner jsCantidad = new javax.swing.JSpinner();
    public static final javax.swing.JSpinner jsCantidadCliente = new javax.swing.JSpinner();
    public static final javax.swing.JTable jtAbonosCredito = new javax.swing.JTable();
    public static final javax.swing.JTable jtCitas = new javax.swing.JTable();
    public static final javax.swing.JTable jtClientes = new javax.swing.JTable();
    public static final javax.swing.JTable jtCreditosCliente = new javax.swing.JTable();
    public static final javax.swing.JTable jtGastos = new javax.swing.JTable();
    public static final javax.swing.JTable jtInventario = new javax.swing.JTable();
    public static final javax.swing.JTable jtProductosVentaCliente = new javax.swing.JTable();
    public static final javax.swing.JTable jtPuntoVenta = new javax.swing.JTable();
    public static final javax.swing.JTable jtUsuarios = new javax.swing.JTable();
    public static final javax.swing.JTable jtVentas = new javax.swing.JTable();
    public static final javax.swing.JTextArea jtaAnotacionesEmpresa = new javax.swing.JTextArea();
    public static final javax.swing.JTextArea jtaNotas = new javax.swing.JTextArea();
    public static final javax.swing.JTextArea jtaNotasCita = new javax.swing.JTextArea();
    public static final javax.swing.JToggleButton jtbPrecio = new javax.swing.JToggleButton();
    public static final javax.swing.JToggleButton jtbPrecioMayoreoCliente = new javax.swing.JToggleButton();
    private javax.swing.JTextField jtxtBuscar;
    private javax.swing.JTextField jtxtBuscarCliente;
    public static final javax.swing.JTextField jtxtCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtCodProdCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtCodigo = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtCodigoPostal = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtCosto = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtDescripcion = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtDirCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtDireccionCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtDireccionEmpresa = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtEmail = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtEmailEmpresa = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtExistencia = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtFacebookEmpresa = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtFactura = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtIdCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtIdProducto = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtIdUsuario = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtMayoreo = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtMetodoPago = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtMinimo = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtNomCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtNombreCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtNombreEmpresa = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtPaginaEmpresa = new javax.swing.JTextField();
    public static final javax.swing.JPasswordField jtxtPass = new javax.swing.JPasswordField();
    public static final javax.swing.JPasswordField jtxtPassRepeat = new javax.swing.JPasswordField();
    public static final javax.swing.JTextField jtxtPublico = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtRFC = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtTelefono = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtTelefonoCliente = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtTelefonoEmpresa = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtUser = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtUsuario = new javax.swing.JTextField();
    public static final javax.swing.JTextField jtxtUsuarioCita = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
