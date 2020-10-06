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
    
    /**
     * Detecta si hay datos determinantes en la base de datos
     * @param connection Conexión de la base de datos
     * @return 
     */
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
    
    
    /**
     * Analiza si los datos ingresados se encuentran registrados en la base de datos
     * @param user Usuario del cliente
     * @param password Contraseña desencriptada del usuario 
     * @return Retorna true si el usuario y contraseña existen en la base de datos, de lo contrario retorna false
     */
    public boolean inicioSesion(String user, String password, String Tabla, Connection connection){
        
        boolean comprobador = false;
        
        String query = "SELECT COUNT(*) FROM " + Tabla + " WHERE codigo = ? AND password = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, user);
            preSt.setString(2, password);
            
            ResultSet result = preSt.executeQuery();
            
            if(result.next()){
                
                if(result.getInt(1) == 1) {
                    
                    comprobador = true;
                    
                }
                
            }
            
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return comprobador;
        
    }
    
}
