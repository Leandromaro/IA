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
    public static boolean bloqueo=false;
    public static int contBloqueo=0;
    public static int tope;
    public static int cont=0;
    public static int contDeIngreso=0;
    
    
    public Episodio(QMat matrizQActual, Estado estadoFinal, Politica politica, RMat matR, int numeroEpisodio){
        //Creo un nuevo episodios
        this.valorQ= matrizQActual.getValorQ();
        this.matrizQ = new QMat(matrizQActual.matQ.clone());
        this.matrizQ = matrizQActual;
        this.estadoFinal= estadoFinal;
        this.matrizR= matR;
        this.politica= politica;
        this.numeroEpisodio= numeroEpisodio;
        //
        this.realizarMovimientos();//realiza un movimiento
        //
    }

    private void realizarMovimientos() {
        //elejir estado inical aleatoriamente
        int dimension= this.getMatrizR().getDimension();
        int iRandom= (int) Math.floor(Math.random() * dimension);
        int jRandom= (int) Math.floor(Math.random() * dimension);

        //obtengo el estado actual
        Estado estadoActual= this.getMatrizQ().getEstado(iRandom, jRandom);
        //mientras estado actual distinto de estado final
        
        //genero un tope de iteraciones para controlar los bucles
        int x = Configuraciones.getDimension();
        int y = 5;
        tope = (int) Math.pow(x, y);
        contDeIngreso++;//Controlo si ingresa mas de una vez y pongo a cero el contador para que pueda realizar movimientos
        if(contDeIngreso==2){
            cont=0;
            contDeIngreso=0;
        }
        
        while(!estadoActual.equals(this.estadoFinal)&&(cont<tope)){//mientras el estado actual sea <> al estado final y el cont sea menor que el tope, realizo movimientos
              Estado estadoProximo = Movimiento.realizarMovimiento(estadoActual, this.getPolitica(), this.getMatrizR());// 
              estadoActual= estadoProximo; 
              cont++;
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

    public static void setBloqueo(boolean bloqueo) {
        Episodio.bloqueo = bloqueo;
    }

    public static boolean isBloqueo() {
        return bloqueo;
    }

    public static void setContBloqueo(int contBloqueo) {
        Episodio.contBloqueo = contBloqueo;
    }

    public static int getContBloqueo() {
        return contBloqueo;
    }
    
}
