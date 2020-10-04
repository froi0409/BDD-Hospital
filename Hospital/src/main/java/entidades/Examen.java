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
public class Examen extends Entidad{
    
    public static final String NOMBRE_TABLA = "EXAMEN";
    public static final String CODIGO = "codigo";
    public static final String NOMBRE = "nombre";
    public static final String ORDEN = "orden";
    public static final String DESCRIPCION = "descripcion";
    public static final String COSTO = "costo";
    public static final String INFORME = "informe";
    
    private String codigo;
    private String nombre;
    private boolean orden;
    private String descripcion;
    private double costo;
    private String informe;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isOrden() {
        return orden;
    }

    public void setOrden(boolean orden) {
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }
    
}
