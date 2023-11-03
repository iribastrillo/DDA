/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import Exceptions.UsuarioYaEstaEnLaMesaException;
import dominio.Jugador;
import dominio.Mesa;

/**
 *
 * @author Usuario
 */
public interface IVistaUnirse {
    public void cargarMesasActivas ();
    public void mostrarMesaJugador (Mesa mesa, Jugador jugador);
    public void logout ();

    public void mostrarDialogoDeError(UsuarioYaEstaEnLaMesaException e);
}
