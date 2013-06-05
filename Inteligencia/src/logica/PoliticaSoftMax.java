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
    double sumatoriaE=0;
    double[] Ei=new double[estadoActual.accionesPosibles.size()];
    double tau= Configuraciones.getTau();
    
    for (int i=0; i<estadoActual.getAccionesPosibles().size();i++){
        double accionI=redondeo (estadoActual.getValorAccion(i),4);
        Ei[i]=redondeo(Math.exp(accionI/tau),4);
        sumatoriaE=sumatoriaE+Ei[i];
    }
    
    for (int j=0; j<estadoActual.getAccionesPosibles().size();j++){
        Ei[j]= Ei[j]/sumatoriaE;
//        System.out.print(Ei[j]);
//        Ei[j]= this.redondearAccion(Ei[j]/sumatoriaE);
    }
        
    double prob = Math.random();
    double limiteInferior=0;    
    double limiteSuperior;    
    int pos=0;
    
    for (int k=0; k<Ei.length;k++){ //recorro el arreglo con las probabilidades 
    limiteSuperior=limiteInferior+Ei[k];//y veo en que rango cae el numero alearorio
        if ((prob>=limiteInferior)&&(prob<=limiteSuperior)){//Mirar porque nunca entra en este if
            pos =k;
        }
        limiteInferior=limiteSuperior;
    }
    
    return estadoActual.getAccionesPosibles().get(pos);
    
    }
    
    private double redondeo(double decimal,int numeroDecimales){
    decimal = decimal*(java.lang.Math.pow(10, numeroDecimales));
    decimal = java.lang.Math.round(decimal);
    decimal = decimal/java.lang.Math.pow(10, numeroDecimales);

return decimal;
}
    public double redondearAccion(double valorAccion) {
       double d=valorAccion; 
       BigDecimal bd = new BigDecimal(Double.toString(d));
       bd = bd.setScale(4, BigDecimal.ROUND_HALF_UP);
       return bd.doubleValue();
   }             
        
    
}
