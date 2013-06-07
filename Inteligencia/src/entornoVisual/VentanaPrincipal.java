/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import logica.Configuraciones;
import logica.Entrenador;
import logica.Estado;
import logica.PoliticaSoftMax;
import logica.QMat;
import logica.RMat;

/**
 *
 * @author Maty
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private Boolean estadoFinal;
    private Border blackline;
    private Boolean flagFinal;
//    blackline = BorderFactory.createLineBorder(Color.black);
    
    Font font = new Font("Arial", Font.BOLD, 9);
                
    final Color rojo = new Color(240, 90, 82);
    final Color amarillo = new Color(220, 246, 53);
    final Color verde = new Color(72, 237, 255);
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
     
        jlAusenciaEstadoFinal.setVisible(false);
        jlTau.setVisible(false);
        jlEpsilon.setVisible(false);
        this.visibleConfigPoliticas(false);

    }

   
    public void cargarTableroManual(int dim){
        jpTablero.setVisible(false);
        jpTablero.removeAll();
        jpTablero.setLayout(new GridLayout(dim,dim));
          
        blackline = BorderFactory.createLineBorder(Color.black);
                       
        flagFinal = false;
        
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                
                JButton jbEstado = new JButton();
                //jbEstado.setBorder(blackline);
                jbEstado.setFont(font);
                jbEstado.setBackground(Color.white);
                
                if (dim < 8){
                    jbEstado.addMouseWheelListener(new MouseAdapter() {
                    
                   public void mouseWheelMoved(MouseWheelEvent e){
                          
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                               if(!flagFinal){
                                                    s.setBackground(Color.white);
                                                    s.setText("FINAL");
                                                    flagFinal = true;
                                                    VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                               }else{
                                                   s.setBackground(Color.white);
                                                   s.setText("");
                                               }
                                           }else{
                                               if("FINAL".equals(s.getText())){
                                                   s.setBackground(Color.white);
                                                   s.setText("");
                                                   flagFinal = false;
                                                   VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                               }
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
                                    
                    if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("FINAL");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("FINAL".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
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
                                    
                        if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
                            s.setBackground(Color.black);
                            s.setText("");
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
                        s.repaint();
                   }                  
                });
                    jbEstado.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {  
                    JButton s = (JButton)e.getComponent();
                                    
                    if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                    s.repaint();
                }});
                    
                }
                
                jpTablero.add(jbEstado);           
            }
        }
        jpTablero.setVisible(true);       
        }

    public void cargarTableroAleatorio(int dim){
        
        blackline = BorderFactory.createLineBorder(Color.black);
        //instanciar matriz, aleatoriament, y modificar codigo para que tome valores de esa matriz
       
        jpTablero.setVisible(false);
        jpTablero.removeAll();
        jpTablero.setLayout(new GridLayout(dim,dim));
        
        
        flagFinal = true;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                
                JButton jbEstado = new JButton();
                //jbEstado.setBorder(blackline);
                jbEstado.setFont(font);
                
                //cargar el background y el tex en base a lo que tiene la matriz r
                
                //if(matR[i][j]==Configuraciones.Pared){
                //jbEstado.setBackground(Color.black);
                
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
                                    
                    
                    if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("FINAL");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("FINAL".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
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
                                    
                    if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                    
                        if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
                            s.setBackground(Color.black);
                            s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("F");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("F".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
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
                                    
                    if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("F");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("F".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
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
        jpTablero.remove(this.posAbosAleatoria(dim));
        jpTablero.add(this.estadoFinal(dim), this.posAbosAleatoria(dim));
 
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
    
    public int aleatorioConCero(int max){
        Random rn = new Random();
        int n = rn.nextInt(max);
        return n;
    }
    
//    Devuelve una posición absoluta aleatoria para usar en el GridLayout
//            de la Interfaz grafica. 
//    Verificar que abarque todos los estados
    public int posAbosAleatoria(int dim){   
        
        int fila = this.aleatorioConCero(dim);
        int columna = this.aleatorioConCero(dim);
        
        return ((fila*dim)+columna);
    }
    
    public JButton estadoFinal(int dim){
        blackline = BorderFactory.createLineBorder(Color.black);
 
        JButton jbEstado = new JButton();
        //jbEstado.setBorder(blackline);
        jbEstado.setFont(font);
        jbEstado.setBackground(Color.white);
    
        if(dim < 8){
            jbEstado.setText("FINAL");
            jbEstado.addMouseWheelListener(new MouseAdapter() {
                   
                   public void mouseWheelMoved(MouseWheelEvent e){
                          
                    JButton s = (JButton)e.getComponent();
                                    
                    
                    if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("FINAL");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("FINAL".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
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
                                    
                    if(s.getBackground() == Color.white & !("FINAL".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("FINAL");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("FINAL".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
                                        }
                                    }  
                            }
                        }
                    }
                    s.repaint();
                }});
        }
        else{
            jbEstado.setText("F");
            
            jbEstado.addMouseWheelListener(new MouseAdapter() {
                    
                    public void mouseWheelMoved(MouseWheelEvent e){
                          
                        JButton s = (JButton)e.getComponent();
                                    
                        if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
                            s.setBackground(Color.black);
                            s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("F");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("F".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
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
                                    
                    if(s.getBackground() == Color.white & !("F".equals(s.getText()))){
                        s.setBackground(Color.black);
                        s.setText("");
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
                                            if(!flagFinal){
                                                 s.setBackground(Color.white);
                                                 s.setText("F");
                                                 flagFinal = true;
                                                 VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }else{
                                                s.setBackground(Color.white);
                                                s.setText("");
                                            }
                                        }else{
                                            if("F".equals(s.getText())){
                                                s.setBackground(Color.white);
                                                s.setText("");
                                                flagFinal = false;
                                                VentanaPrincipal.this.visibleConfigPoliticas(flagFinal);
                                            }
                                        }
                                    }  
                            }
                        }
                    }
                    s.repaint();
                }});
            
        }
    
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

        jRadioButton1 = new javax.swing.JRadioButton();
        jpSuperior = new javax.swing.JPanel();
        jlConfig = new javax.swing.JLabel();
        jlDim = new javax.swing.JLabel();
        jcbDim = new javax.swing.JComboBox();
        jlManOAlea = new javax.swing.JLabel();
        jrbAuto = new javax.swing.JRadioButton();
        jrbManual = new javax.swing.JRadioButton();
        jbGenerarTablero = new javax.swing.JButton();
        jlConfigPoliticas = new javax.swing.JLabel();
        jlPolitica = new javax.swing.JLabel();
        jlEpsilon = new javax.swing.JLabel();
        jtfEpsTau = new javax.swing.JTextField();
        jlTau = new javax.swing.JLabel();
        jrbSoftMax = new javax.swing.JRadioButton();
        jrbEGreedy = new javax.swing.JRadioButton();
        jlAusenciaEstadoFinal = new javax.swing.JLabel();
        jpTablero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jBEntrena = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBAvanza = new javax.swing.JButton();
        jLabelItera = new javax.swing.JLabel();
        jLabelDiferencia = new javax.swing.JLabel();
        jLabelContador = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Princial");
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlConfig.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlConfig.setText("Creación del escenario:");
        jpSuperior.add(jlConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));

        jlDim.setText("Dimensión:");
        jpSuperior.add(jlDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jcbDim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6x6", "7x7", "8x8", "9x9", "10x10" }));
        jcbDim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDimActionPerformed(evt);
            }
        });
        jpSuperior.add(jcbDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jlManOAlea.setText("Creación:");
        jpSuperior.add(jlManOAlea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jrbAuto.setText("Automática");
        jrbAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAutoActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jrbManual.setText("Manual");
        jrbManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbManualActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jbGenerarTablero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbGenerarTablero.setText("Generar escenario");
        jbGenerarTablero.setEnabled(false);
        jbGenerarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarTableroActionPerformed(evt);
            }
        });
        jpSuperior.add(jbGenerarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 54));

        jlConfigPoliticas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlConfigPoliticas.setText("Configuración de la Política:");
        jpSuperior.add(jlConfigPoliticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, 20));

        jlPolitica.setText("Política: ");
        jpSuperior.add(jlPolitica, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jlEpsilon.setText("Epsilon:");
        jlEpsilon.setName(""); // NOI18N
        jpSuperior.add(jlEpsilon, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        jtfEpsTau.setText("0.1");
        jpSuperior.add(jtfEpsTau, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 40, -1));

        jlTau.setText("Tau: ");
        jlTau.setName(""); // NOI18N
        jpSuperior.add(jlTau, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 70, -1));

        jrbSoftMax.setText("SoftMax");
        jrbSoftMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbSoftMaxMouseClicked(evt);
            }
        });
        jpSuperior.add(jrbSoftMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jrbEGreedy.setText("E-Greedy");
        jrbEGreedy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbEGreedyMouseClicked(evt);
            }
        });
        jrbEGreedy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEGreedyActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbEGreedy, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jlAusenciaEstadoFinal.setText("*Advertencia: El escenario no tiene un estado \"Final\"");
        jpSuperior.add(jlAusenciaEstadoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        getContentPane().add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 140));

        jpTablero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTablero.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jpTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 450, 450));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, -1));

        jBEntrena.setText("Entrenar");
        jBEntrena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrenaActionPerformed(evt);
            }
        });
        jPanel1.add(jBEntrena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 50));

        jLabel1.setText("Ciclos de entrenamiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 40));

        jBAvanza.setText("Avanzar");
        jBAvanza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAvanzaActionPerformed(evt);
            }
        });
        jPanel1.add(jBAvanza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 90, 50));

        jLabelItera.setText("Iteraciones Realizadas");
        jPanel1.add(jLabelItera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel1.add(jLabelDiferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, 30));
        jLabelDiferencia.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jLabelContador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 200, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public final void visibleConfigPoliticas(Boolean visible){
        jlConfigPoliticas.setVisible(visible);
        jlPolitica.setVisible(visible);
        jtfEpsTau.setVisible(visible);
        jrbEGreedy.setVisible(visible);
        jrbSoftMax.setVisible(visible);
    }
    private void jbGenerarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarTableroActionPerformed

        //
        
        if(jrbAuto.isSelected()){
        String aux = (String)jcbDim.getSelectedItem();
        switch(aux){
            case "6x6":this.cargarTableroAleatorio(6);
                break;
            case "7x7":this.cargarTableroAleatorio(7);
                break;
            case "8x8":this.cargarTableroAleatorio(8);
                break;
            case "9x9":this.cargarTableroAleatorio(9);
                break;
            case "10x10":this.cargarTableroAleatorio(10);
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

    private void jcbDimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDimActionPerformed

    private void jrbEGreedyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbEGreedyMouseClicked

        jtfEpsTau.setVisible(true);
        jlEpsilon.setVisible(true);
        jlTau.setVisible(false);
        jrbEGreedy.setSelected(true);
        jrbSoftMax.setSelected(false);
        
    }//GEN-LAST:event_jrbEGreedyMouseClicked

    private void jrbSoftMaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbSoftMaxMouseClicked

        jtfEpsTau.setVisible(true);
        jlTau.setVisible(true);
        jlEpsilon.setVisible(false);
        jrbSoftMax.setSelected(true);
        jrbEGreedy.setSelected(false);
    }//GEN-LAST:event_jrbSoftMaxMouseClicked

    private void jBEntrenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrenaActionPerformed
        
        RMat mat= this.obtenerRdesdePantalla();
        
        Configuraciones.setInicial(0,0);

        mat.setInicial(Configuraciones.filaI, Configuraciones.colI);
        mat.setFinal(Configuraciones.filaF, Configuraciones.colF);
        mat.imprimirTab(); 

        QMat matrizQ= new QMat(mat);
        System.out.println(matrizQ);

//        if (jrbEGreedy.isSelected()){
//            PoliticaEGreedy politica= new PoliticaEGreedy();
//            double e = Double.parseDouble(jtfEpsTau.getText());
//            Configuraciones.setEpsilon(e);
//        }
//        if (jrbSoftMax.isSelected()){
            PoliticaSoftMax politica= new PoliticaSoftMax();
//            double t = Double.parseDouble(jtfEpsTau.getText());
//            Configuraciones.setTau(t);
//        }
       
        Estado estadoFinal= matrizQ.getEstado(Configuraciones.getFilaF(),Configuraciones.getColF());
        System.out.println("Estado final");
        System.out.println(estadoFinal);
        Entrenador.entrenar(Configuraciones.cantEpisodios, matrizQ, estadoFinal, politica, mat);
        
    }//GEN-LAST:event_jBEntrenaActionPerformed

    private void jBAvanzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAvanzaActionPerformed
        //recorriendo para ver mejor camino
        QMat matrizQ = Entrenador.getEpisodios()[Configuraciones.cantEpisodios-1].getMatrizQ();
        Estado estadoInicial= matrizQ.getEstado(Configuraciones.getFilaI(),Configuraciones.getColI());
        Estado estadoFinal= matrizQ.getEstado(Configuraciones.getFilaF(),Configuraciones.getColF());
        System.out.println(estadoInicial);
        System.out.println("Movimientos:");

        
        //habilitar el estado inical
        int ind= (estadoInicial.getPosI()*Configuraciones.getDimension() ) +estadoInicial.getPosJ();
        JButton botonInicial = (JButton) jpTablero.getComponent(ind);
        botonInicial.setBorder(BorderFactory.createLineBorder(Color.magenta,4));
        
        //mientras estado actual distinto de estado final
        while(! estadoInicial.equals(estadoFinal)){
                
              Estado estadoProximo = estadoInicial.accionDeMaximoValor().getEstadoDestino();
              System.out.println(estadoProximo);
              int indice= (estadoProximo.getPosI()*Configuraciones.getDimension() ) +estadoProximo.getPosJ();
              JButton boton = (JButton) jpTablero.getComponent(indice);
              boton.setBorder(BorderFactory.createLineBorder(Color.magenta,4));
              estadoInicial= estadoProximo;
        }
        
    }//GEN-LAST:event_jBAvanzaActionPerformed
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jrbEGreedyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEGreedyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbEGreedyActionPerformed

    private RMat obtenerRdesdePantalla(){
        int dimension= 0;
        String aux = (String)jcbDim.getSelectedItem();
        switch(aux){
            case "6x6":dimension= 6;
                break;
            case "7x7":dimension= 7;
                break;
            case "8x8":dimension= 8;
                break;
            case "9x9":dimension= 9;
                break;
            case "10x10":dimension=10;
                break;
        }    
        Configuraciones.setDimension(dimension);
        
        RMat matR= new RMat(Configuraciones.getDimension());
        
        for(int i=0;i<matR.dimension;i++){
            for(int j=0;j<matR.dimension;j++){
                int indice=(i*matR.dimension) + j;
                Component componente= jpTablero.getComponent(indice);
                if(componente.getClass()==JButton.class){
                JButton boton= (JButton) componente;
                String txt= boton.getText();
                Color fondo= boton.getBackground();
                
                if(txt.equalsIgnoreCase("Malo") || txt.equalsIgnoreCase("M")){
                    matR.mat[i][j]=Configuraciones.getValorMalo();
                }
               
                if(txt == "Bueno" || txt == "B"){
                    matR.mat[i][j]=Configuraciones.getValorBueno();
                }
                if(txt == "Excelente" || txt == "E"){
                    matR.mat[i][j]=Configuraciones.getValorExcelente();
                }
                if(txt == "Malo" || txt == "M"){
                    matR.mat[i][j]=Configuraciones.getValorMalo();
                }
                if(fondo == Color.WHITE){
                    matR.mat[i][j]=Configuraciones.getValorNeutro();
                }
                
                if(fondo == Color.BLACK){
                    matR.mat[i][j]=Configuraciones.getValorPared();
                }
                
                if(txt== "FINAL" || txt=="F"){
                    matR.mat[i][j]=Configuraciones.getValorFinal();
                    Configuraciones.setFinal(i,j);
                }

                }
            }
        }
        return matR;
    }
    
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
    private javax.swing.JButton jBAvanza;
    private javax.swing.JButton jBEntrena;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabelContador;
    public static javax.swing.JLabel jLabelDiferencia;
    private javax.swing.JLabel jLabelItera;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbGenerarTablero;
    private javax.swing.JComboBox jcbDim;
    private javax.swing.JLabel jlAusenciaEstadoFinal;
    private javax.swing.JLabel jlConfig;
    private javax.swing.JLabel jlConfigPoliticas;
    private javax.swing.JLabel jlDim;
    private javax.swing.JLabel jlEpsilon;
    private javax.swing.JLabel jlManOAlea;
    private javax.swing.JLabel jlPolitica;
    private javax.swing.JLabel jlTau;
    private javax.swing.JPanel jpSuperior;
    private javax.swing.JPanel jpTablero;
    private javax.swing.JRadioButton jrbAuto;
    private javax.swing.JRadioButton jrbEGreedy;
    private javax.swing.JRadioButton jrbManual;
    private javax.swing.JRadioButton jrbSoftMax;
    private javax.swing.JTextField jtfEpsTau;
    // End of variables declaration//GEN-END:variables
}
