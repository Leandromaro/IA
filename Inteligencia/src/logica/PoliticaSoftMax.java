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
    
    for (int i=0; i<estadoActual.getAccionesPosibles().size();i++){
        Ei[i]=Math.exp(estadoActual.getValorAccion(i)/Configuraciones.getTau());
        sumatoriaE=sumatoriaE+Ei[i];
    }
    
    for (int j=0; j<estadoActual.getAccionesPosibles().size();j++){
        Ei[j]= Ei[j]/sumatoriaE;
//        Ei[j]= this.redondearAccion(Ei[j]/sumatoriaE);
    }
        
    double prob = Math.random();
    double limiteInferior=0;    
    double limiteSuperior;    
    int pos=0;
    
    for (int k=0; k<estadoActual.getAccionesPosibles().size();k++){
        limiteSuperior=limiteInferior+Ei[k];
        if ((prob>limiteInferior)&&(prob<=limiteSuperior)){//Mirar porque nunca entra en este if
            pos =k;
        }
        limiteInferior=limiteSuperior;
    }
    
    return estadoActual.getAccionesPosibles().get(pos);
    
    }
    
//    public double redondearAccion(double valorAccion) {
//       double d=valorAccion; 
//       BigDecimal bd = new BigDecimal(Double.toString(d));
//       bd = bd.setScale(4, BigDecimal.ROUND_HALF_UP);
//       return bd.doubleValue();
//   }             
        
    
}
