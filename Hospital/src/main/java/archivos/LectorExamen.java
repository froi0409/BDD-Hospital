/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.Estructura;
import entidades.Examen;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorExamen extends LectorArchivo{

    private Examen examen;
    
    public LectorExamen() {
        examen = new Examen();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for (Estructura element : atributos){
            
            if(element.getTipo().equals("CODIGO")){
                this.examen.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("NOMBRE")){
                this.examen.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("ORDEN")) {
                this.examen.setOrden(Boolean.parseBoolean(element.getDescripcion().toLowerCase()));
            } else if (element.getTipo().equals("DESCRIPCION")){
                this.examen.setDescripcion(element.getDescripcion());
            } else if (element.getTipo().equals("COSTO")){
                this.examen.setCosto(Double.parseDouble(element.getDescripcion()));
            } else if (element.getTipo().equals("INFORME")){
                this.examen.setInforme(element.getDescripcion());
            }
            
        }
        
    }
    
}
