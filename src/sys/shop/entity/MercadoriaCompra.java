package sys.shop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa a entidade relacionada a compra de mercadoria.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "mec_mercadoria_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MercadoriaCompra.findAll", query = "SELECT m FROM MercadoriaCompra m"),
    @NamedQuery(name = "MercadoriaCompra.findByMecId", query = "SELECT m FROM MercadoriaCompra m WHERE m.mercadoriaCompraPK.mecId = :mecId"),
    @NamedQuery(name = "MercadoriaCompra.findByComId", query = "SELECT m FROM MercadoriaCompra m WHERE m.mercadoriaCompraPK.comId = :comId"),
    @NamedQuery(name = "MercadoriaCompra.findByMerId", query = "SELECT m FROM MercadoriaCompra m WHERE m.merId = :merId"),
    @NamedQuery(name = "MercadoriaCompra.findByMecStatus", query = "SELECT m FROM MercadoriaCompra m WHERE m.mecStatus = :mecStatus")})
public class MercadoriaCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MercadoriaCompraPK mercadoriaCompraPK;
    @Basic(optional = false)
    @Column(name = "mer_id")
    private int merId;
    @Column(name = "mec_status")
    private Character mecStatus;

    public MercadoriaCompra() {
    }

    public MercadoriaCompra(MercadoriaCompraPK mercadoriaCompraPK) {
        this.mercadoriaCompraPK = mercadoriaCompraPK;
    }

    public MercadoriaCompra(MercadoriaCompraPK mercadoriaCompraPK, int merId) {
        this.mercadoriaCompraPK = mercadoriaCompraPK;
        this.merId = merId;
    }

    public MercadoriaCompra(int mecId, int comId) {
        this.mercadoriaCompraPK = new MercadoriaCompraPK(mecId, comId);
    }

    public MercadoriaCompraPK getMercadoriaCompraPK() {
        return mercadoriaCompraPK;
    }

    public void setMercadoriaCompraPK(MercadoriaCompraPK mercadoriaCompraPK) {
        this.mercadoriaCompraPK = mercadoriaCompraPK;
    }

    public int getMerId() {
        return merId;
    }

    public void setMerId(int merId) {
        this.merId = merId;
    }

    public Character getMecStatus() {
        return mecStatus;
    }

    public void setMecStatus(Character mecStatus) {
        this.mecStatus = mecStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mercadoriaCompraPK != null ? mercadoriaCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MercadoriaCompra)) {
            return false;
        }
        MercadoriaCompra other = (MercadoriaCompra) object;
        if ((this.mercadoriaCompraPK == null && other.mercadoriaCompraPK != null) || (this.mercadoriaCompraPK != null && !this.mercadoriaCompraPK.equals(other.mercadoriaCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.MercadoriaCompra[ mercadoriaCompraPK=" + mercadoriaCompraPK + " ]";
    }
    
}
