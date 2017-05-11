/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitetris;

import data.Elemento;
import data.Figura;
import data.Rejilla;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Francis
 */
public class SiguienteFigura extends javax.swing.JPanel {
    /**
     * TetrisFrame para acceder a algunos metodos
     */
    private TetrisFrame frame;
    private int anchoCelda = -1;
    private Figura figuraSiguiente, figuraActual;
    /**
     * Creates new form SiguienteFigura
     */
    public SiguienteFigura() {
        initComponents();
    }
    
    public SiguienteFigura(TetrisFrame fr){
        this();
        frame = fr;
    }
    
    
    public Figura getActual(){
        return figuraActual;
    }
    
    public Figura getSiguiente(){
        return figuraSiguiente;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
    
        if (anchoCelda == -1 )
            anchoCelda = 16;

        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        dibujaFigura(frame.getSiguiente(),g);
    }
    
    void dibujaFigura(Figura figura, java.awt.Graphics g){
        
        if (figura!=null){
            Elemento elemento;

            int xoffset=20;
            int yoffset=20;

            for(int i=0;i<figura.getNElements();i++){
                elemento=figura.getElementAt(i);
                g.setColor(Color.YELLOW);
                g.fillRect(xoffset+elemento.getColumna()*anchoCelda,yoffset+elemento.getFila()*anchoCelda,anchoCelda,anchoCelda);
                g.setColor(Color.RED);
                g.drawRect(xoffset+elemento.getColumna()*anchoCelda,yoffset+elemento.getFila()*anchoCelda,anchoCelda,anchoCelda);
            }

        }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
