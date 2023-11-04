/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Exceptions.UsuarioYaEstaEnLaMesaException;
import controladores.ControladorUnirse;
import Logica.Fachada;
import dominio.Jugador;
import vistas.IVistaUnirse;
import dominio.Mesa;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DialogoUnirse extends javax.swing.JDialog implements IVistaUnirse{
    
       protected final ControladorUnirse controlador;
       protected final Jugador jugador;
       protected final Fachada fachada;
       protected int mesaSeleccionada;

    /**
     * Creates new form DialogoListarMesas
     */
    public DialogoUnirse(java.awt.Frame parent, boolean modal,Fachada fachada, Jugador jugador) {
        super(parent, modal);
        this.controlador=new ControladorUnirse(fachada,this);
        this.jugador=jugador;
        this.fachada = fachada;
        initComponents();
        this.cargarMesasActivas();
        this.setTitle("Mesas activas");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        join = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        mesasActivas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        join.setText("Ingresar");
        join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinActionPerformed(evt);
            }
        });

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        mesasActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesasActivasActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecciona una mesa para unirte:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/roulette.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesasActivas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(join, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mesasActivas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(join)
                    .addComponent(logout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinActionPerformed
        int id = Integer.parseInt(this.mesasActivas.getSelectedItem().toString());
        
        this.controlador.unirse(id, this.jugador);

       
        // Try catch en el controlador
//        try {
//               this.controlador.unirse(id, this.jugador);
//           } catch (UsuarioYaEstaEnLaMesaException ex) {
//               Logger.getLogger(DialogoUnirse.class.getName()).log(Level.SEVERE, null, ex);
//           }
    }//GEN-LAST:event_joinActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.logout();
    }//GEN-LAST:event_logoutActionPerformed

    private void mesasActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesasActivasActionPerformed
        System.out.println(this.mesasActivas.getSelectedItem());
    }//GEN-LAST:event_mesasActivasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton join;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> mesasActivas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarMesasActivas() {
        ArrayList<Mesa> mesasActivas = this.controlador.getMesasActivas(); 
        //Sacamos los items que ya hay por si actualizamos la lista no queden duplicados los que ya estaban
        this.mesasActivas.removeAllItems();
        for (Mesa mesa: mesasActivas) {
            this.mesasActivas.addItem(String.valueOf(mesa.getId()));
        }
    }

    @Override
    public void mostrarMesaJugador(Mesa mesa, Jugador jugador) {
        new DialogoVentanaMesaJugador (mesa, jugador).setVisible(true);
    }

    @Override
    public void logout() {
        this.dispose();
    }

    @Override
    public void mostrarDialogoDeError(String mensaje) {
        JOptionPane.showMessageDialog(this, "El usuario ya se encuentra en la mesa.", "Intenta en otra mesa", JOptionPane.ERROR_MESSAGE);
    }
}
