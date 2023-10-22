/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Exceptions.CedulaUsuarioInvalidaException;
import Exceptions.NombreUsuarioInvalidoException;
import Exceptions.PasswordUsuarioInvalidoException;

/**
 *
 * @author Usuario
 */
public abstract class Usuario {
    
    private String nombreCompleto;
    private String cedula;
    private String password;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Usuario(String nombreCompleto, String cedula,String password) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.password = password;
    }
    
      public Usuario( String cedula,String password) {
       
        this.cedula = cedula;
        this.password = password;
    }
    
     public  void validarAgregar() throws NombreUsuarioInvalidoException, CedulaUsuarioInvalidaException   {
        if (!esNombreValido()) {
            throw new NombreUsuarioInvalidoException("Falta el nombre del contacto");
        }if (!esCedulaValida()) {
            throw new CedulaUsuarioInvalidaException("Numero de cedula invalida");
        } 
        if (!esPasswordValida()) {
            throw new CedulaUsuarioInvalidaException("Numero de cedula invalida");
        } 
    } 
     
        public  void validarUsuarioLogin() throws PasswordUsuarioInvalidoException, CedulaUsuarioInvalidaException   {
       if (!esCedulaValida()) {
            throw new CedulaUsuarioInvalidaException("Numero de cedula invalida");
        } 
        if (!esPasswordValida()) {
            throw new CedulaUsuarioInvalidaException("Password Usuario invalida");
        } 
    } 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
  


    private boolean esNombreValido() {
        // TODO: Mejorar validacion
        return (!this.nombreCompleto.isEmpty());
    }

    private boolean esCedulaValida() {
                // TODO: Mejorar validacion

        return !this.cedula.isEmpty();
    }
       private boolean esPasswordValida() {
                // TODO: Mejorar validacion

        return !this.password.isEmpty();
    }
    
}
