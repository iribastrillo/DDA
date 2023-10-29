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
    
    private ArrayList<Mesa> mesasActivas;
    private ArrayList<Mesa> mesasCerradas; //O bloqueadas?

    public ServicioMesas( ) {
        this.mesasActivas = new ArrayList<>();
        this.mesasCerradas = new ArrayList<>();
    }

    public Mesa agregar(Crupier c, ArrayList<EnumTipoApuesta> tipoApuestas) {
      /// Agregar excepciones si hay..
        Mesa m = new Mesa(tipoApuestas,c);
        mesasActivas.add(m);
        
        return m;

    }
    
}
