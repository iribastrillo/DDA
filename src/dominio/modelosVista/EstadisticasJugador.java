/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.modelosVista;

/**
 *
 * @author nacho
 */
public class EstadisticasJugador {
    private int ronda;
    private int total;
    private int ganado;
    private int perdido;
    private int balance;

    public EstadisticasJugador(int ronda, int total, int ganado, int perdido, int balance) {
        this.ronda = ronda;
        this.total = total;
        this.ganado = ganado;
        this.perdido = perdido;
        this.balance = balance;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getGanado() {
        return ganado;
    }

    public void setGanado(int ganado) {
        this.ganado = ganado;
    }

    public int getPerdido() {
        return perdido;
    }

    public void setPerdido(int perdido) {
        this.perdido = perdido;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
}
