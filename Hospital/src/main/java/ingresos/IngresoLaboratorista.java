/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.DiasTrabajo;
import entidades.Examen;
import entidades.Laboratorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public boolean ingresoArchivo(Connection connection) {
        
        String query = "SELECT codigo FROM " + DiasTrabajo.NOMBRE_TABLA + " WHERE " + DiasTrabajo.LUNES + " = ? AND " + DiasTrabajo.MARTES + " = ? AND " + DiasTrabajo.MIERCOLES + " = ? AND " + DiasTrabajo.JUEVES + " = ? AND " + DiasTrabajo.VIERNES + " = ? AND " + DiasTrabajo.SABADO + " = ? AND " + DiasTrabajo.DOMINGO + " = ? ORDER BY codigo DESC";
        String insertL = "INSERT INTO " + Laboratorista.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        String insertD = "INSERT INTO " + DiasTrabajo.NOMBRE_TABLA + "(" + DiasTrabajo.LUNES + "," + DiasTrabajo.MARTES + "," + DiasTrabajo.MIERCOLES + "," + DiasTrabajo.JUEVES + "," + DiasTrabajo.VIERNES + "," + DiasTrabajo.SABADO + "," + DiasTrabajo.DOMINGO + ") VALUES (?,?,?,?,?,?,?)";
        String nombreExamen = "SELECT codigo FROM " + Examen.NOMBRE_TABLA + " WHERE nombre = ?";        
        
        String codigoDias;
        
        
        try (PreparedStatement preSt = connection.prepareStatement(query);
                PreparedStatement preSt2 = connection.prepareStatement(insertD);
                PreparedStatement preSt3 = connection.prepareStatement(insertL);
                PreparedStatement preSt4 = connection.prepareStatement(nombreExamen)) {
            
            preSt2.setBoolean(1, dias.isLunes());
            preSt2.setBoolean(2, dias.isMartes());
            preSt2.setBoolean(3, dias.isMiercoles());
            preSt2.setBoolean(4, dias.isJueves());
            preSt2.setBoolean(5, dias.isViernes());
            preSt2.setBoolean(6, dias.isSabado());
            preSt2.setBoolean(7, dias.isDomingo());
            
            preSt2.executeUpdate();
            
            preSt.setBoolean(1, dias.isLunes());
            preSt.setBoolean(2, dias.isMartes());
            preSt.setBoolean(3, dias.isMiercoles());
            preSt.setBoolean(4, dias.isJueves());
            preSt.setBoolean(5, dias.isViernes());
            preSt.setBoolean(6, dias.isSabado());
            preSt.setBoolean(7, dias.isDomingo());
            
            ResultSet result3 = preSt.executeQuery();
            result3.next();
            codigoDias = result3.getString(1);
            
            
            //Obtenemos el codigo del examen
            preSt4.setString(1, laboratorista.getCodigoExamen());
            ResultSet result4 = preSt4.executeQuery();
            result4.next();
            
            
            preSt3.setString(1, laboratorista.getCodigo());
            preSt3.setString(2, laboratorista.getNombre());
            preSt3.setString(3, laboratorista.getRegistro());
            preSt3.setString(4, laboratorista.getDpi());
            preSt3.setString(5, laboratorista.getTelefono());
            preSt3.setString(6, laboratorista.getCorreo());
            preSt3.setString(7, laboratorista.getFechaInicio());
            preSt3.setString(8, laboratorista.getPassword());
            preSt3.setString(9, result4.getString(1));
            preSt3.setString(10, codigoDias);
            
            preSt3.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean ingresoNormal(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
