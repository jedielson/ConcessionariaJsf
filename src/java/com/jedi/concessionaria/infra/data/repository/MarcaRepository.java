package com.jedi.concessionaria.infra.data.repository;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.repository.IMarcaRepository;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

        if (result != null && result.size() > 0) {
            return (Marca) result.get(0);
        }

        return null;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public List<Marca> getByExample(Marca exemplo){
        CriteriaQuery<Marca> filtro = this.createCriteria(exemplo);
        Query query = this.getManager().createQuery(filtro);
        
        return (List<Marca>) query.getResultList();
    }

    private CriteriaQuery<Marca> createCriteria(Marca marca) {
        CriteriaBuilder builder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Marca> query = builder.createQuery(Marca.class);

        Root<Marca> from = query.from(Marca.class);

        if (marca.getNome() != null && !marca.getNome().isEmpty()) {
            query.where(builder.like(from.get("nome"), "%" + marca.getNome() + "%"));
        }
        
        if(marca.getDescricao() != null && !marca.getDescricao().isEmpty()){
            query.where(builder.like(from.get("descricao"), "%" + marca.getDescricao()+ "%"));
        }
        
        return query;
    }
}
