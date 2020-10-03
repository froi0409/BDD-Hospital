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
public class Administrador extends Entidad{
    
    public static final String NOMBRE_TABLA = "ADMINISTRADOR";
    public static final String CODIGO = "codigo";
    public static final String INFORME = "informe";
    public static final String FECHA = "fecha";
    public static final String HORA = "hora";
    public static final String CODIGO_MEDICO = "codigo_medico";
    public static final String DPI_PACIENTE = "DPI_paciente";
    
    private String codigo;
    private String dpi;
    private String nombre;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        AnalizarContraseña encriptador = new AnalizarContraseña();
        this.password = encriptador.encriptar(password);
    }
    
}
