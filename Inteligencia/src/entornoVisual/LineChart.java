package entornoVisual;

import java.awt.*;
import javax.swing.JDialog;
import logica.Episodio;
//import org.jfree.ui.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
//import org.jfree.chart.entity.*;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart extends JDialog implements ChartMouseListener {
private JFreeChart chart; 
private XYPlot plot;

private XYSeriesCollection coleccion = new XYSeriesCollection();
XYSeries valoresDeEpisodio = new XYSeries("Valor Q");

public LineChart(String title,Episodio[] episodios){
    super();
    
        //recorro y cargo el grafico
       coleccion.removeAllSeries();
        valoresDeEpisodio.clear();
        
        
        for (int i=0; i < episodios.length;i++){
            valoresDeEpisodio.add(i, episodios[i].valorQ);     
        }
        coleccion.addSeries(valoresDeEpisodio);
    
        this.chart = ChartFactory.createXYLineChart("Evolución de las Aptitudes","Generaciones","Aptitudes", 
        coleccion,
        PlotOrientation.VERTICAL,
        true,
        false,
        true             
        );
        
        this.plot = (XYPlot) chart.getPlot();
        this.plot.setNoDataMessage("No hay datos para mostrar por favor elija una generación distinta a 0");
        this.plot.setBackgroundAlpha(0.2f);
        this.plot.setBackgroundPaint(Color.WHITE); 
        setSeriesStyle(chart, 0, "line");
        setSeriesStyle(chart, 1, "line");
        setSeriesStyle(chart, 2, "line");
        setSeriesColor(chart,0,Color.GREEN);
        setSeriesColor(chart,1,Color.BLUE);
        setSeriesColor(chart,2,Color.RED);
        ChartPanel chartpanel = new ChartPanel(chart, false, true, true, true, true);   
        chartpanel.setVisible(true);
        chartpanel.addChartMouseListener(this);
        setContentPane(chartpanel);
}

@Override
public void chartMouseClicked(ChartMouseEvent event){
//    ChartEntity chartentity = event.getEntity();
//    if (chartentity != null){
//        XYItemEntity xyitem=(XYItemEntity) event.getEntity(); // get clicked entity
//        System.out.println(xyitem.getItem()+" item of "+xyitem.getSeriesIndex()+"series");
//        int indiceIndividuo=0;
//        Generacion generacion= GeneracionManager.getGeneracionNumero(xyitem.getItem());
//        if(xyitem.getSeriesIndex()==0){
//            indiceIndividuo= generacion.obtenerMejorIndividuo().getNroIndividuo();
//        }else{
//            if(xyitem.getSeriesIndex()==2){
//            indiceIndividuo= generacion.obtenerPeorIndividuo().getNroIndividuo();
//            }else{
//                return;
//            }
//        }
//        
//        VisorPoblacion ventanaPoblacion= new VisorPoblacion(xyitem.getItem(),GeneracionManager.getGeneraciones().size(),indiceIndividuo);
//        ventanaPoblacion.setSize(800, 600);
//        ventanaPoblacion.setLocation(this.getLocation());
//        ventanaPoblacion.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
//        ventanaPoblacion.setResizable(false);
//        ventanaPoblacion.setVisible(true);
//    }
}

    @Override
    public void chartMouseMoved(ChartMouseEvent event){
//        ChartEntity chartentity = event.getEntity();
//        if (chartentity.getClass()== XYItemEntity.class){
//            //mostrar tooltip
//            if (chartentity != null){
//                XYItemEntity xyitem=(XYItemEntity) event.getEntity();
//                if(xyitem.getSeriesIndex()==0 || xyitem.getSeriesIndex()==2){
//                     this.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                }
//            }
//        }
//        else{
//            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//        }
    }
    
        /** Line style: line */
    public static final String STYLE_LINE = "line";
    /** Line style: dashed */
    public static final String STYLE_DASH = "dash";
    /** Line style: dotted */
    public static final String STYLE_DOT = "dot";

    /**
    * Convert style string to stroke object.
    * 
    * @param style One of STYLE_xxx.
    * @return Stroke for <i>style</i> or null if style not supported.
    */
   private BasicStroke toStroke(String style) {
        BasicStroke result = null;
        
        if (style != null) {
            float lineWidth = 2f;
            float dash[] = {5.0f};
            float dot[] = {lineWidth};
    
            if (style.equalsIgnoreCase(STYLE_LINE)) {
                result = new BasicStroke(lineWidth);
            } else if (style.equalsIgnoreCase(STYLE_DASH)) {
                result = new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
            } else if (style.equalsIgnoreCase(STYLE_DOT)) {
                result = new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dot, 0.0f);
            }
        }
        
        return result;
    }

    /**
     * Set color of series.
     * 
     * @param chart JFreeChart.
     * @param seriesIndex Index of series to set color of (0 = first series)
     * @param style One of STYLE_xxx.
     */
    private void setSeriesStyle(JFreeChart chart, int seriesIndex, String style) {
        if (chart != null && style != null) {
            BasicStroke stroke = toStroke(style);
            
            Plot p = chart.getPlot();
            if (p instanceof CategoryPlot) {
                CategoryPlot categoryPlot = chart.getCategoryPlot();
                CategoryItemRenderer cir = categoryPlot.getRenderer();
                try {
                    cir.setSeriesStroke(seriesIndex, stroke); //series line style
                } catch (Exception e) {
                    System.err.println("Error setting style '"+style+"' for series '"+seriesIndex+"' of chart '"+chart+"': "+e);
                }
            } else if (p instanceof XYPlot) {
                XYPlot xyPlot = chart.getXYPlot();
                XYItemRenderer xyir = xyPlot.getRenderer();
//                xyir.setBaseToolTipGenerator(new CustomTooltipGenerator());
                try {
                    xyir.setSeriesStroke(seriesIndex, stroke); //series line style
                } catch (Exception e) {
                    System.err.println("Error setting style '"+style+"' for series '"+seriesIndex+"' of chart '"+chart+"': "+e);
                }
            } else {
                System.out.println("setSeriesColor() unsupported plot: "+p);
            }
        }
    }
    
        /**
    * Set color of series.
    * 
    * @param chart JFreeChart.
    * @param seriesIndex Index of series to set color of (0 = first series)
    * @param color New color to set.
    */
   private void setSeriesColor(JFreeChart chart, int seriesIndex, Color color) {
        if (chart != null) {
            Plot p = chart.getPlot();
            try {
                if (p instanceof CategoryPlot) {
                    CategoryPlot categoryPlot = chart.getCategoryPlot();
                    CategoryItemRenderer cir = categoryPlot.getRenderer();
                    cir.setSeriesPaint(seriesIndex, color);
                } else if (p instanceof PiePlot) {
                    PiePlot piePlot = (PiePlot) chart.getPlot();
                    piePlot.setSectionPaint(seriesIndex, color);
                } else if (p instanceof XYPlot) {
                    XYPlot xyPlot = chart.getXYPlot();
                    XYItemRenderer xyir = xyPlot.getRenderer();
                    xyir.setSeriesPaint(seriesIndex, color);
                } else {
                    System.out.println("setSeriesColor() unsupported plot: "+p);
                }
            } catch (Exception e) { //e.g. invalid seriesIndex
                System.err.println("Error setting color '"+color+"' for series '"+seriesIndex+"' of chart '"+chart+"': "+e);
            }
        }
    }
    
}

