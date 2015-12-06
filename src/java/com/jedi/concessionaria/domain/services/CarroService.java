/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.services;

import com.jedi.concessionaria.domain.entities.Carro;
import com.jedi.concessionaria.domain.interfaces.repository.ICarroRepository;
import com.jedi.concessionaria.domain.interfaces.services.ICarroService;
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
@Local(ICarroService.class)
public class CarroService extends ServiceBase<Carro>
                            implements ICarroService {

    @EJB
    private ICarroRepository carroRepository;

    public CarroService() {
    }

    @PostConstruct
    private void init() {
        this.setRepositoryBase(carroRepository);
    }

    /**
     * {@inheritDoc }
     * 
     * @throws java.lang.Exception Caso ocorra alguma exceção ao salvar o carro
     */
    @Override
    public void save(Carro entity) throws Exception {
        entity.setPlaca(entity.getPlaca().toUpperCase());
        entity.setChassi(entity.getChassi().toUpperCase());
        super.save(entity);
    }
    
    

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Carro> getByExample(Carro filter) {
        return this.carroRepository.getByExample(filter);
    }

}
