/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import analizadores.AnalizarContraseña;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class Medico extends Entidad{
    
    public static final String NOMBRE_TABLA = "MEDICO";
    public static final String CODIGO = "codigo";
    public static final String PASSWORD = "password";
    public static final String NOMBRE = "nombre";
    public static final String COLEGIADO = "colegiado";
    public static final String DPI = "DPI";
    public static final String TELEFONO = "telefono";
    public static final String CORREO = "correo";
    public static final String HORARIO_INICIO = "horario_inicio";
    public static final String HORARIO_FIN = "horario_fin";
    public static final String FECHA_INICIO = "fecha_inicio";
    
    private String codigo;
    private String password;
    private String nombre;
    private String colegiado;
    private String dpi;
    private String telefono;
    private String correo;
    private String horarioInicio;
    private String horarioFin;
    private String fecha;
    private ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        AnalizarContraseña encriptador = new AnalizarContraseña();
        this.password = encriptador.encriptar(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegiado() {
        return colegiado;
    }

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
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

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

}
