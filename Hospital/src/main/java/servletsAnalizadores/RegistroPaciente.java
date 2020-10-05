/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import entidades.Paciente;
import ingresos.IngresoPaciente;
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
@WebServlet(name = "RegistroPaciente", urlPatterns = {"/RegistroPaciente"})
public class RegistroPaciente extends HttpServlet {

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
        
        Paciente paciente = new Paciente();
        
        paciente.setCodigo(request.getParameter("codigo"));
        paciente.setDpi(request.getParameter("dpi"));
        paciente.setNombre(request.getParameter("nombre"));
        paciente.setSexo(request.getParameter("sexo"));
        paciente.setFechaNacimiento(request.getParameter("fecha"));
        paciente.setTipoSangre(request.getParameter("sangre"));
        paciente.setTelefono(request.getParameter("telefono"));
        paciente.setPeso(Double.parseDouble(request.getParameter("peso")));
        paciente.setCorreo(request.getParameter("correo"));
        paciente.setPassword(request.getParameter("password"));
        
        IngresoPaciente ingresador = new IngresoPaciente(paciente);
        
        if (ingresador.ingresoNormal(Conexion.getConnection())){
            
        } else {
            
        }
        
    }


}
