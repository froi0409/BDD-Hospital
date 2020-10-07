/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.ArchivoDeEntrada;
import analizadores.Conexion;
import busquedaDeEntidad.BusquedaCitaLaboratorio;
import busquedaDeEntidad.BusquedaLaboratorista;
import entidades.CitaLaboratorio;
import entidades.Resultado;
import ingresos.IngresoResultado;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "RegistroReporte", urlPatterns = {"/RegistroReporte"})
@MultipartConfig
public class RegistroReporte extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BusquedaLaboratorista laboratoristaB = new BusquedaLaboratorista();
        BusquedaCitaLaboratorio citaL = new BusquedaCitaLaboratorio();
        
        ArchivoDeEntrada lector = new ArchivoDeEntrada(request, "informe");
        String path = lector.getPath();
        
        Calendar c = new GregorianCalendar();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String año = Integer.toString(c.get(Calendar.YEAR));
        String fecha = año + "-" + mes + "-" + dia;
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        String hora = dateFormat.format(date);  
        
        String codigoLaboratorista = request.getSession().getAttribute("codigo").toString();
        String codigoCitaLaboratorio = request.getParameter("codigoCita");
        String codigoResultado = "RE-" + codigoCitaLaboratorio;
        
        CitaLaboratorio cita = citaL.datosParaResultado(Conexion.getConnection(), codigoCitaLaboratorio);
        
        
        
        if (laboratoristaB.trabajaHoy(Conexion.getConnection(), codigoLaboratorista)) {
            
            Resultado resultado = new Resultado(); //Creamos nuestro objeto Resultado
            //Agregamos los atributos de nuestro objeto
            resultado.setCodigo(codigoResultado);
            resultado.setFecha(fecha);
            resultado.setHora(hora);
            resultado.setCodigoLaboratorista(codigoLaboratorista);
            resultado.setCodigoCitaLaboratorio(codigoCitaLaboratorio);
            resultado.setOrden(cita.getCodigoOrden());
            resultado.setCodigoPaciente(cita.getCodigoPaciente());
            resultado.setCodigoExamen(cita.getCodigoExamen());
            resultado.setInforme(path);
            
            
            IngresoResultado ingresador = new IngresoResultado(resultado);
            if (ingresador.ingresoNormal(Conexion.getConnection())) {
                
                request.setAttribute("mensaje", "Resultado registrado con éxito");
                request.getRequestDispatcher("inicio-laboratorista.jsp").forward(request, response);
                
            } else {
                
                request.setAttribute("mensaje", "Error al registrar resultado");
                request.getRequestDispatcher("inicio-laboratorista.jsp").forward(request, response);
                
            }
            
        } else {
            System.out.println("No trabaja hoy");
            response.sendRedirect("inicio-laboratorista.jsp");
        }
                
        
    }

}
