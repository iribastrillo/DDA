/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package componentes;

import Exceptions.NoPuedeAbandonarMesaException;
import controladores.ControladorPanelJugador;
import dominio.modelosVista.EstadisticasJugador;
import dominio.modelosVista.ModeloMesaJugador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vistas.IVistaMesaJugador;
/**
 *
 * @author nacho
 */
public class PanelJugador extends javax.swing.JPanel {
    
    private final ControladorPanelJugador controlador;
    private ModeloMesaJugador modelo;
    private IVistaMesaJugador vista;
    /**
     * Creates new form PanelJugador
     */
    public PanelJugador() {
        initComponents();
        this.controlador = new ControladorPanelJugador ();
        this.vista = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        estadisticas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ocurrencias = new javax.swing.JTable();
        abandonarButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 300));

        estadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ronda", "Total apostado", "Ganado", "Perdido", "Balance"
            }
        ));
        jScrollPane1.setViewportView(estadisticas);

        ocurrencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Valor", "Ocurrencia"
            }
        ));
        jScrollPane2.setViewportView(ocurrencias);

        abandonarButton.setText("Abandonar");
        abandonarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abandonarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abandonarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(abandonarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void abandonarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abandonarButtonActionPerformed
        try {
            controlador.abandonar (modelo.getMesa(), modelo.getIdJugador());
            vista.abandonar();
        } catch (NoPuedeAbandonarMesaException ex) {
            vista.mostrarDialogoDeError ("No puedes abandonar la mesa si pusiste apuestas.");
        }
    }//GEN-LAST:event_abandonarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abandonarButton;
    private javax.swing.JTable estadisticas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable ocurrencias;
    // End of variables declaration//GEN-END:variables


    public ModeloMesaJugador getModelo() {
        return modelo;
    }

    public void setModelo(ModeloMesaJugador modelo) {
        this.modelo = modelo;
    }   

    public void setVista(IVistaMesaJugador vista) {
        this.vista = vista;
    }

    public void actualizar() {
        this.estadisticas.setModel(new DefaultTableModel(null,new String[]{"Ronda","Total apostado", "Ganado", "Perdido", "Balance"}));
        DefaultTableModel model = (DefaultTableModel) this.estadisticas.getModel();
        Object stats[] = new Object[5];
        for (EstadisticasJugador row1 : modelo.getEstadisticas()) {
            stats[0] = row1.getRonda();
            stats[1] = row1.getTotal();
            stats[2] = row1.getGanado();
            stats[3] = row1.getPerdido();
            stats[4] = row1.getBalance();
            model.addRow(stats);
        }
        
        this.ocurrencias.setModel(new DefaultTableModel(null,new String[]{"Valor","Ocurrencia"}));
        model = (DefaultTableModel) this.ocurrencias.getModel();
        Object values[] = new Object[2];
        for (String i : modelo.getOcurrencias().keySet()) {
            Float f = modelo.getOcurrencias().get(i);
            values[0] = i;
            values[1] = f;
            model.addRow(values);
        }
    }
}
