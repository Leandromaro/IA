/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    public static boolean bloqueo=false;
    
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
        int contBloqueo=0;
       
        while(!estadoActual.equals(this.estadoFinal)&&(bloqueo!=true)){
            Estado estadoProximo = Movimiento.realizarMovimiento(estadoActual, this.getPolitica(), this.getMatrizR());
            estadoActual= estadoProximo;
            contBloqueo++;
//            if(contBloqueo== 5000){
//                bloqueo=true;
//                contBloqueo=0;
//            }
        }
//        if(bloqueo==true){
//         JFrame ventana=new JFrame();
//         JOptionPane.showMessageDialog(ventana,"Agente Bloqueado o con poco entrenamiento","Error",JOptionPane.WARNING_MESSAGE);
//        }
//        else{
//            bloqueo=false;
//        }
        
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
