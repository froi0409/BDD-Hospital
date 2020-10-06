/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analizadores.Conexion;
import entidades.Administrador;
import entidades.Entidad;
import entidades.Estructura;
import ingresos.IngresoAdministrador;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorAdministrador extends LectorArchivo{
    
    private Administrador administrador;

    
    public LectorAdministrador(){
        administrador = new Administrador();
    }

    /**
     * Convierte un ArrayList de tipo String en un objeto de tipo Administrador
     * @param atributos ArrayList de tipo String que contiene los atributos que debe tener un Administrador.
     */
    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for(Estructura element: atributos){
            
            if(element.getTipo().equals("CODIGO")){
                this.administrador.setCodigo(element.getDescripcion());
            } else if(element.getTipo().equals("DPI")) {
                this.administrador.setDpi(element.getDescripcion());
            } else if(element.getTipo().equals("NOMBRE")) {
                this.administrador.setNombre(element.getDescripcion());
            } else if(element.getTipo().equals("PASSWORD")) {
                this.administrador.setPassword(element.getDescripcion());
            }
            
        }
        
        IngresoAdministrador ingresador = new IngresoAdministrador(this.administrador);
        ingresador.ingresoArchivo(Conexion.getConnection());
        
    }
    
    public Administrador getAdministrador() {
        return administrador;
    }
    
}
