/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

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
@ViewScoped
public class MarcaController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2450999061969991594L;
    @EJB
    private IMarcaAppService marcaAppService;

    private Marca marca;
    private Marca filtro;

    List<Marca> marcas;

    private String dialog;

    /**
     * Creates a new instance of MarcaController
     */
    public MarcaController() {
        this.marca = new Marca();
        this.filtro = new Marca();
        this.marcas = new ArrayList<>();
        this.dialog = "cadastrar";
    }

    public void salvar() {
        try {
            this.marcaAppService.save(this.marca);
            this.atualizaGrid();
            WebUtil.addInfoMessage(String.format("Marca %s salva com sucesso!", marca.getNome()));
            this.marca = new Marca();
        } catch (Exception e) {
            WebUtil.addWarningMessage(String.format("%s \n%s", e.getMessage(), e.getCause().getMessage()));
        }
    }

    public void remover(Marca marca) {
        try {
            this.marcaAppService.remove(marca);
            this.atualizaGrid();
            WebUtil.addInfoMessage("Marca removida com sucesso");
        } catch (Exception ex) {
            WebUtil.addErrorMessage(String.format("Erro ao remover marca\n%s", ex.getCause().getMessage()));
        }
    }

    public void atualizar() {
        try {
            this.marcaAppService.update(this.marca);
            this.atualizaGrid();
            WebUtil.addInfoMessage(String.format("Marca %s editada com sucesso!", marca.getNome()));
            this.marca = new Marca();
        } catch (Exception e) {
            WebUtil.addWarningMessage(String.format("%s \n%s", e.getMessage(), e.getCause().getMessage()));
        }
    }

    public void editar(Marca marca) {
        this.marca = marca;
        this.setDialog("editar");
    }

    public void atualizaGrid() {
        this.marcas = this.marcaAppService.carregarConsulta(filtro);
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

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
        return this.marcas;
    }

    // </editor-fold>
}
