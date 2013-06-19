/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Accion implements Cloneable{
    private Estado estadoOrigen;
    private Estado estadoDestino;
    private double valor;
    private double prob;

   
    public Accion(Estado origen, Estado destino, double valor){
        this.estadoDestino= destino;
        this.estadoOrigen= origen;
        this.valor= valor;
    }
    
    
    @Override
    public String toString(){
        StringBuilder desc= new StringBuilder();
        desc.append(" A ");
        desc.append("ed:");
        desc.append(this.getEstadoDestino().toString());
        desc.append("v:");
        desc.append(this.getValor());
        return desc.toString();
    }

    public Estado getEstadoOrigen() {
        return estadoOrigen;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }
    
    
    public void setEstadoOrigen(Estado estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }

    public Estado getEstadoDestino() {
        return estadoDestino;
    }


    public void setEstadoDestino(Estado estadoDestino) {
        this.estadoDestino = estadoDestino;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


}
