/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Entrenador {

    public Entrenador() {
    }
   
    public Episodio[] entrenar(int cantEpisodios, QMat matrizQ , Estado estadoFinal , Politica politica, RMat mat){
        Episodio[] episodios= new Episodio[Configuraciones.getCantEpisodios()];
            for(int i=0; i<cantEpisodios;i++){
            episodios[i]= new Episodio(matrizQ,estadoFinal,politica,mat,i);
            //System.out.println(episodios[i].getMatrizQ());
            }
            System.out.println(episodios[cantEpisodios-1].getMatrizQ());
            return episodios;
    
    }
}
