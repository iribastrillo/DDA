/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.UsuarioYaExisteException;
import dominio.Crupier;
import dominio.Jugador;
import dominio.Mesa;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DatosPrueba {

    public static void iniciar() throws UsuarioYaExisteException {

        Jugador[] jugadores = new Jugador[]{
            new Jugador(1000, "Jugador_1", "201", "aaa"),
            new Jugador(500, "Jugador_2", "202", "bbb"),
            new Jugador(203, "Jugador_3", "203", "ccc"),
            new Jugador(204, "Jugador_4", "204", "ddd"),
            new Jugador(205, "Jugador_5", "205", "eee")
        };

        Mesa mesa_1 = new Mesa();
        Mesa mesa_2 = new Mesa();
        Mesa mesa_3 = new Mesa();

        Crupier[] crupieres = new Crupier[]{
            new Crupier(mesa_1, "Croupier_1", "101", "aaa"),
            new Crupier(mesa_2, "Croupier_2", "102", "bbb"),
            new Crupier(mesa_3, "Croupier_3", "103", "ccc")
        };

        for (Crupier c : crupieres) {
            FachadaServicios.getInstancia().agrear(c);
        }

        for (Jugador j : jugadores) {
            FachadaServicios.getInstancia().agrear(j);

        }

    }

}
