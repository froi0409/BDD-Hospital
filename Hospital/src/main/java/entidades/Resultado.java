/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author froi-pc
 */
public class Resultado extends Entidad{
    
    public static final String NOMBRE_TABLA = "RESULTADO";
    public static final String CODIGO = "codigo";
    public static final String FECHA = "fecha";
    public static final String HORA = "hora";
    public static final String INFORME = "informe";
    public static final String ORDEN = "orden";
    public static final String CODIGO_MEDICO = "codigo_medico";
    public static final String CODIGO_LABORATORISTA = "codigo_laboratorista";
    public static final String CODIGO_PACIENTE = "codigo_paciente";
    public static final String CODIGO_EXAMEN = "codigo_examen";
    
    private String codigo;
    private String fecha;
    private String hora;
    private String informe;
    private String orden;
    private String codigoMedico;
    private String codigoLaboratorista;
    private String codigoPaciente;
    private String codigoExamen;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }
    
    public String getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(String codigoExamen) {
        this.codigoExamen = codigoExamen;
    }
    
}
