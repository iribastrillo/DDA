/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
import Exceptions.ApuestaNoPermitidaException;
import Exceptions.MontoIgualACeroException;
import Exceptions.NoTieneSaldoDisponibleException;
import Logica.Fachada;
import dominio.EnumEventos;
import dominio.Jugador;
import dominio.Mesa;
import dominio.modelosVista.EstadisticasJugador;
import dominio.modelosVista.ModeloMesaJugador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.IVistaMesaJugador;

/**
 *
 * @author nacho
 */
public class ControladorVistaMesaJugador implements Observador, Jugador.Escuchador {
    
    private final IVistaMesaJugador vista;
    private final Fachada fachada;
    private ModeloMesaJugador modelo;
    
    public ControladorVistaMesaJugador (IVistaMesaJugador vista, ModeloMesaJugador modelo) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
        this.modelo = modelo;
        fachada.getMesa(modelo.getMesa()).agregar(this);
        fachada.getJugadorById(modelo.getIdJugador()).addEventListener (this);
        this.setup();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        EnumEventos e = (EnumEventos) evento;
        if (e == EnumEventos.APUESTA_MODIFICADA) {
            this.vista.refrescar();
        }
        if (e == EnumEventos.LANZAR) {
            this.vista.bloquear ();
        }
        if (e == EnumEventos.PAGAR) {
            this.vista.pagar ();
        }
        if (e == EnumEventos.CERRAR_MESA) {
            this.vista.mostrarDialogoDeError("Va a cerrar la mesa...");
            this.vista.abandonar();
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
        } catch (MontoIgualACeroException ex) {
            vista.mostrarDialogoDeError("El monto no puede ser igual a cero.");
        } catch (ApuestaNoPermitidaException ex) {
            vista.mostrarDialogoDeError(ex.getMessage());
        } 
    }
    
    public void setup () {
        this.refrescarModelo(modelo);
    }
    
    public ModeloMesaJugador refrescarModelo(ModeloMesaJugador modelo) {
        Jugador jugador = fachada.getJugadorById(modelo.getIdJugador());
        Mesa mesa = fachada.getMesa(modelo.getMesa());
        ArrayList<EstadisticasJugador> stats = fachada.getEstadisticasById (modelo.getIdJugador(), mesa.getId());
        HashMap<String, Float> ocurrencias = fachada.getOcurrenciasById(mesa.getId());
        
        ModeloMesaJugador nuevoModelo = new ModeloMesaJugador (
        jugador.getNombreCompleto(),
        jugador.getCedula(),
        jugador.getSaldo(),
        mesa.getId(),
        mesa.getRondaActual().getId(),
        mesa.getUltimoSorteado());
        
        nuevoModelo.setEstadisticas(stats);
        nuevoModelo.setOcurrencias(ocurrencias);
        
        return nuevoModelo;
    }

    @Override
    public void saldoDescontado() {
        this.vista.refrescar();
    }
}
