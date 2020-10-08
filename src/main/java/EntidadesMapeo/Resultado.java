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
public class Resultado {
    //campos de la DB DE LA ENTIDAD RESULTADO
    private int idResul;
     private String idPaciente;
    private String idDoctor;
    private int idExamen;
    private String idLab;
    private String ordenResul;
    private String informeResul;
    private String fechaResul;
    private String horaResul;

    public Resultado(int idResul, String idPaciente, String idDoctor, int idExamen, String idLab, String ordenResul, String informeResul, String fechaResul, String horaResul) {
        this.idResul = idResul;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.idExamen = idExamen;
        this.idLab = idLab;
        this.ordenResul = ordenResul;
        this.informeResul = informeResul;
        this.fechaResul = fechaResul;
        this.horaResul = horaResul;
    }

    public int getIdResul() {
        return idResul;
    }

    public void setIdResul(int idResul) {
        this.idResul = idResul;
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

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getOrdenResul() {
        return ordenResul;
    }

    public void setOrdenResul(String ordenResul) {
        this.ordenResul = ordenResul;
    }

    public String getInformeResul() {
        return informeResul;
    }

    public void setInformeResul(String informeResul) {
        this.informeResul = informeResul;
    }

    public String getFechaResul() {
        return fechaResul;
    }

    public void setFechaResul(String fechaResul) {
        this.fechaResul = fechaResul;
    }

    public String getHoraResul() {
        return horaResul;
    }

    public void setHoraResul(String horaResul) {
        this.horaResul = horaResul;
    }
   


    
    
}
