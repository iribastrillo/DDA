package ui;

import Common.DisplayerStrategy;
import Common.IDisplayerStrategy;
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
import dominio.Casillero;
import dominio.modelosVista.EstadisticaCrupier;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author digregor
 */
public class DialogoVentanaMesaCrupier extends javax.swing.JFrame implements IVistaMesaCrupier {

    int apuestaRojo = 0;
    protected final ControladorVistaMesaCrupier controlador;
    protected final Mesa m;
    private final IDisplayerStrategy displayer = new DisplayerStrategy();

    /**
     * Creates new form NewJFrame
     */
    public DialogoVentanaMesaCrupier(Mesa m) {
        initComponents();
//        ocultarDocenas();
//        ocultarColor();
//        ocultarParidad();

        this.m = m;
        this.controlador = new ControladorVistaMesaCrupier(m, this);
        setup();
        actualizar();

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
        estadisticas = new componentes.PanelTableroRuleta();
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_ultimosLanzamientos))
                            .addComponent(panelInfoCrupier1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(estadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(39, 39, 39)
                .addComponent(estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.PanelTableroRuleta estadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_ultimosLanzamientos;
    private componentes.PanelInfoCrupier panelInfoCrupier1;
    private componentes.PanelRuleta r;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTiposApuestaSeleccionados(ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados) {
        for (EnumTipoApuesta enumApuesta : listarTiposApuestaSeleccionados) {
            switch (enumApuesta) {
                case Colores:
                    // mostrarColor();
                    displayer.mostrarColor(r);
                    break;
                case Docenas:
                    // mostrarDocenas();
                    displayer.mostrarDocenas(r);
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
        this.estadisticas.setJugadoresSaldo(jugadoresSaldo);
    }

    @Override
    public void cargarDropdownEfectos(String[] efectos) {
        this.panelInfoCrupier1.setDropdownEfectos(efectos);
    }

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
        controlador.cargarNumerosSorteados();
    }

    @Override
    public void cargarUltimoNumeroSorteado(String ultimoSorteado) {
        this.panelInfoCrupier1.cargarUltimoNumeroSorteado(ultimoSorteado);
    }

    private void setup() {
        displayer.ocultarTodo(r);
        controlador.cargarDropdownEfectos();
        this.panelInfoCrupier1.setNumeroMesa(m.getId());
        this.panelInfoCrupier1.agregar(this.controlador);
    }

    @Override
    public void cargarFichasEnMesa(ArrayList<Casillero> casilleros) {

        for (Casillero c : casilleros) {
            int montoActual = r.getApuesta(c.getUccode());
            r.setApuesta(c.getUccode(), c.getMonto()+montoActual);
        }

    }

    @Override
    public void borrarFichasEnMesa() {
        r.limpiar();
    }

    @Override
    public void cargarNumerosSorteados(String numerosSorteados) {
        this.lbl_ultimosLanzamientos.setText(numerosSorteados);
     }

    @Override
    public void cargarEstadisticasMesa(ArrayList<EstadisticaCrupier> estadisticasCrupier) {

        this.estadisticas.setEstadisticas(estadisticasCrupier);
    }

    @Override
    public void cargarSaldoJugadores(ArrayList<ModeloInfoCrupier> saldoJugadores) {
        this.estadisticas.setJugadoresSaldo(saldoJugadores);
     }
    
    

}
