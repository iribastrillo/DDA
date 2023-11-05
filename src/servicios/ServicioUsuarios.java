/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import Exceptions.UsuarioCrupierTieneSesionActivaException;
import Exceptions.UsuarioNoEncontradoException;
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

    private HashMap<String, Crupier> croupieres;
    private HashMap<String, Jugador> jugadores;
    private HashMap<String, Jugador> jugadoresActivos;
    private HashMap<String, Usuario> usuariosConectados;

    public ServicioUsuarios() {
        croupieres = new HashMap();
        jugadores = new HashMap();
        jugadoresActivos = new HashMap();
        usuariosConectados = new HashMap();
    }

    public void agregar(Crupier croupier) throws UsuarioYaExisteException {
        if (!croupieres.containsKey(croupier.getCedula())) {
            croupieres.put(croupier.getCedula(), croupier);
        } else {
            throw new UsuarioYaExisteException("El usuario ya existe");
        }
    }

    public void agregar(Jugador jugador) throws UsuarioYaExisteException {
        if (!croupieres.containsKey(jugador.getCedula())) {
            jugadores.put(jugador.getCedula(), jugador);
        } else {
            throw new UsuarioYaExisteException("El usuario ya existe");
        }
    }

    public Usuario loginJugador(Usuario u) {

        if (jugadores.containsKey(u.getCedula())) {
            Jugador j = jugadores.get(u.getCedula());
            if (j.getPassword().equals(u.getPassword())) {

                //Si el usuario no se encuentra como conectado se agrega
                if (!usuariosConectados.containsKey(j.getCedula())) {
                    usuariosConectados.put(j.getCedula(), j);
                }
                return j;
            }
        }
        return null;
    }

    public Crupier loginCroupier(Usuario u) throws UsuarioCrupierTieneSesionActivaException, UsuarioNoEncontradoException {

        Crupier c = croupieres.get(u.getCedula());
        if (c != null) {
            if (c.getPassword().equals(u.getPassword())) {

                if (!usuariosConectados.containsKey(c.getCedula())) {
                    usuariosConectados.put(c.getCedula(), c);
                    
                } else {
                    //Si el crupier ya se encuentra como conectado se tiramos exepcion
                    throw new UsuarioCrupierTieneSesionActivaException("El usuario ya tiene una sesion activa en el sistema");
                }
            } else {
                throw new UsuarioNoEncontradoException("No se ha encontrado usuario para la combinacion de cedula y password");
            }
        }
        return c;
    }

    public Jugador login(String nombreUsuario, String contrasena) {

        return null;

    }

    public HashMap<String, Crupier> getCrupieres() {
        return this.croupieres;
    }

}
