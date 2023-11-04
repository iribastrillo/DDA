/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.modelosVista;

/**
 *
 * @author Usuario
 */
public class ModeloJugadorSaldo {
    private String nombreJugador;
    private Float saldoJugador;

    public ModeloJugadorSaldo(String nombreJugador, Float saldoJugador) {
        this.nombreJugador = nombreJugador;
        this.saldoJugador = saldoJugador;
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
}
