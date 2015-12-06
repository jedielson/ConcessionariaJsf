/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jedi.concessionaria.infra.data.repository;

import com.jedi.concessionaria.domain.entities.Carro;
import com.jedi.concessionaria.domain.interfaces.repository.ICarroRepository;
import com.jedi.concessionaria.domain.interfaces.repository.common.IFilteredQueryBuilder;
import com.jedi.concessionaria.infra.data.repository.common.RepositoryBase;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
@Local(ICarroRepository.class)
public class CarroRepository extends RepositoryBase<Carro>
                                implements ICarroRepository,
                                            IFilteredQueryBuilder<Carro, Carro>{

    public CarroRepository(){
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Carro> getByExample(Carro filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public CriteriaQuery<Carro> createCriteria(Carro filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
