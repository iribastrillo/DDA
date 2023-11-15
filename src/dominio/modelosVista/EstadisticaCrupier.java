/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.modelosVista;

/**
 *
 * @author Usuario
 */
public class EstadisticaCrupier {
    private int ronda;
    private int liquidacion;
    private int balanceAnterior;
    private int recoleccion;
    private int balancePosterior;
    private int apuestas;

    public EstadisticaCrupier(int ronda, int liquidacion,int apuestas, int balanceAnterior, int recoleccion, int balancePosterior) {
        this.ronda = ronda;
        this.liquidacion = liquidacion;
        this.balanceAnterior = balanceAnterior;
        this.recoleccion = recoleccion;
        this.balancePosterior = balancePosterior;
        this.apuestas=apuestas;
    }

    public int getApuestas() {
        return apuestas;
    }

    public int getRonda() {
        return ronda;
    }

    public int getLiquidacion() {
        return liquidacion;
    }

    public int getBalanceAnterior() {
        return balanceAnterior;
    }

    public int getRecoleccion() {
        return recoleccion;
    }

    public int getBalancePosterior() {
        return balancePosterior;
    }

 
}
