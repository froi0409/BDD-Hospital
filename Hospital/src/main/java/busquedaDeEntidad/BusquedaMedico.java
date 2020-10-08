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
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

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
        
        String query = "SELECT " + Medico.HORARIO_INICIO + "," + Medico.HORARIO_FIN + " FROM " + Medico.NOMBRE_TABLA + " WHERE " + Medico.CODIGO + " = ?";
        
        System.out.println(query);
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoMedico);
            
            ResultSet result = preSt.executeQuery();
            if(result.next()) { //Encontramos el horario
                
                Date entrada = new SimpleDateFormat("HH:mm").parse(result.getString(1));
                Date salida = new SimpleDateFormat("HH:mm").parse(result.getString(2));
                Date solicitada = new SimpleDateFormat("HH:mm").parse(hora);

                System.out.println("E: " + entrada + " S: " + salida);
                if((solicitada.after(entrada) && solicitada.before(salida)) || solicitada.equals(entrada) ||solicitada.equals(salida)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            
            
        } catch (Exception e) {
            System.out.println("Error disponibilidad medico: " + e.getMessage());
            return false;
        }
        
    }
    
    /**
     * Obtiene el intervalo de tiempo en el que trabaja un médico en específico
     * @param connection Conexión de la base de datos
     * @param codigoMedico Código del médico a consultar horario
     * @return ArrayList de tipo String, el cuál contiene cada hora (en punto) que se encuentra dentro del intervalo cerrado en el que trabaja el médico consultado
     */
    public ArrayList<String> horarioMedico(Connection connection, String codigoMedico) {
        
        String query = "SELECT " + Medico.HORARIO_INICIO + "," + Medico.HORARIO_FIN + " FROM " + Medico.NOMBRE_TABLA + " WHERE " + Medico.CODIGO + " = ?";
        ArrayList<String> lista = new ArrayList<String>();
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoMedico);
            
            ResultSet result = preSt.executeQuery();
            if(result.next()) {
                
                for (int i = 6; i <= 22; i++) {
                    
                    String hora = i + ":00";
                    Date horaConvertida = new SimpleDateFormat("HH:mm").parse(hora);
                    Date entrada = new SimpleDateFormat("HH:mm").parse(result.getString(1));
                    Date salida = new SimpleDateFormat("HH:mm").parse(result.getString(2));
                    
                    
                    if ((horaConvertida.after(entrada)) && horaConvertida.before(salida) || horaConvertida.equals(entrada) || horaConvertida.equals(salida)) {
                        lista.add(hora);
                    }
                    
                }
                
                return lista;
                
            } else {
                return null;
            }
            
        } catch (Exception e) {
            System.out.println("Error Horario Medico: " + e.getMessage());
            return null;
        }
        
    }
    
    /**
     * Obtiene el Codigo y nombre de todos los médicos registrados en la base de datos
     * @param connection Conexión de la Base de Datos
     * @return ArrayList tipo String[] que contiene el código y nombre de cada uno de los médicos registrados en la base de datos
     */
    public ArrayList<String[]> all(Connection connection) {
        
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT " + Medico.CODIGO + "," + Medico.NOMBRE + " FROM " + Medico.NOMBRE_TABLA;
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            ResultSet result = preSt.executeQuery();
            while(result.next()) {
                String[] datos = new String[2];
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                
                lista.add(datos);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error Medico All: " + e.getMessage());
            return null;
        }
        
    }
    
}
