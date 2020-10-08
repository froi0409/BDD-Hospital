<%-- 
    Document   : medico-reporte-pacientes-informes
    Created on : 8/10/2020, 03:52:30
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
        <title>Pacientes con Más Informes</title>
    </head>
    <body>
        <%@include file = "medico-cabecera.html" %>
        <%@include file = "medico-barra-herramientas.html" %>
        
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Pacientes con Más Informes</h1>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                        <th scope="col">Paciente</th>
                        <th scope="col">Cantidad de Informes</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    ReporteMedico medico = new ReporteMedico();

                    for(String[] element: medico.pacientesConMasInformes(Conexion.getConnection())) {
                        out.println("<tr>");
                        out.println("<td>" + element[0] + "</td>");
                        out.println("<td>" + element[1] + "</td>");
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