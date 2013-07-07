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
public class PoliticaEGreedy implements Politica {


@Override
public Accion seleccionarAccionSiguiente(Estado estadoActual) {
        Accion accionSiguiente= null;
        
        if(Math.random()<Configuraciones.getEpsilon()){
            PoliticaAleatoria politicaAleatoria= new PoliticaAleatoria();
            accionSiguiente= politicaAleatoria.seleccionarAccionSiguiente(estadoActual);    
        }else{
            
            accionSiguiente= estadoActual.accionDeMaximoValor();
          
        }
        //System.out.println(accionSiguiente);
  
        return accionSiguiente;
    }
  




  
    
}

