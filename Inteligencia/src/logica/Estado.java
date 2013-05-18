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
    public int [] posicionA; 
    public int [] posicionR;

       
    public double getValor() {
        return valor;
    }

    public Estado(double valor, int[] posicionA, int[] posicionR) {
        this.valor = valor;
        this.posicionA = posicionA;
        this.posicionR = posicionR;
    }

    public int[] getPosicionA() {
        return posicionA;
    }

    public int[] getPosicionR() {
        return posicionR;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPosicionA(int fila, int columna) {
        posicionA[0] = fila;
        posicionA[1] = columna;
    }

    public void setPosicionR(int fila, int columna) {
        this.posicionR[0] = fila;
        this.posicionR[1] = columna;
    }

    
}
