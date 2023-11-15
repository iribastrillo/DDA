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
import Exceptions.MontoIgualACeroException;
import Exceptions.NoPuedeAbandonarMesaException;
import Exceptions.NoSeHaSeleccionadoUnEfectoException;
import Exceptions.NoTieneSaldoDisponibleException;
import Exceptions.PasswordUsuarioInvalidoException;
import Exceptions.ServicioUsuariosException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import Exceptions.UsuarioYaExisteException;
import dominio.Crupier;
import dominio.EnumEventos;
import dominio.EnumTipoApuesta;
import dominio.Jugador;
import dominio.Mesa;
import dominio.Ronda;
import dominio.Usuario;
import dominio.modelosVista.EstadisticasJugador;
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

    public Usuario loginCroupier(String cedula, String password) throws CedulaUsuarioInvalidaException, PasswordUsuarioInvalidoException,   ServicioUsuariosException {

        Crupier u = new Crupier(cedula, password);
        u.validarUsuarioLogin();

        Usuario encontrado = servicioUsuarios.loginCroupier(u);
   
            return encontrado;
    

    }
    
    public void logoutCrupier(Crupier c) throws ServicioUsuariosException{
        servicioUsuarios.logoutCrupier(c);
    }

    public Usuario loginJugador(String cedula, String password) throws PasswordUsuarioInvalidoException, CedulaUsuarioInvalidaException, ServicioUsuariosException {
        Jugador j = new Jugador(cedula, password);
        j.validarUsuarioLogin();
        Usuario encontrado = servicioUsuarios.loginJugador(j);
       
            return encontrado;
    
    }

    public void agregar(Jugador jugador) throws UsuarioYaExisteException {
        servicioUsuarios.agregar(jugador);

    }

    public void agregar(Crupier croupier) throws UsuarioYaExisteException {
        servicioUsuarios.agregar(croupier);
    }
    
    // Este metodo se usa en cargar datos 
    public void agregar(Mesa mesa) throws UsuarioYaExisteException {
        servicioMesas.agregar(mesa);
        avisar(EnumEventos.FACHADA_NUEVA_MESA_AGREGADA);
    }

    public Mesa iniciarMesa(Crupier c, ArrayList< EnumTipoApuesta> tipoApuestas) throws UsuarioYaExisteException {
        Mesa mesa = new Mesa(tipoApuestas, c);
        agregar( mesa);
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
    public void abandonar(int mesa, String jugador) throws NoPuedeAbandonarMesaException {
        this.servicioMesas.abandonar (mesa, jugador);
        avisar (EnumEventos.ABANDONAR_MESA);
    }

    public void apostar(int n, int monto, int mesa, String idJugador) throws NoTieneSaldoDisponibleException, MontoIgualACeroException {
        servicioMesas.apostar (n, monto, mesa,  idJugador);
    }

    public Jugador getJugadorById(String cedula) {
        return servicioUsuarios.getJugadorById(cedula);
    }

    public void ActualizarEfectoEnRonda(String efecto, Mesa m) throws NoSeHaSeleccionadoUnEfectoException {
        Ronda ronda =m.getRondaActual();
        ronda.ActualizarEfecto(efecto);
    }

    public ArrayList<EstadisticasJugador> getEstadisticasById(String idJugador, int idMesa) {
        return this.servicioMesas.getEstadisticasDelJugador (idJugador, idMesa);        
    }

    public HashMap<Integer, ArrayList> getOcurrenciasById(int idMesa) {
        // Funcionalidad limitada con un mock de datos para desarrollar.
        // Luego el dato viene de algun servicio.
        HashMap<Integer, ArrayList> ocurrencias = new HashMap <> ();
        ArrayList<Integer> fila1 = new ArrayList<> ();
        fila1.add(21);
        fila1.add(50);  
        ocurrencias.put(1, fila1);
        ocurrencias.put(2, fila1);
        return ocurrencias;
    }
}
