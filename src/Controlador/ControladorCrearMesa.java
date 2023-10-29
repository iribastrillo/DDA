/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.FachadaServicios;
import Vista.IVistaCrearMesa;
import dominio.Crupier;
import dominio.EnumTipoApuesta;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorCrearMesa {
          private final FachadaServicios fachada;
        private final IVistaCrearMesa vista;
        EnumTipoApuesta tipoApuesta;

    public ControladorCrearMesa(FachadaServicios fachada, IVistaCrearMesa vista) {
        this.fachada = fachada;
        this.vista = vista;
        System.out.println("ControladorCrearMesa: Caso de Uso Crupier");

    }
    
    public void cargarListaTiposDeApuestas(){
        //Esta logica va en el controlador ? o en el servicio mejor?
        EnumTipoApuesta[] valoresEnum = EnumTipoApuesta.values();
        String[] valoresEnumStrings = new String[valoresEnum.length];
        for (int i = 0; i < valoresEnum.length; i++) {
            valoresEnumStrings[i] = valoresEnum[i].name();
        }
        vista.cargarListaTiposDeApuestas(valoresEnumStrings);
    }

    public void tipoApuestaSeleccionada(String tipoApuestaSeleccionada) {
             tipoApuesta = EnumTipoApuesta.valueOf(tipoApuestaSeleccionada);
         
            

    }

    public void inciarMesa(Crupier c,String[] tiposDeApuesta) {
        
        //castear los string a un ArrayList de EnumTiposDeApuesta
        ArrayList<EnumTipoApuesta> tiposDeApuestaSeleccionados=new ArrayList<>();
        for (String tipoApuesta:tiposDeApuesta){
            tiposDeApuestaSeleccionados.add(EnumTipoApuesta.valueOf(tipoApuesta));
        }
        fachada.iniciarMesa(c,tiposDeApuestaSeleccionados);
    }
}
