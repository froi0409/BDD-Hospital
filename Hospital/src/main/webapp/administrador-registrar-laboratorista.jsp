<%-- 
    Document   : administrador-registrar-laboratorista
    Created on : 6/10/2020, 06:42:11
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Registrar Laboratorista</title>
    </head>
    <body>
        <%@include file="administrador-cabecera.html" %>
        <%@include file="administrador-barra-herramientas.html" %>
        
        <!-- Creamos la ventana de registro -->
        <form action="RegistroMedico" method="POST">
            
            <div class="pt-2">
               &nbsp;
               <br>
            </div>
            
            <div class="container formulario pt-4" style="margin-bottom: 30px"> 
                <div class="row justify-content-center pt-1 mt-5 mr-1 " align="center">
                    <h1>Registro de Datos</h1>
                </div>
                <div class="row justify-content-center pt-2 mt-5 mr-1 "> <!-- Utilizamos el sistema de filas de bootstrap -->
                    
                    <div class="col-md-6">
                        
                        <div class="form-froup mx-sm-5 pb-5">
                            
                            <label for="codigo">Código</label>
                            <input type="text" class="form-control" placeholder="Ingrese Código" name="codigo"/>
                            <br>
                            <label for="password">Contraseña (provisional):</label>
                            <input type="password" class="form-control" name="password"/>
                            <br>
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre"/>
                            <br>
                            <label for="colegiado">Número de Registro:</label>
                            <input type="text" class="form-control" placeholder="Ingrese No. de Registro Ante el Ministrio" name="registro"/>
                            <br>
                            <label for="dpi">DPI:</label>
                            <input type="number" class="form-control" placeholder="Ingrese Número de DPI" name="dpi"/>
                            <br>
                            <label for="telefono">Teléfono:</label>
                            <input type="number" class="form-control" placeholder="Ingrese Teléfono" name="telefono"/>
                            
                        </div>
                        
                    </div>
                    
                    <div class="col-md-6">
                        
                        <div class="form-froup mx-sm-5 pb-5">
                        
                            <br>
                            <label for="correo">Correo Electrónico:</label>
                            <input type="email" class="form-control" placeholder="Ej: correo@anfield.com" name="correo"/>
                            <br>
                            <label for="horarioEntrada">Examen a realizar</label>
                            <input type="text" class="form-control" placeholder="Código del Examen que Realizará" name="examen"/>
                            <br> 
                            <label for="dias">Dias de Trabajo:</label>
                            <br>
                            <div>
                                <input type="checkbox" id="Lunes" value="Lunes" name="lunes"/><label for="Lunes">&nbsp;Lunes</label><br>
                                <input type="checkbox" id="Martes" value="Lunes" name="martes"/><label for="Martes">&nbsp;Martes</label><br>
                                <input type="checkbox" id="Miercoles" value="Lunes" name="miercoles"/><label for="Miercoles">&nbsp;Miércoles</label><br>
                                <input type="checkbox" id="Jueves" value="Lunes" name="jueves"/><label for="Jueves">&nbsp;Jueves</label><br>
                                <input type="checkbox" id="Viernes" value="Lunes" name="viernes"/><label for="Viernes">&nbsp;Viernes</label><br>
                                <input type="checkbox" id="Sabado" value="Lunes" name="sabado"/><label for="Sabado">&nbsp;Sábado</label><br>
                                <input type="checkbox" id="Domingo" value="Lunes" name="domingo"/><label for="Domingo">&nbsp;Domingo</label><br>
                            </div>
                            <br>
                            <label for="button">(Verifique que los datos sean correctos)</label>
                            <input type="submit" class="btn btn-info ingresar btn-block" value="Registrar Laboratorista"/>
                        </div>
                            
                    </div>
                </div>
            </div>
        </form>
        
        <%@include file = "scripts.html"%>
    </body>
</html>
