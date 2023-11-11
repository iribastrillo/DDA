/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
import Exceptions.EfectoException;
import Exceptions.MesaNoEncontradaException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import Logica.Fachada;
import dominio.EnumEventos;
import dominio.Jugador;
import vistas.IVistaUnirse;
import dominio.Mesa;
import dominio.modelosVista.ModeloMesaJugador;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class ControladorUnirse implements Observador{
    
    private final Fachada fachada;
    private final IVistaUnirse vista;

    public ControladorUnirse(Fachada fachada, IVistaUnirse vista) {
        this.fachada = fachada;
        this.fachada.agregar(this);
        this.vista = vista;
    }
    public void unirse (int idMesa, Jugador jugador){   
            try {
                Mesa mesa=fachada.agregar(idMesa,jugador);
                ModeloMesaJugador modelo = new ModeloMesaJugador (
                jugador.getNombreCompleto(),
                jugador.getCedula(),
                jugador.getSaldo(),
                mesa.getId(),
                mesa.getRondaActual().getId(),
                mesa.getUltimoSorteado());
                this.vista.mostrarMesaJugador(modelo);
            } catch (MesaNoEncontradaException   |UsuarioYaEstaEnLaMesaException ex) {
                vista.mostrarDialogoDeError(ex.getMessage());
             } 
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
         if (EnumEventos.FACHADA_NUEVA_MESA_AGREGADA.equals(evento)) {
            this.vista.cargarMesasActivas();
        }
     }

    public ArrayList<Mesa> getMesasActivas() {
        return this.fachada.getMesasActivas();
    }
}
