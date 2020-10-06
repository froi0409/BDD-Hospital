<%-- 
    Document   : administrador-registrar-examen
    Created on : 6/10/2020, 10:23:26
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Registrar Examen</title>
    </head>
    <body>
        <%@include file="administrador-cabecera.html" %>
        <%@include file="administrador-barra-herramientas.html" %>
        
        <!-- Creamos la ventana de registro -->
        <form action="RegistroExamen" method="POST">
            
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
                            <input type="text" class="form-control" placeholder="Ingrese Código" name="codigo" required/>
                            <br>
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Nombre del Examen" name="nombre" required/>
                            <br>
                            <label for="costo">Costo del Examen (En Quetzales - Q):</label>
                            <input type="number" step="any" class="form-control" placeholder="Ej: 125.00" name="costo" required/>
                            <br>
                            <label for="orden">¿Requiere Orden Médica?</label>
                            <select name="orden" class="btn-block">
                                <option>Si</option>
                                <option>No</option>
                            </select>
                            <br>
                            
                        </div>
                        
                    </div>
                    
                    <div class="col-md-6">
                        
                        <div class="form-froup mx-sm-5 pb-5">
                        
                            <label for="informe">Tipo del Informe:</label>
                            <select name="informe" class="btn-block">
                                <option>PDF</option>
                                <option>PNG</option>
                            </select>
                            <br>
                            <label for="descripcion">Descripcion:</label>
                            <textarea name="descripcion" rows="5" class="form-control" required></textarea>
                            <br>
                            <label for="button">(Verifique que los datos sean correctos)</label>
                            <input type="submit" class="btn btn-info ingresar btn-block" value="Registrar Examen"/>
                        </div>
                            
                    </div>
                </div>
                
            </div>
        </form>
        
        <%@include file="scripts.html" %>
    </body>
</html>
