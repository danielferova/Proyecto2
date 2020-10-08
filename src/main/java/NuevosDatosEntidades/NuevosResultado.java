/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import EntidadesMapeo.Resultado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosResultado {
    PreparedStatement ps = null;
    Connection conexion = null;
    ResultSet resultSet = null;
    
    public boolean agregarResultado(Resultado resultado) //throws DatosNoRegistradosException
    {
        String sql = "INSERT INTO RESULTADO (Id_Resultado, PACIENTE_id_Usuario, DOCTOR_id_Usuario, EXAMEN_Id_Examen,"
                + " LABORATORISTA_id_Usuario, Orden_Resultado, Informe_Resultado, Fecha_Resultado, Hora_Resultado) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

         try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, resultado.getIdResul());
            ps.setString(2, resultado.getIdPaciente());
            ps.setString(3, resultado.getIdDoctor());
            ps.setString(4, resultado.getIdLab());
            ps.setInt(5, resultado.getIdExamen());
            ps.setString(6, resultado.getOrdenResul());
            ps.setString(7, resultado.getInformeResul());
            ps.setString(8, resultado.getFechaResul());
            ps.setString(9, resultado.getHoraResul());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

        
    }
}
