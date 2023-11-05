/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Common.Observable;
import Common.Observador;
import servicios.ServicioMesas;
import servicios.ServicioUsuarios;
import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.MesaNoEncontradaException;
import Exceptions.NombreUsuarioInvalidoException;
import Exceptions.PasswordUsuarioInvalidoException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import Exceptions.UsuarioYaExisteException;
import dominio.Crupier;
import dominio.EnumEventos;
import dominio.EnumTipoApuesta;
import dominio.Jugador;
import dominio.Mesa;
import dominio.Usuario;
import dominio.modelosVista.ModeloJugadorSaldo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Fachada extends Observable implements Observador {

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

    public Usuario loginCroupier(String cedula, String password) throws CedulaUsuarioInvalidaException, PasswordUsuarioInvalidoException {

        Crupier u = new Crupier(cedula, password);
        u.validarUsuarioLogin();
        return servicioUsuarios.loginCroupier(u);

    }

    public Usuario loginJugador(String cedula, String password) throws PasswordUsuarioInvalidoException, CedulaUsuarioInvalidaException {
        Jugador j = new Jugador(cedula, password);
        j.validarUsuarioLogin();
        return servicioUsuarios.loginJugador(j);
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

    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Agregar jugador a mesa
    public Mesa agregar(int id, Jugador jugador) throws MesaNoEncontradaException, UsuarioYaEstaEnLaMesaException {

        avisar(EnumEventos.LOGIN_JUGADOR_MESA);

        return getServicioMesa().agregarJugador(id, jugador);

    }

    public ArrayList<ModeloJugadorSaldo> cargarJugadoresSaldo(Mesa m) {
        return getServicioMesa().obtenerJugadoresSaldoParaMesa(m);
    }
}
