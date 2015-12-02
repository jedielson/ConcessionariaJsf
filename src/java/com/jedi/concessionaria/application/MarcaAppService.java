/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.application;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.jedi.concessionaria.application.common.AppServiceBase;
import com.jedi.concessionaria.application.interfaces.IMarcaAppService;
import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.services.IMarcaService;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
@Local(IMarcaAppService.class)
public class MarcaAppService extends AppServiceBase<Marca> implements IMarcaAppService {

    @EJB
    private IMarcaService marcaService;

    public MarcaAppService() {
    }

    @PostConstruct
    public void init() {
        this.setServiceBase(marcaService);
    }

}
