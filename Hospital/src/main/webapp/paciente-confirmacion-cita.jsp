<%-- 
    Document   : paciente-confirmacion-cita
    Created on : 5/10/2020, 02:07:15
    Author     : froi-pc
--%>

<%@page import="entidades.Paciente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <title>Confirmacion Cita</title>
    </head>
    
        <%@include file="paciente-cabecera.html" %>
        <%@include file = "paciente-barra-herramientas.html" %>
        
        <!<!-- Se define si la página muestra un mensaje o la información de la solicitud de la cita médica -->
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
                    <div style="margin-top: 30px" align="center">
                        <a href="paciente-crear-cita.jsp" style="button" class="btn btn-outline-danger">Regresar</a>
                    </div>
                </div>
                
            </c:otherwise>
        </c:choose>
        
        
        <%@include file = "scripts.html"%>
    
</html>
<%
    if (request.getSession().getAttribute("codigo") == null || request.getSession().getAttribute("tipoSesion") != Paciente.NOMBRE_TABLA) {
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>

