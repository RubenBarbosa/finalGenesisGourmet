/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.cliente.modelo.contoller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Cliente;
import com.genesis.modelo.facade.ClienteFacadeLocal;
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
@Named(value = "listarClienteController")
@ViewScoped
public class ListarClienteController implements Serializable{

    @EJB
    private ClienteFacadeLocal cfl;
    
    private List<Cliente> clientes;
    
    private Cliente clienteSeleccionado;

    public ListarClienteController() {
    }
    
    @PostConstruct
    public void init(){
        recargarClientes();
    }

    private void recargarClientes() {
        clientes = cfl.findAll();
    }
    
    public ClienteFacadeLocal getCfl() {
        return cfl;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setCfl(ClienteFacadeLocal cfl) {
        this.cfl = cfl;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }
    
    public void eliminarCliente(){
        cfl.remove(clienteSeleccionado);
        recargarClientes();
        MessageUtil.enviarMensajeInformacion("listar-clientes", "Eliminaci�n exitosa", "Se ha eliminado el registro");
    }

    
}
