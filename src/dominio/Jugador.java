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

    

    private int saldo;

    public Jugador(int saldo, String nombreCompleto, String cedula, String password) {
        super(nombreCompleto, cedula, password);
        this.saldo = saldo;
    }
     public Jugador(  String cedula, String password) {
        super(  cedula, password);
      
    }
     
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void descontar(int monto) {
        this.saldo -= monto;
    }

    public void acreditar(int monto) {
        this.saldo += monto;
    }
}
