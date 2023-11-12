/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class CasilleroNoNumerico extends Casillero {

    public CasilleroNoNumerico(int monto, int uccode) {
        super(monto, uccode);
        setFactorDePago();
    }

    @Override
    public void setFactorDePago() {

        if (uccode >= 40 && uccode <= 42) {
            // Esto es docenas
            super.factorDePago = 3;
        } else if (uccode > 42 && uccode <= 44) {
            // Esto es color
            super.factorDePago = 2;
        }
    }

}
