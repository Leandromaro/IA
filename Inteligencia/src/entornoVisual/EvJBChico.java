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
        String textoAnterior;
        textoAnterior=s.getName();  
        if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                s.setBackground(Color.black);
//                s.setText("");
                  
            }else{
            if(s.getBackground() == Color.black){  
                s.setBackground(cf.rojo);
//                s.setText("Malo");
                   
            }else{
                if(cf.rojo.equals(s.getBackground())){//Malo".equals(s.getText())){
                    
                    s.setBackground(cf.amarillo);
//                    s.setText("Bueno");
                }else{
                    if(cf.amarillo.equals(s.getBackground())){
                        s.setBackground(cf.verde);
//                        s.setText("Excelente");
                    }else{
                        if(cf.verde.equals(s.getBackground())){
                                    if(!VentanaPrincipal.banderaEstadoFinal){
                                        s.setBackground(Color.GREEN);
                                        textoAnterior=s.getText();
                                        s.setText("FINAL");
                                        VentanaPrincipal.banderaEstadoFinal = true;
                                        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbConfirmar.setEnabled(true); 
                                         
                                    }else{
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbConfirmar.setEnabled(true);
                                        
                                        s.setBackground(Color.white);
//                                        s.setText(textoAnterior);
                                    }
                            }else{
                                if("FINAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText(textoAnterior);
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
        
        if((VentanaPrincipal.estadoInicial) & (VentanaPrincipal.banderaEstadoFinal)){
            VentanaPrincipal.jbConfirmar.setEnabled(true);
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    }
      
    public void setjbEstado(MouseEvent e){
        JButton s = (JButton)e.getComponent();
        String textoAnterior;
        textoAnterior=s.getName();  
        if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                s.setBackground(Color.black);
//                s.setText("");
                  
            }else{
            if(s.getBackground() == Color.black){  
                s.setBackground(cf.rojo);
//                s.setText("Malo");
                   
            }else{
                if(cf.rojo.equals(s.getBackground())){//Malo".equals(s.getText())){
                    
                    s.setBackground(cf.amarillo);
//                    s.setText("Bueno");
                }else{
                    if(cf.amarillo.equals(s.getBackground())){
                        s.setBackground(cf.verde);
//                        s.setText("Excelente");
                    }else{
                        if(cf.verde.equals(s.getBackground())){
                                    if(!VentanaPrincipal.banderaEstadoFinal){
                                        s.setBackground(Color.GREEN);
                                        textoAnterior=s.getText();
                                        s.setText("FINAL");
                                        VentanaPrincipal.banderaEstadoFinal = true;
                                        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbConfirmar.setEnabled(true); 
                                         
                                    }else{
                                        VentanaPrincipal.jbConfirmar.setVisible(true);
                                        VentanaPrincipal.jbConfirmar.setEnabled(true);
                                        
                                        s.setBackground(Color.white);
//                                        s.setText(textoAnterior);
                                    }
                            }else{
                                if("FINAL".equals(s.getText())){
                                    s.setBackground(Color.white);
                                    s.setText(textoAnterior);
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
        
        if((VentanaPrincipal.estadoInicial) & (VentanaPrincipal.banderaEstadoFinal)){
            VentanaPrincipal.jbConfirmar.setEnabled(true);
        }
        this.jbEstado = s;
        this.jbEstado.repaint();
    };
    
    public EvJBChico() {
          
    }
}
