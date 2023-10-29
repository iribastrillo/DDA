/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.FachadaServicios;
import Vista.IVistaMesaCrupier;

/**
 *
 * @author Usuario
 */
public class ControladorVistaMesaCrupier {

    private final FachadaServicios fachada;
    private final IVistaMesaCrupier vista;

    public ControladorVistaMesaCrupier(FachadaServicios fachada, IVistaMesaCrupier vista) {
        this.fachada = fachada;
        this.vista = vista;
    }
    
    

}
