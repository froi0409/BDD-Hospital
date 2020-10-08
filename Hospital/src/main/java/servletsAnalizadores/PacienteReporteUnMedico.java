/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

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
@WebServlet(name = "PacienteReporteUnMedico", urlPatterns = {"/PacienteReporteUnMedico"})
public class PacienteReporteUnMedico extends HttpServlet {

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
        
        String codigoMedico = request.getParameter("codigoMedico");
        String fechaInicial = request.getParameter("fechaInicial");
        String fechaFinal = request.getParameter("fechaFinal");
        
        System.out.println(codigoMedico);
        System.out.println(fechaInicial);
        System.out.println(fechaFinal);
        
        request.getSession().setAttribute("codigoMedico", codigoMedico);
        request.getSession().setAttribute("fechaInicial", fechaInicial);
        request.getSession().setAttribute("fechaFinal", fechaFinal);
        
        request.getRequestDispatcher("paciente-reporte-citas-medico.jsp").forward(request, response);
        
    }

}
