/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.Especialidad;
import entidades.Estructura;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorConsulta extends LectorArchivo{

    private Especialidad especialidad;
    
    public LectorConsulta() {
        especialidad = new Especialidad();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for (Estructura element : atributos){
            
            if (element.getTipo().equals("TIPO")){
                this.especialidad.setNombre(element.getDescripcion());
            } else if (element.getTipo().equals("COSTO")){
                this.especialidad.setCosto(Double.parseDouble(element.getDescripcion()));
            }
            
        }
        
    }
    
}
