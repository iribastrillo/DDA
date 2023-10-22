/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.UsuarioYaExisteException;
import dominio.Croupier;
import dominio.Jugador;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class ServicioUsuarios {

    private HashMap<String,Croupier> croupieres;
    private HashMap<String,Jugador> jugadores;
    private HashMap<String, Jugador> jugadoresActivos;

    public ServicioUsuarios() {
        croupieres=new HashMap();
        jugadores=new HashMap();
        jugadoresActivos=new HashMap();
    }
    
    public void agregarJugador(String cedula, String Nombre){
        
    }

    void agregar(Croupier croupier) throws UsuarioYaExisteException {
        if(!croupieres.containsKey(croupier.getCedula())){
        croupieres.put(croupier.getCedula(),croupier);}
        else{
            throw new UsuarioYaExisteException("El usuario ya existe");
        }
     }

    void agregar(Jugador jugador)  throws UsuarioYaExisteException {
        if(!croupieres.containsKey(jugador.getCedula())){
        jugadores.put(jugador.getCedula(),jugador);}
        else{
            throw new UsuarioYaExisteException("El usuario ya existe");
        }
     }
    
    
    public Usuario loginJugador(Usuario u) {
        
      if (jugadores.containsKey(u.getCedula())){
           Jugador j = jugadores.get(u.getCedula());
           if (j.getPassword().equals(u.getPassword())){
               return j;
           }
        }
        return null;
    }

    public Croupier loginCroupier(Usuario u) {
        if (croupieres.containsKey(u.getCedula())){
           Croupier c = croupieres.get(u.getCedula());
           if (c.getPassword().equals(u.getPassword())){
               return c;
           }
        }
        return null;
    }

   
}


    
    
 