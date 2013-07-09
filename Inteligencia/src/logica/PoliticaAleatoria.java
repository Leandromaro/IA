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
    public Accion seleccionarAccionSiguiente(Estado estadoActual) {//genero un numero aleatorio y lo multiplico por el size de las acciones posibles 
        int indiceRandom= (int) Math.floor(Math.random() * estadoActual.getAccionesPosibles().size());//y lo redondeo hacia abajo para obtener una acciones aleatoria
        return estadoActual.getAccionesPosibles().get(indiceRandom );
    }
    
    
}
