/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import EntidadesMapeo.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosConsulta {

    PreparedStatement ps = null;
    Connection conexion = null;
    ResultSet resultSet = null;

    public boolean agregarConsulta(Consulta consulta) {

        String sql = "INSERT INTO CONSULTA (Tipo_Consulta, Costo_Consulta) VALUES(?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, consulta.getTipoConsulta());
            ps.setDouble(2, consulta.getCostoConsulta());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
    }
}
