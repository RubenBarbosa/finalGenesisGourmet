/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.tipo.modelo.controller;

import com.genesis.ambiente.modelo.controller.*;
import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Tipo;
import com.genesis.modelo.facade.TipoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author ruben
 */
@Named(value = "modificarTipoController")
@SessionScoped
public class ModificarTipoController implements Serializable{
    
    @EJB
    private TipoFacadeLocal tfl;
    
    private Tipo tipoSeleccionado;

    public ModificarTipoController() {
    }

    public Tipo getTipoSeleccionado() {
        return tipoSeleccionado;
    }

    public void setTipoSeleccionado(Tipo tipoSeleccionado) {
        this.tipoSeleccionado = tipoSeleccionado;
    }
    
    public void actualizarDatos(){
        try {
            tfl.edit(tipoSeleccionado);
            MessageUtil.enviarMensajeInformacion("form-edit-tipoPro", "Actualizaci�n correcta", "Tipo de producto actualizado correctamente");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar el registro", e.getStackTrace().toString());
        }
    }
}
