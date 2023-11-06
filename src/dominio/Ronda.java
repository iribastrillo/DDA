/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

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
<<<<<<< Updated upstream
    private ArrayList<Apuesta>apuestas;
=======
    private ArrayList<Apuesta> apuestas;
    private StrategyEfecto efecto;
    private Mesa mesa;
>>>>>>> Stashed changes
    
    public Ronda () {
        this.id = autoId;
        this.balanceAnterior = 0;
        this.balancePosterior = 0;
        this.recoleccion = 0;
        this.liquidacion = 0;
        this.apuestas=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public float getBalanceAnterior() {
        return balanceAnterior;
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
        this.numeroSorteado = numeroSorteado;
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
        }
    }

    private Apuesta getApuesta(String idJugador) {
        Apuesta apuesta = null;
        for (Apuesta a: apuestas) {
            if (a.getIdJugador() == idJugador) {
                apuesta = a;
            }
        }
        return apuesta;
    }
}
