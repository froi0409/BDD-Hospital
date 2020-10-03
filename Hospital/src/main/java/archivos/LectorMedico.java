/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.Entidad;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class LectorMedico extends LectorArchivo{

    public LectorMedico(String path, String tagName) {
        super(path, tagName);
    }

    @Override
    public void readme() {
        Lector lector = new Lector();
        lector.leerTag(getPath(), getTagName());
    }

    @Override
    public void convertToObject(Entidad entd, ArrayList al) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
