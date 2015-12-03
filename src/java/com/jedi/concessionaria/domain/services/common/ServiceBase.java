/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.services.common;

import com.jedi.concessionaria.domain.interfaces.repository.common.IRepositoryBase;
import com.jedi.concessionaria.domain.interfaces.services.common.IServiceBase;
import java.util.List;

/**
 * <p>
 * Um serviço base tem a missão de prover as regras de negócio básicas para funcionamento de uma aplicação.
 * </p>
 * Além disso, pode ser exztendido em outros serviços, aplicando-se extensões da interface 
 * {@link IServiceBase} afim de determinar comportamentos específicos de algumas entidades
 * 
 * @author Jedielson Nakonieczni
 * @param <TEntity> O tipo do serviço
 */
public abstract class ServiceBase<TEntity> implements IServiceBase<TEntity> {

    private IRepositoryBase repositoryBase;

//    public ServiceBase(IRepositoryBase repositoryBase) {
//        this.repositoryBase = repositoryBase;
//    }
    
    public ServiceBase(){
        
    }

    protected void setRepositoryBase(IRepositoryBase repositoryBase) {
        this.repositoryBase = repositoryBase;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public TEntity getById(Long id) {
        return (TEntity) this.repositoryBase.getById(id);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<TEntity> findAll() {
        return this.repositoryBase.findAll();
    }

    /**
     * {@inheritDoc }
     * @throws java.lang.Exception Caso ocorra um erro em {@link #repositoryBase}
     */
    @Override
    public void save(TEntity entity) throws Exception {
        this.repositoryBase.save(entity);
    }
    
    
    /**
     * <p>
     * Salva um {@link TEntity}.
     * Caso o objeto seja transiente, salva,
     * caso contrário, atualiza
     * </p>
     * @param entity um {@link TEntity}
     * @throws Exception Retorno genérico de exception
     */
    @Override
    public void update(TEntity entity) throws Exception{
        this.repositoryBase.update(entity);
    }

    /**
     * {@inheritDoc }
     * @throws java.lang.Exception Caso ocorra um erro em {@link #repositoryBase}
     */
    @Override
    public void remove(TEntity entity) throws Exception {
        this.repositoryBase.remove(entity);
    }

    /**
     * {@inheritDoc }
     * @throws java.lang.Exception Caso ocorra um erro em {@link #repositoryBase}
     */
    @Override
    public void removeById(Long id) throws Exception {
        this.repositoryBase.removeById(id);
    }

}
