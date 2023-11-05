/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Common;

import componentes.PanelRuleta;

/**
 *
 * @author nacho
 */
public interface IDisplayerStrategy {
    public void mostrarColor (PanelRuleta ruleta);
    public void ocultarColor (PanelRuleta ruleta);
    public void mostrarParidad (PanelRuleta ruleta);
    public void ocultarParidad (PanelRuleta ruleta);
    public void mostrarDocenas(PanelRuleta ruleta);
    public void ocultarDocenas(PanelRuleta ruleta);
    public void ocultarTodo (PanelRuleta ruleta);
}
