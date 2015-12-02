/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.jedi.concessionaria.application.interfaces.IMarcaAppService;
import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.web.util.WebUtil;

/**
 *
 * @author Jedielson
 */
@Named(value = "marcaController")
@SessionScoped
public class MarcaController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2450999061969991594L;
    @EJB
    private IMarcaAppService marcaAppService;
    private Marca marca;

    /**
     * Creates a new instance of MarcaController
     */
    public MarcaController() {
        this.marca = new Marca();
    }

    public void salvar() {
        try {
            this.marcaAppService.save(this.marca);
        } catch (Exception e) {
            WebUtil.addWarningMessage(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
	// </editor-fold>
}
