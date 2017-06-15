/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.converters;
import com.genesis.modelo.entities.Cliente;
import com.genesis.modelo.facade.ClienteFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ruben
 */
@FacesConverter(forClass = Cliente.class, value = "clienteConverter")
public class ClienteConverter implements Converter{

    private ClienteFacadeLocal cfl;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return cfl.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Cliente) {
            Cliente cl = (Cliente) value;
            return cl.getCedulaCliente().toString();
        }
        return null;
    }
    
}
