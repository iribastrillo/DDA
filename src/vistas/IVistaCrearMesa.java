/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.Mesa;

/**
 *
 * @author Usuario
 */
public interface IVistaCrearMesa {
    
   public void cargarListaTiposDeApuestas(String[] tiposApuesta);
   public void tipoDeApuestaSeleccionado();
   public void iniciarMesa();

    public void mostrarMesaCrupier(Mesa mesaIniciada);

    public void mostaMensajeError(String message);
}
