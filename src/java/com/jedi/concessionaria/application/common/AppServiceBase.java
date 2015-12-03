/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jedi.concessionaria.application.common;

import com.jedi.concessionaria.application.interfaces.common.IAppServiceBase;
import com.jedi.concessionaria.domain.interfaces.services.common.IServiceBase;
import com.jedi.concessionaria.domain.services.common.ServiceBase;
import java.util.List;

/**
 *
 * @author Jedielson Nakonieczni
 * @param <TEntity> O tipo base do serviço
 */
public abstract class AppServiceBase<TEntity> implements IAppServiceBase<TEntity>{

    private IServiceBase serviceBase;
    
//    public AppServiceBase(IServiceBase serviceBase){
//        this.serviceBase = serviceBase;
//    }
    
    public AppServiceBase(){
        
    }

    protected void setServiceBase(IServiceBase serviceBase) {
        this.serviceBase = serviceBase;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public TEntity getById(Long id) {
        return (TEntity) this.serviceBase.getById(id);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<TEntity> findAll() {
        return this.serviceBase.findAll();
    }

    /**
     * {@inheritDoc }
     * @throws java.lang.Exception caso ocorra uma Excessão em {@link ServiceBase}
     */
    @Override
    public void save(TEntity entity) throws Exception {
        this.serviceBase.save(entity);
    }    
    
    /**
     * {@inheritDoc }
     * @throws java.lang.Exception caso ocorra uma Excessão em {@link ServiceBase}
     */
    @Override
    public void update(TEntity entity) throws Exception{
        this.serviceBase.update(entity);
    }

    /**
     * {@inheritDoc }
     * @throws java.lang.Exception caso ocorra uma Excessão em {@link ServiceBase}
     */
    @Override
    public void remove(TEntity entity) throws Exception {
        this.serviceBase.remove(entity);
    }

    /**
     * {@inheritDoc }
     * @throws java.lang.Exception caso ocorra uma Excessão em {@link ServiceBase}
     */
    @Override
    public void removeById(Long id) throws Exception {
        this.serviceBase.removeById(id);
    }
    
}
