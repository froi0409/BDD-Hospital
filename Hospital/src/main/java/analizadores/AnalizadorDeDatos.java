/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author froi-pc
 */
public class AnalizadorDeDatos {
    
    public boolean baseLlena(Connection connection){
        boolean comprobante = true;
        String query = "SELECT COUNT(*) FROM ADMINISTRADOR";
        try (PreparedStatement prest = connection.prepareStatement(query)) {
            
            ResultSet result = prest.executeQuery();
            result.next();
            
            if(result.getInt(1) > 0){
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            return false;
        }
    }
    
}
