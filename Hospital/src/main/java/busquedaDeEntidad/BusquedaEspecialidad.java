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
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class BusquedaEspecialidad {
    
    private ArrayList<String> lista;

    public BusquedaEspecialidad() {
        lista = new ArrayList<String>();
    }
    
    /**
     * Metodo que nos sirve para obtener todas las especialidades que hay registradas en el sistema
     * @param connection Conexión de la base de datos
     * @return ArrayList que contiene el noombre de todas las especialidades
     */
    public ArrayList<String> all(Connection connection){
        
        String query = "SELECT nombre FROM " + Especialidad.NOMBRE_TABLA;
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            ResultSet result = preSt.executeQuery();
            
            while(result.next()) {
                
                lista.add(result.getString(1));
                
            }
            
        } catch (Exception e) {
            System.out.println("Error especialidad all: " + e.getMessage());
        }
        
        return lista;
    }
    
    /**
     * Método que sirve para obtener todas las especialidades que tiene un médico en específico dentro de la base de datos
     * @param connection Conexión de la base de datos
     * @param codigoMedico Codigo del médico, del que se están consultando las especialidades
     * @return ArrayList tipo String que contiene el nombre de las especialidades que tiene un médico en específico
     */
    public ArrayList<String> especialidadMedico(Connection connection, String codigoMedico) {
        
        String query = "SELECT " + Descripcion.NOMBRE_ESPECIALIDAD + " FROM " + Descripcion.NOMBRE_TABLA + " WHERE " + Descripcion.CODIGO_MEDICO + " = ?";
        ArrayList<String> lista = new ArrayList<String>();
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoMedico);
            
            ResultSet result = preSt.executeQuery();
            
            while(result.next()) {
                lista.add(result.getString(1));
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Especialidad Medico: " + e.getMessage());
            return null;
        }
        
    }
    
}
