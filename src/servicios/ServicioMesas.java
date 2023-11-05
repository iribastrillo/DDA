/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
import Exceptions.MesaNoEncontradaException;
import Exceptions.UsuarioYaEstaEnLaMesaException;
import dominio.Jugador;
import dominio.Mesa;
import dominio.modelosVista.ModeloJugadorSaldo;
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

    public ArrayList<ModeloJugadorSaldo> obtenerJugadoresSaldoParaMesa(Mesa m) {
        ArrayList<ModeloJugadorSaldo>jugadoresSaldo=new ArrayList<>();
        ArrayList<Jugador> jugadores =m.getJugadores();
        for(Jugador j :jugadores){
            ModeloJugadorSaldo jugadorSaldo= new ModeloJugadorSaldo(j.getNombreCompleto(),j.getSaldoInicial());
            jugadoresSaldo.add(jugadorSaldo);
        }
        return jugadoresSaldo;
    }
}
