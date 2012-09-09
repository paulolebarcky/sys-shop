package sys.shop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa a entidade relacionada a forma de pagamento.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "fop_forma_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FopFormaPagamento.findAll", query = "SELECT f FROM FopFormaPagamento f"),
    @NamedQuery(name = "FopFormaPagamento.findByFopId", query = "SELECT f FROM FopFormaPagamento f WHERE f.fopId = :fopId"),
    @NamedQuery(name = "FopFormaPagamento.findByFopNome", query = "SELECT f FROM FopFormaPagamento f WHERE f.fopNome = :fopNome"),
    @NamedQuery(name = "FopFormaPagamento.findByFopSigla", query = "SELECT f FROM FopFormaPagamento f WHERE f.fopSigla = :fopSigla"),
    @NamedQuery(name = "FopFormaPagamento.findByFopDtcadastro", query = "SELECT f FROM FopFormaPagamento f WHERE f.fopDtcadastro = :fopDtcadastro"),
    @NamedQuery(name = "FopFormaPagamento.findByFopStatus", query = "SELECT f FROM FopFormaPagamento f WHERE f.fopStatus = :fopStatus"),
    @NamedQuery(name = "FopFormaPagamento.findByFopDescricao", query = "SELECT f FROM FopFormaPagamento f WHERE f.fopDescricao = :fopDescricao")})
public class FormaPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fop_id")
    private Integer fopId;
    @Column(name = "fop_nome")
    private String fopNome;
    @Column(name = "fop_sigla")
    private String fopSigla;
    @Column(name = "fop_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date fopDtcadastro;
    @Column(name = "fop_status")
    private Character fopStatus;
    @Column(name = "fop_descricao")
    private String fopDescricao;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer fopId) {
        this.fopId = fopId;
    }

    public Integer getFopId() {
        return fopId;
    }

    public void setFopId(Integer fopId) {
        this.fopId = fopId;
    }

    public String getFopNome() {
        return fopNome;
    }

    public void setFopNome(String fopNome) {
        this.fopNome = fopNome;
    }

    public String getFopSigla() {
        return fopSigla;
    }

    public void setFopSigla(String fopSigla) {
        this.fopSigla = fopSigla;
    }

    public Date getFopDtcadastro() {
        return fopDtcadastro;
    }

    public void setFopDtcadastro(Date fopDtcadastro) {
        this.fopDtcadastro = fopDtcadastro;
    }

    public Character getFopStatus() {
        return fopStatus;
    }

    public void setFopStatus(Character fopStatus) {
        this.fopStatus = fopStatus;
    }

    public String getFopDescricao() {
        return fopDescricao;
    }

    public void setFopDescricao(String fopDescricao) {
        this.fopDescricao = fopDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fopId != null ? fopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.fopId == null && other.fopId != null) || (this.fopId != null && !this.fopId.equals(other.fopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.FopFormaPagamento[ fopId=" + fopId + " ]";
    }
    
}
