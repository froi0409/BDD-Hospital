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
public class LectorInforme extends LectorArchivo{

    public LectorInforme(String path, String tagName) {
        super(path, tagName);
    }

    @Override
    public void readme() {
        Lector lector = new Lector();
        lector.leerTag(getPath(), getTagName());
        setAtributos(lector.getAtributos());
    }

    @Override
    public void convertToObject(Entidad entd, ArrayList al) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
