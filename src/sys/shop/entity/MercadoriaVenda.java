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
 * Representa a entidade relacionada a venda de mercadoria.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "mev_mercadoria_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MercadoriaVenda.findAll", query = "SELECT m FROM MercadoriaVenda m"),
    @NamedQuery(name = "MercadoriaVenda.findByMevId", query = "SELECT m FROM MercadoriaVenda m WHERE m.mevMercadoriaVendaPK.mevId = :mevId"),
    @NamedQuery(name = "MercadoriaVenda.findByVenId", query = "SELECT m FROM MercadoriaVenda m WHERE m.mevMercadoriaVendaPK.venId = :venId"),
    @NamedQuery(name = "MercadoriaVenda.findByMerId", query = "SELECT m FROM MercadoriaVenda m WHERE m.mevMercadoriaVendaPK.merId = :merId"),
    @NamedQuery(name = "MercadoriaVenda.findByMevValor", query = "SELECT m FROM MercadoriaVenda m WHERE m.mevValor = :mevValor"),
    @NamedQuery(name = "MercadoriaVenda.findByMevStatus", query = "SELECT m FROM MercadoriaVenda m WHERE m.mevStatus = :mevStatus")})
public class MercadoriaVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MercadoriaVendaPK mevMercadoriaVendaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mev_valor")
    private Double mevValor;
    @Column(name = "mev_status")
    private Character mevStatus;

    public MercadoriaVenda() {
    }

    public MercadoriaVenda(MercadoriaVendaPK mevMercadoriaVendaPK) {
        this.mevMercadoriaVendaPK = mevMercadoriaVendaPK;
    }

    public MercadoriaVenda(int mevId, int venId, int merId) {
        this.mevMercadoriaVendaPK = new MercadoriaVendaPK(mevId, venId, merId);
    }

    public MercadoriaVendaPK getMercadoriaVendaPK() {
        return mevMercadoriaVendaPK;
    }

    public void setMercadoriaVendaPK(MercadoriaVendaPK mevMercadoriaVendaPK) {
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
        if (!(object instanceof MercadoriaVenda)) {
            return false;
        }
        MercadoriaVenda other = (MercadoriaVenda) object;
        if ((this.mevMercadoriaVendaPK == null && other.mevMercadoriaVendaPK != null) || (this.mevMercadoriaVendaPK != null && !this.mevMercadoriaVendaPK.equals(other.mevMercadoriaVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.MercadoriaVenda[ mevMercadoriaVendaPK=" + mevMercadoriaVendaPK + " ]";
    }
    
}
