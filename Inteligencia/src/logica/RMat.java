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
    public double matR [][][];
    int filaI; 
    int columnaI;
    int filaF; 
    int columnaF;
    public RMat(double[][][] matR) {
        this.matR = matR;
    }

    public RMat(int x){
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

    public void setFilaI(int filaI) {
        this.filaI = filaI;
    }

    public void setColumnaI(int columnaI) {
        this.columnaI = columnaI;
    }

    public void setFilaF(int filaF) {
        this.filaF = filaF;
    }

    public void setColumnaF(int columnaF) {
        this.columnaF = columnaF;
    }
    
//    public int estadoI(){
//        
//        
//    }


      
           
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
    public void estadosProhibidos (){
        int a;
        a=matR.length;
        matR[0][0][6]=-1.0;
        matR[0][a][2]=-1.0;
        matR[a][0][6]=-1.0;
        matR[a][a][2]=-1.0;//mirar porque no corresponde los movimientos del cuaderno con los de el fondo
        for (int i=0; i< matR.length;i++){
            for(int j=0;j<matR[i].length;j++){
                for(int k=0; k<8;k++){
                   
                   
                }
            }
        }
    }
    public void imprimirR(){
            for (int i=0; i < matR.length; i++) {
                //System.out.println(i);
                //System.out.println("");
                for (int j=0; j < matR[i].length; j++) {
                                     
                   for (int k=0;k<8; k++){
//                  System.out.println("Matriz R posicion " + i + j + " accion "+k);
                    System.out.print(matR[i][j][k]+"\t"); 
                   }
                      
                }
                  System.out.println("");
            }
        }
    
}
