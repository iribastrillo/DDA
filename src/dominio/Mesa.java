/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Exceptions.UsuarioYaEstaEnLaMesaException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Mesa {

    private static int autoId = 0;
    private int id;
    private float balance;
    private ArrayList<Integer> numerosSorteados;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Ronda> rondas;
    private boolean bloqueada;
    private ArrayList<EnumTipoApuesta> tiposApuesta;
    private Crupier crupier;
    private Ronda rondaActual;

    public Mesa(ArrayList<EnumTipoApuesta> tiposApuesta, Crupier crupier) {
        this.id = autoId;
        this.balance = 0;
        this.numerosSorteados = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.rondas = new ArrayList <>();
        this.bloqueada = false;
        this.tiposApuesta = tiposApuesta;
        this.crupier = crupier;
        this.rondaActual=new Ronda(this);
        this.tiposApuesta.add(EnumTipoApuesta.Apuesta_Directa);
        this.rondas=new ArrayList<Ronda>();
        autoId ++;
    }
    
    public ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados(){
        return this.tiposApuesta;
    }
    
    
    public int getId() {
        return id;
    }

    public float getBalance() {
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
    
    public void agregarJugador (Jugador jugador) throws UsuarioYaEstaEnLaMesaException {
        if (jugadores.contains(jugador)) {
            throw new UsuarioYaEstaEnLaMesaException ("El usuario ya está en la mesa.");
        }
        jugadores.add (jugador);
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
    
    public Ronda getRondaActual () {
        return this.rondaActual;
        //return this.rondas.get(this.rondas.size() - 1);
    }
    
    public Ronda getRondaAnterior () {
        return this.rondas.get(this.rondas.size() - 2);
    }

    public void removerJugador(String idJugador) {
        Jugador j = null;
        for (Jugador jugador: jugadores) {
            if (jugador.getCedula() == idJugador) {
                j = jugador;
            }
        }
        jugadores.remove(j);
    }

    public Jugador getJugador(String idJugador) {
        Jugador j = null;
        for (Jugador jugador: jugadores) {
            if (jugador.getCedula() == idJugador) {
                j = jugador;
            }
        }
        return j;
    }

    public void apostar(String idJugador, int monto, int uccode) {
        Ronda ronda = this.getRondaActual();
        ronda.apostar (idJugador, monto, uccode);
    }

    public void quitarApuesta(String idJugador, int uccode) {
        Ronda ronda = this.getRondaActual();
        ronda.quitarApuesta (idJugador, uccode);
    }
}
