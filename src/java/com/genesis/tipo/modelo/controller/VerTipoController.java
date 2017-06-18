/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.tipo.modelo.controller;

import com.genesis.tipo.modelo.controller.*;
import com.genesis.modelo.entities.Tipo;
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
 * @author ruben
 */
@Named(value = "verTipoController")
@SessionScoped
public class VerTipoController implements Serializable{
    
    private Tipo tipo;

    public VerTipoController() {
    }
    
    @PostConstruct
    public void init(){
    
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public String verTipo(Tipo t){
        this.tipo = t;
        return "/app/administrador/tipos/listar.xhtml?faces-redirect=true";
    }
    
}
