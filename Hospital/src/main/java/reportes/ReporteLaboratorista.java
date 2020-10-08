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
public class ReporteLaboratorista {
 
    public ArrayList<String[]> examenesARealizar(Connection connection, String codigoLaboratorista) {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT codigo_examen FROM LABORATORISTA WHERE codigo = ?";
        String query2 = "SELECT C.codigo,C.hora,P.codigo,P.nombre FROM CITA_LABORATORIO C INNER JOIN PACIENTE P ON P.codigo = C.codigo_paciente WHERE C.codigo_examen = ? AND C.hora > NOW() AND C.fecha = DATE(NOW())";
        
        try (PreparedStatement preSt = connection.prepareStatement(query);
                PreparedStatement preSt2 = connection.prepareStatement(query2)) {
            
            preSt.setString(1, codigoLaboratorista);
            ResultSet result = preSt.executeQuery();
            result.next(); //Obtenemos el codigo de examen de laboratorio que realiza el laboratorista
            
            String codigoExamen = result.getString(1);
            
            preSt2.setString(1, codigoExamen);
            ResultSet result2 = preSt2.executeQuery(); 
            
            while(result2.next()) { //Obtenemos los datos de los examenes que se realizan ese día
                String[] datos = new String[4];
                
                datos[0] = result2.getString(1);
                datos[1] = result2.getString(2);
                datos[2] = result2.getString(3);
                datos[3] = result2.getString(4);
                
                lista.add(datos);
            }
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error Examenes a Realizar: " + e.getMessage());
            return null;
        }
        
    }

    public ArrayList<String[]> examenesRealizados(Connection connection, String codigoLaboratorista) {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT codigo_examen FROM LABORATORISTA WHERE codigo = ?";
        String query2 = "SELECT C.codigo,C.hora,P.codigo,P.nombre FROM CITA_LABORATORIO C INNER JOIN PACIENTE P ON P.codigo = C.codigo_paciente WHERE C.codigo_examen = ? AND C.hora < NOW() AND C.fecha = DATE(NOW())";
        
        try (PreparedStatement preSt = connection.prepareStatement(query);
                PreparedStatement preSt2 = connection.prepareStatement(query2)) {
            
            preSt.setString(1, codigoLaboratorista);
            ResultSet result = preSt.executeQuery();
            result.next(); //Obtenemos el codigo de examen de laboratorio que realiza el laboratorista
            
            String codigoExamen = result.getString(1);
            
            preSt2.setString(1, codigoExamen);
            ResultSet result2 = preSt2.executeQuery(); 
            
            while(result2.next()) { //Obtenemos los datos de los examenes que se realizan ese día
                String[] datos = new String[4];
                
                datos[0] = result2.getString(1);
                datos[1] = result2.getString(2);
                datos[2] = result2.getString(3);
                datos[3] = result2.getString(4);
                
                lista.add(datos);
            }
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error Examenes a Realizar: " + e.getMessage());
            return null;
        }
        
    }
    
    public ArrayList<String[]> diasConMasTrabajo(Connection connection, String codigoLaboratorista) {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT codigo_examen FROM LABORATORISTA WHERE codigo = ?";
        String query2 = "SELECT fecha,COUNT(*) FROM CITA_LABORATORIO WHERE codigo_examen = ? GROUP BY fecha ORDER BY COUNT(*) DESC LIMIT 10" +
"";
        
        try (PreparedStatement preSt = connection.prepareStatement(query);
                PreparedStatement preSt2 = connection.prepareStatement(query2)) {
            
            preSt.setString(1, codigoLaboratorista);
            ResultSet result = preSt.executeQuery();
            result.next(); //Obtenemos el codigo de examen de laboratorio que realiza el laboratorista
            
            String codigoExamen = result.getString(1);
            
            preSt2.setString(1, codigoExamen);
            ResultSet result2 = preSt2.executeQuery(); 
            
            while(result2.next()) { //Obtenemos los datos de los examenes que se realizan ese día
                String[] datos = new String[2];
                
                datos[0] = result2.getString(1);
                datos[1] = result2.getString(2);
                
                lista.add(datos);
            }
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error Examenes a Realizar: " + e.getMessage());
            return null;
        }
    }
    
}
