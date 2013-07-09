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
        Accion accionSiguiente= null;//creo una nueva accionSiguiente
        
        if(Math.random()<Configuraciones.getEpsilon()){//Genero n° aleatorios y verifico que sea menor que epsilon
            PoliticaAleatoria politicaAleatoria= new PoliticaAleatoria();//Exploro
            accionSiguiente= politicaAleatoria.seleccionarAccionSiguiente(estadoActual);//Exploro    
        }else{
            accionSiguiente= estadoActual.accionDeMaximoValor();//Exploto
          
        }
        return accionSiguiente;//devuelvo la accionSiguiente
    }
  




  
    
}

