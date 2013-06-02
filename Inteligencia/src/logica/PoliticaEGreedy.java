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
private double epsilon=0.1;


@Override
public Accion seleccionarAccionSiguiente(Estado estadoActual) {

    if (!estadoActual.getAccionesPosibles().isEmpty()){
        Accion accionSiguiente= null;
        PoliticaAleatoria politicaAleatoria= new PoliticaAleatoria();
        
        if(Math.random()<this.getEpsilon()){
            accionSiguiente= politicaAleatoria.seleccionarAccionSiguiente(estadoActual);    
        }else{
            
            accionSiguiente= estadoActual.accionDeMaximoValor();
            
//            if (!this.existe(estadosAnteriores, estadoActual.accionDeMaximoValor().getEstadoDestino() ) ){//recorrer el array y que no hay ninguno
//               accionSiguiente= estadoActual.accionDeMaximoValor();
//            }else{
//               accionSiguiente= politicaAleatoria.seleccionarAccionSiguiente(estadoActual);
//            }
            
        }
        //System.out.println(accionSiguiente);
        estadosAnteriores.add(accionSiguiente.getEstadoDestino());
        return accionSiguiente;
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

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }
    
}
