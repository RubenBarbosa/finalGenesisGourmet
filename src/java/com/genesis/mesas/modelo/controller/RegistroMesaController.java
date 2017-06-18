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
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "registroMesaController")
@RequestScoped
public class RegistroMesaController {

    @EJB
    private MesaFacadeLocal mfl;
   
    
    private Mesa nuevaMesa;
    /**
     * Creates a new instance of RegistroController
     */
    public RegistroMesaController() {
    }
    
    @PostConstruct
    public void init(){
        nuevaMesa = new Mesa();
    }

    public Mesa getNuevaMesa() {
        return nuevaMesa;
    }

    public void setNuevaMesa(Mesa nuevaMesa) {
        this.nuevaMesa = nuevaMesa;
    }
    
    public void registrar(){
        if(nuevaMesa != null){
            mfl.create(nuevaMesa);
            MessageUtil.enviarMensajeInformacion("form-registro", "Registro satisfactorio", "La Mesa se ha registrado correctamente.");
            init();
        } else{
            MessageUtil.enviarMensajeError("form-registro", "No se han diligenciado los campos", "");
        }
    }
    
}
