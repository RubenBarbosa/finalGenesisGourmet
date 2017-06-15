/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.factura.modelo.controller;

import com.genesis.modelo.entities.Factura;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ruben
 */
@Named(value = "verFacturaController")
@SessionScoped
public class VerFacturaController implements Serializable{
    
    private Factura factura;

    public VerFacturaController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    public String verFacturas(Factura f){
        this.factura = f;
        return "/app/factutas/verF.xhtml?faces-redirect=true";
    }
    
}
