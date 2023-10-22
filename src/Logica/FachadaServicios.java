/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.NombreUsuarioInvalidoException;
import Exceptions.PasswordUsuarioInvalidoException;
import Exceptions.UsuarioYaExisteException;
import dominio.Croupier;
import dominio.Jugador;
import dominio.Usuario;

/**
 *
 * @author Usuario
 */
public  class FachadaServicios {
    
    private static  FachadaServicios instancia;
    private ServicioMesas servicioMesa;
    private ServicioUsuarios servicioUsuarios;

    public ServicioMesas getServicioMesa() {
        return servicioMesa;
    }

    public ServicioUsuarios getServicioUsuarios() {
        return servicioUsuarios;
    }
    

    public FachadaServicios() {
      servicioMesa=new ServicioMesas();
      servicioUsuarios=new ServicioUsuarios();
    }
    
    public synchronized static FachadaServicios getInstancia(){
       if(instancia==null){
           instancia=new FachadaServicios();
       }
       return instancia;
    }

    public Usuario loginCroupier(String cedula, String password) throws CedulaUsuarioInvalidaException, PasswordUsuarioInvalidoException {
        
            Croupier u = new Croupier(cedula, password);
            u.validarUsuarioLogin();
           return servicioUsuarios.loginCroupier(u);
    
    }

    public Usuario loginJugador(String cedula, String password) throws PasswordUsuarioInvalidoException, CedulaUsuarioInvalidaException {
         Jugador j = new Jugador(cedula, password);
            j.validarUsuarioLogin();
           return servicioUsuarios.loginJugador(j);
    }

    void agrear(Jugador jugador) throws UsuarioYaExisteException {
         servicioUsuarios.agregar(jugador);

    }

    void agrear(Croupier croupier) throws UsuarioYaExisteException {
        servicioUsuarios.agregar(croupier);
    }
    
   
}
