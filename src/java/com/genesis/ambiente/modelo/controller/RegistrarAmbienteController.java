/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.ambiente.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Ambiente;
import com.genesis.modelo.facade.AmbienteFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author ruben
 */
@Named(value = "registroAmbienteController")
@RequestScoped
public class RegistrarAmbienteController {
    
    @EJB
    private AmbienteFacadeLocal afl;
    
    private Ambiente nuevoAmbiente;

    public RegistrarAmbienteController() {
    }
    
    @PostConstruct
    public void init(){
        nuevoAmbiente = new Ambiente();
    }

    public Ambiente getNuevoAmbiente() {
        return nuevoAmbiente;
    }

    public void setNuevoAmbiente(Ambiente nuevoAmbiente) {
        this.nuevoAmbiente = nuevoAmbiente;
    }
    
    public void registrar(){
        afl.create(nuevoAmbiente);
        MessageUtil.enviarMensajeInformacion("form-registro", "Registro satisfactorio", "El Ambiente se ha registrado correctamente");
        init();
    }
    
}
