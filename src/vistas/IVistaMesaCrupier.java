/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.EnumTipoApuesta;
import dominio.Mesa;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface IVistaMesaCrupier {

    public void mostrarTiposApuestaSeleccionados(ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados);

    public void cargarNumeroDeMesaEnPanel(int id);

    public void cargarTotalApostadoEnPanel(Mesa m);

    public void cargarNumeroDeRondaEnPanel(int id);

    public void cargarNumeroDeApuestasEnPanel(int cantidadApuestas);


    public void cargarDropdownEfectos(String[] valoresEnumStrings);
    public void cargarListaJugadores(ArrayList<ModeloInfoCrupier> jugadoresSaldo);
    
}
