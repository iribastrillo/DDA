/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Crupier;
import dominio.EnumTipoApuesta;
import dominio.Mesa;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ServicioMesas {

    public ArrayList<Mesa> getMesasActivas() {
        return mesasActivas;
    }

    public void setMesasActivas(ArrayList<Mesa> mesasActivas) {
        this.mesasActivas = mesasActivas;
    }

    public ArrayList<Mesa> getMesasCerradas() {
        return mesasCerradas;
    }

    public void setMesasCerradas(ArrayList<Mesa> mesasCerradas) {
        this.mesasCerradas = mesasCerradas;
    }
    
    private ArrayList<Mesa> mesasActivas;
    private ArrayList<Mesa> mesasCerradas; //O bloqueadas?

    public ServicioMesas( ) {
        this.mesasActivas = new ArrayList<>();
        this.mesasCerradas = new ArrayList<>();
    }

    public Mesa agregar(Mesa mesa) {
      /// Agregar excepciones si hay..
        mesasActivas.add(mesa);        
        return mesa;
    }    
}
