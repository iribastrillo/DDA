/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Mesa {

    private static int autoId = 0;
    private int id;
    private float balance;
    private ArrayList<Integer> numerosSorteados;
    private boolean bloqueada;
    // por defecto el tipo de apuesta directa siempre esta
    // se le puede agregar los otros 3 tipos de apuestas opcionales
    private ArrayList<EnumTipoApuesta> tiposApuesta;
    private Crupier c;

    public Mesa(ArrayList<EnumTipoApuesta> tiposApuesta, Crupier c) {
        this.id = autoId;
        this.balance = 0;
        this.numerosSorteados = new ArrayList<>();
        this.bloqueada = false;
        //Se agrega apuesta directa por defecto a la lista de apuestas seleccionada;
        tiposApuesta.add(EnumTipoApuesta.Apuesta_Directa);
        this.tiposApuesta = tiposApuesta;
        this.c = c;
        
        autoId ++;
    }
    
    public ArrayList<EnumTipoApuesta> listarTiposApuestaSeleccionados(){
        return this.tiposApuesta;
    }
    
    
    public int getId() {
        return id;
    }

    public float getBalance() {
        return balance;
    }

    public ArrayList<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public ArrayList<EnumTipoApuesta> getTiposApuesta() {
        return tiposApuesta;
    }

    public Crupier getC() {
        return c;
    }

}
