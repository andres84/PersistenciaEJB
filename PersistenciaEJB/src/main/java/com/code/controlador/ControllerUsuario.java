/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.controlador;

import com.code.ejb.UsuarioFacade;
import com.code.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.view.ViewScoped;


/**
 *
 * @author sil
 */
@ManagedBean
@ViewScoped
public class ControllerUsuario implements Serializable {

    @EJB
    private UsuarioFacade usuarioEJB;
    private Usuario usuario = new Usuario();
    
    public String editarUsuario(Usuario usuario){
        
        this.usuario = usuario;
        
        return "modificarUsuario";
        
    }
    
    public String editarUsuario(){
        
        this.usuarioEJB.edit(usuario);
        
        return "index";
        
    }
    
    public String eliminarUsuario(Usuario usuario){
        
        this.usuarioEJB.remove(usuario);
        
        return "index";
        
    }
    
    public String agregarUsuario(){
        
        this.usuarioEJB.create(usuario);
        
        return "index";
        
    }

    public List<Usuario> listarUsuario() {

        return this.usuarioEJB.findAll();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ControllerUsuario() {
    }

}
