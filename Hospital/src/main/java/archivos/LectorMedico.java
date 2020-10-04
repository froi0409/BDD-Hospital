/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.Especialidad;
import entidades.Estructura;
import entidades.Medico;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorMedico extends LectorArchivo{

    private Medico medico;
    
    public LectorMedico() {
        medico = new Medico();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for(Estructura element : atributos) {
            
            if (element.getTipo().equals("CODIGO")) {
                medico.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("NOMBRE")) {
                medico.setNombre(element.getDescripcion());
            } else if (element.getTipo().equals("COLEGIADO")) {
                medico.setColegiado(element.getDescripcion());
            } else if (element.getTipo().equals("DPI")) {
                medico.setDpi(element.getDescripcion());
            } else if (element.getTipo().equals("TELEFONO")) {
                medico.setTelefono(element.getDescripcion());
            } else if (element.getTipo().equals("ESPECIALIDAD")) {
                setEspecialidades(element);
            } else if (element.getTipo().equals("CORREO")) {
                medico.setCorreo(element.getDescripcion());
            } else if (element.getTipo().equals("HORARIO")) {
                setHorario(element);
            } else if (element.getTipo().equals("TRABAJO")) {
                medico.setFecha(element.getDescripcion());
            } else if (element.getTipo().equals("PASSWORD")) {
                medico.setPassword(element.getDescripcion());
            }
            
        }
        
    }
    
    private void setEspecialidades(Estructura estruct){
        
        int start = 1;
        
        for (int i = 1; i < estruct.getDescripcion().length(); i++){
            
            if(estruct.getDescripcion().charAt(i) == ' '){
                start++;
            }
            
            if(estruct.getDescripcion().charAt(i) == '\n'){
                
                Especialidad especialidad = new Especialidad();
                especialidad.setNombre(estruct.getDescripcion().substring(start, i));
                
                medico.getEspecialidades().add(especialidad);
                start = i + 1;
                
            }
            
        }
        
    }
    
    private void setHorario(Estructura estruct){
        
        int start = 1;
        int cont = 0;
        
        for (int i = 1; i < estruct.getDescripcion().length(); i++){
            
            if(estruct.getDescripcion().charAt(i) == ' '){
                start++;
            }
            
            if(estruct.getDescripcion().charAt(i) == '\n'){
                
                if(cont == 0){
                    medico.setHorarioInicio(estruct.getDescripcion().substring(start, i));
                } else {
                    medico.setHorarioFin(estruct.getDescripcion().substring(start, i));
                }
                
                start = i + 1;
                
            }
            
        }
        
    }
    
}
