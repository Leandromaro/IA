/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public interface Politica {
    /**
     *
     * @param estadoActual
     * @return
     */
    public Accion seleccionarAccionSiguiente(Estado estadoActual);
    
}
