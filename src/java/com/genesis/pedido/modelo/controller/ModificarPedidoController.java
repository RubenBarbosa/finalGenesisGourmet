/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.pedido.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Pedido;
import com.genesis.modelo.facade.PedidoFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author ruben
 */
@Named(value = "modificarPedidoController")
public class ModificarPedidoController {
    
    @EJB
    private PedidoFacadeLocal pfl;
    
    private Pedido pedidoSeleccionado;

    public ModificarPedidoController() {
    }

    public PedidoFacadeLocal getPfl() {
        return pfl;
    }

    public void setPfl(PedidoFacadeLocal pfl) {
        this.pfl = pfl;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }
    
    public void actualizarPedido(){
        try {
            pfl.edit(pedidoSeleccionado);
            MessageUtil.enviarMensajeInformacion("listar-pedidos", "Actualizaci�n", "Se han actualizado correctamente los datos");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos", e.getStackTrace().toString());
        }
    }
    
    public String preModificar(Pedido p){
        setPedidoSeleccionado(p);
        return "/app/administrador/pedidos/listar.xhtml?faces-redirect=true";
    }
    
}
