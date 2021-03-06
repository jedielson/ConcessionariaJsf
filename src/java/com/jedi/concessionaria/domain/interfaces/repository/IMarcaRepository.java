/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.repository;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.repository.common.IFilteredQueryRepository;
import com.jedi.concessionaria.domain.interfaces.repository.common.IRepositoryBase;

/**
 *
 * Interface para implementação de um {@link IRepositoryBase} de {@link Marca}
 * 
 * @author Jedielson Nakonieczni
 */
public interface IMarcaRepository extends IRepositoryBase<Marca>, IFilteredQueryRepository<Marca, Marca> {
    
    /**
     * Seleciona uma {@link Marca} filtrando pelo nome.
     * @param name O nome da marca a ser pesquisada
     * @return Uma marca compatível, ou Null caso não encontre
     */
    Marca getByName(String name);
}
