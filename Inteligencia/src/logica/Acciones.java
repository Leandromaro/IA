/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Acciones {
    public double valor;
    public int estadoOrig [];
    public int estadoDestino [];

    public double getValor() {
        return valor;
    }

    public int[] getEstadoOrig() {
        return estadoOrig;
    }

    public int[] getEstadoDestino() {
        return estadoDestino;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setEstadoOrig() {
        this.estadoOrig = estadoOrig;
    }

    public void setEstadoDestino(int[] estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

}
