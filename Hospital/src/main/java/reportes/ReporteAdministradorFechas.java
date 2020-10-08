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
public class ReporteAdministradorFechas {
    
    private String fechaInicial;
    private String fechaFinal;

    public ReporteAdministradorFechas(String fechaInicial, String fechaFinal) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }
    
    /**
     * Obtiene información de los 10 médicos que han hecho más informes en un intervalo de tiempo
     * @param connection Conexión de la base de datos
     * @return ArrayList tipo String[] que contiene el codigo, y cantidad de informes que un médico ha generado en el intervalo de tiempo ingresado
     */
    public ArrayList<String[]> medicosConMasInformes (Connection connection) {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT I.codigo_medico,M.nombre,COUNT(*) FROM INFORME I INNER JOIN MEDICO M ON M.codigo = I.codigo_medico WHERE fecha BETWEEN ? AND ? GROUP BY I.codigo_medico ORDER BY COUNT(*) DESC LIMIT 10";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, fechaInicial);
            preSt.setString(2, fechaFinal);
            
            ResultSet result = preSt.executeQuery();
            
            while (result.next()) {
                String[] datos = new String[3];
                
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                
                lista.add(datos);
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Médicos con Más Informes: " + e.getMessage());
            return null;
        }
        
    }
    
    /**
     * Obtiene información de los 5 médicos que tienen agendadas menos citas médicas en un intervalo de tiempo
     * @param connection Conexión de la base de datos
     * @return ArrayList de tipo String que contiene el codigo y nomere del médico, así como la cantidad de citas médicas que tiene agendadas
     */
    public ArrayList<String[]> medicosConMenosCitas(Connection connection) {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT M.codigo,M.nombre,COUNT(*) FROM CITA_MEDICA C INNER JOIN MEDICO M ON M.codigo = C.codigo_medico WHERE C.fecha BETWEEN ? AND ? GROUP BY C.codigo_medico ORDER BY COUNT(*) ASC LIMIT 5";
    
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, fechaInicial);
            preSt.setString(2, fechaFinal);
            
            ResultSet result = preSt.executeQuery();
            
            while (result.next()) {
                String[] datos = new String[3];
                
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                
                lista.add(datos);
            }
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error Medicos con Menos Citas Medicas: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Obtiene la información de los exámenes de laboratorio más demandados en un intervalo de tiempo
     * @param connection Conexion de la base de datos
     * @return ArrayList de tipo String[] que contiene el código, el nómbre y la cantidad de exámenes demandados de cada tipo
     * en el intervalo de tiempo determinado en el constructor de la clase
     */
    public ArrayList<String[]> examenesDemandados(Connection connection) {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT E.codigo,E.nombre,COUNT(*) FROM CITA_LABORATORIO C INNER JOIN EXAMEN E ON C.codigo_examen = E.codigo WHERE C.fecha BETWEEN ? AND ? GROUP BY C.codigo_examen ORDER BY COUNT(*) DESC";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, fechaInicial);
            preSt.setString(2, fechaFinal);
            
            ResultSet result = preSt.executeQuery();
            
            while (result.next()) {
                String[] datos = new String[3];
                
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                
                lista.add(datos);
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Examenes Demandados: " + e.getMessage());
            return null;
        }
        
    }
    
}
