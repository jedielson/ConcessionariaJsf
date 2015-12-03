/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.infra.data.repository;

import com.jedi.concessionaria.domain.interfaces.repository.common.IRepositoryBase;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jedielson Nakonieczni
 * @param <TEntity> O tipo da entidade
 */
public abstract class RepositoryBase<TEntity> implements IRepositoryBase<TEntity> {

    @PersistenceContext(name = "ConcessionariaPU")
    private EntityManager entityManager;

    protected EntityManager getManager() {
        return this.entityManager;
    }

    /**
     * {@inheritDoc}
     *
     * E este é o meu comentário local, por que eu sou foda!
     */
    @Override
    public TEntity getById(Long id) {
        return (TEntity) entityManager.find(getTypeClass(), id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TEntity> findAll() {
        
        String sql = ("FROM " + getTypeClass().getSimpleName());
        
        System.err.println("Sql gerada no find all: " + sql);
        
        return entityManager.createQuery(sql)
                .getResultList();
    }

    /**
     * {@inheritDoc}
     *
     * @throws java.lang.Exception Caso ocorra algum erro no momento de
     * persistir os dados Um log é gravado neste momento
     */
    @Override
    public void save(TEntity entity) throws Exception {
        try {

            entityManager.persist(entity);
        } catch (Exception ex) {
            throw new Exception("Erro ao persistir um paciente.", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws java.lang.Exception Caso ocorra algum erro no momento de
     * persistir os dados Um log é gravado neste momento
     */
    @Override
    public TEntity merge(TEntity entity) throws Exception {
        try {

            entity = entityManager.merge(entity);
            return entity;

        } catch (Exception ex) {
            throw new Exception("Erro ao efetuar merge de um paciente.", ex);            
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws java.lang.Exception Caso ocorra algum erro no momento de
     * persistir os dados Um log é gravado neste momento
     */
    @Override
    public void remove(TEntity entity) throws Exception {
        try {

            entity = this.merge(entity);
            entityManager.remove(entity);

        } catch (Exception ex) {
            throw new Exception("Erro ao remover um paciente.", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws java.lang.Exception Caso ocorra algum erro no momento de
     * persistir os dados Um log é gravado neste momento
     */
    @Override
    public void removeById(Long id) throws Exception {
        try {

            this.remove(getById(id));

        } catch (Exception ex) {

            throw new Exception("Erro ao remover um paciente.", ex);
        }
    }

    /**
     * Recupera o tipo de {@TEntity}
     * @return O tipo de {@TEntity}
     */
    private Class<?> getTypeClass() {        
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

}
