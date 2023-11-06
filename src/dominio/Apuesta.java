/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package dominio;

import java.util.HashMap;

/**
 *
 * @author nacho
 */
public class Apuesta {

    private String jugador;
    private HashMap <String, Casillero> casilleros;
    
    public Apuesta (String idJugador) {
        this.jugador = idJugador;
        this.casilleros = new HashMap<> ();
    }

    public String getIdJugador() {
        return jugador;
    }

    public void setIdJugador(String idJugador) {
        this.jugador = idJugador;
    }

    public HashMap<String, Casillero> getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(HashMap<String, Casillero> casilleros) {
        this.casilleros = casilleros;
    }
    
    public void apostar (int monto, int uccode) {
        this.casilleros.put(String.valueOf(uccode), new Casillero (monto, uccode));
        System.out.println (casilleros.size());
    }

    public void quitarApuesta(int uccode) {
        this.casilleros.remove(String.valueOf(uccode));
        System.out.println ("APUESTA ELIMINADA");
    }
}