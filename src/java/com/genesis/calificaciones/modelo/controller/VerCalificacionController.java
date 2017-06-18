/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.calificaciones.modelo.controller;

import com.genesis.modelo.entities.Calificacion;
import com.genesis.modelo.facade.CalificacionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "verCalificacionController")
@SessionScoped //Debemos cambiarlo a @ConversationScoped
public class VerCalificacionController implements Serializable{

    private Calificacion calificacion;
    /**
     * Creates a new instance of ListarUsuariosController
     */
    public VerCalificacionController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public String verCalificacion(Calificacion c){
        this.calificacion = c;
        return "/app/administrador/calificaciones/ver.xhtml?faces-redirect=true";
    }
    
    
}
