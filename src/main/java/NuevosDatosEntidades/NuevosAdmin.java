/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;

import ConexionBD.Conexion;
import EntidadesMapeo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosAdmin {

  //  PreparedStatement ps;
  //  Connection conexion;
  //  PreparedStatement ps1;
    
    public boolean agregarAdmin(Administrador admin) 
    {
         String sql = "INSERT INTO USUARIO (id_Usuario, Nombre_Usuario, Dpi_Usuario, Telefono_Usuario, "
                 + "Correo_Usuario, Contraseña_Usuario, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String sql1 = "INSERT INTO ADMINISTRADOR (id_Usuario) "
                + "VALUES(?)";
        
        try {
            PreparedStatement ps = Conexion.conexion.prepareStatement(sql);
           // ps  = conexion.prepareStatement(sql);
            ps.setString(1, admin.getIdUsuario());
            ps.setString(2, admin.getNombreUsuario());
            ps.setString(3, admin.getDpiUsuario());
            ps.setString(4, admin.getTelefonoUsuario());
            ps.setString(5, admin.getCorreoUsuario());
            ps.setString(6, admin.getContraseñaUsuario());
            ps.setInt(7, 1);
            ps.executeUpdate();
            //mando los datos a LABORATORISTA
            PreparedStatement ps1 = Conexion.conexion.prepareStatement(sql1);
       //     ps1  = conexion.prepareStatement(sql1);
            ps1.setString(1, admin.getIdUsuario());
            ps1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
       
       
    }
    
     public boolean verificarEstadoDB(){
        
        Administrador admin = null;
        
     // String sql =  "SELECT u.id_Usuario, u.Nombre_Usuario, u.Dpi_Usuario, u.Telefono_Usuario, u.Correo_Usuario, u.Contraseña_Usuario, u.Tipo_Usuario FROM ADMINISTRADOR a INNER JOIN USUARIO u ON a.id_Usuario = u.id_Usuario";
        
        ResultSet resultSet = Conexion.getTabla("SELECT u.id_Usuario, u.Nombre_Usuario, u.Dpi_Usuario, u.Telefono_Usuario, u.Correo_Usuario, u.Contraseña_Usuario, u.Tipo_Usuario FROM ADMINISTRADOR a INNER JOIN USUARIO u ON a.id_Usuario = u.id_Usuario");
        try {
            while (resultSet.next()) {
                admin = new Administrador(resultSet.getString("id_Usuario"), resultSet.getString("Nombre_Usuario"), 
                        resultSet.getString("Dpi_Usuario"), resultSet.getString("Telefono_Usuario"), resultSet.getString("Correo_Usuario"),
                        resultSet.getString("Contraseña_Usuario"), resultSet.getInt("Tipo_Usuario"));
            }

        } catch (Exception e) {

        }
           if(admin == null)
           {
               return false;
           } else
           {
           return true;
           }
    
    }
}
