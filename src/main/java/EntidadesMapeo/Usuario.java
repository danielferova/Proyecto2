/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesMapeo;

/**
 *
 * @author danielferova
 */
public class Usuario {
    //atributos
    private String idUsuario;
    private String nombreUsuario;
    private String dpiUsuario;
    private String telefonoUsuario;
    private String correoUsuario;
    private String contraseñaUsuario;
    private int tipoUsuario;
/**
 * 
 * @param idUsuario
 * @param nombreUsuario
 * @param dpiUsuario
 * @param telefonoUsuario
 * @param correoUsuario
 * @param contraseñaUsuario
 * @param tipoUsuario 
 */
    public Usuario(String idUsuario, String nombreUsuario, String dpiUsuario, String telefonoUsuario, String correoUsuario, String contraseñaUsuario, int tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.dpiUsuario = dpiUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.correoUsuario = correoUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDpiUsuario() {
        return dpiUsuario;
    }

    public void setDpiUsuario(String dpiUsuario) {
        this.dpiUsuario = dpiUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
}
