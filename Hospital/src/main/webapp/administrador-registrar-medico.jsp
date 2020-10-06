<%-- 
    Document   : administrador-registrar-medico
    Created on : 5/10/2020, 23:45:01
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.html" %>
        <title>Registrar Médico</title>
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
                            
                            <label for="codigo">Codigo</label>
                            <input type="text" class="form-control" placeholder="Ingrese Codigo" name="codigo"/>
                            <br>
                            <label for="password">Contraseña (provisional):</label>
                            <input type="password" class="form-control" name="password"/>
                            <br>
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre"/>
                            <br>
                            <label for="colegiado">Colegiado</label>
                            <input type="text" class="form-control" placeholder="Ingrese No. de Colegiado" name="colegiado"/>
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
                            <label for="correo">Correo Electrónico:</label>
                            <input type="email" class="form-control" placeholder="Ej: correo@anfield.com" name="correo"/>
                            <br>
                            <label for="horarioEntrada">Horario de Entrada:</label>
                            <select name="horarioEntrada" class="btn-block">
                            <%
                                for(int i = 6; i < 23; i++) {
                                    out.println("<option>" + i + ":00</option>");
                                }
                            %>
                            </select>
                            <br> 
                            <label for="horarioSalida">Horario de Salida:</label>
                            <select name="horarioSalida" class="btn-block">
                            <%
                                for(int i = 6; i < 23; i++) {
                                    out.println("<option>" + i + ":00</option>");
                                }
                            %>
                            </select>
                            <br>
                            <label for="button">(Verifique que los datos sean correctos)</label>
                            <input type="submit" class="btn btn-primary ingresar btn-block" value="Registrar Médico"/>
                        </div>
                            
                    </div>
                </div>
            </div>
        </form>
        
        <%@include file = "scripts.html"%>
    </body>
</html>
