/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Configuraciones {
    //valores por defecto a utilizar
    private static double gamma = 0.4;
    private static double ValorNeutro=0.3;
    private static double valorPared= -1;
    private static double valorMalo = 0.1;
    private static double valorBueno= 0.5;
    private static double valorExcelente = 1;
    private static double valorFinal = 1000;
    private static int dimension; 
    private static int valorPorDefectoMatQ= 100;//valor "optimo" para que no entre en bucle con EGreedy
    public static int filaI=0;
    public static int filaF=0;
    public static int colI;
    public static int colF;
    public static int cantEpisodios= 750;
    public static double epsilon=0.2;
    public static double tau=50;
    
    public static boolean flagEvEstadoInicial = false;
    public static boolean flagEInicialSeleccionado = false;
    
    public static boolean getFlagEInicialSeleccionado(){
        return flagEInicialSeleccionado;
    }
    
    public static void setFlagEInicialSeleccionado(boolean flag){
        flagEInicialSeleccionado = flag;
    }
    
    public static boolean getFlagEvEstadoInicial(){
        return flagEvEstadoInicial;
    }
    
    public static void setEvEstadoInicial(boolean flag){
        flagEvEstadoInicial = flag;
    }
    
    public static int getFilaI() {
        return filaI;
    }

    public static int getFilaF() {
        return filaF;
    }

    public static int getColI() {
        return colI;
    }

    public static int getColF() {
        return colF;
    }
    
    
    public static double getGamma() {
        return gamma;
    }

    public static double getValorNeutro() {
        return ValorNeutro;
    }
    
    
    public static double getValorPared(){
        return valorPared;
    }

    public static int getDimension() {
        return dimension;
    }  

   public static double getValorMalo() {
        return valorMalo;
    }

    public static double getValorBueno() {
        return valorBueno;
    }

    public static double getValorExcelente() {
        return valorExcelente;
    }

    public static int getCantEpisodios() {
        return cantEpisodios;
    }

    public static double getEpsilon() {
        return epsilon;
    }
    public static double getValorFinal() {
        return valorFinal;
    }

    public static void setValorFinal(double valorFinal) {
        Configuraciones.valorFinal = valorFinal;
    }
    
    public static void setEpsilon(double epsilon) {
        Configuraciones.epsilon = epsilon;
    }

    public static double getTau() {
        return tau;
    }

    public static void setTau(double tau) {
        Configuraciones.tau = tau;
    }

    public static void setFilaI(int filaI) {
        Configuraciones.filaI = filaI;
    }

    public static void setFilaF(int filaF) {
        Configuraciones.filaF = filaF;
    }

    public static void setColI(int colI) {
        Configuraciones.colI = colI;
    }

    public static void setColF(int colF) {
        Configuraciones.colF = colF;
    }

    public static void setCantEpisodios(int cantEpisodios) {
        Configuraciones.cantEpisodios = cantEpisodios;
    }

    
    public static void setInicial(int fila, int col){
    filaI=fila;
    colI=col;
    
}

    public static void setFinal(int fila, int col){
    filaF=fila;
    colF=col;
    }
    
    public static void setDimension(int dim) {
        if (dim<6){
        Configuraciones.dimension = 6;    
        }
        else if (dim<11){
            Configuraciones.dimension = dim;
        }
    }
    
    public static void setGamma(double valorGamma){
        Configuraciones.gamma = valorGamma;
    }
    
    public static void setValorPared(double valorPared) {
        if (valorPared <0){
        Configuraciones.valorPared = valorPared;
        }  
        else{
            Configuraciones.valorPared = valorPared*-1;
        }
    }

    public static void setValorMalo(double valorMalo) {
        Configuraciones.valorMalo = valorMalo;
    }

    public static void setValorBueno(double valorBueno) {
        Configuraciones.valorBueno = valorBueno;
    }

    public static void setValorExcelente(double valorExcelente) {
        Configuraciones.valorExcelente = valorExcelente;
    }

    public static void setValorNeutro(double ValorNeutro) {
        Configuraciones.ValorNeutro = ValorNeutro;
    }

    /**
     * @return the valorPorDefectoMatQ
     */
    public static int getValorPorDefectoMatQ() {
        return valorPorDefectoMatQ;
    }

    /**
     * @param aValorPorDefectoMatQ the valorPorDefectoMatQ to set
     */
    public static void setValorPorDefectoMatQ(int aValorPorDefectoMatQ) {
        valorPorDefectoMatQ = aValorPorDefectoMatQ;
    }

   
    
    
}
