<%-- 
    Document   : paciente-reporte-ultimas-consultas
    Created on : 7/10/2020, 18:52:12
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
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file = "paciente-cabecera.html" %>
        <%@include file = "paciente-barra-herramientas.html" %>
        
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Últimas 5 Citas Médicas</h1>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Código Consulta</th>
                    <th scope="col">Nombre del Médico</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    ReportePaciente paciente = new ReportePaciente();
                    
                    for(String[] element: paciente.ultimasCitasMedicas(Conexion.getConnection(), session.getAttribute("codigo").toString())){
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
