/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import EntidadesMapeo.DiasDeTrabajo;
import EntidadesMapeo.Laboratorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosLab {
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    Connection conexion = null;
    ResultSet resultSet = null;
    
     public boolean agregarLab(Laboratorista lab, DiasDeTrabajo dias) 
    {
         String sql = "INSERT INTO USUARIO (id_Usuario, Nombre_Usuario, Dpi_Usuario, Telefono_Usuario,"
                 + " Correo_Usuario, Contraseña_Usuario, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String sql1 = "INSERT INTO LABORATORISTA (id_Usuario, Registro_Ministerio, Nombre_Examen,"
                + " Fecha_Inicio, EXAMEN_Id_Examen) "
                + "VALUES(?,?,?,?, "
                + "(SELECT Id_Examen FROM EXAMEN WHERE Nombre_Usuario = ? LIMIT 1))";

        String sql2 = "INSERT INTO DIAS_TRABAJO (Dias_Trabajo, LABORATORISTA_id_Usuario) "
                + "VALUES(?,?)";
        
          try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, lab.getIdUsuario());
            ps.setString(2, lab.getNombreUsuario());
            ps.setString(3, lab.getDpiUsuario());
            ps.setString(4, lab.getTelefonoUsuario());
            ps.setString(5, lab.getCorreoUsuario());
            ps.setString(6, lab.getContraseñaUsuario());
            ps.setInt(7, 2);
            ps.executeUpdate();
            //datos o campos del lab de la entidad laboratorista
            ps1 = conexion.prepareStatement(sql1);
            ps1.setString(1, lab.getIdUsuario());
            ps1.setString(2, lab.getRegistroMinisterio());
            ps1.setString(3, lab.getNombreExamen());
            ps1.setString(4, lab.getFechaLab());
            ps1.setString(5, lab.getNombreExamen());
            ps1.executeUpdate();
            //envio los datos de dias de trabajo
            ps2 = conexion.prepareStatement(sql2); //foreach arraylist
            for (int i = 0;i<dias.getDiasTrabajo().size();i++) {  
                ps2.setString(1, dias.getDiasTrabajo().get(i).toString());
                ps2.setString(2, lab.getIdUsuario()); //Envio del Codigo del laboratorista, al cual se le asigno dicho dia
                ps2.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return false;
        
    }
    
}
