/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.ambiente.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Ambiente;
import com.genesis.modelo.facade.AmbienteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author ruben
 */
@Named(value = "ModificarAmbienteController")
@SessionScoped
public class ModificarAmbienteController implements Serializable{
    
    @EJB
    private AmbienteFacadeLocal afl;
    
    private Ambiente ambienteSeleccionado;

    public ModificarAmbienteController() {
    }

    public Ambiente getAmbienteSeleccionado() {
        return ambienteSeleccionado;
    }

    public void setAmbienteSeleccionado(Ambiente ambienteSeleccionado) {
        this.ambienteSeleccionado = ambienteSeleccionado;
    }
    
    public void actualizarDatos(){
        try {
            afl.edit(ambienteSeleccionado);
            MessageUtil.enviarMensajeInformacion("form-edit-ambiente", "Actualizaci�n correcta", "Ambiente actualizado correctamente");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar el registro", e.getStackTrace().toString());
        }
    }
}
