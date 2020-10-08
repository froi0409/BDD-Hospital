<%-- 
    Document   : dministrador-reporte-medicos-menos-citas
    Created on : 8/10/2020, 12:40:11
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="reportes.ReporteAdministradorFechas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html" %>
        <title>Medicos con Más Informes</title>
    </head>
    <body>
        <%@include file = "administrador-cabecera.html" %>
        <%@include file = "administrador-barra-herramientas.html" %>
        
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Médicos con Menos Citas</h1>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Código</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Cantidad de Citas</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    String fechaInicial = request.getAttribute("fechaInicial").toString();
                    String fechaFinal = request.getAttribute("fechaFinal").toString();
                    
                    ReporteAdministradorFechas administrador = new ReporteAdministradorFechas(fechaInicial,fechaFinal);
                    
                    for(String[] element: administrador.medicosConMenosCitas(Conexion.getConnection())){
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
        
        <%@include file = "scripts.html" %>
    </body>
</html>
<%@include file = "administrador-seguridad.jsp" %>