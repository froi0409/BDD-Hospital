/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analizadores.Etiqueta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorArchivo {
    
    private String ruta;
    private ArrayList<String> etiquetas;
    
    public LectorArchivo(String ruta){
        this.ruta = ruta;
        inicializarEtiquetas(); //Inicializamos las etiquetas principales
    }
    
    /**
     * Clase utilizada para identificar las etiquetas principales que el archivo de entrada tendrá
     */
    private void inicializarEtiquetas(){
        etiquetas = new ArrayList<String>();
        etiquetas.add("admin");
        etiquetas.add("doctor");
        etiquetas.add("Laboratorista");
        etiquetas.add("paciente");
        etiquetas.add("examen");
        etiquetas.add("reporte");
        etiquetas.add("resultado");
        etiquetas.add("cita");
        etiquetas.add("consulta");
    }
    
    public void leerEntrada(){
        try {
            String linea;
            ArrayList<Etiqueta> grupoLineas = new ArrayList<Etiqueta>(); //grupo de etiquetas que será enviado a la clase que lo leera
            BufferedReader reader = new BufferedReader(new FileReader(ruta)); //declaramos el lector del archivo
            
            boolean startBlock = false; //servirá para identificar el inicio de un bloque
            boolean endBlock = false; //servirá para identificar el dinal de un bloque
            
            do{
                linea = reader.readLine();
                
                if(linea != null){ //Evita que el documento termine en la linea final
                    
                    grupoLineas.add(new Etiqueta(linea));
                    
                }
                
            }while(linea != null);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
