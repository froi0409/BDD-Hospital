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
    
}
