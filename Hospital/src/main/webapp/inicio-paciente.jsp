<%-- 
    Document   : inicio-paciente
    Created on : 4/10/2020, 16:30:48
    Author     : froi-pc
--%>

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
        
        <!<!-- Creamos la barra de herramientas -->
        <div class='container-fluid bg-info p-1 mb-2'>
            
            <div class='row'>
                
                <div class='col-12' style="color: white">
                    
                    <form action="" method="POST" class="form">
                        <input class="btn btn-info" type="submit" value="Inicio"/>
                    </form>
                    <form action="" method="POST" class="form">
                        <input class="btn btn-info" type="submit" value="Cita Médica"/>
                    </form>
                    <form action="" method="POST" class="form">
                        <input class="btn btn-info" type="submit" value="Examen de Laboratorio"/>
                    </form>
                    <form action="" method="POST" class="form">
                        <input class="btn btn-info" type="submit" value="Reportes"/>
                    </form>
                    
                </div>
                
            </div>
            
        </div>
        
        <%@include file = "scripts.html"%>
    </body>
</html>
