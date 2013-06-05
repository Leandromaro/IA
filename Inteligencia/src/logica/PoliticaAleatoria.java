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
public class PoliticaAleatoria implements Politica{

    @Override
    public Accion seleccionarAccionSiguiente(Estado estadoActual) {
        int indiceRandom= (int) Math.floor(Math.random() * estadoActual.getAccionesPosibles().size());
        //checkear que acciones siguientes sea mayor a cero
        return estadoActual.getAccionesPosibles().get(indiceRandom );
    }

//    @Override
//     public boolean existe(ArrayList<Estado> estadosAnteriores, Estado estadoSiguiente) {
//        boolean bandera=false;
//        for (int i=0; i<estadosAnteriores.size();i++){
//            if (estadosAnteriores.get(i).equals(estadoSiguiente)){
//                bandera=true;
//            }
//        }
//        return bandera;
//    }
    
}
