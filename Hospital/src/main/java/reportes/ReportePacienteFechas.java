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
public class ReportePacienteFechas {
    
    private String fechaInicial;
    private String fechaFinal;

    /**
     * Constructor de la clase
     * @param fechaInicial Inicio en el intervalo de tiempo
     * @param fechaFinal  Final en el intervalo de tiempo
     */
    public ReportePacienteFechas(String fechaInicial, String fechaFinal) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }
    
    public ArrayList<String[]> examenesDeUnTipo(Connection connection, String codigoPaciente, String codigoExamen){
        
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String query = "SELECT E.codigo,E.nombre,C.fecha,C.hora FROM CITA_LABORATORIO C INNER JOIN EXAMEN E ON C.codigo_examen = E.codigo WHERE C.fecha BETWEEN ? AND ? AND C.codigo_paciente = ? AND E.codigo = ? AND (C.fecha < DATE(NOW()) OR (C.fecha = DATE(NOw()) AND C.hora < NOW())) ORDER BY FECHA DESC";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, fechaInicial);
            preSt.setString(2, fechaFinal);
            preSt.setString(3, codigoPaciente);
            preSt.setString(4, codigoExamen);
            
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
            System.out.println("Error Reporte Examenes de un Tipo: " + e.getMessage());
            return null;
        }
                
    }
    
}
