/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoVisual;

import javax.swing.JFrame;

/**
 *
 * @author Leandro
 */



public class RVentana extends javax.swing.JFrame
{
public RVentana()
{
super();
}
public RVentana (String title)
{
}

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static void main (java.lang.String args[])
{
JFrame MiVentana = new JFrame("Matriz R" ); //llamamos a la clase y creamos un objeto llamado MiVentana
MiVentana.setVisible(true);//le decimos al compilador que queremos que se vea la ventana
MiVentana.setSize(400,400);//le damos el tamaño deseado a nuestra ventana

MiVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);//le decimos que al dar clic en la X se cierre nuestra ventana
}
}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables




