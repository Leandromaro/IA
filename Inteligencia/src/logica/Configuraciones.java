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
    
    private static double gamma = 0.8;
    private static double ValorNeutro= 0;
    private static double valorPared= -1;
    private static double valorMalo = 0.2;
    private static double valorBueno= 0.8;
    private static double valorExcelente = 1.0;
    private static int dimension = 6; 

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

    public static void setDimension(int dim) {
        Configuraciones.dimension = dim;
    }
    public static void setGamma(double valorGamma){
        Configuraciones.gamma = valorGamma;
    }
    
    public static void setValorPared(double valorPared) {
        Configuraciones.valorPared = valorPared;
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

    
    
}
