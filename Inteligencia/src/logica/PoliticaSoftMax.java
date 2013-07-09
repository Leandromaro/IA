/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public class PoliticaSoftMax implements Politica {
    
   
    @Override
    public Accion seleccionarAccionSiguiente(Estado estadoActual) {
    double sumatoriaE=0;//Acumulador para el denominador
    double[] Ei=new double[estadoActual.accionesPosibles.size()];//arreglo con los valores de las probabilidades
    double tau= Configuraciones.getTau();//obtengo el valor de Tau
    
    for (int i=0; i<estadoActual.getAccionesPosibles().size();i++){//Recorro todo el arreglo y calculo 
        double accionI=redondeo (estadoActual.getValorAccion(i),4);//Math.exp(accionI/tau) para cada accion posible, se redondea  
        Ei[i]=redondeo(Math.exp(accionI/tau),4);                   // a 4 decimale y se almacenan en Ei 
        sumatoriaE=sumatoriaE+Ei[i];//acumulo los valores para el denominador
    }
    
    for (int j=0; j<estadoActual.getAccionesPosibles().size();j++){
        Ei[j]= redondeo(Ei[j]/sumatoriaE,4);//divido a cada valor por el acumulado
    }
        
    //Aplico Ruleta
    double prob = Math.random();
    double limiteInferior=0;    
    double limiteSuperior;    
    int pos=0;
    
    for (int k=0; k<Ei.length;k++){ //recorro el arreglo con las probabilidades 
    limiteSuperior=limiteInferior+Ei[k];//y veo en que rango cae el numero alearorio
        if ((prob>=limiteInferior)&&(prob<=limiteSuperior)){//almaceno la posicion donde
            pos =k;                                         //cayo el numero aleatorio
        }
        limiteInferior=limiteSuperior;
    }
    //Termina Ruleta
    return estadoActual.getAccionesPosibles().get(pos);//devuelvo el estado seleccionado
    
    }
    
private double redondeo(double decimal,int numeroDecimales){//metodo para rendodear a 4 decimales
    decimal = decimal*(java.lang.Math.pow(10, numeroDecimales));
    decimal = java.lang.Math.round(decimal);
    decimal = decimal/java.lang.Math.pow(10, numeroDecimales);

return decimal;
}
     
}
