/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Leandro
 */
public class Accion {
    private Estado estadoOrigen;
    private Estado estadoDestino;

    public Accion(Estado origen, Estado destino){
        this.estadoDestino= destino;
        this.estadoOrigen= origen;
    }
    
    
    @Override
    public String toString(){
        StringBuilder desc= new StringBuilder();
        desc.append(" A ");
        desc.append("ed:");
        desc.append(this.getEstadoDestino().toString());
        return desc.toString();
    }

    /**
     * @return the estadoOrigen
     */
    public Estado getEstadoOrigen() {
        return estadoOrigen;
    }

    /**
     * @param estadoOrigen the estadoOrigen to set
     */
    public void setEstadoOrigen(Estado estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }

    /**
     * @return the estadoDestino
     */
    public Estado getEstadoDestino() {
        return estadoDestino;
    }

    /**
     * @param estadoDestino the estadoDestino to set
     */
    public void setEstadoDestino(Estado estadoDestino) {
        this.estadoDestino = estadoDestino;
    }
    


}
