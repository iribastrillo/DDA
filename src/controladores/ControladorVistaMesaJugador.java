/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
import Logica.Fachada;
import dominio.EnumEventos;
import dominio.Mesa;
import vistas.IVistaMesaJugador;

/**
 *
 * @author nacho
 */
public class ControladorVistaMesaJugador implements Observador {
    
    private final IVistaMesaJugador vista;
    private final Fachada fachada;
    
    public ControladorVistaMesaJugador (IVistaMesaJugador vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
        this.fachada.agregar(this);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        EnumEventos e = (EnumEventos) evento;
        if (e == EnumEventos.ABANDONAR_MESA) {
            this.vista.abandonar();
        }
    }

    public void mostrarTiposDeApuesta(Mesa mesa) {
        vista.mostrarTiposDeApuesta (mesa.listarTiposApuestaSeleccionados());
    }
}
