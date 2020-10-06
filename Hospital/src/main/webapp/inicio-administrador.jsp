<%-- 
    Document   : inicio-administrador
    Created on : 4/10/2020, 16:31:48
    Author     : froi-pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entidades.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <title>Admin</title>
    </head>
    <body>
        <%@include file = "administrador-cabecera.html" %>
        <%@include file = "administrador-barra-herramientas.html" %>
        
        <c:choose>
            <c:when test="${not empty mensaje}">
                <div class="container" style="margin-top: 30px">
                <div class="alert alert-info" role="alert" align="center">
                    ${mensaje}
                </div>
            </div>
            </c:when>
        </c:choose>
        
        <%@include file = "scripts.html"%>
    </body>
</html>
<%
    if (request.getSession().getAttribute("codigo") == null || !request.getSession().getAttribute("tipoSesion").equals(Administrador.NOMBRE_TABLA)) {
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>