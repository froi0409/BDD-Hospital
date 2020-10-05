/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.CitaMedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author froi-pc
 */
public class BusquedaCitaMedica {
    
    /**
     * Determina si un medico está ocupado en cierta fecha y hora
     * @param connection Conexion de la base de datos
     * @param codigoMedico Codigo del médico a consultar
     * @param fecha Fecha a consultar
     * @param hora Hora a consultar
     * @return Retorna true si el médico tiene ocupado el horario consultado en la fecha consultada, de lo contrario retorna false
     */
    public boolean medicoOcupado (Connection connection, String codigoMedico, String fecha, String hora) {
        
        String query = "SELECT COUNT(*) FROM " + CitaMedica.NOMBRE_TABLA + " WHERE " + CitaMedica.CODIGO_MEDICO + " = ? AND " + CitaMedica.FECHA + " = ? AND " + CitaMedica.HORA + " = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoMedico);
            preSt.setString(2, fecha);
            preSt.setString(3, hora);
            
            ResultSet result = preSt.executeQuery();
            result.next();
            
            if (result.getInt(1) > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error medico ocupado: " + e.getMessage());
            return true;
        }
        
    }
    
}
