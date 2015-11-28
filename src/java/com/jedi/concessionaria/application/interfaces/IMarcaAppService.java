/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.application.interfaces;

import com.jedi.concessionaria.application.interfaces.common.IAppServiceBase;
import com.jedi.concessionaria.domain.entities.Marca;
import javax.ejb.Local;

/**
 *
 * @author AS
 */
@Local
public interface IMarcaAppService extends IAppServiceBase<Marca>{
    
}
