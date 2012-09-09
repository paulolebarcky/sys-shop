package sys.shop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa a entidade relacionada a chave compra de mercadoria.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Embeddable
public class MercadoriaCompraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "mec_id")
    private int mecId;
    @Basic(optional = false)
    @Column(name = "com_id")
    private int comId;

    public MercadoriaCompraPK() {
    }

    public MercadoriaCompraPK(int mecId, int comId) {
        this.mecId = mecId;
        this.comId = comId;
    }

    public int getMecId() {
        return mecId;
    }

    public void setMecId(int mecId) {
        this.mecId = mecId;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mecId;
        hash += (int) comId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MercadoriaCompraPK)) {
            return false;
        }
        MercadoriaCompraPK other = (MercadoriaCompraPK) object;
        if (this.mecId != other.mecId) {
            return false;
        }
        if (this.comId != other.comId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.MecMercadoriaCompraPK[ mecId=" + mecId + ", comId=" + comId + " ]";
    }
    
}
