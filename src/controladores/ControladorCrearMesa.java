/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Exceptions.UsuarioYaExisteException;
import Logica.Fachada;
import vistas.IVistaCrearMesa;
import dominio.Crupier;
import dominio.EnumTipoApuesta;
import dominio.Mesa;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControladorCrearMesa {

    private final Fachada fachada;
    private final IVistaCrearMesa vista;
    EnumTipoApuesta tipoApuesta;

    public ControladorCrearMesa(Fachada fachada, IVistaCrearMesa vista) {
        this.fachada = fachada;
        this.vista = vista;
    }

    public void cargarListaTiposDeApuestas() {
        //Esta logica va en el controlador ? o en el servicio mejor?
        EnumTipoApuesta[] valoresEnum = EnumTipoApuesta.values();
        String[] valoresEnumStrings = new String[valoresEnum.length];
        for (int i = 0; i < valoresEnum.length; i++) {
            
            // Apuesta directa esta debe estar por defecto,
            //entonces no se lo pasaremos a la listas de tipos de apuestas para seleccionar
            if (valoresEnum[i].name() != "Apuesta_Directa") {

                valoresEnumStrings[i] = valoresEnum[i].name();
            }
        }
        vista.cargarListaTiposDeApuestas(valoresEnumStrings);
    }

    public void tipoApuestaSeleccionada(String tipoApuestaSeleccionada) {
        tipoApuesta = EnumTipoApuesta.valueOf(tipoApuestaSeleccionada);

    }

    public void inciarMesa(Crupier c, String[] tiposDeApuesta) {

        //castear los string a un ArrayList de EnumTiposDeApuesta
        ArrayList<EnumTipoApuesta> tiposDeApuestaSeleccionados = new ArrayList<>();
        
        //Se agrega el tipo de apuesta por defecto  !, linea comentada porque se lo agrego en clase Mesa al iniciar la misma Preguntar!!     
        //tiposDeApuestaSeleccionados.add(EnumTipoApuesta.Apuesta_Directa);
        
        //Se agregan los tipos seleccionados en UI, ver que pasa si la lista estta vacia
        for (String tipoApuesta : tiposDeApuesta) {
            tiposDeApuestaSeleccionados.add(EnumTipoApuesta.valueOf(tipoApuesta));
        }
        Mesa mesaIniciada;
        try {
            mesaIniciada = fachada.iniciarMesa(c, tiposDeApuestaSeleccionados);
            
             vista.mostrarMesaCrupier(mesaIniciada);
        } catch (UsuarioYaExisteException ex) {
            vista.mostaMensajeError(ex.getMessage());
            Logger.getLogger(ControladorCrearMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
