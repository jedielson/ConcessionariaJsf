/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.services;

import com.jedi.concessionaria.domain.entities.Modelo;
import com.jedi.concessionaria.domain.filters.ModeloFilter;
import com.jedi.concessionaria.domain.interfaces.repository.IModeloRepository;
import com.jedi.concessionaria.domain.interfaces.services.IModeloService;
import com.jedi.concessionaria.domain.services.common.ServiceBase;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
@Local(IModeloService.class)
public class ModeloService extends ServiceBase<Modelo> implements IModeloService {

    @EJB
    private IModeloRepository modeloRepository;

    public ModeloService() {
    }
    
    @PostConstruct
    public void init(){
        this.setRepositoryBase(modeloRepository);
    }

    /**
     * {@inheritDoc }     
     */
    @Override
    public List<Modelo> getByExample(ModeloFilter filter) {
        return this.modeloRepository.getByExample(filter);
    }

}
