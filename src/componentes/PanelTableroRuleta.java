/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package componentes;

import dominio.modelosVista.ModeloInfoJugador;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nacho
 */
public class PanelTableroRuleta extends javax.swing.JPanel {

    /**
     * Creates new form PanelJugador
     */
    public PanelTableroRuleta() {
        initComponents();
    }

    public void setJugadoresSaldo(ArrayList<ModeloInfoCrupier> jugadoresSaldo) {
       
        if (jugadoresSaldo != null) {
            // Limpiando la tabla para cargar datos actualizados
            this.tbl_JugadorSaldo.setModel(new DefaultTableModel(null,new String[]{"Jugador","Saldo"}));
            DefaultTableModel model = (DefaultTableModel) this.tbl_JugadorSaldo.getModel();
            Object rowData[] = new Object[2];
            for (ModeloInfoCrupier mjs : jugadoresSaldo) {
                rowData[0] = mjs.getJugador();
                rowData[1] = mjs.getSaldo();
                model.addRow(rowData);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_TableroMesa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_JugadorSaldo = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(720, 300));

        tbl_TableroMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ronda", "Balance anterior", "Apuestas", "Recoleccion", "Liquidacion", "Balance posterior"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_TableroMesa);

        tbl_JugadorSaldo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Jugador", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_JugadorSaldo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_JugadorSaldo;
    private javax.swing.JTable tbl_TableroMesa;
    // End of variables declaration//GEN-END:variables
}
