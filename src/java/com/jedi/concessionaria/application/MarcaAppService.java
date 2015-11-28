/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jedi.concessionaria.application;

import com.jedi.concessionaria.application.common.AppServiceBase;
import com.jedi.concessionaria.application.interfaces.IMarcaAppService;
import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.services.MarcaService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
public class MarcaAppService extends AppServiceBase<Marca> implements IMarcaAppService{
    
    @EJB
    private MarcaService marcaService;
    
    public MarcaAppService(){        
        this.setServiceBase(new MarcaService());
    }
    
}
