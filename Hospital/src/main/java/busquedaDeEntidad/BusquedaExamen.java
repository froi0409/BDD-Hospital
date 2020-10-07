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
    
    public String codigoExamen(Connection connection, String nombreExamen) throws NullPointerException {
        
        String query = "SELECT " + Examen.CODIGO + " FROM " + Examen.NOMBRE_TABLA + " WHERE " + Examen.NOMBRE + " = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, nombreExamen);
            
            ResultSet result = preSt.executeQuery();
            
            if (result.next()) {
                return result.getString(1);
            } else {
                return null;
            }
            
        } catch (Exception e) {
            System.out.println("Error Buscar Codigo Examen: " + e.getMessage());
            return null;
        }
    }
    
    public boolean requiereOrden(Connection connection, String nombreExamen) {
        
        String query = "SELECT " + Examen.ORDEN + " FROM " + Examen.NOMBRE_TABLA + " WHERE " + Examen.NOMBRE + " = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, nombreExamen);
            
            ResultSet result = preSt.executeQuery();
            result.next();
            
            if (result.getBoolean(1)) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error Requiere Orden: " + e.getMessage());
            return false;
        }
        
    }
    
    public double costo (Connection connection, String codigoExamen) {
        
        String query = "SELECT " + Examen.COSTO + " FROM " + Examen.NOMBRE_TABLA + " WHERE " + Examen.CODIGO + " = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoExamen);
            
            ResultSet result = preSt.executeQuery();
            
            //Determinamos si hay algún valor
            if (result.next()) {
                return result.getDouble(1);
            } else {
                return 0.00;
            }
            
        } catch (Exception e) {
            System.out.println("Error Costo Examen: " + e.getMessage());
            return 0.00;
        }
        
    }
    
}
