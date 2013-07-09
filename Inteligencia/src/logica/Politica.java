/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public interface Politica {//Interface para las politicas
     public Accion seleccionarAccionSiguiente(Estado e);//Metodo Abstracto
}
