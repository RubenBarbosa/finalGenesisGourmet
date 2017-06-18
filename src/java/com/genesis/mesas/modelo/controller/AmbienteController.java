/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.mesas.modelo.controller;

import com.genesis.mesas.modelo.controller.*;
import com.genesis.modelo.entities.Ambiente;
import com.genesis.modelo.facade.AmbienteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "ambienteController")
@RequestScoped
public class AmbienteController {

    @EJB
    private AmbienteFacadeLocal afl;
    
    private List<Ambiente> ambientes;
    /**
     * Creates a new instance of TipoDocumentoController
     */
    public AmbienteController() {
    }
    
    @PostConstruct
    public void init(){
        ambientes = afl.findAll();
    }

    public List<Ambiente> getAmientes() {
        return ambientes;
    }
    
    
}
