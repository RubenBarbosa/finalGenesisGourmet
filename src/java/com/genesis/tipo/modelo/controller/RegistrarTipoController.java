/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.tipo.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Tipo;
import com.genesis.modelo.entities.Tipo;
import com.genesis.modelo.facade.TipoFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author ruben
 */
@Named(value = "registroTipoController")
@RequestScoped
public class RegistrarTipoController {
    
    @EJB
    private TipoFacadeLocal tfl;
    
    private Tipo nuevoTipo;

    public RegistrarTipoController() {
    }
    
    @PostConstruct
    public void init(){
        nuevoTipo = new Tipo();
    }

    public Tipo getNuevoTipo() {
        return nuevoTipo;
    }

    public void setNuevoTipo(Tipo nuevoTipo) {
        this.nuevoTipo = nuevoTipo;
    }
    
    public void registrar(){
        tfl.create(nuevoTipo);
        MessageUtil.enviarMensajeInformacion("form-registro", "Registro satisfactorio", "El Tipo se ha registrado correctamente");
        init();
    }
    
}
