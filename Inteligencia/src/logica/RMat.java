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
public double mat[][];
public int filaI;
public int filaF;

    public int getFilaF() {
        return filaF;
    }

    public int getColF() {
        return colF;
    }
public int colI;
public int colF;
private int dimension;



public RMat() {
}

public RMat(int x) {
    mat=new double [x][x];
    dimension=x; 
}

public void setInicial(int fila, int col){
    mat[fila][col]=0;
    filaI=fila;
    colI=col;
    
}

public void setFinal(int fila, int col){
    mat[fila][col]=1000;
    filaF=fila;
    colF=col;
    
}

public double [][] iniciar() {
       for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = Configuraciones.getValorPared();
                
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
                if (porcentaje >0.1){
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
                for (int j=0; j < mat[i].length; j++) {
                    System.out.print(mat[i][j]+"\t");
                    
                    }
                  System.out.println("");
            }
        }
    
 public double devolverR(int fila, int col){
     return mat[fila][col];
}

    public int getDimension() {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

}
