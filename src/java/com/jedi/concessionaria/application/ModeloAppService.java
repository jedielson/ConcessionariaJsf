/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jedi.concessionaria.application;

import com.jedi.concessionaria.application.common.AppServiceBase;
import com.jedi.concessionaria.application.interfaces.IModeloAppService;
import com.jedi.concessionaria.domain.entities.Modelo;
import com.jedi.concessionaria.domain.filters.ModeloFilter;
import com.jedi.concessionaria.domain.interfaces.services.IModeloService;
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
@Local(IModeloAppService.class)
public class ModeloAppService extends AppServiceBase<Modelo> implements IModeloAppService{

    @EJB
    private IModeloService modeloService;
    
    public ModeloAppService(){
    }
    
    @PostConstruct
    public void init() {
        this.setServiceBase(modeloService);
    }

    @Override
    public List<Modelo> carregarConsulta(ModeloFilter filtro) {
        return this.modeloService.getByExample(filtro);
    }
    
    
}
