/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.PasswordUsuarioInvalidoException;
import Logica.FachadaServicios;
import Vista.IVistaLogin;
import dominio.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControladorLogin {

    private final FachadaServicios fachada;
    private final IVistaLogin vista;

    public ControladorLogin(FachadaServicios fachada, IVistaLogin vista) {
        this.fachada = fachada;
        this.vista = vista;

    }

    public Usuario loginCroupier(String cedula, String password) {
        try {
            return fachada.loginCroupier(cedula, password);
        } catch (CedulaUsuarioInvalidaException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PasswordUsuarioInvalidoException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Usuario loginJugador(String cedula, String password) {
        try {
            return fachada.loginJugador(cedula, password);
        } catch (CedulaUsuarioInvalidaException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PasswordUsuarioInvalidoException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     

}
