/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.modelosVista;

/**
 *
 * @author nacho
 */
public class ModeloInfoCrupier {
    private String jugador;
    private float saldo;
    
    public ModeloInfoCrupier (String jugador, float saldo) {
        this.jugador = jugador;
        this.saldo = saldo;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
