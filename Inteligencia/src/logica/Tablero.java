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
public double mat[][];
    
public Tablero() {
    }

public Tablero(int x) {
    mat=new double [x][x];
     
}
    
public double[][] getMat() {
        
    return mat;
    }

public void setMat(double[][] mat) {
        this.mat = mat;
}

public double [][] iniciar() {
       
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = -1;
                
            }
        }
return mat;
}
    
public double [][] rellenar() {
       
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                double porcentaje;
                porcentaje= Math.random();
                if (porcentaje >0.2){
                Aleatorio a;
                a= new Aleatorio();
                mat[i][j] = a.getAleatorio();
                }
            }
        }
return mat;
}    
    
    
        
    
public void imprimirTab(){
            for (int i=0; i < mat.length; i++) {
                //System.out.println(i);
                //System.out.println("");
                for (int j=0; j < mat[i].length; j++) {
                    System.out.print(mat[i][j]+"\t");
                    
                    }
                  System.out.println("");
            }
        }
    
    
}
