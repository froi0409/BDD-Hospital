/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analizadores.Conexion;
import entidades.Estructura;
import entidades.Informe;
import ingresos.IngresoInforme;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorInforme extends LectorArchivo{

    private Informe informe;
    
    public LectorInforme() {
        informe = new Informe();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for (Estructura element : atributos){
            
            if(element.getTipo().equals("CODIGO")) {
                informe.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("PACIENTE")) {
                informe.setCodigoPaciente(element.getDescripcion());
            } else if (element.getTipo().equals("MEDICO")) {
                informe.setCodigoMedico(element.getDescripcion());
            } else if (element.getTipo().equals("INFORME")) {
                informe.setInforme(element.getDescripcion());
            } else if (element.getTipo().equals("FECHA")) {
                informe.setFecha(element.getDescripcion());
            } else if (element.getTipo().equals("HORA")) {
                informe.setHora(element.getDescripcion());
            }
            
        }
        
        IngresoInforme ingresador = new IngresoInforme(informe);
        ingresador.ingresoArchivo(Conexion.getConnection());
        
    }
    
}
