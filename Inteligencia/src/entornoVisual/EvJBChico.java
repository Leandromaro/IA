/*
 * Con este objeto se modifica el contenido de un estado chico, esto es,
 * de dimension mayor o igual a 8
 */
package entornoVisual;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;

/**
 *
 *
 */
public class EvJBChico {
 
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

        if(s.getBackground() == Color.white & (!("F".equals(s.getText())))){
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
                            if(!VentanaPrincipal.banderaEstadoFinal){
                                s.setBackground(Color.GREEN);
                                s.setText("F");
                                VentanaPrincipal.banderaEstadoFinal = true;
                                VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);                                                              
                            }else{
                                s.setBackground(Color.white);
                                s.setText("");
                            }
                            VentanaPrincipal.jbConfirmar.setEnabled(true);
                            VentanaPrincipal.jbConfirmar.setVisible(true);
                        }else{
                            if("F".equals(s.getText())){
                                s.setBackground(Color.white);
                                s.setText("");
                                VentanaPrincipal.banderaEstadoFinal = false;                                    
                                VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(true);
                            }
                            VentanaPrincipal.jbConfirmar.setVisible(true);
                            VentanaPrincipal.jbConfirmar.setEnabled(false);     
                        } 
                                     
                    }
                }     
            }
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    }
      
    public void setjbEstado(MouseEvent e){
        JButton s = (JButton)e.getComponent();

        if(s.getBackground() == Color.white & (!("F".equals(s.getText())))){
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
                            if(!VentanaPrincipal.banderaEstadoFinal){
                                s.setBackground(Color.GREEN);
                                s.setText("F");
                                VentanaPrincipal.banderaEstadoFinal = true;
                                VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);                                                              
                            }else{
                                s.setBackground(Color.white);
                                s.setText("");
                            }
                            VentanaPrincipal.jbConfirmar.setEnabled(true);
                            VentanaPrincipal.jbConfirmar.setVisible(true);
                        }else{
                            if("F".equals(s.getText())){
                                s.setBackground(Color.white);
                                s.setText("");
                                VentanaPrincipal.banderaEstadoFinal = false;                                    
                                VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(true);
                            }
                            VentanaPrincipal.jbConfirmar.setVisible(true);
                            VentanaPrincipal.jbConfirmar.setEnabled(false);     
                        } 
                                     
                    }
                }     
            }
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    };
    
    public EvJBChico() {
          
    }
}
