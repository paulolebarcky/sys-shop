/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "mev_mercadoria_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MevMercadoriaVenda.findAll", query = "SELECT m FROM MevMercadoriaVenda m"),
    @NamedQuery(name = "MevMercadoriaVenda.findByMevId", query = "SELECT m FROM MevMercadoriaVenda m WHERE m.mevMercadoriaVendaPK.mevId = :mevId"),
    @NamedQuery(name = "MevMercadoriaVenda.findByVenId", query = "SELECT m FROM MevMercadoriaVenda m WHERE m.mevMercadoriaVendaPK.venId = :venId"),
    @NamedQuery(name = "MevMercadoriaVenda.findByMerId", query = "SELECT m FROM MevMercadoriaVenda m WHERE m.mevMercadoriaVendaPK.merId = :merId"),
    @NamedQuery(name = "MevMercadoriaVenda.findByMevValor", query = "SELECT m FROM MevMercadoriaVenda m WHERE m.mevValor = :mevValor"),
    @NamedQuery(name = "MevMercadoriaVenda.findByMevStatus", query = "SELECT m FROM MevMercadoriaVenda m WHERE m.mevStatus = :mevStatus")})
public class MevMercadoriaVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MevMercadoriaVendaPK mevMercadoriaVendaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mev_valor")
    private Double mevValor;
    @Column(name = "mev_status")
    private Character mevStatus;

    public MevMercadoriaVenda() {
    }

    public MevMercadoriaVenda(MevMercadoriaVendaPK mevMercadoriaVendaPK) {
        this.mevMercadoriaVendaPK = mevMercadoriaVendaPK;
    }

    public MevMercadoriaVenda(int mevId, int venId, int merId) {
        this.mevMercadoriaVendaPK = new MevMercadoriaVendaPK(mevId, venId, merId);
    }

    public MevMercadoriaVendaPK getMevMercadoriaVendaPK() {
        return mevMercadoriaVendaPK;
    }

    public void setMevMercadoriaVendaPK(MevMercadoriaVendaPK mevMercadoriaVendaPK) {
        this.mevMercadoriaVendaPK = mevMercadoriaVendaPK;
    }

    public Double getMevValor() {
        return mevValor;
    }

    public void setMevValor(Double mevValor) {
        this.mevValor = mevValor;
    }

    public Character getMevStatus() {
        return mevStatus;
    }

    public void setMevStatus(Character mevStatus) {
        this.mevStatus = mevStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mevMercadoriaVendaPK != null ? mevMercadoriaVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MevMercadoriaVenda)) {
            return false;
        }
        MevMercadoriaVenda other = (MevMercadoriaVenda) object;
        if ((this.mevMercadoriaVendaPK == null && other.mevMercadoriaVendaPK != null) || (this.mevMercadoriaVendaPK != null && !this.mevMercadoriaVendaPK.equals(other.mevMercadoriaVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.MevMercadoriaVenda[ mevMercadoriaVendaPK=" + mevMercadoriaVendaPK + " ]";
    }
    
}
