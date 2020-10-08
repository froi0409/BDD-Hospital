/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class ReporteMedico {
    
    public ArrayList<String[]> citasHoy(Connection connection, String codigoMedico){
        
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT C.codigo,C.nombre_especialidad,P.codigo,P.nombre,C.fecha,C.hora FROM CITA_MEDICA C INNER JOIN PACIENTE P ON C.codigo_paciente = P.codigo WHERE C.codigo_medico = ? AND C.fecha = DATE(NOW())";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoMedico);
            ResultSet result = preSt.executeQuery();
            
            while (result.next()) {
                String[] datos = new String[6];
                
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                datos[3] = result.getString(4);
                datos[4] = result.getString(5);
                datos[5] = result.getString(6);
                
                lista.add(datos);
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Citas Hoy: " + e.getMessage());
            return null;
        }
        
    }
    
}
