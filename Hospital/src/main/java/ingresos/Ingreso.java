/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Entidad;
import java.sql.Connection;

/**
 *
 * @author froi-pc
 */
public abstract class Ingreso {
    
    public abstract void ingresoArchivo(Connection connection);
    
}
