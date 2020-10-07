/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.Conexion;
import busquedaDeEntidad.BusquedaCitaMedica;
import busquedaDeEntidad.BusquedaDescripcion;
import busquedaDeEntidad.BusquedaPaciente;
import entidades.CitaMedica;
import entidades.Orden;
import escritores.Escritor;
import escritores.OrdenPdf;
import ingresos.IngresoCitaMedica;
import ingresos.IngresoOrden;
import java.io.IOException;
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
@WebServlet(name = "GenerarCitaMedico", urlPatterns = {"/GenerarCitaMedico"})
public class GenerarCitaMedico extends HttpServlet {

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
        
        Calendar c = new GregorianCalendar();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String año = Integer.toString(c.get(Calendar.YEAR));
        
        BusquedaPaciente paciente = new BusquedaPaciente();
        BusquedaCitaMedica citaMedica = new BusquedaCitaMedica();
        BusquedaDescripcion descripcionB = new BusquedaDescripcion();
        
        String nombreEspecialidad = request.getParameter("nombreEspecialidad");
        String codigoPaciente = request.getSession().getAttribute("codigoPaciente").toString();
        String codigoMedico = request.getSession().getAttribute("codigo").toString();
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String codigoCita = codigoPaciente + fecha + hora;
        double costo = descripcionB.getCostoCita(Conexion.getConnection(), codigoMedico, nombreEspecialidad);
        
        String codigoExamen = request.getSession().getAttribute("codigoExamen").toString();
        String descripcion = request.getSession().getAttribute("descripcion").toString();
        String path = Escritor.SERVER_RESOURCES_PATH + "/" + codigoPaciente + "_" + fecha + "_" + codigoExamen + ".pdf";
        String fechaCreacion = año + "-" + mes + "-" + dia;
        String codigoOrden = fecha+codigoPaciente+codigoExamen;
        
        String error = "";
        boolean aprobacion = true;
        
        //Comprobamos que el paciente exista dentro de la base de datos
        if (!paciente.exists(Conexion.getConnection(), codigoPaciente)) {
            aprobacion = false;
            error += "El paciente ingresado no se encuentra registrado en el sistema. ";
        }
        
        //Comprobamos si el médico no tiene ocupado dicho horario
        if (citaMedica.medicoOcupado(Conexion.getConnection(), codigoMedico, fecha, hora)) {
            aprobacion = false;
            error += "Usted tiene ocupado el horario en el que desea agendar la consulta. ";
        }
        
        Orden orden = new Orden();
        CitaMedica cita = new CitaMedica();
        
        cita.setCodigo(codigoCita);
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setCosto(costo);
        cita.setCodigoMedico(codigoMedico);
        cita.setCodigoPaciente(codigoPaciente);
        cita.setNombreEspecialidad(nombreEspecialidad);
        
        orden.setCodigo(codigoOrden);
        orden.setCodigoExamen(codigoExamen);
        orden.setDescripcion(descripcion);
        orden.setPath(path);
        orden.setFechaCreacion(fechaCreacion);
        orden.setCodigoPaciente(codigoPaciente);
        
        IngresoCitaMedica ingresadorCita = new IngresoCitaMedica(cita);
        IngresoOrden ingresadorOrden = new IngresoOrden(orden);
        OrdenPdf opdf = new OrdenPdf(orden);
        
        if(ingresadorCita.ingresoNormal(Conexion.getConnection()) && ingresadorOrden.ingresoNormal(Conexion.getConnection())) {
            
            opdf.write();
            
            request.getSession().removeAttribute("codigoExamen");
            request.getSession().removeAttribute("descripcion");

            request.setAttribute("mensaje", "Orden Medica generada con éxito. Cita médica agendada con éxito. ");
            request.getRequestDispatcher("inicio-medico.jsp").forward(request, response);


        } else {
            System.out.println("problema :c");
        }
        
    }

}
