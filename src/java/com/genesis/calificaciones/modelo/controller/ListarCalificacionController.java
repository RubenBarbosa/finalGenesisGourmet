/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.calificaciones.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Calificacion;
import com.genesis.modelo.facade.CalificacionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Mateo
 */
@Named(value = "listarCalificacionController")
@ViewScoped
public class ListarCalificacionController implements Serializable {

    @EJB
    private CalificacionFacadeLocal cfl;

    private List<Calificacion> calificaciones;

    private Calificacion calificacionSeleccionado;

    /**
     * Creates a new instance of ListarProductosController
     */
    public ListarCalificacionController() {
    }

    @PostConstruct
    public void init() {
        recargarCalificaciones();
    }

    private void recargarCalificaciones() {
        calificaciones = cfl.findAll();
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
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
        System.out.println("hdjsahjdhsajkdhjksahd - " + calificacionSeleccionado.getIdcalificacion());
        this.calificacionSeleccionado = calificacionSeleccionado;
    }

    public void eliminarCalificacion() {
        Calificacion calificacion = null;
//        System.out.println("Voy a eliminar la calificacion : " + calificacionSeleccionado.getPrimerNombre());
        cfl.remove(calificacionSeleccionado);
        recargarCalificaciones();
        MessageUtil.enviarMensajeInformacion("listar-calificaciones", "Eliminacion correcta", "La calificacion se ha eliminado correctamente.");
    }
}
