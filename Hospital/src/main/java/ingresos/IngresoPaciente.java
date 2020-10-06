/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import analizadores.Conexion;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoPaciente extends Ingreso{
    
    private Paciente paciente;
    
    public IngresoPaciente (Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean ingresoArchivo(Connection connection) {
        
        String insert = "INSERT INTO " + Paciente.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, paciente.getCodigo());
            preSt.setString(2, paciente.getDpi());
            preSt.setString(3, paciente.getNombre());
            preSt.setString(4, paciente.getSexo());
            preSt.setString(5, paciente.getFechaNacimiento());
            preSt.setString(6, paciente.getTipoSangre());
            preSt.setString(7, paciente.getTelefono());
            preSt.setDouble(8, paciente.getPeso());
            preSt.setString(9, paciente.getCorreo());
            preSt.setString(10, paciente.getPassword());
            
            preSt.executeUpdate();
            
            IngresoPaciente ingresador = new IngresoPaciente(paciente);
            
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
