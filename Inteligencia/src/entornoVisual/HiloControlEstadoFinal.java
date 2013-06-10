/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

/**
 *
 * @author Maty
 * 
 * Hilo para controlar que en la creación o generación de un escenario, ya sea 
 * automático o manual, siempre haya uno y solo un estado fnal
 */
public class HiloControlEstadoFinal extends Thread {
   
    int m;
    public void run(){
        
        try{
            m = (int) (Math.random()*5*1000);
            Thread.sleep(m);
	}catch(Exception e){}
            System.out.println("Termino en : tiempo: "+m);
        
        if(VentanaPrincipal.estadoFinal){
            VentanaPrincipal.vistaConfigPoliticas(true);
        }else{
            VentanaPrincipal.vistaConfigPoliticas(false);
        }   
    }
    
    public void HiloControlEstadoFinal(){
        
    }

}
