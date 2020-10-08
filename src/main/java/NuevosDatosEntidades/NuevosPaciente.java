/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import EntidadesMapeo.Paciente;
import Exception.NoRegistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosPaciente {
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    Connection conexion = null;
    ResultSet resultSet = null;
    
    public boolean agregarPaciente(Paciente paciente) //throws NoRegistro
    {
         String sql = "INSERT INTO USUARIO (id_Usuario, Nombre_Usuario, Dpi_Usuario, Telefono_Usuario, "
                 + "Correo_Usuario, Contraseña_Usuario, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String sql1 = "INSERT INTO PACIENTE (id_Usuario, Sexo, Fecha_Nacimiento, Peso_Paciente, Tipo_Sangre) "
                + "VALUES(?,?,?,?,?)";
        
        try {

            ps  = conexion.prepareStatement(sql);
            ps.setString(1, paciente.getIdUsuario());
            ps.setString(2, paciente.getNombreUsuario());
            ps.setString(3, paciente.getDpiUsuario());
            ps.setString(4, paciente.getTelefonoUsuario());
            ps.setString(5, paciente.getCorreoUsuario());
            ps.setString(6, paciente.getContraseñaUsuario());
            ps.setInt(7, 3);
            ps.executeUpdate();
            //datos o campos de la entidad PACIENTE
            ps1  = conexion.prepareStatement(sql1);
            ps1.setString(1, paciente.getIdUsuario());
            ps1.setString(2, paciente.getSexo());
            ps1.setString(3, paciente.getBirthPaciente());
            ps1.setString(4, paciente.getPesoP());
            ps1.setString(5, paciente.getSangreP());
            ps1.executeUpdate();
            System.out.println("PACIENTE REGISTRADO!");

            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL ASIGNAR DATOS AL EXAMEN!");
           // throw new NoRegistro("");
            ex.printStackTrace(System.out);
            
          return false;
        }

      
    
    }
    private void ingresarPaciente(Paciente paciente,PreparedStatement ps) //throws DatosNoRegistradosException
    {
        try {
            /*
            ps.setString(1, paciente.getIdPaciente());
            ps.setString(2, paciente.getNombrePaciente());
            ps.setString(3, paciente.getSexo());
            ps.setString(4, paciente.getBirthPaciente());
            ps.setString(5, paciente.getDpiPaciente());
            ps.setString(6, paciente.getTelefonoP());
            ps.setString(7, paciente.getPesoP());
            ps.setString(8, paciente.getSangreP());
            ps.setString(9, paciente.getCorreoP());*/
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar lso datos del PACIENTE");
           // throw new DatosNoRegistradosException("");
        }
    }
    
}
