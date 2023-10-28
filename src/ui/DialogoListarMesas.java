/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Controlador.ControladorListarMesas;
import Logica.FachadaServicios;
import Vista.IVistaListarMesas;
import dominio.Jugador;

/**
 *
 * @author Usuario
 */
public class DialogoListarMesas extends javax.swing.JDialog implements IVistaListarMesas {
    
       protected final ControladorListarMesas controlador;
         protected final Jugador j;

    /**
     * Creates new form DialogoListarMesas
     */
    public DialogoListarMesas(java.awt.Frame parent, boolean modal,FachadaServicios f, Jugador jugador) {
        super(parent, modal);
        this.controlador=new ControladorListarMesas(f,this);
        this.j=jugador;
        initComponents();
        this.setTitle(String.format("Mesas abiertas, Usuario logueado: %s", jugador.getNombreCompleto()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
