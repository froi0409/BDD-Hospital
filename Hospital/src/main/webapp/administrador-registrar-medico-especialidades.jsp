<%-- 
    Document   : administrador-registrar-medico-especialidades
    Created on : 6/10/2020, 04:52:39
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaEspecialidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Definir especialidades</title>
    </head>
    <body>
        <%@include file="administrador-cabecera.html" %>
        <%@include file="administrador-barra-herramientas.html" %>
        
        <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-4 formulario">
                        <div class="form-group text-center pt-3">
                            <h1>Seleccionar Especialidad</h1>
                        </div>
                        <form action="AgregarEspecialidad" method="POST">
                            <div class="form-froup mx-sm-5 pt3">
                                <label for="user">Seleccione una Especialidad:</label>
                                <select name="especialidad" class="btn-block">
                                    <%
                                        BusquedaEspecialidad especialidad = new BusquedaEspecialidad();
                                        for (String element : especialidad.all(Conexion.getConnection())) {
                                            out.println("<option>" + element + "</option>");
                                        }
                                    %>
                                </select>
                            </div>

                            <div class="form-group mx-sm-5 pb-3" align="center">
                                <br>
                                <input type="submit" class="btn btn-outline-info" value="Agregar Especialidad" required/>
                            </div>
                        </form>
                        <div class="form-group mx-sm-5 pb-5">
                            <form action="ConfirmarRegistroMedico" method="POST">
                                <input type="submit" class="btn btn-info btn-block" value="Confirmar Especialidades" required/>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        
        <%@include file="scripts.html" %>
    </body>
</html>
