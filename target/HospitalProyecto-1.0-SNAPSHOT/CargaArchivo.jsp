<%-- 
    Document   : CargaArchivo
    Created on : 2/10/2020, 19:24:23
    Author     : danielferova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <body>
        <% if (request.getAttribute("Cargado exitosamente!") == null) {%>
        

      
        
        <div class="container" style="padding-top: 60px" >
            <h1 class="align-content-lg-center">Carga de Archivo XML</h1>
     
            <FORM class="col-12 caja2" METHOD="POST" ACTION="CargandoArchivoServlet" enctype="multipart/form-data">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Elija el Archivo que desea Cargar a la Base de Datos: </label>
                    </div>
                    <div class="form-group col-md-4">
                        
                        <input class="form-control" type="file"  name="archivoXML" id="archivoXML" placeholder="Elija el Archivo" accept="application/xml" required>
                    </div>
                </div>
                <div class="row">
                        <div class="form-group col-md-5">
                            <label>Seleccione los Archivos Complementarios del Archivo XML</label>
                        </div>
                        <div class="form-group col-md-4">
                            <input class="form-control" type="file"  name="" id="archivosComplementariosDB" placeholder="Elija los archivos" accept=".pdf,image/*" multiple required>
                        </div>
                    </div>


                <br>
                <center>

                    <input class="btn btn-primary" type="submit" value="Cargar">
                    <input class="btn" type="reset" value="Eliminar Datos">
                </center>

            </form>

        </div>
        <% } else {%>
                    < <div class="container" style="padding-top: 60px" >
             <center>
            <h1 class="align-content-lg-center">Carga de Archivo</h1>
             </center>
                        
        <% if ((boolean)request.getAttribute("Cargado exitosamente!")) {%>
           

            <div class="alert alert-success">
                Carga de Archivo Realizada con Exito
            </div>
                <br>
                <CENTER>
               
                    <a href="PantallaAdmin.jsp" class="btn btn-primary">Iniciar Sesion</a>
              

                </CENTER>
      

        
        <% } else {%>
                       <div class="alert alert-danger">
               -- ERROR en la Carga del Archivo --
            </div>
                <br>
                <CENTER>
               
                    <a href="CargaArchivo.jsp" class="btn btn-primary">Iniciar Sesion</a>
              

                </CENTER>
        <% }%>
         </div>
        <% }%>

        
    </body>
</html>
