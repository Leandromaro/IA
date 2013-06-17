/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;

/**
 *
 * @author Maty
 * La el objeto EvJBGrande contiene los eventos correspondientes a un 
 * JButton grande de dimensionse 6x6 y 7x7 del tablero
 * Ademas cuenta con atributos utiles para actualizar otras partes de la 
 * VentanaPrincipal
 */
public class EvJBGrande extends MouseAdapter{
    
    private ColoresyFormas cf = new ColoresyFormas();
    
    private MouseAdapter mWheelMoved;
    private MouseAdapter mClicked;
    
    private JButton jbEstado;   
    
    public JButton getjbEstado(){
        return this.jbEstado;
    }
    public MouseAdapter getmWheelMoved(){
        return this.mWheelMoved;
    }
    public MouseAdapter getmClicked(){
        return this.mClicked;
    }
    
    public void setjbEstado(MouseWheelEvent e){
        JButton s = (JButton)e.getComponent();

        if(s.getBackground() == Color.white & (!("FINAL".equals(s.getText())) | !("INICIAL").equals(s.getText()))){
                s.setBackground(Color.black);
                s.setText("");
            }else{
            if(s.getBackground() == Color.black){  
                s.setBackground(cf.rojo);
                s.setText("Malo");
            }else{
                if("Malo".equals(s.getText())){
                    s.setBackground(cf.amarillo);
                    s.setText("Bueno");
                }else{
                    if("Bueno".equals(s.getText())){
                        s.setBackground(cf.verde);
                        s.setText("Excelente");
                    }else{
                        if("Excelente".equals(s.getText())){
                                if(!VentanaPrincipal.estadoInicial){
                                    s.setBackground(Color.ORANGE);
                                    s.setText("INICIAL");
                                    VentanaPrincipal.estadoInicial = true;
//                                    VentanaPrincipal.vistaConfigPoliticas(true);
                                    VentanaPrincipal.jlEstadoInicial.setVisible(false);
                                }else{
                                    if(!VentanaPrincipal.estadoFinal){
                                        s.setBackground(Color.GREEN);
                                        s.setText("FINAL");
                                        VentanaPrincipal.estadoFinal = true;
                                        
                                        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
                                    }else{
                                        s.setBackground(Color.white);
                                        s.setText("");
                                    }
                                }    
                            }else{
                                if("FINAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoFinal = false;
                                    VentanaPrincipal.jbConfirmar.setEnabled(false);
                                    VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(true);
                                }
                                if("INICIAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoInicial = false;
                                    VentanaPrincipal.jbConfirmar.setEnabled(false);
                                    VentanaPrincipal.jlEstadoInicial.setVisible(true);                      
                                } 
                            }
                    }
                }     
            }
        }
        
        if((VentanaPrincipal.estadoInicial) & (VentanaPrincipal.estadoFinal)){
            VentanaPrincipal.jbConfirmar.setEnabled(true);
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    }
      
    public void setjbEstado(MouseEvent e){
        JButton s = (JButton)e.getComponent();

        if(s.getBackground() == Color.white & (!("FINAL".equals(s.getText())) | !("INICIAL").equals(s.getText()))){
                s.setBackground(Color.black);
                s.setText("");
            }else{
            if(s.getBackground() == Color.black){  
                s.setBackground(cf.rojo);
                s.setText("Malo");
            }else{
                if("Malo".equals(s.getText())){
                    s.setBackground(cf.amarillo);
                    s.setText("Bueno");
                }else{
                    if("Bueno".equals(s.getText())){
                        s.setBackground(cf.verde);
                        s.setText("Excelente");
                    }else{
                        if("Excelente".equals(s.getText())){
                                if(!VentanaPrincipal.estadoInicial){
                                    s.setBackground(Color.ORANGE);
                                    s.setText("INICIAL");
                                    VentanaPrincipal.estadoInicial = true;
                                    VentanaPrincipal.vistaConfigPoliticas(true);
                                    VentanaPrincipal.jlEstadoInicial.setVisible(false);
                                }else{
                                    if(!VentanaPrincipal.estadoFinal){
                                        s.setBackground(Color.GREEN);
                                        s.setText("FINAL");
                                        VentanaPrincipal.estadoFinal = true;
                                        VentanaPrincipal.jbConfirmar.setEnabled(true);
                                        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
                                    }else{
                                        s.setBackground(Color.white);
                                        s.setText("");
                                    }
                                }    
                            }else{
                                if("FINAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoFinal = false;
                                    VentanaPrincipal.jbConfirmar.setEnabled(false);
                                    VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(true);
                                }
                                if("INICIAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoInicial = false;
                                    VentanaPrincipal.jbConfirmar.setEnabled(false);
                                    VentanaPrincipal.jlEstadoInicial.setVisible(true);                      
                                } 
                            }
                    }
                }     
            }
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    };
    
    public EvJBGrande() {
          
    }
}
