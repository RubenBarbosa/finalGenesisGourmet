/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.mesa.modelo.controller;
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
 * @author ruben
 */
@Named(value = "listarMesaController")
public class ListarMesaController {
    
    @EJB
    private MesaFacadeLocal mfl;
    
    private List<Mesa> mesas;
    
    private Mesa mesaSeleccionada;

    public ListarMesaController() {
    }
    
    @PostConstruct
    public void init(){
        recargarMesas();
    }

    private void recargarMesas() {
        mesas = mfl.findAll();
    }

    public MesaFacadeLocal getMfl() {
        return mfl;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public Mesa getMesaSeleccionada() {
        return mesaSeleccionada;
    }

    public void setMfl(MesaFacadeLocal mfl) {
        this.mfl = mfl;
    }

    public void setMesaSeleccionada(Mesa mesaSeleccionada) {
        this.mesaSeleccionada = mesaSeleccionada;
    }
    
    public void eliminarMesa(){
        mfl.remove(mesaSeleccionada);
        recargarMesas();
        MessageUtil.enviarMensajeInformacion("listar-mesas", "Eliminaci�n correcta", "Se ha eliminado el registro");
    }
    
}
