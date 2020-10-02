/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadores;

/**
 *
 * @author froi-pc
 */
public class Etiqueta {
    
    private String linea;
    private String tipo;
    private String atributo;
    private String descripcion;
    private boolean validez;
    
    public Etiqueta(String linea){
        this.linea = linea;
        validez = false;
        setValues();
    }
    
    private void setValues(){
        
        int start = 0;
        int end = 0;
        int contDatos = 0;
        
        for(int i = 0; i < linea.length(); i++){
            
            if(linea.charAt(i) == '<' && contDatos == 0){
                start = 0;
            } else if(linea.charAt(i) == '>' && contDatos == 0){
                end = 0;
            }
            if(start !=0 && end !=0){
                atributo = linea.substring(start+1,end-1);
                contDatos++;
                start = end + 1;
            }
            
            if(contDatos == 1){
                if(linea.charAt(i) == '<' && linea.charAt(i+1) == '/'){
                    if(linea.substring(i+2,linea.length()-1).equals(atributo)){
                        descripcion = linea.substring(start,i-1);
                        validez = true;
                        contDatos++;
                        break;
                    }
                }
            }
            
        }
        
        System.out.println("Tipo: " + tipo + "   Descripcion: " + descripcion);
        
    }
    
    public String getTipo(){
        return tipo;
    }
    
}
