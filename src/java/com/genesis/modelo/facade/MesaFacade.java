/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.facade;

import com.genesis.modelo.entities.Mesa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zergiok
 */
@Stateless
public class MesaFacade extends AbstractFacade<Mesa> implements MesaFacadeLocal {

    @PersistenceContext(unitName = "genesis_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesaFacade() {
        super(Mesa.class);
    }
    
}
