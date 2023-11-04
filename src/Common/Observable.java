/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public abstract class Observable {
    
    private final ArrayList<Observador> observadores = new ArrayList<>();
    
    public void agregar(Observador observador) {
        this.observadores.add(observador);
    }
    
    public boolean remover(Observador observador) {
        return observadores.remove(observador);
    }
    
    protected void avisar(Object evento) {
        //observadores.forEach(e -> e.actualizar(this, evento));
        for(int i=0;i<observadores.size();i++){
            observadores.get(i).actualizar(this, evento);
        }
    }
    
}
