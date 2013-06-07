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
            while((i<cantEpisodios)&&(bandera==false)){
               double valorAnterior = qAnterior(matrizQ);
               episodios[i]= new Episodio(matrizQ,estadoFinal,politica,mat,i);
               VentanaPrincipal.jLabelContador.setText(Double.toString(i));
               System.out.print(diferencia(valorAnterior,matrizQ));
               i++;
               }
        
           System.out.println("episodios realizados "+i); 
           if (bandera==true){
               Configuraciones.cantEpisodios =i;
           }
           System.out.println(episodios[Configuraciones.cantEpisodios-1].getMatrizQ());

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
    private static boolean diferencia(double QAnterior, QMat q){
        double QActual=0;
        for (int i=0; i<Configuraciones.getDimension();i++){
            for (int j=0; j<Configuraciones.getDimension();j++){
                for (int k=0; k<q.getEstado(i, j).getAccionesPosibles().size();k++){
                        QActual=QActual+q.getEstado(i, j).getValorAccion(k);
                }
            }
        }
        System.out.print("QActual "+QActual+" ");
        System.out.print("QAnterior "+QAnterior+" ");
        double resta = QActual-QAnterior;
        resta= redondeo(resta,4);
        System.out.print("resta "+resta+" ");
        if (Math.abs(resta)<0.0001){
            return true;
        }
        else{
         return false;   
        }
        
    }
    
private static double redondeo(double decimal,int numeroDecimales){
    decimal = decimal*(java.lang.Math.pow(10, numeroDecimales));
    decimal = java.lang.Math.round(decimal);
    decimal = decimal/java.lang.Math.pow(10, numeroDecimales);

return decimal;
}
}
