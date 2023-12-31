/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.UsuarioYaExisteException;
import dominio.Crupier;
import dominio.Jugador;
import dominio.Mesa;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class DatosPrueba {

    public static void iniciar(Fachada fachada) throws UsuarioYaExisteException 
    {
        Jugador[] jugadores = new Jugador[]{
            new Jugador(1000, "Jugador_1", "201", "aaa"),
            new Jugador(500, "Jugador_2", "202", "bbb"),
            new Jugador(203, "Jugador_3", "203", "ccc"),
            new Jugador(204, "Jugador_4", "204", "ddd"),
            new Jugador(205, "Jugador_5", "205", "eee")
        };

        Crupier[] crupieres = new Crupier[]{
            new Crupier( "Alfonso Paredes", "101", "aaa"),
            new Crupier( "Croupier_2", "102", "bbb"),
            new Crupier( "Croupier_3", "103", "ccc")
        };

        for (Crupier c : crupieres) {
            fachada.agregar(c);
        }

        for (Jugador j : jugadores) {
            fachada.agregar(j);
        }   
    }

}
