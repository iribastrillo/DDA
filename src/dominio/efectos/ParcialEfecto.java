/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.efectos;

import dominio.Mesa;
import java.util.Objects;

/**
 *
 * @author nacho
 */
public class ParcialEfecto implements StrategyEfecto {

    private String nombreEfecto = "Parcial";

    @Override
    public int obtenerNumero(Mesa m) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
