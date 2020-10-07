/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.DiasTrabajo;
import entidades.Laboratorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

/**
 *
 * @author froi-pc
 */
public class BusquedaLaboratorista {
    
    private String[] dias;
    
    public boolean trabajaHoy(Connection connection, String codigoLaboratorista) {
        
        Calendar calendario = Calendar.getInstance();
        dias = new String[]{"domingo","lunes","martes","miercoles","Jueves","viernes","sabado"};
        String hoy = dias[calendario.get(Calendar.DAY_OF_WEEK) - 1];
        
        
        String query = "SELECT * FROM " + Laboratorista.NOMBRE_TABLA +" L INNER JOIN " + DiasTrabajo.NOMBRE_TABLA + " D ON D.codigo = L." + Laboratorista.CODIGO_DIAS_TRABAJO + " WHERE L." + Laboratorista.CODIGO + " = ?";
        System.out.println(query);
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoLaboratorista);
            
            ResultSet result = preSt.executeQuery();
            if (result.next() && result.getBoolean(hoy)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error Trabaja Hoy: " + e.getMessage());
            return false;
        }
    }
    
}
