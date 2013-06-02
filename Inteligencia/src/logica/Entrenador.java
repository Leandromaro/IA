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

    private static Episodio[] episodios;

    public static Episodio[] getEpisodios() {
        return episodios;
    }
    
    public static void entrenar(int cantEpisodios, QMat matrizQ , Estado estadoFinal , Politica politica, RMat mat){
         episodios= new Episodio[Configuraciones.getCantEpisodios()];
            for(int i=0; i<cantEpisodios;i++){
            episodios[i]= new Episodio(matrizQ,estadoFinal,politica,mat,i);
            //System.out.println(episodios[i].getMatrizQ());
            }
            System.out.println(episodios[cantEpisodios-1].getMatrizQ());
    }
}
