<%-- 
    Document   : paciente-confirmacion-cita
    Created on : 5/10/2020, 02:07:15
    Author     : froi-pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <title>Confirmacion Cita</title>
    </head>
    
        
        <!-- Creamos la cabecera de la página -->
        <div class="container-fluid">

            <!-- Añadimos la fila que será la cabecera de la página -->
            <div class="row fondoInicio align-items-center">

                <div class="col-3" align="left">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/logo.png" height="75px"/>
                </div>
                <div class="col-6" align="center">
                    <h1>HOSPITAL DE ANFIELD</h1>
                </div>
                <div class="col-3" align="right">
                    <h2>Confirmacion Cita</h2>
                </div>
                
            </div>

        </div>
        
        
        <%@include file = "paciente-barra-herramientas.html" %>
        
        <c:choose>
            <c:when test="${aprobacion}">
                
                <form action="CrearCita" method="POST">
                    <div class="container"> 
                        <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                            <div class="col-md-4 formulario">
                                <div class="form-group text-center pt-3">
                                    <h3>Confirmar Cita</h3>
                                </div>
                                
                                    <label for="medico">Codigo del Médico: </label> <% out.print(request.getSession().getAttribute("codigoMedico")); %>
                                    <br>
                                    <br>
                                    <label for="especialidad">Especialidad de la consulta: </label> <% out.print(request.getSession().getAttribute("especialidad")); %>
                                    <br>  
                                    <br>
                                    <label for="fecha">Fecha de la Cita: </label> <% out.print(request.getSession().getAttribute("fecha")); %>
                                    <br>
                                    <br>
                                    <label for="hora">Hora de la Cita (HH:00): </label> <% out.print(request.getSession().getAttribute("hora")); %>
                                    <br>
                                    <br>
                                    <label for="hora">Costo: </label> <% out.print("Q " + request.getSession().getAttribute("costo")); %>
                                    <br>
                                    <br>
                                    
                                    <input type="submit" class="btn btn-primary ingresar btn-block" value="Confirmar"/>

                            </div>
                        </div>
                    </div>
                </form>
                
            </c:when>
            <c:otherwise>
                
                <div class="container" style="margin-top: 30px">
                    <div class="alert alert-danger" role="alert">
                        ${mensaje}
                    </div>
                </div>
                
            </c:otherwise>
        </c:choose>
        
        
        <%@include file = "scripts.html"%>
    
</html>

