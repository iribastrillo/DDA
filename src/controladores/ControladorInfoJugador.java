/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Exceptions.NoTieneSaldoDisponibleException;
import Logica.Fachada;

/**
 *
 * @author nacho
 */
public class ControladorInfoJugador {
    
    private Fachada fachada;
    
    public ControladorInfoJugador () {
        this.fachada = Fachada.getInstancia();
    }

    public void tomarFicha(int ficha, int monto, float saldo) throws NoTieneSaldoDisponibleException {
        if (ficha + monto > saldo) {
            throw new NoTieneSaldoDisponibleException ("No tiene saldo.");
        }
    }
    
}
