/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class Jugador extends Usuario {

    public float getSaldoInicial() {
        return saldo;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldo = saldoInicial;
    }
    

    private float saldo;

    public Jugador(float saldoInicial, String nombreCompleto, String cedula, String password) {
        super(nombreCompleto, cedula, password);
        this.saldo = saldoInicial;
    }
     public Jugador(  String cedula, String password) {
        super(  cedula, password);
      
    }

    public void descontar(int monto) {
        this.saldo -= monto;
    }

    public void acreditar(int monto) {
        this.saldo += monto;
    }
}
