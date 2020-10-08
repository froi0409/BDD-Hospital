<%-- 
    Document   : paciente-reporte-citas-medico
    Created on : 7/10/2020, 23:09:15
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="reportes.ReportePacienteFechas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html" %>
        <title>Citas Médicas con Un Médico</title>
    </head>
    <body>
        <%@include file = "paciente-cabecera.html" %>
        <%@include file = "paciente-barra-herramientas.html" %>
        
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Citas Médicas con Un Médico</h1>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Código de Médico</th>
                    <th scope="col">Nombre del Médico</th>
                    <th scope="col">Código de la Cita</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    String fechaInicial = request.getSession().getAttribute("fechaInicial").toString();
                    String fechaFinal = request.getSession().getAttribute("fechaFinal").toString();
                    String codigoMedico = request.getSession().getAttribute("codigoMedico").toString();
                    String codigoPaciente = request.getSession().getAttribute("codigo").toString();
                    
                    ReportePacienteFechas paciente = new ReportePacienteFechas(fechaInicial,fechaFinal);
                    
                    for(String[] element: paciente.citasConUnMedico(Conexion.getConnection(), codigoPaciente, codigoMedico)){
                        out.println("<tr>");
                        out.println("<td>" + element[0] + "</td>");
                        out.println("<td>" + element[1] + "</td>");
                        out.println("<td>" + element[2] + "</td>");
                        out.println("<td>" + element[3] + "</td>");
                        out.println("<td>" + element[4] + "</td>");
                        out.println("</tr>");
                    }
                    %>
                </tbody>
            </table>

        </div>
        
        <%@include file = "scripts.html" %>
    </body>
</html>
<%
request.getSession().removeAttribute("fechaInicial");
request.getSession().removeAttribute("fechaFinal");
request.getSession().removeAttribute("codigoMedico");
%>
<%@include file = "paciente-seguridad.jsp" %>