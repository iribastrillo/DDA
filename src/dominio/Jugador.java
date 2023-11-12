/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import controladores.ControladorVistaMesaJugador;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Jugador extends Usuario {
    
    private ArrayList<Escuchador> escuchadores;

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
        this.escuchadores = new ArrayList <> ();
    }
     public Jugador(  String cedula, String password) {
        super(  cedula, password);
      
    }

    public void descontar(int monto) {
        this.saldo -= monto;
        this.triggerSaldoDescontado();
    }
    
    public void triggerSaldoDescontado () {
        for (Escuchador e: escuchadores) {
            e.saldoDescontado();
        }
    }

    public void acreditar(int monto) {
        this.saldo += monto;
    }

    public void addEventListener(Escuchador escuchador) {
        escuchadores.add(escuchador);
    }
    
    public interface Escuchador {
        public void saldoDescontado ();
    }
}
