/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author danielferova
 */
public class NoRegistro extends Exception {
   //excepcion para los datos no registrados
    public NoRegistro(String message) {
        super(message);
    }
}
