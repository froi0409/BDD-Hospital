/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author froi-pc
 */
public class Especialidad extends Entidad{
    
    public static final String NOMBRE_TABLA = "ESPECIALIDAD";
    public static final String NOMBRE = "nombre";
    public static final String COSTO = "costo";
    
    private String nombre;
    private double costo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
