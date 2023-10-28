/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.FachadaServicios;
import Vista.IVistaCrearMesa;

/**
 *
 * @author Usuario
 */
public class ControladorCrearMesa {
          private final FachadaServicios fachada;
        private final IVistaCrearMesa vista;

    public ControladorCrearMesa(FachadaServicios fachada, IVistaCrearMesa vista) {
        this.fachada = fachada;
        this.vista = vista;
        System.out.println("ControladorCrearMesa: Caso de Uso Crupier");

    }
}
