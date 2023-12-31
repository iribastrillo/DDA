/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nacho
 */
public class Apuesta {

    private String jugador;
    private HashMap<String, Casillero> casilleros;

    public Apuesta(String idJugador) {
        this.jugador = idJugador;
        this.casilleros = new HashMap<>();
    }

    public String getIdJugador() {
        return jugador;
    }

    public ArrayList<Integer> getNumerosApostados() {
          ArrayList<Integer>  numerosApostados = new ArrayList<>();
        for (Casillero c : casilleros.values()) {
            numerosApostados.add(c.getUccode());
        }
        return numerosApostados;
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

    public void apostar(Casillero casillero) {  
        
        this.casilleros.put(String.valueOf(casillero.uccode), casillero);
    }

    public boolean isEmpty() {
        return casilleros.isEmpty();
    }

    public int getTotalApostadoByJugador(String idJugador) {
        int total = 0;
        for (Casillero c : casilleros.values()) {
            total += c.getMonto();
        }
        return total;
    }

    public int getTotalApostado() {
        int total = 0;
        for (Casillero c : casilleros.values()) {
            total += c.getMonto();
        }
        return total;
    }
    
    public int getTotalApostadoEnCasillero(Casillero c){
            return casilleros.get(String.valueOf(c.uccode)).getMonto();
    }

    public int getCantidadApuestas() {
        int cantidadApuestas = 0;
        for (Casillero c : casilleros.values()) {
            cantidadApuestas += 1;
        }
        return cantidadApuestas;
    }
    
    public Casillero getCasillero (int uccode) {
        return this.casilleros.get(String.valueOf(uccode));
    }

    void agregarFichas(int monto, int uccode) {
        Casillero casillero = this.getCasillero(uccode);
        casillero.agregarMonto(monto);
    }

    public boolean apostoRojo() {
        return this.casilleros.containsKey("43");
    }

    public boolean apostoNegro() {
        return this.casilleros.containsKey("44");
    }
}
