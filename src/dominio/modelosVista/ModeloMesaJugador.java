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
public class ModeloMesaJugador {
    private String nombreJugador;
    private String idJugador;
    private float saldoJugador;
    private int mesa;
    private int ronda;
    private String ultimoSorteado;
    private ArrayList<Integer> fichasApostadas;
    private ArrayList<EstadisticasJugador> estadisticas;

    public ModeloMesaJugador(String nombreJugador, String idJugador, float saldoJugador, int mesa, int ronda, String ultimoSorteado) {
        this.nombreJugador = nombreJugador;
        this.idJugador = idJugador;
        this.saldoJugador = saldoJugador;
        this.mesa = mesa;
        this.ronda = ronda;
        this.ultimoSorteado = ultimoSorteado;
        this.fichasApostadas = new ArrayList <> ();
        this.estadisticas = new ArrayList <> ();
    }
    
    public ModeloMesaJugador (String idJugador, int idMesa) {
        this.idJugador = idJugador;
        this.mesa = idMesa;
        this.fichasApostadas = new ArrayList <> ();
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public float getSaldoJugador() {
        return saldoJugador;
    }

    public void setSaldoJugador(float saldoJugador) {
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

    public ArrayList<EstadisticasJugador> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(ArrayList<EstadisticasJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }

    public ArrayList<Integer> getMontoApostado() {
        return fichasApostadas;
    }

    public void setMontoApostado(ArrayList<Integer> montoApostado) {
        this.fichasApostadas = montoApostado;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getUltimoSorteado() {
        return ultimoSorteado;
    }

    public void setUltimoSorteado(String ultimoSorteado) {
        this.ultimoSorteado = ultimoSorteado;
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
