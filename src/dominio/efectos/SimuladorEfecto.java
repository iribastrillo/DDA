/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.efectos;

import Exceptions.EfectoException;
import dominio.Mesa;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author nacho
 */
public class SimuladorEfecto implements StrategyEfecto {

    private String nombreEfecto = "Simulador";
    private Mesa mesa = null;

    public SimuladorEfecto(Mesa m) {
        this.mesa = m;
    }

    //• Modo simulador: la bola sortea únicamente entre
    //los números que tienen Apuesta Directa, más el cero.
    @Override
    public int obtenerNumero(Mesa m)  {
        
         Random random = new Random();
       

        ArrayList<Integer> numerosConApuestaDirecta = m.getNumerosConApuestaDirecta();
        if (numerosConApuestaDirecta.size() == 0) {
            //Si no hay numeros con apuesta directa realizo el sorteo con todos los numeros el sorteo igualmente
            return  random.nextInt(37);
//            throw new EfectoException("no hay apuestas en numeros para realizar el efecto simulador");
        } else {
            //agregar el cero si no esta
            if(!numerosConApuestaDirecta.contains(0)){
                numerosConApuestaDirecta.add(0);
            }
            int rnd = random.nextInt(numerosConApuestaDirecta.size() - 1);
            return numerosConApuestaDirecta.get(rnd);
        }

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
