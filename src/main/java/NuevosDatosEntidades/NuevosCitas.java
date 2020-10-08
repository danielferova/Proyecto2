/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import EntidadesMapeo.CitaLab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosCitas {
    PreparedStatement ps = null;
    Connection conexion = null;
    ResultSet resultSet = null;
    
    public void agregarCitaLab(CitaLab cita) {
       
        String sql = "INSERT INTO CITA (PACIENTE_id_Usuario, LABORATORISTA_id_Usuario, Fecha_Cita, Hora_Cita) "
                + "VALUES(?,?,?,?)";
         try {

            ps = conexion.prepareStatement(sql);
            ps.setString(1, cita.getIdPaciente());
            ps.setString(2, cita.getIdLab());
            ps.setString(3, cita.getFecha());
            ps.setString(4, cita.getHora());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
