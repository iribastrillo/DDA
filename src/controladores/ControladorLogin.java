/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.PasswordUsuarioInvalidoException;
import Exceptions.UsuarioCrupierTieneSesionActivaException;
import Exceptions.UsuarioNoEncontradoException;
import Logica.Fachada;
import vistas.IVistaLogin;
import dominio.Usuario;

/**
 *
 * @author Usuario
 */
public class ControladorLogin {

    private final Fachada fachada;
    private final IVistaLogin vista;

    public ControladorLogin(Fachada fachada, IVistaLogin vista) {
        this.fachada = fachada;
        this.vista = vista;

    }

    public Usuario loginCroupier(String cedula, String password) {
        try {
            return fachada.loginCroupier(cedula, password);
        } catch (CedulaUsuarioInvalidaException | PasswordUsuarioInvalidoException | UsuarioCrupierTieneSesionActivaException  | UsuarioNoEncontradoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
        return null;
    }

    public Usuario loginJugador(String cedula, String password) {
        try {
            return fachada.loginJugador(cedula, password);
        } catch (CedulaUsuarioInvalidaException |PasswordUsuarioInvalidoException |UsuarioNoEncontradoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        } 
        return null;
    }

}
