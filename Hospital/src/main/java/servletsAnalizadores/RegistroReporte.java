/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import busquedaDeEntidad.BusquedaLaboratorista;
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
@WebServlet(name = "RegistroReporte", urlPatterns = {"/RegistroReporte"})
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
        
        String codigoLaboratorista = request.getSession().getAttribute("codigo").toString();
        
        if (laboratoristaB.trabajaHoy(Conexion.getConnection(), codigoLaboratorista)) {
            System.out.println("Trabaja Hoy");
        } else {
            System.out.println("No trabaja hoy");
        }
                
        
    }

}
