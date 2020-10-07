/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.CitaLaboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

/**
 *
 * @author froi-pc
 */
public class IngresoCitaLaboratorio {
    
    private CitaLaboratorio cita;

    public IngresoCitaLaboratorio(CitaLaboratorio cita) {
        this.cita = cita;
    }
    
    public void ingresoNormal(Connection connection) {
        
        String query = "INSERT INTO " + CitaLaboratorio.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, cita.getCodigo());
            preSt.setString(2, cita.getFecha());
            preSt.setString(3, cita.getHora());
            preSt.setDouble(4, cita.getCosto());
            preSt.setString(5, cita.getCodigoPaciente());
            preSt.setString(6, cita.getCodigoExamen());
            preSt.setString(7, cita.getCodigoOrden());
            
            preSt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error Ingreso Cita Laboratorio: " + e.getMessage());
        }
        
    }
    
}
