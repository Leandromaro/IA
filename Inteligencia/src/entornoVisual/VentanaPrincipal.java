/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Maty
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private Boolean estadoFinal;
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    
    public void cargarTableroManual(int dim){
        jpTablero.setVisible(false);
        jpTablero.removeAll();
        jpTablero.setLayout(new GridLayout(dim,dim));
          
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);
                       
        Font font = new Font("Arial", Font.BOLD, 9);
                
        final Color rojo = new Color(240, 90, 82);
        final Color amarillo = new Color(220, 246, 53);
        final Color verde = new Color(72, 237, 255);

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                
                JButton jbEstado = new JButton();
                jbEstado.setBorder(blackline);
                jbEstado.setFont(font);
                jbEstado.setBackground(Color.white);
                if (dim < 8){
                    jbEstado.addMouseWheelListener(new MouseAdapter() {
                    
                   public void mouseWheelMoved(MouseWheelEvent e){
                          
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white){
                        s.setBackground(Color.black);
                    }else{
                        if(s.getBackground() == Color.black){
                            s.setBackground(rojo);
                            s.setText("Malo");
                        }else{
                            if(s.getBackground() == rojo){
                                s.setBackground(amarillo);
                                s.setText("Bueno");
                            }else{
                               if(s.getBackground() == amarillo){
                                    s.setBackground(verde);
                                    s.setText("Excelente");
                                }else{
                                   if(s.getBackground() == verde){
                                        s.setBackground(Color.white);
                                        s.setText("");                                   
                                   }
                               } 
                            }
                        }
                    }
                    
                   s.repaint();   
                   } 
                    
                });
                    jbEstado.addMouseListener(new MouseAdapter(){
		
		public void mouseClicked(MouseEvent e) {
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white){
                        s.setBackground(Color.black);
                    }else{
                        if(s.getBackground() == Color.black){
                            s.setBackground(rojo);
                            s.setText("Malo");
                        }else{
                            if(s.getBackground() == rojo){
                                s.setBackground(amarillo);
                                s.setText("Bueno");
                            }else{
                               if(s.getBackground() == amarillo){
                                    s.setBackground(verde);
                                    s.setText("Excelente");
                                }else{
                                   if(s.getBackground() == verde){
                                        s.setBackground(Color.white);
                                        s.setText("");                                   
                                   }
                               } 
                            }
                        }
                    }
                    s.repaint();
                }}); 
                }else{
                    jbEstado.addMouseWheelListener(new MouseAdapter() {
                    
                        public void mouseWheelMoved(MouseWheelEvent e){
                          
                        JButton s = (JButton)e.getComponent();
                                    
                        if(s.getBackground() == Color.white){
                            s.setBackground(Color.black);
                        }else{
                            if(s.getBackground() == Color.black){
                                s.setBackground(rojo);
                                s.setText("M");
                            }else{
                                if(s.getBackground() == rojo){
                                    s.setBackground(amarillo);
                                    s.setText("B");
                                }else{
                                    if(s.getBackground() == amarillo){
                                        s.setBackground(verde);
                                        s.setText("E");
                                    }else{
                                        if(s.getBackground() == verde){
                                            s.setBackground(Color.white);
                                            s.setText("");                                    
                                        }
                                    } 
                                }
                            }
                        }
                        s.repaint();
                   }                  
                });
                    jbEstado.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {  
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white){
                        s.setBackground(Color.black);
                    }else{
                        if(s.getBackground() == Color.black){
                            s.setBackground(rojo);
                            s.setText("M");
                        }else{
                            if(s.getBackground() == rojo){
                                s.setBackground(amarillo);
                                s.setText("B");
                            }else{
                               if(s.getBackground() == amarillo){
                                    s.setBackground(verde);
                                    s.setText("E");
                                }else{
                                   if(s.getBackground() == verde){
                                        s.setBackground(Color.white);
                                        s.setText("");
                                   }
                               } 
                            }
                        }
                    }
                    s.repaint();
                }});
                    
                }
                
                jpTablero.add(jbEstado);           
            }
        }
//        Se agrega Estado Final
        
        
        jpTablero.remove(this.posAbosAleatoria(dim-1));
        jpTablero.add(this.estadoFinal(), this.posAbosAleatoria(dim-1));
        
        jpTablero.setVisible(true);       
        }

    public void cargarTablero(int dim){
        
        Font font = new Font("Arial", Font.BOLD, 9);
                
        final Color rojo = new Color(240, 90, 82);
        final Color amarillo = new Color(220, 246, 53);
        final Color verde = new Color(72, 237, 255);
       
        jpTablero.setVisible(false);
        jpTablero.removeAll();
        jpTablero.setLayout(new GridLayout(dim,dim));
          
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                
                JButton jbEstado = new JButton();
                jbEstado.setBorder(blackline);
                jbEstado.setFont(font);
                
                if (dim < 8){
                    switch(this.aleatorio(1, 5)){
                    
                        case 1: jbEstado.setBackground(Color.white);
                            break;
                        case 2: jbEstado.setBackground(Color.black);
                            break;
                        case 3: jbEstado.setBackground(rojo);
                            jbEstado.setText("Malo");
                            break;
                        case 4: jbEstado.setBackground(amarillo);
                            jbEstado.setText("Bueno");
                            break;
                        case 5: jbEstado.setBackground(verde);
                            jbEstado.setText("Excelente");
                            break;
                        default: //jbEstado.setBackground(Color.red);
                            jbEstado.setText("OTRO");
                            break;
                    }
                    
                jbEstado.addMouseWheelListener(new MouseAdapter() {
                   public void mouseWheelMoved(MouseWheelEvent e){
                          
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white){
                        s.setBackground(Color.black);
                    }else{
                        if(s.getBackground() == Color.black){
                            s.setBackground(rojo);
                            s.setText("Malo");
                        }else{
                            if(s.getBackground() == rojo){
                                s.setBackground(amarillo);
                                s.setText("Bueno");
                            }else{
                               if(s.getBackground() == amarillo){
                                    s.setBackground(verde);
                                    s.setText("Excelente");
                                }else{
                                   if(s.getBackground() == verde){
                                        s.setBackground(Color.white);
                                        s.setText("");                                    
                                   }
                               } 
                            }
                        }
                    }
                    s.repaint();
                   } 
                });
                    
                    
                jbEstado.addMouseListener(new MouseAdapter(){
		
		public void mouseClicked(MouseEvent e) {
                    
                  
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white){
                        s.setBackground(Color.black);
                    }else{
                        if(s.getBackground() == Color.black){
                            s.setBackground(rojo);
                            s.setText("Malo");
                        }else{
                            if(s.getBackground() == rojo){
                                s.setBackground(amarillo);
                                s.setText("Bueno");
                            }else{
                               if(s.getBackground() == amarillo){
                                    s.setBackground(verde);
                                    s.setText("Excelente");
                                }else{
                                   if(s.getBackground() == verde){
                                        s.setBackground(Color.white);
                                        s.setText("");
                                   }
                               } 
                            }
                        }
                    }
                    s.repaint();
                }});
                    
                }else{
                    switch(this.aleatorio(1, 5)){
                    
                        case 1: jbEstado.setBackground(Color.white);
                            break;
                        case 2: jbEstado.setBackground(Color.black);
                            break;
                        case 3: jbEstado.setBackground(rojo);
                            jbEstado.setText("M");
                            break;
                        case 4: jbEstado.setBackground(amarillo);
                            jbEstado.setText("B");
                            break;
                        case 5: jbEstado.setBackground(verde);
                            jbEstado.setText("E");
                            break;
                        default: //jbEstado.setBackground(Color.red);
                            jbEstado.setText("OTRO");
                            break;
                    }
                        
                    jbEstado.addMouseWheelListener(new MouseAdapter() {
                    
                    public void mouseWheelMoved(MouseWheelEvent e){
                          
                        JButton s = (JButton)e.getComponent();
                                    
                        if(s.getBackground() == Color.white){
                            s.setBackground(Color.black);
                        }else{
                            if(s.getBackground() == Color.black){
                                s.setBackground(rojo);
                                s.setText("M");
                            }else{
                                if(s.getBackground() == rojo){
                                    s.setBackground(amarillo);
                                    s.setText("B");
                                }else{
                                    if(s.getBackground() == amarillo){
                                        s.setBackground(verde);
                                        s.setText("E");
                                    }else{
                                        if(s.getBackground() == verde){
                                            s.setBackground(Color.white);
                                            s.setText("");                                    
                                        }
                                    } 
                                }
                            }
                        }
                        s.repaint();
                    }});
                    
                    jbEstado.addMouseListener(new MouseAdapter(){
		
                    public void mouseClicked(MouseEvent e) {
                    
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white){
                        s.setBackground(Color.black);
                    }else{
                        if(s.getBackground() == Color.black){
                            s.setBackground(rojo);
                            s.setText("M");
                        }else{
                            if(s.getBackground() == rojo){
                                s.setBackground(amarillo);
                                s.setText("B");
                            }else{
                               if(s.getBackground() == amarillo){
                                    s.setBackground(verde);
                                    s.setText("E");
                                }else{
                                   if(s.getBackground() == verde){
                                        s.setBackground(Color.white);
                                        s.setText("");   
                                   }
                               } 
                            }
                        }
                    }
                    s.repaint();
                }});
                    
                }
                
            jpTablero.add(jbEstado);           
            }
        }
//        Se agrega Estado Final
        jpTablero.remove(this.posAbosAleatoria(dim-1));
        jpTablero.add(this.estadoFinal(), this.posAbosAleatoria(dim-1));
        
        jpTablero.setVisible(true);
    } 
    
    public int aleatorio(int min, int max){
        
        int randomNum=0;
        Random rn = new Random();
       // int n = max - min + 1;
        int n = rn.nextInt(max);
        //int i = rn.nextInt() % n;
        //randomNum =  min + i;
        //return randomNum;
        return n+1;
    }
    
//    Devuelve una posición absoluta aleatoria para usar en el GridLayout
//            de la Interfaz grafica. 
//    Verificar que abarque todos los estados
    public int posAbosAleatoria(int dim){   
        
        int fila = this.aleatorio(0, dim);
        int columna = this.aleatorio(0, dim);
        
        return ((fila*dim)+columna);
    }
    
    public JButton estadoFinal(){
        
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);
        Font font = new Font("Arial", Font.BOLD, 9);
        
        JButton jbEstado = new JButton();
        jbEstado.setBorder(blackline);
        jbEstado.setFont(font);
        jbEstado.setBackground(Color.white);
        jbEstado.setText("FINAL");
        
        jbEstado.repaint();
        
        return jbEstado;     
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpSuperior = new javax.swing.JPanel();
        jlConfig = new javax.swing.JLabel();
        jlDim = new javax.swing.JLabel();
        jcbDim = new javax.swing.JComboBox();
        jlManOAlea = new javax.swing.JLabel();
        jrbAuto = new javax.swing.JRadioButton();
        jrbManual = new javax.swing.JRadioButton();
        jbGenerarTablero = new javax.swing.JButton();
        jpTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Princial");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlConfig.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlConfig.setText("Creación del escenario:");
        jpSuperior.add(jlConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));

        jlDim.setText("Dimensión");
        jpSuperior.add(jlDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jcbDim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6x6", "7x7", "8x8", "9x9", "10x10" }));
        jpSuperior.add(jcbDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jlManOAlea.setText("Creación:");
        jpSuperior.add(jlManOAlea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jrbAuto.setText("Automática");
        jrbAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAutoActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jrbManual.setText("Manual");
        jrbManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbManualActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jbGenerarTablero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbGenerarTablero.setText("Generar escenario");
        jbGenerarTablero.setEnabled(false);
        jbGenerarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarTableroActionPerformed(evt);
            }
        });
        jpSuperior.add(jbGenerarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 54));

        getContentPane().add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 635, 130));

        jpTablero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTablero.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jpTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 440, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbGenerarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarTableroActionPerformed
        
        if(jrbAuto.isSelected()){
        String aux = (String)jcbDim.getSelectedItem();
        switch(aux){
            case "6x6":this.cargarTablero(6);
                break;
            case "7x7":this.cargarTablero(7);
                break;
            case "8x8":this.cargarTablero(8);
                break;
            case "9x9":this.cargarTablero(9);
                break;
            case "10x10":this.cargarTablero(10);
                break;
        }    
        }else{
            if(jrbManual.isSelected()){
               String aux = (String)jcbDim.getSelectedItem();
               switch(aux){
                    case "6x6":this.cargarTableroManual(6);
                    break;
                case "7x7":this.cargarTableroManual(7);
                    break;
                case "8x8":this.cargarTableroManual(8);
                    break;
                case "9x9":this.cargarTableroManual(9);
                    break;
                case "10x10":this.cargarTableroManual(10);
                    break;
               }    
            } 
        }  
    }//GEN-LAST:event_jbGenerarTableroActionPerformed

    private void jrbManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbManualActionPerformed

        jrbManual.setSelected(true);
        jrbAuto.setSelected(false);
        jbGenerarTablero.setEnabled(true);
    }//GEN-LAST:event_jrbManualActionPerformed

    private void jrbAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAutoActionPerformed

        jrbManual.setSelected(false);
        jrbAuto.setSelected(true);
        jbGenerarTablero.setEnabled(true);
    }//GEN-LAST:event_jrbAutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbGenerarTablero;
    private javax.swing.JComboBox jcbDim;
    private javax.swing.JLabel jlConfig;
    private javax.swing.JLabel jlDim;
    private javax.swing.JLabel jlManOAlea;
    private javax.swing.JPanel jpSuperior;
    private javax.swing.JPanel jpTablero;
    private javax.swing.JRadioButton jrbAuto;
    private javax.swing.JRadioButton jrbManual;
    // End of variables declaration//GEN-END:variables
}
