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
public class CasilleroNumerico extends Casillero {

    private ArrayList<Integer> numerosRojos = this.numerosRojos = new ArrayList<>(
            Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 30, 32, 34, 36));
    private String color;
    private int docena = -1;

    public CasilleroNumerico(int monto, int uccode) {
        super(monto, uccode);
        setearDocena();
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        if (uccode != 0) {
            this.color = (numerosRojos.contains(uccode)) ? "Rojo" : "Negro";
        } else {
            this.color = "Verde";
        }
    }

    private void setearDocena() {
        if (uccode != 0) {
            if (uccode / 12 <= 1) {
                this.docena = 40;//primeraDocena 
                //ver lo de las divisiones
            } else if (uccode / 12 > 1 && uccode / 12 <= 2) {
                this.docena = 41;//segundaDocena
            } else {
                this.docena=42;
            }
        }

    }

    public int getDocena() {
        return docena;
    }
}
