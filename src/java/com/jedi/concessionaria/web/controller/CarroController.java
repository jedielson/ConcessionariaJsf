/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jedi.concessionaria.web.controller;

import com.jedi.concessionaria.application.interfaces.ICarroAppService;
import com.jedi.concessionaria.application.interfaces.IMarcaAppService;
import com.jedi.concessionaria.application.interfaces.IModeloAppService;
import com.jedi.concessionaria.domain.entities.Carro;
import com.jedi.concessionaria.domain.entities.Marca;
import com.jedi.concessionaria.domain.entities.Modelo;
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
 * @author AS
 */
@Named(value = "carroController")
@ViewScoped
public class CarroController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ICarroAppService carroService;

    @EJB
    private IMarcaAppService marcaService;

    @EJB
    private IModeloAppService modeloService;

    private Carro carro;
    private String dialog;

    private Carro filter;
    private Marca marcaFiltro;

    private List<Carro> gridCarros;
    private List<Modelo> modelos;

    /**
     * Creates a new instance of CarroController
     */
    public CarroController() {
        this.carro = new Carro();
        this.filter = new Carro();
        this.gridCarros = new ArrayList<>();
        this.modelos = new ArrayList<>();
        this.dialog = "cadastrar";
    }
    
    public void save() {
        try {
            this.carroService.save(carro);
            this.carro = new Carro();
            WebUtil.addInfoMessage("Carro salvo com sucesso.");
        } catch (Exception ex) {
            Logger.getLogger(CarroController.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.addErrorMessage("Erro ao salvar carro");
        }
    }
    

    public void atualizaGrid() {
        this.gridCarros = this.carroService.findAll();
    }

    public void editar(Carro carro) {
        this.carro = carro;
        this.marcaFiltro = this.carro.getModelo().getMarca();
        this.updateModelos();
        this.dialog = "editar";
    }
    
    public void atualizar() {
        try {
            this.carroService.update(this.carro);
            this.carro = new Carro();
            WebUtil.addInfoMessage("Carro Atualizado com sucesso");
        } catch (Exception ex) {
            Logger.getLogger(CarroController.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.addErrorMessage("Ocorreu um erro ao atualizar o carro");
        }
    }
    

    public void remover(Carro carro) {
        try {
            this.carroService.remove(carro);
            this.atualizaGrid();
            WebUtil.addInfoMessage("Carro deletado com sucesso.");
        } catch (Exception ex) {
            Logger.getLogger(CarroController.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.addErrorMessage("Não foi possível remover o carro");
        }
    }

    public List<Marca> marcasFiltro() {
        return this.marcaService.findAll();
    }

    public void updateModelos() {
        System.out.println("Entrou nos modelos");
        ModeloFilter modeloFilter = new ModeloFilter();
        modeloFilter.setMarca(marcaFiltro);
        this.modelos = this.modeloService.carregarConsulta(modeloFilter);
    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Carro getFilter() {
        return filter;
    }

    public void setFilter(Carro filter) {
        this.filter = filter;
    }

    public List<Carro> getGridCarros() {
        return gridCarros;
    }

    public void setGridCarros(List<Carro> gridCarros) {
        this.gridCarros = gridCarros;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public Marca getMarcaFiltro() {
        return marcaFiltro;
    }

    public void setMarcaFiltro(Marca marcaFiltro) {
        this.marcaFiltro = marcaFiltro;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    //</editor-fold>
}
