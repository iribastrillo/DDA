/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dominio.efectos;

import Exceptions.EfectoException;
import dominio.Mesa;

/**
 *
 * @author nacho
 */
public interface StrategyEfecto {
    
    public int obtenerNumero( Mesa m);
    
    public String getNombreEfecto();
    
    @Override
    public String toString();
    
}
