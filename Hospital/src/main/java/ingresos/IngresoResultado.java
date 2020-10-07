/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Resultado;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoResultado extends Ingreso {
    
    private Resultado resultado;

    public IngresoResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public boolean ingresoArchivo(Connection connection) {
        
        String insert = "INSERT INTO " + Resultado.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, resultado.getCodigo());
            preSt.setString(2, resultado.getFecha());
            preSt.setString(3, resultado.getHora());
            preSt.setString(4, resultado.getInforme());
            preSt.setString(5, resultado.getOrden());
            preSt.setString(6, resultado.getCodigoMedico());
            preSt.setString(7, resultado.getCodigoLaboratorista());
            preSt.setString(8, resultado.getCodigoPaciente());
            preSt.setString(9, resultado.getCodigoExamen());
            preSt.setString(10, null);
            
            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean ingresoNormal(Connection connection) {
        String insert = "INSERT INTO " + Resultado.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, resultado.getCodigo());
            preSt.setString(2, resultado.getFecha());
            preSt.setString(3, resultado.getHora());
            preSt.setString(4, resultado.getInforme());
            preSt.setString(5, resultado.getOrden());
            preSt.setString(6, resultado.getCodigoMedico());
            preSt.setString(7, resultado.getCodigoLaboratorista());
            preSt.setString(8, resultado.getCodigoPaciente());
            preSt.setString(9, resultado.getCodigoExamen());
            preSt.setString(10, resultado.getCodigoCitaLaboratorio());
            
            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }
    
}
