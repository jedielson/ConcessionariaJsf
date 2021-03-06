/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.application.interfaces;

import com.jedi.concessionaria.application.common.IFilteredQueryableAppService;
import com.jedi.concessionaria.application.interfaces.common.IAppServiceBase;
import com.jedi.concessionaria.domain.entities.Marca;
import java.util.List;

/**
 *
 * @author Jedielson Nakonieczni
 */
public interface IMarcaAppService extends IAppServiceBase<Marca>, IFilteredQueryableAppService<Marca, Marca>{
    
    /**
     * {@inheritDoc }
     * @param exemplo O exemplo
     * @return Uma {@link List} de {@link Marca}
     */
    @Override
    List<Marca> carregarConsulta(Marca exemplo);
    
}
