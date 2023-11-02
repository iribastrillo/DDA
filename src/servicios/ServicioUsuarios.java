/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import Exceptions.UsuarioYaExisteException;
import dominio.Crupier;
import dominio.Jugador;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class ServicioUsuarios {

    private HashMap<String,Crupier> croupieres;
    private HashMap<String,Jugador> jugadores;
    private HashMap<String, Jugador> jugadoresActivos;

    public ServicioUsuarios() {
        croupieres=new HashMap();
        jugadores=new HashMap();
        jugadoresActivos=new HashMap();
    }

    public void agregar(Crupier croupier) throws UsuarioYaExisteException {
        if(!croupieres.containsKey(croupier.getCedula())){
        croupieres.put(croupier.getCedula(),croupier);}
        else{
            throw new UsuarioYaExisteException("El usuario ya existe");
        }
     }

   public void agregar(Jugador jugador)  throws UsuarioYaExisteException {
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

    public Crupier loginCroupier(Usuario u) {
        if (croupieres.containsKey(u.getCedula())){
           Crupier c = croupieres.get(u.getCedula());
           if (c.getPassword().equals(u.getPassword())){
               return c;
           }
        }
        return null;
    }
    
    public Jugador login (String nombreUsuario, String contrasena) {
        
        return null;
        
    }

    public HashMap<String, Crupier> getCrupieres() {
        return this.croupieres;
    }

   
}


    
    
 