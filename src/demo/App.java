/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo;

import Exceptions.UsuarioYaExisteException;
import Logica.DatosPrueba;
import Logica.FachadaServicios;
import componente.PanelRuleta;
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
        FachadaServicios f = FachadaServicios.getInstancia();
        DatosPrueba datosPrueba = new DatosPrueba();
        try {

            datosPrueba.iniciar(f);
        } catch (UsuarioYaExisteException ex) {
            System.out.println("Algun usuario ya existe");
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);

        }

        new VentanaInicio(f).setVisible(true);

//       new VentanaMesa().setVisible(true);
//       new PanelRuleta().setVisible(true);
    }

}
