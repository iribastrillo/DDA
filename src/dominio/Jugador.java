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
        return saldoInicial;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
    

    private float saldoInicial;

    public Jugador(float saldoInicial, String nombreCompleto, String cedula, String password) {
        super(nombreCompleto, cedula, password);
        this.saldoInicial = saldoInicial;
    }
     public Jugador(  String cedula, String password) {
        super(  cedula, password);
      
    }
   
    
    

}
