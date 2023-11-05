/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package componentes;

import Exceptions.NoTieneSaldoDisponibleException;
import controladores.ControladorInfoJugador;
import dominio.modelosVista.ModeloInfoJugador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vistas.IPanelInfoJugador;

/**
 *
 * @author nacho
 */
public class PanelInfoJugador extends javax.swing.JPanel implements IPanelInfoJugador{
    
    private ControladorInfoJugador controlador;
    private ArrayList<Integer> fichas;
    private ModeloInfoJugador modelo;
    /**
     * Creates new form PanelInfoJugador
     */
    public PanelInfoJugador() {
        initComponents();
        this.controlador = new ControladorInfoJugador ();
        this.fichas = new ArrayList ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void setSaldoInicial (float saldoInicial) {
        this.saldoInicial.setText("$" + String.valueOf(saldoInicial));
    }
    
    public void setNombreJugador (String nombre) {
        this.playerName.setText(nombre);
    }
    
    public void setNumeroMesa (int mesa) {
        this.ruleta.setText("Ruleta #" + String.valueOf(mesa));
    }
    
    public void setNumeroRonda (int ronda) {
        this.ronda.setText("Ronda #" + String.valueOf(ronda));
    }
    
    public void setMontoApostado () {
        this.montoApostado.setText("Apuesta: $" + String.valueOf(this.modelo.getTotal()));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ruleta = new javax.swing.JLabel();
        ronda = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        numeroSorteado = new javax.swing.JLabel();
        saldoInicial = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chip1 = new javax.swing.JButton();
        chip5 = new javax.swing.JButton();
        chip10 = new javax.swing.JButton();
        chip50 = new javax.swing.JButton();
        chip100 = new javax.swing.JButton();
        montoApostado = new javax.swing.JLabel();
        undoButton = new javax.swing.JButton();

        ruleta.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ruleta.setText("Ruleta #3");

        ronda.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ronda.setText("Ronda #3");

        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/profile-user.png"))); // NOI18N

        playerName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        playerName.setText("Montgomery Burns");

        numeroSorteado.setBackground(new java.awt.Color(255, 102, 102));
        numeroSorteado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroSorteado.setText("12");

        saldoInicial.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        saldoInicial.setText("$ 153");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/money.png"))); // NOI18N

        chip1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/chip.png"))); // NOI18N
        chip1.setText("1");
        chip1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chip1ActionPerformed(evt);
            }
        });

        chip5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/chip.png"))); // NOI18N
        chip5.setText("5");
        chip5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chip5ActionPerformed(evt);
            }
        });

        chip10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/chip.png"))); // NOI18N
        chip10.setText("10");
        chip10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chip10ActionPerformed(evt);
            }
        });

        chip50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/chip.png"))); // NOI18N
        chip50.setText("50");
        chip50.setToolTipText("");
        chip50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chip50ActionPerformed(evt);
            }
        });

        chip100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/chip.png"))); // NOI18N
        chip100.setText("100");
        chip100.setToolTipText("");
        chip100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chip100ActionPerformed(evt);
            }
        });

        montoApostado.setText("MontoApostado");

        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/arrows.png"))); // NOI18N
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saldoInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                        .addComponent(ruleta)
                        .addGap(18, 18, 18)
                        .addComponent(ronda)
                        .addGap(124, 124, 124)
                        .addComponent(playerName)
                        .addGap(57, 57, 57)
                        .addComponent(userIcon))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(montoApostado)
                        .addGap(55, 55, 55)
                        .addComponent(chip1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(chip5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(chip10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(chip50, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(chip100)
                        .addGap(18, 18, 18)
                        .addComponent(undoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeroSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ruleta)
                                .addComponent(ronda)
                                .addComponent(saldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numeroSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chip1)
                        .addComponent(chip5)
                        .addComponent(chip10)
                        .addComponent(chip50)
                        .addComponent(chip100)
                        .addComponent(montoApostado))
                    .addComponent(undoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chip1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chip1ActionPerformed
        this.tomarFicha(1);
    }//GEN-LAST:event_chip1ActionPerformed

    private void chip5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chip5ActionPerformed
        this.tomarFicha(5);
    }//GEN-LAST:event_chip5ActionPerformed

    private void chip10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chip10ActionPerformed
        this.tomarFicha(10);
    }//GEN-LAST:event_chip10ActionPerformed

    private void chip50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chip50ActionPerformed
        this.tomarFicha(50);
    }//GEN-LAST:event_chip50ActionPerformed

    private void chip100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chip100ActionPerformed
        this.tomarFicha(100);
    }//GEN-LAST:event_chip100ActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        this.undo();
    }//GEN-LAST:event_undoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chip1;
    private javax.swing.JButton chip10;
    private javax.swing.JButton chip100;
    private javax.swing.JButton chip5;
    private javax.swing.JButton chip50;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel montoApostado;
    private javax.swing.JLabel numeroSorteado;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel ronda;
    private javax.swing.JLabel ruleta;
    private javax.swing.JLabel saldoInicial;
    private javax.swing.JButton undoButton;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
    
    private void undo () {
        this.controlador.undo (this.modelo);
        this.actualizar ();
    }
    
    private void tomarFicha(int i) {
        try {
            this.controlador.tomarFicha (i, this.modelo, this);
            int monto = 1 + this.modelo.getTotal();
            this.modelo.agregarFicha (i);
            this.actualizar();
        } catch (NoTieneSaldoDisponibleException ex) {
            this.mostrarDialogoDeError(ex.getMessage());
        }
    }
    
    public ModeloInfoJugador getModelo() {
        return modelo;
    }

    public void setModelo(ModeloInfoJugador modelo) {
        this.modelo = modelo;
    }
    
    public void actualizar () {
        this.setNombreJugador(this.modelo.getNombreJugador());
        this.setSaldoInicial(this.modelo.getSaldoJugador());
        this.setNumeroMesa(this.modelo.getMesa());
        this.setNumeroRonda(this.modelo.getRonda());
        this.setMontoApostado();
    }

    @Override
    public void mostrarDialogoDeError(String message) {
        JOptionPane.showMessageDialog(this, message, "Saldo insuficiente", JOptionPane.ERROR_MESSAGE);
    }
}
