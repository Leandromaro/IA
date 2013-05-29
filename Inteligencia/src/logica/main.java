/* c
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class main {
 
  public static void main (String[] args){
  RMat mat;
  Configuraciones.setDimension(8);
  mat= new RMat(Configuraciones.getDimension());
  Configuraciones.setValorExcelente(100);
  Configuraciones.setValorBueno(50);
  Configuraciones.setValorMalo(5);
  Configuraciones.setValorPared(15);
  mat.rellenar();
  Configuraciones.setInicial(0,0);
  Configuraciones.setFinal(7, 7);
  
  mat.setInicial(Configuraciones.filaI, Configuraciones.colI);
  mat.setFinal(Configuraciones.filaF, Configuraciones.colF);
  mat.imprimirTab(); 
  
  QMat matrizQ= new QMat(mat);
  System.out.println(matrizQ);
  
  //PoliticaEGreedy politica= new PoliticaEGreedy();
  //politica.setEpsilon(0.9);
  //PoliticaAleatoria politica= new PoliticaAleatoria();
  PoliticaGreedy politica= new PoliticaGreedy();
  //TODO: agregar estadoi final a configuraciones

  Estado estadoFinal= matrizQ.getEstado(Configuraciones.getFilaF(),Configuraciones.getColF());
  System.out.println("Estado final");
  System.out.println(estadoFinal);
  
  System.out.println("Entrenando");
    int cantEpisodios= 1000000;
  Episodio[] episodios= new Episodio[cantEpisodios];


  
  for(int i=0; i<cantEpisodios;i++){
      episodios[i]= new Episodio(matrizQ,estadoFinal,politica,mat,i);
      //System.out.println(episodios[i].getMatrizQ());
  }
  
  System.out.println(episodios[cantEpisodios-1].getMatrizQ());
  
  System.out.println("Buscando mejor camino");
  System.out.println("Estado Inicial");
//  int i= 0;
//  int j=0;
  
  Estado estadoActual= episodios[cantEpisodios-1].getMatrizQ().getEstado(Configuraciones.getFilaI(),Configuraciones.getColI());
  System.out.println(estadoActual);
  
  System.out.println("Movimientos:");
  //mientras estado actual distinto de estado final
  
  System.out.println("Avanzando");
  while(! estadoActual.equals(estadoFinal)){
        Estado estadoProximo = estadoActual.accionDeMaximoValor().getEstadoDestino();
        System.out.println(estadoProximo);
        estadoActual= estadoProximo;
  }
  
  }
}
