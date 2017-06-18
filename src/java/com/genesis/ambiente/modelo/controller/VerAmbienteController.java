/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.ambiente.modelo.controller;

import com.genesis.modelo.entities.Ambiente;
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
@Named(value = "verAmbienteController")
@SessionScoped
public class VerAmbienteController implements Serializable{
    
    private Ambiente ambiente;

    public VerAmbienteController() {
    }
    
    @PostConstruct
    public void init(){
    
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    
    public String verAmbiente(Ambiente a){
        this.ambiente = a;
        return "/app/administrador/listar.xhtml?faces-redirect=true";
    }
    
}
