/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.CitaMedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author froi-pc
 */
public class IngresoCitaMedica extends Ingreso{
    
    private CitaMedica cita;
    
    public IngresoCitaMedica(CitaMedica cita){
        this.cita = cita;
    }

    @Override
    public boolean ingresoArchivo(Connection connection) {
        
        String insert = "INSERT INTO " + CitaMedica.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?)";
        String nombreEspecialidad = "SELECT D.nombre_especialidad FROM MEDICO M INNER JOIN DESCRIPCION D ON M.codigo = D.codigo_medico AND codigo_medico = ?";
        String costo = "SELECT costo FROM ESPECIALIDAD WHERE nombre = ?";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert);
                PreparedStatement preSt2 = connection.prepareStatement(nombreEspecialidad);
                PreparedStatement preSt3 = connection.prepareStatement(costo)) {
            
            preSt2.setString(1, cita.getCodigoMedico());
            
            ResultSet result2 = preSt2.executeQuery();
            result2.next(); //encontramos la especialidad del médico
            
            preSt3.setString(1, result2.getString(1)); //Completamos queery del costo
            
            ResultSet result3 = preSt3.executeQuery();
            result3.next(); //Obtenemos el costo de la consulta
            
            preSt.setString(1, cita.getCodigo());
            preSt.setString(2, cita.getFecha());
            preSt.setString(3, cita.getHora());
            preSt.setString(4, result3.getString(1));
            preSt.setString(5, cita.getCodigoMedico());
            preSt.setString(6, cita.getCodigoPaciente());
            preSt.setString(7, result2.getString(1));
            
            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }

    /**
     * Ingresa una cita médica con datos completos a la base de datos
     * @param connection Conexión de la base de datos
     * @return Retorna verdadero si la conexión se ha realizado con éxito, de lo contrario retorna false
     */
    @Override
    public boolean ingresoNormal(Connection connection) {
        
        String insert = "INSERT INTO " + CitaMedica.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, cita.getCodigo());
            preSt.setString(2, cita.getFecha());
            preSt.setString(3, cita.getHora());
            preSt.setDouble(4, cita.getCosto());
            preSt.setString(5, cita.getCodigoMedico());
            preSt.setString(6, cita.getCodigoPaciente());
            preSt.setString(7, cita.getNombreEspecialidad());

            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error ingreso cita: " + e.getMessage());
            return false;
        }
        
    }
    
    
}
