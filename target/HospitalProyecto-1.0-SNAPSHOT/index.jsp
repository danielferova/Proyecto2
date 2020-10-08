<%-- 
    Document   : index
    Created on : 7/10/2020, 19:47:44
    Author     : danielferova
--%>

<%@page import="ConexionBD.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ConexionBD.Conexion.crearConexion();
%>
<html>
    
    <body>
       <% if (request.getAttribute("Estado") == null) {%>
        <% RequestDispatcher d = request.getRequestDispatcher("AccesoInicio");
           d.forward(request, response);%>
           <% } else {%>
             <% if ((boolean)request.getAttribute("Estado")) {%>
           
            <% response.sendRedirect("PantallaAdmin.jsp"); %>
        <% } else {%>
            <% response.sendRedirect("CargaArchivo.jsp"); %>
        <% }%>
        <% }%>
    </body>
</html>
