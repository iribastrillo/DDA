/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Controlador.ControladorCrearMesa;
import Logica.Fachada;
import Vista.IVistaCrearMesa;
import dominio.Crupier;
import dominio.EnumTipoApuesta;
import dominio.Mesa;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Usuario
 */
public class DialogoCrearMesa extends javax.swing.JDialog implements IVistaCrearMesa {

    protected final ControladorCrearMesa controlador;
    protected final Crupier c;
    protected final Fachada f;

    /**
     * Creates new form DialogoCrearMesa
     */
    public DialogoCrearMesa(java.awt.Frame parent, boolean modal, Fachada f, Crupier crupier) {
        super(parent, modal);
        this.controlador = new ControladorCrearMesa(f, this);
        initComponents();
        this.c = crupier;
        this.setTitle(String.format("Crear Mesa, Crupier logueado: %s", c.getNombreCompleto()));
        controlador.cargarListaTiposDeApuestas();
        this.f=f;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaTiposApuesta = new javax.swing.JList<>();
        jIniciarMesaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tipo de apuesta");

        jScrollPane1.setViewportView(jListaTiposApuesta);

        jIniciarMesaBtn.setText("Iniciar");
        jIniciarMesaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIniciarMesaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jIniciarMesaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jIniciarMesaBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jIniciarMesaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIniciarMesaBtnActionPerformed
      iniciarMesa();
    }//GEN-LAST:event_jIniciarMesaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jIniciarMesaBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListaTiposApuesta;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarListaTiposDeApuestas(String[] tiposApuesta) {  
        
        jListaTiposApuesta.setListData(tiposApuesta);
        
    }

    public void tipoDeApuestaSeleccionado() {
        
        //De aca le paso el string seleccionado al controladror, y el controlador manda fachada,
        //que manda al servicio que traduceel string  al enum?
        String tipoApuestaSeleccionada =  jListaTiposApuesta.getSelectedValue();
         controlador.tipoApuestaSeleccionada(tipoApuestaSeleccionada);
    }

    @Override
    public void iniciarMesa() {
      Object[] tipoApuestaSeleccionada =  jListaTiposApuesta.getSelectedValues();
      String[] stringArr=Arrays.copyOf(tipoApuestaSeleccionada,tipoApuestaSeleccionada.length,String[].class);
        System.out.printf("DialogoCrearMesa: Tipos de Apuesta Seleccionadas para la mesa %s",Arrays.toString(stringArr));
        controlador.inciarMesa(c,stringArr);
    }
    
    @Override
    public void mostrarMesaCrupier(Mesa mesaIniciada){
                new DialogoVentanaMesaCrupier(mesaIniciada,f).setVisible(true);
                this.dispose();
                 
                 
                //new DialogoVentanaMesaCrupier((java.awt.Frame) this.getParent(),false,super.f,(Crupier) usuario).setVisible(true);

        
    }
}
