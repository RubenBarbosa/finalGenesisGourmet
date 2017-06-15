/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.calificaciones.modelo.controller;


import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Calificacion;
import com.genesis.modelo.facade.CalificacionFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "registroCalificacionController")
@RequestScoped
public class RegistroCalificacionController {

    @EJB
    private CalificacionFacadeLocal cfl;
   
    
    private Calificacion nuevaCalificacion;
    /**
     * Creates a new instance of RegistroController
     */
    public RegistroCalificacionController() {
        
    }
    public List<Long> listarCedulaMeseros(){
        List<Long> cedulas = cfl.cedulaMeseros(); 
        return cedulas;
    }
    
    @PostConstruct
    public void init(){
        nuevaCalificacion = new Calificacion();
    }

    public Calificacion getNuevaCalificacion() {
        return nuevaCalificacion;
    }

    public void setNuevaCalificacion(Calificacion nuevaCalificacion) {
        this.nuevaCalificacion = nuevaCalificacion;
    }
    
    public void registrar(){
        if(nuevaCalificacion != null){
            cfl.create(nuevaCalificacion);
            MessageUtil.enviarMensajeInformacion("form-calificacion", "Registro satisfactorio", "La calficacion se ha registrado correctamente.");
            init();
        } else{
            MessageUtil.enviarMensajeError("form-calificacion", "No se han diligenciado los campos", "");
        }
    }
    
}
