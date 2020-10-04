/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import analizadores.AnalizarContraseña;

/**
 *
 * @author froi-pc
 */
public class Laboratorista extends Entidad{
    
    public static final String NOMBRE_TABLA = "LABORATORISTA";
    public static final String CODIGO = "codigo";
    public static final String NOMBRE = "nombre";
    public static final String REGISTRO = "registro";
    public static final String DPI = "DPI";
    public static final String TELEFONO = "telefono";
    public static final String CORREO = "correo";
    public static final String FECHA_INICIO = "fecha_inicio";
    public static final String PASSWORD = "password";
    public static final String CODIGO_EXAMEN = "codigo_examen";
    public static final String CODIGO_DIAS_TRABAJO = "dias_trabajo_codigo";
    
    private String codigo;
    private String nombre;
    private String registro;
    private String dpi;
    private String telefono;
    private String correo;
    private String fechaInicio;
    private String password;
    private String codigoExamen;
    private String diasTrabajoCodigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        AnalizarContraseña encriptador = new AnalizarContraseña();
        this.password = encriptador.encriptar(password);
    }

    public String getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(String codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public String getDiasTrabajoCodigo() {
        return diasTrabajoCodigo;
    }

    public void setDiasTrabajoCodigo(String diasTrabajoCodigo) {
        this.diasTrabajoCodigo = diasTrabajoCodigo;
    }
    
}
