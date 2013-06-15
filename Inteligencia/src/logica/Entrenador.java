/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Entrenador {

    private static Episodio[] episodios;
    private static int numEpisodios;
    private static QMat MQ;
    private static Estado EFinal;
    private static Politica P;
    private static RMat R;
    
    public static Episodio[] getEpisodios() {
        return episodios;
    }
    
    public static void entrenar(int cantEpisodios, QMat matrizQ , Estado estadoFinal , Politica politica, RMat mat){
        
        numEpisodios=cantEpisodios;
        MQ=matrizQ;
        EFinal=estadoFinal;
        P=politica;
        R=mat;
        episodios= new Episodio[Configuraciones.getCantEpisodios()];
        
        int i=0;
//        new Thread(new ProgressBar.Hilo()).start();
            while((i<numEpisodios)){
               episodios[i]= new Episodio(MQ,EFinal,P,R,i);
//               barra.setValue(i);
//               barra.repaint();
//               try {
//                Thread.sleep(50);
//                } catch (InterruptedException ex) {
//                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
//                }
               i++;
               }
        
        System.out.println(episodios[Configuraciones.cantEpisodios-1].getMatrizQ()); 
//      
            
        }
    
   
    
//    private static double qAnterior(QMat q){
//        double QAnterior=0;
//        for (int i=0; i<Configuraciones.getDimension();i++){
//            for (int j=0; j<Configuraciones.getDimension();j++){
//                for (int k=0; k<q.getEstado(i, j).getAccionesPosibles().size();k++){
//                        QAnterior=QAnterior+q.getEstado(i, j).getValorAccion(k);
//                }
//            }
//        }
//        return QAnterior;
//    }
//    private static boolean diferencia(double QAnterior, QMat q){
//        double QActual=0;
//        for (int i=0; i<Configuraciones.getDimension();i++){
//            for (int j=0; j<Configuraciones.getDimension();j++){
//                for (int k=0; k<q.getEstado(i, j).getAccionesPosibles().size();k++){
//                        QActual=QActual+q.getEstado(i, j).getValorAccion(k);
//                }
//            }
//        }
//        System.out.print("QActual "+QActual+" ");
//        System.out.print("QAnterior "+QAnterior+" ");
//        double resta = QActual-QAnterior;
//        resta= redondeo(resta,4);
//        System.out.print("resta "+resta+" ");
//        if (Math.abs(resta)<0.0001){
//            return true;
//        }
//        else{
//         return false;   
//        }
//        
//    }
//    
//private static double redondeo(double decimal,int numeroDecimales){
//    decimal = decimal*(java.lang.Math.pow(10, numeroDecimales));
//    decimal = java.lang.Math.round(decimal);
//    decimal = decimal/java.lang.Math.pow(10, numeroDecimales);
//
//return decimal;
//}
// public static class Hilo implements Runnable{
//
//        
//        @Override
//        public void run() {
//        episodios= new Episodio[Configuraciones.getCantEpisodios()];
//        int i=0;
//        
//            while((i<numEpisodios)){
//               
//               episodios[i]= new Episodio(MQ,EFinal,P,R,i);
////               barra.setValue(i);
////               barra.repaint();
////               try {
////                Thread.sleep(50);
////                } catch (InterruptedException ex) {
////                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
////                }
//               i++;
//               }
//        
//           System.out.println(episodios[Configuraciones.cantEpisodios-1].getMatrizQ());
// 
//        
//        
//        }
//    }
}
