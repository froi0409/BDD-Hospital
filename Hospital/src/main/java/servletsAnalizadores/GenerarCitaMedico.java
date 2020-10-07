/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import busquedaDeEntidad.BusquedaCitaMedica;
import busquedaDeEntidad.BusquedaPaciente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "GenerarCitaMedico", urlPatterns = {"/GenerarCitaMedico"})
public class GenerarCitaMedico extends HttpServlet {

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
        
        BusquedaPaciente paciente = new BusquedaPaciente();
        BusquedaCitaMedica citaMedica = new BusquedaCitaMedica();
        
        String codigoPaciente = request.getParameter("codigoPaciente");
        String codigoMedico = request.getSession().getAttribute("codigo").toString();
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        
        String error = "";
        boolean aprobacion = true;
        
        if (!paciente.exists(Conexion.getConnection(), codigoPaciente)) {
            aprobacion = false;
            error += "El paciente ingresado no se encuentra registrado en el sistema. ";
        }
        if (citaMedica.medicoOcupado(Conexion.getConnection(), codigoMedico, fecha, hora)) {
            aprobacion = false;
            error += "Usted tiene ocupado el horario en el que desea agendar la consulta. ";
        }
        
        
        
    }

}
