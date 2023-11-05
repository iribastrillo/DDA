/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Common.Observable;
import Common.Observador;
import Logica.Fachada;
import dominio.EnumEfectos;
import dominio.EnumEventos;
import dominio.EnumTipoApuesta;
import vistas.IVistaMesaCrupier;
import dominio.Mesa;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorVistaMesaCrupier implements Observador {

    private final Fachada fachada;
    private final IVistaMesaCrupier vista;
    private final Mesa m;

    // Nota: le pasamos la Mesa al la vista y voy a sacar Fachada, si se precisa se instancia..
    // porque para cargar listas y demas eventos de la mesa, se precisa saber de que mesa se esta hablando
    //Entonces pasamos mesa
    public ControladorVistaMesaCrupier(Mesa mesa,IVistaMesaCrupier vista) {
        this.fachada = Fachada.getInstancia();
        this.vista = vista;
        this.m=mesa;
        this.fachada.agregar(this);
    }

    public void mostrarTiposApuestaSeleccionados(Mesa m) {
        vista.mostrarTiposApuestaSeleccionados(m.listarTiposApuestaSeleccionados());
    }

    public void cargarNumeroDeMesaEnPanel(Mesa m) {
        vista.cargarNumeroDeMesaEnPanel(m.getId());
    }

    public void cargarTotalApostadoEnPanel(Mesa m) {
        vista.cargarTotalApostadoEnPanel(m);
    }

    public void cargarNumeroDeRondaEnPanel(Mesa m) {
        vista.cargarNumeroDeRondaEnPanel(m.getRondaActual().getId());
    }

    public void cargarNumeroDeApuestasEnPanel(Mesa m) {
        vista.cargarNumeroDeApuestasEnPanel(m.getRondaActual().getCantidadApuestas());
    }
    
    private void cargarJugadoresYSaldoEnMesa(Mesa m){
           ArrayList<ModeloInfoCrupier> jugadoresSaldo= this.fachada.cargarJugadoresSaldo(m);
             
              this.vista.cargarListaJugadores(jugadoresSaldo);
    }
    
    public void cargarDropdownEfectos(){
 
        
        EnumEfectos[] valoresEnum = EnumEfectos.values();
        String[] valoresEnumStrings = new String[valoresEnum.length];
        for (int i = 0; i < valoresEnum.length; i++) {
            
       

                valoresEnumStrings[i] = valoresEnum[i].name();
          
        }
        vista.cargarDropdownEfectos(valoresEnumStrings);
 
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EnumEventos.LOGIN_JUGADOR_MESA.equals(evento)) {
            // Ccrear Modelo que pase el nombre del jugador y el saldo para mostrar en la vista (esto se tiene que cargar en searvicios mesa), previa llamada a fachada
      
                    cargarJugadoresYSaldoEnMesa(m);
            
            //ArrayList<ModeloListarJugadoresSaldo> jugadoresSaldo
           
        }
    }
 
}
