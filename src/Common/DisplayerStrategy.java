/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import componentes.PanelRuleta;

/**
 *
 * @author nacho
 */
public class DisplayerStrategy implements IDisplayerStrategy {

    @Override
    public void mostrarColor(PanelRuleta ruleta) {
        ruleta.setVisible(PanelRuleta.ROJO, true);
        ruleta.setVisible(PanelRuleta.NEGRO, true);
    }

    @Override
    public void ocultarColor(PanelRuleta ruleta) {
        ruleta.setVisible(PanelRuleta.ROJO, false);
        ruleta.setVisible(PanelRuleta.NEGRO, false);    }

    @Override
    public void mostrarParidad(PanelRuleta ruleta) {
        ruleta.setVisible(PanelRuleta.PAR,true);
        ruleta.setVisible(PanelRuleta.IMPAR,true);
    }

    @Override
    public void ocultarParidad(PanelRuleta ruleta) {
        ruleta.setVisible(PanelRuleta.PAR,false);
        ruleta.setVisible(PanelRuleta.IMPAR,false);
    }

    @Override
    public void mostrarDocenas(PanelRuleta ruleta) {
        ruleta.setVisible(PanelRuleta.PRIMERA_DOCENA, true);
        ruleta.setVisible(PanelRuleta.SEGUNDA_DOCENA, true);
        ruleta.setVisible(PanelRuleta.TERCERA_DOCENA, true);    }

    @Override
    public void ocultarDocenas(PanelRuleta ruleta) {
        ruleta.setVisible(PanelRuleta.PRIMERA_DOCENA, false);
        ruleta.setVisible(PanelRuleta.SEGUNDA_DOCENA, false);
        ruleta.setVisible(PanelRuleta.TERCERA_DOCENA, false);
    }

    @Override
    public void ocultarTodo(PanelRuleta ruleta) {
        this.ocultarColor(ruleta);
        this.ocultarDocenas(ruleta);
        this.ocultarParidad(ruleta);
    }
    
}
