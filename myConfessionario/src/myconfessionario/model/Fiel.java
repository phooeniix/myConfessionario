/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconfessionario.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ahcar
 */
@Entity
public class Fiel implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pessoa cod_pessoa;
    @ManyToOne
    private Endereco cod_endereco;
    private boolean batizado;
    private boolean frequenta_igreja;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fiel)) {
            return false;
        }
        Fiel other = (Fiel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myconfessionario.model.Fiel[ id=" + id + " ]";
    }
    /**
     * @return the cod_pessoa
     */
    public Pessoa getCod_pessoa() {
        return cod_pessoa;
    }

    /**
     * @param cod_pessoa the cod_pessoa to set
     */
    public void setCod_pessoa(Pessoa cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    /**
     * @return the cod_endereco
     */
    public Endereco getCod_endereco() {
        return cod_endereco;
    }

    /**
     * @param cod_endereco the cod_endereco to set
     */
    public void setCod_endereco(Endereco cod_endereco) {
        this.cod_endereco = cod_endereco;
    }

    /**
     * @return the batizado
     */
    public boolean isBatizado() {
        return batizado;
    }

    /**
     * @param batizado the batizado to set
     */
    public void setBatizado(boolean batizado) {
        this.batizado = batizado;
    }

    /**
     * @return the frequenta_igreja
     */
    public boolean isFrequenta_igreja() {
        return frequenta_igreja;
    }

    /**
     * @param frequenta_igreja the frequenta_igreja to set
     */
    public void setFrequenta_igreja(boolean frequenta_igreja) {
        this.frequenta_igreja = frequenta_igreja;
    }
}
