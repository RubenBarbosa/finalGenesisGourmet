/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.producto.modelo.controller;


import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Producto;
import com.genesis.modelo.facade.ProductoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Mateo
 */
@Named(value = "modificarProductoController")
@SessionScoped
public class ModificarProductoController implements Serializable {

    @EJB
    private ProductoFacadeLocal pfl;
    
    private Producto productoSeleccionado;
    
    /**
     * Creates a new instance of ModificarController
     */
    public ModificarProductoController() {
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    

       
    public void actulaizarDatos(){
        try {
            pfl.edit(productoSeleccionado);
            MessageUtil.enviarMensajeInformacion("listar-productos", "Actualización", "Los datos se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos", e.getStackTrace().toString());
        }
    }
    
    public String preModificar(Producto p){
        setProductoSeleccionado(p);
        return "/app/administrador/productos/listar.xhtml?faces-redirect=true";
    }
    
}
