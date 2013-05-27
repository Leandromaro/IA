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
 //por cada estado que reciba tengo que devolver el estado con mejor accion   

@Override
public Accion seleccionarAccionSiguiente(Estado estadoActual) {
 double maximoValor=0;
 if (!estadoActual.getAccionesPosibles().isEmpty()){
        Accion accionMaxima;
        accionMaxima = new Accion(estadoActual.getAccionesPosibles().get(0).getEstadoOrigen(),estadoActual.getAccionesPosibles().get(0).getEstadoDestino(),estadoActual.getAccionesPosibles().get(0).getValor());
        for (int i=0; i<estadoActual.getAccionesPosibles().size();i++){
        double valorAccion= estadoActual.getAccionesPosibles().get(i).getValor();
           if (valorAccion>maximoValor){
            maximoValor=valorAccion;
            accionMaxima = new Accion(estadoActual.getAccionesPosibles().get(0).getEstadoOrigen(),estadoActual.getAccionesPosibles().get(0).getEstadoDestino(),estadoActual.getAccionesPosibles().get(0).getValor());
            }
     }
        return accionMaxima;
    }
 else{
      System.out.println("No tiene estados Accesibles");
      return null;
    }   
    
}
}

    


    
    

