/*
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
  MatrizR mat;
  Estados e;
  e=new Estados();
  mat = new MatrizR(6);
  mat.generarR();
  mat.imprimirR();
//  String bueno = e.getBueno(mat.getRecompensa(6, 6, 6));
  return;
  }
}
