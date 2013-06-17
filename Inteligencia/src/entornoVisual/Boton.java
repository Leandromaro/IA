/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

import java.awt.Color;
import javax.swing.border.Border;

/**
 *
 * @author Maty
 */
public class Boton implements Cloneable{
    private Color color;
    private String texto;
    private Border borde;
    
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return this.texto;
    }
    
    public void setBorde(Border borde){
        this.borde = borde;
    }
    public Border getBorde(){
        return this.borde;
    }
    
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
    
}
