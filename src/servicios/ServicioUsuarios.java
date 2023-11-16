/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import Exceptions.NoTieneSaldoDisponibleException;
import Exceptions.ServicioUsuariosException;
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

    public Usuario loginJugador(Usuario u) throws ServicioUsuariosException {

        Jugador j = jugadores.get(u.getCedula());
        if (j == null) {

            throw new ServicioUsuariosException("Credenciales incorrectas.");

        } else {
            if (j.getPassword().equals(u.getPassword()) && j.getCedula().equals(u.getCedula())) {

                if (!usuariosConectados.containsKey(j.getCedula())) {
                    usuariosConectados.put(j.getCedula(), j);
                }
            } else {
                throw new ServicioUsuariosException("No se ha encontrado usuario para los datos ingresados");
            }
        }
        return j;

    }

    public Crupier loginCroupier(Usuario u) throws ServicioUsuariosException {

        Crupier c = croupieres.get(u.getCedula());
        if (c == null) {
            //Si el crupier ya se encuentra como conectado se tiramos exepcion
            throw new ServicioUsuariosException("Credenciales incorrectas.");

        } else {
            if (c.getPassword().equals(u.getPassword())) {

                if (!usuariosConectados.containsKey(c.getCedula())) {
                    usuariosConectados.put(c.getCedula(), c);

                } else {
                    //Si el crupier ya se encuentra como conectado se tiramos exepcion
                    throw new ServicioUsuariosException("Acceso denegado. El usuario ya tiene una sesión activa.");
                }
            } else {
                throw new ServicioUsuariosException("Credenciales incorrectas.");
            }
        }
        return c;
    }

    public Jugador login(String nombreUsuario, String contrasena) {

        return null;
    }

    public Jugador getJugadorById(String idJugador) {
        return this.jugadores.get(idJugador);
    }

    public HashMap<String, Crupier> getCrupieres() {
        return this.croupieres;
    }

    public void logoutCrupier(Crupier c) throws ServicioUsuariosException {
        if (c == null) {
            throw new ServicioUsuariosException("Ingrese usuario al que hacer logout");
        } else {
            if (!usuariosConectados.containsKey(c.getCedula())) {
                throw new ServicioUsuariosException("No Se encontro Usuario al que hacer logout");
            } else {
                usuariosConectados.remove(c.getCedula());
            }
        }
    }
}
