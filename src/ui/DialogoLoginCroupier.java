/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Logica.Fachada;
import dominio.Crupier;
import dominio.Usuario;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author ddauser
 */
public class DialogoLoginCroupier extends DialogoLogin {

    public DialogoLoginCroupier(Frame parent, boolean modal, Fachada f) {
        super(parent, modal,f);
        this.setTitle("Ingrese sus credenciales de Crupier");
    }

    @Override
    public Usuario loginUsuario(String cedula, String password) {
           
               
            return super.controlador.loginCroupier(cedula, password);
         
     }
    
        @Override
    protected void ejecutarCasoUsoInicial(Usuario usuario) {
     
        System.out.println("DialogoLoginCrupier: Caso de uso inicial para usuario Croupier");
        new DialogoCrearMesa((java.awt.Frame) this.getParent(),false,super.fachada,(Crupier) usuario).setVisible(true);
//        new DialogoUsuariosConectados((java.awt.Frame) this.getParent(), false, (Croupier) usuario).setVisible(true);
        
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
            JOptionPane.showMessageDialog(this, mensaje, "Login incorrecto", JOptionPane.ERROR_MESSAGE);
    }
    
    
}
