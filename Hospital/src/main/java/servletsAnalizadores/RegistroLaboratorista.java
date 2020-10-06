/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import entidades.DiasTrabajo;
import entidades.Laboratorista;
import entidades.Medico;
import ingresos.IngresoLaboratorista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "RegistroLaboratorista", urlPatterns = {"/RegistroLaboratorista"})
public class RegistroLaboratorista extends HttpServlet {

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
        
        Laboratorista laboratorista = new Laboratorista();
        DiasTrabajo dias = new DiasTrabajo();
        
        Medico medico = new Medico();
        Calendar c = new GregorianCalendar();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String año = Integer.toString(c.get(Calendar.YEAR));
        String fecha = año + "-" + mes + "-" + dia;
        
        laboratorista.setCodigo(request.getParameter("codigo"));
        laboratorista.setNombre(request.getParameter("nombre"));
        laboratorista.setRegistro(request.getParameter("registro"));
        laboratorista.setDpi(request.getParameter("dpi"));
        laboratorista.setTelefono(request.getParameter("telefono"));
        laboratorista.setCorreo(request.getParameter("correo"));
        laboratorista.setFechaInicio(fecha);
        laboratorista.setPassword(request.getParameter("password"));
        laboratorista.setCodigoExamen(request.getParameter("examen"));
        
        //no verifica si el día es true o false, aquí te quedaste
        System.out.println(Boolean.parseBoolean(request.getParameter("lunes")));
        System.out.println(Boolean.parseBoolean(request.getParameter("martes")));
        
        dias.setLunes(Boolean.parseBoolean(request.getParameter("lunes")));
        dias.setMartes(Boolean.parseBoolean(request.getParameter("martes")));
        dias.setMiercoles(Boolean.parseBoolean(request.getParameter("miercoles")));
        dias.setJueves(Boolean.parseBoolean(request.getParameter("jueves")));
        dias.setViernes(Boolean.parseBoolean(request.getParameter("viernes")));
        dias.setSabado(Boolean.parseBoolean(request.getParameter("sabado")));
        dias.setDomingo(Boolean.parseBoolean(request.getParameter("domingo")));
        
        IngresoLaboratorista ingresador = new IngresoLaboratorista(laboratorista,dias);
        if (ingresador.ingresoNormal(Conexion.getConnection())) {
            
            request.setAttribute("mensaje", "Laboratorista registrado con éxito");
            request.getRequestDispatcher("inicio-administrador.jsp").forward(request, response);
            
        } else {
            
            
            
        }
        
    }

}
