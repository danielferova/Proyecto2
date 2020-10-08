/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesMapeo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielferova
 */
public class Especialidad {
    //campos de la DB
    private List<String> nombreEspecialidad = new ArrayList<>();

    public Especialidad(List nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public List<String> getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(List<String> nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
   
    
    
}
