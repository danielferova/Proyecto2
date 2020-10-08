<%-- 
    Document   : RegistrarAdmin
    Created on : 4/10/2020, 03:31:08
    Author     : danielferova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
           
       <%@ include file = "AdminRegistro.html" %>
        <% if (request.getAttribute("REGISTRADO") == null) {%>
         
         <center>
                        <h2>Ingrese los datos que se le piden a continuación: </h2>
                    </center>
                    <hr width="80%">.
                    <div class="col-xs-12">
                        <form method="post" action="RegistroAdmin" >
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Código: </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="IdAdmin" id="IdAdmin" placeholder="Código" required="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Nombre: </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="nombreAdmin" id="nombreAdmin" placeholder="Nombre" required="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">DPI:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="DpiAdmin" id="DpiAdmin" placeholder="DPI" required="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Telefono:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="telefonoAdmin" id="telefonoAdmin" placeholder="Telefono" required="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmailAdmin" class="col-sm-2 control-label">Correo Electronico: </label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" name="correoAdmin" id="correoAdmin" placeholder="email" required="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPasswordAdmin" class="col-sm-2 control-label">Contraseña: </label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" name="contraseñaAdmin" id="contraseñaAdmin" placeholder="Password" required="">
                                </div>
                            </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Registrar Administrador</button>
                            <button type="reset" class="btn btn-default">Eliminar Datos</button>
                        </div>
                    </div>
                            
                             </form>
                         </div>
        <% } else {%>
        <div class="container" style="padding-top: 60px" >
            <h1 class="align-content-lg-center">Nuevo Administrador</h1>

            <% if ((boolean) request.getAttribute("REGISTRADO")) {%>
            <div class="alert alert-success">
                ¡Nuevo Administrador registrado!
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                ERROR! Al registrar el Administrador
            </div>
            <div class="col-12 caja2">
                <center>

                    <a href="RegistrarAdmin.jsp" class="btn btn-primary">-- Volver a ingresar los datos de nuevo --</a>

                </center>
            </div>
            <% }%>
        </div>
        <% }%>
    </body>
</html>
