/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.EnumTipoApuesta;
import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public interface IVistaMesaJugador {

    public void abandonar();

    public void mostrarTiposDeApuesta(ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados);
    
    public void refrescar ();

    public void mostrarDialogoDeError(String message);

    public void bloquear();
}
