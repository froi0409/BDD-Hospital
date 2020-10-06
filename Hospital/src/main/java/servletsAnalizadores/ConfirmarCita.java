/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import busquedaDeEntidad.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "ConfirmarCita", urlPatterns = {"/ConfirmarCita"})
public class ConfirmarCita extends HttpServlet {

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
        
        //Verificamos que el usuario esté dentro de la sesion
        if (request.getSession().getAttribute("codigo") == null) {
            response.sendRedirect("inicio-sesion.jsp");
        }
        
        BusquedaDescripcion descripcion = new BusquedaDescripcion();
        BusquedaMedico medico = new BusquedaMedico();
        BusquedaCitaMedica cita = new BusquedaCitaMedica();
        
        
        boolean aceptacion = true;
        String error = "";
        String codigoMedico = request.getParameter("medico");
        String especialidad = request.getParameter("especialidad");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        
        if (!descripcion.exists(Conexion.getConnection(), codigoMedico, especialidad)) {
            aceptacion = false;
            error += "El médico ingresado no posee la especialidad seleccionada. ";
        } 
        
        if (!medico.disponibilidadDeHorario(Conexion.getConnection(), codigoMedico, hora)) {
            aceptacion = false;
            error += "El médico no trabaja en el horario solicitado. ";
        } else if (cita.medicoOcupado(Conexion.getConnection(), codigoMedico, fecha, hora)) {
            aceptacion = false;
            error += "El médico se encuentra ocupado en el horario solicitado. ";
        }
        
        if (aceptacion) {
            
            double costo = descripcion.getCostoCita(Conexion.getConnection(), codigoMedico, especialidad);
            String codigoPaciente = (String) request.getSession().getAttribute("codigo");
            String codigoCitaMedica = codigoMedico + codigoPaciente + fecha + hora;
            
            request.getSession().setAttribute("codigoMedico", codigoMedico);
            request.getSession().setAttribute("especialidad", especialidad);
            request.getSession().setAttribute("fecha", fecha);
            request.getSession().setAttribute("hora", hora);
            request.getSession().setAttribute("costo", costo);
            request.getSession().setAttribute("codigoCitaMedica", codigoCitaMedica);
            request.getSession().setAttribute("aprobacion", true);
            
            request.getRequestDispatcher("paciente-confirmacion-cita.jsp").forward(request, response);
            
        } else {
            
            request.setAttribute("mensaje", error);
            request.setAttribute("aprobacion", false);
            
            request.getRequestDispatcher("paciente-confirmacion-cita.jsp").forward(request, response);
            
        }
        
    }


}
