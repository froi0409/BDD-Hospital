<%-- 
    Document   : paciente-crear-cita-laboratorio
    Created on : 6/10/2020, 12:00:57
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaExamen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html"%>
        <title>Agendar Examen de Laboratorio</title>
    </head>
    <body>
        <%@include file="paciente-cabecera.html" %>
        <%@include file="paciente-barra-herramientas.html" %>

        <form action="ConfirmarExamenLaboratorio" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-6 formulario">
                        <div class="form-group text-center pt-3">
                            <h3>Agendar Cita Laboratorio</h3>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <!-- busca las especialidades -->
                            <label for="examen">Examen a Realizar:</label>
                            <select name="nombreExamen" class="btn-block">
                                <%
                                    BusquedaExamen busqueda = new BusquedaExamen();
                                    
                                    for (String element : busqueda.all(Conexion.getConnection())) {
                                        out.println("<option>" + element + "</option>");
                                    }
                                %>
                            </select>
                            <br>
                            <label for="fecha">Fecha del Examen:</label>
                            <input type="date" class="form-control" name="fecha" required/>
                            <br>
                            <label for="hora">Hora de la Cita (HH:00): </label>
                            <input type="time" class="form-control" name="hora" required/>
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
<%@include file = "paciente-seguridad.jsp" %>