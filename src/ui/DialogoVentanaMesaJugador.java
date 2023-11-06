package ui;

import Common.DisplayerStrategy;
import Common.IDisplayerStrategy;
import Logica.Fachada;
import controladores.ControladorVistaMesaJugador;
import vistas.IVistaMesaJugador;
import componentes.PanelRuleta;
import dominio.EnumTipoApuesta;
import dominio.modelosVista.ModeloMesaJugador;
import java.util.ArrayList;
/**
 *
 * @author digregor
 */
public class DialogoVentanaMesaJugador extends javax.swing.JFrame implements IVistaMesaJugador {

    private final ControladorVistaMesaJugador controlador;
    private final Selector selector;
    private ModeloMesaJugador modelo;
    private final IDisplayerStrategy displayer = new DisplayerStrategy ();

    /**
     * Creates new form NewJFrame
     */
    public DialogoVentanaMesaJugador(ModeloMesaJugador modelo) {
        initComponents();
        this.selector = new Selector ();
        this.modelo = modelo;
        this.controlador = new ControladorVistaMesaJugador (this);
        this.setup();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        r = new componentes.PanelRuleta();
        panelEstadisticasJugador = new componentes.PanelJugador();
        panelInfoJugador1 = new componentes.PanelInfoJugador();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Limpiar apuestas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Apostar al 0");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Borrar apuesta al 0");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Agregar 10 a la apuesta del rojo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setText("50");

        jCheckBox2.setText("Apostar en seleccion");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelEstadisticasJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(r, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                                    .addComponent(panelInfoJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInfoJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(12, 12, 12)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEstadisticasJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        r.limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int n = selector.universalCellCode;
        int monto = panelInfoJugador1.getModelo().getTotal();
        String idJugador = modelo.getIdJugador();
        r.setApuesta(n, monto);
        controlador.apostar (n, monto, modelo.getMesa(), idJugador);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int uccode = selector.universalCellCode;
        int monto = r.getApuesta(uccode);
        if (r.getApuesta(uccode) != 0) {
            r.setApuesta(selector.universalCellCode, 0);
            controlador.quitarApuesta (uccode, monto, modelo.getMesa(), modelo.getIdJugador());
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //apuestaRojo += 10;
        //r.setApuesta(PanelRuleta.ROJO, apuestaRojo);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            r.agregar(new PanelRuleta.Escuchador() {
                @Override
                public void celdaSeleccionada(int universalCellCode) {
                    int apuesta = Integer.valueOf(jTextField1.getText());
                    System.out.println("Id de celda seleccionada: " + universalCellCode + ". Apuesta anterior: " + r.getApuesta(universalCellCode) + ". Apuesta nueva:" + apuesta);
                    r.setApuesta(universalCellCode, apuesta);
                }
            });
        } else {
            r.eliminarEscuchadores();
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private componentes.PanelJugador panelEstadisticasJugador;
    private componentes.PanelInfoJugador panelInfoJugador1;
    private componentes.PanelRuleta r;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTiposDeApuesta(ArrayList<EnumTipoApuesta> tiposDeApuesta) {
        for (EnumTipoApuesta enumApuesta : tiposDeApuesta) {
            switch (enumApuesta) {
                case Paridad: 
                    displayer.mostrarParidad(r);
                    break;
                case Colores:
                    displayer.mostrarColor(r);
                    break;
                case Docenas:
                    displayer.mostrarDocenas(r);
                    break;

            }
        }
    }
    
    private void setup () {
        r.agregar(selector);
        this.panelEstadisticasJugador.setModelo(modelo);
        this.panelInfoJugador1.setModelo(modelo);
        this.displayer.ocultarTodo(r);
        this.controlador.mostrarTiposDeApuesta (modelo.getMesa());
        this.panelInfoJugador1.actualizar();
    }

    @Override
    public void refrescar() {
        this.modelo = controlador.refrescarModelo (modelo);
        this.panelInfoJugador1.setModelo(modelo);
        this.panelInfoJugador1.actualizar();
    }

    private class Selector implements PanelRuleta.Escuchador {
        
        int universalCellCode = 0;
        
        @Override
        public void celdaSeleccionada(int universalCellCode) {
            this.universalCellCode = universalCellCode;
            String labelApuesta = "Apostar al " + String.valueOf(universalCellCode);
            String labelBorrar = "Borrar apuesta al " + String.valueOf(universalCellCode);
            jButton2.setText(labelApuesta);
            jButton3.setText(labelBorrar);
        }
        
    }
    
    public void abandonar (){
        this.dispose();
    }

}
