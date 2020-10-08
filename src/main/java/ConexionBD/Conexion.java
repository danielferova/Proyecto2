/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author danielferova
 */
public class Conexion {
     private static String url="jdbc:mysql://localhost:3306/HospitalProyecto";
    public static Connection conexion = null;
   // Connection conexion = null;
   // PreparedStatement preparedStatement = null;
    
    /*
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "ferova";
    private final String password = "defo1412guate";
    private final String url = "jdbc:mysql://localhost:3306/HospitalProyecto";
    
        public Connection conectandoBase() {
        try {
            conexion = (Connection) DriverManager.getConnection(url, user, password);
                        if(conexion != null){
                System.out.println("Conexion establecida");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar" + ex);
        }
        return conexion;
    }    
    //metodo encargado de salir de la base de datos
    public void desconectarDB(){
        conexion = null;
        if(conexion == null){
            System.out.println("Conexion terminada");
        }
    }
    
      public Connection getConnection() {
        return conexion;
    }*/
    
      public static void crearConexion(){
        if(conexion == null){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalProyecto", "root", "defo910hlfer");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex){
        System.out.println("Error DB: " + ex.getMessage());
            ex.printStackTrace();
        }
        }
    }
    
    public static Connection getInstance(){
        if(conexion == null){
            conexion = (Connection) new Conexion();
        }
            
        return conexion;
    }
    
    public static Connection conexionDB() throws SQLException{
        String url="jdbc:mysql://localhost:3306/HospitalProyecto";
        return DriverManager.getConnection(url,"root","defo910hlfer");
    }
    public static void close(Connection cerrar){
        try {
            cerrar.close();
        } catch (SQLException eX) {

        }
    }
    public static void close(PreparedStatement cerrar){
        try {
            cerrar.close();
        } catch (SQLException eX) {

        }
    }
  
      public static ResultSet getTabla(String consulta) {
       // Connection c = conectandoBase();
       Connection c = conexion;
       Statement st;
        ResultSet datos = null;
        try {
            st = c.createStatement();
            datos = st.executeQuery(consulta);
        } catch (SQLException e) {
        }
        return datos;
    }
}


