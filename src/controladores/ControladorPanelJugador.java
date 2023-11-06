/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Exceptions.NoPuedeAbandonarMesaException;
import Logica.Fachada;
import vistas.IVistaMesaJugador;

/**
 *
 * @author nacho
 */
public class ControladorPanelJugador {
    
    private Fachada fachada;
    
    public ControladorPanelJugador () {
        this.fachada = Fachada.getInstancia();
    }
    
    public void abandonar (int mesa, String jugador) throws NoPuedeAbandonarMesaException {
        fachada.abandonar(mesa, jugador);
    }
}
