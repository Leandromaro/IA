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
public int ei [];
public int ef [];
public int dimension;

public RMat() {
    }

public RMat(int x) {
    mat=new double [x][x];// cambiar por el getter de Configuraciones
    dimension=x; 
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
    
 public double devolverR(int fila, int col){//mirar porque no devuelve el valor
    int f=0;
    int c=0;
    boolean find;
    find = false;
    
     while((fila < mat.length)&&(f< mat.length)&&(find = false)){
        while((col < mat.length)&&(col< mat.length)&&(find = false)){
                if ((fila ==f) && (col==c)){
                    find= true;
                    System.out.println(mat[fila][col]);
                    return(mat[fila][col]);
                }
          c=c++;
         }
     f=f++;   
     }
    return 0;
     
}
 
 
}
