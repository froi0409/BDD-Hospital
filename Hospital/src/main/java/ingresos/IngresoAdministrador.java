/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoAdministrador extends Ingreso{
    
    private Administrador administrador;
    
    public IngresoAdministrador(Administrador administrador){
        this.administrador = administrador;
    }
    
    @Override
    public boolean ingresoArchivo(Connection connection){
        
        String insert = "INSERT INTO " + Administrador.NOMBRE_TABLA + " VALUES (?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            System.out.println("SIUU");
            
            preSt.setString(1, administrador.getCodigo());
            preSt.setString(2, administrador.getDpi());
            preSt.setString(3, administrador.getNombre());
            preSt.setString(4, administrador.getPassword());
            
            preSt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean ingresoNormal(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
