/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import logica.Configuraciones;
import logica.Episodio;
import static logica.Episodio.bloqueo;
import logica.Estado;
import logica.Politica;
import logica.PoliticaEGreedy;
import logica.PoliticaSoftMax;
import logica.QMat;
import logica.RMat;
/**
 *
 * @author Maty
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    public static Boolean estadoFinal =false;
    public static Boolean estadoInicial =false;
    private Border blackline;
    private Boolean flagFinal;
    private Boolean flagInicial;
    private static Politica p;
    private int contadorEpisodios;
    public static boolean banderaTope=false;
//    blackline = BorderFactory.createLineBorder(Color.black);
    
    private ColoresyFormas cf = new ColoresyFormas();
    
    EvJBGrande ma  = new EvJBGrande();
    EvJBChico  ma1 = new EvJBChico();
    public static boolean banderaEGreedy;
    public static boolean banderaSoftMax;

    public void setFlagInicial(Boolean flagInicial) {
        this.flagInicial = flagInicial;
    }
   
    
    
    private Episodio[] episodios;
    
     public void iniciarEntrenamiento(){
         
        try{   
            final SwingWorker iniciarEntrenamiento;
            iniciarEntrenamiento = new SwingWorker(){
        @Override
        protected Object doInBackground() throws Exception {


          contadorEpisodios=0;
          jLabelContador.setText(String.valueOf(contadorEpisodios));

          RMat mat= obtenerRdesdePantalla();

          mat.setInicial(Configuraciones.filaI, Configuraciones.colI);
          mat.setFinal(Configuraciones.filaF, Configuraciones.colF);
          mat.imprimirTab(); 

          QMat matrizQ= new QMat(mat);
          System.out.println(matrizQ);
          //ProgressBar p =new ProgressBar();

          Estado estadoFinal= matrizQ.getEstado(Configuraciones.getFilaF(),Configuraciones.getColF());
          System.out.println("Estado final");
          System.out.println(estadoFinal);
          episodios= new Episodio[Configuraciones.cantEpisodios];
          int cont=0;
          int TopeEpisodios=2000;
          if(Integer.parseInt(jTextCantidadEpisodios.getText().trim())>2000){
              TopeEpisodios=Integer.parseInt(jTextCantidadEpisodios.getText().trim());
          } 
          
          while((contadorEpisodios<Configuraciones.cantEpisodios)&&(cont<TopeEpisodios)){
              episodios[contadorEpisodios]= new Episodio(matrizQ,estadoFinal,p,mat,contadorEpisodios);
              contadorEpisodios++;
              jLabelContador.setText(String.valueOf(contadorEpisodios));
              cont++;
          }
          if(cont==TopeEpisodios){
              JFrame j=new JFrame();
              JOptionPane.showMessageDialog(j,"Estoy ACA","Error",JOptionPane.WARNING_MESSAGE);
          }
          System.out.println(episodios[Configuraciones.cantEpisodios-1].getMatrizQ()); 
          jBAvanza.setEnabled(true);
            throw new UnsupportedOperationException("Not supported yet.");
            }

        };

        iniciarEntrenamiento.execute();

        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Error" , e.toString(), 1);
        }
    }
    
    public VentanaPrincipal() {
        initComponents();
        VentanaPrincipal.vistaConfigPoliticas(false);
        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
        jPanel1.setVisible(false);
        jCEpsilon.setVisible(false);
        jCTau.setVisible(false);
    }
    
   
    public void cargarTableroManual(int dim){
        jpTablero.setVisible(false);
        jpTablero.removeAll();
        jpTablero.setLayout(new GridLayout(dim,dim));
          
        blackline = BorderFactory.createLineBorder(Color.black);
        
        VentanaPrincipal.estadoFinal = false;
        VentanaPrincipal.estadoInicial=false;
        VentanaPrincipal.vistaConfigPoliticas(false);
        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(true);
         
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                
                JButton jbEstado = new JButton();
                //jbEstado.setBorder(blackline);
                jbEstado.setFont(cf.font);
                jbEstado.setBackground(Color.white);
                
                if (dim < 8){
                    
                    jbEstado.addMouseWheelListener(new MouseAdapter(){
                        public void mouseWheelMoved(MouseWheelEvent e){
                            
                           ma.setjbEstado(e);
                           ma.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            
                            ma.setjbEstado(e);
                            ma.getjbEstado().repaint();
                        }
                    }); 
                    
                }else{
                    jbEstado.addMouseWheelListener(new MouseAdapter(){
                        public void mouseWheelMoved(MouseWheelEvent e){
                            
                           ma1.setjbEstado(e);
                           ma1.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            
                            ma1.setjbEstado(e);
                            ma1.getjbEstado().repaint();
                        }
                    }); 
                    
                }
                
                jpTablero.add(jbEstado);           
            }
        }
        jpTablero.setVisible(true);       
        }

    public void cargarTableroAleatorio(int dim){
        //instanciar matriz, aleatoriament, y modificar codigo para que tome valores de esa matriz
       
        jpTablero.setVisible(false);
        jpTablero.removeAll();
        jpTablero.setLayout(new GridLayout(dim,dim));
        
        blackline = BorderFactory.createLineBorder(Color.black);
        
        VentanaPrincipal.estadoFinal = true;
        VentanaPrincipal.estadoInicial=true;
        VentanaPrincipal.vistaConfigPoliticas(true);
        VentanaPrincipal.jlAusenciaEstadoFinal.setVisible(false);
                
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                
                JButton jbEstado = new JButton();
                //jbEstado.setBorder(blackline);
                jbEstado.setFont(cf.font);
                //cargar el background y el tex en base a lo que tiene la matriz r
                
                //if(matR[i][j]==Configuraciones.Pared){
                //jbEstado.setBackground(Color.black);
               
   
                if (dim < 8){
                    switch(this.aleatorio(1, 5)){
                    
                        case 1: jbEstado.setBackground(Color.white);
                            break;
                        case 2: jbEstado.setBackground(Color.black);
                            break;
                        case 3:jbEstado.setBackground(cf.rojo);
                            jbEstado.setText("Malo");
                            break;
                        case 4: jbEstado.setBackground(cf.amarillo);
                            jbEstado.setText("Bueno");
                            break;
                        case 5: jbEstado.setBackground(cf.verde);
                            jbEstado.setText("Excelente");
                            break;
                        default: //jbEstado.setBackground(Color.red);
                            jbEstado.setText("OTRO");
                            break;
                    }
                    
                    jbEstado.addMouseWheelListener(new MouseAdapter(){
                        public void mouseWheelMoved(MouseWheelEvent e){
                            
                           ma.setflagFinal(flagFinal);
                           ma.setjbEstado(e);
                           flagFinal = ma.getflagFinal();
                           ma.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            ma.setflagFinal(flagFinal);
                            ma.setjbEstado(e);
                            flagFinal = ma.getflagFinal();
                            ma.getjbEstado().repaint();
                        }
                    }); 
                    
                }else{
                    switch(this.aleatorio(1, 5)){
                    
                        case 1: jbEstado.setBackground(Color.white);
                            break;
                        case 2: jbEstado.setBackground(Color.black);
                            break;
                        case 3: jbEstado.setBackground(cf.rojo);
                            jbEstado.setText("M");
                            break;
                        case 4: jbEstado.setBackground(cf.amarillo);
                            jbEstado.setText("B");
                            break;
                        case 5: jbEstado.setBackground(cf.verde);
                            jbEstado.setText("E");
                            break;
                        default: //jbEstado.setBackground(Color.red);
                            jbEstado.setText("OTRO");
                            break;
                    }
                        
                    jbEstado.addMouseWheelListener(new MouseAdapter(){
                        public void mouseWheelMoved(MouseWheelEvent e){

                           ma1.setflagFinal(flagFinal);
                           ma1.setjbEstado(e);
                           flagFinal = ma1.getflagFinal();
                           ma1.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            ma1.setflagFinal(flagFinal);    
                            ma1.setjbEstado(e);
                            flagFinal = ma1.getflagFinal();
                            ma1.getjbEstado().repaint();
                        }
                    });                     
            }
            jpTablero.add(jbEstado);
            
        }
        }    
//        Se agrega Estado Final
        jpTablero.remove(this.posAbosAleatoria(dim));
        jpTablero.add(this.estadoFinal(dim), this.posAbosAleatoria(dim));
 //        Se agrega Estado Inicial
        jpTablero.remove(this.posAbosAleatoria(dim));
        jpTablero.add(this.estadoInicial(dim), this.posAbosAleatoria(dim));
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
        jbEstado.setFont(cf.font);
        jbEstado.setBackground(Color.GREEN);
    
        
        flagFinal = true;
        ma.setflagFinal(true);
        ma1.setflagFinal(true);
        
        if(dim < 8){
            jbEstado.setText("FINAL");
            jbEstado.setBackground(Color.GREEN);
            jbEstado.addMouseWheelListener(new MouseAdapter(){
                    public void mouseWheelMoved(MouseWheelEvent e){
                           ma.setflagFinal(flagFinal);             
                           ma.setjbEstado(e);
                           flagFinal = ma.getflagFinal();
                           ma.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){

                            ma.setflagFinal(flagFinal);
                            ma.setjbEstado(e);
                            flagFinal = ma.getflagFinal();
                            
                            ma.getjbEstado().repaint();
                        }
                    }); 
        }
        else{
            jbEstado.setText("F");
            jbEstado.setBackground(Color.GREEN);
            jbEstado.addMouseWheelListener(new MouseAdapter(){
                        public void mouseWheelMoved(MouseWheelEvent e){
                            
                           ma1.setflagFinal(flagFinal);
                           ma1.setjbEstado(e);
                           flagFinal = ma1.getflagFinal();
                           ma1.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            
                            ma1.setflagFinal(flagFinal);
                            ma1.setjbEstado(e);
                            flagFinal = ma1.getflagFinal();
                            ma1.getjbEstado().repaint();
                        }
                    }); 
            
        }
    
        jbEstado.repaint();
        return jbEstado;     
    }
    
    public JButton estadoInicial(int dim){
        blackline = BorderFactory.createLineBorder(Color.black);
 
        JButton jbEstado = new JButton();
        //jbEstado.setBorder(blackline);
        jbEstado.setFont(cf.font);
        jbEstado.setBackground(Color.ORANGE);
    
        
        flagInicial = true;
        
        ma.setFlagInicial(true);
        ma1.setflagFinal(true);
        
        if(dim < 8){
            jbEstado.setText("INICIAL");
            jbEstado.setBackground(Color.ORANGE);
            jbEstado.addMouseWheelListener(new MouseAdapter(){
                    public void mouseWheelMoved(MouseWheelEvent e){
                           ma.setflagFinal(flagInicial);             
                           ma.setjbEstado(e);
                           flagInicial = ma.getFlagInicial();
                           ma.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){

                            ma.setflagFinal(flagFinal);
                            ma.setjbEstado(e);
                            flagFinal = ma.getFlagInicial();
                            
                            ma.getjbEstado().repaint();
                        }
                    }); 
        }
        else{
            jbEstado.setText("I");
            jbEstado.setBackground(Color.ORANGE);
            jbEstado.addMouseWheelListener(new MouseAdapter(){
                        public void mouseWheelMoved(MouseWheelEvent e){
                            
                           ma.setflagFinal(flagInicial);             
                           ma.setjbEstado(e);
                           flagInicial = ma.getFlagInicial();
                           ma.getjbEstado().repaint();
                        }
                    });
//                  
                    jbEstado.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            
                           ma.setflagFinal(flagInicial);             
                           ma.setjbEstado(e);
                           flagInicial = ma.getFlagInicial();
                           ma.getjbEstado().repaint();
                        }
                    }); 
            
        }
    
        jbEstado.repaint();
        return jbEstado;     
    }
    
    public static void vistaConfigPoliticas(Boolean flag){
        
        jlConfigPoliticas.setVisible(flag);
        jlPolitica.setVisible(flag);
        jlEpsilon.setVisible(flag);
        jlTau.setVisible(false); //Porque arranca EGreedy por defecto
//        jtfEpsTau.setVisible(flag);
        jrbEGreedy.setVisible(flag);
        jrbSoftMax.setVisible(flag);
        jbConfirmar.setVisible(flag);
        
        
        jrbEGreedy.setSelected(true);
        jrbSoftMax.setSelected(false);
        
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
        jrbSoftMax = new javax.swing.JRadioButton();
        jrbEGreedy = new javax.swing.JRadioButton();
        jlAusenciaEstadoFinal = new javax.swing.JLabel();
        jbConfirmar = new javax.swing.JButton();
        jlTau = new javax.swing.JLabel();
        jlEpsilon = new javax.swing.JLabel();
        jCEpsilon = new javax.swing.JComboBox();
        jCTau = new javax.swing.JComboBox();
        jpTablero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextCantidadEpisodios = new javax.swing.JTextField();
        jBEntrena = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBAvanza = new javax.swing.JButton();
        jLabelItera = new javax.swing.JLabel();
        jLabelContador = new javax.swing.JLabel();
        jBGrafica = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Princial");
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlConfig.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlConfig.setText("Creación del escenario:");
        jpSuperior.add(jlConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        jlDim.setText("Dimensión:");
        jpSuperior.add(jlDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jcbDim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6x6", "7x7", "8x8", "9x9", "10x10" }));
        jcbDim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDimActionPerformed(evt);
            }
        });
        jpSuperior.add(jcbDim, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jlManOAlea.setText("Creación:");
        jpSuperior.add(jlManOAlea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

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
        jbGenerarTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Accept32.png"))); // NOI18N
        jbGenerarTablero.setText("Generar escenario");
        jbGenerarTablero.setEnabled(false);
        jbGenerarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarTableroActionPerformed(evt);
            }
        });
        jpSuperior.add(jbGenerarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 54));

        jlConfigPoliticas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlConfigPoliticas.setText("Configuración de la Política:");
        jpSuperior.add(jlConfigPoliticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 200, 20));

        jlPolitica.setText("Política: ");
        jpSuperior.add(jlPolitica, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, 20));

        jrbSoftMax.setText("SoftMax");
        jrbSoftMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbSoftMaxMouseClicked(evt);
            }
        });
        jrbSoftMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSoftMaxActionPerformed(evt);
            }
        });
        jpSuperior.add(jrbSoftMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

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
        jpSuperior.add(jrbEGreedy, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, 20));

        jlAusenciaEstadoFinal.setText("*Advertencia: El escenario no tiene un estado \"Final\"");
        jpSuperior.add(jlAusenciaEstadoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 20));

        jbConfirmar.setText("Confirmar Escenario y Politicas");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });
        jpSuperior.add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 210, 120));

        jlTau.setText("Tau: ");
        jlTau.setName(""); // NOI18N
        jpSuperior.add(jlTau, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        jlEpsilon.setText("Epsilon:");
        jlEpsilon.setName(""); // NOI18N
        jpSuperior.add(jlEpsilon, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 20));

        jCEpsilon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0,1", "0,2", "0,3", "0,4", "0,5", "0,6", "0,7", "0,8", "0,9", " " }));
        jCEpsilon.setEnabled(false);
        jCEpsilon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEpsilonActionPerformed(evt);
            }
        });
        jpSuperior.add(jCEpsilon, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 100, 50, 30));

        jCTau.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", " " }));
        jCTau.setEnabled(false);
        jpSuperior.add(jCTau, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        getContentPane().add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 140));

        jpTablero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTablero.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jpTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 450, 450));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextCantidadEpisodios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextCantidadEpisodios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadEpisodiosActionPerformed(evt);
            }
        });
        jPanel1.add(jTextCantidadEpisodios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        jBEntrena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Fast-forward32.png"))); // NOI18N
        jBEntrena.setText("Entrenar");
        jBEntrena.setEnabled(false);
        jBEntrena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrenaActionPerformed(evt);
            }
        });
        jPanel1.add(jBEntrena, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 120, 50));

        jLabel1.setText("Ciclos de entrenamiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 40));

        jBAvanza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Font32.png"))); // NOI18N
        jBAvanza.setText("Avanzar");
        jBAvanza.setEnabled(false);
        jBAvanza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAvanzaActionPerformed(evt);
            }
        });
        jPanel1.add(jBAvanza, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, 50));

        jLabelItera.setText("Iteraciones Realizadas");
        jPanel1.add(jLabelItera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabelContador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabelContador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 30));

        jBGrafica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Line-chart32.png"))); // NOI18N
        jBGrafica.setText("Grafica");
        jBGrafica.setEnabled(false);
        jBGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGraficaActionPerformed(evt);
            }
        });
        jPanel1.add(jBGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 170, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public final void visibleConfigPoliticas(Boolean visible){
        jlConfigPoliticas.setVisible(visible);
        jlPolitica.setVisible(visible);
        
        jrbEGreedy.setVisible(visible);
        jrbSoftMax.setVisible(visible);
    }
    private void jbGenerarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarTableroActionPerformed
        jCEpsilon.setVisible(true);
        jCTau.setVisible(true);
        jBEntrena.setEnabled(false);
        jBAvanza.setEnabled(false);
        jTextCantidadEpisodios.setText("");
        jLabelContador.setText("");
        jCEpsilon.enable(true);
        if(jrbAuto.isSelected()){
        String aux = (String)jcbDim.getSelectedItem();
        switch(aux){
            case "6x6":this.cargarTableroAleatorio(6);
                jTextCantidadEpisodios.setText("750");
                break;
            case "7x7":this.cargarTableroAleatorio(7);
                jTextCantidadEpisodios.setText("1000");
                break;
            case "8x8":this.cargarTableroAleatorio(8);
                jTextCantidadEpisodios.setText("1250");
                break;
            case "9x9":this.cargarTableroAleatorio(9);
                jTextCantidadEpisodios.setText("1500");
                break;
            case "10x10":this.cargarTableroAleatorio(10);
                jTextCantidadEpisodios.setText("2000");
                break;
        }    
        
        }else{
            if(jrbManual.isSelected()){
               String aux = (String)jcbDim.getSelectedItem();
               switch(aux){
                    case "6x6":this.cargarTableroManual(6);
                    jTextCantidadEpisodios.setText("750");
                    break;
                case "7x7":this.cargarTableroManual(7);
                    jTextCantidadEpisodios.setText("1000");
                    break;
                case "8x8":this.cargarTableroManual(8);
                    jTextCantidadEpisodios.setText("1250");
                    break;
                case "9x9":this.cargarTableroManual(9);
                    jTextCantidadEpisodios.setText("1500");
                    break;
                case "10x10":this.cargarTableroManual(10);
                    jTextCantidadEpisodios.setText("2000");
                    break;
               }    
           
            }
            
        }
       jBEntrena.setEnabled(true); 
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

//        jtfEpsTau.setVisible(true);
        jlEpsilon.setVisible(true);
        jlTau.setVisible(false);
        jrbEGreedy.setSelected(true);
        jrbSoftMax.setSelected(false);
        
    }//GEN-LAST:event_jrbEGreedyMouseClicked

    private void jrbSoftMaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbSoftMaxMouseClicked

//        jtfEpsTau.setVisible(true);
        jlTau.setVisible(true);
        jlEpsilon.setVisible(false);
        jrbSoftMax.setSelected(true);
        jrbEGreedy.setSelected(false);
    }//GEN-LAST:event_jrbSoftMaxMouseClicked

    private void jBEntrenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrenaActionPerformed
        
        String userdata = jTextCantidadEpisodios.getText().trim();
        int val;
        
        try
        {
           val = Integer.parseInt(userdata);
        }
        catch (NumberFormatException nfe)
        {
           JOptionPane.showMessageDialog(this,"Valores Invalidos de Entenamiento, se cargará un numero de ciclos por default","Error",JOptionPane.WARNING_MESSAGE);
           jTextCantidadEpisodios.setText(Integer.toString(Configuraciones.cantEpisodios));
           val = Configuraciones.cantEpisodios;
        }
        Configuraciones.setCantEpisodios(val);
        
        
        if (banderaEGreedy==true){
            PoliticaEGreedy politica= new PoliticaEGreedy();
            p=politica;
            System.out.println("POLITICA EGREEDY");
            
        }
        else{
            PoliticaSoftMax politica= new PoliticaSoftMax();
            p=politica;
            
            System.out.println("POLITICA SOFTMAX");
            
        }
        
        iniciarEntrenamiento();//llama al hilo de entrenamiento
        jBEntrena.setEnabled(false);

    }//GEN-LAST:event_jBEntrenaActionPerformed

    private void jBAvanzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAvanzaActionPerformed
        //recorriendo para ver mejor camino
        QMat matrizQ = episodios[Configuraciones.cantEpisodios-1].getMatrizQ();
        Estado estadoInicial= matrizQ.getEstado(Configuraciones.getFilaI(),Configuraciones.getColI());
        Estado estadoFinal= matrizQ.getEstado(Configuraciones.getFilaF(),Configuraciones.getColF());
        System.out.println(estadoInicial);
        System.out.println("Movimientos:");

        
        //habilitar el estado inical
        int ind= (estadoInicial.getPosI()*Configuraciones.getDimension() ) +estadoInicial.getPosJ();
        JButton botonInicial = (JButton) jpTablero.getComponent(ind);
        botonInicial.setBorder(BorderFactory.createLineBorder(Color.magenta,4));
        
        //mientras estado actual distinto de estado final
        int cont=0;
        int x = Configuraciones.getDimension();
        int y = 5;
        int tope = (int) Math.pow(x, y);
        
        while(!estadoInicial.equals(estadoFinal)&&(cont<tope)){
                
              Estado estadoProximo = estadoInicial.accionDeMaximoValor().getEstadoDestino();
              System.out.println(estadoProximo);
              int indice= (estadoProximo.getPosI()*Configuraciones.getDimension() ) +estadoProximo.getPosJ();
              JButton boton = (JButton) jpTablero.getComponent(indice);
              boton.setBorder(BorderFactory.createLineBorder(Color.magenta,4));//cambia de color el camino
              estadoInicial= estadoProximo;
              cont++;
         }
        jBGrafica.setEnabled(true);
        jBAvanza.setEnabled(false);
        System.out.println(cont);
        if (cont==tope){
            if(jrbEGreedy.isSelected()){
                JOptionPane.showMessageDialog(this,"Agente Bloqueado o con poco entrenamiento, pruebe con un valor de Espsilon mayor, o con mayor numero de episodios","Error",JOptionPane.WARNING_MESSAGE);
            }
            else{
               JOptionPane.showMessageDialog(this,"Agente Bloqueado o con poco entrenamiento","Error",JOptionPane.WARNING_MESSAGE); 
            }
            
        }
    }//GEN-LAST:event_jBAvanzaActionPerformed
    private void jTextCantidadEpisodiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadEpisodiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadEpisodiosActionPerformed

    private void jrbEGreedyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEGreedyActionPerformed
        jCEpsilon.setEnabled(true);
        jlEpsilon.setEnabled(true);
        jCTau.setEnabled(false);
    }//GEN-LAST:event_jrbEGreedyActionPerformed

    private void jBGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGraficaActionPerformed
        //panelCorrida.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        LineChart grafico = new LineChart("Valores de matriz Q ",episodios);
        grafico.setSize(800, 600);
        grafico.setLocation(this.getLocation());
        grafico.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        grafico.setResizable(true);
        grafico.setVisible(true);
        
       // panelCorrida.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jBGraficaActionPerformed

    public void enabledJPSuperior(Boolean flag){
        jpSuperior.setEnabled(flag);
        jlConfig.setEnabled(flag);
        jrbAuto.setEnabled(flag);
        jrbManual.setEnabled(flag);
        jcbDim.setEnabled(flag);
        jlDim.setEnabled(flag);
        jlManOAlea.setEnabled(flag);
        jbGenerarTablero.setEnabled(flag);
        jlConfigPoliticas.setEnabled(flag);
        jlPolitica.setEnabled(flag);
        jCEpsilon.setEnabled(flag);;
        jrbEGreedy.setEnabled(flag);
        jrbSoftMax.setEnabled(flag);
        jbConfirmar.setEnabled(flag);
        jlTau.setEnabled(flag);
        jlEpsilon.setEnabled(flag);
    }
    
    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed

        jPanel1.setVisible(true);
        if (jrbEGreedy.isSelected()){
            banderaEGreedy=true;
        }
        else{
                 
        
            Configuraciones.setEpsilon(jCTau.getSelectedIndex());
        }
        if (banderaEGreedy){
            
            Configuraciones.setEpsilon(jCEpsilon.getSelectedIndex());
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jrbSoftMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSoftMaxActionPerformed
        jlTau.setVisible(true);
        jCTau.setEnabled(true);
        jCEpsilon.setEnabled(false);
        jrbEGreedy.setSelected(false);
    }//GEN-LAST:event_jrbSoftMaxActionPerformed

    private void jCEpsilonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEpsilonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCEpsilonActionPerformed

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
//        int indice=(Configuraciones.getFilaI()*matR.dimension) + Configuraciones.getColI();
//        if(JButton.getComponent(indice).getBackground().equals(BLACK)){
//        
//        }
        for(int i=0;i<matR.dimension;i++){
            for(int j=0;j<matR.dimension;j++){
                int indice=(i*matR.dimension) + j;
                Component componente= jpTablero.getComponent(indice);
                if(componente.getClass()==JButton.class){
                JButton boton= (JButton) componente;
                String txt= boton.getText();
                Color fondo= boton.getBackground();
                
                //cargo los valores a la matriz R dependiendo de de las letras o colores de los botones del tablero
                if(txt.equalsIgnoreCase("Malo") || txt.equalsIgnoreCase("M")){
                    matR.mat[i][j]=Configuraciones.getValorMalo();
                }
               
                if("Bueno".equals(txt) || "B".equals(txt)){
                    matR.mat[i][j]=Configuraciones.getValorBueno();
                }
                if("Excelente".equals(txt) || "E".equals(txt)){
                    matR.mat[i][j]=Configuraciones.getValorExcelente();
                }
                if("Malo".equals(txt) || "M".equals(txt)){
                    matR.mat[i][j]=Configuraciones.getValorMalo();
                }
                if(fondo == Color.WHITE){
                    matR.mat[i][j]=Configuraciones.getValorNeutro();
                }
                
                if(fondo == Color.BLACK){
                    matR.mat[i][j]=Configuraciones.getValorPared();
                }
                
                if("FINAL".equals(txt) || "F".equals(txt)){
                    matR.mat[i][j]=Configuraciones.getValorFinal();
                    Configuraciones.setFinal(i,j);
                }
                if("INICIAL".equals(txt) || "I".equals(txt)){
                    matR.mat[i][j]=Configuraciones.getValorNeutro();
                    Configuraciones.setInicial(i, j);
                    
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
    private javax.swing.JButton jBGrafica;
    private javax.swing.JComboBox jCEpsilon;
    private javax.swing.JComboBox jCTau;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabelContador;
    private javax.swing.JLabel jLabelItera;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTextCantidadEpisodios;
    public static javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbGenerarTablero;
    private javax.swing.JComboBox jcbDim;
    public static javax.swing.JLabel jlAusenciaEstadoFinal;
    private javax.swing.JLabel jlConfig;
    public static javax.swing.JLabel jlConfigPoliticas;
    private javax.swing.JLabel jlDim;
    public static javax.swing.JLabel jlEpsilon;
    private javax.swing.JLabel jlManOAlea;
    public static javax.swing.JLabel jlPolitica;
    public static javax.swing.JLabel jlTau;
    private javax.swing.JPanel jpSuperior;
    private javax.swing.JPanel jpTablero;
    private javax.swing.JRadioButton jrbAuto;
    public static javax.swing.JRadioButton jrbEGreedy;
    private javax.swing.JRadioButton jrbManual;
    public static javax.swing.JRadioButton jrbSoftMax;
    // End of variables declaration//GEN-END:variables
}
