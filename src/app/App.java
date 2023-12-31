/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import Exceptions.UsuarioYaExisteException;
import Logica.DatosPrueba;
import Logica.Fachada;
import componentes.PanelRuleta;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.VentanaInicio;

/**
 *
 * @author digregor
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fachada f = Fachada.getInstancia();
        DatosPrueba datosPrueba = new DatosPrueba();
        try {

            datosPrueba.iniciar(f);
        } catch (UsuarioYaExisteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);

        }

        new VentanaInicio(f).setVisible(true);
    }

}
