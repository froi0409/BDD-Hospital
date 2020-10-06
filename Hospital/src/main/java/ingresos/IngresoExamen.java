/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoExamen extends Ingreso {
    
    private Examen examen;
    
    public IngresoExamen (Examen examen) {
        this.examen = examen;
    }

    @Override
    public boolean ingresoArchivo(Connection connection) {
        
        String insert = "INSERT INTO " + Examen.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
        
            preSt.setString(1, examen.getCodigo());
            preSt.setString(2, examen.getNombre());
            preSt.setBoolean(3, examen.isOrden());
            preSt.setString(4, examen.getDescripcion());
            preSt.setDouble(5, examen.getCosto());
            preSt.setString(6, examen.getInforme());
        
            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean ingresoNormal(Connection connection) {
        return ingresoArchivo(connection);
    }
    
}
