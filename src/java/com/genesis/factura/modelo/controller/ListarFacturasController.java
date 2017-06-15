/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.factura.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Factura;
import com.genesis.modelo.entities.Pedido;
import com.genesis.modelo.facade.FacturaFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.mail.Message;

/**
 *
 * @author ruben
 */
@Named(value = "listarFacturasController")
public class ListarFacturasController {
    
    @EJB
    private FacturaFacadeLocal fl;
    
    private List<Factura> facturas;
    
    private Factura facturaSeleccionada;

    public ListarFacturasController() {
    }

    @PostConstruct
    public void init(){
        recargarFacturas();
    }
    
    private void recargarFacturas() {
        facturas = fl.findAll();
    }
    
    public FacturaFacadeLocal getFl() {
        return fl;
    }

    public void setFl(FacturaFacadeLocal fl) {
        this.fl = fl;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Factura getFacturaSeleccionada() {
        return facturaSeleccionada;
    }

    public void setFacturaSeleccionada(Factura facturaSeleccionada) {
        this.facturaSeleccionada = facturaSeleccionada;
    }
    
    public void eliminarFactura(){
        fl.remove(facturaSeleccionada);
        recargarFacturas();
        MessageUtil.enviarMensajeInformacion("listar-facturas", "Eliminaci�n correctar", "La factuea se ha eliminado correctamente");
        
    }

    
    
}
