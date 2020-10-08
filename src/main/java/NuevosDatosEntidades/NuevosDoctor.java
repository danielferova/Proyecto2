/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;


import EntidadesMapeo.Doctor;
import EntidadesMapeo.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosDoctor {
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    Connection conexion = null;
    ResultSet resultSet = null;
    
    public boolean agregarDoctor (Doctor doctor, Especialidad especialidad) 
    {
         String sql = "INSERT INTO USUARIO (id_Usuario, Nombre_Usuario, Dpi_Usuario, Telefono_Usuario, "
                 + "Correo_Usuario, Contraseña_Usuario, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

         String sql1 = "INSERT INTO DOCTOR (id_Usuario, Num_Colegiado, Horario_Atencion, Horario_Salida,"
                 + " Fecha_Inicio) "
                + "VALUES(?,?,?,?,?)";

         String sql2 = "INSERT INTO ESPECIALIDAD (Nombre_Especialidad, DOCTOR_id_Usuario) "
                + "VALUES(?,?,?)";
         
         try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, doctor.getIdUsuario());
            ps.setString(2, doctor.getNombreUsuario());
            ps.setString(3, doctor.getDpiUsuario());
            ps.setString(4, doctor.getTelefonoUsuario());
            ps.setString(5, doctor.getCorreoUsuario());
            ps.setString(6, doctor.getContraseñaUsuario());
            ps.setInt(7, 4);
            ps.executeUpdate();
            //datos o campos extras de DOCTOR
            ps1  = conexion.prepareStatement(sql1);
            ps1.setString(1, doctor.getIdUsuario());
            ps1.setInt(2, doctor.getNumColegiado());
            ps1.setString(3, doctor.getHorarioAtencion());
            ps1.setString(4, doctor.getHorarioSalida());
            ps1.setString(5, doctor.getFechaInicio());
            ps1.executeUpdate();

            ps2  = conexion.prepareStatement(sql2);
            //ERROR DEBIDO A QUE NECESITO RECORRER UN ARRAYLIST Y NO SE COMO
            
            for(int i=0; i< especialidad.getNombreEspecialidad().size();i++){
                ps2.setString(1, especialidad.getNombreEspecialidad().get(i).toString());
                ps2.setString(2, doctor.getIdUsuario()); //Envio del Codigo del Medico, al cual se le asigno dicha especialidad
                ps2.executeUpdate();
            }
           

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return false;

        
    }
    
        
}
