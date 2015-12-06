/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.repository;

import com.jedi.concessionaria.domain.entities.Carro;
import com.jedi.concessionaria.domain.interfaces.repository.common.IFilteredQueryRepository;
import com.jedi.concessionaria.domain.interfaces.repository.common.IRepositoryBase;

/**
 *
 * @author Jedielson Nakonieczni
 */
public interface ICarroRepository extends IRepositoryBase<Carro>,
                                            IFilteredQueryRepository<Carro, Carro>{
    
}
