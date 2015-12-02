/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.repository.IMarcaRepository;
import com.jedi.concessionaria.domain.interfaces.services.IMarcaService;
import com.jedi.concessionaria.domain.services.common.ServiceBase;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
@Local(IMarcaService.class)
public class MarcaService extends ServiceBase<Marca> implements IMarcaService {

	@EJB
	private IMarcaRepository repository;

	public MarcaService() {
	}

	@PostConstruct
	public void init() {
		this.setRepositoryBase(repository);
	}
}
