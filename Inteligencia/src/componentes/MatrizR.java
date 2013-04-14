/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;


/**
 *
 * @author Leandro
 */
public class MatrizR {
      public MatrizR(){ //constructor
               
      }
      
      public void crearR (int x){
          int r [][]= new int [x][x];
          
          for (int i=0; i<=x;i++)
              for (int j=0; j<=x;j++)
              {
                  r[i][j]=i;
              }
      
      }
}
