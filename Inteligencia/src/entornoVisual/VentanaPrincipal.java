/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Maty
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    public void cargarTablero(int dim){
       
        jpTablero.setVisible(false);
        jpTablero.removeAll();
        jpTablero.setLayout(new GridLayout(dim,dim));
        
//
//        ImageIcon image = new ImageIcon("images/Excelente.png"); 
//                int scale = 1;        
//                int width = image.getIconWidth();  
//                int height = image.getIconHeight();  
//                BufferedImage buffer = new BufferedImage(scale * width, scale * height,
//                        BufferedImage.TYPE_INT_ARGB);  
//                Graphics2D graphics = buffer.createGraphics();  
//                graphics.scale(scale,scale);  
//                image.paintIcon(null, graphics, 0, 0);  
//                graphics.dispose();  
//                JLabel jlLabel = new JLabel();
//                Icon icono = new ImageIcon(image.getImage()
//                        .getScaledInstance(jlLabel.getWidth(), jlLabel.getHeight(),
//                        Image.SCALE_DEFAULT));
//                jlLabel.setIcon(icono);
//                this.repaint();
        
        
        
        
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                JButton jbEstado = new JButton();
                jbEstado.setBorder(blackline);
                
//                ImageIcon icon = new ImageIcon("images/Excelente.png");
                
                // pego
//                int scale =1;
//                BufferedImage bi = new BufferedImage(
//                        scale*icon.getIconWidth(),
//                        scale*icon.getIconHeight(),
//                        BufferedImage.TYPE_INT_ARGB);
//                Graphics2D g = bi.createGraphics();
//                g.scale(scale,scale);
//                icon.paintIcon(null,g,0,0);
//                g.dispose();
                
                
                
                
//                JLabel jlLabel = new JLabel("Excelente");
//                
//                jlLabel.setBackground(Color.GREEN);
//                
//                jlLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//                jlLabel.setVerticalTextPosition(SwingConstants.CENTER);
//            
                jbEstado.setText("Excelente");
                Font font = new Font("Arial", Font.BOLD, 9);
                
                jbEstado.setFont(font);
               

                switch(this.aleatorio(1, 5)){
                    
                    case 1: jbEstado.setBackground(Color.black);
                        break;
                    case 2: jbEstado.setBackground(Color.gray);
                        break;
                    case 3: jbEstado.setBackground(Color.blue);
                        break;
                    case 4: jbEstado.setBackground(Color.red);
                        break;
                    case 5: jbEstado.setBackground(Color.orange);
                        break;
                   default: jbEstado.setBackground(Color.white);
                       break;
                }
                
                
                jbEstado.addMouseListener(new MouseAdapter(){
		
		public void mouseClicked(MouseEvent e) {
                    
                  
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.black){
                        s.setBackground(Color.gray);
                        s.repaint();
                    }else{
                        if(s.getBackground() == Color.gray){
                            s.setBackground(Color.blue);
                            s.repaint();
                        }else{
                            if(s.getBackground() == Color.blue){
                                s.setBackground(Color.red);
                                s.repaint();
                            }else{
                               if(s.getBackground() == Color.red){
                                    s.setBackground(Color.orange);
                                    s.repaint();
                                }else{
                                   if(s.getBackground() == Color.orange){
                                        s.setBackground(Color.white);
                                        s.repaint();
                                    }else{
                                       if(s.getBackground() == Color.white){
                                            s.setBackground(Color.black);
                                            s.repaint();
                                       }
                                   }
                               } 
                            }
                        }
                    }
                    
                }});
                
            jpTablero.add(jbEstado);           
            }
        }
        jpTablero.setVisible(true);
    } 
    
    public int aleatorio(int min, int max){
        
        int randomNum=0;
        Random rn = new Random();
        int n = max - min + 1;
        int i = rn.nextInt() % n;
        randomNum =  min + i;
        return randomNum;
        
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Princial");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlConfig.setText("Creación del escenario");
        jpSuperior.add(jlConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 6, -1, -1));

        jlDim.setText("Dimensión");
        jpSuperior.add(jlDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 34, -1, -1));

        jcbDim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6x6", "7x7", "8x8", "9x9", "10x10" }));
        jpSuperior.add(jcbDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 31, -1, -1));

        jlManOAlea.setText("Creación:");
        jpSuperior.add(jlManOAlea, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, 20));

        jrbAuto.setText("Automática");
        jrbAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAutoActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jrbManual.setText("Manual");
        jrbManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbManualActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jbGenerarTablero.setText("Generar escenario");
        jbGenerarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarTableroActionPerformed(evt);
            }
        });
        jpSuperior.add(jbGenerarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 27, -1, 54));

        getContentPane().add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 635, 130));

        jpTablero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTablero.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jpTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 440, 410));

        jMenu1.setText("Menu");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Crear escenario");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked

    }//GEN-LAST:event_jMenuItem1MouseClicked

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
                // FALTA1
            }
                
        }  
    }//GEN-LAST:event_jbGenerarTableroActionPerformed

    private void jrbManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbManualActionPerformed

        jrbManual.setSelected(true);
        jrbAuto.setSelected(false);
    }//GEN-LAST:event_jrbManualActionPerformed

    private void jrbAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAutoActionPerformed

        jrbManual.setSelected(false);
        jrbAuto.setSelected(true);
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
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
