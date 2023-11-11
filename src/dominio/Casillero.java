/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author nacho
 */
public class Casillero {
    private int monto;
    private float factor;
    private int uccode;
   // private ArrayList<Integer> numerosRojos;
    
    public Casillero (int monto, int uccode) {
        this.monto = monto;
        this.uccode = uccode;
        this.factor = 36; // Luego cambiamos para mapear con el UCCode;
      //  this.numerosRojos=new ArrayList<>( Arrays.asList(1,3,5,7,9,12,14,16,18,21,23,25,27,30,32,34,36));
        
    }
    

    
//    public boolean Color(){
//        //Falso: rojo, Verdadero: negro
//        ret
//    }
  
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
