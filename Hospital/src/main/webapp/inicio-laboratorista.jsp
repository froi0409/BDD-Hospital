<%-- 
    Document   : inicio-laboratorista
    Created on : 4/10/2020, 16:32:03
    Author     : froi-pc
--%>

<%@page import="entidades.Laboratorista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
<%
    if (request.getSession().getAttribute("codigo") == null || request.getSession().getAttribute("tipoSesion") != Laboratorista.NOMBRE_TABLA) {
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>