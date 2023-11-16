/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
import Exceptions.NoSeHaSeleccionadoUnEfectoException;
import Exceptions.HayApuestasEnRondaActualException;
import Exceptions.ServicioUsuariosException;
import Logica.Fachada;
import dominio.EnumEfectos;
import dominio.EnumEventos;
import vistas.IVistaMesaCrupier;
import dominio.Mesa;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import componentes.PanelInfoCrupier.Escuchador;
import dominio.Casillero;
import dominio.Jugador;
import dominio.modelosVista.EstadisticaCrupier;
import java.util.StringJoiner;

/**
 *
 * @author Usuario
 */
public class ControladorVistaMesaCrupier implements Observador, Escuchador {

    private final Fachada fachada;
    private final IVistaMesaCrupier vista;
    private final Mesa m;
    private final ArrayList<ModeloInfoCrupier> saldoJugadores;
    private final ArrayList<EstadisticaCrupier> estadisticas;

 
    public ControladorVistaMesaCrupier(Mesa mesa, IVistaMesaCrupier vista) {
        this.fachada = Fachada.getInstancia();
        this.vista = vista;
        this.m = mesa;
        m.agregar(this);
        this.fachada.agregar(this);
        this.saldoJugadores = new ArrayList();
        this.estadisticas = new ArrayList();

    }

    public void mostrarTiposApuestaSeleccionados() {
        vista.mostrarTiposApuestaSeleccionados(m.listarTiposApuestaSeleccionados());
    }

    public void cargarNumeroDeMesaEnPanel() {
        vista.cargarNumeroDeMesaEnPanel(m.getId());
    }

    public void cargarTotalApostadoEnPanel() {

        vista.cargarTotalApostadoEnPanel(m.getTotalApostado());
    }

    public void cargarNumeroDeRondaEnPanel() {
        vista.cargarNumeroDeRondaEnPanel(m.getRondaActual().getId());
    }

    public void cargarNumeroDeApuestasEnPanel() {
        vista.cargarNumeroDeApuestasEnPanel(m.getRondaActual().getCantidadApuestas());
    }

    private void cargarJugadoresYSaldoEnMesa() {
        ArrayList<ModeloInfoCrupier> jugadoresSaldo = this.fachada.cargarJugadoresSaldo(m);

        this.vista.cargarListaJugadores(jugadoresSaldo);
    }

    private void cargarFichasEnMesa() {
        vista.borrarFichasEnMesa();

        ArrayList<Casillero> casillerosConApuestas = m.getRondaActual().getCasillerosConApuestas();

        vista.cargarFichasEnMesa(casillerosConApuestas);

    }

    public void cargarDropdownEfectos() {

        EnumEfectos[] valoresEnum = EnumEfectos.values();
        String[] valoresEnumStrings = new String[valoresEnum.length];
        for (int i = 0; i < valoresEnum.length; i++) {

            valoresEnumStrings[i] = valoresEnum[i].name();

        }
        vista.cargarDropdownEfectos(valoresEnumStrings);

    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EnumEventos.LOGIN_JUGADOR_MESA.equals(evento)||EnumEventos.ABANDONAR_MESA.equals(evento) || EnumEventos.SE_PAGO.equals(evento)) {
            cargarSaldoJugadores();
        }
        if (EnumEventos.APUESTA_CREADA.equals(evento) || EnumEventos.APUESTA_MODIFICADA.equals(evento)) {
            cargarFichasEnMesa();
            cargarSaldoJugadores();
            actualizarPanelApuestasMesa();
            cargarTotalApostadoEnPanel();
            cargarNumeroDeApuestasEnPanel();
        }
        if (EnumEventos.PAGAR.equals(evento)) {
             cargarFichasEnMesa();
             cargarEstadisticasMesa();
             cargarSaldoJugadores();
             cargarNumerosSorteados();
             cargarTotalApostadoEnPanel();
             cargarNumeroDeApuestasEnPanel();
             cargarNumeroDeRondaEnPanel();
  
        }
         if (EnumEventos.LANZAR.equals(evento)) {
            cargarUltimoNumeroSorteado();
        }
    }

    @Override
    public void efectoSeleccionado(String efecto) {
        try {
            fachada.ActualizarEfectoEnRonda(efecto, m);

        } catch (NoSeHaSeleccionadoUnEfectoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    private void actualizarPanelApuestasMesa() {
        int cantidadDeApuestas = m.getCantidadDeApuestas();
        int totalApostado = m.getTotalApostado();

        vista.cargarTotalApostado(totalApostado);
        vista.cargarCantidadDeApuestas(cantidadDeApuestas);

    }

    @Override
    public void cerrarMesa() {
        try {
            m.cerrarYPagar();
            fachada.logoutCrupier(m.getCrupier());
            fachada.sacarMesaActiva (m);
            vista.cerrarVentana();
        } catch (ServicioUsuariosException | HayApuestasEnRondaActualException  ex) {
            Logger.getLogger(ControladorVistaMesaCrupier.class.getName()).log(Level.SEVERE, null, ex);
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    @Override
    public void lanzarYPagar() {
       
            m.lanzarYPagar();
            fachada.sePago();
    }

    public void cargarUltimoNumeroSorteado() {
        vista.cargarUltimoNumeroSorteado(m.getUltimoSorteado());
    }

    public void cargarNumerosSorteados() {
        String numeros = "N/A";
        StringJoiner joiner = new StringJoiner(", ");
        if (m.getNumerosSorteados().size() > 0) {
            for (int numero : m.getNumerosSorteados()) {
                joiner.add(String.valueOf(numero));
            }
            numeros = joiner.toString();
        }
        vista.cargarNumerosSorteados(numeros);

    }

    public void cargarEstadisticasMesa() {
           
    vista.cargarEstadisticasMesa(m.getEstadisticasCrupier());
    }
 

 
    public void cargarSaldoJugadores(){
        this.saldoJugadores.clear();
        for(Jugador j:m.getJugadores()){
            ModeloInfoCrupier objSaldoJugador=new ModeloInfoCrupier(j.getNombreCompleto(),j.getSaldo());
            this.saldoJugadores.add(objSaldoJugador);
        }
        vista.cargarSaldoJugadores(saldoJugadores);
    }
    
    

}
