/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import busquedaDeEntidad.BusquedaExamen;
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
@WebServlet(name = "PacienteReporteTipoExamen", urlPatterns = {"/PacienteReporteTipoExamen"})
public class PacienteReporteTipoExamen extends HttpServlet {

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
        
        BusquedaExamen examenB = new BusquedaExamen();
        
        //Declaramos las variables
        String codigoExamen = examenB.codigoExamen(Conexion.getConnection(), request.getParameter("nombreExamen"));
        String fechaInicial = request.getParameter("fechaInicial");
        String fechaFinal = request.getParameter("fechaFinal");
        String codigoPaciente = request.getSession().getAttribute("codigo").toString();
        
        //Pasammos los parámetros
        request.getSession().setAttribute("codigoExamen", codigoExamen);
        request.getSession().setAttribute("fechaInicial", fechaInicial);
        request.getSession().setAttribute("fechaFinal", fechaFinal);
        request.getSession().setAttribute("codigoPaciente", codigoPaciente);
        request.getRequestDispatcher("paciente-reporte-examenes-tipo.jsp").forward(request, response);
        
    }

}
