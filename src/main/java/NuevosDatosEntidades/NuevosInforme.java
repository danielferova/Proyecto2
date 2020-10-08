/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import EntidadesMapeo.Informe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosInforme {
    PreparedStatement ps = null;
    Connection conexion = null;
    ResultSet resultSet = null;
    
     public boolean agregarInforme(Informe informe) 
    {
          String sql = "INSERT INTO INFORME (Id_Informe, PACIENTE_id_Usuario, DOCTOR_id_Usuario, "
                  + "Descripcion_Informe, Fecha_Informe, Hora_Informe) "
                + "VALUES(?,?,?,?,?,?,?)";
          
           try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, informe.getIdInfo());
            ps.setString(2, informe.getIdPaciente());
            ps.setString(3, informe.getIdDoctor());
            ps.setString(4, informe.getDescripcionInfo());
            ps.setString(5, informe.getFechaInfo());
            ps.setString(6, informe.getHoraInfo());
            ps.executeUpdate();
            System.out.println("Informe REGISTRADO!");
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
        
    }
    
}
