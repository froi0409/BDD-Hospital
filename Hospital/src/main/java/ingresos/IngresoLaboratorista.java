/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.DiasTrabajo;
import entidades.Laboratorista;
import java.sql.Connection;

/**
 *
 * @author froi-pc
 */
public class IngresoLaboratorista extends Ingreso {
    
    private Laboratorista laboratorista;
    private DiasTrabajo dias;

    public IngresoLaboratorista(Laboratorista laboratorista, DiasTrabajo dias) {
        this.laboratorista = laboratorista;
        this.dias = dias;
    }
    
    @Override
    public void ingresoArchivo(Connection connection) {
        
        String query = "SELECT codigo FROM";
        
    }

    
}
