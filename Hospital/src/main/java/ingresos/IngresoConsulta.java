/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoConsulta extends Ingreso{
    
    private Especialidad especialidad;
    
    public IngresoConsulta (Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean ingresoArchivo(Connection connection) {
        
        String insert = "INSERT INTO " + Especialidad.NOMBRE_TABLA + " VALUES (?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, especialidad.getNombre());
            preSt.setDouble(2, especialidad.getCosto());
            
            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean ingresoNormal(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
