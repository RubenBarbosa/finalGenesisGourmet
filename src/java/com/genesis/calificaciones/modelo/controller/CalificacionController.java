/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.calificaciones.modelo.controller;

import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.CalificacionFacadeLocal;
import com.genesis.modelo.facade.RolFacadeLocal;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "calificacionController")
@RequestScoped
public class CalificacionController {
    
    @EJB
    private UsuarioFacadeLocal ufl;
    
    @EJB
    private RolFacadeLocal rfl;
    
    @EJB
    private CalificacionFacadeLocal cfl;
    
    
    private List<Usuario> usuarios ;

    public CalificacionController() {
    }

    

    public UsuarioFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(UsuarioFacadeLocal ufl) {
        this.ufl = ufl;
    }

    public RolFacadeLocal getRfl() {
        return rfl;
    }

    public void setRfl(RolFacadeLocal rfl) {
        this.rfl = rfl;
    }

    public CalificacionFacadeLocal getCfl() {
        return cfl;
    }

    public void setCfl(CalificacionFacadeLocal cfl) {
        this.cfl = cfl;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void recargarUsuarios(){
        usuarios = ufl.findAll();
    }
    
    @PostConstruct
    public void init(){
        recargarUsuarios();
    }
    
}
