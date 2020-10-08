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
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class BusquedaPaciente {
    
    /**
     * Determina si un paciente existe en la base de datos
     * @param connection Conexion de la base de datos
     * @param codigoPaciente Codigo del paciente
     * @return True si el paciente existe en la base de datos, de lo contrario retorna false
     */
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
    
    /**
     * Obtiene el codigo y el nombre de todos los pacientes
     * @param connection Conexión de la base de datos
     * @return ArrayList de tipo String[] que contiene el código y el nombre de cada paciente registrado en la base de datos
     */
    public ArrayList<String[]> allCredenciales(Connection connection) {
        
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT " + Paciente.CODIGO + "," + Paciente.NOMBRE +" FROM " + Paciente.NOMBRE_TABLA;
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            ResultSet result = preSt.executeQuery();
            
            while (result.next()) {
                String[] datos = new String[2];
                
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                
                lista.add(datos);
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error paciente all: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Obtiene los datos de todos los pacientes
     * @param connection Conexión de la base de datos
     * @return ArrayList tipo String[] que contiene los datos de todos los pacientes
     */
    public ArrayList<String[]> allAttributes (Connection connection) {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT codigo,nombre,sexo,fecha_nacimiento,tipo_sangre,telefono,correo FROM PACIENTE";
    
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            ResultSet result = preSt.executeQuery();
            
            while(result.next()) {
                String[] datos = new String[7];
                
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                datos[3] = result.getString(4);
                datos[4] = result.getString(5);
                datos[5] = result.getString(6);
                datos[6] = result.getString(7);
                
                lista.add(datos);
            }
                    
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error all: " + e.getMessage());
            return null;
        }
    
    }
    
}
