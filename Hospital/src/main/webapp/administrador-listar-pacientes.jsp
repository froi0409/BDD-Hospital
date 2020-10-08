<%-- 
    Document   : administrador-listar-pacientes
    Created on : 8/10/2020, 13:50:49
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaPaciente"%>
<%@page import="busquedaDeEntidad.BusquedaPaciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html" %>
        <title>Listar Pacientes</title>
    </head>
    <body>
        <%@include file = "administrador-cabecera.html" %>
        <%@include file = "administrador-barra-herramientas.html" %>
        
        <div class="container" align="center" style="margin-top: 100px">
            <h1>Pacientes</h1><br>
            <table class="table table-bordered">
                <thead>
                    <tr class="table-info">
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Fecha de Nacimiento</th>
                    <th scope="col">Sangre</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">Correo Electrónico</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    BusquedaPaciente paciente = new BusquedaPaciente();

                    for(String[] element: paciente.allAttributes(Conexion.getConnection())) {
                        out.println("<tr>");
                        out.println("<td>" + element[0] + "</td>");
                        out.println("<td>" + element[1] + "</td>");
                        out.println("<td>" + element[2] + "</td>");
                        out.println("<td>" + element[3] + "</td>");
                        out.println("<td>" + element[4] + "</td>");
                        out.println("<td>" + element[5] + "</td>");
                        out.println("<td>" + element[6] + "</td>");
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