<%-- 
    Document   : inicioSesion
    Created on : 1/10/2020, 02:12:14
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <title>Iniciar Sesión</title>
    </head>
    <body>
        
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
                <h3>Inicio de Sesión</h3>
            </div>

        </div>


    </div>
        
        <%@include file = "scripts.html"%>
    </body>
</html>
