/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Episodio {
    private QMat matrizQ;
    private int numeroEpisodio;
    private Estado estadoFinal;
    private Politica politica;
    private RMat matrizR;
    public double valorQ;
    
    public Episodio(QMat matrizQActual, Estado estadoFinal, Politica politica, RMat matR, int numeroEpisodio){
        //TODO:clonar matriz Q
        this.valorQ= matrizQActual.getValorQ();
        this.matrizQ= new QMat(matrizQActual.matQ.clone());
        this.matrizQ= matrizQActual;
        this.estadoFinal= estadoFinal;
        this.matrizR= matR;
        this.politica= politica;
        this.numeroEpisodio= numeroEpisodio;
        this.realizarMovimientos();
    }

    private void realizarMovimientos() {
        //elejir estado inical aleatoriamente
        int dimension= this.getMatrizR().getDimension();
        int iRandom= (int) Math.floor(Math.random() * dimension);
        int jRandom= (int) Math.floor(Math.random() * dimension);
        
        Estado estadoActual= this.getMatrizQ().getEstado(iRandom, jRandom);
        //mientras estado actual distinto de estado final
        while(! estadoActual.equals(this.estadoFinal)){
            Estado estadoProximo = Movimiento.realizarMovimiento(estadoActual, this.getPolitica(), this.getMatrizR());
            estadoActual= estadoProximo;
        }
    }
    /**
     * @return the matrizQ
     */
    public QMat getMatrizQ() {
        return matrizQ;
    }

    /**
     * @return the numeroEpisodio
     */
    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    /**
     * @return the estadoFinal
     */
    public Estado getEstadoFinal() {
        return estadoFinal;
    }

    /**
     * @return the politica
     */
    public Politica getPolitica() {
        return politica;
    }

    /**
     * @return the matrizR
     */
    public RMat getMatrizR() {
        return matrizR;
    }
}
