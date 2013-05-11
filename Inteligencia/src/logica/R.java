/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class R {
    public double matR [][][];
    int filaI; 
    int columnaI;
    int filaF; 
    int columnaF;
    public R(double[][][] matR) {
        this.matR = matR;
    }

    public R(int x){
    this.matR = new double [x][x][8];
    Estados aleatorio;
    aleatorio = new Estados();
    for (int i = 0; i < matR.length; i++) {
            for (int j = 0; j < matR[i].length; j++) {
                for (int k = 0; k < 8; k++) {
                    matR[i][j][k] = aleatorio.estadoA();
                }
            }
        }
    }

    public double[][][] getMatR() {
        return matR;
    }

    public void setMatR(double[][][] matR) {
        this.matR = matR;
    }
    
    public double[][][] cero() {
       
        for (int i = 0; i < matR.length; i++) {
            for (int j = 0; j < matR[i].length; j++) {
                for (int k = 0; k < 8; k++) {
                    matR[i][j][k] = 0;
                }
            }
        }
    return matR;
    }
    public void imprimirR(){
            for (int i=0; i < matR.length; i++) {
                //System.out.println(i);
                //System.out.println("");
                for (int j=0; j < matR[i].length; j++) {
                    for (int k=0;k<8; k++){
                    System.out.print(matR[i][j][k]+"\t");
                    } 
                    }
                  System.out.println("");
            }
        }

}
