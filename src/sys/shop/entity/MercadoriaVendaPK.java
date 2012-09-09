package sys.shop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa a entidade relacionada a chave de venda de mercadoria.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Embeddable
public class MercadoriaVendaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "mev_id")
    private int mevId;
    @Basic(optional = false)
    @Column(name = "ven_id")
    private int venId;
    @Basic(optional = false)
    @Column(name = "mer_id")
    private int merId;

    public MercadoriaVendaPK() {
    }

    public MercadoriaVendaPK(int mevId, int venId, int merId) {
        this.mevId = mevId;
        this.venId = venId;
        this.merId = merId;
    }

    public int getMevId() {
        return mevId;
    }

    public void setMevId(int mevId) {
        this.mevId = mevId;
    }

    public int getVenId() {
        return venId;
    }

    public void setVenId(int venId) {
        this.venId = venId;
    }

    public int getMerId() {
        return merId;
    }

    public void setMerId(int merId) {
        this.merId = merId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mevId;
        hash += (int) venId;
        hash += (int) merId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MercadoriaVendaPK)) {
            return false;
        }
        MercadoriaVendaPK other = (MercadoriaVendaPK) object;
        if (this.mevId != other.mevId) {
            return false;
        }
        if (this.venId != other.venId) {
            return false;
        }
        if (this.merId != other.merId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.MevMercadoriaVendaPK[ mevId=" + mevId + ", venId=" + venId + ", merId=" + merId + " ]";
    }
    
}
