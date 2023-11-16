/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author nacho
 */
public abstract class Casillero {
    protected int monto;
    protected int factorDePago;
    protected int uccode;
 
 
    public Casillero (int monto, int uccode) {
        this.monto = monto;
        this.uccode = uccode;
        this.factorDePago = 36; 
    }

    public float getFactorDePago() {
        return factorDePago;
    }

    public void setFactorDePago() {
        this.factorDePago = 36;
    }
    
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getUccode() {
        return uccode;
    }

    public void setUccode(int uccode) {
        this.uccode = uccode;
    }
    
    public void agregarMonto (int monto) {
        this.monto += monto;
    } 
}
