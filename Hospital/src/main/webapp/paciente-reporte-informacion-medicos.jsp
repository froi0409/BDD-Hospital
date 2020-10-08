<%-- 
    Document   : paciente-reporte-informacion-medicos
    Created on : 8/10/2020, 01:06:11
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
        <title>Información Médicos</title>
    </head>
    <body>
        <%@include file = "paciente-cabecera.html" %>
        <%@include file = "paciente-barra-herramientas.html" %>
        
        <form action="paciente-reporte-informacion-medicos.jsp" method="GET">
            <div class="container" align="center" style="margin-top: 100px">
                <h1>Citas Médicas con Un Médico</h1><br>
                <label for="orden">Seleccione una opción para ordenar</label>&nbsp;&nbsp;
                <select name="orden">
                    <option value="M.nombre">Nombre</option>
                    <option value="D.nombre_especialidad">Especialidad</option>
                </select><br>
                <input type="submit" class="btn btn-info" value="Consultar"/><br><br>
                <table class="table table-bordered">
                    <thead>
                        <tr class="table-info">
                        <th scope="col">Código</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Especialidad</th>
                        <th scope="col">Colegiado</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Hora Entrada</th>
                        <th scope="col">Hora Salida</th>
                      </tr>
                    </thead>
                    <tbody>
                        <%
                        String orden = request.getParameter("orden");
                        ReportePaciente paciente = new ReportePaciente();

                        for(String[] element: paciente.medicos(Conexion.getConnection(), request.getParameter("orden"))){
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
        </form>
        
        <%@include file = "scripts.html" %>
    </body>
</html>
<%
request.getSession().removeAttribute("fechaInicial");
request.getSession().removeAttribute("fechaFinal");
request.getSession().removeAttribute("codigoMedico");
%>