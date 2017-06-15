/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.cliente.modelo.contoller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Cliente;
import com.genesis.modelo.facade.ClienteFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ruben
 */
@Named(value = "registroClienteController")
public class RegistroClienteController {

    @EJB
    private ClienteFacadeLocal cfl;

    private Cliente nuevoCliente;

    public RegistroClienteController() {
    }

    public Cliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(Cliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }

    public void registrar() {
        if (nuevoCliente != null) {
            cfl.create(nuevoCliente);
            MessageUtil.enviarMensajeInformacion("form-registro", "Registro exitoso", "Se ha registrado el cliente");
        } else {
            MessageUtil.enviarMensajeError("form-registro", "Campos incompletos", "");
        }
    }

}
