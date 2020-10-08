/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoCarga;

import EntidadesMapeo.Administrador;
import EntidadesMapeo.CitaDoctor;
import EntidadesMapeo.Consulta;
import EntidadesMapeo.DiasDeTrabajo;
import EntidadesMapeo.Doctor;
import EntidadesMapeo.Especialidad;
import EntidadesMapeo.Examen;
import EntidadesMapeo.Informe;
import EntidadesMapeo.Laboratorista;
import EntidadesMapeo.Paciente;
import EntidadesMapeo.Resultado;
import Exception.NoRegistro;
import NuevosDatosEntidades.NuevosAdmin;
import NuevosDatosEntidades.NuevosCitaDoctor;
import NuevosDatosEntidades.NuevosConsulta;
import NuevosDatosEntidades.NuevosDoctor;
import NuevosDatosEntidades.NuevosExamen;
import NuevosDatosEntidades.NuevosInforme;
import NuevosDatosEntidades.NuevosLab;
import NuevosDatosEntidades.NuevosPaciente;
import NuevosDatosEntidades.NuevosResultado;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author danielferova
 */
public class CargandoArchivo {
    
    public void llamandoArchivo(String archivo) //throws NoRegistro 
    {

      //  String path = "/home/danielferova/NetBeansProjects/HospitalProyecto/src/main/webapp/Archivo/" + archivo;
        
        try { 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder(); 
            Document documento = builder.parse(new File(archivo));// Obtengo el documento, a partir del XML
             NodeList examenList = documento.getElementsByTagName("examen");
            NodeList adminList = documento.getElementsByTagName("admin");
            NodeList pacienteList = documento.getElementsByTagName("paciente");
            NodeList doctorList = documento.getElementsByTagName("doctor");
            NodeList labList = documento.getElementsByTagName("laboratorista");
            NodeList consultaList = documento.getElementsByTagName("consulta");
           
            NodeList informeList = documento.getElementsByTagName("reporte");
            NodeList resultadoList = documento.getElementsByTagName("resultado");            
            NodeList citadoctorList = documento.getElementsByTagName("cita");
            

            //llamando a los metodos con los que lleno las entidades en la BD
            datosExamen(examenList);
            datosAdministrador(adminList);
            datosPaciente(pacienteList);
            datosDoctor(doctorList);
            datosLaboratorista(labList);
             datosConsulta(consultaList);
            
            datosInforme(informeList);
             datosResultado(resultadoList);
             datosCitaDoctor(citadoctorList);
            
            
           
            

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void datosAdministrador(NodeList adminList) {

        Administrador admin; 
        for (int i = 0; i < adminList.getLength(); i++) {
            admin = new Administrador("", "", "", "", "", "", 1);

            // tengo el nodo actual
            Node nodo = adminList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido
                        if (!hijo.getNodeName().equalsIgnoreCase("horario")) {
                            System.out.println("Propiedad: " + hijo.getNodeName()
                                    + ", Valor: " + hijo.getTextContent());
                            switch (hijo.getNodeName().toUpperCase()) {
                                case "CODIGO":
                                    admin.setIdUsuario(hijo.getTextContent());
                                    break;
                                case "DPI":
                                    admin.setDpiUsuario(hijo.getTextContent());
                                    break;
                                case "NOMBRE":
                                    admin.setNombreUsuario(hijo.getTextContent());
                                    break;
                                case "PASSWORD":
                                    admin.setContraseñaUsuario(hijo.getTextContent());
                                    break;
                                default:
                                    System.out.println("ERROR!");
                                           }
                    }
                }
                     NuevosAdmin nuevo = new NuevosAdmin();
                     if(nuevo.agregarAdmin(admin)) {
                     System.out.println("Administrador Agregado Correctamente");
                }

            }

        }
    }
     }
    
   
    public void datosDoctor(NodeList doctorList) {
        // Recorro las etiquetas
        Doctor doctor;
        String[] horario = new String[2];
        List<String> especialidades = new ArrayList<>();

        for (int i = 0; i < doctorList.getLength(); i++) {
            doctor = new Doctor("", "", "", "", "", "", 2, 0, "", "", "");
            especialidades.clear();
            // Cojo el nodo actual
            Node nodo = doctorList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        if (hijo.getNodeName().equalsIgnoreCase("horario")) {

                            horario = tagHorario(hijo);

                        } else if (hijo.getNodeName().equalsIgnoreCase("especialidad")) {
                            especialidades = tagEspecialidad(hijo);

                        } else {
                            creacionDoctor(doctor, hijo.getNodeName(), hijo.getTextContent());

                        }
                    }

                }
                //Ultimos Atributos del Objeto Medico, para enviar al DAO
                doctor.setHorarioAtencion((String) horario[0]);
                doctor.setHorarioSalida((String) horario[1]);
                //Creacion de la especialidad, para enviarla a la base de datos
                Especialidad es = new Especialidad(especialidades);

                NuevosDoctor nuevo = new NuevosDoctor();
                nuevo.agregarDoctor(doctor, es);
                System.out.println("");
            }

        }
    }
    
    public void datosLaboratorista(NodeList laboratoristaList) {

        Laboratorista laboratorista;
        List<String> diasTrabajo = new ArrayList<>();

        for (int i = 0; i < laboratoristaList
                .getLength(); i++) {
            //---------------------------PREGUNTAR LAS DIFERENCIAS DE INSTANCIAR EL OBJETO ANTES DEL FOR (MEDICO Y ADMIN) VS. DENTRO DEL FOR (LABORATORISTA)
            laboratorista = new Laboratorista("123", "", "", "", "", "", 2, "", "", "", 1);
            diasTrabajo.clear();
            // Cojo el nodo actual
            Node nodo = laboratoristaList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        if (hijo.getNodeName().equalsIgnoreCase("trabajo")) {

                            System.out.println("Propiedad: " + hijo.getNodeName()
                                    + ", Valor: " + hijo.getTextContent());
                            //dias que trabaja
                            diasTrabajo = tagDiasTrabajo(hijo);
                        } else {

                            creacionLaboratorista(laboratorista, hijo.getNodeName(), hijo.getTextContent());

                        }
                    }

                }

                DiasDeTrabajo nuevo1 = new DiasDeTrabajo(diasTrabajo);
                NuevosLab nuevo = new NuevosLab();
                nuevo.agregarLab(laboratorista, nuevo1);
                System.out.println("");
            }

        }
    }
    
     public void datosPaciente(NodeList pacienteList) //throws NoRegistro 
     {

        Paciente paciente;

        for (int i = 0; i < pacienteList.getLength(); i++) {
            paciente = new Paciente("", "", "", "", "", "", 3, "", "", "", "");
            // Cojo el nodo actual
            Node nodo = pacienteList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        creacionPaciente(paciente, hijo.getNodeName(), hijo.getTextContent());
                    }
                }   
                // Envio a la Base de Datos
                NuevosPaciente nuevoPaciente = new NuevosPaciente();
                nuevoPaciente.agregarPaciente(paciente);
                System.out.println("");
            }
        }
    }
    
    
    public void datosExamen(NodeList examenList) //throws NoRegistro
    {

        Examen examen;

        for (int i = 0; i < examenList.getLength(); i++) {
            examen = new Examen(0, "", false, "", 0.00, "");
            // Cojo el nodo actual
            Node nodo = examenList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        creacionExamen(examen, hijo.getNodeName(), hijo.getTextContent());

                    }
                }
                NuevosExamen nuevo = new NuevosExamen();
                nuevo.agregarExamen(examen);
                System.out.println("");
            }
        }
    }

    public void datosInforme(NodeList informeList) {
        
        Informe informe;
        for (int i = 0; i < informeList.getLength(); i++) {
            informe = new Informe(1, "", "", "", "", "");
            // Cojo el nodo actual
            Node nodo = informeList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        creacionInforme(informe, hijo.getNodeName(), hijo.getTextContent());
                    }
                }
                NuevosInforme nuevo = new NuevosInforme();
                nuevo.agregarInforme(informe);
                System.out.println("");
            }
        }
    }
    
    public void datosResultado(NodeList resultadoList) {

        Resultado resultado;
        for (int i = 0; i < resultadoList.getLength(); i++) {
            resultado = new Resultado(1, "", "",1, "", "", "", "", "");
            // Cojo el nodo actual
            Node nodo = resultadoList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                                creacionResultado(resultado, hijo.getNodeName(), hijo.getTextContent());
                    }
                }    
                NuevosResultado nuevo = new NuevosResultado();
                nuevo.agregarResultado(resultado);
                System.out.println("");
            }
        }
    }

    public void datosCitaDoctor(NodeList citadoctorList) {

        CitaDoctor citaMedico;
        for (int i = 0; i < citadoctorList.getLength(); i++) {
            citaMedico = new CitaDoctor(1, "", "", "", "", "");
                    // Cojo el nodo actual
            Node nodo = citadoctorList.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        creacionCitaDoctor(citaMedico, hijo.getNodeName(), hijo.getTextContent());
                    }
                }
                NuevosCitaDoctor nuevo = new NuevosCitaDoctor();
                nuevo.agregarCitaDoctor(citaMedico);   
                System.out.println("");
            }
        }
    }
    
    public void datosConsulta(NodeList listadoDeConsultas) {
        
        Consulta consulta;
        for (int i = 0; i < listadoDeConsultas.getLength(); i++) {
            consulta = new Consulta("",0.00);
            // Cojo el nodo actual
            Node nodo = listadoDeConsultas.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        creacionConsulta(consulta,hijo.getNodeName(), hijo.getTextContent());
                    }
                }
                NuevosConsulta nuevo = new NuevosConsulta();
                nuevo.agregarConsulta(consulta);
                System.out.println("");
            }
        }
    }
    
    public List<String> tagEspecialidad(Node especialidad) {
        // Recorro las etiquetas
        List<String> especilidadesMedicas = new ArrayList<>();
        especilidadesMedicas.clear();
        // for (int i = 0; i < especialidad.getLength(); i++) {
        // Cojo el nodo actual
        Node nodo = especialidad;
        // Compruebo si el nodo es un elemento
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            // Lo transformo a Element
            Element e = (Element) nodo;
            // Obtengo sus hijos
            NodeList hijos = e.getChildNodes();
            // Recorro sus hijos
            for (int j = 0; j < hijos.getLength(); j++) {
                // Obtengo al hijo actual
                Node hijo = hijos.item(j);
                // Compruebo si es un nodo
                if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                    // Muestro el contenido

                    especilidadesMedicas.add(hijo.getTextContent());
                }

            }
            System.out.println("");
        }

        return especilidadesMedicas;
    }

    public String[] tagHorario(Node nodeHorario) {
        // Recorro las etiquetas
        String[] horario = new String[2];
        System.out.println("<========>HORARIO<========>HORARIO<========>");
        // for (int i = 0; i < especialidad.getLength(); i++) {
        // Cojo el nodo actual
        Node nodo = nodeHorario;
        // Compruebo si el nodo es un elemento
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            // Lo transformo a Element
            Element e = (Element) nodo;
            // Obtengo sus hijos
            NodeList hijos = e.getChildNodes();
            // Recorro sus hijos
            for (int j = 0; j < hijos.getLength(); j++) {
                // Obtengo al hijo actual
                Node hijo = hijos.item(j);
                // Compruebo si es un nodo
                if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                    // Muestro el contenido
                    //horario[0][0] = hijo.getNodeName();
                    //horario[0][j] = hijo.getTextContent();
                    System.out.println("Propiedad: " + hijo.getNodeName()
                            + ", Valor: " + hijo.getTextContent());

                    if (hijo.getNodeName().equalsIgnoreCase("inicio")) {
                        horario[0] = hijo.getTextContent();
                    } else {
                        horario[1] = hijo.getTextContent();
                    }
                }
            }
            System.out.println("");
        }
        return horario;
    }
    
     public List<String> tagDiasTrabajo(Node trabajoLab) {

        System.out.println("Dias de Trabajo LAB");

        List<String> diasDeTrabajo = new ArrayList<>();
        diasDeTrabajo.clear();
        Node nodo = trabajoLab;
        // Compruebo si el nodo es un elemento
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            // Lo transformo a Element
            Element e = (Element) nodo;
            // Obtengo sus hijos
            NodeList hijos = e.getChildNodes();
            // Recorro sus hijos
            for (int j = 0; j < hijos.getLength(); j++) {
                // Obtengo al hijo actual
                Node hijo = hijos.item(j);
                // Compruebo si es un nodo
                if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                    // Muestro el contenido

                    System.out.println("Propiedad: " + hijo.getNodeName()
                            + ", Valor: " + hijo.getTextContent());

                    diasDeTrabajo.add(hijo.getTextContent());

                }

            }
            System.out.println("");
        }

        return diasDeTrabajo;
    }
    
    public void creacionPaciente(Paciente paciente, String tag, String n) {

        switch (tag.toUpperCase()) {
            case "CODIGO":
                paciente.setIdUsuario(n);
                break;
            case "NOMBRE":
                paciente.setNombreUsuario(n);
                break;
            case "SEXO":
                paciente.setSexo(n);
                break;
            case "BIRTH":
                paciente.setBirthPaciente(n);
                break;
            case "DPI":
                paciente.setDpiUsuario(n);
                break;
            case "TELEFONO":
                paciente.setTelefonoUsuario(n);
                break;
            case "PESO":
                paciente.setPesoP(n);
                break;
            case "SANGRE":
                paciente.setSangreP(n);
                break;
            case "CORREO":
                paciente.setCorreoUsuario(n);
                break;
            case "PASSWORD":
                paciente.setContraseñaUsuario(n);
                break;
            default:

        }

    }

     public void creacionDoctor(Doctor doctor, String tag, String n) {

        switch (tag.toUpperCase()) {
            case "CODIGO":
                doctor.setIdUsuario(n);
                break;
            case "NOMBRE":
                doctor.setNombreUsuario(n);
                break;
            case "COLEGIADO":
                doctor.setNumColegiado(Integer.parseInt(n));
                break;
            case "DPI":
                doctor.setDpiUsuario(n);
                break;
            case "TELEFONO":
                doctor.setTelefonoUsuario(n);
                break;
            case "CORREO":
                doctor.setCorreoUsuario(n);
                break;
            case "TRABAJO":
                doctor.setFechaInicio(n);
                break;
            case "PASSWORD":
                doctor.setContraseñaUsuario(n);
                break;
            default:
        }
    }
    
     public void creacionLaboratorista(Laboratorista lab, String tag, String n) {

        switch (tag.toUpperCase()) {
            case "CODIGO":
                lab.setIdUsuario(n);
                break;
            case "NOMBRE":
                lab.setNombreUsuario(n);
                break;
            case "REGISTRO":
                lab.setRegistroMinisterio(n);
                break;
            case "DPI":
                lab.setDpiUsuario(n);
                break;
            case "TELEFONO":
                lab.setTelefonoUsuario(n);
                break;
            case "EXAMEN":
                lab.setNombreExamen(n);
                break;
            case "CORREO":
                lab.setCorreoUsuario(n);
                break;

            //case para la Etiqueta Trabajo, ira en un arraylist arriba
            case "TRABAJOF":
                lab.setFechaLab(n);
                break;
            case "PASSWORD":
                lab.setContraseñaUsuario(n);
                break;
            default:

        }

    }
     
     public void creacionExamen(Examen examen, String tag, String n) {

        switch (tag.toUpperCase()) {
            case "CODIGO":
                examen.setIdExamen(Integer.parseInt(n));
                break;
            case "NOMBRE":
                examen.setNombreExamen(n);
                break;
            case "ORDEN":

                if (n.equalsIgnoreCase("true")) {
                    examen.setOrdenExamen(true);
                } else if (n.equalsIgnoreCase("false")) {
                    examen.setOrdenExamen(false);
                } else {
                    
                }
                break;
            case "DESCRIPCION":
                examen.setDescripcionExamen(n);
                break;

            case "COSTO":
                examen.setCostoExamen(Double.parseDouble(n));
                break;
            case "INFORME":
                examen.setInformeExamen(n);
                break;

            default:

        }
    }
     
      public void creacionInforme(Informe informe, String tag, String n) {

        switch (tag.toUpperCase()) {
           case "CODIGO":
                informe.setIdInfo(Integer.parseInt(n));
                
                break;
            case "PACIENTE":
                informe.setIdPaciente(n);
                break;
                
            case "MEDICO":
                informe.setIdDoctor(n);
                break;
                
            case "INFORME":
                informe.setDescripcionInfo(n);
                break;
                
            case "FECHA":
                informe.setFechaInfo(n);
                break;
                
            case "HORA":
                informe.setHoraInfo(n);
                break;
                
          
            default:
                System.out.println("Valor no permitido");

        }

    }
      
      public void creacionResultado(Resultado resultado, String tag, String n) {

        switch (tag.toUpperCase()) {
           case "CODIGO":
                resultado.setIdResul(Integer.parseInt(n));
                
                break;
            case "PACIENTE":
                resultado.setIdPaciente(n);
                break;
                
            case "MEDICO":
                resultado.setIdDoctor(n);
                break;
                
             case "EXAMEN":
                resultado.setIdExamen(Integer.parseInt(n));
                break;
                
            
            case "LABORATORISTA":
                resultado.setIdLab(n);
                break;
                
            case "ORDEN":
                resultado.setOrdenResul(n);
                break;
            
                 case "INFORME":
                resultado.setInformeResul(n);
                break;
             
            case "FECHA":
                resultado.setFechaResul(n);
                break;
                
            case "HORA":
                resultado.setHoraResul(n);
                break;
                
          
            default:
                System.out.println("Valor no permitido");

        }
    }
    
       public void creacionCitaDoctor(CitaDoctor cita, String tag, String n) {

        switch (tag.toUpperCase()) {
           case "CODIGO":
                cita.setIdCitaDoctor(Integer.parseInt(n));
                
                break;
            case "PACIENTE":
                cita.setIdPaciente(n);
                break;
                
            case "MEDICO":
                cita.setIdDoctor(n);
                break;
                
             case "ESPECIALIDAD":
                cita.setTipoConsulta(n);
                break;   
            case "FECHA":
                cita.setFecha(n);
                break;
                
            case "HORA":
                cita.setHora(n);
                break;
                
          
            default:
                System.out.println("Valor no permitido");

        }
    }

         public void creacionConsulta(Consulta c ,String tag, String n) {

        switch (tag.toUpperCase()) {
            case "TIPO":
                c.setTipoConsulta(n);
                
                break;
            case "COSTO":
                c.setCostoConsulta(Double.parseDouble(n));
                break;
            default:
                System.out.println("Valor no permitido");
        }
    }
     
}


