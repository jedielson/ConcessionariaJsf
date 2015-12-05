/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.filters;

import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.entities.enumerations.ModeloCombustivel;
import com.jedi.concessionaria.domain.entities.enumerations.ModeloPortas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jedielson Nakonieczni
 */
public class ModeloFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Marca marca;
    private String nome;
    private List<ModeloPortas> portas;
    private List<ModeloCombustivel> combustiveis;

    public ModeloFilter() {
        this.marca = new Marca();
        this.portas = new ArrayList<>();
        this.combustiveis = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getter">
    public Marca getMarca() {
        return marca;
    }

    public String getNome() {
        return nome;
    }

    public List<ModeloPortas> getPortas() {
        return portas;
    }

    public List<ModeloCombustivel> getCombustiveis() {
        return combustiveis;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter">
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPortas(List<ModeloPortas> portas) {
        this.portas = portas;
    }

    public void setCombustiveis(List<ModeloCombustivel> combustiveis) {
        this.combustiveis = combustiveis;
    }
    //</editor-fold>

    @Override
    public String toString() {
        String texto = "ModeloFilter{" + "marca=";
        texto += marca !=null ? marca.getNome() : "NULL";
        texto += ", nome=" + nome + ", portas={\n";
        texto = portas.stream().map(
                (porta) -> porta.toString() + ",\n")
                .reduce(texto, String::concat);
        
        texto += "}\n, combustíveis={\n";
        
        texto = combustiveis.stream().map(
                (combustivel) -> combustivel.toString() + ",\n")
                .reduce(texto, String::concat);
        
        return texto;
    }
    
    
}
