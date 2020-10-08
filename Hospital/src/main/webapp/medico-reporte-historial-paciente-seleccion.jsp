<%-- 
    Document   : medico-reporte-historial-paciente-seleccion
    Created on : 8/10/2020, 13:26:48
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
        <%@include file ="links.html" %>
        <title>Solicitar Historial Médico</title>
    </head>
    <body>
        <%@include file ="medico-cabecera.html" %>
        <%@include file ="medico-barra-herramientas.html" %>
        <form action="MedicoConfirmarHistorial" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-3 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-4 formulario">
                        <div class="form-group text-center pt-3">
                            <h3>Solicitar Historial Médico</h3>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <label for="paciente">Paciente</label><br>
                            <select name="codigoPaciente" class="btn-block">
                                <%
                                BusquedaPaciente paciente = new BusquedaPaciente();
                                for (String[] element : paciente.allCredenciales(Conexion.getConnection())) {
                                    out.println("<option value=\"" + element[0] +"\">" + element[0] + " - " + element[1] + "</option>");
                                }
                                %>
                            </select>
                            <br>                            
                            <input type="submit" class="btn btn-info ingresar btn-block" value="Soilicitar"/>

                        </div>

                    </div>
                </div>
            </div>
        </form>
        <%@include file ="scripts.html" %>
    </body>
</html>
<%@include file ="medico-seguridad.jsp" %>
