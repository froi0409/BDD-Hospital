<%-- 
    Document   : paciente-reporte-examenes-tipo
    Created on : 7/10/2020, 21:17:36
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
                    <th scope="col">Código Examen</th>
                    <th scope="col">Nombre del Examen</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                    String fechaInicial = request.getParameter("fechaInicial");
                    String fechaFinal = request.getParameter("fechaFinal");
                    String codigoExamen = request.getParameter("codigoExamen");
                    String codigoPaciente = request.getParameter("codigoPaciente").toString();
                    ReportePacienteFechas paciente = new ReportePacienteFechas(fechaInicial,fechaFinal);
                    
                    System.out.println(request.getParameter("nombreExamen"));
                    System.out.println(codigoExamen);
                    System.out.println(fechaInicial);
                    System.out.println(fechaFinal);
                    
                    for(String[] element: paciente.examenesDeUnTipo(Conexion.getConnection(), codigoPaciente, codigoExamen)){
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
