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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldoInicial) {
        this.saldo = saldoInicial;
    }
    

    private float saldo;

    public Jugador(float saldo, String nombreCompleto, String cedula, String password) {
        super(nombreCompleto, cedula, password);
        this.saldo = saldo;
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
