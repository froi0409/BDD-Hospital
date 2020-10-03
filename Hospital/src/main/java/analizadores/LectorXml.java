/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadores;

import archivos.*;
import entidades.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author froi-pc
 */
public class LectorXml {
    
    public void read(String path){
        try {
            
            Lector lector = new Lector();
            
            Administrador administrador = new Administrador();
            LectorAdministrador lecAdministrador = new LectorAdministrador();
            lector.leerTag(path, "admin", lecAdministrador, administrador);
            
            Medico medico = new Medico();
            LectorMedico lecMedico = new LectorMedico();
            lector.leerTag(path, "doctor", lecMedico, medico);
            
            Laboratorista laboratorista = new Laboratorista();
            LectorLaboratorista lecLaboratorista = new LectorLaboratorista();
            lector.leerTag(path, "laboratorista", lecLaboratorista, laboratorista);
            
            Paciente paciente = new Paciente();
            LectorPaciente lecPaciente = new LectorPaciente();
            lector.leerTag(path, "paciente", lecPaciente, paciente);
            
            
            LectorExamen examen = new LectorExamen();
            
            LectorInforme informe = new LectorInforme();
            
            LectorResultado resultado = new LectorResultado();
            
            LectorCita cita = new LectorCita();
            
            LectorConsulta consulta = new LectorConsulta();
            
        } catch (Exception ex) {
            Logger.getLogger(LectorXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
