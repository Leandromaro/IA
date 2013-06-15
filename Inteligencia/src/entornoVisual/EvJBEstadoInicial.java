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
    private JButton jbAnterior;
    
    public JButton getjbEstado(){
        return this.jbEstado;
    }
    
    public void setjbEstado(MouseWheelEvent e){
        
        JButton s = (JButton)e.getComponent();
        if(!Configuraciones.getFlagEInicialSeleccionado()){
            if(s.getBackground()!=Color.black){
                jbAnterior = new JButton();
                jbAnterior.setBackground(s.getBackground());
                jbAnterior.setText(s.getText());
            
                s.setBackground(Color.orange);
                s.setText("I");
        
                Configuraciones.setFlagEInicialSeleccionado(true);
                VentanaPrincipal.jlInicialNoPared.setVisible(false);
        
                VentanaPrincipal.jlEstadoInicial.setVisible(false);
                VentanaPrincipal.jBAvanza.setEnabled(true);
            }
            else{
                VentanaPrincipal.jlInicialNoPared.setVisible(true);
            }
        }else{
            if("I".equals(s.getText())){
                s.setText(jbAnterior.getText());
                s.setBackground(jbAnterior.getBackground());
                Configuraciones.setFlagEInicialSeleccionado(false);
                VentanaPrincipal.jlEstadoInicial.setVisible(true);
                VentanaPrincipal.jBAvanza.setEnabled(false);
            }
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    }
    
    public void setjbEstado(MouseEvent e){
        JButton s = (JButton)e.getComponent();
        if(!Configuraciones.getFlagEInicialSeleccionado()){
            if(s.getBackground()!=Color.black){
                jbAnterior = new JButton();
                jbAnterior.setBackground(s.getBackground());
                jbAnterior.setText(s.getText());
            
                s.setBackground(Color.orange);
                s.setText("I");
        
                Configuraciones.setFlagEInicialSeleccionado(true);
                VentanaPrincipal.jlInicialNoPared.setVisible(false);
        
                VentanaPrincipal.jlEstadoInicial.setVisible(false);
                VentanaPrincipal.jBAvanza.setEnabled(true);
            }
            else{
                VentanaPrincipal.jlInicialNoPared.setVisible(true);
            }
        }else{
            if("I".equals(s.getText())){
                s.setText(jbAnterior.getText());
                s.setBackground(jbAnterior.getBackground());
                Configuraciones.setFlagEInicialSeleccionado(false);
                VentanaPrincipal.jlEstadoInicial.setVisible(true);
                VentanaPrincipal.jBAvanza.setEnabled(false);
            }
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    }
}
 
