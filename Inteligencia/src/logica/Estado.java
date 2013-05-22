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
    
    public ArrayList<Accion> accionesPosibles;
    public int posI;
    public int posJ;
    
    public Estado(int posI, int posJ){
        this.setPosI(posI);
        this.setPosJ(posJ);
        this.setAccionesPosibles(new ArrayList<Accion>());
    }
    
    @Override
    public String toString(){
        StringBuilder desc= new StringBuilder();
        desc.append(" E:");
        desc.append(this.getPosI());
        desc.append(",");
        desc.append(this.getPosJ());
        return desc.toString();
    }

     public ArrayList<Accion> getAccionesPosibles() {
        return accionesPosibles;
    }

    public int getPosI() {
        return posI;
    }

    public int getPosJ() {
        return posJ;
    }

    public void setAccionesPosibles(ArrayList<Accion> accionesPosibles) {
        this.accionesPosibles = accionesPosibles;
    }

    public void setPosI(int posI) {
        this.posI = posI;
    }

    public void setPosJ(int posJ) {
        this.posJ = posJ;
    }


    
}
