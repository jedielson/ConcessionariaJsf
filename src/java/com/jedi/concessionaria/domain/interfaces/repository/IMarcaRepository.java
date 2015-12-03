/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.interfaces.repository;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.interfaces.repository.common.IRepositoryBase;
import java.util.List;

/**
 *
 * Interface para implementação de um {@link IRepositoryBase{Marca}}
 * 
 * @author AS
 */
public interface IMarcaRepository extends IRepositoryBase<Marca> {
    
    /**
     * Seleciona uma {@link Marca} filtrando pelo nome.
     * @param name O nome da marca a ser pesquisada
     * @return Uma marca compatível, ou Null caso não encontre
     */
    Marca getByName(String name);
    
    /**
     * Seleciona uma coleção de {@link Marca} usando um objeto de exemplo
     * @param exemplo O exemplo
     * @return Uma lista de resultados compatíveis com o exemplo
     */
    List<Marca> getByExample(Marca exemplo);

}
