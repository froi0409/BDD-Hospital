/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author froi-pc
 */
public class BusquedaPaciente {
    
    public boolean exists(Connection connection, String codigoPaciente) {
        
        String query = "SELECT COUNT(*) FROM " + Paciente.NOMBRE_TABLA + " WHERE " + Paciente.CODIGO + " = ?";
         
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoPaciente);
            
            ResultSet result = preSt.executeQuery();
            result.next();
            
            if(result.getInt(1) == 1) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error Paciente Exists: " + e.getMessage());
            return false;
        }
        
    }
    
}
