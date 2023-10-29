/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.PasswordUsuarioInvalidoException;
import Logica.FachadaServicios;
import dominio.Jugador;
import dominio.Usuario;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import uy.edu.ort.dominio.Usuario;
//import uy.edu.ort.dominio.UsuarioGenerico;
//import uy.edu.ort.logica.FachadaServicios;

/**
 *
 * @author ddauser
 */
public class DialogoLoginJugador extends DialogoLogin {

    public DialogoLoginJugador(Frame parent, boolean modal,FachadaServicios f) {
        super(parent, modal,f);
        this.setTitle("Ingrese sus credenciales de Jugador");
    }

    @Override
    public Usuario loginUsuario(String cedula,String password) {
        
            return super.controlador.loginJugador(cedula, password);
      
     
    }

    @Override
    protected void ejecutarCasoUsoInicial(Usuario usuario) {
        System.out.println("DialogoLoginCrupier: Caso de uso inicial para usuario Croupier");
        new DialogoListarMesas((java.awt.Frame) this.getParent(),false,super.f,(Jugador) usuario).setVisible(true);
        
//        TODO aca va un dialogo que muestra las mesas activas?
//        new DialogoAgenda((java.awt.Frame) this.getParent(), false, (Usuario) usuario).setVisible(true);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
            JOptionPane.showMessageDialog(this, "Login incorrecto, revise usuario y passoword y reintente.", "Login incorrecto", JOptionPane.ERROR_MESSAGE);
    }
}