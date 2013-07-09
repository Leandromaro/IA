/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public class QMat {
    
    public Estado matQ[][];
    
    public QMat(RMat matR) {
       
        //obtener dimension 
       int dimension= matR.getDimension();
       //creamos la matriz de estados
       matQ= new Estado[dimension][dimension];
        
       //rellenemos la matriz con objetos Estado
       for (int i=0; i<dimension;i++){
             for (int j=0; j<dimension;j++){
                matQ[i][j]= new Estado(i,j);
             }   
        }
       
       //asignar a cada estado las acciones posibles
        for (int posI=0; posI<dimension;posI++){
            for (int posJ=0; posJ<dimension;posJ++){             
                //dependiendo de la posicion y de las paredes que existen en la matriz,
                //deberiamos cargar las acciones posibles en el ArrayList
                //ver cuales son las acciones posibles
                
                for(int offsetI=-1; offsetI<=1;offsetI++){
                    for(int offsetJ=-1; offsetJ<=1;offsetJ++){
                        //obetenemos i y j del estado
                        int i=posI;
                        int j= posJ;
                        //obtenemos i y j para un POSIBLE estado valido
                        i+=offsetI;
                        j+=offsetJ;
                        //verificar si los indices son validos
                        if(this.indicesValidos(i, j, matR.getDimension()) && !(i==posI && j==posJ)){
                            //verificar si no hay una pared en la posicion
                            if(matR.devolverR(i, j)!=Configuraciones.getValorPared()){
                                //si llegamos aca el estado es valido
                                //deberiamos cargarlo com destino de una accion posible
                                Estado estadoActual= this.getEstado(posI, posJ);
                                Accion nuevaAccion= new Accion(estadoActual, this.getEstado(i, j),Configuraciones.getValorPorDefectoMatQ());
                                estadoActual.getAccionesPosibles().add(nuevaAccion);
                            }
                        }
                    }    
                }
            }   
        }
    }

    public QMat(Estado [][] matQ) {
        this.matQ= matQ;
    }
    
    public Estado getEstado(int posI, int posJ){
        return this.matQ[posI][posJ];
    }
    
    private boolean indicesValidos(int i, int j, int dimension){
         //i y j son validos si estan dentro de la matriz
        if(i>=0 && j>=0 && i<dimension && j<dimension){
            return true;
        }
        return false;
    }
    
   public double getValorQ(){
       double sum=0;
       for (int i=0; i<this.matQ.length;i++){
             for (int j=0; j<this.matQ.length;j++){
                 for(int k=0; k<this.getEstado(i, j).accionesPosibles.size();k++){
                     sum+= matQ[i][j].getValorAccion(k);
                 }
                 
             }   
        }
       return sum;
    }

    @Override
    public String toString(){
        StringBuilder desc= new StringBuilder();
        
        //rellenemos la matriz con objetos Estado
        for (int i=0; i<this.matQ.length;i++){
             for (int j=0; j<this.matQ.length;j++){
               desc.append(this.getEstado(i, j).toString());
               
               ArrayList<Accion> acciones= this.getEstado(i, j).getAccionesPosibles();
               for(Accion accion: acciones){
                   desc.append(accion.toString());
               }
               desc.append(" \f ");
             }   
        }
        return desc.toString();
    }
  

}
