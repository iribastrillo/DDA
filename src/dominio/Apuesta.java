/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package dominio;

import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public class Apuesta {

    private String jugador;
    private ArrayList<Casillero> casilleros;
    
    public Apuesta (String idJugador) {
        this.jugador = idJugador;
        this.casilleros = new ArrayList<> ();
    }

    public String getIdJugador() {
        return jugador;
    }

    public void setIdJugador(String idJugador) {
        this.jugador = idJugador;
    }

    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(ArrayList<Casillero> casilleros) {
        this.casilleros = casilleros;
    }
    
    public void apostar (int monto, int uccode) {
        this.casilleros.add(new Casillero (monto, uccode));
        System.out.println ("Apuesta creada");
    }
}