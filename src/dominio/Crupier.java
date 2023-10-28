/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class Crupier extends Usuario {
    
    private Mesa mesaAsignada;
  

    public Crupier(Mesa mesaAsignada, String nombreCompleto, String cedula, String password) {
        super(nombreCompleto, cedula, password);
        this.mesaAsignada = mesaAsignada;
    }
    
    public Crupier(  String cedula, String password) {
        super( cedula, password);
     
    }
    
}
