/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.services.common;

import java.util.List;

/**
 *
 * Provê a funcionalidade de consulta filtrada a um serviço
 *
 * @author Jedielson Nakonieczni
 * @param <TEntity> O tipo do retorno
 * @param <TFilter> O tipo do Filtro
 */
public interface IFilteredQueryService<TEntity, TFilter> {

    /**
     * Dado um filtro, retorna uma {@link List} com os dados da consulta
     * @param filter O filtro a ser aplicado
     * @return Uma {@link List}
     */
    List<TEntity> getByExample(TFilter filter);

}
