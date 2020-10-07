/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author froi-pc
 */
public class BusquedaResultado {
    
    public String extension(Connection connection, String codigoExamen) {
        
        String query = "SELECT " + Examen.INFORME + " FROM " + Examen.NOMBRE_TABLA + " WHERE " + Examen.CODIGO + " = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoExamen);
            ResultSet result = preSt.executeQuery();
            
            if (result.next()) {
                return result.getString(1);
            } else {
                return null;
            }
            
        } catch (Exception e) {
            System.out.println("Error Extensión");
            return null;
        }
        
        
    }
    
}
