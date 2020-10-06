/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Descripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoDescripcion {
    
    private String codigoMedico;
    private String nombreEspecialidad;

    public IngresoDescripcion(String codigoMedico, String nombreEspecialidad) {
        this.codigoMedico = codigoMedico;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public boolean ingresoNormal(Connection connection) {
        
        String insert = "INSERT INTO " + Descripcion.NOMBRE_TABLA + " VALUES (?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, codigoMedico);
            preSt.setString(2, nombreEspecialidad);
            
            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error ingreso descripcion: " + e.getMessage());
            return false;
        }
        
    }
    
}
