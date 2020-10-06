/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import entidades.CitaMedica;
import ingresos.IngresoCitaMedica;
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
@WebServlet(name = "CrearCita", urlPatterns = {"/CrearCita"})
public class CrearCita extends HttpServlet {

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
        
        //Verificamos que exista una sesión en el sistema
        if (request.getSession().getAttribute("codigo") == null) {
            response.sendRedirect("inicio-sesion.jsp");
        }
        
        CitaMedica cita = new CitaMedica();
        
        cita.setCodigo(request.getSession().getAttribute("codigoCitaMedica").toString());
        cita.setFecha(request.getSession().getAttribute("fecha").toString());
        cita.setHora(request.getSession().getAttribute("hora").toString());
        cita.setCosto(Double.parseDouble(request.getSession().getAttribute("costo").toString()));
        cita.setCodigoMedico(request.getSession().getAttribute("codigoMedico").toString());
        cita.setCodigoPaciente(request.getSession().getAttribute("codigo").toString());
        cita.setNombreEspecialidad(request.getSession().getAttribute("especialidad").toString());
        
        IngresoCitaMedica ingresador = new IngresoCitaMedica(cita);
        ingresador.ingresoNormal(Conexion.getConnection());
        
        request.getSession().removeAttribute("codigoCitaMedica");
        request.getSession().removeAttribute("fecha");
        request.getSession().removeAttribute("hora");
        request.getSession().removeAttribute("costo");
        request.getSession().removeAttribute("codigoMedico");
        request.getSession().removeAttribute("especialidad");
        
        request.setAttribute("mensaje", "Se ha agendado su cita médica con éxito");
        request.getRequestDispatcher("inicio-paciente.jsp").forward(request, response);
        
    }

}
