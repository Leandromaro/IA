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

        if(s.getBackground() == Color.white & (!("F".equals(s.getText())) | !("I").equals(s.getText()))){
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
                                if(!VentanaPrincipal.estadoInicial){
                                    s.setBackground(Color.ORANGE);
                                    s.setText("I");
                                    VentanaPrincipal.estadoInicial = true;
                                    VentanaPrincipal.jlEstadoInicial.setVisible(false);
                                    if(VentanaPrincipal.estadoFinal){
                                        VentanaPrincipal.jbConfirmar.setEnabled(true);
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbGuardar.setVisible(true);
                                        VentanaPrincipal.jbGuardar.setEnabled(true);
                                    }  
                                }else{
                                    if(!VentanaPrincipal.estadoFinal){
                                        s.setBackground(Color.GREEN);
                                        s.setText("F");
                                        VentanaPrincipal.estadoFinal = true;
                                        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
                                        if(VentanaPrincipal.estadoInicial){
                                            VentanaPrincipal.jbConfirmar.setEnabled(true);
                                            VentanaPrincipal.jbConfirmar.setVisible(true);
                                            VentanaPrincipal.jbGuardar.setVisible(true);
                                            VentanaPrincipal.jbGuardar.setEnabled(true);
                                        }  
                                    }else{
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbConfirmar.setEnabled(true);
                                        VentanaPrincipal.jbGuardar.setVisible(true);
                                        VentanaPrincipal.jbGuardar.setEnabled(true);
                                        s.setBackground(Color.white);
                                        s.setText("");
                                    }
                                }    
                            }else{
                                if("I".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoInicial = false;
                                    VentanaPrincipal.jlEstadoInicial.setVisible(true);                      
                                } 
                                if("F".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoFinal = false;                                    
                                    VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(true);
                                }
                                VentanaPrincipal.jbConfirmar.setVisible(true);
                                VentanaPrincipal.jbConfirmar.setEnabled(false);
                                VentanaPrincipal.jbGuardar.setVisible(true);
                                VentanaPrincipal.jbGuardar.setEnabled(false);
                                
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

        if(s.getBackground() == Color.white & (!("F".equals(s.getText())) | !("I").equals(s.getText()))){
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
                                if(!VentanaPrincipal.estadoInicial){
                                    s.setBackground(Color.ORANGE);
                                    s.setText("I");
                                    VentanaPrincipal.estadoInicial = true;
                                    VentanaPrincipal.jlEstadoInicial.setVisible(false);
                                    if(VentanaPrincipal.estadoFinal){
                                        VentanaPrincipal.jbConfirmar.setEnabled(true);
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbGuardar.setVisible(true);
                                        VentanaPrincipal.jbGuardar.setEnabled(true);
                                    }  
                                }else{
                                    if(!VentanaPrincipal.estadoFinal){
                                        s.setBackground(Color.GREEN);
                                        s.setText("F");
                                        VentanaPrincipal.estadoFinal = true;
                                        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
                                        if(VentanaPrincipal.estadoInicial){
                                            VentanaPrincipal.jbConfirmar.setEnabled(true);
                                            VentanaPrincipal.jbConfirmar.setVisible(true);
                                            VentanaPrincipal.jbGuardar.setVisible(true);
                                            VentanaPrincipal.jbGuardar.setEnabled(true);
                                        }  
                                    }else{
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbConfirmar.setEnabled(true);
                                        s.setBackground(Color.white);
                                        s.setText("");
                                    }
                                }    
                            }else{
                                if("INICIAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoInicial = false;
                                    VentanaPrincipal.jlEstadoInicial.setVisible(true);                      
                                } 
                                if("FINAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText("");
                                    VentanaPrincipal.estadoFinal = false;                                    
                                    VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(true);
                                }
                                VentanaPrincipal.jbConfirmar.setVisible(true);
                                VentanaPrincipal.jbConfirmar.setEnabled(false);
                                VentanaPrincipal.jbGuardar.setVisible(true);
                                VentanaPrincipal.jbGuardar.setEnabled(false);
                                
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
