/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.Fachada;
import Vista.IVistaListarMesas;
import dominio.Jugador;

/**
 *
 * @author Usuario
 */
public class ControladorUnirse {
    
        private final Fachada fachada;
        private final IVistaListarMesas vista;

    public ControladorUnirse(Fachada fachada, IVistaListarMesas vista) {
        this.fachada = fachada;
        this.vista = vista;
    }
    public void unirse (int mesa, Jugador jugador) {
        
    }
    public void logout () {
        
    }
}
