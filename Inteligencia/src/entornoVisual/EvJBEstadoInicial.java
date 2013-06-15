/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;
import logica.Configuraciones;

/**
 *
 * @author Maty
 */
public class EvJBEstadoInicial {
    private ColoresyFormas cf = new ColoresyFormas();
    
    private JButton jbEstado; 
    
    public JButton getjbEstado(){
        return this.jbEstado;
    }
    
    public void setjbEstado(MouseWheelEvent e){
        if(!Configuraciones.getFlagEInicialSeleccionado()){
            JButton s = (JButton)e.getComponent();
        
            s.setBackground(Color.white);
            s.setText("I");
        
            Configuraciones.setFlagEInicialSeleccionado(true);
        
            VentanaPrincipal.jlEstadoInicial.setVisible(false);
            VentanaPrincipal.jBAvanza.setEnabled(true);
        
            this.jbEstado = s;
            this.jbEstado.repaint();
        }
    }
    
    public void setjbEstado(MouseEvent e){
        if(!Configuraciones.getFlagEInicialSeleccionado()){
            JButton s = (JButton)e.getComponent();
        
            s.setBackground(Color.orange);
            s.setText("I");
        
            Configuraciones.setFlagEInicialSeleccionado(true);
        
            VentanaPrincipal.jlEstadoInicial.setVisible(false);
            VentanaPrincipal.jBAvanza.setEnabled(true);
        
            this.jbEstado = s;
            this.jbEstado.repaint();
        }
    }
}
