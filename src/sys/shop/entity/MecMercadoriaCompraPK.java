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
public class MecMercadoriaCompraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "mec_id")
    private int mecId;
    @Basic(optional = false)
    @Column(name = "com_id")
    private int comId;

    public MecMercadoriaCompraPK() {
    }

    public MecMercadoriaCompraPK(int mecId, int comId) {
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
        if (!(object instanceof MecMercadoriaCompraPK)) {
            return false;
        }
        MecMercadoriaCompraPK other = (MecMercadoriaCompraPK) object;
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
