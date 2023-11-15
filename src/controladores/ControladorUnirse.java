/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
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
    private ArrayList<Mesa> mesasActivas;

    public ControladorUnirse(Fachada fachada, IVistaUnirse vista) {
        this.fachada = fachada;
        this.fachada.agregar(this);
        this.vista = vista;
        this.mesasActivas = this.getMesasActivas();
    }
    public void unirse (int idMesa, Jugador jugador){   
            try {
                Mesa mesa=fachada.agregar(idMesa,jugador);
                ModeloMesaJugador modelo = new ModeloMesaJugador (
                jugador.getCedula(),
                mesa.getId());
                this.vista.mostrarMesaJugador(modelo);
            } catch (MesaNoEncontradaException   |UsuarioYaEstaEnLaMesaException ex) {
                vista.mostrarDialogoDeError(ex.getMessage());
             } 
    }
    
    public void refrescar () {
        for (Mesa mesa: mesasActivas) {
            mesa.agregar(this);
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EnumEventos.FACHADA_NUEVA_MESA_AGREGADA.equals(evento)) {
            this.vista.cargarMesasActivas();
        }
        if (EnumEventos.FACHADA_MESA_REMOVIDA.equals(evento)) {
            this.vista.cargarMesasActivas();
        }
     }

    public ArrayList<Mesa> getMesasActivas() {
        this.mesasActivas = this.fachada.getMesasActivas();
        return this.mesasActivas;
    }
}
