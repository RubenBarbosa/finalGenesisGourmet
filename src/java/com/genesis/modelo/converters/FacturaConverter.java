/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.converters;

import com.genesis.modelo.entities.Factura;
import com.genesis.modelo.facade.FacturaFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ruben
 */
@FacesConverter(forClass = Factura.class, value = "facturaConverter")
public class FacturaConverter implements Converter{
    
    private FacturaFacadeLocal fl;
    
    public FacturaConverter(){
        fl = CDI.current().select(FacturaFacadeLocal.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return fl.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Factura) {
            Factura pe = (Factura) value;
            return pe.getIdPedido().toString();
        }
        return null;
    }
    
    
    
}
