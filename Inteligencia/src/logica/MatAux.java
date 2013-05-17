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
            for (int j = 0; j < matAux[i].length; j++) {
                Estado e;
                e=new Estado();
                e.valor=t.getPos(i, j);
                matAux[i][j] = e;
                
            }
        }
    }

   
}
