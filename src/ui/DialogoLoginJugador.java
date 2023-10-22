/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.PasswordUsuarioInvalidoException;
import Logica.FachadaServicios;
import dominio.Usuario;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
//import uy.edu.ort.dominio.Usuario;
//import uy.edu.ort.dominio.UsuarioGenerico;
//import uy.edu.ort.logica.FachadaServicios;

/**
 *
 * @author ddauser
 */
public class DialogoLoginJugador extends DialogoLogin {

    public DialogoLoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales de Jugador");
    }

    @Override
    protected Usuario loginUsuario(String cedula,String password) {
        try {
            return FachadaServicios.getInstancia().loginJugador(cedula, password);
        } catch (PasswordUsuarioInvalidoException ex) {
            Logger.getLogger(DialogoLoginJugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CedulaUsuarioInvalidaException ex) {
            Logger.getLogger(DialogoLoginJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void ejecutarCasoUsoInicial(Usuario usuario) {
        System.out.println("Caso de uso Incial para usuario Jugador");
        
//        TODO aca va un dialogo que muestra las mesas activas?
//        new DialogoAgenda((java.awt.Frame) this.getParent(), false, (Usuario) usuario).setVisible(true);
    }
}
