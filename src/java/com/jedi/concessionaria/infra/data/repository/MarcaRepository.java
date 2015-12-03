package com.jedi.concessionaria.infra.data.repository;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.repository.IMarcaRepository;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
@Local(IMarcaRepository.class)
public class MarcaRepository extends RepositoryBase<Marca> implements IMarcaRepository {

    public MarcaRepository() {
    }

    @Override
    public Marca getByName(String name) {
        String sql = "FROM Marca m WHERE m.nome=:pNome";
        Query query = this.getManager().createQuery(sql);

        query.setParameter("pNome", name);

        List result = query.getResultList();
        
        if(result != null && result.size() > 0){
            return (Marca)result.get(0);
        }
        
        return null;
    }

}
