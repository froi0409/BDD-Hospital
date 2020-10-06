/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import entidades.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "RegistroMedico", urlPatterns = {"/RegistroMedico"})
public class RegistroMedico extends HttpServlet {

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
        
        //Aún debes agregar las restrcciones que tiene el ingreso de datos
        
        Date fecha = new Date();
        Medico medico = new Medico();
        
        medico.setCodigo(request.getParameter("codigo"));
        medico.setPassword(request.getParameter("password"));
        medico.setNombre(request.getParameter("nombre"));
        medico.setColegiado(request.getParameter("colegiado"));
        medico.setDpi(request.getParameter("dpi"));
        medico.setTelefono(request.getParameter("telefono"));
        medico.setCorreo(request.getParameter("correo"));
        medico.setHorarioInicio(request.getParameter("horarioEntrada"));
        medico.setHorarioFin(request.getParameter("horarioSalida"));
        medico.setFecha(fecha.toString());
        
    }

}
