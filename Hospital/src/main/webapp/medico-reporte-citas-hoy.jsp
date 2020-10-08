<%-- 
    Document   : medico-reporte-citas-hoy
    Created on : 8/10/2020, 03:07:29
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="reportes.ReporteMedico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html" %>
        <title>Citas de Hoy</title>
    </head>
    <body>
        <%@include file = "medico-cabecera.html" %>
        <%@include file = "medico-barra-herramientas.html" %>
        
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Citas de Hoy</h1><br>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Código Cita</th>
                    <th scope="col">Especialidad</th>
                    <th scope="col">Codigo Paciente</th>
                    <th scope="col">Nombre Paciente</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    String codigoMedico = request.getSession().getAttribute("codigo").toString();
                    ReporteMedico medico = new ReporteMedico();

                    for(String[] element: medico.citasHoy(Conexion.getConnection(), codigoMedico)) {
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