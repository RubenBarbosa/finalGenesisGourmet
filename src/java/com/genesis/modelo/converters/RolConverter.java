/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.converters;


import com.genesis.modelo.entities.Rol;
import com.genesis.modelo.facade.RolFacade;
import com.genesis.modelo.facade.RolFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = Rol.class, value = "rolConverter")
public class RolConverter implements Converter{
    
    private RolFacadeLocal tdfl;

    public RolConverter() {
        tdfl = CDI.current().select(RolFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tdfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Rol){
            Rol td = (Rol) value;
            return td.getIdRol().toString();
        }
        return null;
    }
    
}
