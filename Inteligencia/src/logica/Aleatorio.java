/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Aleatorio {
    public double aleatorio;
    public String tipoA;   

    public Aleatorio(double aleatorio, String tipoA) {
        this.aleatorio = aleatorio;
        this.tipoA = tipoA;
    }
    
    public double getAleatorio() {
        return aleatorio;
    }

    public String getTipoA() {
        if (aleatorio <=0.2) {
        tipoA ="Pared";
        } 
        else if ((aleatorio >=0.2) && (aleatorio <=0.49)){
        tipoA ="Malo";
        }
        else if ((aleatorio >=0.5) && (aleatorio <=0.79)){
        tipoA ="Bueno";
        }
        else{
        tipoA ="Excelente";
        }
        return tipoA;
        }
    

    public void setTipoA(String tipoA) {
        this.tipoA = tipoA;
    }
    
    public void setAleatorio(double aleatorio) {
        this.aleatorio = aleatorio;
    }

    
    public Aleatorio(){
        
        aleatorio = Math.random();
        
        if (aleatorio <=0.2) {
            aleatorio = Configuraciones.getValorPared();
        } 
        else if ((aleatorio >=0.2) && (aleatorio <=0.49)){
            aleatorio=Configuraciones.getValorMalo();
        }
        else if ((aleatorio >=0.5) && (aleatorio <=0.79)){
        aleatorio = Configuraciones.getValorBueno();
        }
        else {
        aleatorio = Configuraciones.getValorExcelente();
        }
    }
}