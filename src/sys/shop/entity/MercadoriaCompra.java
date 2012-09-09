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
    @NamedQuery(name = "MecMercadoriaCompra.findAll", query = "SELECT m FROM MecMercadoriaCompra m"),
    @NamedQuery(name = "MecMercadoriaCompra.findByMecId", query = "SELECT m FROM MecMercadoriaCompra m WHERE m.mecMercadoriaCompraPK.mecId = :mecId"),
    @NamedQuery(name = "MecMercadoriaCompra.findByComId", query = "SELECT m FROM MecMercadoriaCompra m WHERE m.mecMercadoriaCompraPK.comId = :comId"),
    @NamedQuery(name = "MecMercadoriaCompra.findByMerId", query = "SELECT m FROM MecMercadoriaCompra m WHERE m.merId = :merId"),
    @NamedQuery(name = "MecMercadoriaCompra.findByMecStatus", query = "SELECT m FROM MecMercadoriaCompra m WHERE m.mecStatus = :mecStatus")})
public class MercadoriaCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MercadoriaCompraPK mecMercadoriaCompraPK;
    @Basic(optional = false)
    @Column(name = "mer_id")
    private int merId;
    @Column(name = "mec_status")
    private Character mecStatus;

    public MercadoriaCompra() {
    }

    public MercadoriaCompra(MercadoriaCompraPK mecMercadoriaCompraPK) {
        this.mecMercadoriaCompraPK = mecMercadoriaCompraPK;
    }

    public MercadoriaCompra(MercadoriaCompraPK mecMercadoriaCompraPK, int merId) {
        this.mecMercadoriaCompraPK = mecMercadoriaCompraPK;
        this.merId = merId;
    }

    public MercadoriaCompra(int mecId, int comId) {
        this.mecMercadoriaCompraPK = new MercadoriaCompraPK(mecId, comId);
    }

    public MercadoriaCompraPK getMecMercadoriaCompraPK() {
        return mecMercadoriaCompraPK;
    }

    public void setMecMercadoriaCompraPK(MercadoriaCompraPK mecMercadoriaCompraPK) {
        this.mecMercadoriaCompraPK = mecMercadoriaCompraPK;
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
        hash += (mecMercadoriaCompraPK != null ? mecMercadoriaCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MercadoriaCompra)) {
            return false;
        }
        MercadoriaCompra other = (MercadoriaCompra) object;
        if ((this.mecMercadoriaCompraPK == null && other.mecMercadoriaCompraPK != null) || (this.mecMercadoriaCompraPK != null && !this.mecMercadoriaCompraPK.equals(other.mecMercadoriaCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.MecMercadoriaCompra[ mecMercadoriaCompraPK=" + mecMercadoriaCompraPK + " ]";
    }
    
}
