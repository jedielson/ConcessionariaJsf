/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.application.common;

import java.util.List;

/**
 *
 * Define a funcionalidade de consulta utilizando filtros
 *
 * @author Jedielson Nakonieczni
 * @param <TEntity> O tipo de retorno
 * @param <TFilter> O Tipo do Filtro
 */
public interface IFilteredQueryableAppService<TEntity, TFilter> {

    /**
     * Dado um filtro, retorna efetua a consulta filtrada
     * @param filtro O filtro a ser aplicado
     * @return Uma {@link List}
     */
    List<TEntity> carregarConsulta(TFilter filtro);

}
