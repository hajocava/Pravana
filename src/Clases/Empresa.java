
package Clases;

public class Empresa {
    static String nombre,direccion,telefono,correo,pagina,facebook,rutaLogo,notas;
    
    public Empresa(String nombre,String direccion,String telefono,String correo,
            String pagina,String facebook,String rutaLogo,String notas){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.pagina = pagina;
        this.facebook = facebook;
        this.rutaLogo = rutaLogo;
        this.notas = notas;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Empresa.nombre = nombre;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static void setDireccion(String direccion) {
        Empresa.direccion = direccion;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        Empresa.telefono = telefono;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        Empresa.correo = correo;
    }

    public static String getPagina() {
        return pagina;
    }

    public static void setPagina(String pagina) {
        Empresa.pagina = pagina;
    }

    public static String getFacebook() {
        return facebook;
    }

    public static void setFacebook(String facebook) {
        Empresa.facebook = facebook;
    }

    public static String getRutaLogo() {
        return rutaLogo;
    }

    public static void setRutaLogo(String rutaLogo) {
        Empresa.rutaLogo = rutaLogo;
    }

    public static String getNotas() {
        return notas;
    }

    public static void setNotas(String notas) {
        Empresa.notas = notas;
    }
    
    

}
