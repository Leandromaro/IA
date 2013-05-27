/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

import javax.swing.JButton;

/**
 *
 * @author Maty
 */


/* 
 *  1 --> regular (color Blanco)
 *  2 --> Pared (color Negro)
 * 
 *  3 --> Malo (con texto)
 *  4 --> Bueno (con texto)
 *  5 --> Excelente (con texto)
 * 
 * 
 */
public class EstadoVisual {
    
    private double valor;
    private JButton jbEstado;
    private int posI;
    private int posJ;
    private int posAbs;
    
    public void EstadoVisual(){
        
        valor = 0;
        jbEstado = new JButton();
        posI = 0;
        posJ = 0;
        posAbs = 0;
        
    }
    
    public JButton pintarEstado(int tipoEstado, int posI, int posJ, int PosAbs){
        
        
        return this.jbEstado;
    } 
}
