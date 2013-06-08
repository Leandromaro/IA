/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;

/**
 *
 * @author Maty
 */
public final class ColoresyFormas {

    private Boolean estadoFinal;
    private Border blackline;
    private Boolean flagFinal;
    
    
    static Font font = new Font("Arial", Font.BOLD, 9);
                
    final  Color rojo;
    final  Color amarillo;
    final  Color verde;

    public ColoresyFormas() {
        this.verde = new Color(72, 237, 255);
        this.rojo = new Color(240, 90, 82);
        this.amarillo = new Color(220, 246, 53);    
    }
    
 
    
}
