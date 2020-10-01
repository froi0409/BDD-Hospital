/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author froi-pc
 */
public class Conexion {
    
    private static Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/HOSPITAL?useSSL=false";
    private final String user = "usuarioHospital";
    private final String password = "admin123";
    
    /**
     * Método que nos sirve para crear la conexión de la base de datos
     */
    public void crearConexion(){
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("CONEXIÓN CREADA");
        } catch (SQLException e) {
            System.out.println("ERROR AL CREAR LA CONEXIÓN");
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Nos sirve para obtener la conexión de la base de datos
     * @return conexión de la base de datos
     */
    public static Connection getConnection(){
        return connection;
    }
    
}
