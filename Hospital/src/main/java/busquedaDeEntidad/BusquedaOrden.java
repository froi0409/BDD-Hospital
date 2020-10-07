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
     * 
     * @param connection
     * @param codigoPaciente
     * @param codigoExamen
     * @return 
     */
    public boolean pacienteOrden(Connection connection, String codigoPaciente, String codigoExamen) {
        
        String query = "SELECT " + Orden.VALIDEZ + " FROM " + Orden.NOMBRE_TABLA + " WHERE " + Orden.CODIGO_PACIENTE + " = ? " + Orden.CODIGO_EXAMEN + " = ?";
        
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
    
}
