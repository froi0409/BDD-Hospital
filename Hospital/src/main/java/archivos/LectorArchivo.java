/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.Entidad;
import entidades.Estructura;
import java.util.ArrayList;


/**
 *
 * @author froi-pc
 */
public abstract class LectorArchivo {
    
    private String path;
    private String tagName;
    private ArrayList<Estructura> atributos;
    
    public LectorArchivo(String path, String tagName){
        this.path = path;
        this.tagName = tagName;
        atributos = new ArrayList<Estructura>();
    }
    
    public abstract void readme();
    
    public abstract void convertToObject(Entidad entidad, ArrayList atributos);
    
    public String getPath(){
        return path;
    }
    
    public String getTagName(){
        return tagName;
    }

    public ArrayList<Estructura> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Estructura> atributos) {
        this.atributos = atributos;
    }
    
}
