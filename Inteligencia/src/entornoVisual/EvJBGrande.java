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
    
    private Boolean flagFinal = false;
    
    public JButton getjbEstado(){
        return this.jbEstado;
    }
    public MouseAdapter getmWheelMoved(){
        return this.mWheelMoved;
    }
    public MouseAdapter getmClicked(){
        return this.mClicked;
    }
    
    public Boolean getflagFinal(){
        return this.flagFinal;
    }
    public void setflagFinal(Boolean flagFinal){
        this.flagFinal = flagFinal;
    }

    public void setjbEstado(MouseWheelEvent e){
        JButton s = (JButton)e.getComponent();

        if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
            s.setBackground(Color.black);
            s.setText("");
        }else{
            if(s.getBackground() == Color.black){  
                s.setBackground(cf.rojo);
                s.setText("Malo");
            }else{
                if(s.getBackground() == cf.rojo){
                    s.setBackground(cf.amarillo);
                    s.setText("Bueno");
                }else{
                    if(s.getBackground() == cf.amarillo){
                        s.setBackground(cf.verde);
                        s.setText("Excelente");
                    }else{
                        if(s.getBackground() == cf.verde){
                            if(!flagFinal){
                                s.setBackground(Color.white);
                                s.setText("FINAL");
                                flagFinal = true;
                            }else{
                            s.setBackground(Color.white);
                            s.setText("");
                            }
                        }else{
                            if("FINAL".equals(s.getText())){
                            s.setBackground(Color.white);
                            s.setText("");
                            flagFinal = false;
                            }
                        }
                    } 
                }
            }     
        }   
        this.jbEstado = s;
        this.jbEstado.repaint();
        };

    public void setjbEstado(MouseEvent e){
        JButton s = (JButton)e.getComponent();

        if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
            s.setBackground(Color.black);
            s.setText("");
        }else{
            if(s.getBackground() == Color.black){  
                s.setBackground(cf.rojo);
                s.setText("Malo");
            }else{
                if(s.getBackground() == cf.rojo){
                    s.setBackground(cf.amarillo);
                    s.setText("Bueno");
                }else{
                    if(s.getBackground() == cf.amarillo){
                        s.setBackground(cf.verde);
                        s.setText("Excelente");
                    }else{
                        if(s.getBackground() == cf.verde){
                            if(!flagFinal){
                                s.setBackground(Color.white);
                                s.setText("FINAL");
                                flagFinal = true;
                            }else{
                            s.setBackground(Color.white);
                            s.setText("");
                            }
                        }else{
                            if("FINAL".equals(s.getText())){
                            s.setBackground(Color.white);
                            s.setText("");
                            flagFinal = false;
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
