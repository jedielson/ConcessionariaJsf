/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Entity
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carroId;
    
    @Column(length = 8, nullable = false)
    private String placa;
    
    @Column(length = 20, nullable = false)
    private String chassi;
    
    @ManyToOne(optional = false)
    private Modelo modelo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Carro() {
    }

    public Carro(Integer carroId, String placa, String chassi, Modelo modelo) {
        this.carroId = carroId;
        this.placa = placa;
        this.chassi = chassi;
        this.modelo = modelo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter">
    public Integer getCarroId() {
        return carroId;
    }

    public String getPlaca() {
        return placa;
    }

    public String getChassi() {
        return chassi;
    }

    public Modelo getModelo() {
        return modelo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter">
    public void setCarroId(Integer carroId) {
        this.carroId = carroId;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Equals">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.carroId);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.carroId, other.carroId)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.chassi, other.chassi)) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "Carro{" + "carroId=" + carroId + ", placa=" + placa + ", chassi=" + chassi + ", modelo=" + modelo + '}';
    }
    //</editor-fold>
}
