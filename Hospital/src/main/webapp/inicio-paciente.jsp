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
        
        <%@include file="paciente-cabecera.html" %>
        
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
