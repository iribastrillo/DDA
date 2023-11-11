package ui;

import componentes.PanelRuleta;
import controladores.ControladorVistaMesaCrupier;
import dominio.EnumTipoApuesta;
import dominio.Mesa;
import dominio.modelosVista.ModeloInfoCrupier;

import Logica.Fachada;

import componentes.PanelRuleta;
import controladores.ControladorVistaMesaCrupier;
import dominio.EnumEfectos;

import dominio.EnumTipoApuesta;
import dominio.Mesa;
import dominio.efectos.CompletoEfecto;
import dominio.efectos.ParcialEfecto;
import dominio.efectos.SimuladorEfecto;
import dominio.efectos.StrategyEfecto;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vistas.IVistaMesaCrupier;
import componentes.PanelInfoCrupier.Escuchador;

/**
 *
 * @author digregor
 */
public class DialogoVentanaMesaCrupier extends javax.swing.JFrame implements IVistaMesaCrupier {

    int apuestaRojo = 0;
    protected final ControladorVistaMesaCrupier controlador;
    protected final Mesa m;

    /**
     * Creates new form NewJFrame
     */
    public DialogoVentanaMesaCrupier(Mesa m) {
        initComponents();
        ocultarDocenas();
        ocultarColor();
        ocultarParidad();
        this.m = m;

        this.controlador = new ControladorVistaMesaCrupier(m, this);
        controlador.cargarDropdownEfectos(); // evitar cargar los efectos

        actualizar();

        this.panelInfoCrupier1.setNumeroMesa(m.getId());
        this.panelInfoCrupier1.agregar(this.controlador);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r = new componentes.PanelRuleta();
        panelInfoCrupier1 = new componentes.PanelInfoCrupier();
        panelTableroRuleta1 = new componentes.PanelTableroRuleta();
        jLabel1 = new javax.swing.JLabel();
        lbl_ultimosLanzamientos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ultimos Lanzamientos:");

        lbl_ultimosLanzamientos.setText("N/A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTableroRuleta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_ultimosLanzamientos))
                            .addComponent(panelInfoCrupier1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelInfoCrupier1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_ultimosLanzamientos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTableroRuleta1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void mostrarColor() {
        r.setVisible(PanelRuleta.ROJO, true);
        r.setVisible(PanelRuleta.NEGRO, true);
    }

    private void ocultarColor() {
        r.setVisible(PanelRuleta.ROJO, false);
        r.setVisible(PanelRuleta.NEGRO, false);
    }

    private void mostrarDocenas() {
        r.setVisible(PanelRuleta.PRIMERA_DOCENA, true);
        r.setVisible(PanelRuleta.SEGUNDA_DOCENA, true);
        r.setVisible(PanelRuleta.TERCERA_DOCENA, true);

    }

    private void ocultarDocenas() {
        r.setVisible(PanelRuleta.PRIMERA_DOCENA, false);
        r.setVisible(PanelRuleta.SEGUNDA_DOCENA, false);
        r.setVisible(PanelRuleta.TERCERA_DOCENA, false);

    }

    private void mostrarParidad() {
        r.setVisible(PanelRuleta.PAR, true);
        r.setVisible(PanelRuleta.IMPAR, true);
    }

    private void ocultarParidad() {
        r.setVisible(PanelRuleta.PAR, false);
        r.setVisible(PanelRuleta.IMPAR, false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_ultimosLanzamientos;
    private componentes.PanelInfoCrupier panelInfoCrupier1;
    private componentes.PanelTableroRuleta panelTableroRuleta1;
    private componentes.PanelRuleta r;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTiposApuestaSeleccionados(ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados) {
        for (EnumTipoApuesta enumApuesta : listarTiposApuestaSeleccionados) {
            switch (enumApuesta) {
                case Colores:
                    mostrarColor();
                    break;
                case Docenas:
                    mostrarDocenas();
                    break;
            }
        }
    }

    @Override
    public void cargarNumeroDeMesaEnPanel(int id) {
        this.panelInfoCrupier1.setNumeroMesa(id);
    }

    @Override
    public void cargarTotalApostadoEnPanel(int balance) {
        this.panelInfoCrupier1.setTotalApostado(balance);
    }

    @Override
    public void cargarNumeroDeRondaEnPanel(int id) {
        this.panelInfoCrupier1.setNumeroRonda(id);
    }

    @Override
    public void cargarNumeroDeApuestasEnPanel(int cantidadApuestas) {
        this.panelInfoCrupier1.setCantidadApuestas(cantidadApuestas);
    }

    @Override
    public void cargarListaJugadores(ArrayList<ModeloInfoCrupier> jugadoresSaldo) {
        this.panelTableroRuleta1.setJugadoresSaldo(jugadoresSaldo);

    }

    @Override
    public void cargarDropdownEfectos(String[] efectos) {
        this.panelInfoCrupier1.setDropdownEfectos(efectos);
    }

//    @Override
//    public void efectoSeleccionado(String efecto) {
//        StrategyEfecto strategyEfecto=null;
//         switch(efecto){
//                case  "COMPLETO":
//                    strategyEfecto=new CompletoEfecto();
//                break;
//                case "PARCIAL":
//                    strategyEfecto=new ParcialEfecto();
//                 break;
//                case "SIMULADOR" :
//                    strategyEfecto=new SimuladorEfecto();
//        }
//        this.m.getRondaActual().setEfecto(strategyEfecto);
//        System.out.printf("Efecto seleccionado %s ",efecto);  
//    }
    @Override
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Login incorrecto", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void cargarTotalApostado(int totalApostado) {
        this.panelInfoCrupier1.setTotalApostado(totalApostado);
    }

    @Override
    public void cargarCantidadDeApuestas(int cantidadDeApuestas) {
        this.panelInfoCrupier1.setCantidadApuestas(cantidadDeApuestas);
    }

    @Override
    public void cerrarVentana() {
        //hay que sacar el escuchador?
        this.panelInfoCrupier1.eliminarEscuchador(this.controlador);
        this.setVisible(false);
        this.dispose();
    }

    @Override
    public void actualizar() {
        controlador.mostrarTiposApuestaSeleccionados(m);
        controlador.cargarNumeroDeMesaEnPanel(m);
        controlador.cargarTotalApostadoEnPanel(m);
        controlador.cargarNumeroDeRondaEnPanel(m);
        controlador.cargarNumeroDeApuestasEnPanel(m);
        controlador.cargarUltimoNumeroSorteado();
    }

    @Override
    public void cargarUltimoNumeroSorteado(String ultimoSorteado) {
        this.panelInfoCrupier1.cargarUltimoNumeroSorteado(ultimoSorteado);
    }

}
