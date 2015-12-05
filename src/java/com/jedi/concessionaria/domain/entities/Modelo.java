/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.entities;

import com.jedi.concessionaria.domain.entities.enumerations.ModeloCombustivel;
import com.jedi.concessionaria.domain.entities.enumerations.ModeloPortas;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Entity
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;

    //<editor-fold defaultstate="collapsed" desc="Attributes">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modeloId;

    @Column(length = 50, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ModeloPortas modeloPortas;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private ModeloCombustivel combustivel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marcaId", nullable = false)
    private Marca marca;
    
    @OneToMany(mappedBy = "modelo")
    private List<Carro> carros;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Modelo() {
    }

    public Modelo(String nome, ModeloPortas modeloPortas, ModeloCombustivel combustivel, Marca marca) {
        this.nome = nome;
        this.modeloPortas = modeloPortas;
        this.combustivel = combustivel;
        this.marca = marca;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter">
    public Integer getModeloId() {
        return modeloId;
    }

    public String getNome() {
        return nome;
    }

    public ModeloPortas getModeloPortas() {
        return modeloPortas;
    }

    public Marca getMarca() {
        return marca;
    }

    public ModeloCombustivel getCombustivel() {
        return combustivel;
    }

    public List<Carro> getCarros() {
        return carros;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter">
    public void setModeloId(Integer modeloId) {
        this.modeloId = modeloId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModeloPortas(ModeloPortas modeloPortas) {
        this.modeloPortas = modeloPortas;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setCombustivel(ModeloCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Equals">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.modeloId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.modeloId, other.modeloId)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.modeloPortas != other.modeloPortas) {
            return false;
        }        
        if (this.combustivel != other.combustivel) {
            return false;
        }
        return Objects.equals(this.marca, other.marca);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">    
    @Override
    public String toString() {
        return "Modelo{" + "modeloId=" + modeloId + ", nome=" + nome + ", modeloPortas=" + modeloPortas + ", combustivel=" + combustivel + ", marca=" + marca.getNome() + '}';
    }
    //</editor-fold>

}
