<%-- 
    Document   : administrador-reporte-examenes-demandados-fecha
    Created on : 8/10/2020, 13:06:15
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Médicos que Han Realizado Más Informes</title>
    </head>
    <body>
        <%@include file="administrador-cabecera.html" %>
        <%@include file="administrador-barra-herramientas.html" %>
        
        <!-- Creamos la ventana de registro -->
        <form action="AdministradorReporteExamenesDemandados" method="POST">
            
            <div class="pt-2">
               &nbsp;
               <br>
            </div>
            
            <div class="container formulario pt-4" style="margin-bottom: 30px"> 
                <div class="row justify-content-center pt-1 mt-5 mr-1 " align="center">
                    <h1>Exámenes de Laboratorio Más Demandados</h1>
                </div>
                <div class="row justify-content-center pt-2 mt-5 mr-1 "> <!-- Utilizamos el sistema de filas de bootstrap -->
                    
                    <div class="col-md-6">
                        
                        <div class="form-froup mx-sm-5 pb-5">
                            <br>
                            <label for="fechaInicial">Fecha Inicio:</label>
                            <input type="date" class="form-control btn-block" placeholder="Ingrese Código" name="fechaInicial" required/>
                            <br>
                            <label for="fechaFinal">Fecha Final:</label>
                            <input type="date" class="form-control btn-block" placeholder="Ingrese Nombre del Examen" name="fechaFinal" required/>
                            <br>
                            <input type="submit" class="btn btn-info ingresar btn-block" value="Confirmar"/>
                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
        </form>
        
        <%@include file="scripts.html" %>
    </body>
</html>
<%@include file = "administrador-seguridad.jsp" %>