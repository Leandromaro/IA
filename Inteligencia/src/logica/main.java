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
  Configuraciones.setDimension(4);
  mat= new RMat(Configuraciones.getDimension());
  Configuraciones.setValorExcelente(100);
  Configuraciones.setValorBueno(50);
  Configuraciones.setValorMalo(5);
  Configuraciones.setValorPared(15);
  mat.rellenar();
  
  Configuraciones.setInicial(0,0);
  Configuraciones.setFinal(3, 3);
  
  mat.setInicial(Configuraciones.filaI, Configuraciones.colI);
  mat.setFinal(Configuraciones.filaF, Configuraciones.colF);
  mat.imprimirTab(); 
  
  QMat matrizQ= new QMat(mat);
  System.out.println(matrizQ);
  
  PoliticaEGreedy politica= new PoliticaEGreedy();
  politica.setEpsilon(0.2);
  //PoliticaAleatoria politica= new PoliticaAleatoria();
  //PoliticaGreedy politica= new PoliticaGreedy();
  //TODO: agregar estadoi final a configuraciones

  Estado estadoFinal= matrizQ.getEstado(Configuraciones.getFilaF(),Configuraciones.getColF());
  System.out.println("Estado final");
  System.out.println(estadoFinal);
  
  Entrenador.entrenar(Configuraciones.cantEpisodios, matrizQ, estadoFinal, politica, mat);
  Estado estadoActual= Entrenador.getEpisodios()[Configuraciones.cantEpisodios-1].getMatrizQ().getEstado(Configuraciones.getFilaI(),Configuraciones.getColI());
  System.out.println(estadoActual);
  
  System.out.println("Movimientos:");
  //mientras estado actual distinto de estado final
 
  while(! estadoActual.equals(estadoFinal)){
        Estado estadoProximo = estadoActual.accionDeMaximoValor().getEstadoDestino();
        System.out.println(estadoProximo);
        estadoActual= estadoProximo;
  }
  
  }
}
