package com.jedi.concessionaria.infra.data.repository;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.repository.IMarcaRepository;
import javax.ejb.Stateless;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
public class MarcaRepository extends RepositoryBase<Marca> implements IMarcaRepository{
    
    public MarcaRepository(){
    }
    
}
