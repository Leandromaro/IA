/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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
        recompensa= matrizR.devolverR(accionARealizar.getEstadoDestino().getPosI(),accionARealizar.getEstadoDestino().getPosJ());
        //obtenemos maximo valor que se puede obtener desde el estado proximo
        double maximoValor= accionARealizar.getEstadoDestino().maximoValorParaAcciones();
        //actualizar el valor de la accion elejida
//        if ((Episodio.cont % 100) == 0){
//            accionARealizar.setValor(recompensa+ (Configuraciones.getGamma()*maximoValor)*0.5); 
//        }
//       
//        else{
        accionARealizar.setValor(recompensa+ (Configuraciones.getGamma()*maximoValor));
//        }
        //devolver al estado al que va
        return accionARealizar.getEstadoDestino();
    }
}
