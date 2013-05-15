/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Estado {
    public double valor;
    public double [] posicionA; 
    public double [] posicionR;

    public double getValor() {
        return valor;
    }

    public double[] getPosicionA() {
        return posicionA;
    }

    public double[] getPosicionR() {
        return posicionR;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPosicionA(double[] posicionA) {
        this.posicionA = posicionA;
    }

    public void setPosicionR(double[] posicionR) {
        this.posicionR = posicionR;
    }
    
}
