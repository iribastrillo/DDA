/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Exceptions.EfectoException;
import Exceptions.NoSeHaSeleccionadoUnEfectoException;
import dominio.efectos.CompletoEfecto;
import dominio.efectos.ParcialEfecto;
import dominio.efectos.SimuladorEfecto;
import dominio.efectos.StrategyEfecto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author nacho
 */
public class Ronda {

    private int id;
    private float balanceAnterior;
    private float balancePosterior;
    private float recoleccion;
    private float liquidacion;
    private int totalApostado;
    private int numeroSorteado;
    private HashMap<String, Apuesta> apuestas;
    private StrategyEfecto efecto;
    private Mesa mesa;

    public Ronda(Mesa mesa) {
        this.id = mesa.getUltimaIdRonda();
        this.totalApostado = 0;
        this.balanceAnterior = 0;
        this.balancePosterior = 0;
        this.recoleccion = 0;
        this.liquidacion = 0;
        this.apuestas = new HashMap<>();
        this.efecto = new CompletoEfecto();
        this.mesa = mesa;

    }

    public int getId() {
        return id;
    }

    public float getBalanceAnterior() {
        return balanceAnterior;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado() {

        int totalApostado = 0;
        for (Apuesta apu : apuestas.values()) {
            totalApostado += apu.getTotalApostado();
        }
        this.totalApostado = totalApostado;

    }

    public HashMap<String, Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(HashMap<String, Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public StrategyEfecto getEfecto() {
        return efecto;
    }

    public void setEfecto(StrategyEfecto efecto) {
        this.efecto = efecto;
    }

    public void setBalanceAnterior(float balanceAnterior) {
        this.balanceAnterior = balanceAnterior;
    }

    public float getBalancePosterior() {
        return balancePosterior;
    }

    public void setBalancePosterior(float balancePosterior) {
        this.balancePosterior = balancePosterior;
    }

    public float getRecoleccion() {
        return recoleccion;
    }

    public void setRecoleccion(float recoleccion) {
        this.recoleccion = recoleccion;
    }

    public float getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(float liquidacion) {
        this.liquidacion = liquidacion;
    }

    public int getNumeroSorteado() throws EfectoException {
        this.numeroSorteado = efecto.obtenerNumero(mesa);
        return numeroSorteado;
    }

    public int getCantidadApuestas() {
        int cantidadApuestas = 0;
        for (Apuesta apu : apuestas.values()) {
            cantidadApuestas += apu.getCantidadApuestas();
        }
        return cantidadApuestas;
    }

    public void apostar(String idJugador, int monto, int uccode) {
        Apuesta apuesta = this.getApuesta(idJugador);
        if (apuesta != null) {
            apuesta.apostar(monto, uccode);
            // ver de cambiar esto a un parametro que se va sumando
            setTotalApostado();
        } else {
            apuesta = new Apuesta(idJugador);
            apuesta.apostar(monto, uccode);
            apuestas.put(idJugador, apuesta);
            // ver de cambiar esto a un parametro que se va sumando
            setTotalApostado();
        }
    }

    private Apuesta getApuesta(String idJugador) {
        Apuesta apuesta = null;
        if (apuestas.containsKey(idJugador)) {
            apuesta = apuestas.get(idJugador);
        }
        return apuesta;
    }

    public void quitarApuesta(String idJugador, int uccode) {
        Apuesta apuesta = this.getApuesta(idJugador);
        apuesta.quitarApuesta(uccode);
        if (apuesta.isEmpty()) {
            apuestas.remove(idJugador);
        }
    }

    public int reembolsarTodo(int idMesa, String idJugador) {
        int reembolso = 0;
        Apuesta apuesta = this.getApuesta(idJugador);
        if (apuesta != null) {
            reembolso = apuesta.getTotalApostadoByJugador(idJugador);
        }
        return reembolso;
    }

    public boolean puedeAbandonar(String idJugador) {
        return !apuestas.containsKey(idJugador);
    }

    public void ActualizarEfecto(String efecto) throws NoSeHaSeleccionadoUnEfectoException {

        // Habra que checkear si la ronda esta activa o bloqueada?,  o es instantaneo, cuando se lanza se pasa la ronda activa a la lista de rondas completadas?
        if (!efecto.isEmpty() || !efecto.isBlank()) {
            StrategyEfecto strategyEfecto = null;
            switch (efecto) {
                case "COMPLETO":
                    strategyEfecto = new CompletoEfecto();
                    break;
                case "PARCIAL":
                    strategyEfecto = new ParcialEfecto(mesa);
                    break;
                case "SIMULADOR":
                    strategyEfecto = new SimuladorEfecto(mesa);
            }
            this.efecto = strategyEfecto;
            System.out.printf("\nEfecto seleccionado %s  y configurado a la ronda actual ", efecto);
        } else {
            throw new NoSeHaSeleccionadoUnEfectoException("No se ha seleccionado un efecto");
        }
    }

    public ArrayList<Integer> getNumerosConApuestaDirecta() {
        ArrayList<Integer> numerosConApuestaDirecta = new ArrayList<Integer>();
        for (Apuesta apu : apuestas.values()) {
            //por cada apuesta ir al los casilleros y obtener el numero
            for (int numero : apu.getNumerosApostados()) {
                if (numero < 37 && !numerosConApuestaDirecta.contains(numero)) {
                    numerosConApuestaDirecta.add(numero);
                }
            }

        }
        return numerosConApuestaDirecta;
    }

    void pagarApuestas(int numeroSorteado) {
        System.out.println("Ronda: numero sorteado " + String.valueOf(numeroSorteado));
        int factorPagoApuestaDirecta = 36;  //36 a 1
        int factorPagoColores = 2; // 2 a 1  1. Restricciones: si un jugador pierde 
        //una apuesta por valor N a los coloresun color, 
        //no podrá volver a apostar un monto superior a N en la siguiente ronda
        int factorPagoDocena = 3; //factor de pago 3 a 1  Restricciones: no se puede 
        //apostar a más de una docena por ronda.
        
        //Strategy TipoApuestaColores
        if (mesa.listarTiposApuestaSeleccionados().contains(EnumTipoApuesta.Colores)) {
            /// ver si el color del uuid que selecciono esta en la lista de los rojos
            //ver el color del numero que salio
            if (numeroSorteado != 0) {
                if (mesa.getNumerosRojos().contains(numeroSorteado)) {
                    for (Apuesta apu : apuestas.values()) {
                        if (apu.getNumerosApostados().contains(43))// si aposto al rojo
                        {
                            mesa.getJugador(apu.getIdJugador()).acreditar(apu.getTotalApostado() * factorPagoColores);
                        }
                    }

                } else {
                    // el numero es negro
                    for (Apuesta apu : apuestas.values()) {
                        if (apu.getNumerosApostados().contains(44))// si aposto al  negro
                        {
                            mesa.getJugador(apu.getIdJugador()).acreditar(apu.getTotalApostado() * factorPagoColores);
                        }
                    }

                }

            }

        }
        //Strategy TipoApuestaDocenas
        if (mesa.listarTiposApuestaSeleccionados().contains(EnumTipoApuesta.Docenas)) {

            Collection<Apuesta> apus = apuestas.values();

            ArrayList<Integer> numeros = new ArrayList();
            for (Apuesta apu : apus) {
                // Preguntarle a la apuesta si tiene el numero en su lista de numeros
                numeros = apu.getNumerosApostados();
                if (numeroSorteado / 12 <= 1) {
                    //salio en la primera docena
                    for (Integer n : numeros) {
                        if (n / 12 <= 1) {
                            mesa.getJugador(apu.getIdJugador()).acreditar(apu.getTotalApostado() * factorPagoDocena);
                        }
                    }
                } else if ((numeroSorteado / 12 > 1) && (numeroSorteado / 12 <= 2)) {
                    //salio la segunda docena
                    for (Integer n : numeros) {
                        if ((n / 12 > 1) && (n / 12 <= 2)) {
                            mesa.getJugador(apu.getIdJugador()).acreditar(apu.getTotalApostado() * factorPagoDocena);
                        }
                    }
                } else {
                    //salio la tercera docena
                    for (Integer n : numeros) {
                        if (n / 12 > 2) {
                            mesa.getJugador(apu.getIdJugador()).acreditar(apu.getTotalApostado() * factorPagoDocena);
                        }
                    }
                }
            }
        }
        //siempre se checkea si el numero sorteado esta en los numeros apostados
        //Strategy TipoApuestaDirecta
        Collection<Apuesta> apus = apuestas.values();

        ArrayList<Integer> numeros = new ArrayList();
        for (Apuesta apu : apus) {
            numeros = apu.getNumerosApostados();

            for (Integer n : numeros) {
                if (n == numeroSorteado) {
                    mesa.getJugador(apu.getIdJugador()).acreditar(apu.getTotalApostado() * factorPagoApuestaDirecta);
                }

            }
        }

        // apuestas por los casilleros
        // si la apuesta es directa y el numero sorteado es parte de la apuesta
        // pagar apuesta directa
        // si es al color fijarse si los pares o los impares es el color, si sale 0 no gana nadie
        // agregar logica para las docenas
        System.out.println("TERMINO PAGAR A JUGADOR EN RONDA");
    }

}
