<%-- 
    Document   : inicio-laboratorista
    Created on : 4/10/2020, 16:32:03
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="busquedaDeEntidad.BusquedaLaboratorista"%>
<%@page import="entidades.Laboratorista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="laboratorista-cabecera.html" %>
        <%@include file="laboratorista-barra-herramientas.html" %>
        
        <%
            BusquedaLaboratorista laboratorista = new BusquedaLaboratorista();
            if(!laboratorista.trabajaHoy(Conexion.getConnection(), session.getAttribute("codigo").toString())){
        %>
        
        <div class="container" style="margin-top: 30px">
            <div class="alert alert-danger" role="alert" align="center">
                ADVERTENCIA: HOY NO ES DÍA DE TRABAJO.
            </div>
        </div>
        
        <%
            } else {
        %>
        
        
        <%
            }
        %>
        <%@include file="scripts.html" %>
    </body>
</html>