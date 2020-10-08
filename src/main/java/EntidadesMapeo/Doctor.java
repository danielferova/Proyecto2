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
public class Doctor extends Usuario {
   //campos de la DB de entidad DOCTOR
    private int numColegiado;
    private String horarioAtencion;
    private String horarioSalida;
    private String fechaInicio;

    public Doctor(String idUsuario, String nombreUsuario, String dpiUsuario, String telefonoUsuario, String correoUsuario, String contraseñaUsuario, int tipoUsuario, 
            int numColegiado, String horarioAtencion, String horarioSalida, String fechaInicio) {
        super(idUsuario, nombreUsuario, dpiUsuario, telefonoUsuario, correoUsuario, contraseñaUsuario, tipoUsuario);
        this.numColegiado = numColegiado;
        this.horarioAtencion = horarioAtencion;
        this.horarioSalida = horarioSalida;
        this.fechaInicio = fechaInicio;
    }

    public int getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    
    
    
    
    
    
}
