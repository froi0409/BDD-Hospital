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
            
            Especialidad especialidad = new Especialidad();
            LectorConsulta lecEspecialidad = new LectorConsulta();
            lector.leerTag(path, "consulta", lecEspecialidad, especialidad);
            
            Medico medico = new Medico();
            LectorMedico lecMedico = new LectorMedico();
            lector.leerTag(path, "doctor", lecMedico, medico);
            
            Laboratorista laboratorista = new Laboratorista();
            LectorLaboratorista lecLaboratorista = new LectorLaboratorista();
            lector.leerTag(path, "laboratorista", lecLaboratorista, laboratorista);
            
            Paciente paciente = new Paciente();
            LectorPaciente lecPaciente = new LectorPaciente();
            lector.leerTag(path, "paciente", lecPaciente, paciente);
            
            Examen examen = new Examen();
            LectorExamen lecExamen = new LectorExamen();
            lector.leerTag(path, "examen", lecExamen, examen);
            
            Informe informe = new Informe();
            LectorInforme lecInforme = new LectorInforme();
            lector.leerTag(path, "reporte", lecInforme, informe);
            
            Resultado resultado = new Resultado();
            LectorResultado lecResultado = new LectorResultado();
            lector.leerTag(path, "resultado", lecResultado, resultado);
            
            CitaMedica cita = new CitaMedica();
            LectorCita lecCita = new LectorCita();
            lector.leerTag(path, "cita", lecCita, cita);
            
        } catch (Exception ex) {
            Logger.getLogger(LectorXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
