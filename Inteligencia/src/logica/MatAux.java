package logica;

/**
 *
 * @author Leandro
 */
public class MatAux {
    private Estado[][] matAux;

    public MatAux(Estado[][] matAux) {
        this.matAux = matAux;
    }

    public MatAux(Tablero t) {
        this.matAux = new Estado [t.dimension][t.dimension];
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux[i].length; j++) {
                int a[];
                a = new int[] {i,j};
                Estado e;
                e=new Estado(t.getPos(i, j),a,[]);
//                e.valor=t.getPos(i, j);
//                e.setPosicionA(i, j);
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





   

