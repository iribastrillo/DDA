/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.efectos;

import dominio.Mesa;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author nacho
 */
public class CompletoEfecto implements StrategyEfecto {

    private String nombreEfecto = "Completo";

    @Override
    public int obtenerNumero(Mesa m) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(37);

        return numeroAleatorio;
    }

    @Override
    public String getNombreEfecto() {
        return this.nombreEfecto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
