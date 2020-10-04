<%-- 
    Document   : subir-archivo
    Created on : 2/10/2020, 03:37:26
    Author     : froi-pc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <link href="estilos/login.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
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
                    <h2>&nbsp;&nbsp;Registrar Datos</h2>
                </div>

            </div>

        </div>
        
        
        <form action="LecturaArchivo" method="POST" enctype="multipart/form-data">
            <div class="container">
                <div class="row justify-content-center pt-4 mr-1 mt-5">
                    <div class="col-md-4 formulario">
                        
                        <div class="form-group mx-sm-5 pt3">
                            <h2>Seleccionar Archivo</h2>
                        </div>
                        
                        <div class="form-group mx-sm-4 pt-3">
                            <label>Seleccione la ruta y presione "Aceptar"</label>
                            <input type="file" class="btn-block" name="ruta" value="Elegir"/>
                        </div>
                        
                        <div class="form-group mx-sm-4 pb-5">
                            <input type="submit" class="btn btn-primary ingresar btn-block" />
                        </div>
                        
                    </div>
                </div>
            </div>
        </form>
        
        
        <%@include file = "scripts.html"%>
    </body>
</html>
