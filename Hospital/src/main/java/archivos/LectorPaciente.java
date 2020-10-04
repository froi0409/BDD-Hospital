/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analizadores.Conexion;
import entidades.Estructura;
import entidades.Paciente;
import ingresos.IngresoPaciente;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorPaciente extends LectorArchivo{

    private Paciente paciente;
    
    public LectorPaciente() {
        paciente = new Paciente();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for(Estructura element : atributos) {
            
            if (element.getTipo().equals("CODIGO")) {
                paciente.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("NOMBRE")) {
                paciente.setNombre(element.getDescripcion());
            } else if (element.getTipo().equals("SEXO")) {
                paciente.setSexo(element.getDescripcion());
            } else if (element.getTipo().equals("BIRTH")) {
                paciente.setFechaNacimiento(element.getDescripcion());
            } else if (element.getTipo().equals("DPI")) {
                paciente.setDpi(element.getDescripcion());
            } else if (element.getTipo().equals("TELEFONO")) {
                paciente.setTelefono(element.getDescripcion());
            } else if (element.getTipo().equals("PESO")) {
                paciente.setPeso(Double.parseDouble(element.getDescripcion()));
            } else if (element.getTipo().equals("SANGRE")) {
                paciente.setTipoSangre(element.getDescripcion());
            } else if (element.getTipo().equals("CORREO")) {
                paciente.setCorreo(element.getDescripcion());
            } else if (element.getTipo().equals("PASSWORD")) {
                paciente.setPassword(element.getDescripcion());
            }
            
        }
        
        IngresoPaciente ingresador = new IngresoPaciente(paciente);
        ingresador.ingresoArchivo(Conexion.getConnection());
        
    }
    
}
