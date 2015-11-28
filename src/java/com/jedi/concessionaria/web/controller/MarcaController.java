/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.web.controller;

import com.jedi.concessionaria.application.MarcaAppService;
import com.jedi.concessionaria.domain.entities.Marca;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Jedielson
 */
@Named(value = "marcaController")
@SessionScoped
public class MarcaController implements Serializable {
    
    @EJB
    private MarcaAppService marcaService;    
    private Marca marca;
    
    /**
     * Creates a new instance of MarcaController
     */
    public MarcaController() {
        this.marca = new Marca();        
    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Marca getMarca() {
        return marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    //</editor-fold>
}
