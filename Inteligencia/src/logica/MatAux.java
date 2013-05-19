package logica;

/**
 *
 * @author Leandro
 */
public class MatAux {
    private Estado[][] matAux;
    

    
    public MatAux(Tablero t) {
        this.matAux = new Estado [t.dimension][t.dimension];
        for (int i = 0; i < matAux.length; i++) {
                int xA;
                xA = 0;
                int yA;
                yA = 0;
                if (xA>t.dimension) {
                xA = 0;
                } 
                else if (xA<=t.dimension){
                xA=xA++;
                }
                if (yA>t.dimension) {
                yA =0;
                } 
                else if (yA<=t.dimension){
                yA=yA++;
                }
            for (int j = 0; j < matAux[i].length; j++) {
                int xR;
                xR = 0;
                int yR;
                yR = 0;
                int a[];
                a = new int[] {i,j};
                Estado e;
                e= new Estado();
                e.valor=t.getPos(i, j);
                e.setPosicionA(xA, yA);
                e.setPosicionR(xR, yR);
                
                if (xR>t.dimension) {
                xR = 0;
                } 
                else if (xR<=t.dimension){
                xR=xR++;
                }
                if (yR>t.dimension) {
                yR =0;
                } 
                else if (yR<=t.dimension){
                yR=yR++;
                }
                matAux[i][j] = e;
             
            }
        }
    }
 
    
    
    
    public void imprimirR(){
            for (int i=0; i < matAux.length; i++) {
                //System.out.println(i);
                //System.out.println("");
                for (int j=0; j < matAux[i].length; j++) {
                    System.out.print(matAux[i][j].getPosicionA()); 
                }
                  System.out.println("");
            }
        }
    
}





   

