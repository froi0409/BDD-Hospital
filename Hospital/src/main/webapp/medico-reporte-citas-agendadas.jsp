<%-- 
    Document   : medico-reporte-citas-agendadas
    Created on : 8/10/2020, 01:33:24
    Author     : froi-pc
--%>

<%@page import="reportes.ReporteMedicoFechas"%>
<%@page import="analizadores.Conexion"%>
<%@page import="reportes.ReportePacienteFechas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html" %>
        <title>Citas Agendadas</title>
    </head>
    <body>
        <%@include file = "medico-cabecera.html" %>
        <%@include file = "medico-barra-herramientas.html" %>
        
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Cita Agendadas</h1>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Codigo Cita</th>
                    <th scope="col">Especialidad</th>
                    <th scope="col">Codigo Paciente</th>
                    <th scope="col">Nombre Paciente</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    String fechaInicial = request.getAttribute("fechaInicial").toString();
                    String fechaFinal = request.getAttribute("fechaFinal").toString();
                    String codigoMedico = request.getSession().getAttribute("codigo").toString();
                    
                    ReporteMedicoFechas medico = new ReporteMedicoFechas(fechaInicial,fechaFinal);
                    
                    for(String[] element: medico.citasAgendadas(Conexion.getConnection(), codigoMedico)){
                        out.println("<tr>");
                        out.println("<td>" + element[0] + "</td>");
                        out.println("<td>" + element[1] + "</td>");
                        out.println("<td>" + element[2] + "</td>");
                        out.println("<td>" + element[3] + "</td>");
                        out.println("<td>" + element[4] + "</td>");
                        out.println("<td>" + element[5] + "</td>");
                        out.println("</tr>");
                    }
                    %>
                </tbody>
            </table>

        </div>
        
        <%@include file = "scripts.html" %>
    </body>
</html>