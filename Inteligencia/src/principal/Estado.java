/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Maty
 */
public class Estado {
    
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }
    private boolean inicio=false;
    private boolean fin=false;
    
    public void Estado(){
        this.valor=0;
    }
}
