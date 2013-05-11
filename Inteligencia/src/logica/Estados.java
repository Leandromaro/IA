/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Estados {
    public double malo = 0.2;
    public double bueno = 0.5;
    public double excelente = 0.8;
    public double neutral = 0;

    public Estados() {//constructor
    }
    //Inicio geters
    public String getMalo(double valor) {
        if (valor <=0.2){
        return "malo";
        }
        return "no es malo";
    }


    public String getBueno(double valor) {
        if ((valor >0.2)&&(valor <=0.5)){
        return "Bueno";
        }
        return "no es Bueno";

    }

    public String getExcelente(double valor) {
        if (valor >0.5){
        return "Excelente";
        }
        return "no es Excelente";
    }

    public String getNeutral(double valor) {
        if (valor ==0){
        return "Neutral";
        }
        return "No es neutral";
    }//Fin geters

    //Inicio seters
    public void setMalo(double malo) {
        this.malo = malo;
    }

    public void setBueno(double bueno) {
        this.bueno = bueno;
    }

    public void setExcelente(double excelente) {
        this.excelente = excelente;
    }


    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }//Fin seters
    
    public double estadoA(){
        double aleatorio;
        aleatorio = Math.random();
        if ((aleatorio >=0) && (aleatorio <=0.39)){
            aleatorio=0;
        }
        else if ((aleatorio >=0.4) && (aleatorio <=0.79)){
        aleatorio = 0.4;
        }
        else if ((aleatorio >=0.8) && (aleatorio <=0.99)){
        aleatorio = 0.8;
        }
        else {
            aleatorio = 1;}
        return aleatorio;
        }

        }
