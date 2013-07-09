/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Leandro
 */
public class Estado implements Cloneable{
    
    public ArrayList<Accion> accionesPosibles;
    private double valor;
    private int posI;
    private int posJ;
    
    public Estado(int posI, int posJ){
        this.setPosI(posI);
        this.setPosJ(posJ);
        this.setAccionesPosibles(new ArrayList<Accion>());
    }
    
    @Override
    public String toString(){
               
        StringBuilder desc= new StringBuilder();
        desc.append(" E:(");
        desc.append(this.getPosI());
        desc.append(",");
        desc.append(this.getPosJ());
        desc.append(")");
        return desc.toString();
    }

    public ArrayList<Accion> getAccionesPosibles() {
         return accionesPosibles;
    }

    public void setPosJ(int posJ) {
        this.posJ = posJ;
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

    
    
    public double getValorAccion(int posI){
        return accionesPosibles.get(posI).getValor();
       
    }
    
    public double maximoValorParaAcciones(){
        double maximoValor=0;
        for(int i=0; i< this.getAccionesPosibles().size();i++){
            double valorAccion= this.getAccionesPosibles().get(i).getValor();
            if(valorAccion>maximoValor){
                maximoValor= valorAccion;
            }
        }
        return maximoValor;
    }
    
    
   public Accion accionDeMaximoValor(){
        for(Accion acc:this.accionesPosibles){
            if(acc.getValor()==this.maximoValorParaAcciones()){
                return acc;
            }
        }
        return null;
    }
       
    @Override
    public boolean equals(Object estado){
        if(estado.getClass()==this.getClass()){
            if(this.hashCode()==estado.hashCode()){
                return true;
            }
        }
        return false; 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.posI;
        hash = 73 * hash + this.posJ;
        return hash;
    }

 
}
