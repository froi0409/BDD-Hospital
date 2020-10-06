/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import ingresos.IngresoDescripcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "AgregarEspecialidad", urlPatterns = {"/AgregarEspecialidad"})
public class AgregarEspecialidad extends HttpServlet {

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
        
        String codigoMedico = (String) request.getSession().getAttribute("codigoMedico");
        String nombreEspecialidad = request.getParameter("especialidad");
        
        IngresoDescripcion ingresador = new IngresoDescripcion(codigoMedico, nombreEspecialidad);
        ingresador.ingresoNormal(Conexion.getConnection());
        
        request.getRequestDispatcher("administrador-registrar-medico-especialidades.jsp").forward(request, response);
        
    }

}
