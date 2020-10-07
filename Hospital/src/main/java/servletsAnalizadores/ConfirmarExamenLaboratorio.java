/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import actualizaciones.ActualizacionOrden;
import analizadores.Conexion;
import busquedaDeEntidad.BusquedaExamen;
import busquedaDeEntidad.BusquedaOrden;
import entidades.CitaLaboratorio;
import ingresos.IngresoCitaLaboratorio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "ConfirmarExamenLaboratorio", urlPatterns = {"/ConfirmarExamenLaboratorio"})
public class ConfirmarExamenLaboratorio extends HttpServlet {

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
        
        BusquedaExamen examen = new BusquedaExamen();
        BusquedaOrden orden = new BusquedaOrden();
        ActualizacionOrden ordenUpdate = new ActualizacionOrden();
        
        CitaLaboratorio cita = new CitaLaboratorio();
        
        String nombreExamen = request.getParameter("nombreExamen");
        String codigoExamen = examen.codigoExamen(Conexion.getConnection(), nombreExamen);
        String codigoPaciente = request.getSession().getAttribute("codigo").toString();
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String codigoOrden = orden.codigoOrden(Conexion.getConnection(), codigoPaciente, codigoExamen);
        double costo = examen.costo(Conexion.getConnection(), codigoExamen);
        
        String codigoCita = "LAB-" + codigoExamen + codigoPaciente + fecha;
        
        cita.setCodigo(codigoCita);
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setCosto(costo);
        cita.setCodigoPaciente(codigoPaciente);
        cita.setCodigoExamen(codigoExamen);
        cita.setCodigoOrden(codigoOrden);
        
        System.out.println("Examen: " + codigoExamen + "\nPaciente: " + codigoPaciente);
        
        if (examen.requiereOrden(Conexion.getConnection(), nombreExamen) && orden.pacienteOrden(Conexion.getConnection(), codigoPaciente, codigoExamen)) { //Condición que determina si el examen requiere de orden
            
            IngresoCitaLaboratorio ingresador = new IngresoCitaLaboratorio(cita);
            
            ingresador.ingresoNormal(Conexion.getConnection());
            ordenUpdate.actualizarEstadoOrden(Conexion.getConnection(), codigoPaciente, codigoExamen);
            
            request.setAttribute("mensaje", "Cita de Laboratorio agendada con éxito");
            request.getRequestDispatcher("inicio-paciente.jsp").forward(request, response);
            
        } else if (!examen.requiereOrden(Conexion.getConnection(), nombreExamen)) { //Condición que determina si el examen simplemente no requiere de orden 
            
            IngresoCitaLaboratorio ingresador = new IngresoCitaLaboratorio(cita);
            ingresador.ingresoNormal(Conexion.getConnection());
            
            request.setAttribute("mensaje", "Cita de Laboratorio agendada con éxito");
            request.getRequestDispatcher("inicio-paciente.jsp").forward(request, response);
        } else if (examen.requiereOrden(Conexion.getConnection(), nombreExamen)) {
            
            request.setAttribute("mensaje", "Error al generar cita, el éxamen necesita de una orden médica para ser agendado");
            request.getRequestDispatcher("inicio-paciente.jsp").forward(request, response);
            
        } else {
            request.setAttribute("mensaje", "Error al generar cita, verifique que sus datos sean correctos");
            request.getRequestDispatcher("inicio-paciente.jsp").forward(request, response);
        }
        
    }

}
