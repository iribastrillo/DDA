/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
import Exceptions.NoTieneSaldoDisponibleException;
import Logica.Fachada;
import dominio.EnumEventos;
import dominio.Jugador;
import dominio.Mesa;
import dominio.modelosVista.ModeloMesaJugador;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.IVistaMesaJugador;

/**
 *
 * @author nacho
 */
public class ControladorVistaMesaJugador implements Observador {
    
    private final IVistaMesaJugador vista;
    private final Fachada fachada;
    
    public ControladorVistaMesaJugador (IVistaMesaJugador vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
        this.fachada.agregar(this);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        EnumEventos e = (EnumEventos) evento;
        if (e == EnumEventos.LANZAR_PAGAR) {
            this.vista.refrescar();
            // y algo más ... Como notificar qué número salió y si ganaste o perdiste.
        }
    }

    public void mostrarTiposDeApuesta(int idMesa) {
        Mesa mesa = fachada.getMesa(idMesa);
        vista.mostrarTiposDeApuesta (mesa.listarTiposApuestaSeleccionados());
    }

    public void apostar(int n, int monto, int mesa, String idJugador) {
        try {
            fachada.apostar (n, monto, mesa, idJugador);
            vista.refrescar();
        } catch (NoTieneSaldoDisponibleException ex) {
            Logger.getLogger(ControladorVistaMesaJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void quitarApuesta(int uucod, int monto, int mesa, String idJugador) {
        fachada.quitarApuesta (uucod, monto, mesa, idJugador);
        vista.refrescar ();
    }
    
    public void modificarApuesta(int uccode, int monto, int mesa, String idJugador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ModeloMesaJugador refrescarModelo(ModeloMesaJugador modelo) {
        Jugador jugador = fachada.getJugadorById(modelo.getIdJugador());
        Mesa mesa = fachada.getMesa(modelo.getMesa());
        
        return new ModeloMesaJugador (
        jugador.getNombreCompleto(),
        jugador.getCedula(),
        jugador.getSaldo(),
        mesa.getId(),
        mesa.getRondaActual().getId());
    }
}
