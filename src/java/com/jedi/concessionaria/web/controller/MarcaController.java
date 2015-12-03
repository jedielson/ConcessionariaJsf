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
import java.util.ArrayList;
import java.util.List;

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
    private Marca filtro;

    private String dialog;

    /**
     * Creates a new instance of MarcaController
     */
    public MarcaController() {
        this.marca = new Marca();
        this.filtro = new Marca();
        this.dialog = "cadastrar";
    }

    public void salvar() {
        try {
            this.marcaAppService.save(this.marca);
            WebUtil.addInfoMessage(String.format("Marca %s salva com sucesso!", marca.getNome()));
            this.marca = new Marca();
        } catch (Exception e) {
            WebUtil.addWarningMessage(String.format("%s \n%s", e.getMessage(), e.getCause().getMessage()));
        }
    }

    public void remover(Marca marca) {
        try {
            this.marcaAppService.remove(marca);
            WebUtil.addInfoMessage("Marca removida com sucesso");
        } catch (Exception ex) {
            WebUtil.addErrorMessage(String.format("Erro ao remover marca\n%s", ex.getCause().getMessage()));
        }
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Marca getFiltro() {
        return filtro;
    }

    public void setFiltro(Marca filtro) {
        this.filtro = filtro;
    }

    public List<Marca> getGridMarcas() {
        try {
            List<Marca> marcas = this.marcaAppService.findAll();
            return marcas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }

    // </editor-fold>
}
