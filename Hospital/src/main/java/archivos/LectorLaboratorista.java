/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analizadores.Conexion;
import entidades.DiasTrabajo;
import entidades.Estructura;
import entidades.Laboratorista;
import ingresos.IngresoLaboratorista;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorLaboratorista extends LectorArchivo{

    private Laboratorista laboratorista;
    private DiasTrabajo dias;
    
    public LectorLaboratorista() {
        laboratorista = new Laboratorista();
        dias = new DiasTrabajo();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for (Estructura element: atributos) {
            
            if(element.getTipo().equals("CODIGO")){
                laboratorista.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("NOMBRE")) {
                laboratorista.setNombre(element.getDescripcion());
            } else if (element.getTipo().equals("REGISTRO")) {
                laboratorista.setRegistro(element.getDescripcion());
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
        
        
        IngresoLaboratorista ingresador = new IngresoLaboratorista(laboratorista, dias);
        atributos.clear();
        ingresador.ingresoArchivo(Conexion.getConnection());
        
        
    }
    
    private void agregarDias(Estructura estruct){
        
        dias.setLunes(false);
        dias.setMartes(false);
        dias.setMiercoles(false);
        dias.setJueves(false);
        dias.setViernes(false);
        dias.setSabado(false);
        dias.setDomingo(false);
        
        int start = 1;
        int cont = 1;
        
        for (int i = 1; i < estruct.getDescripcion().length(); i++){
            
            if(estruct.getDescripcion().charAt(i) == ' '){
                start++;
            }
            
            if(estruct.getDescripcion().charAt(i) == '\n'){
                
                dias.getDias().add(estruct.getDescripcion().substring(start,i));
                
                System.out.println("+++++---" + estruct.getDescripcion().substring(start,i) );
                
                if(estruct.getDescripcion().substring(start,i).equals("Lunes")) {
                    dias.setLunes(true);
                } else if (estruct.getDescripcion().substring(start,i).equals("Martes")) {
                    dias.setMartes(true);
                } else if (estruct.getDescripcion().substring(start,i).equals("Miercoles")) {
                    dias.setMiercoles(true);
                } else if (estruct.getDescripcion().substring(start,i).equals("Jueves")) {
                    dias.setJueves(true);
                } else if (estruct.getDescripcion().substring(start,i).equals("Viernes")) {
                    dias.setViernes(true);
                } else if (estruct.getDescripcion().substring(start,i).equals("Sabado")) {
                    dias.setSabado(true);
                } else if (estruct.getDescripcion().substring(start,i).equals("Domingo")) {
                    dias.setDomingo(true);
                }
                
                start = i + 1;
                
            }
            
        }
        
    }
    
}
