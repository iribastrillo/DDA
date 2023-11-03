/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.Usuario;

/**
 *
 * @author Usuario
 */
public interface IVistaLogin {
   public Usuario loginUsuario(String cedula, String password);
   
   public void mostrarMensajeError(String mensaje);
 }
