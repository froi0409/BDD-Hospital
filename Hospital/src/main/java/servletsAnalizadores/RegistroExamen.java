/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import ingresos.IngresoExamen;
import entidades.Examen;
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
@WebServlet(name = "RegistroExamen", urlPatterns = {"/RegistroExamen"})
public class RegistroExamen extends HttpServlet {

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
        
        Examen examen = new Examen();
        
        if (request.getParameter("orden").equals("Si")) {
            examen.setOrden(true);
        } else {
            examen.setOrden(false);
        }
        
        examen.setCodigo(request.getParameter("codigo"));
        examen.setNombre(request.getParameter("nombre"));
        examen.setDescripcion(request.getParameter("descripcion"));
        examen.setInforme(request.getParameter("informe"));
        examen.setCosto(Double.parseDouble(request.getParameter("costo")));
        
        IngresoExamen ingresador = new IngresoExamen(examen);
        if (ingresador.ingresoNormal(Conexion.getConnection())) {
            
            request.setAttribute("mensaje", "Examen de Laboratorio Registrado con Éxito");
            request.getRequestDispatcher("inicio-administrador.jsp").forward(request, response);
            
        }
        
    }

}
