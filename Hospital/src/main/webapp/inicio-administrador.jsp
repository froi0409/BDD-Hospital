<%-- 
    Document   : inicio-administrador
    Created on : 4/10/2020, 16:31:48
    Author     : froi-pc
--%>

<%@page import="entidades.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1>SOY ADMIN B)</h1>
    </body>
</html>
<%
    if (request.getSession().getAttribute("codigo") == null || request.getSession().getAttribute("tipoSesion") != Administrador.NOMBRE_TABLA) {
        request.getSession().removeAttribute("codigo");
        request.getSession().removeAttribute("tipoSesion");
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>