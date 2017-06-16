/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.facade;

import com.genesis.modelo.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zergiok
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    Usuario login (Long cedula, String clave);
    
    List<Usuario> findByRol(int idRol);
    
}
