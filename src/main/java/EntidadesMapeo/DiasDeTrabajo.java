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
public class DiasDeTrabajo {
    //atributo dentro de un arraylist y una list
    private List diasTrabajo = new ArrayList<>();

    public DiasDeTrabajo(List diasTrabajo) {
        this.diasTrabajo = diasTrabajo;
    }

    public List getDiasTrabajo() {
        return diasTrabajo;
    }

    public void setDiasTrabajo(List diasTrabajo) {
        this.diasTrabajo = diasTrabajo;
    }
    
    
    
}
