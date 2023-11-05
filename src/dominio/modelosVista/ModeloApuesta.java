/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.modelosVista;

import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public class ModeloApuesta {
    private ArrayList<Integer> fichas;
    private int uccode;


    public int getUccode() {
        return uccode;
    }

    public void setUccode(int uccode) {
        this.uccode = uccode;
    }

    public ArrayList<Integer> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Integer> fichas) {
        this.fichas = fichas;
    }
}
