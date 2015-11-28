/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.repository;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.repository.common.IRepositoryBase;
import javax.ejb.Local;

/**
 *
 * Interface para implementação de um {@link IRepositoryBase{Marca}}
 * @author AS
 */
@Local
public interface IMarcaRepository extends  IRepositoryBase<Marca>{
    
}
