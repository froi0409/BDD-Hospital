/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author froi-pc
 */
public class Lector {
    
    public void leerTag(String path, String tagName){
        try {
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(new File(path));
            NodeList listaTag = documento.getElementsByTagName(tagName);
            
            for(int i = 0; i < listaTag.getLength(); i++){
                
                Node nodo = listaTag.item(i);
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    
                    Element e = (Element) nodo;
                    
                    NodeList hijos = e.getChildNodes();
                    
                    for(int j = 0; j < hijos.getLength(); j++){
                        
                        Node hijo = hijos.item(j);
                        
                        if(hijo.getNodeType() == Node.ELEMENT_NODE){
                            
                            System.out.println("Propiedad: " + hijo.getNodeName() + "     Valor: " + hijo.getTextContent());
                            
                        }
                        
                    }
                    
                    System.out.println("");
                    
                }
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(LectorArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}