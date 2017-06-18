/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.mesas.modelo.controller;

import com.genesis.mesas.modelo.controller.*;
import com.genesis.modelo.entities.Mesa;
import com.genesis.modelo.facade.MesaFacadeLocal;
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
@Named(value = "verMesaController")
@SessionScoped //Debemos cambiarlo a @ConversationScoped
public class VerMesaController implements Serializable{

    private Mesa mesa;
    /**
     * Creates a new instance of ListarUsuariosController
     */
    public VerMesaController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String verMesa(Mesa u){
        this.mesa = u;
        return "/app/administrador/mesas/ver.xhtml?faces-redirect=true";
    }
    
    
}
