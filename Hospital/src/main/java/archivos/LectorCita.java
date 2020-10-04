/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analizadores.Conexion;
import entidades.CitaMedica;
import entidades.Estructura;
import ingresos.IngresoCitaMedica;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorCita extends LectorArchivo {

    private CitaMedica cita;
    
    public LectorCita() {
        cita = new CitaMedica();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for(Estructura element: atributos){
            
            if (element.getTipo().equals("CODIGO")){
                this.cita.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("PACIENTE")) {
                this.cita.setCodigoPaciente(element.getDescripcion());
            } else if (element.getTipo().equals("MEDICO")) {
                this.cita.setCodigoMedico(element.getDescripcion());
            } else if (element.getTipo().equals("FECHA")) {
                this.cita.setFecha(element.getDescripcion());
            } else if (element.getTipo().equals("HORA")) {
                this.cita.setHora(element.getDescripcion());
            }
            
        }
        
        IngresoCitaMedica ingresador = new IngresoCitaMedica(cita);
        ingresador.ingresoArchivo(Conexion.getConnection());
        
    }
    
}
