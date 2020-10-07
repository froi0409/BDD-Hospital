/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import entidades.Informe;
import ingresos.IngresoInforme;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "RegistroInforme", urlPatterns = {"/RegistroInforme"})
public class RegistroInforme extends HttpServlet {

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
        
        Informe informe = new Informe();
        
        Calendar c = new GregorianCalendar();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String año = Integer.toString(c.get(Calendar.YEAR));
        String fecha = año + "-" + mes + "-" + dia;
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        String hora = dateFormat.format(date);     
        
        String codigoPaciente = request.getParameter("codigoPaciente");
        String descripcion = request.getParameter("descripcion");
        String codigoInforme = "INF-" + codigoPaciente + fecha + hora;
        String codigoMedico = request.getSession().getAttribute("codigo").toString();
        
        informe.setCodigo(codigoInforme);
        informe.setInforme(descripcion);
        informe.setFecha(fecha);
        informe.setHora(hora);
        informe.setCodigoMedico(codigoMedico);
        informe.setCodigoPaciente(codigoPaciente);
        
        IngresoInforme ingresador = new IngresoInforme(informe);
        
        if (ingresador.ingresoNormal(Conexion.getConnection())) {
            request.setAttribute("mensaje", "Informe registrado con éxito");
            request.getRequestDispatcher("inicio-medico.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "Error al realizar el informe");
            request.getRequestDispatcher("inicio-medico.jsp").forward(request, response);
        }
        
    }

}
