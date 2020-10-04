/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.DiasTrabajo;
import entidades.Estructura;
import entidades.Laboratorista;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorLaboratorista extends LectorArchivo{

    private Laboratorista laboratorista;
    private DiasTrabajo dias = new DiasTrabajo();
    
    public LectorLaboratorista() {
        laboratorista = new Laboratorista();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for (Estructura element: atributos) {
            
            if(element.getTipo().equals("CODIGO")){
                laboratorista.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("NOMBRE")) {
                laboratorista.setNombre(element.getDescripcion());
            } else if (element.getTipo().equals("REGISTRO")) {
                laboratorista.setNombre(element.getDescripcion());
            } else if (element.getTipo().equals("DPI")) {
                laboratorista.setDpi(element.getDescripcion());
            } else if (element.getTipo().equals("TELEFONO")) {
                laboratorista.setTelefono(element.getDescripcion());
            } else if (element.getTipo().equals("EXAMEN")) {
                laboratorista.setCodigoExamen(element.getDescripcion());
            } else if (element.getTipo().equals("CORREO")) {
                laboratorista.setCorreo(element.getDescripcion());
            } else if (element.getTipo().equals("TRABAJO")) {
                agregarDias(element);
            } else if (element.getTipo().equals("TRABAJOF")) {
                laboratorista.setFechaInicio(element.getDescripcion());
            } else if (element.getTipo().equals("PASSWORD")) {
                laboratorista.setPassword(element.getDescripcion());
            }
            
        }
        
        
        
        
        atributos.clear();
        
    }
    
    private void agregarDias(Estructura estruct){
        
        int start = 1;
        int cont = 1;
        
        for (int i = 1; i < estruct.getDescripcion().length(); i++){
            
            if(estruct.getDescripcion().charAt(i) == ' '){
                start++;
            }
            
            if(estruct.getDescripcion().charAt(i) == '\n'){
                
                dias.getDias().add(estruct.getDescripcion().substring(start,i));
                
                switch(estruct.getDescripcion().substring(start,i)){
                    case "LUNES":
                        dias.setLunes(true);
                        break;
                    case "MARTES":
                        dias.setMartes(true);
                        break;
                    case "MIERCOLES":
                        dias.setMiercoles(true);
                        break;
                    case "JUEVES":
                        dias.setJueves(true);
                        break;
                    case "VIERNES":
                        dias.setViernes(true);
                        break;
                    case "SABADO":
                        dias.setSabado(true);
                        break;
                    case "DOMINGO":
                        dias.setDomingo(true);
                        break;
                }
                start = i + 1;
                
            }
            
        }
        
    }
    
}
