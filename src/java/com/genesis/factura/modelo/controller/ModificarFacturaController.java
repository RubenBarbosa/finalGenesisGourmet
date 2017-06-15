/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.factura.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Factura;
import com.genesis.modelo.facade.FacturaFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ruben
 */
@Named(value = "modificarFacturasController")
@SessionScoped
public class ModificarFacturaController implements Serializable{
    
    @EJB
    private FacturaFacadeLocal fl;
    
    private Factura facturaseleccionada;

    public ModificarFacturaController() {
       
    }

    public Factura getFacturaseleccionada() {
        return facturaseleccionada;
    }

    public void setFacturaseleccionada(Factura facturaseleccionada) {
        this.facturaseleccionada = facturaseleccionada;
    }
    
    public void actualizarDatos(){
        try{
            fl.edit(facturaseleccionada);
            MessageUtil.enviarMensajeInformacion("listar-facturas", "Actualizaci�n exitosa", "");
        }catch (Exception e){
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos de la factura", e.getStackTrace().toString());
        }
    }
    
    public String preModificar(Factura f){
        setFacturaseleccionada(f);
        return "/app/administrador/facturas/listar.xhtml?faces-redirect=true";
    }
    
}
