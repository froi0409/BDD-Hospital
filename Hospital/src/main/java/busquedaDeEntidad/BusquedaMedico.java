/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;

/**
 *
 * @author froi-pc
 */
public class BusquedaMedico {
    
    /**
     * Determina si un médico tiene disponibilidad de horario en una hora especifica
     * @param connection Conexión de la base de datos
     * @param codigoMedico Codigo del médico a consultar
     * @param hora Hora en la que se quiere verificar la disponibilidad
     * @return Retorna true si la hora especificada se encuentra dentro del horario del médico, de lo contrario devuelve false
     */
    public boolean disponibilidadDeHorario(Connection connection, String codigoMedico, String hora){
        
        String query = "SELECT (" + Medico.HORARIO_INICIO + "," + Medico.HORARIO_FIN + ") FROM " + Medico.NOMBRE_TABLA + " WHERE " + Medico.CODIGO + " = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoMedico);
            
            ResultSet result = preSt.executeQuery();
            result.next(); //Encontramos el horario
            
            LocalTime entrada = LocalTime.parse(result.getString(1));
            LocalTime salida = LocalTime.parse(result.getString(2));
            LocalTime solicitada = LocalTime.parse(hora);
            
            System.out.println("E: " + entrada + " S: " + salida);
            
            if(solicitada.getHour() < salida.getHour() && solicitada.getHour() > entrada.getHour()) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }
    
}
