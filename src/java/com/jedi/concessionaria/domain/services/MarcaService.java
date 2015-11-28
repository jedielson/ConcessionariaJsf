/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.services;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.services.IMarcaService;
import com.jedi.concessionaria.domain.services.common.ServiceBase;
import com.jedi.concessionaria.infra.data.repository.MarcaRepository;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
public class MarcaService extends ServiceBase<Marca> implements IMarcaService {

    @EJB
    private MarcaRepository repository;

    public MarcaService() {
        //super(new MarcaRepository());
        this.setRepositoryBase(repository);
    }
}
