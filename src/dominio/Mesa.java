/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Common.Observable;
import Exceptions.EfectoException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import Exceptions.HayApuestasEnRondaActualException;
import dominio.modelosVista.EstadisticaCrupier;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Mesa extends Observable {

    private static int autoId = 0;
    private int id;
    private int balance;
    private ArrayList<Integer> numerosSorteados;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Ronda> rondas;
    private boolean bloqueada;
    private ArrayList<EnumTipoApuesta> tiposApuesta;
    private Crupier crupier;
    private Ronda rondaActual;
    private EnumEstados estado;
    private int numeroSorteado;
    private ArrayList<Integer> numerosRojos;
    private ArrayList<EstadisticaCrupier> estadisticasCrupier;

    public Mesa(ArrayList<EnumTipoApuesta> tiposApuesta, Crupier crupier) {
        this.id = autoId;
        this.balance = 0;
        this.numerosSorteados = new ArrayList<>();
        this.numeroSorteado = -1;//este es a su vez el ultimo numero sorteado
        this.jugadores = new ArrayList<>();
        this.rondas = new ArrayList<>();
        this.bloqueada = false;
        this.tiposApuesta = tiposApuesta;
        this.crupier = crupier;
        this.rondaActual = new Ronda(this,0);
        this.tiposApuesta.add(EnumTipoApuesta.Apuesta_Directa);
        this.rondas = new ArrayList<>();
        this.estadisticasCrupier = new ArrayList<>();
        this.estado = EnumEstados.ACTIVA;
        this.numerosRojos = new ArrayList<>(
                Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 30, 32, 34, 36));
        autoId++;
    }

    public ArrayList<Integer> getNumerosConApuestaDirecta() {
        return rondaActual.getNumerosConApuestaDirecta();

    }

    public ArrayList<Integer> getNumerosRojos() {
        return this.numerosRojos;

    }

    public ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados() {
        return this.tiposApuesta;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public ArrayList<EnumTipoApuesta> getTiposApuesta() {
        return tiposApuesta;
    }

    public Crupier getCrupier() {
        return crupier;
    }

    public void agregarJugador(Jugador jugador) throws UsuarioYaEstaEnLaMesaException {
        if (jugadores.contains(jugador)) {
            throw new UsuarioYaEstaEnLaMesaException("El usuario ya está en la mesa.");
        }
        jugadores.add(jugador);
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }

    public Ronda getRondaActual() {
        return this.rondaActual;
        //return this.rondas.get(this.rondas.size() - 1);
    }

    public Ronda getRondaAnterior() {
        Ronda ronda = null;
        if (this.rondas.size() > 1) {
            ronda = this.rondas.get(this.rondas.size() - 2);
        }
        return ronda;
    }

    public void removerJugador(String idJugador) {
        Jugador j = null;
        for (Jugador jugador : jugadores) {
            if (jugador.getCedula() == idJugador) {
                j = jugador;
            }
        }
        jugadores.remove(j);
    }

    public Jugador getJugador(String idJugador) {
        Jugador j = null;
        for (Jugador jugador : jugadores) {
            if (jugador.getCedula() == idJugador) {
                j = jugador;
            }
        }
        return j;
    }

    public void apostar(String idJugador, int monto, int uccode) {
        Ronda ronda = this.getRondaActual();
        Casillero c = (uccode > 36) ? new CasilleroNoNumerico(monto, uccode) : new CasilleroNumerico(monto, uccode);

        if (ronda.yaAposto(idJugador, uccode)) {
            ronda.agregarFichas(idJugador, monto, uccode);
        } else {
            ronda.apostar(idJugador, c);
//            avisar(EnumEventos.APUESTA_CREADA);
        }

//        ronda.apostar(idJugador, c);
        avisar(EnumEventos.APUESTA_CREADA);

    }

    public void agregarFichas(String idJugador, int monto, int uccode) {
        Ronda ronda = this.getRondaActual();
        ronda.agregarFichas(idJugador, monto, uccode);
        avisar(EnumEventos.APUESTA_MODIFICADA);
    }

    public boolean puedeAbandonar(String idJugador) {
        return this.getRondaActual().puedeAbandonar(idJugador);
    }

    public String getUltimoSorteado() {
        String ultimoSorteado = "N/A";

        if (numeroSorteado != -1) {
            ultimoSorteado = String.valueOf(numeroSorteado);
        }
        return ultimoSorteado;
    }

    int getUltimaIdRonda() {
        return rondas.size() + 1;
    }

    public int getCantidadDeApuestas() {
        return rondaActual.getCantidadApuestas();
    }

    public int getTotalApostado() {
        return rondaActual.getTotalApostado();
    }

    public void cerrarYPagar() throws HayApuestasEnRondaActualException, EfectoException {
        //checkear si no hay rondas activas, si hay tirar excepcion
        if (estado.equals(EnumEstados.BLOQUEADA)) {
            //pagar a jugadores 
            lanzarYPagar();
            avisar(EnumEventos.CERRAR_MESA);
        } else {
            throw new HayApuestasEnRondaActualException("No se puede cerrar la mesa, necesita lanzar y pagar");

        }

        //cerrar mesas Y Ventanas, lanzar el evento cerrar mesa
    }

    public ArrayList<EstadisticaCrupier> getEstadisticasCrupier() {
        return estadisticasCrupier;
    }
    
   

    public void lanzarYPagar() throws EfectoException {
        // generar el numero random desde la ronda
        switch (estado) {
            case ACTIVA:
                // si la mesa esta activa se sortea el numero
                numeroSorteado = lanzar();
                avisar(EnumEventos.LANZAR);
                estado = EnumEstados.BLOQUEADA;

                break;
            case BLOQUEADA:
                //Si la mesa esta bloqueada se procede a pagar
                pagar(numeroSorteado);
                avisar(EnumEventos.PAGAR);
                //mesa queda activa
                estado = EnumEstados.ACTIVA;
                break;

        }

    }

    private int lanzar() throws EfectoException {
        this.numeroSorteado = rondaActual.getNumeroSorteado();
        return numeroSorteado;

    }

    private void pagar(int numeroSorteado) {
        // se crea un casillero cascaron para ver de que color es en caso de apuestas a color
        Casillero c = (numeroSorteado > 36) ? new CasilleroNoNumerico(-1, numeroSorteado) : new CasilleroNumerico(-1, numeroSorteado);

        this.rondaActual.pagarApuestas(c);
        //guardar ronda actual y crear ronda nueva
        guardarEstadisticasCrupier(this.rondaActual);
        this.rondas.add(this.rondaActual);

        this.rondaActual = new Ronda(this,this.rondaActual.getBalancePosterior());
        this.numerosSorteados.add(numeroSorteado);

    }

    private void guardarEstadisticasCrupier(Ronda ronda) {
        estadisticasCrupier.add(0,new EstadisticaCrupier(ronda.getId(), ronda.getTotalGanado(),ronda.getTotalApostado(),ronda.getBalanceAnterior(), ronda.getTotalPerdido(), ronda.getBalancePosterior()));
    }

    public boolean yaAposto(String idJugador, int uccode) {
        return this.getRondaActual().yaAposto(idJugador, uccode);
    }

}
