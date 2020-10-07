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
public class CitaLaboratorio extends Entidad{
    
    public static final String NOMBRE_TABLA = "CITA_LABORATORIO";
    public static final String CODIGO = "codigo";
    public static final String FECHA = "fecha";
    public static final String HORA = "hora";
    public static final String COSTO = "costo";
    public static final String CODIGO_MEDICO = "codigo_medico";
    public static final String CODIGO_PACIENTE = "codigo_paciente";
    public static final String CODIGO_EXAMEN = "codigo_examen";
    public static final String CODIGO_ORDEN = "codigo_orden";
    
    private String codigo;
    private String fecha;
    private String hora;
    private double costo;
    private String codigoMedico;
    private String codigoPaciente;
    private String codigoExamen;
    private String codigoOrden;

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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
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

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }
    
}
