/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Leandro
 */
public class PoliticaGreedy implements Politica{ 
 //por cada estado que reciba tengo que devolver el estado con mejor accion   
private ArrayList<Estado> estadosAnteriores= new ArrayList<Estado>();

@Override
public Accion seleccionarAccionSiguiente(Estado estadoActual) {
 
        if (!estadoActual.getAccionesPosibles().isEmpty()){
        Accion accionMaxima= null;
        for (int i=0; i<estadoActual.getAccionesPosibles().size();i++){
        Accion accionI= estadoActual.getAccionesPosibles().get(i);
           
           if(accionMaxima==null){//si es null elijo un estado aleatorio la primera vez
               PoliticaAleatoria politicaAleatoria= new PoliticaAleatoria();
               do{
                accionMaxima= politicaAleatoria.seleccionarAccionSiguiente(estadoActual);    
               }while(existe(estadosAnteriores,accionMaxima.getEstadoDestino()));
               
           }else{
               if ( accionI.getValor()>accionMaxima.getValor() && !this.existe(estadosAnteriores, accionI.getEstadoDestino() ) ){//recorrer el array y que no hay ninguno
              
                      accionMaxima= accionI;
               }
           } 
         }
        System.out.println(accionMaxima);
        estadosAnteriores.add(accionMaxima.getEstadoDestino());
       
        return accionMaxima;
    }
 else{
      System.out.println("No tiene estados Accesibles");
      return null;
    }   
    
}

    @Override
    public boolean existe(ArrayList<Estado> estadosAnteriores, Estado estadoSiguiente) {
        boolean bandera=false;
        for (int i=0; i<estadosAnteriores.size();i++){
            if (estadosAnteriores.get(i).equals(estadoSiguiente)){
                bandera=true;
            }
        }
        return bandera;
    }
}

    


    
    

