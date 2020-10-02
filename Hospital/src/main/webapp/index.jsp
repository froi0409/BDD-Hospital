<%-- 
    Document   : index
    Created on : 30/09/2020, 22:34:44
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "analizadores.*"%>
<% 

    Conexion conexionBD = new Conexion();
    conexionBD.crearConexion();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        
    </head>
    <body>
        <!<!-- La siguiente instrucción nos dirige a la página de inicio -->
        <% response.sendRedirect("paginasIniciales/inicio.jsp"); %>
    </body>
</html>
