<%-- 
    Document   : paciente-crear-cita
    Created on : 4/10/2020, 23:09:25
    Author     : froi-pc
--%>

<%@page import="analizadores.Conexion"%>
<%@page import="busquedaDeEntidad.BusquedaEspecialidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <title>Solicitar Cita Médica</title>
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
        
        <!<!-- Incluimos la barra de herramientas -->
        <%@include file = "paciente-barra-herramientas.html"%>
        
        <!<!-- Creamos la ventana de creación de cita -->
        <form action="ConfirmarCita" method="POST">
            <div class="container"> 
                <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                    <div class="col-md-4 formulario">
                        <div class="form-group text-center pt-3">
                            <h3>Agendar Cita</h3>
                        </div>
                        <div class="form-froup mx-sm-5 pt3">
                            <label for="medico">Codigo del Médico:</label>
                            <input type="text" class="form-control" placeholder="Ingrese Codigo del Médico" name="medico"/> 
                            <br>
                            <!<!-- busca las especialidades -->
                            <label for="especialidad">Especialidad de la consulta:</label>
                            <select name="especialidad" class="btn-block">
                                <%
                                BusquedaEspecialidad find = new BusquedaEspecialidad();
                                
                                
                                for (String element : find.all(Conexion.getConnection())) {
                                    out.println("<option>" + element + "</option>");
                                }
                            %>
                            </select>
                            <br>                            
                            <label for="fecha">Fecha de la Cita: </label>
                            <input type="date" class="form-control" name="fecha"/> 
                            <br>
                            <label for="hora">Hora de la Cita (HH:00): </label>
                            <select name="hora" class="btn-block">
                                <%
                                for(int i = 6; i < 23; i++) {
                                    out.println("<option>" + i + ":00</option>");
                                }
                                %>
                            </select>
                                
                            <br>
                            
                            <input type="submit" class="btn btn-primary ingresar btn-block" value="Soilicitar"/>

                        </div>

                    </div>
                </div>
            </div>
        </form>
        
        <%@include file = "scripts.html"%>
    </body>
</html>
<%

    //Nos aseguramos de que exista una sesión
if(request.getSession().getAttribute("codigo") == null){
    response.sendRedirect("inicio-sesion.jsp");
}

%>