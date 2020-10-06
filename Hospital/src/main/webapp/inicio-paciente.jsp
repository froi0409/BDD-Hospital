<%-- 
    Document   : inicio-paciente
    Created on : 4/10/2020, 16:30:48
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
        <title>Paciente</title>
    </head>
    <body>
        
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
                    <h2>¡Bienvenido!</h2>
                </div>
                
            </div>

        </div>
        
        <%@include file = "paciente-barra-herramientas.html"%>
        
    <c:choose>
        
        <c:when test="${not empty mensaje}">
            
            <div class="container" style="margin-top: 30px">
                <div class="alert alert-info" role="alert" align="center">
                    ${mensaje}
                </div>
            </div>
            
        </c:when>
        <c:otherwise>
            
        </c:otherwise>
    </c:choose>
        
        <%@include file = "scripts.html"%>
    </body>
</html>

