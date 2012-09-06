/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author paulo
 */
@Entity
@Table(name = "pgv_pagamento_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgvPagamentoVenda.findAll", query = "SELECT p FROM PgvPagamentoVenda p"),
    @NamedQuery(name = "PgvPagamentoVenda.findByPgvId", query = "SELECT p FROM PgvPagamentoVenda p WHERE p.pgvPagamentoVendaPK.pgvId = :pgvId"),
    @NamedQuery(name = "PgvPagamentoVenda.findByVenId", query = "SELECT p FROM PgvPagamentoVenda p WHERE p.pgvPagamentoVendaPK.venId = :venId"),
    @NamedQuery(name = "PgvPagamentoVenda.findByPgvData", query = "SELECT p FROM PgvPagamentoVenda p WHERE p.pgvData = :pgvData"),
    @NamedQuery(name = "PgvPagamentoVenda.findByPgvValor", query = "SELECT p FROM PgvPagamentoVenda p WHERE p.pgvValor = :pgvValor"),
    @NamedQuery(name = "PgvPagamentoVenda.findByPgvStatus", query = "SELECT p FROM PgvPagamentoVenda p WHERE p.pgvStatus = :pgvStatus")})
public class PgvPagamentoVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgvPagamentoVendaPK pgvPagamentoVendaPK;
    @Column(name = "pgv_data")
    @Temporal(TemporalType.DATE)
    private Date pgvData;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pgv_valor")
    private Double pgvValor;
    @Column(name = "pgv_status")
    private Character pgvStatus;

    public PgvPagamentoVenda() {
    }

    public PgvPagamentoVenda(PgvPagamentoVendaPK pgvPagamentoVendaPK) {
        this.pgvPagamentoVendaPK = pgvPagamentoVendaPK;
    }

    public PgvPagamentoVenda(int pgvId, int venId) {
        this.pgvPagamentoVendaPK = new PgvPagamentoVendaPK(pgvId, venId);
    }

    public PgvPagamentoVendaPK getPgvPagamentoVendaPK() {
        return pgvPagamentoVendaPK;
    }

    public void setPgvPagamentoVendaPK(PgvPagamentoVendaPK pgvPagamentoVendaPK) {
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
        if (!(object instanceof PgvPagamentoVenda)) {
            return false;
        }
        PgvPagamentoVenda other = (PgvPagamentoVenda) object;
        if ((this.pgvPagamentoVendaPK == null && other.pgvPagamentoVendaPK != null) || (this.pgvPagamentoVendaPK != null && !this.pgvPagamentoVendaPK.equals(other.pgvPagamentoVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.PgvPagamentoVenda[ pgvPagamentoVendaPK=" + pgvPagamentoVendaPK + " ]";
    }
    
}
