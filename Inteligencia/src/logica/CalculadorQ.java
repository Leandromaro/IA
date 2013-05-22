/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Fer
 */
public class CalculadorQ {
    
    public static QMat calcularSiguienteQ(Estado estadoActual, Politica politica, QMat matrizQActual, RMat matrizR){
        QMat nuevaQ= matrizQActual; //deberia clonar la matriz para devolver una nueva
        
        Accion accionARealizar= politica.seleccionarAccionSiguiente(estadoActual);
         double recompensa= matrizR.devolverR(estadoActual.getPosI(),estadoActual.getPosJ());
         double maximoValor= accionARealizar.getEstadoDestino().maximoValorParaAcciones();
        accionARealizar.getEstadoDestino().setValor(recompensa+ (Configuraciones.getGamma()*maximoValor) );
 
        return nuevaQ;
        
    }
}
