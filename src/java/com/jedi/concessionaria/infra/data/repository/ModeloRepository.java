/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.infra.data.repository;

import com.jedi.concessionaria.domain.entities.Modelo;
import com.jedi.concessionaria.domain.filters.ModeloFilter;
import com.jedi.concessionaria.domain.interfaces.repository.IModeloRepository;
import com.jedi.concessionaria.domain.interfaces.repository.common.IFilteredQueryBuilder;
import com.jedi.concessionaria.infra.data.repository.common.RepositoryBase;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Stateless
@Local(IModeloRepository.class)
public class ModeloRepository extends RepositoryBase<Modelo>
                            implements IModeloRepository,
                                        IFilteredQueryBuilder<Modelo, ModeloFilter> {

    public ModeloRepository() {
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Modelo> getByExample(ModeloFilter filter) {
        CriteriaQuery<Modelo> criteriaQuery = this.createCriteria(filter);
        Query query = this.getManager().createQuery(criteriaQuery);

        return (List<Modelo>) query.getResultList();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public CriteriaQuery<Modelo> createCriteria(ModeloFilter filter) {
        CriteriaBuilder builder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Modelo> query = builder.createQuery(Modelo.class);

        Root<Modelo> from = query.from(Modelo.class);
        List<Predicate> predicados = new ArrayList<>();

        if (filter == null) {
            return query;
        }

        if (filter.getMarca() != null && filter.getMarca().getMarcaId() != null && filter.getMarca().getMarcaId() > 0) {
            predicados.add(builder.equal(from.get("marca"), filter.getMarca().getMarcaId()));
        }

        if (filter.getNome() != null && !filter.getNome().isEmpty()) {
            predicados.add(builder.like(from.get("nome"), "%" + filter.getNome() + "%"));
        }

        if (filter.getPortas() != null && !filter.getPortas().isEmpty()) {
            predicados.add(from.get("modeloPortas").in(filter.getPortas()));
        }

        if (filter.getCombustiveis() != null && !filter.getCombustiveis().isEmpty()) {
            predicados.add(from.get("combustivel").in(filter.getCombustiveis()));
        }

        if (!predicados.isEmpty()) {
            query.where(builder.and(predicados.toArray(new Predicate[]{})));
        }

        return query;
    }

}
