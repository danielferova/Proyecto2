/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesMapeo;

import java.io.Serializable;

/**
 *
 * @author danielferova
 */
public class Administrador extends Usuario implements Serializable{
    /**
     * -- Parametros en Admin --
     * @param IdAdmin
     * @param nombreAdmin
     * @param dpiAdmin
     * @param telefonoAdmin
     * @param correoAdmin
     * @param contraseñaAdmin
     * @param tipo
    
     */
     public Administrador(String IdAdmin, String nombreAdmin, String dpiAdmin, String telefonoAdmin, 
             String correoAdmin, String contraseñaAdmin, int tipo ) {
             super(IdAdmin, nombreAdmin, dpiAdmin, telefonoAdmin, correoAdmin, contraseñaAdmin, tipo);
    }
     
}
