/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgressBar {

    static JFrame ventana;
    static JProgressBar barra;
    private static Episodio[] episodios;

    public static Episodio[] getEpisodios() {
        return episodios;
    }
    public ProgressBar() {

        ventana=new JFrame("Progreso");
        
        barra=new JProgressBar(0,100);
        
        new Escucha();        
        ventana.setLayout(new FlowLayout());
        ventana.add(barra);
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args){
        new ProgressBar();
    }
    public static class Escucha implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new Thread(new Hilo()).start();
            
        }
    }
    public static class Hilo implements Runnable{
      public void run() {

        int i=0;
        
           while((i<100)){

                barra.setValue(i);
                barra.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                i++;
           }
       
        }
}
}
    


