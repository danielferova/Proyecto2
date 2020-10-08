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
public class CitaLab {
    //CAMPOS DE LA DB DE LA ENTIDAD CITA
    private int idCita;
    private String idPaciente;
    private String idLab;
   // private String idExamen;
    private String fecha;
    private String hora;

    public CitaLab(int idCita, String idPaciente, String idLab, String fecha, String hora) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idLab = idLab;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
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
