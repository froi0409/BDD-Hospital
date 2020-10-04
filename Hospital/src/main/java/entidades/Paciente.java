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
public class Paciente extends Entidad{
    
    public static final String NOMBRE_TABLA = "PACIENTE";
    public static final String CODIGO = "codigo";
    public static final String DPI = "DPI";
    public static final String NOMBRE = "nombre";
    public static final String SEXO = "sexo";
    public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final String TIPO_SANGRE = "tipo_sangre";
    public static final String TELEFONO = "telefono";
    public static final String PESO = "peso";
    public static final String CORREO = "correo";
    public static final String PASSWORD = "password";
    
    private String codigo;
    private String dpi;
    private String nombre;
    private String sexo;
    private String fechaNacimiento;
    private String tipoSangre;
    private String telefono;
    private double peso;
    private String correo;
    private String password;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        AnalizarContraseña encriptador = new AnalizarContraseña();
        this.password = encriptador.encriptar(password);
    }
    
}
