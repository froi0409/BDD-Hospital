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
public class ReportePaciente {
    
    /**
     * Obtenemos los últimos 5 exámenes de laboratorio que un paciente realizó
     * @param connection Conexión con la base de datos
     * @param codigoPaciente Codigo del paciente
     * @return ArrayList tipo String que contiene el código, fecha y hora de la cita de laboratorio, y el nombre del examen realizado
     */
    public ArrayList<String[]>ultimosExamenes (Connection connection, String codigoPaciente) {
        
        ArrayList<String[]> lista = new ArrayList<String[]>();
        
        String query = "SELECT C.codigo,E.nombre,C.fecha,C.hora FROM CITA_LABORATORIO C INNER JOIN EXAMEN E ON C.codigo_examen = E.codigo WHERE C.codigo_paciente = ? AND C.fecha < DATE(NOW()) OR (C.fecha = DATE(NOW()) AND C.hora < NOW()) ORDER BY C.fecha DESC,C.hora DESC LIMIT 5" ;
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoPaciente);
            ResultSet result = preSt.executeQuery();
            
            while (result.next()) {
              String[] datos = new String[4];
              
              datos[0] = result.getString(1);
              datos[1] = result.getString(2);
              datos[2] = result.getString(3);
              datos[3] = result.getString(4);
                
              lista.add(datos);
              
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Reporte Ultimos Examenes Paciente: " + e.getMessage());
            return null;
        }
        
    }
    
    /**
     * Obtenemos las últimas 5 citas médicas que un paciente realizó
     * @param connection Conexión de la base de datos
     * @param codigoPaciente Código del paciente
     * @return ArrayList de tipo String[] que contiene ek códico, fecha y hora de la consulta y el nómbre del médico que realizó la consulta
     */
    public ArrayList<String[]> ultimasCitasMedicas (Connection connection, String codigoPaciente) {
        
        ArrayList<String[]> lista = new ArrayList<String[]>();
        
        String query = "SELECT C.codigo,M.nombre,C.fecha,C.hora FROM CITA_MEDICA C INNER JOIN MEDICO M ON C.codigo_medico = M.codigo WHERE C.codigo_paciente = ? AND (C.fecha < DATE(NOW()) OR (C.fecha = DATE(NOW())) AND C.hora < NOW()) ORDER BY C.fecha DESC, C.hora DESC LIMIT 5";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, codigoPaciente);
            ResultSet result = preSt.executeQuery();
            
            while(result.next()) {
                String[] datos = new String[4];
                
              datos[0] = result.getString(1);
              datos[1] = result.getString(2);
              datos[2] = result.getString(3);
              datos[3] = result.getString(4);
                
              lista.add(datos);
              
            }
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Reporte Ultimas Citas Médicas" + e.getMessage());
            return null;
        }
        
    }
    
}
