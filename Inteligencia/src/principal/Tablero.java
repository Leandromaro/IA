/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Random;

/**
 *
 * @author Maty
 */
public class Tablero {
    
    private int dim;
    private Estado matriz[][];
    private final int CONSTANTE=5;
     
    private boolean eInicial=false;
    private boolean eFinal=false;

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public Estado[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Estado[][] matriz) {
        this.matriz = matriz;
    }

    public boolean iseInicial() {
        return eInicial;
    }

    public void seteInicial(boolean eInicial) {
        this.eInicial = eInicial;
    }

    public boolean iseFinal() {
        return eFinal;
    }

    public void seteFinal(boolean eFinal) {
        this.eFinal = eFinal;
    }
   
    public void Tablero(int dim){
        //this.dim=dim;
        //this.matriz= new Estado[dim][dim];
    }
    
    public void rellenarTableroAutomáticamente(){
       
        int filaI=0;
        int filaF=0;
        int columnaI=0;
        int columnaF=0;
        
        Random r= new Random();
        
        while(filaI==filaF & columnaI==columnaF){
           
            filaI = r.nextInt(dim);
            filaF = r.nextInt(dim);
        
            columnaI = r.nextInt(dim);
            columnaF = r.nextInt(dim);
        
        }
        
        for(int i=1; i<dim; i++){
            for(int j=1; j<dim; j++){
                
                if(filaI==i & columnaI==j) {
                    this.matriz[i][j].setInicio(true);
                    this.matriz[i][j].setValor(0);
                }else{
                    if(filaF==i & columnaF==j){
                        this.matriz[i][j].setFin(true);
                        this.matriz[i][j].setValor(1);
                    }
                    
                    //this.matriz[i][j]= new Estado();
                    this.matriz[i][j].setValor(r.nextInt(CONSTANTE)+2);
                }                              
            }
        }
    }
}
