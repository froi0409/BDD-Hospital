<%-- 
    Document   : registro
    Created on : 1/10/2020, 02:16:18
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <link href="estilos/login.css" rel="stylesheet" type="text/css"/>
        <title>Registrarse</title>
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
                    <h2>Registarse&nbsp;&nbsp;</h2>
                </div>

            </div>

        </div>
            
        <!-- Creamos la ventana de registro -->
        <form action="RegistroPaciente" method="POST">
            
            <div class="pt-2">
               &nbsp;
               <br>
            </div>
            
            <div class="container formulario pt-4"> 
                <div class="row justify-content-center pt-1 mt-5 mr-1 " align="center">
                    <h1>Registro de Datos</h1>
                </div>
                <div class="row justify-content-center pt-2 mt-5 mr-1 "> <!-- Utilizamos el sistema de filas de bootstrap -->
                    
                    
                    
                    <div class="col-md-6">
                        
                        <div class="form-froup mx-sm-5 pb-5">
                            
                            <label for="codigo">Usuario:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Usuario" name="codigo"/>
                            <br>
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre"/>
                            <br>
                            <label for="sexo">Sexo:</label>
                            <select name="sexo" class="btn-block">
                                <option>Hombre</option>
                                <option>Mujer</option>
                            </select>
                            <br>
                            <label for="fecha">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" name="fecha"/>
                            <br>
                            <label for="dpi">DPI:</label>
                            <input type="number" class="form-control" placeholder="Ingrese Número de DPI" name="dpi"/>
                            <br>
                            
                        </div>
                        
                    </div>
                    
                    <div class="col-md-6">
                        
                        <div class="form-froup mx-sm-5 pb-5">
                        
                            <label for="telefono">Telefono:</label>
                            <input type="number" class="form-control" placeholder="Ingrese Teledono" name="telefono"/>
                            <br>
                            <label for="peso">Peso:</label>
                            <input type="number" step="any" class="form-control" placeholder="Ingrese su Peso" name="peso"/>
                            <br>
                            <label for="sangre">Tipo de Sangre:</label>
                            <input type="text" class="form-control" placeholder="Ingrese su Tipo de Sangre" name="sangre"/>
                            <br>
                            <label for="correo">Correo Electrónico:</label>
                            <input type="email" class="form-control" placeholder="Ej: correo@anfield.com" name="correo"/>
                            <br>
                            <label for="correo">(Verifique que sus datos sean correctos)</label>
                            <input type="submit" class="btn btn-primary ingresar btn-block" value="Registrarse"/>
                            
                        </div>
                            
                    </div>
                </div>
            </div>
        </form>
        
        
        <%@include file = "scripts.html"%>
    </body>
</html>
