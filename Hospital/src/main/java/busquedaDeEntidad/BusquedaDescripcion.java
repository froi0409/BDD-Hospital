/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.Descripcion;
import entidades.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author froi-pc
 */
public class BusquedaDescripcion {
    
    /**
     * Consulta y devuelve el precio de la especialidad de un médico
     * @param connection Conexión de la base de datos
     * @param codigoMedico Codigo del médico a consultar
     * @param especialidad Nombre de la especialidad a Consultar
     * @return devuelve el costo que tendría una cita medica de alguna especialidad con determinado doctor
     */
    public double getCostoCita(Connection connection, String codigoMedico, String especialidad){
        
        if (exists(connection, codigoMedico, especialidad)) {
            
            String query = "SELECT costo FROM" + Especialidad.NOMBRE_TABLA + " WHERE nombre = ?";
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
                
                preSt.setString(1, especialidad);
                
                ResultSet result = preSt.executeQuery();
                result.next();
                
                return result.getDouble(1);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return 0.00;
            }
            
        }
        
        return 0.00;
        
    }
    
    /**
     * Comprueba si el medico ingresado posee la especialidad ingresada
     * @param connection Conexión de la base de datos
     * @param codigoMedico Codigo del médico a consultar
     * @param especialidad Nombre de la especialidad a consultar
     * @return Devuelve true si el médico posee la especialidad ingresada
     */
    public boolean exists(Connection connection, String codigoMedico, String especialidad) {
        
        String query = "SELECT COUNT(*) FROM " + Descripcion.NOMBRE_TABLA + " WHERE codigo_medico = ? AND nombre_especialidad = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoMedico);
            preSt.setString(2, especialidad);
            
            ResultSet result = preSt.executeQuery();
            result.next(); //Encontramos la cantidad de registros
            
            if(result.getInt(1) == 1){
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }
    
}
