/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JTextField;

/**
 *
 * @author Leandro
 */
public class Configuraciones {
    
    private static double gamma = 0.8;
    private static double ValorNeutro= 0.30;
    private static double valorPared= -1;
    private static double valorMalo = 0.15;
    private static double valorBueno= 0.60;
    private static double valorExcelente = 1;
    private static double valorFinal = 1000;
    private static int dimension = 3; 
    private static int valorPorDefectoMatQ= 0;
    public static int filaI;
    public static int filaF;
    public static int colI;
    public static int colF;
    public static int cantEpisodios= 750;
    public static double epsilon=0.1;
    public static double tau=50;
    
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
        Configuraciones.dimension = 6;    //cambiar por 6
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
