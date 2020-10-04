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
public class Descripcion extends Entidad{
    
    public static final String NOMBRE_TABLA = "DESCRIPCION";
    public static final String CODIGO_MEDICO = "codigo_medico";
    public static final String NOMBRE_ESPECIALIDAD = "nombre_especialidad";
    
    private String codigoMedico;
    private String nombreEspecialidad;

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
}
