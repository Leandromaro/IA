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
public int ei [];
public int ef [];
public int dimension;    
public Tablero() {
    }

    public int getDimension() {
        return dimension;
    }

    public void setEi(int fila, int columna) {
        this.ei[0] = fila;
        this.ei[1] = columna;
    }

    public void setEf(int fila, int columna) {
        this.ef[0] = fila;
        this.ef[1] = columna;
    }

    public int[] getEi() {
    return ei;
    }

    public int[] getEf() {
        return ef;
    }

public Tablero(int x) {
    mat=new double [x][x];
    dimension=x; 
}
    
public double[][] getMat() {
    
    return mat;
    }
public double getPos (int fila, int columna){
    double valor;
    valor = mat[fila][columna];
    return valor;
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
mat = this.iniciar();   
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
    
    mat = this.rellenar();
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
