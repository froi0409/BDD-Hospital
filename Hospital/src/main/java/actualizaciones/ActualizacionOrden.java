/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actualizaciones;

import entidades.Orden;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class ActualizacionOrden {
    
    /**
     * Invalida una orden, esto se hace porque la orden solamente tiene un uso
     * @param connection Conexión de la base de datos
     * @param codigoPaciente Código del paciente
     * @param codigoExamen Código del examen
     */
    public void actualizarEstadoOrden(Connection connection, String codigoPaciente, String codigoExamen) {
        
        String update = "UPDATE " + Orden.NOMBRE_TABLA + " SET " + Orden.VALIDEZ + " = 0 WHERE " + Orden.CODIGO_PACIENTE + " = ? AND " + Orden.CODIGO_EXAMEN + " = ?";  
        
        try (PreparedStatement preSt = connection.prepareStatement(update)) {
            
            preSt.setString(1, codigoPaciente);
            preSt.setString(2, codigoExamen);
            
            preSt.executeUpdate();
            
            System.out.println("Se realizó el cambio del estado de la orden con éxito");
            
        } catch (Exception e) {
            System.out.println("Error Actualizar Estado Orden" + e.getMessage());
        }
        
    }
    
}
