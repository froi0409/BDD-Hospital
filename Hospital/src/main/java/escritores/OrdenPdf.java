/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritores;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entidades.Orden;
import java.io.FileOutputStream;

/**
 *
 * @author froi-pc
 */
public class OrdenPdf {
    
    private Orden orden;

    /**
     * Establece el objeto que se manejará para el pdf
     * @param orden Objeto orden que se utilizará para el manejo de su archivo pdf
     */
    public OrdenPdf(Orden orden) {
        this.orden = orden;
    }
    
    /**
     * Crea una orden de laboratorio en formato pdf
     * @return Retorna true si la orden se generó con éxito, de lo contrario retorna false
     */
    public boolean write() {
        
        try {
            
            FileOutputStream archivo = new FileOutputStream(orden.getPath());
            Document documento = new Document();
            
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            
            Paragraph parrafo = new Paragraph("ORDEN DE LABORATORIO");
            parrafo.setAlignment(1);
            documento.add(parrafo);
            
            documento.add(new Paragraph("Codigo de orden: " + orden.getCodigo()));
            documento.add(new Paragraph("Codigo del Examen : " + orden.getCodigoExamen()));
            documento.add(new Paragraph("Descripción: " + orden.getDescripcion()));
            documento.add(new Paragraph("Fecha de Emisión: " + orden.getFechaCreacion()));
            documento.add(new Paragraph("Codigo del paciente: " + orden.getCodigoPaciente()));
            
            documento.close();
            
            System.out.println("Orden de laboratorio PDF generada con éxito");
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error de Escritura PDF: " + e.getMessage());
            return false;
        }
        
    }
    
}
