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

/**
 *
 * @author ahcar
 */
@Entity
public class Pecados implements Serializable {

   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String especificacao;
    private TiposPecado tipo_pecado; 
    private double indice_malvadeza;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) getId();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pecados)) {
            return false;
        }
        Pecados other = (Pecados) object;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myconfessionario.model.Pecados[ id=" + getId() + " ]";
    }
    
     /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the especificacao
     */
    public String getEspecificacao() {
        return especificacao;
    }

    /**
     * @param especificacao the especificacao to set
     */
    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    /**
     * @return the tipo_pecado
     */
    public TiposPecado getTipo_pecado() {
        return tipo_pecado;
    }

    /**
     * @param tipo_pecado the tipo_pecado to set
     */
    public void setTipo_pecado(TiposPecado tipo_pecado) {
        this.tipo_pecado = tipo_pecado;
    }

    /**
     * @return the indice_malvadeza
     */
    public double getIndice_malvadeza() {
        return indice_malvadeza;
    }

    /**
     * @param indice_malvadeza the indice_malvadeza to set
     */
    public void setIndice_malvadeza(double indice_malvadeza) {
        this.indice_malvadeza = indice_malvadeza;
    }

   

    
}
