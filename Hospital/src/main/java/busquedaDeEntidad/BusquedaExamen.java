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
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class BusquedaExamen {
    
    /**
     * Metodo que sirve para obtener todos los examenes de labotaorio regitrados en a base de datos
     * @param connection Conexión de la base de datos
     * @return Retorna un ArrayList tipo String que contiene el nombre de todos los examenes de laboratorio que están registrados
     */
    public ArrayList<String> all(Connection connection) {
        
        String query = "SELECT nombre FROM " + Examen.NOMBRE_TABLA;
        ArrayList<String> lista = new ArrayList<String>();
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            ResultSet result = preSt.executeQuery();
            
            while (result.next()) {
                lista.add(result.getString(1));
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Especialidad All: " + e.getMessage());
            return null;
        }
        
    }
    
}