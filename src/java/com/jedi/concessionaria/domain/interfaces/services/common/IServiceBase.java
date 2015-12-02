/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.services.common;

import java.util.List;

/**
 *
 * @author AS
 * @param <TEntity>
 *            O tipo base do serviço
 */
public interface IServiceBase<TEntity> {

	/**
	 * <p>
	 * Retorna um {@link TEntity} a partir de seu Id
	 * </p>
	 * 
	 * @param id
	 *            O id da entidade
	 * @return Uma {@link TEntity}
	 */
	public TEntity getById(final Long id);

	/**
	 * <p>
	 * Retorna todos os {@link TEntity}
	 * </p>
	 * 
	 * @return Um List{TEntity}
	 */
	public List<TEntity> findAll();

	/**
	 * <p>
	 * Salva um {@link TEntity}. Caso o objeto seja transiente, salva, caso
	 * contrário, atualiza
	 * </p>
	 * 
	 * @param entity
	 *            um {@link TEntity}
	 * @throws Exception
	 *             Retorno genérico de exception
	 */
	public void save(TEntity entity) throws Exception;

	/**
	 * <p>
	 * Remove uma {@link TEntity}
	 * </p>
	 * 
	 * @param entity
	 *            uma entidade
	 * @throws Exception
	 *             Retorno genérico de exception
	 */
	public void remove(TEntity entity) throws Exception;

	/**
	 * <p>
	 * Dado um Id, a entidade do tipo {@link TEntity} relacionada a ela
	 * </p>
	 * 
	 * @param id
	 *            Um Id
	 * @throws Exception
	 *             Retorno genérico de exception
	 */
	public void removeById(final Long id) throws Exception;

}
