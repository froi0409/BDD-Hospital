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
public class Orden {
    
    public static final String NOMBRE_TABLA = "ORDEN";
    public static final String CODIGO = "codigo";
    public static final String CODIGO_EXAMEN = "codigo_examen";
    public static final String DESCRIPCION = "descrićion";
    public static final String FECHA_CREACION = "fecha_creacion";
    public static final String PATH = "archivo";
    public static final String CODIGO_PACIENTE = "codigo_paciente";
    
    private String codigo;
    private String codigoExamen;
    private String descripcion;
    private String fechaCreacion;
    private String path;
    private String codigoPaciente;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(String codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }
    
}
