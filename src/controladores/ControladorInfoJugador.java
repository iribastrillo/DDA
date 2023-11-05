/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Exceptions.NoTieneSaldoDisponibleException;
import Logica.Fachada;
import dominio.modelosVista.ModeloInfoJugador;
import java.util.ArrayList;
import vistas.IPanelInfoJugador;

/**
 *
 * @author nacho
 */
public class ControladorInfoJugador {
    
    private Fachada fachada;
    
    public ControladorInfoJugador () {
        this.fachada = Fachada.getInstancia();
    }

    public void tomarFicha(int ficha, ModeloInfoJugador modelo, IPanelInfoJugador vista) throws NoTieneSaldoDisponibleException {
        if (ficha + modelo.getTotal() > modelo.getSaldoJugador()) {
            throw new NoTieneSaldoDisponibleException ("No tiene saldo suficiente.");
        }
    }

    public void undo(ModeloInfoJugador modelo) {
        ArrayList<Integer> fichas = modelo.getMontoApostado();
        if (!fichas.isEmpty()) {
            fichas.remove(fichas.size() - 1);
        }
    }
}
