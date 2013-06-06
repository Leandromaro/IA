/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entornoVisual.VentanaPrincipal;

/**
 *
 * @author Leandro
 */
public class Entrenador {

    private static Episodio[] episodios;

    public static Episodio[] getEpisodios() {
        return episodios;
    }
    
    public static void entrenar(int cantEpisodios, QMat matrizQ , Estado estadoFinal , Politica politica, RMat mat){
         episodios= new Episodio[Configuraciones.getCantEpisodios()];
         int i=0;   
         boolean bandera=false;
         while(i<=cantEpisodios){
            episodios[i]= new Episodio(matrizQ,estadoFinal,politica,mat,i);
            
            VentanaPrincipal.jLabelContador1.setText(Double.toString(i));
            double valorAnterior = qAnterior(matrizQ);
            System.out.println(valorAnterior);
            bandera= diferenciaQ(valorAnterior,matrizQ);
            i++;
            }
         if (bandera==true){
         Configuraciones.cantEpisodios=i;    
         cantEpisodios=i;
         }

         System.out.println(episodios[cantEpisodios-1].getMatrizQ());

    }
   
    
    private static double qAnterior(QMat q){
        double QAnterior=0;
        for (int i=0; i<Configuraciones.getDimension();i++){
            for (int j=0; j<Configuraciones.getDimension();j++){
                for (int k=0; k<q.getEstado(i, j).getAccionesPosibles().size();k++){
                        QAnterior=QAnterior+q.getEstado(i, j).getValorAccion(k);
                }
            }
        }
        return QAnterior;
    }
    private static boolean diferenciaQ(double qAnterior,QMat q){
        double qSiguiente=0;
        double diferencia;
        for (int i=0; i<Configuraciones.getDimension();i++){
            for (int j=0; j<Configuraciones.getDimension();j++){
                for (int k=0; k<q.getEstado(i, j).getAccionesPosibles().size();k++){
                        qSiguiente=qSiguiente+q.getEstado(i, j).getValorAccion(k);
                }
            }
            }
        diferencia=Math.abs(qAnterior-qSiguiente);
        VentanaPrincipal.jLabelDiferencia.setText(Double.toString(diferencia));
        if (diferencia<10.0){
            return true;
        }
        else{
          return false;  
        }
    }
}
