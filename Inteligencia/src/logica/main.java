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
  Configuraciones.setDimension(3);
  mat= new RMat(Configuraciones.getDimension());
  Configuraciones.setValorExcelente(100);
  Configuraciones.setValorBueno(50);
  Configuraciones.setValorMalo(5);
  Configuraciones.setValorPared(-15);
  mat.rellenar();
  mat.setInicial(1,1);
  mat.setFinal(2, 2);
  mat.imprimirTab(); 
  
  QMat matrizQ= new QMat(mat);
  System.out.println(matrizQ);
  
  PoliticaAleatoria politica= new PoliticaAleatoria();
  QMat nuevaQ= CalculadorQ.calcularSiguienteQ(matrizQ.getEstado(0, 0),politica , matrizQ, mat);
  
  System.out.println(nuevaQ);
  
  }
}
