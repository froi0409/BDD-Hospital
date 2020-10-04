/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analizadores.Conexion;
import entidades.Estructura;
import entidades.Resultado;
import ingresos.IngresoResultado;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorResultado extends LectorArchivo{

    private Resultado resultado;
    
    public LectorResultado() {
        resultado = new Resultado();
    }

    @Override
    public void convertToEntidad(ArrayList<Estructura> atributos) {
        
        for (Estructura element : atributos) {
            
            if (element.getTipo().equals("CODIGO")) {
                resultado.setCodigo(element.getDescripcion());
            } else if (element.getTipo().equals("PACIENTE")) {
                resultado.setCodigoPaciente(element.getDescripcion());
            } else if (element.getTipo().equals("MEDICO")) {
                resultado.setCodigoMedico(element.getDescripcion());
            } else if (element.getTipo().equals("EXAMEN")) {
                resultado.setCodigoExamen(element.getDescripcion());
            } else if (element.getTipo().equals("LABORATORISTA")) {
                resultado.setCodigoLaboratorista(element.getDescripcion());
            } else if (element.getTipo().equals("ORDEN")) {
                resultado.setOrden(element.getDescripcion());
            } else if (element.getTipo().equals("INFORME")) {
                resultado.setInforme(element.getDescripcion());
            } else if (element.getTipo().equals("FECHA")) {
                resultado.setFecha(element.getDescripcion());
            } else if (element.getTipo().equals("HORA")) {
                resultado.setHora(element.getDescripcion());
            }
            
        }
        
        IngresoResultado ingresador = new IngresoResultado(resultado);
        ingresador.ingresoArchivo(Conexion.getConnection());
        
    }
    
}
