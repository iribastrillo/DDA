/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.efectos;

import dominio.Mesa;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author nacho
 */
public class ParcialEfecto implements StrategyEfecto {

    private String nombreEfecto = "Parcial";
    private Mesa mesa = null;

    public ParcialEfecto(Mesa m) {
        this.mesa = m;
    }

    //  Modo aleatorio parcial:
    //la bola determina un valor aleatorio, pero asegurando de no repetir los últimos 3 valores. Por 
//ejemplo, si en una ronda sale el número N, N no volverá a salir sorteado durante al menos las siguientes 3 rondas.
    @Override
    public int obtenerNumero(Mesa m) {
        List<Integer> numerosSorteados = mesa.getNumerosSorteados();
        List<Integer> ultimosTres = numerosSorteados.subList(Math.max(numerosSorteados.size() - 3, 0), numerosSorteados.size());
        int numeroAleatorio = 0;
        Random random = new Random();
        
        do {
            numeroAleatorio = random.nextInt(37);
        } while (ultimosTres.contains(numeroAleatorio));
        
        return numeroAleatorio;
    }

    @Override
    public String getNombreEfecto() {
        return this.nombreEfecto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompletoEfecto other = (CompletoEfecto) obj;
        return Objects.equals(this.nombreEfecto, other.getNombreEfecto());
    }

    @Override
    public String toString() {
        return "CompletoEfecto{" + "nombreEfecto=" + nombreEfecto + '}';
    }
}
