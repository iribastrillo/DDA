/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
import Exceptions.MesaNoEncontradaException;
import Exceptions.NoTieneSaldoDisponibleException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import dominio.Jugador;
import dominio.Mesa;
import dominio.modelosVista.ModeloInfoCrupier;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ServicioMesas {

    public Mesa agregarJugador(int id, Jugador jugador) throws MesaNoEncontradaException, UsuarioYaEstaEnLaMesaException {
        
        Mesa mesa=getMesa(id);
        if(mesa==null){
            String mensaje=String.format("Mesa con id: %s No encontrada", id);
            throw new MesaNoEncontradaException(mensaje);
        }        
        mesa.agregarJugador(jugador);
        
        //Si no hay excepciones, retorno true.
        return mesa;
     }

    public ArrayList<Mesa> getMesasActivas() {
        return mesasActivas;
    }

    public void setMesasActivas(ArrayList<Mesa> mesasActivas) {
        this.mesasActivas = mesasActivas;
    }

    public ArrayList<Mesa> getMesasCerradas() {
        return mesasCerradas;
    }

    public void setMesasCerradas(ArrayList<Mesa> mesasCerradas) {
        this.mesasCerradas = mesasCerradas;
    }
    
    private ArrayList<Mesa> mesasActivas;
    private ArrayList<Mesa> mesasCerradas; //O bloqueadas?

    public ServicioMesas( ) {
        this.mesasActivas = new ArrayList<>();
        this.mesasCerradas = new ArrayList<>();
    }

    public Mesa agregar(Mesa mesa) {
      /// Agregar excepciones si hay..
        mesasActivas.add(mesa);        
        return mesa;
    }    

    public Mesa getMesa(int mesa) {
        return mesasActivas.get(mesa);
    }

    public ArrayList<ModeloInfoCrupier> obtenerJugadoresSaldoParaMesa(Mesa m) {
        ArrayList<ModeloInfoCrupier> jugadoresSaldo=new ArrayList<>();
        ArrayList<Jugador> jugadores =m.getJugadores();
        for(Jugador j :jugadores){
            ModeloInfoCrupier jugadorSaldo= new ModeloInfoCrupier(j.getNombreCompleto(),j.getSaldoInicial());
            jugadoresSaldo.add(jugadorSaldo);
        }
        return jugadoresSaldo;
    }

    public void abandonar(int idMesa, String idJugador) {
        Mesa mesa = this.getMesa(idMesa);
        this.reembolsarTodo(idMesa, idJugador);
        mesa.removerJugador (idJugador);
    }
    
    public void apostar(int uccode, int monto, int idMesa, String idJugador) throws NoTieneSaldoDisponibleException {
        Mesa mesa = this.getMesa (idMesa);
        Jugador jugador = mesa.getJugador(idJugador);
        if (jugador.getSaldoInicial() < monto) {
            throw new NoTieneSaldoDisponibleException ("Saldo insuficiente.");
        }
        mesa.apostar (idJugador, monto, uccode);
        jugador.descontar (monto);
    }
    
    public void quitarApuesta(int uccode, int monto, int idMesa, String idJugador) {
        Mesa mesa = this.getMesa(idMesa);
        Jugador jugador = mesa.getJugador (idJugador);
        mesa.quitarApuesta (idJugador, uccode);
        jugador.acreditar (monto);
    }
    
    public void reembolsarTodo (int idMesa, String idJugador) {
        Mesa mesa = this.getMesa(idMesa);
        Jugador jugador = mesa.getJugador(idJugador);
        jugador.acreditar(mesa.getRondaActual().reembolsarTodo(idMesa, idJugador));
    }
}
