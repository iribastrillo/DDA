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
    
  
 
  
 // Constructor para crear un  Crupier al cargar la aplicacion
    public Crupier(String nombreCompleto, String cedula, String password) {
        super(nombreCompleto, cedula, password);
         
       
    }
    
    // Constructor para crear un  objeto crupiera la hora de loguearse
    //para validar si existe, si los campos estan cargados etc etc
    public Crupier(  String cedula, String password) {
        super( cedula, password);
     
    }
    
    
    
}
