/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.mesas.modelo.controller;


import com.genesis.mesas.modelo.controller.*;
import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Mesa;
import com.genesis.modelo.facade.MesaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Mateo
 */
@Named(value = "modificarMesaController")
@SessionScoped
public class ModificarMesaController implements Serializable {

    @EJB
    private MesaFacadeLocal mfl;
    
    private Mesa mesaSeleccionada;
    
    /**
     * Creates a new instance of ModificarController
     */
    public ModificarMesaController() {
    }

    public Mesa getMesaSeleccionada() {
        return mesaSeleccionada;
    }

    public void setMesaSeleccionada(Mesa mesaSeleccionada) {
        this.mesaSeleccionada = mesaSeleccionada;
    }
    

       
    public void actulaizarDatos(){
        try {
            mfl.edit(mesaSeleccionada);
            MessageUtil.enviarMensajeInformacion("listar-mesas", "Actualización", "Los datos se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos", e.getStackTrace().toString());
        }
    }
    
    public String preModificar(Mesa m){
        setMesaSeleccionada(m);
        return "/app/administrador/mesas/listar.xhtml?faces-redirect=true";
    }
    
}
