/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.services;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.services.common.IServiceBase;
import javax.ejb.Local;

/**
 *
 * @author AS
 */
@Local
public interface IMarcaService extends IServiceBase<Marca>{
    
}
