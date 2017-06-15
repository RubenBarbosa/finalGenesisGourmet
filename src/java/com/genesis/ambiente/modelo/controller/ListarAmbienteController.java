/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.ambiente.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Ambiente;
import com.genesis.modelo.facade.AmbienteFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author ruben
 */
@Named(value = "listarAmbienteController")
@ViewScoped
public class ListarAmbienteController implements Serializable{
    
    @EJB
    private AmbienteFacadeLocal afl;
    
    private List<Ambiente> ambientes;
    
    private Ambiente ambienteSeleccionado;

    public ListarAmbienteController() {
    }
    
    @PostConstruct
    public void init(){
        recargarAmbientes();
    }

    public List<Ambiente> getAmbientes() {
        return ambientes;
    }

    private void recargarAmbientes() {
        ambientes = afl.findAll();
    }

    public AmbienteFacadeLocal getAfl() {
        return afl;
    }

    public void setAfl(AmbienteFacadeLocal afl) {
        this.afl = afl;
    }

    public Ambiente getAmbienteSeleccionado() {
        return ambienteSeleccionado;
    }

    public void setAmbienteSeleccionado(Ambiente ambienteSeleccionado) {
        this.ambienteSeleccionado = ambienteSeleccionado;
    }
    
    public void eliminarAmbiente(){
        afl.remove(ambienteSeleccionado);
        recargarAmbientes();
        MessageUtil.enviarMensajeInformacion("listar-ambientes", "Eliminaci�n", "El ambiente se ha eliminado con �xito");
    }
    
}
