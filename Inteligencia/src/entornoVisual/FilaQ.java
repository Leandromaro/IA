/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

import logica.Accion;
import logica.Estado;

/**
 *
 * @author Leandro
 */
public class FilaQ {
    private String estado;
    private double valorAcc1=0;
    private double valorAcc2=0;
    private double valorAcc3=0;
    private double valorAcc4=0;
    private double valorAcc5=0;
    private double valorAcc6=0;
    private double valorAcc7=0;
    private double valorAcc8=0;

    public FilaQ(){
        this.estado= "estado de test";
    }
    
    public FilaQ(Estado estado){
        this.estado= estado.toString();
        
        int origenI= estado.getPosI();
        int origenJ= estado.getPosJ();
        
        Accion accionMax= estado.accionDeMaximoValor();
        
        for(Accion accion : estado.accionesPosibles){
           
           int destinoI= accion.getEstadoDestino().getPosI();
           int destinoJ= accion.getEstadoDestino().getPosJ(); 
           
//           if(accion.equals(accionMax)){
//               
//           }
           
           if(destinoI<origenI){
            //izquierda
               if(destinoJ<origenJ){
                   //izquierda arriba
                   valorAcc1= accion.getValor();
               }else if(destinoJ>origenJ){
                   //izquierda abajo
                   valorAcc3= accion.getValor();
               }else{
                   //izquierda centro
                   valorAcc2= accion.getValor();
               }
           }else if(destinoI>origenI){
               //derecha
               if(destinoJ<origenJ){
                   //derecha arriba
                   valorAcc7= accion.getValor();
               }else if(destinoJ>origenJ){
                   //derecha abajo
                   valorAcc5= accion.getValor();
               }else{
                   //derecha centro
                   valorAcc6= accion.getValor();
               }
           }else{
               //iguales
                if(destinoJ<origenJ){
                   //arriba
                   valorAcc8= accion.getValor();
               }else if(destinoJ>origenJ){
                   //abajo
                   valorAcc4= accion.getValor();
               }
           }           
        }
        
        
        //agregar logica para sacar valores de acciones del estado
    }    
    
    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the valorAcc1
     */
    public double getValorAcc1() {
        return valorAcc1;
    }

    /**
     * @param valorAcc1 the valorAcc1 to set
     */
    public void setValorAcc1(double valorAcc1) {
        this.valorAcc1 = valorAcc1;
    }

    /**
     * @return the valorAcc2
     */
    public double getValorAcc2() {
        return valorAcc2;
    }

    /**
     * @param valorAcc2 the valorAcc2 to set
     */
    public void setValorAcc2(double valorAcc2) {
        this.valorAcc2 = valorAcc2;
    }

    /**
     * @return the valorAcc3
     */
    public double getValorAcc3() {
        return valorAcc3;
    }

    /**
     * @param valorAcc3 the valorAcc3 to set
     */
    public void setValorAcc3(double valorAcc3) {
        this.valorAcc3 = valorAcc3;
    }

    /**
     * @return the valorAcc4
     */
    public double getValorAcc4() {
        return valorAcc4;
    }

    /**
     * @param valorAcc4 the valorAcc4 to set
     */
    public void setValorAcc4(double valorAcc4) {
        this.valorAcc4 = valorAcc4;
    }

    /**
     * @return the valorAcc5
     */
    public double getValorAcc5() {
        return valorAcc5;
    }

    /**
     * @param valorAcc5 the valorAcc5 to set
     */
    public void setValorAcc5(double valorAcc5) {
        this.valorAcc5 = valorAcc5;
    }

    /**
     * @return the valorAcc6
     */
    public double getValorAcc6() {
        return valorAcc6;
    }

    /**
     * @param valorAcc6 the valorAcc6 to set
     */
    public void setValorAcc6(double valorAcc6) {
        this.valorAcc6 = valorAcc6;
    }

    /**
     * @return the valorAcc7
     */
    public double getValorAcc7() {
        return valorAcc7;
    }

    /**
     * @param valorAcc7 the valorAcc7 to set
     */
    public void setValorAcc7(double valorAcc7) {
        this.valorAcc7 = valorAcc7;
    }

    /**
     * @return the valorAcc8
     */
    public double getValorAcc8() {
        return valorAcc8;
    }

    /**
     * @param valorAcc8 the valorAcc8 to set
     */
    public void setValorAcc8(double valorAcc8) {
        this.valorAcc8 = valorAcc8;
    }
}
