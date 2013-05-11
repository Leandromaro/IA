package logica;

/**
 *
 * @author Leandro
 */
public class MatrizR {

    private double[][][] recompensas;

    public MatrizR(int dimension) {
        recompensas = new double[dimension][dimension][8];
    }

    public MatrizR() {
    }

    public double[][][] getRecompensas() {
        return recompensas;
    }

    public double getRecompensa(int x, int y, int z) {
        return recompensas[x][y][z];
    }
    
    public void setRecompensas(int x) {
        this.recompensas = new double [x][x][8];
    }

    public double[][][] cero() {
       
        for (int i = 0; i < recompensas.length; i++) {
            for (int j = 0; j < recompensas[i].length; j++) {
                for (int k = 0; k < 8; k++) {
                    recompensas[i][j][k] = 0;
                }
            }
        }
    return recompensas;
    }
public void imprimirR(){
            for (int i=0; i < recompensas.length; i++) {
                //System.out.println(i);
                //System.out.println("");
                for (int j=0; j < recompensas[i].length; j++) {
                    for (int k=0;k<8; k++){
                    System.out.print(recompensas[i][j][k]+"\t");
                    } 
                    }
                  System.out.println("");
            }
        }

    public void generarR() {
        for (int i = 0; i < recompensas.length; i++) {
           for (int j = 0; j < recompensas[i].length; j++) {
                for (int k = 0; k < 8; k++) {
                    Estados f;
                    f= new Estados();
                    recompensas[i][j][k] = f.estadoA();
                }
            }
        }
        for (int i = 0; i < recompensas.length; i++) {

            for (int j = 0; j < recompensas[i].length; j++) {
                for (int k = 0; k < 8; k++) {
                    System.out.print(recompensas[i][j][k] + "\t");
                }
            }
            System.out.println("");
        }
    }
}
