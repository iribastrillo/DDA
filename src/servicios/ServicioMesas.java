/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import Exceptions.ApuestaNoPermitidaException;
import Exceptions.EfectoException;
import Exceptions.MesaNoEncontradaException;
import Exceptions.MontoIgualACeroException;
import Exceptions.NoPuedeAbandonarMesaException;
import Exceptions.NoTieneSaldoDisponibleException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import dominio.Jugador;
import dominio.Mesa;
import dominio.modelosVista.EstadisticasJugador;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class ServicioMesas {

    public Mesa agregarJugador(int id, Jugador jugador) throws MesaNoEncontradaException, UsuarioYaEstaEnLaMesaException {
        Mesa mesa = getMesa(id);
        if (mesa == null) {
            String mensaje = String.format("Mesa con id: %s No encontrada", id);
            throw new MesaNoEncontradaException(mensaje);
        }
        mesa.agregarJugador(jugador);
        return mesa;
    }

    public ArrayList<Mesa> getMesasActivas() {
        return mesasActivas;
    }

    public void setMesasActivas(ArrayList<Mesa> mesasActivas) {
        this.mesasActivas = mesasActivas;
    }

    public ArrayList<Mesa> getMesasCerradas() {
        return mesasCerradas;
    }

    public void setMesasCerradas(ArrayList<Mesa> mesasCerradas) {
        this.mesasCerradas = mesasCerradas;
    }

    private ArrayList<Mesa> mesasActivas;
    private ArrayList<Mesa> mesasCerradas; //O bloqueadas?

    public ServicioMesas() {
        this.mesasActivas = new ArrayList<>();
        this.mesasCerradas = new ArrayList<>();
    }

    public Mesa agregar(Mesa mesa) {
        /// Agregar excepciones si hay..
        mesasActivas.add(mesa);
        return mesa;
    }

    public Mesa getMesa(int idMesa) {
        Mesa m = null;
        for (Mesa mesa: this.mesasActivas) {
            if (mesa.getId() == idMesa) {
                m = mesa;
            }
        }
        return m;
    }

    public ArrayList<ModeloInfoCrupier> obtenerJugadoresSaldoParaMesa(Mesa m) {
        ArrayList<ModeloInfoCrupier> jugadoresSaldo = new ArrayList<>();
        ArrayList<Jugador> jugadores = m.getJugadores();
        for (Jugador j : jugadores) {
            ModeloInfoCrupier jugadorSaldo = new ModeloInfoCrupier(j.getNombreCompleto(), j.getSaldo());
            jugadoresSaldo.add(jugadorSaldo);
        }
        return jugadoresSaldo;
    }

    public void abandonar(int idMesa, String idJugador) throws NoPuedeAbandonarMesaException {
        Mesa mesa = this.getMesa(idMesa);
        if (!mesa.puedeAbandonar(idJugador)) {
            throw new NoPuedeAbandonarMesaException("No puedes abandonar si ya apostaste.");
        }
        mesa.removerJugador(idJugador);
    }

    public void apostar(int uccode, int monto, int idMesa, String idJugador) throws NoTieneSaldoDisponibleException, MontoIgualACeroException, ApuestaNoPermitidaException, EfectoException {
        Mesa mesa = this.getMesa(idMesa);
        Jugador jugador = mesa.getJugador(idJugador);
        if (jugador.getSaldo() < monto) {
            throw new NoTieneSaldoDisponibleException("Saldo insuficiente.");
        }

        if (monto == 0) {
            throw new MontoIgualACeroException("El monto no puede ser cero.");
        }

        if (!mesa.permiteApuesta(uccode, monto, idJugador)) {
            throw new ApuestaNoPermitidaException ("No puedes apostar a ese color un monto superior a la ronda pasada.");
        }
        
        if (mesa.yaAposto(idJugador, uccode)) {
            mesa.agregarFichas(idJugador, monto, uccode);
        } else {
            mesa.apostar(idJugador, monto, uccode);
        }
      
        jugador.descontar(monto);
    }

    public void reembolsarTodo(int idMesa, String idJugador) {
        Mesa mesa = this.getMesa(idMesa);
        Jugador jugador = mesa.getJugador(idJugador);
        jugador.acreditar(mesa.getRondaActual().reembolsarTodo(idMesa, idJugador));
    }

    public void agregarFichas(String idJugador, int monto, int uccode, int idMesa) {
        Mesa mesa = this.getMesa(idMesa);
        mesa.agregarFichas(idJugador, monto, uccode);
    }

    public ArrayList<EstadisticasJugador> getEstadisticasDelJugador(String idJugador, int idMesa) {
        Mesa mesa = this.getMesa(idMesa);
        return mesa.getEstadisticasDelJugador(idJugador);
    }

    public void cerrarMesa(int idMesa) {
        for (Mesa mesa: this.mesasActivas) {
            if (mesa.getId() == idMesa) {
                this.mesasActivas.remove(mesa);
            }
        }
    }

    public HashMap<String, Float> getOcurrenciasById(int idMesa) {
        return this.getMesa(idMesa).getOcurrencias ();
    }

    public void sacarMesaActiva(Mesa m) {
        this.mesasActivas.remove(m);
    }
}
