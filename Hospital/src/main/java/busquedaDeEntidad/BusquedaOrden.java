/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.Orden;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author froi-pc
 */
public class BusquedaOrden {
    
    /**
     * Determina si un paciente tiene una orden de exámen de laboratorio en específico. Al mismo tiempo verifica que la orden de laboratorio esté disponible
     * @param connection Conexion de la base de datos
     * @param codigoPaciente Codigo del paciente
     * @param codigoExamen Codigo del examen de laboratorio
     * @return Retorna true si el paciente posee una orden exámen de laboratorio válida, de lo contrario retorna false
     */
    public boolean pacienteOrden(Connection connection, String codigoPaciente, String codigoExamen) {
        
        String query = "SELECT " + Orden.VALIDEZ + " FROM " + Orden.NOMBRE_TABLA + " WHERE " + Orden.CODIGO_PACIENTE + " = ? AND " + Orden.CODIGO_EXAMEN + " = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoPaciente);
            preSt.setString(2, codigoExamen);
            
            ResultSet result = preSt.executeQuery();
            
            if (result.next()) {
                
                if (result.getBoolean(1)) {
                    return true;
                } else {
                    return false;
                }
                
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error Paciente Orden: " + e.getMessage());
            return false;
        }
        
    }
    
    /**
     * Obtiene el codigo de una orden de examen de laboratorio
     * @param connection Conexión de la base de datos
     * @param codigoPaciente Codigo del paciente
     * @param codigoExamen Codigo del examen 
     * @return Retorna el código que tiene la orden médica, siempre que el código del paciente y el código del examen tengan una orden dentro de la base de datos
     * @throws NullPointerException Si el código del paciente y el código del examen no tienen una orden dentro de la base de datos
     */
    public String codigoOrden(Connection connection, String codigoPaciente, String codigoExamen) throws NullPointerException {
        
        String query = "SELECT " + Orden.CODIGO + " FROM " + Orden.NOMBRE_TABLA + " WHERE " + Orden.CODIGO_PACIENTE + " = ? AND " + Orden.CODIGO_EXAMEN + " = ? AND " + Orden.VALIDEZ + " = 1";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoPaciente);
            preSt.setString(2, codigoExamen);
            
            ResultSet result = preSt.executeQuery();
            
            if (result.next()) {
                return result.getString(1);
            } else {
                return null;
            }
            
        } catch (Exception e) {
            System.out.println("Error Codigo Orden: " + e.getMessage());
            return null;
        }
        
    }
    
}
