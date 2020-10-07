<%-- 
    Document   : inicio-medico
    Created on : 4/10/2020, 16:31:36
    Author     : froi-pc
--%>

<%@page import="entidades.Medico"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html"%>
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="medico-cabecera.html"%>
        <%@include file="medico-barra-herramientas.html"%>
        
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
        
        <%@include file="scripts.html"%>
    </body>
</html>
<%@include file="medico-seguridad.jsp" %>