/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.domain.entities.enumerations;

/**
 * Define a quantidade de portas que um modelo pode possuir
 *
 * @author Jedielson Nakonieczni
 */
public enum ModeloPortas {

    DUAS("Duas Portas"),
    QUATRO("Quatro Portas"),
    CINCO("Cinco Portas");

    private final String portas;

    private ModeloPortas(String value) {
        this.portas = value;
    }

}
