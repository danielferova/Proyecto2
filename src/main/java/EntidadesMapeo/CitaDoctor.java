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
public class CitaDoctor {
    //CAMPOS DE LA DB DE LA ENTIDAD CITA_DOCTOR
    private int idCitaDoctor;
    private String idPaciente;
    private String idDoctor;
    private String tipoConsulta;
    private String fecha;
    private String hora;

    public CitaDoctor(int idCitaDoctor, String idPaciente, String idDoctor, String tipoConsulta, String fecha, String hora) {
        this.idCitaDoctor = idCitaDoctor;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.tipoConsulta = tipoConsulta;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdCitaDoctor() {
        return idCitaDoctor;
    }

    public void setIdCitaDoctor(int idCitaDoctor) {
        this.idCitaDoctor = idCitaDoctor;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
}
