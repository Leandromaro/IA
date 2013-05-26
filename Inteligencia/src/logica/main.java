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
  
  PoliticaAleatoria politica= new PoliticaAleatoria();
  
  //TODO: agregar estadoi final a configuraciones

  Estado estadoFinal= matrizQ.getEstado(Configuraciones.getFilaF(),Configuraciones.getColF());
  System.out.println("Estado final");
  System.out.println(estadoFinal);
  Episodio[] episodios= new Episodio[1000];
  
  for(int i=0; i<1000;i++){
      episodios[i]= new Episodio(matrizQ,estadoFinal,politica,mat,i);
  }
  
  System.out.println(episodios[999].getMatrizQ());
  
  System.out.println("Buscando mejor camino");
  System.out.println("Estado Inicial");
//  int i= 0;
//  int j=0;
  
  Estado estadoActual= episodios[999].getMatrizQ().getEstado(Configuraciones.getFilaI(),Configuraciones.getColI());
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
