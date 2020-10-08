<%-- 
    Document   : laboratorista-reporte-dias-mas-trabajados
    Created on : 8/10/2020, 07:34:57
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="reportes.ReporteLaboratorista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Días con Más Trabajo</title>
    </head>
    <body>
        <%@include file="laboratorista-cabecera.html" %>
        <%@include file="laboratorista-barra-herramientas.html" %>
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Días con Más Trabajo</h1>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">fecha</th>
                    <th scope="col">Examenes Realizados</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    String codigoLaboratorista = request.getSession().getAttribute("codigo").toString();

                    ReporteLaboratorista labo = new ReporteLaboratorista();

                    for(String[] element: labo.diasConMasTrabajo(Conexion.getConnection(), codigoLaboratorista)){
                        out.println("<tr>");
                        out.println("<td>" + element[0] + "</td>");
                        out.println("<td>" + element[1] + "</td>");
                        out.println("</tr>");
                    }
                    %>
                </tbody>
            </table>

        </div>
        <%@include file="scripts.html" %>
    </body>
</html>
<%@include file="laboratorista-seguridad.jsp" %>