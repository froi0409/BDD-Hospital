/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Orden;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoOrden {
    
    private Orden orden;

    public IngresoOrden(Orden orden) {
        this.orden = orden;
    }
    
    public boolean ingresoNormal(Connection connection) {
        
        String insert = "INSERT INTO " + Orden.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, orden.getCodigo());
            preSt.setString(2, orden.getCodigoExamen());
            preSt.setString(3, orden.getDescripcion());
            preSt.setString(4, orden.getPath());
            preSt.setString(5, orden.getFechaCreacion());
            preSt.setString(6, orden.getCodigoPaciente());
            preSt.setString(7, orden.getCodigoMedico());
            preSt.setBoolean(8, true);
            
            preSt.executeUpdate();
            
            System.out.println("Orden de Laboratorio ingresada con éxito");
            return true;
            
        } catch (Exception e) {
            System.out.println("Error Ingreso Orden: " + e.getMessage());
            return false;
        }
        
    }
    
}
