/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class PoliticaGreedy implements Politica{ 
    
    @Override
    public Accion seleccionarAccionSiguiente(Estado estadoActual){
      double maximoValor=0;
        for(int i=0; i< estadoActual.getAccionesPosibles().size();i++){
            double valorAccion= estadoActual.getAccionesPosibles().get(i).getValor();
            if(valorAccion>maximoValor){
                maximoValor= valorAccion;
            }
        }
    
    for(Accion acc:estadoActual.accionesPosibles){
            if(acc.getValor()==maximoValor){
                return acc;
            }
        }
        return null;
    }
}
    


    
    

