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
public class Laboratorista extends Usuario {
    //campos de la base de datoa de la entidad Laboratorista
    private String registroMinisterio;
    private String nombreExamen;
    private String fechaLab;
    private int idExamen;

    public Laboratorista(String idUsuario, String nombreUsuario, String dpiUsuario, String telefonoUsuario, String correoUsuario, String contraseñaUsuario, int tipoUsuario,
            String registroMinisterio, String nombreExamen, String fechaLab, int idExamen) {
        super(idUsuario, nombreUsuario, dpiUsuario, telefonoUsuario, correoUsuario, contraseñaUsuario, tipoUsuario);
        this.registroMinisterio = registroMinisterio;
        this.nombreExamen = nombreExamen;
        this.fechaLab = fechaLab;
        this.idExamen = idExamen;
    }

    public String getRegistroMinisterio() {
        return registroMinisterio;
    }

    public void setRegistroMinisterio(String registroMinisterio) {
        this.registroMinisterio = registroMinisterio;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getFechaLab() {
        return fechaLab;
    }

    public void setFechaLab(String fechaLab) {
        this.fechaLab = fechaLab;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

   
    
    
    
}
