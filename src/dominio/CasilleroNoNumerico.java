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
    }

    @Override
    public void setFactorDePago() {
        switch (uccode) {
            case 43 | 44: // color rojo o negro
                super.factorDePago = 2; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                break;
            case 40|41|42: //docenas
                super.factorDePago=3;

        }
    }

}
