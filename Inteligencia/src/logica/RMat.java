/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class RMat {
    public double matR [][];

    public RMat(Tablero tablero) {
        MatAux aux;
        aux = new MatAux(tablero);
         
        
    }
 
    public void imprimirR(){
            for (int i=0; i < matR.length; i++) {
                //System.out.println(i);
                //System.out.println("");
                for (int j=0; j < matR[i].length; j++) {
                    System.out.print(matR[i][j]+"\t"); 
                }
                  System.out.println("");
            }
        }
    
}
