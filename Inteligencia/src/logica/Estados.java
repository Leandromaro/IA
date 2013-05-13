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
    public double malo = 0.4;
    public double bueno = 0.8;
    public double excelente = 1;
    public double neutral = 0;
    public double noValido = -1;

    public Estados() {//constructor
    }
    //Inicio geters
    public String getMalo(double valor) {
        if ((valor >=0.4) && (valor <=0.79)){
        return "malo";
        }
        return "no es malo";
    }


    public String getBueno(double valor) {
        if ((valor >=0.8) && (valor <=0.99)){
        return "Bueno";
        }
        return "no es Bueno";

    }

    public String getExcelente(double valor) {
        if (valor == 1){
        return "Excelente";
        }
        return "no es Excelente";
    }

    public String getNoValido(double valor) {
      if (valor == -1){
        return "Estado Inaccesible";
        }
        return "no es Estado Inaccesible";
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
        if (aleatorio <=0.2) {
            aleatorio =-1;
        } 
        else if ((aleatorio >=0.2) && (aleatorio <=0.39)){
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
