/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import EntidadesMapeo.CitaDoctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosCitaDoctor {
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    Connection conexion = null;
    ResultSet resultSet = null;
    
     public boolean agregarCitaDoctor(CitaDoctor cita) 
    {
         String sql = "INSERT INTO CITA_DOCTOR (Id_CitaDoctor, PACIENTE_id_Usuario , DOCTOR_id_Usuario, "
                 + "CONSULTA_Tipo_Consulta, Fecha_CitaD, Hora_CitaD) "
                + "VALUES(?,?,?,?,?,?)";
        
        String sql2 = "INSERT INTO GANANCIAS_DOCTOR (PACIENTE_id_Usuario, DOCTOR_id_Usuario, Fecha_GananciasD,"
                + " Total_GananciasD, CITA_DOCTOR_Id_CitaDoctor) "
                + "VALUES(?,?,?, (SELECT Costo_Consulta FROM CONSULTA WHERE Tipo_Consulta = ? LIMIT 1),?)"; 
        
        
       try {

            ps = conexion.prepareStatement(sql);

            //Envio de los Datos Principales de la Cita de un Medico a la Tabla Cita_Medico
            ps.setInt(1, cita.getIdCitaDoctor());
            ps.setString(2, cita.getIdPaciente());
            ps.setString(3, cita.getIdDoctor());
            ps.setString(4, cita.getTipoConsulta());
            ps.setString(5, cita.getFecha());
            ps.setString(6, cita.getHora());
            ps.executeUpdate();
            
            ps1  = conexion.prepareStatement(sql2);

            //Envio de los Datos Principales de la Cita de un Medico a la Tabla Ingresos_Medico
            ps1.setString(1, cita.getIdPaciente());
            ps1.setString(2, cita.getIdDoctor());
            ps1.setString(3, cita.getFecha());
            ps1.setString(4, cita.getTipoConsulta());
            ps1.setInt(5, cita.getIdCitaDoctor());
            ps1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

        
    }
    
    
}
