/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio.efectos.CompletoEfecto;
import dominio.efectos.StrategyEfecto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nacho
 */
public class Ronda {
    private static int autoId = 0;
    private int id;
    private float balanceAnterior;
    private float balancePosterior;
    private float recoleccion;
    private float liquidacion;
    private int numeroSorteado;
    private HashMap<String, Apuesta> apuestas;
    private StrategyEfecto efecto;
    private Mesa mesa;
    
    public Ronda (Mesa mesa) {
        this.id = ++autoId;
        this.balanceAnterior = 0;
        this.balancePosterior = 0;
        this.recoleccion = 0;
        this.liquidacion = 0;
        this.apuestas=new HashMap<>();
        this.efecto=new CompletoEfecto();
        this.mesa=mesa;
    }

    public int getId() {
        return id;
    }

    public float getBalanceAnterior() {
        return balanceAnterior;
    }

    public HashMap<String, Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(HashMap<String, Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public StrategyEfecto getEfecto() {
        return efecto;
    }

    public void setEfecto(StrategyEfecto efecto) {
        this.efecto = efecto;
    }

    public void setBalanceAnterior(float balanceAnterior) {
        this.balanceAnterior = balanceAnterior;
    }

    public float getBalancePosterior() {
        return balancePosterior;
    }

    public void setBalancePosterior(float balancePosterior) {
        this.balancePosterior = balancePosterior;
    }

    public float getRecoleccion() {
        return recoleccion;
    }

    public void setRecoleccion(float recoleccion) {
        this.recoleccion = recoleccion;
    }

    public float getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(float liquidacion) {
        this.liquidacion = liquidacion;
    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = efecto.obtenerNumero(mesa);
    }
    public int getCantidadApuestas(){
        return apuestas.size();
    }

    public void apostar(String idJugador, int monto, int uccode) {
        Apuesta apuesta = this.getApuesta(idJugador);
        if (apuesta != null) {
            apuesta.apostar(monto, uccode);
        } else {
            apuesta = new Apuesta (idJugador);
            apuesta.apostar(monto, uccode);
            apuestas.put(idJugador, apuesta);
        }
    }

    private Apuesta getApuesta(String idJugador) {
        Apuesta apuesta = null;
            if (apuestas.containsKey(idJugador)) {
                apuesta = apuestas.get(idJugador);
            }
        return apuesta;
    }

    public void quitarApuesta(String idJugador, int uccode) {
        Apuesta apuesta = this.getApuesta(idJugador);
        apuesta.quitarApuesta (uccode);
        if (apuesta.isEmpty()) {
            apuestas.remove(idJugador);
        }
    }
    
    public int reembolsarTodo (int idMesa, String idJugador) {
        int reembolso = 0;
        Apuesta apuesta = this.getApuesta(idJugador);
        if (apuesta != null) {
            reembolso = apuesta.getTotalApostadoByJugador(idJugador);
        }
        return reembolso;
    }

    public boolean puedeAbandonar(String idJugador) {
        return !apuestas.containsKey(idJugador);
    }
}
