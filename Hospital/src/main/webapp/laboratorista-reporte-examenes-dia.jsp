<%-- 
    Document   : laboratorista-reporte-examenes-dia
    Created on : 8/10/2020, 06:32:10
    Author     : froi-pc
--%>

<%@page import="reportes.ReporteLaboratorista"%>
<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaLaboratorista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Examenes del Día</title>
    </head>
    <body>
        <%@include file="laboratorista-cabecera.html" %>
        <%@include file="laboratorista-barra-herramientas.html" %>
        
        <%
            BusquedaLaboratorista laboratorista = new BusquedaLaboratorista();
            if(!laboratorista.trabajaHoy(Conexion.getConnection(), session.getAttribute("codigo").toString())){
        %>
        
            <div class="container" style="margin-top: 30px">
                <div class="alert alert-danger" role="alert" align="center">
                    ADVERTENCIA: HOY NO ES DÍA DE TRABAJO.
                </div>
            </div>
        
        <%
            } else {
        %>
        
            <div class="container" align="center" style="margin-top: 100px">
                <h1>Examenes del Día</h1>
                <table class="table table-bordered">
                    <thead>
                        <tr class="table-info">
                        <th scope="col">Codigo Cita</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Codigo Paciente</th>
                        <th scope="col">Nombre Paciente</th>
                      </tr>
                    </thead>
                    <tbody>
                        <%
                        String codigoLaboratorista = request.getSession().getAttribute("codigo").toString();
                        
                        ReporteLaboratorista labo = new ReporteLaboratorista();
                        
                        for(String[] element: labo.examenesARealizar(Conexion.getConnection(), codigoLaboratorista)){
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
        
        <%
            }
        %>
        <%@include file="scripts.html" %>
    </body>
</html>
<%@page import="entidades.Administrador"%>
<%@include file="laboratorista-seguridad.jsp" %>