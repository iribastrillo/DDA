/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.Casillero;
import dominio.EnumTipoApuesta;
import dominio.Mesa;
import dominio.modelosVista.EstadisticaCrupier;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public interface IVistaMesaCrupier {

    public void mostrarTiposApuestaSeleccionados(ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados);

    public void cargarNumeroDeMesaEnPanel(int id);

    public void cargarTotalApostadoEnPanel(int balance);

    public void cargarNumeroDeRondaEnPanel(int id);

    public void cargarNumeroDeApuestasEnPanel(int cantidadApuestas);

    public void cargarDropdownEfectos(String[] valoresEnumStrings);
    
    public void cargarListaJugadores(ArrayList<ModeloInfoCrupier> jugadoresSaldo);

    public void mostrarMensajeError(String message);

    public void cargarTotalApostado(int totalApostado);
    
    public void cargarCantidadDeApuestas(int cantidadDeApuestas);

    public void cerrarVentana();

    public void actualizar();

    public void cargarUltimoNumeroSorteado(String ultimoSorteado);

    public void cargarFichasEnMesa(ArrayList<Casillero> casilleros);

    public void borrarFichasEnMesa();

    public void cargarNumerosSorteados(String numerosSorteados);

    public void cargarEstadisticasMesa(ArrayList<EstadisticaCrupier> estadisticasCrupier);

    public void cargarSaldoJugadores(ArrayList<ModeloInfoCrupier> saldoJugadores);
    
}
