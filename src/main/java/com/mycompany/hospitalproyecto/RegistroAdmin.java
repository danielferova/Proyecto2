/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproyecto;

import EntidadesMapeo.Administrador;
import NuevosDatosEntidades.NuevosAdmin;
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
//@WebServlet(name = "RegistroAdmin", urlPatterns = {"/RegistroAdmin"})
@WebServlet("/RegistroAdmin")

public class RegistroAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        processRequest(request, response);
    }

  
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idAdmin = request.getParameter("IdAdmin");
        String nombreAdmin = request.getParameter("nombreAdmin");
        String dpiAdmin = request.getParameter("DpiAdmin");
        String telefonoAdmin = request.getParameter("telefonoAdmin");
        String correoAdmin = request.getParameter("correoAdmin");
        String contraseñaAdmin = request.getParameter("contraseñaAdmin");
        Administrador admin = new Administrador(idAdmin, nombreAdmin, dpiAdmin, telefonoAdmin,
                correoAdmin, contraseñaAdmin, 1);
        //instanciando mi clase de la query
        NuevosAdmin registrar = new NuevosAdmin();
        if (registrar.agregarAdmin(admin)) {
            request.setAttribute("Se registro exitosamente", true);
        } else {
            request.setAttribute("Se registro exitosamente", false);
        }
        RequestDispatcher d = request.getRequestDispatcher("RegistrarAdmin.jsp");
        d.forward(request, response);

    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
