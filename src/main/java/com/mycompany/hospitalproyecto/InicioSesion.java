/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproyecto;

import ConexionBD.Conexion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielferova
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {
    // Conexion conexion;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
       Conexion conexion = new Conexion();
       //     request.getSession().setAttribute("conexion", conexion.getConnection());
        
     //   dBConectorPerfil = new DBConectorPerfil(conexionSQL.getConnection());
      /*  try {
            
            Perfil perfil = dBConectorPerfil.validarUsuario(request.getParameter("id"), request.getParameter("password"));
            request.getSession().setAttribute("usuario", perfil);
            switch (perfil.getTipoUsuario()) {
                case Usuario.ADMINISTRADOR:
                    requestDispatcher = request.getRequestDispatcher("PerfilAdministrador.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                case Usuario.LABORATORISTA:
                    requestDispatcher = request.getRequestDispatcher("PerfilLaboratorista.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                case Usuario.MEDICO:
                    requestDispatcher = request.getRequestDispatcher("PerfilMedico.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                case Usuario.PACIENTE:
                    requestDispatcher = request.getRequestDispatcher("PerfilAdministrador.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                default:
                    request.setAttribute("credencialesNoValidas", true);
                    requestDispatcher = request.getRequestDispatcher("InicioDeSesion.jsp");
                    requestDispatcher.forward(request, response);
                    break;
            }
            
        } catch (CredencialesIncorrectasException e) {
            request.setAttribute("credencialesNoValidas", true);*/
        RequestDispatcher d = request.getRequestDispatcher("InicioSesion.jsp");
        d.forward(request, response);  
            
        }
        
    }
    
    
//}
