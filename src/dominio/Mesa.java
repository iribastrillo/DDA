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
    // por defecto el tipo de apuesta directa siempre esta
    // se le puede agregar los otros 3 tipos de apuestas opcionales
    private ArrayList<EnumTipoApuesta> tiposApuesta;
    private Crupier c;

    public Mesa(ArrayList<EnumTipoApuesta> tiposApuesta, Crupier c) {
        this.id = id++;
        this.balance=0;
        this.numerosSorteados=new ArrayList<>();
        this.bloqueada=false;
        this.tiposApuesta=tiposApuesta;
        this.c=c;
    }
    

  
}
