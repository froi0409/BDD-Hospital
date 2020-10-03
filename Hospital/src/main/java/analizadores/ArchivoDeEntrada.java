/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author froi-pc
 */
public class ArchivoDeEntrada {
    
    private HttpServletRequest request;
    private String rutaCarpeta;
    private String parametroFileHtml;
    
    public ArchivoDeEntrada(HttpServletRequest request, String parametroFileHtml){
        this.request = request;
        this.parametroFileHtml = parametroFileHtml;
    }
    
    public void setArchivo(){
         //String description = request.getParameter(""); //Recuperamos lo obtenido en el input file de html
        
         try{
            Part filePart = request.getPart(parametroFileHtml);
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            OutputStream salida = new FileOutputStream(fileName);
            fileContent.transferTo(salida);
            File file = Paths.get(filePart.getSubmittedFileName()).toFile();

            rutaCarpeta = file.getAbsolutePath().replace("/" + file.getName(), "");

            System.out.println(rutaCarpeta);
         } catch (Exception ex) {
             
         }
    }
    
}
