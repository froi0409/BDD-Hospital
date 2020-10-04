<%-- 
    Document   : inicio-sesion
    Created on : 1/10/2020, 02:12:14
    Author     : froi-pc
--%>

<%@page import="analizadores.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <link href="estilos/login.css" rel="stylesheet" type="text/css"/>
        <title>Iniciar Sesión</title>
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
                    <h2>Inicio de Sesión</h2>
                </div>

            </div>

        </div>
        
        <!-- Creamos botón de regreso -->
        <div class="container">
            
            <form action="inicio.jsp" method="POST">
                <input type="submit" class="btn btn-outline-primary" value="Regresar" />
            </form>
            
        </div>
        
        <!-- mostramos mensaje si la base de datos está vacia -->
        <%
            AnalizadorDeDatos analizador = new AnalizadorDeDatos();
            try{
                if(!analizador.baseLlena(Conexion.getConnection())){ %>
                <br><br>
            
                <div class="container">
                    <div class="alert alert-primary" role="alert" align="center">
                        SISTEMA VACIO, FAVOR CONTACTAR AL ADMINISTRADOR
                    </div>
                </div>
                
            <%} }catch(Exception e) {}%>
            
        <!-- Creamos la ventana del login -->
        <form action="AnalizadorDatosLogin" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-4 formulario">
                        <div class="form-group text-center pt-3">
                            <h1>Iniciar Sesión</h1>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <label for="user">Seleccione su tipo de usuario:</label>
                            <select name="TABLA">
                                <option>Paciente</option>
                                <option>Laboratorista</option>
                                <option>Medico</option>
                                <option>Administrador</option>
                            </select>
                        </div>
                        <div class="form-group mx-sm-5 pt-3">
                            <label for="user">Usuario</label>
                            <input type="text" class="form-control" placeholder="Ingrese Usuario" name="user"/>
                        </div>
                        <div class="form-group mx-sm-5 pb-3">
                            <label for="user">Contraseña</label>
                            <input type="password" class="form-control" placeholder="Ingrese Usuario" name="password"/>
                        </div>
                        <div class="form-group mx-sm-5 pb-5"><!-- comment -->

                            <input type="submit" class="btn btn-primary ingresar btn-block" value="Ingresar"/>

                        </div>

                    </div>
                </div>
            </div>
        </form>
        
        <%@include file = "scripts.html"%>
    </body>
</html>