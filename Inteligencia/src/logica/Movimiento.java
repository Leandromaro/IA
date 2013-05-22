/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Fer
 */
public class Movimiento {
    
    public static Estado realizarMovimiento(Estado estadoActual, Politica politica, RMat matrizR){
        //seleccionamos accion con la politica pasada por parametro
        Accion accionARealizar= politica.seleccionarAccionSiguiente(estadoActual);
        //obtenemos la recompensa
        double recompensa= matrizR.devolverR(accionARealizar.getEstadoDestino().getPosI(),accionARealizar.getEstadoDestino().getPosJ());
        //obtenemos maximo valor que se puede obtener desde el estado proximo
        double maximoValor= accionARealizar.getEstadoDestino().maximoValorParaAcciones();
        //actualizar el valor de la accion elejida
        accionARealizar.setValor(recompensa+ (Configuraciones.getGamma()*maximoValor)); 
        //devolver al estado al que va
        return accionARealizar.getEstadoDestino();
    }
}
