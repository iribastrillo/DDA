/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.modelosVista;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ModeloInfoJugador {
    private String nombreJugador;
    private Float saldoJugador;
    private int mesa;
    private int ronda;
    private ArrayList<Integer> fichasApostadas;

    public ModeloInfoJugador(String nombreJugador, Float saldoJugador, int mesa, int ronda) {
        this.nombreJugador = nombreJugador;
        this.saldoJugador = saldoJugador;
        this.mesa = mesa;
        this.ronda = ronda;
        this.fichasApostadas = new ArrayList ();
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Float getSaldoJugador() {
        return saldoJugador;
    }

    public void setSaldoJugador(Float saldoJugador) {
        this.saldoJugador = saldoJugador;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public ArrayList<Integer> getMontoApostado() {
        return fichasApostadas;
    }

    public void setMontoApostado(ArrayList<Integer> montoApostado) {
        this.fichasApostadas = montoApostado;
    }
    
    public int getTotal () {
        int total = 0;
        for (Integer i: fichasApostadas) {
            total += i;
        }
        return total;
    }
    
    public void agregarFicha (int i) {
        this.fichasApostadas.add (i);
    }

}
