/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author paulo
 */
@Embeddable
public class PgvPagamentoVendaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pgv_id")
    private int pgvId;
    @Basic(optional = false)
    @Column(name = "ven_id")
    private int venId;

    public PgvPagamentoVendaPK() {
    }

    public PgvPagamentoVendaPK(int pgvId, int venId) {
        this.pgvId = pgvId;
        this.venId = venId;
    }

    public int getPgvId() {
        return pgvId;
    }

    public void setPgvId(int pgvId) {
        this.pgvId = pgvId;
    }

    public int getVenId() {
        return venId;
    }

    public void setVenId(int venId) {
        this.venId = venId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pgvId;
        hash += (int) venId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgvPagamentoVendaPK)) {
            return false;
        }
        PgvPagamentoVendaPK other = (PgvPagamentoVendaPK) object;
        if (this.pgvId != other.pgvId) {
            return false;
        }
        if (this.venId != other.venId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.PgvPagamentoVendaPK[ pgvId=" + pgvId + ", venId=" + venId + " ]";
    }
    
}
