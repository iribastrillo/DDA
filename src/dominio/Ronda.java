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
import dominio.modelosVista.EstadisticasJugador;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nacho
 */
public class Ronda {

    private int id;
    private int balanceAnterior;
    private int balancePosterior;
    private int recoleccion;
    private int liquidacion;
    private int totalApostado;
    private int totalPerdido;
    private int totalGanado;
    private int balance;
    private int numeroSorteado;
    private HashMap<String, Apuesta> apuestas;
    private StrategyEfecto efecto;
    private Mesa mesa;

    public Ronda(Mesa mesa,int balanceAnterior) {
        this.id = mesa.getUltimaIdRonda();
        this.totalApostado = 0;
        this.totalPerdido = 0;
        this.totalGanado=0;
        this.balance = 0;
        this.balanceAnterior = balanceAnterior;
        this.balancePosterior = 0;
        this.recoleccion = 0;
        this.liquidacion = 0;
        this.apuestas = new HashMap<>();
        this.efecto = new CompletoEfecto();
        this.mesa = mesa;

    }

    public int getTotalGanado() {
        return totalGanado;
    }

    public void setTotalGanado(int totalGanado) {
        this.totalGanado = totalGanado;
    }

    public int getTotalPerdido() {
        return totalPerdido;
    }

    public void setTotalPerdido(int totalPerdido) {
        this.totalPerdido = totalPerdido;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getBalanceAnterior() {
        return balanceAnterior;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado() {
        int totalApostado = 0;
        for (Apuesta a : apuestas.values()) {
            totalApostado += a.getTotalApostado();
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

    public void setBalanceAnterior(int balanceAnterior) {
        this.balanceAnterior = balanceAnterior;
    }

    public int getBalancePosterior() {
        return balancePosterior;
    }

    public void setBalancePosterior(int balancePosterior) {
        this.balancePosterior = balancePosterior;
    }

    public int getRecoleccion() {
        return recoleccion;
    }

    public void setRecoleccion(int recoleccion) {
        this.recoleccion = recoleccion;
    }

    public int getLiquidacion() {
        return liquidacion;
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

    public void apostar(String idJugador, Casillero casillero) {

        Apuesta apuesta = this.getApuesta(idJugador);
        if (apuesta != null) {
            apuesta.apostar(casillero);
            // ver de cambiar esto a un parametro que se va sumando
//            setTotalApostado();
        } else {
            apuesta = new Apuesta(idJugador);
            apuesta.apostar(casillero);
            apuestas.put(idJugador, apuesta);
        }
        setTotalApostado();
    }

    public void agregarFichas(String idJugador, int monto, int uccode) {
        Apuesta apuesta = this.getApuesta(idJugador);
        apuesta.agregarFichas(monto, uccode);
        setTotalApostado();
    }

    public Apuesta getApuesta(String idJugador) {
        Apuesta apuesta = null;
        if (apuestas.containsKey(idJugador)) {
            apuesta = apuestas.get(idJugador);
        }
        return apuesta;
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

    void pagarApuestas(Casillero casilleroSorteado) {
        CasilleroNumerico casilleroNumericoSorteado = (CasilleroNumerico) casilleroSorteado;
        int montoGanado = 0;
        int totalPerdido;
        int totalGanado = 0;
        for (Apuesta apu : apuestas.values()) {
            totalPerdido = apu.getTotalApostado(); // Asumo que perdio todo en principio.
            // checkeo si el jugador le emboco al numero directo
            Casillero casilleroGanador = apu.getCasilleros().get(String.valueOf(casilleroNumericoSorteado.uccode));
            if (casilleroGanador != null) {
                // pago por acierto de numero
                montoGanado = casilleroGanador.monto * casilleroGanador.factorDePago;
                totalPerdido -= montoGanado;
                totalGanado += montoGanado;
                mesa.getJugador(apu.getIdJugador()).acreditar(montoGanado);
                // lo que pierde la casa
                this.totalPerdido += montoGanado;
                System.out.println("El Jugador le emboco al numero, apuesta directa...");
            }

            // Si el casillero sorteado no es el 0, procedemos a checkear
            // de que color o docena es, dependiendo de que tipos de apuestas estan activas en la mesa
            if (casilleroNumericoSorteado.uccode != 0) {

                //Si esta habilitado el tipo de apuesta por colores
                /// ver si el color del uuid que selecciono esta en la lista de los rojos
                //ver el color del numero que salio
                if (mesa.listarTiposApuestaSeleccionados().contains(EnumTipoApuesta.Colores)) {
                    //pago por si tambiensi  acierto al color 
                    Casillero casilleroColor = apu.getCasilleros().get((casilleroNumericoSorteado.getColor().equals("Rojo")) ? String.valueOf(43) : String.valueOf(44));
                    if (casilleroColor != null) {
                        montoGanado = apu.getTotalApostadoEnCasillero(casilleroColor) * casilleroColor.factorDePago;
                        totalPerdido -= montoGanado;
                        totalGanado += montoGanado;
                        mesa.getJugador(apu.getIdJugador()).acreditar(montoGanado);
                        // lo que pierde la casa
                        this.totalPerdido += montoGanado;
                        System.out.println("El jugador emboco al color, pagando...");
                    }
                }

            }
            //Si esta habilitado el tipo de apuesta por docenas
            // me fijo en las apuestas si apostaron a alguna docena perteneciente a la docena del numero que salio,
            // es decir si el numero que salio pertenece a la 1ra docena y hay una apuesta sobre el casillero 1ra docena ahi se paga
            if (mesa.listarTiposApuestaSeleccionados().contains(EnumTipoApuesta.Docenas)) {
                Casillero casilleroDocena = apu.getCasilleros().get(String.valueOf(casilleroNumericoSorteado.getDocena()));
                if (casilleroDocena != null) {
                    montoGanado = apu.getTotalApostadoEnCasillero(casilleroDocena) * casilleroDocena.factorDePago;
                    totalPerdido -= montoGanado;
                    totalGanado += montoGanado;
                    mesa.getJugador(apu.getIdJugador()).acreditar(montoGanado);
                    // lo que pierde la casa
                    this.totalPerdido += montoGanado;
                    System.out.println("El jugador emboco a la docena, pagando...");
                }
            }
            mesa.agregarEstadisticaDelJugador (apu.getIdJugador(), new EstadisticasJugador (
                    this.id,
                    totalGanado + totalPerdido,
                    totalGanado,
                    totalPerdido,
                    totalGanado - Math.abs(totalPerdido)
            ));    
        }
        // lo que gana la casa (Balance)
        //this.totalGanado=this.totalApostado-this.totalPerdido;  // total perdido  es recoleccion (apuestas perdidas por los jugadores)
        this.balance=this.totalApostado-this.totalPerdido;     // total ganado, es apuestas pagas liquidacion
        this.balancePosterior=this.balanceAnterior+this.balance;
    }
   
    public boolean yaAposto(String idJugador, int uccode) {
        boolean yaAposto = false;
        Apuesta apuesta = this.apuestas.get(idJugador);
        if (apuesta != null) {
            if (apuesta.getCasillero(uccode) != null) {
                yaAposto = true;
            }
        }

        return yaAposto;
    }

    public ArrayList<Casillero> getCasillerosConApuestas() {

        ArrayList<Casillero> casilleros = new ArrayList();
        for (Apuesta a : apuestas.values()) {
            for (Casillero c : a.getCasilleros().values()) {
                casilleros.add(c);
            }
        }
        return casilleros;
    }
}
