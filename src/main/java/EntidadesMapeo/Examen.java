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
public class Examen {
    //campos de la DB de la entidad EXAMEN
    private int idExamen;
    private String nombreExamen;
    private boolean ordenExamen;
    private String descripcionExamen;
    private double costoExamen;
    private String informeExamen;

    public Examen(int idExamen, String nombreExamen, boolean ordenExamen, String descripcionExamen, double costoExamen, String informeExamen) {
        this.idExamen = idExamen;
        this.nombreExamen = nombreExamen;
        this.ordenExamen = ordenExamen;
        this.descripcionExamen = descripcionExamen;
        this.costoExamen = costoExamen;
        this.informeExamen = informeExamen;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public boolean isOrdenExamen() {
        return ordenExamen;
    }

    public void setOrdenExamen(boolean ordenExamen) {
        this.ordenExamen = ordenExamen;
    }

    public String getDescripcionExamen() {
        return descripcionExamen;
    }

    public void setDescripcionExamen(String descripcionExamen) {
        this.descripcionExamen = descripcionExamen;
    }

    public double getCostoExamen() {
        return costoExamen;
    }

    public void setCostoExamen(double costoExamen) {
        this.costoExamen = costoExamen;
    }

    public String getInformeExamen() {
        return informeExamen;
    }

    public void setInformeExamen(String informeExamen) {
        this.informeExamen = informeExamen;
    }
    
    
    
}
