/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Mesa {
    
    private static int id=1;
    private float balance;
    private ArrayList<Integer> numerosSorteados;
    private  boolean bloqueada;

    public Mesa() {
        this.id = id++;
        this.balance=0;
        this.numerosSorteados=new ArrayList<>();
        this.bloqueada=false;
    }
    

  
}
