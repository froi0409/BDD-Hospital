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
public class LectorCita extends LectorArchivo {

    public LectorCita(String path, String tagName) {
        super(path, tagName);
    }

    @Override
    public void readme() {
        Lector lector = new Lector();
        lector.leerTag(getPath(), getTagName());
    }
    
}
