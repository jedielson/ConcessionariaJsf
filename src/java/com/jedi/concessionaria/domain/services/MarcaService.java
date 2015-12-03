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
import java.util.List;

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

    @Override
    public void save(Marca entity) throws Exception {
        try {
            if (!this.existeComONome(entity.getNome())) {
                super.save(entity);
                return;
            }
            
            throw new Exception(String.format("O já existe uma marca com o nome %s", entity.getNome()));
        } catch (Exception ex) {
            throw new Exception("Não foi possível salvar a marca.", ex);
        }
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public boolean existeComONome(String nome) {
        return this.repository.getByName(nome) != null;
    }
    
    public List<Marca> getByExample(Marca exemplo){
        return this.repository.getByExample(exemplo);
    }
}
