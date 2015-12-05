/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.repository.common;

import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * Define um conjunto de metodos que auxiliam consultas filtradas
 * 
 * @author Jedielson Nakonieczni
 * @param <TEntity> O tipo da coleção a ser retornada
 * @param <TFilter> O tipo do filtro a ser criado
 */
public interface IFilteredQueryBuilder<TEntity, TFilter> {
    
    /**
     * Dada uma entidade de filtro, retorna um {@link CriteriaQuery} com os 
     * filtros necessários para a consulta
     * @param filter o filtro a ser utilizado
     * @return Um {@link CriteriaQuery}
     */
    CriteriaQuery<TEntity> createCriteria(TFilter filter);
    
}
