package com.jedi.concessionaria.domain.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Esta classe define uma marca.
 *
 * @author Jedielson Nakonieczni
 */
@Entity
public class Marca implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Propriedades">
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marcaId;
    
    @Column(length = 30, nullable = false)
    private String nome;
    
    @Column(length = 100, nullable = false)
    private String descricao;
    
    @OneToMany(targetEntity = Modelo.class)
    private List<Modelo> modelos;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Marca() {
    }

    public Marca(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter">
    public Long getMarcaId() {
        return marcaId;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter">
    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Equals">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.marcaId);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.marcaId, other.marcaId)) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString()">
    @Override
    public String toString() {
        return "Marca{" + "marcaId=" + marcaId + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    //</editor-fold>

}
