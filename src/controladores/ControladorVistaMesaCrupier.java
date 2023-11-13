/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
import Exceptions.EfectoException;
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

/**
 *
 * @author Usuario
 */
public class ControladorVistaMesaCrupier implements Observador, Escuchador {

    private final Fachada fachada;
    private final IVistaMesaCrupier vista;
    private final Mesa m;

    // Nota: le pasamos la Mesa al la vista y voy a sacar Fachada, si se precisa se instancia..
    // porque para cargar listas y demas eventos de la mesa, se precisa saber de que mesa se esta hablando
    //Entonces pasamos mesa
    public ControladorVistaMesaCrupier(Mesa mesa, IVistaMesaCrupier vista) {
        this.fachada = Fachada.getInstancia();
        this.vista = vista;
        this.m = mesa;          
        m.agregar(this);
        this.fachada.agregar(this);
        
    }

    public void mostrarTiposApuestaSeleccionados(Mesa m) {
        vista.mostrarTiposApuestaSeleccionados(m.listarTiposApuestaSeleccionados());
    }

    public void cargarNumeroDeMesaEnPanel(Mesa m) {
        vista.cargarNumeroDeMesaEnPanel(m.getId());
    }

    public void cargarTotalApostadoEnPanel(Mesa m) {

        vista.cargarTotalApostadoEnPanel(m.getBalance());
    }

    public void cargarNumeroDeRondaEnPanel(Mesa m) {
        vista.cargarNumeroDeRondaEnPanel(m.getRondaActual().getId());
    }

    public void cargarNumeroDeApuestasEnPanel(Mesa m) {
        vista.cargarNumeroDeApuestasEnPanel(m.getRondaActual().getCantidadApuestas());
    }

    private void cargarJugadoresYSaldoEnMesa(Mesa m) {
        ArrayList<ModeloInfoCrupier> jugadoresSaldo = this.fachada.cargarJugadoresSaldo(m);

        this.vista.cargarListaJugadores(jugadoresSaldo);
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
        if (EnumEventos.LOGIN_JUGADOR_MESA.equals(evento)) {
            // Ccrear Modelo que pase el nombre del jugador y el saldo para mostrar en la vista (esto se tiene que cargar en searvicios mesa), previa llamada a fachada

            cargarJugadoresYSaldoEnMesa(m);

            //ArrayList<ModeloListarJugadoresSaldo> jugadoresSaldo
        }
        if (EnumEventos.APUESTA_CREADA.equals(evento)) {
            actualizarPanelApuestasMesa();
        }
    }

    @Override
    public void efectoSeleccionado(String efecto) {
        try {
            fachada.ActualizarEfectoEnRonda(efecto, m);

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

    ///El crupier solo podrá cerrar su mesa en el periodo que se
    //encuentra la mesa bloqueada, luego de lanzar y antes de pagar.
    //Al 
    // Agregar estados en mesa (por ahora parametros)
    // luego seria bueno traducirlos a STATE
    // Avisar a la ventana de jugador que se cierra la mesa
    @Override
    public void cerrarMesa() {
        try {
            m.cerrarYPagar();
            fachada.logoutCrupier(m.getCrupier());
            vista.cerrarVentana();
        } catch (ServicioUsuariosException | HayApuestasEnRondaActualException |EfectoException ex) {
            Logger.getLogger(ControladorVistaMesaCrupier.class.getName()).log(Level.SEVERE, null, ex);
            vista.mostrarMensajeError(ex.getMessage());
        } 
    }

    @Override
    public void lanzarYPagar() {
        try {
            m.lanzarYPagar();
            vista.actualizar();
        } catch (EfectoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    public void cargarUltimoNumeroSorteado() {
        vista.cargarUltimoNumeroSorteado(m.getUltimoSorteado());
     }

}
