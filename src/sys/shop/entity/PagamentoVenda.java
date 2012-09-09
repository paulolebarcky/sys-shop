package sys.shop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa a entidade relacionada ao pagamento de venda.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "pgv_pagamento_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagamentoVenda.findAll", query = "SELECT p FROM PagamentoVenda p"),
    @NamedQuery(name = "PagamentoVenda.findByPgvId", query = "SELECT p FROM PagamentoVenda p WHERE p.pgvPagamentoVendaPK.pgvId = :pgvId"),
    @NamedQuery(name = "PagamentoVenda.findByVenId", query = "SELECT p FROM PagamentoVenda p WHERE p.pgvPagamentoVendaPK.venId = :venId"),
    @NamedQuery(name = "PagamentoVenda.findByPgvData", query = "SELECT p FROM PagamentoVenda p WHERE p.pgvData = :pgvData"),
    @NamedQuery(name = "PagamentoVenda.findByPgvValor", query = "SELECT p FROM PagamentoVenda p WHERE p.pgvValor = :pgvValor"),
    @NamedQuery(name = "PagamentoVenda.findByPgvStatus", query = "SELECT p FROM PagamentoVenda p WHERE p.pgvStatus = :pgvStatus")})
public class PagamentoVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagamentoVendaPK pgvPagamentoVendaPK;
    @Column(name = "pgv_data")
    @Temporal(TemporalType.DATE)
    private Date pgvData;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pgv_valor")
    private Double pgvValor;
    @Column(name = "pgv_status")
    private Character pgvStatus;

    public PagamentoVenda() {
    }

    public PagamentoVenda(PagamentoVendaPK pgvPagamentoVendaPK) {
        this.pgvPagamentoVendaPK = pgvPagamentoVendaPK;
    }

    public PagamentoVenda(int pgvId, int venId) {
        this.pgvPagamentoVendaPK = new PagamentoVendaPK(pgvId, venId);
    }

    public PagamentoVendaPK getPagamentoVendaPK() {
        return pgvPagamentoVendaPK;
    }

    public void setPagamentoVendaPK(PagamentoVendaPK pgvPagamentoVendaPK) {
        this.pgvPagamentoVendaPK = pgvPagamentoVendaPK;
    }

    public Date getPgvData() {
        return pgvData;
    }

    public void setPgvData(Date pgvData) {
        this.pgvData = pgvData;
    }

    public Double getPgvValor() {
        return pgvValor;
    }

    public void setPgvValor(Double pgvValor) {
        this.pgvValor = pgvValor;
    }

    public Character getPgvStatus() {
        return pgvStatus;
    }

    public void setPgvStatus(Character pgvStatus) {
        this.pgvStatus = pgvStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgvPagamentoVendaPK != null ? pgvPagamentoVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagamentoVenda)) {
            return false;
        }
        PagamentoVenda other = (PagamentoVenda) object;
        if ((this.pgvPagamentoVendaPK == null && other.pgvPagamentoVendaPK != null) || (this.pgvPagamentoVendaPK != null && !this.pgvPagamentoVendaPK.equals(other.pgvPagamentoVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.PagamentoVenda[ pgvPagamentoVendaPK=" + pgvPagamentoVendaPK + " ]";
    }
    
}
