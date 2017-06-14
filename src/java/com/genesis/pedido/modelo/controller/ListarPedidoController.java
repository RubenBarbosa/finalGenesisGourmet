/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.pedido.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Pedido;
import com.genesis.modelo.facade.PedidoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author ruben
 */
@Named(value = "listarPedidoController")
public class ListarPedidoController implements Serializable {

    @EJB
    private PedidoFacadeLocal pfl;

    private List<Pedido> pedidos;

    private Pedido pedidoSeleccionado;

    public ListarPedidoController() {
    }
    
    @PostConstruct
    private void init(){
        recargarPedidos();
    }

    private void recargarPedidos() {
        pedidos = pfl.findAll();
    }

    public PedidoFacadeLocal getPfl() {
        return pfl;
    }

    public void setPfl(PedidoFacadeLocal pfl) {
        this.pfl = pfl;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }
    
    public void eliminarPedido(){
        pfl.remove(pedidoSeleccionado);
        recargarPedidos();
        MessageUtil.enviarMensajeInformacion("listar-pedidos", "Eliminaci�n correcta", "El pedido se ha eliminado con exito");
    }
    
    
}
