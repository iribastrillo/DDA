/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.modelosVista;

/**
 *
 * @author nacho
 */
public class ModeloJugador {
    private String jugador;
    private int mesa;
    
    public ModeloJugador (String jugador, int mesa) {
        this.jugador = jugador;
        this.mesa = mesa;
    }

    public String getJugador() {
        return jugador;
    }

    public int getMesa() {
        return mesa;
    }
}
