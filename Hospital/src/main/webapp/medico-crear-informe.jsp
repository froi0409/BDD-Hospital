<%-- 
    Document   : medico-crear-informe
    Created on : 6/10/2020, 16:15:24
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html" %>
        <title>Crear Informe Médico</title>
    </head>
    <body>
        <%@include file = "medico-cabecera.html" %>
        <%@include file = "medico-barra-herramientas.html" %>
        
        <form action="RegistroInforme" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-6 formulario">
                        <div class="form-group text-center pt-3">
                            <h3>Informe Médico</h3>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <label for="codigoPaciente">Codigo del Paciente:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Codigo del Paciente" name="codigoPaciente" required/> 
                            <br>
                            <label for="descripcion">Descripción del informe:</label>
                            <textarea name="descripcion" rows="5" class="form-control" required></textarea>
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