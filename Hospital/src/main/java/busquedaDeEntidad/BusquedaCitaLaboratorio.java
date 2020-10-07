/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaDeEntidad;

import entidades.CitaLaboratorio;
import entidades.Laboratorista;
import entidades.Resultado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class BusquedaCitaLaboratorio {
    
    /**
     * Obtenemos los valores de una cita de laboratorio ejecutada, pero sin resultados 
     * @param connection Conexión de la base de datos
     * @return ArrayList de tipo String que contiene las citas del aboratorio que ya han sido realizadas, pero que aún no cuentan con un resultado
     */
    public ArrayList<String> citasPrevias(Connection connection, String codigoLaboratorista) {
        
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<String> listaNo = new ArrayList<String>();
        
        String query = "SELECT " + CitaLaboratorio.CODIGO +" FROM " + CitaLaboratorio.NOMBRE_TABLA + " WHERE (" + CitaLaboratorio.FECHA + " < DATE(NOW()) OR (" + CitaLaboratorio.FECHA + " = DATE(NOW()) AND "  + CitaLaboratorio.HORA + " < NOW())) AND " + CitaLaboratorio.CODIGO_EXAMEN + " = ?";
        String query2 = "SELECT " + Resultado.CODIGO_CITA_LABORATORIO + " FROM " + Resultado.NOMBRE_TABLA + " WHERE " + Resultado.CODIGO_CITA_LABORATORIO + " IS NOT NULL";
        String query3 = "SELECT " + Laboratorista.CODIGO_EXAMEN + " FROM " + Laboratorista.NOMBRE_TABLA + " WHERE " + Laboratorista.CODIGO + " = ?";
        
        
        try (PreparedStatement preSt = connection.prepareStatement(query);
                PreparedStatement preSt2 = connection.prepareStatement(query2);
                PreparedStatement preSt3 = connection.prepareStatement(query3)) {
            
            //Obtenemos el tipo de examen que realiza el laboratorista
            preSt3.setString(1, codigoLaboratorista);
            ResultSet result3 = preSt3.executeQuery();
            result3.next();
            String tipoExamen = result3.getString(1);
            
            
            //Obtenemos aquellas citas de laboratorio que ya tienen un reporte
            ResultSet result2 = preSt2.executeQuery();
            while(result2.next()) {
                listaNo.add(result2.getString(1));
            }
            
            
            //Obtenemos el codigo de las citas de laboratorio. Aquellas que tienen el mismo codigo de examen que el que realiza el laboratorista
            preSt.setString(1, tipoExamen);
            ResultSet result = preSt.executeQuery();
            
            while(result.next()) {
                String codigoCitaLaboratorio = result.getString(1);
                //Verificamos que la cita de laboratorio no tenga un reporte
                if (!listaNo.contains(codigoCitaLaboratorio)) {
                    lista.add(codigoCitaLaboratorio);
                }
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error Citas Previas: " + e.getMessage());
            return null;
        }
        
    }
    
}
