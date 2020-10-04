/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.AnalizadorDeDatos;
import analizadores.AnalizarContraseña;
import analizadores.Conexion;
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
@WebServlet(name = "AnalizadorDatosLogin", urlPatterns = {"/AnalizadorDatosLogin"})
public class AnalizadorDatosLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        Conexion con = new Conexion();
        AnalizadorDeDatos analizador = new AnalizadorDeDatos();
        AnalizarContraseña encriptador = new AnalizarContraseña();
        
        String tabla = request.getParameter("TABLA").toUpperCase();
        String usuario = request.getParameter("user"); //Obtenemos el usuario
        String password = encriptador.encriptar(request.getParameter("password")); //Obtenemos la contraseña
        
        System.out.println("Contraseña: " + password);
        
        //condición que nos permite saber si la base de datos está vacía y si los datos ingresados en el formulario son los del creador de la base de datos
        if(!analizador.baseLlena(Conexion.getConnection()) && request.getParameter("user").equals(con.getUser()) && request.getParameter("password").equals(con.getPassword())){
            
            request.getRequestDispatcher("/subir-archivo.jsp").forward(request, response); //Nos dirigimos a la pagina de ingreso de archivos
            
        } else if (analizador.inicioSesion(usuario, password, tabla, Conexion.getConnection())) {
            
            String rutaJsp = "/inicio-" + tabla.toLowerCase() + ".jsp";
            
            request.getRequestDispatcher(rutaJsp).forward(request, response);
            
        } else {
            
        }
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
