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
private ArrayList<Estado> estadosAnteriores= new ArrayList<>();

@Override
public Accion seleccionarAccionSiguiente(Estado estadoActual) {
        Accion accionSiguiente= null;
        PoliticaAleatoria politicaAleatoria= new PoliticaAleatoria();
        if(Math.random()<Configuraciones.getEpsilon()){
            accionSiguiente= politicaAleatoria.seleccionarAccionSiguiente(estadoActual);    
        }else{
            
            accionSiguiente= estadoActual.accionDeMaximoValor();
          
        }
        //System.out.println(accionSiguiente);
        estadosAnteriores.add(accionSiguiente.getEstadoDestino());
        return accionSiguiente;
    }
  




  
    
}

