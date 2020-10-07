/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import busquedaDeEntidad.BusquedaExamen;
import busquedaDeEntidad.BusquedaPaciente;
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
@WebServlet(name = "GenerarOrden", urlPatterns = {"/GenerarOrden"})
public class GenerarOrden extends HttpServlet {

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
        
        BusquedaExamen examen = new BusquedaExamen();
        BusquedaPaciente paciente = new BusquedaPaciente();
        
        String codigoPaciente = request.getParameter("codigoPaciente");
        String codigoExamen = examen.codigoExamen(Conexion.getConnection(), request.getParameter("nombreExamen"));
        String descripcion = request.getParameter("descripcion");
        
        if (paciente.exists(Conexion.getConnection(), codigoPaciente)) {
            
            request.getSession().setAttribute("codigoPaciente", codigoPaciente);
            request.getSession().setAttribute("codigoExamen", codigoExamen);
            request.getSession().setAttribute("descripcion", descripcion);
            request.getRequestDispatcher("medico-generar-cita.jsp").forward(request, response);

        } else {
            
            request.setAttribute("mensaje", "Error al tratar de agendar la consulta, el paciente no existe en el sistema.");
            request.getRequestDispatcher("inicio-medico.jsp").forward(request, response);
            
        }
        
        
    }

}
