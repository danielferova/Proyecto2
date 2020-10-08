<%-- 
    Document   : InicioSesion
    Created on : 1/10/2020, 04:03:38
    Author     : danielferova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospital (Code Hero)</title>
        <%@include file="prueba.html" %>
    </head>
    <body>
        <h1>Bienvenido!</h1>
        <%
            session.setAttribute("usuario", null);
        %>


    <c:if test="${requestScope['credencialesNoValidas']==true}">
        <script type="text/javascript">
            $(document).ready(function () {
                $('#InfoModalCredenciales').modal('show');
            });
        </script>
    </c:if>
    <%@include file="IniciarSesion.html" %>

</body>
</html>
