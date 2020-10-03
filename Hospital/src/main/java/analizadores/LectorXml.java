/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadores;

import archivos.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author froi-pc
 */
public class LectorXml {
    
    public void read(String path){
        try {
            
            LectorAdministrador administrador = new LectorAdministrador(path, "admin");
            administrador.readme();
            
            LectorMedico doctor = new LectorMedico(path, "doctor");
            doctor.readme();
            
            LectorLaboratorista laboratorista = new LectorLaboratorista(path, "laboratorista");
            laboratorista.readme();
            
            LectorPaciente paciente = new LectorPaciente(path, "paciente");
            paciente.readme();
            
            LectorExamen examen = new LectorExamen(path, "examen");
            examen.readme();
            
            LectorInforme informe = new LectorInforme(path, "reporte");
            informe.readme();
            
            LectorResultado resultado = new LectorResultado(path, "resultado");
            resultado.readme();
            
            LectorCita cita = new LectorCita(path, "cita");
            cita.readme();
            
            LectorConsulta consulta = new LectorConsulta(path, "consulta");
            consulta.readme();
            
        } catch (Exception ex) {
            Logger.getLogger(LectorXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
