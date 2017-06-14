/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.facturas.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Factura;
import com.genesis.modelo.facade.FacturaFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ruben
 */
@Named(value = "regitroFacturaController")
@RequestScoped
public class RegistrarFacturaController {

    @EJB
    private FacturaFacadeLocal fl;

    private Factura nuevaFactura;

    public RegistrarFacturaController() {
    }

    @PostConstruct
    public void init() {
        nuevaFactura = new Factura();
    }

    public Factura getNuevaFactura() {
        return nuevaFactura;
    }

    public void setNuevaFactura(Factura nuevaFactura) {
        this.nuevaFactura = nuevaFactura;
    }

    public void registrar() {
        if (nuevaFactura != null) {
            fl.create(nuevaFactura);
            MessageUtil.enviarMensajeInformacion("form-registro", "Registro exitoso", "La factura se ha registrado correctamente");
        }else{
            MessageUtil.enviarMensajeError("form-registro", "Campos incompletos", "");
        }
    }

}
