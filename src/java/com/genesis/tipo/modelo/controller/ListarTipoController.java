/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.tipo.modelo.controller;

import com.genesis.tipo.modelo.controller.*;
import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Tipo;
import com.genesis.modelo.facade.TipoFacadeLocal;
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
@Named(value = "listarTipoController")
@ViewScoped
public class ListarTipoController implements Serializable{
    
    @EJB
    private TipoFacadeLocal tfl;
    
    private List<Tipo> tipos;
    
    private Tipo tipoSeleccionado;

    public ListarTipoController() {
    }
    
    @PostConstruct
    public void init(){
        recargarTipos();
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    private void recargarTipos() {
        tipos = tfl.findAll();
    }

    public TipoFacadeLocal getTFL() {
        return tfl;
    }

    public void setTFL(TipoFacadeLocal tfl) {
        this.tfl = tfl;
    }

    public Tipo getTipoSeleccionado() {
        return tipoSeleccionado;
    }

    public void setTipoSeleccionado(Tipo tipoSeleccionado) {
        this.tipoSeleccionado = tipoSeleccionado;
    }
    
    public void eliminarTipo(){
        tfl.remove(tipoSeleccionado);
        recargarTipos();
        MessageUtil.enviarMensajeInformacion("listar-tipos", "Eliminaci�n", "El tipo de producto se ha eliminado con �xito");
    }
    
}
