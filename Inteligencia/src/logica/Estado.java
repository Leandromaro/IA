/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public class Estado {
    ArrayList accionesPosibles [];
    int posI;
    int posJ;

    public ArrayList[] getAccionesPosibles() {
        return accionesPosibles;
    }

    public int getPosI() {
        return posI;
    }

    public int getPosJ() {
        return posJ;
    }

    public void setAccionesPosibles(ArrayList[] accionesPosibles) {
        this.accionesPosibles = accionesPosibles;
    }

    public void setPosI(int posI) {
        this.posI = posI;
    }

    public void setPosJ(int posJ) {
        this.posJ = posJ;
    }
    
}
