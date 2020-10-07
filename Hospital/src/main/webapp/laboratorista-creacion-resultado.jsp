<%-- 
    Document   : laboratorista-creacion-resultado
    Created on : 7/10/2020, 09:29:34
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaCitaLaboratorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Generación de Reporte</title>
    </head>
    <body>
        <%@include file="laboratorista-cabecera.html" %>
        <%@include file="laboratorista-barra-herramientas.html" %>
        
        <form action="RegistroReporte" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-6 formulario">
                        <div class="form-group text-center pt-3">
                            <h3>Resultado</h3>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <label for="codigoPaciente">Codigo de la Cita :</label>
                            <select name="codigoCita">
                                <%
                                BusquedaCitaLaboratorio find = new BusquedaCitaLaboratorio();
                                for (String element : find.citasPrevias(Conexion.getConnection(), session.getAttribute("codigo").toString())) {
                                    out.println("<option>" + element + "</option>");
                                }
                                %>
                            </select>
                            <br>
                            <label for="descripcion">Descripción del informe:</label>
                            <textarea name="descripcion" rows="5" class="form-control" required></textarea>
                            <br>                            

                            <input type="submit" class="btn btn-info ingresar btn-block" value="Realizar Informe"/>

                        </div>

                    </div>
                </div>
            </div>
        </form>
        
        <%@include file="scripts.html" %>
    </body>
</html>
