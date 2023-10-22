/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class Croupier extends Usuario {
    
    private Mesa mesaAsignada;
  

    public Croupier(Mesa mesaAsignada, String nombreCompleto, String cedula, String password) {
        super(nombreCompleto, cedula, password);
        this.mesaAsignada = mesaAsignada;
    }
    
    public Croupier(  String cedula, String password) {
        super( cedula, password);
     
    }
    
}
