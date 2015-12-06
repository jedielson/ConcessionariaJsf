/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.services;

import com.jedi.concessionaria.domain.entities.Carro;
import com.jedi.concessionaria.domain.interfaces.services.common.IServiceBase;
import com.jedi.concessionaria.domain.services.common.IFilteredQueryService;

/**
 *
 * @author AS
 */
public interface ICarroService extends IServiceBase<Carro>,
                                        IFilteredQueryService<Carro, Carro>{
    
}
