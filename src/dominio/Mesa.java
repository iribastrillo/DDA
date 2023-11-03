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

    public Mesa(ArrayList<EnumTipoApuesta> tiposApuesta, Crupier crupier) {
        this.id = autoId;
        this.balance = 0;
        this.numerosSorteados = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.rondas = new ArrayList <>();
        this.bloqueada = false;
        this.tiposApuesta = tiposApuesta;
        this.crupier = crupier;
        
        this.tiposApuesta.add(EnumTipoApuesta.Apuesta_Directa);
        this.rondas.add(new Ronda());
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
        return this.rondas.get(this.rondas.size() - 1);
    }
    
    public Ronda getRondaAnterior () {
        return this.rondas.get(this.rondas.size() - 2);
    }

}
