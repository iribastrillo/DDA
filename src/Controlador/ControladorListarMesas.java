/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.FachadaServicios;
import Vista.IVistaListarMesas;

/**
 *
 * @author Usuario
 */
public class ControladorListarMesas {
    
        private final FachadaServicios fachada;
        private final IVistaListarMesas vista;

    public ControladorListarMesas(FachadaServicios fachada, IVistaListarMesas vista) {
        this.fachada = fachada;
        this.vista = vista;
        
                System.out.println("Caso de Uso Jugador");

    }
        
        
    
}
