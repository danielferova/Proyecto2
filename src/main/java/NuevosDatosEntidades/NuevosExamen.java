/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosDatosEntidades;


import ConexionBD.Conexion;
import EntidadesMapeo.Examen;
import Exception.NoRegistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielferova
 */
public class NuevosExamen {
 //   PreparedStatement ps ;
   // Connection conexion ;
    ResultSet resultSet = null;
    
      public boolean agregarExamen(Examen examen)// throws NoRegistro
    {
        String sql = "INSERT INTO EXAMEN (Id_Examen, Nombre_Examen, Orden_Examen, Descripcion_Examen,"
                + "Costo_Examen, Informe_Examen) VALUES(?,?,?,?,?,?)";
        
        try {
                        PreparedStatement ps = Conexion.conexion.prepareStatement(sql);

           // ps = conexion.prepareStatement(sql);
            ps.setInt(1, examen.getIdExamen());
            ps.setString(2, examen.getNombreExamen());
            ps.setBoolean(3, examen.isOrdenExamen());
            ps.setString(4, examen.getDescripcionExamen());
            ps.setDouble(5, examen.getCostoExamen());
            ps.setString(6, examen.getInformeExamen());
            ps.executeUpdate();
            System.out.println("EXAMEN REGISTRADO!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ASIGNAR DATOS AL EXAMEN!");
          //  throw new NoRegistro("");
            e.printStackTrace(System.out);
            return false;
        }
      

        
        
    }
    
}
