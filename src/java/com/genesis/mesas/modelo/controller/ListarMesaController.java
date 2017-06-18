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
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Mateo
 */
@Named(value = "listarMesasController")
@ViewScoped
public class ListarMesaController implements Serializable {

    @EJB
    private MesaFacadeLocal mfl;

    private List<Mesa> mesas;

    private Mesa mesaSeleccionada;

    /**
     * Creates a new instance of ListarProductosController
     */
    public ListarMesaController() {
    }

    @PostConstruct
    public void init() {
        recargarMesas();
    }

    private void recargarMesas() {
        mesas = mfl.findAll();
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public MesaFacadeLocal getUfl() {
        return mfl;
    }

    public void setUfl(MesaFacadeLocal mfl) {
        this.mfl = mfl;
    }

    public Mesa getMesaSeleccionada() {
        return mesaSeleccionada;
    }

    public void setMesaSeleccionada(Mesa mesaSeleccionada) {
        this.mesaSeleccionada = mesaSeleccionada;
    }

    public void eliminarMesa() {
        mfl.remove(mesaSeleccionada);
        recargarMesas();
        MessageUtil.enviarMensajeInformacion("listar-mesas", "Eliminacion correcta", "La Mesa se ha eliminado correctamente.");
    }
}
