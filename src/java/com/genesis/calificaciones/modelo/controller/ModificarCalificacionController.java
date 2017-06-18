/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.calificaciones.modelo.controller;


import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Calificacion;
import com.genesis.modelo.facade.CalificacionFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Mateo
 */
@Named(value = "modificarCalificacionController")
@SessionScoped
public class ModificarCalificacionController implements Serializable {

    @EJB
    private CalificacionFacadeLocal cfl;
    
    private Calificacion calificacionSeleccionado;
    
    /**
     * Creates a new instance of ModificarController
     */
    public ModificarCalificacionController() {
    }

    public CalificacionFacadeLocal getCfl() {
        return cfl;
    }

    public void setCfl(CalificacionFacadeLocal cfl) {
        this.cfl = cfl;
    }

    public Calificacion getCalificacionSeleccionado() {
        return calificacionSeleccionado;
    }

    public void setCalificacionSeleccionado(Calificacion calificacionSeleccionado) {
        this.calificacionSeleccionado = calificacionSeleccionado;
    }
       
    public void actulaizarDatos(){
        try {
            Calificacion calificacion = null;
            cfl.edit(calificacion);
            MessageUtil.enviarMensajeInformacion("listar-calificaciones", "Actualización", "Los datos de la calificacion se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos de la Calificacion", e.getStackTrace().toString());
        }
    }
    public String preModificar(Calificacion c){
        setCalificacionSeleccionado(c);
        return "/app/administrador/calificaciones/listar.xhtml?faces-redirect=true";
    }
    
}
