/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Tablero {

    public Tablero() {
    }
    public double mat[][];
    
    public Tablero(int x) {
        double mat [][];
        mat = new double [x][x];
    }
    public double[][]iniciar() {
       
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = -1;
                
            }
        }
    return mat;
    }

    public double[][] getMat() {
        return mat;
    }

    public void setMat(double[][] mat) {
        this.mat = mat;
    }
    
}
