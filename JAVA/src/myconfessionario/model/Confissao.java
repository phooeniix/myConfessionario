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
import javax.persistence.OneToOne;

/**
 *
 * @author ahcar
 */
@Entity
public class Confissao implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Fiel cod_pecador;
    @ManyToOne
    private Pecados pecado;
    private String especificacao;
    private String categoria;
    private String data_pecado;
    private String data_confissao;
    private String local;
    private String motivo;
    private boolean desviado;
    private int quantidade_vezes;

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
        if (!(object instanceof Confissao)) {
            return false;
        }
        Confissao other = (Confissao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myconfessionario.model.Confissao[ id=" + id + " ]";
    }
    /**
     * @return the cod_pecador
     */
    public Fiel getCod_pecador() {
        return cod_pecador;
    }

    /**
     * @param cod_pecador the cod_pecador to set
     */
    public void setCod_pecador(Fiel cod_pecador) {
        this.cod_pecador = cod_pecador;
    }

    /**
     * @return the pecado
     */
    public Pecados getPecado() {
        return pecado;
    }

    /**
     * @param pecado the pecado to set
     */
    public void setPecado(Pecados pecado) {
        this.pecado = pecado;
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the data_pecado
     */
    public String getData_pecado() {
        return data_pecado;
    }

    /**
     * @param data_pecado the data_pecado to set
     */
    public void setData_pecado(String data_pecado) {
        this.data_pecado = data_pecado;
    }

    /**
     * @return the data_confissao
     */
    public String getData_confissao() {
        return data_confissao;
    }

    /**
     * @param data_confissao the data_confissao to set
     */
    public void setData_confissao(String data_confissao) {
        this.data_confissao = data_confissao;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the desviado
     */
    public boolean isDesviado() {
        return desviado;
    }

    /**
     * @param desviado the desviado to set
     */
    public void setDesviado(boolean desviado) {
        this.desviado = desviado;
    }

    /**
     * @return the quantidade_vezes
     */
    public int getQuantidade_vezes() {
        return quantidade_vezes;
    }

    /**
     * @param quantidade_vezes the quantidade_vezes to set
     */
    public void setQuantidade_vezes(int quantidade_vezes) {
        this.quantidade_vezes = quantidade_vezes;
    }
    
}
