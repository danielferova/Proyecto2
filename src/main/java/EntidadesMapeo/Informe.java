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
public class Informe {
    //CAMPOS DE LA DB de la entidad INFORME
    private int idInfo;
    private String idPaciente;
    private String idDoctor;
    private String descripcionInfo;
    private String fechaInfo;
    private String horaInfo;

    public Informe(int idInfo, String idPaciente, String idDoctor, String descripcionInfo, String fechaInfo, String horaInfo) {
        this.idInfo = idInfo;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.descripcionInfo = descripcionInfo;
        this.fechaInfo = fechaInfo;
        this.horaInfo = horaInfo;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
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

    public String getDescripcionInfo() {
        return descripcionInfo;
    }

    public void setDescripcionInfo(String descripcionInfo) {
        this.descripcionInfo = descripcionInfo;
    }

    public String getFechaInfo() {
        return fechaInfo;
    }

    public void setFechaInfo(String fechaInfo) {
        this.fechaInfo = fechaInfo;
    }

    public String getHoraInfo() {
        return horaInfo;
    }

    public void setHoraInfo(String horaInfo) {
        this.horaInfo = horaInfo;
    }
    
    
    
}
