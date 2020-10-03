/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;


/**
 *
 * @author froi-pc
 */
public abstract class LectorArchivo {
    
    private String path;
    private String tagName;
    
    public LectorArchivo(String path, String tagName){
        this.path = path;
        this.tagName = tagName;
    }
    
    public abstract void readme(String tagName);
    
    
}
