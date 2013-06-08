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
 */
public class EvJBChico {
 
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

        if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
            s.setBackground(Color.black);
            s.setText("");
        }else{
            if(s.getBackground() == Color.black){
                s.setBackground(cf.rojo);
                s.setText("M");
            }else{
                if("M".equals(s.getText())){
                    s.setBackground(cf.amarillo);
                    s.setText("B");
                }else{
                    if("B".equals(s.getText())){
                        s.setBackground(cf.verde);
                        s.setText("E");
                    }else{
                        if("E".equals(s.getText())){
                            if(!flagFinal){
                                 s.setBackground(Color.white);
                                 s.setText("F");
                                 flagFinal = true;

                            }else{
                                s.setBackground(Color.white);
                                s.setText("");
                            }
                        }else{
                            if("F".equals(s.getText())){
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

        if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
            s.setBackground(Color.black);
            s.setText("");
        }else{
            if(s.getBackground() == Color.black){
                s.setBackground(cf.rojo);
                s.setText("M");
            }else{
                if("M".equals(s.getText())){
                    s.setBackground(cf.amarillo);
                    s.setText("B");
                }else{
                    if("B".equals(s.getText())){
                        s.setBackground(cf.verde);
                        s.setText("E");
                    }else{
                        if("E".equals(s.getText())){
                            if(!flagFinal){
                                 s.setBackground(Color.white);
                                 s.setText("F");
                                 flagFinal = true;

                            }else{
                                s.setBackground(Color.white);
                                s.setText("");
                            }
                        }else{
                            if("F".equals(s.getText())){
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
        
}
