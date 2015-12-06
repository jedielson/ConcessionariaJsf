/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.application;

import com.jedi.concessionaria.application.common.AppServiceBase;
import com.jedi.concessionaria.domain.entities.Carro;

import com.jedi.concessionaria.application.interfaces.ICarroAppService;
import com.jedi.concessionaria.domain.interfaces.services.ICarroService;
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
@Local(ICarroAppService.class)
public class CarroAppService extends AppServiceBase<Carro>
        implements ICarroAppService {

    @EJB
    private ICarroService carroService;

    public CarroAppService() {
    }

    @PostConstruct
    public void init() {
        this.setServiceBase(carroService);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Carro> carregarConsulta(Carro filtro) {
        return this.carroService.getByExample(filtro);
    }

}
