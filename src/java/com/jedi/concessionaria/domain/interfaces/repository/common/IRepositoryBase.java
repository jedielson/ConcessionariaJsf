package com.jedi.concessionaria.domain.interfaces.repository.common;

import java.util.List;

/**
 *
 * @author Jedielson Nakonieczni
 * @param <TEntity> O tipo do repositório
 */
public interface IRepositoryBase<TEntity> {

    /**
     * <p>
     * Retorna um {@link TEntity} a partir de seu Id
     * </p>
     * @param id O id da entidade
     * @return Uma {@link TEntity}
     */
    public TEntity getById(final Long id);

    /**
     * <p>
     * Retorna todos os {@link TEntity}
     * </p>
     * @return Um List{TEntity}
     */
    public List<TEntity> findAll();

    /**
     * <p>
     * Salva um {@link TEntity}.
     * Caso o objeto seja transiente, salva,
     * caso contrário, atualiza
     * </p>
     * @param entity um {@link TEntity}
     * @throws Exception Retorno genérico de exception
     */
    public void save(TEntity entity) throws Exception;

    /**
     * <p>
     * Coloca a {@link TEntity} abaixo do proxy
     * </p>
     * @param entity A entidade
     * @throws Exception Retorno genérico de exception
     */
    public void merge(TEntity entity) throws Exception;

    /**
     * <p>
     * Remove uma {@link TEntity}
     * </p>
     * @param entity uma entidade
     * @throws Exception Retorno genérico de exception
     */
    public void remove(TEntity entity) throws Exception;

    /**
     * <p>
     * Dado um Id, a entidade do tipo {@link TEntity} relacionada a ela
     * </p>
     * @param id Um Id
     * @throws Exception Retorno genérico de exception
     */
    public void removeById(final Long id) throws Exception;
}
