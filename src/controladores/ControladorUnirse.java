/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Exceptions.UsuarioYaEstaEnLaMesaException;
import Logica.Fachada;
import dominio.Jugador;
import vistas.IVistaUnirse;
import dominio.Mesa;

/**
 *
 * @author Usuario
 */
public class ControladorUnirse {
    
        private final Fachada fachada;
        private final IVistaUnirse vista;

    public ControladorUnirse(Fachada fachada, IVistaUnirse vista) {
        this.fachada = fachada;
        this.vista = vista;
    }
    public void unirse (int id, Jugador jugador) throws UsuarioYaEstaEnLaMesaException {
        Mesa mesa = fachada.getMesa(id);
        try {
            mesa.agregarJugador(jugador);
            this.vista.mostrarMesaJugador(mesa, jugador);
        } catch (UsuarioYaEstaEnLaMesaException e) {
            this.vista.mostrarDialogoDeError(e);
        }
    }
}
