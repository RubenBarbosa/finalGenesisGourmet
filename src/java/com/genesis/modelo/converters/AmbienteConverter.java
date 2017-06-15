/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.converters;

import com.genesis.modelo.entities.Ambiente;
import com.genesis.modelo.facade.AmbienteFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author ruben
 */
@FacesConverter(forClass= Ambiente.class, value = "ambienteConverter")
public class AmbienteConverter implements Converter{
    
    private AmbienteFacadeLocal afl;

    public AmbienteConverter() {
        afl = CDI.current().select(AmbienteFacadeLocal.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return afl.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Ambiente) {
            Ambiente am = (Ambiente) value;
            return am.getIdAmbiente().toString();
        }
        return null;
    }
    
    
    
    
}
