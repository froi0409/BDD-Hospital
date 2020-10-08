<%-- 
    Document   : medico-reporte-historial.paciente
    Created on : 8/10/2020, 13:18:34
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="reportes.ReportePaciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html" %>
        <title>Historial Médico de Paciente</title>
    </head>
    <body>
        <%@include file = "medico-cabecera.html" %>
        <%@include file = "medico-barra-herramientas.html" %>
        
        <div align="center" style="margin-top: 75px">
            <h1>Historial Médico de Paciente ${codigoPaciente}</h1>
        </div>
        <div class="container" align="center" style="margin-top: 100px">
            <h2>Citas Medicas</h2>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Codigo Cita</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Especialidad</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    String codigoPaciente = request.getAttribute("codigoPaciente").toString();
                    
                    ReportePaciente paciente = new ReportePaciente();
                    
                    for(String[] element: paciente.historialCitaMedica(Conexion.getConnection(), codigoPaciente)){
                        out.println("<tr>");
                        out.println("<td>" + element[0] + "</td>");
                        out.println("<td>" + element[1] + "</td>");
                        out.println("<td>" + element[2] + "</td>");
                        out.println("</tr>");
                    }
                    %>
                </tbody>
            </table>

        </div>
                
        <div class="container" align="center" style="margin-top: 50px; margin-bottom: 100px">
            <h2>Exámenes de Laboratorio</h2>
           <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Código Cita Laboratorio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Codigo Examen</th>
                    <th scope="col">Nombre Examen</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    for(String[] element: paciente.historialCitaLaboratorio(Conexion.getConnection(), codigoPaciente)){
                        out.println("<tr>");
                        out.println("<td>" + element[0] + "</td>");
                        out.println("<td>" + element[1] + "</td>");
                        out.println("<td>" + element[2] + "</td>");
                        out.println("<td>" + element[3] + "</td>");
                        out.println("</tr>");
                    }
                    %>
                </tbody>
            </table>

        </div>
        
        <%@include file = "scripts.html" %>
    </body>
</html>
<%@include file = "medico-seguridad.jsp" %>