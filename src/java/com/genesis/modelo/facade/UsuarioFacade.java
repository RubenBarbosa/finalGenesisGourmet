/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.facade;

import com.genesis.modelo.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author zergiok
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "genesis_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario login(Long cedula, String clave) {
        
         try {
               
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Usuario> q = getEntityManager().createNamedQuery("Usuario.findLogin", Usuario.class);
            q.setParameter("cedula", cedula);
            q.setParameter("clave", clave);
             System.out.println("Se encontro la consulta");
            return q.getSingleResult();
        } catch (Exception e) {
             System.out.println("No se encontro la consulta");
             e.getStackTrace();
            return null;
        }
    }
    
     @Override
    public List<Usuario> findByRol(int idRol) {

        try {

            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Usuario> q = getEntityManager().createNamedQuery("Usuario.findByRol", Usuario.class);
            q.setParameter("idRol", idRol);
            System.out.println("Se encontro la consulta findByRol");
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("No se encontro la consulta findByRol "+e.getMessage());
            e.getStackTrace();
            return null;
        }
    }
    
}
