/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.pedido.modelo.controller;

import com.genesis.modelo.controller.util.Constantes;
import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Pedido;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.PedidoFacadeLocal;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author zergiok
 */
@Named(value = "registroPedidoController")
@RequestScoped
public class RegistroPedidoController {
    @EJB
    private PedidoFacadeLocal pfl;
    
    @EJB
    private UsuarioFacadeLocal ufl;
    
    private Pedido nuevoPedido;
    
    private List<Usuario> capitanes;

    public RegistroPedidoController() {
    }
    
    @PostConstruct
    public void init(){
        nuevoPedido = new Pedido();
        cargarCapitanes();
    }
    
    private void cargarCapitanes(){        
        capitanes = ufl.findByRol(Constantes.ROL_CAPITAN);
    }

    public Pedido getNuevoPedido() {
        return nuevoPedido;
    }

    public void setNuevoPedido(Pedido nuevoPedido) {
        this.nuevoPedido = nuevoPedido;
    }

    public List<Usuario> getCapitanes() {
        return capitanes;
    }

    public void setCapitanes(List<Usuario> capitanes) {
        this.capitanes = capitanes;
    }
    
    
    
     public void registrar(){
        if(nuevoPedido != null){
           pfl.create(nuevoPedido);
            MessageUtil.enviarMensajeInformacion("form-registro", "Registro satisfactorio", "El pedido se ha registrado correctamente.");
            init();
        } else{
            MessageUtil.enviarMensajeError("form-registro", "No se han diligenciado los campos", "");
        }
    }
    
}