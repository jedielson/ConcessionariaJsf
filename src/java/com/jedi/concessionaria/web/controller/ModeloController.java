/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.web.controller;

import com.jedi.concessionaria.application.interfaces.IMarcaAppService;
import com.jedi.concessionaria.application.interfaces.IModeloAppService;
import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.entities.Modelo;
import com.jedi.concessionaria.domain.entities.enumerations.ModeloCombustivel;
import com.jedi.concessionaria.domain.entities.enumerations.ModeloPortas;
import com.jedi.concessionaria.domain.filters.ModeloFilter;
import com.jedi.concessionaria.web.util.WebUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Jedielson Nakonieczni
 */
@Named(value = "modeloController")
@ViewScoped
public class ModeloController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private IMarcaAppService marcaService;

    @EJB
    private IModeloAppService modeloService;

    private Modelo modelo;
    private ModeloFilter filtro;
    private List<Modelo> gridModelos;
    private String dialog;

    /**
     * Creates a new instance of ModeloController
     */
    public ModeloController() {
        this.modelo = new Modelo();
        this.filtro = new ModeloFilter();
        this.gridModelos = new ArrayList<>();
        this.dialog = "cadastrar";
    }

    public void atualizaGrid() {        
        try {
            this.gridModelos = this.modeloService.carregarConsulta(filtro);
        } catch (Exception ex) {
            WebUtil.addErrorMessage("Ocorreu um erro ao efetuar a consulta de Modelos.\n" + ex.getMessage());
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        try {
            this.modeloService.save(modelo);
            this.modelo = new Modelo();
            WebUtil.addInfoMessage("Modelo Salvo com Sucesso");
        } catch (Exception ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.addErrorMessage("Ocorreu um erro ao salvar o modelo.\n" + ex.getMessage());
        }
    }

    public void editar(Modelo modelo) {
        this.modelo = modelo;
        this.dialog = "editar";
    }

    public void atualizar() {
        try {
            this.modeloService.update(modelo);
            this.atualizaGrid();
            WebUtil.addInfoMessage(String.format("Modelo %s atualizado com sucesso", this.modelo.getNome()));
            this.modelo = new Modelo();
        } catch (Exception ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, "Erro ao atualizar o modelo.", ex);
            WebUtil.addErrorMessage("Ocorreu um erro ao atualizar a o modelo");
        }
    }

    public void remover(Modelo modelo) {
        try {
            this.modeloService.remove(modelo);
            this.atualizaGrid();
            WebUtil.addInfoMessage("Modelo removido com sucesso");
        } catch (Exception ex) {
            WebUtil.addErrorMessage(String.format("Erro ao remover o modelo \n%s", ex.getCause().getMessage()));
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, "Erro ao remover o modelo", ex);
        }

    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public ModeloPortas[] getModeloPortasValues() {
        return ModeloPortas.values();
    }

    public ModeloCombustivel[] getModeloCombustivel() {
        return ModeloCombustivel.values();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Marca> getMarcas() {
        return this.marcaService.findAll();
    }

    public List<Modelo> getGridModelos() {
        return gridModelos;
    }

    public String getDialog() {
        return this.dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public ModeloFilter getFiltro() {
        return filtro;
    }

    public void setFiltro(ModeloFilter filtro) {
        this.filtro = filtro;
    }
    //</editor-fold>

}
