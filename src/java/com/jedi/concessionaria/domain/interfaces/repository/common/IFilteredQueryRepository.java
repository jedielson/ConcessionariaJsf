/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.repository.common;

import java.util.List;

/**
 *
 * @author Jedielson Nakonieczni
 * @param <TEntity> O Tipo da coleção de retorno
 * @param <TFilter> O Tipo do filtro
 */
public interface IFilteredQueryRepository<TEntity, TFilter> {
    
    /**
     * Dado um filtro do tipo {@link TFilter}, retorna uma coleção de {@link TEntity}
     * @param filter O filtro
     * @return Uma coleção
     */
    List<TEntity> getByExample(TFilter filter);
    
}
