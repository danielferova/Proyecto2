/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproyecto;

import ArchivoCarga.CargandoArchivo;
import NuevosDatosEntidades.NuevosAdmin;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author danielferova
 */
//@WebServlet(name = "CargandoArchivoServlet", urlPatterns = {"/CargandoArchivoServlet"})
@WebServlet("/CargandoArchivoServlet")
//@MultipartConfig(maxFileSize = 16177215) //MaximoDelArchivo = 16mb
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class CargandoArchivoServlet extends HttpServlet {
public static final String BASE_PATH = "/app";
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try ( PrintWriter out = response.getWriter()) {
            //imprimiendo HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CargandoArchivoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CargandoArchivoServlet" + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        processRequest(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println("Procesando Archivo");
            
            Part archivo = request.getPart("archivoXML");
             String nombreArchivo = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();
             System.out.println("Path del Archivo: "+nombreArchivo);
             String pathAbsolutoArchivo = "/home/danielferova/NetBeansProjects/HospitalProyecto/src/main/webapp/Archivo/"+nombreArchivo;
             //nombreArchivo = data.xml
             guardarArchivos(archivo, nombreArchivo);
             
             //Guardar todos los Archivos que estan incluidos dentro de la carga del Archivo en la carpeta ArchivosDB
                 
             ArrayList<Part> filePartArchivosDB = (ArrayList<Part>) request.getParts();       
             for (Part part : filePartArchivosDB) {
             String rutaArchivo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            guardarArchivos(part, rutaArchivo);
            }
             //
             CargandoArchivo lectura = new CargandoArchivo();
             lectura.llamandoArchivo(pathAbsolutoArchivo);
             NuevosAdmin admin = new NuevosAdmin();
             if(admin.verificarEstadoDB())
             {
                    request.setAttribute("Exitoso", true);
     
             }else
             {
                request.setAttribute("Exitoso", false);
     
             }

        RequestDispatcher d = request.getRequestDispatcher("CargaArchivo.jsp");
        d.forward(request, response);
        
            
       
            
            
            
           /*  Part archivo = request.getPart("archivoXML");
             String file = archivo.getSubmittedFileName();
             
            // String fileName = getFileName(filePart);
        InputStream fileStream = archivo.getInputStream();
        /// a DB
        String path = BASE_PATH + "/" + file;
        archivo.write(path);
        
        String mimeType = archivo.getContentType();
        System.out.println("type: " + mimeType);
        System.out.println("file name: " + file);
             
             
             
             CargandoArchivo llamando = new CargandoArchivo();
             llamando.llamandoArchivo(file);
             
             NuevosAdmin admin = new NuevosAdmin();
             
             if(admin.verificarEstadoDB())
             {
                    request.setAttribute("Cargado", true);
     
             }else
             {
                request.setAttribute("Cargado", false);
     
             }

        
        RequestDispatcher d = request.getRequestDispatcher("CargaArchivo.jsp");
        d.forward(request, response);*/
    }
    
     private void guardarArchivos(Part filePart, String rutaArchivo){
        File rutaDestino = new File("/home/danielferova/NetBeansProjects/HospitalProyecto/src/main/webapp/Archivo");
        File file = new File(rutaDestino,rutaArchivo);

        try(InputStream inputS = filePart.getInputStream()) {
            Files.copy(inputS, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
