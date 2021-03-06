<%-- 
    Document   : medico-generar-cita
    Created on : 6/10/2020, 18:14:52
    Author     : froi-pc
--%>

<%@page import="busquedaDeEntidad.BusquedaMedico"%>
<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaEspecialidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Generar Cita</title>
    </head>
    <body>
        <%@include file="medico-cabecera.html" %>
        <%@include file="medico-barra-herramientas.html" %>
        
        <form action="GenerarCitaMedico" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-4 formulario">
                        <div class="form-group text-center pt-3">
                            <h3>Agendar Cita</h3>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <!-- busca las especialidades -->
                            <label for="especialidad">Especialidad de la consulta:</label>
                            <select name="nombreEspecialidad" class="btn-block">
                                <%
                                    BusquedaEspecialidad find = new BusquedaEspecialidad();

                                    for (String element : find.especialidadMedico(Conexion.getConnection(), request.getSession().getAttribute("codigo").toString())) {
                                        out.println("<option>" + element + "</option>");
                                    }
                                %>
                            </select>
                            <br>                            
                            <label for="fecha">Fecha de la Cita: </label>
                            <input type="date" class="form-control" name="fecha" required/> 
                            <br>
                            <label for="hora">Hora de la Cita (HH:00): </label>
                            <select name="hora" class="btn-block">
                                <%
                                    BusquedaMedico medico = new BusquedaMedico();
                                    for (String element : medico.horarioMedico(Conexion.getConnection(), request.getSession().getAttribute("codigo").toString())) {
                                        out.println("<option>" + element + "</option>");
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
        
        <%@include file="scripts.html" %>
    </body>
</html>
<%@include file="medico-seguridad.jsp" %>