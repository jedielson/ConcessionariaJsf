/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.application.interfaces;

import com.jedi.concessionaria.application.common.IFilteredQueryableAppService;
import com.jedi.concessionaria.application.interfaces.common.IAppServiceBase;
import com.jedi.concessionaria.domain.entities.Modelo;
import com.jedi.concessionaria.domain.filters.ModeloFilter;

/**
 *
 * @author Jedielson Nakonieczni
 */
public interface IModeloAppService extends IAppServiceBase<Modelo>,
                                           IFilteredQueryableAppService<Modelo, ModeloFilter> {
    
}
