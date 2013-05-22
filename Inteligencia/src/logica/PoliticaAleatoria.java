/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
/**
 *
 * @author Fer
 */
public class PoliticaAleatoria implements Politica{

    @Override
    public Accion seleccionarAccionSiguiente(Estado estadoActual) {
        int indiceRandom= (int) Math.floor(Math.random() * estadoActual.getAccionesPosibles().size());
        return estadoActual.getAccionesPosibles().get(indiceRandom );
    }
    
}
