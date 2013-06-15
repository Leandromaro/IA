/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Movimiento {

    public static Estado realizarMovimiento(Estado estadoActual, Politica politica, RMat matrizR){
        //seleccionamos accion con la politica pasada por parametro
        Accion accionARealizar= politica.seleccionarAccionSiguiente(estadoActual);
        //obtenemos la recompensa
        double recompensa;
        if ((Episodio.cont % 100) == 0){
        recompensa= matrizR.devolverR(accionARealizar.getEstadoDestino().getPosI(),accionARealizar.getEstadoDestino().getPosJ())*0.1;
        }else{
        recompensa= matrizR.devolverR(accionARealizar.getEstadoDestino().getPosI(),accionARealizar.getEstadoDestino().getPosJ());
        }
        //obtenemos maximo valor que se puede obtener desde el estado proximo
        double maximoValor= accionARealizar.getEstadoDestino().maximoValorParaAcciones();
        //actualizar el valor de la accion elejida
        accionARealizar.setValor(recompensa+ (Configuraciones.getGamma()*maximoValor)); 
        //devolver al estado al que va
        return accionARealizar.getEstadoDestino();
    }
}
