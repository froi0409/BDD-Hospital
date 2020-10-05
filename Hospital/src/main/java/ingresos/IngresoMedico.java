/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresos;

import entidades.Descripcion;
import entidades.Especialidad;
import entidades.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author froi-pc
 */
public class IngresoMedico extends Ingreso {
    
    private Medico medico;

    public IngresoMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean ingresoArchivo(Connection connection) {
        
        boolean comprobacion = true;
        
        //Terminando el ciclo agregamos al doctor
         String insert = "INSERT INTO " + Medico.NOMBRE_TABLA + " VALUES (?,?,?,?,?,?,?,?,?,?)";
         
         try (PreparedStatement preSt = connection.prepareStatement(insert)) {
            
             preSt.setString(1, medico.getCodigo());
             preSt.setString(2, medico.getPassword());
             preSt.setString(3, medico.getNombre());
             preSt.setString(4, medico.getColegiado());
             preSt.setString(5, medico.getDpi());
             preSt.setString(6, medico.getTelefono());
             preSt.setString(7, medico.getCorreo());
             preSt.setString(8, medico.getHorarioInicio());
             preSt.setString(9, medico.getHorarioFin());
             preSt.setString(10, medico.getFecha());
             
             preSt.executeUpdate();
             
        } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
             comprobacion = false;
        }
        
        //Con el siguiente ciclo añadimos las especialidades del médico
        for (Especialidad element : medico.getEspecialidades()){
            
            String insertD = "INSERT INTO " + Descripcion.NOMBRE_TABLA + " VALUES (?,?)";
            
            try (PreparedStatement preSt2 = connection.prepareStatement(insertD)) {
                
                preSt2.setString(1, medico.getCodigo());
                preSt2.setString(2, element.getNombre());
                
                preSt2.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
                comprobacion = false;
            }
            
        }
        
        return comprobacion;
        
    }

    @Override
    public boolean ingresoNormal(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
