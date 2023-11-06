/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.modelosVista.ModeloMesaJugador;

/**
 *
 * @author Usuario
 */
public interface IVistaUnirse {
    public void cargarMesasActivas ();
    public void mostrarMesaJugador (ModeloMesaJugador modelo);
    public void logout ();
    public void mostrarDialogoDeError(String mensaje);
}
