/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author nacho
 */
public class Casillero {
    private int monto;
    private float factor;
    private int uccode;
    
    public Casillero (int monto, int uccode) {
        this.monto = monto;
        this.uccode = uccode;
        this.factor = 36; // Luego cambiamos para mapear con el UCCode;
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
    
}
