/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Informe;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoInforme extends Ingreso{
    
    private Informe informe;
    
    public IngresoInforme (Informe informe) {
        this.informe = informe;
    }

    @Override
    public void ingresoArchivo(Connection connection) {
        
        String insert = "INSERT INTO " + Informe.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
            preSt.setString(1, informe.getCodigo());
            preSt.setString(2, informe.getInforme());
            preSt.setString(3, informe.getFecha());
            preSt.setString(4, informe.getHora());
            preSt.setString(5, informe.getCodigoMedico());
            preSt.setString(6, informe.getCodigoPaciente());
            
            preSt.executeQuery();
            
        } catch (Exception e) {
        
        }
        
    }
    
}
