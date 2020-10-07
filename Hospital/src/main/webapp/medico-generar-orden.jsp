<%-- 
    Document   : medico-generar-orden
    Created on : 6/10/2020, 17:39:47
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaExamen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="links.html" %>
        <title></title>
    <body>
        <%@include file="medico-cabecera.html" %>
        <%@include file="medico-barra-herramientas.html" %>
        
        <form action="GenerarOrden" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-4 formulario">
                        <div class="form-group text-center pt-3">
                            <h3>Orden de Laboratorio</h3>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <label for="codigoPaciente">Codigo del Paciente:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Código del Paciente" name="codigoPaciente" required/>
                            <br>
                            <!-- busca los examenes disponibles -->
                            <label for="examen">Examen a Realizar:</label>
                            <select name="nombreExamen" class="btn-block">
                                <%
                                    BusquedaExamen examen = new BusquedaExamen();
                                    
                                    for (String element : examen.all(Conexion.getConnection())) {
                                        out.println("<option>" + element + "</option>");
                                    }
                                %>
                            </select>
                            <br>
                            <label for="descripcion">Descripcion:</label>
                            <textarea name="descripcion" rows="5" class="form-control" required></textarea>
                            <br>
                            <input type="submit" class="btn btn-info ingresar btn-block" value="Generar Orden"/>

                        </div>

                    </div>
                </div>
            </div>
        </form>
        
        <%@include file="scripts.html" %>
    </body>
</html>
<%@include file="medico-seguridad.jsp" %>