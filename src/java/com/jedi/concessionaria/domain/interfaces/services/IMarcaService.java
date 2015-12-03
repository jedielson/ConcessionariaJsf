/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.services;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.services.common.IServiceBase;

/**
 *
 * @author AS
 */
public interface IMarcaService extends IServiceBase<Marca> {
    
    /**
     * Verifica se a marca já existe com o nome informado
     * @param nome O nome a ser pesquisado
     * @return true caso exista uma marca com o nome passado
     */
    boolean existeComONome(String nome);

}
