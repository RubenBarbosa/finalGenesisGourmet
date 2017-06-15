/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.converters;

import com.genesis.modelo.entities.Ambiente;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author ruben
 */
@FacesConverter(forClass = Ambiente.class, value = "cedCapitanConverter")
public class CedCapitanConverter implements Converter{

    //Regla de negocio que solamente me traiga la cedula de capit�n
    private UsuarioFacadeLocal ufl;

    public CedCapitanConverter() {
        ufl = CDI.current().select(UsuarioFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return ufl.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Usuario) {
            Usuario us = (Usuario) value;
            return us.getCedula().toString();
        }
        return null;
    }
    
}
