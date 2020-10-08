/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAnalizadores;

import analizadores.ArchivoDeEntrada;
import analizadores.LectorXml;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "LecturaArchivo", urlPatterns = {"/LecturaArchivo"})
@MultipartConfig //Permite reconocer y soportar las solicitudes de multipart/form-data (usado en el input file de html)
public class LecturaArchivo extends HttpServlet {
    
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
        String path;
        ArchivoDeEntrada lector = new ArchivoDeEntrada(request,"ruta"); //Enviamos al constructor la propiedad request
        path = lector.getPath();//obtenemos el path del archivo en el servidor
       
        LectorXml lectxml = new LectorXml();
        lectxml.read(path);
        request.setAttribute("mensaje", "Archivo subido con éxito");
        request.getRequestDispatcher("inicio-sesion.jsp").forward(request, response);
       
    }

}
