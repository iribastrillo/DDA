/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import servicios.ServicioMesas;
import servicios.ServicioUsuarios;
import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.NombreUsuarioInvalidoException;
import Exceptions.PasswordUsuarioInvalidoException;
import Exceptions.UsuarioYaExisteException;
import dominio.Crupier;
import dominio.EnumTipoApuesta;
import dominio.Jugador;
import dominio.Mesa;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Fachada {
    
    private static  Fachada instancia;
    private ServicioMesas servicioMesas;
    private ServicioUsuarios servicioUsuarios;

    public ServicioMesas getServicioMesa() {
        return servicioMesas;
    }

    public ServicioUsuarios getServicioUsuarios() {
        return servicioUsuarios;
    }
    

    private Fachada() {
      servicioMesas=new ServicioMesas();
      servicioUsuarios=new ServicioUsuarios();
    }
    
    public synchronized static Fachada getInstancia(){
       if(instancia==null){
           instancia=new Fachada();
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

    void agregar(Jugador jugador) throws UsuarioYaExisteException {
         servicioUsuarios.agregar(jugador);

    }

    void agregar(Crupier croupier) throws UsuarioYaExisteException {
        servicioUsuarios.agregar(croupier);
    }
    
    void agregar(Mesa mesa) throws UsuarioYaExisteException {
        servicioMesas.agregar(mesa);
    }

    public Mesa iniciarMesa(Crupier c,ArrayList< EnumTipoApuesta> tipoApuestas) {
       return null;
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
}
