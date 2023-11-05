/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Common.Observable;
import servicios.ServicioMesas;
import servicios.ServicioUsuarios;
import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.MesaNoEncontradaException;
import Exceptions.NoTieneSaldoDisponibleException;
import Exceptions.PasswordUsuarioInvalidoException;
import Exceptions.UsuarioCrupierTieneSesionActivaException;
import Exceptions.UsuarioNoEncontradoException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import Exceptions.UsuarioYaExisteException;
import dominio.Crupier;
import dominio.EnumEventos;
import dominio.EnumTipoApuesta;
import dominio.Jugador;
import dominio.Mesa;
import dominio.Usuario;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Fachada extends Observable {

    private static Fachada instancia;
    private ServicioMesas servicioMesas;
    private ServicioUsuarios servicioUsuarios;

    public ServicioMesas getServicioMesa() {
        return servicioMesas;
    }

    public ServicioUsuarios getServicioUsuarios() {
        return servicioUsuarios;
    }

    private Fachada() {
        servicioMesas = new ServicioMesas();
        servicioUsuarios = new ServicioUsuarios();
    }

    public synchronized static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public Usuario loginCroupier(String cedula, String password) throws CedulaUsuarioInvalidaException, PasswordUsuarioInvalidoException, UsuarioCrupierTieneSesionActivaException, UsuarioNoEncontradoException {

        Crupier u = new Crupier(cedula, password);
        u.validarUsuarioLogin();

        Usuario encontrado = servicioUsuarios.loginCroupier(u);
        if (encontrado == null) {
            throw new UsuarioNoEncontradoException("No se ha encontrado usuario para la combinacion de cedula y password");
        } else {
            return encontrado;
        }

    }

    public Usuario loginJugador(String cedula, String password) throws PasswordUsuarioInvalidoException, CedulaUsuarioInvalidaException, UsuarioNoEncontradoException {
        Jugador j = new Jugador(cedula, password);
        j.validarUsuarioLogin();
        Usuario encontrado = servicioUsuarios.loginJugador(j);
        if (encontrado == null) {
            throw new UsuarioNoEncontradoException("No se ha encontrado usuario para la combinacion de cedula y password");
        } else {
            return encontrado;
        }

    }

    public void agregar(Jugador jugador) throws UsuarioYaExisteException {
        servicioUsuarios.agregar(jugador);

    }

    public void agregar(Crupier croupier) throws UsuarioYaExisteException {
        servicioUsuarios.agregar(croupier);
    }

    public void agregar(Mesa mesa) throws UsuarioYaExisteException {
        servicioMesas.agregar(mesa);
        avisar(EnumEventos.FACHADA_NUEVA_MESA_AGREGADA);
    }

    public Mesa iniciarMesa(Crupier c, ArrayList< EnumTipoApuesta> tipoApuestas) throws UsuarioYaExisteException {
        Mesa mesa = new Mesa(tipoApuestas, c);
        agregar(mesa);
        return mesa;
    }

    HashMap<String, Crupier> getCrupieres() {
        return servicioUsuarios.getCrupieres();
    }

    public ArrayList<Mesa> getMesasActivas() {
        return servicioMesas.getMesasActivas();
    }

    public Mesa getMesa(int mesa) {
        return servicioMesas.getMesa(mesa);
    }

    // Agregar jugador a mesa
    public Mesa agregar(int id, Jugador jugador) throws MesaNoEncontradaException, UsuarioYaEstaEnLaMesaException {

        Mesa mesa = getServicioMesa().agregarJugador(id, jugador);
        avisar(EnumEventos.LOGIN_JUGADOR_MESA);

        return mesa;

    }

    public ArrayList<ModeloInfoCrupier> cargarJugadoresSaldo(Mesa m) {
        return getServicioMesa().obtenerJugadoresSaldoParaMesa(m);
    }

    public void abandonar(int mesa, String jugador) {
        this.servicioMesas.abandonar (mesa, jugador);
        avisar (EnumEventos.ABANDONAR_MESA);
    }

    public void apostar(int n, int monto, String idJugador) throws NoTieneSaldoDisponibleException {
        servicioUsuarios.apostar (n, monto, idJugador);
    }
    
    public void quitarApuesta(int uucod, int monto, String idJugador) {
        servicioUsuarios.quitarApuesta (uucod, monto, idJugador);
    }

    public Jugador getJugadorById(String cedula) {
        return servicioUsuarios.getJugadorById(cedula);
    }
}
