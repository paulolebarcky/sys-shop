/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "com_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComCompra.findAll", query = "SELECT c FROM ComCompra c"),
    @NamedQuery(name = "ComCompra.findByComId", query = "SELECT c FROM ComCompra c WHERE c.comId = :comId"),
    @NamedQuery(name = "ComCompra.findByForId", query = "SELECT c FROM ComCompra c WHERE c.forId = :forId"),
    @NamedQuery(name = "ComCompra.findByTivId", query = "SELECT c FROM ComCompra c WHERE c.tivId = :tivId"),
    @NamedQuery(name = "ComCompra.findByFopId", query = "SELECT c FROM ComCompra c WHERE c.fopId = :fopId"),
    @NamedQuery(name = "ComCompra.findByComValor", query = "SELECT c FROM ComCompra c WHERE c.comValor = :comValor"),
    @NamedQuery(name = "ComCompra.findByComData", query = "SELECT c FROM ComCompra c WHERE c.comData = :comData"),
    @NamedQuery(name = "ComCompra.findByComDescricao", query = "SELECT c FROM ComCompra c WHERE c.comDescricao = :comDescricao")})
public class ComCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "com_id")
    private Integer comId;
    @Basic(optional = false)
    @Column(name = "for_id")
    private int forId;
    @Basic(optional = false)
    @Column(name = "tiv_id")
    private int tivId;
    @Basic(optional = false)
    @Column(name = "fop_id")
    private int fopId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "com_valor")
    private Double comValor;
    @Column(name = "com_data")
    @Temporal(TemporalType.DATE)
    private Date comData;
    @Column(name = "com_descricao")
    private String comDescricao;

    public ComCompra() {
    }

    public ComCompra(Integer comId) {
        this.comId = comId;
    }

    public ComCompra(Integer comId, int forId, int tivId, int fopId) {
        this.comId = comId;
        this.forId = forId;
        this.tivId = tivId;
        this.fopId = fopId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public int getForId() {
        return forId;
    }

    public void setForId(int forId) {
        this.forId = forId;
    }

    public int getTivId() {
        return tivId;
    }

    public void setTivId(int tivId) {
        this.tivId = tivId;
    }

    public int getFopId() {
        return fopId;
    }

    public void setFopId(int fopId) {
        this.fopId = fopId;
    }

    public Double getComValor() {
        return comValor;
    }

    public void setComValor(Double comValor) {
        this.comValor = comValor;
    }

    public Date getComData() {
        return comData;
    }

    public void setComData(Date comData) {
        this.comData = comData;
    }

    public String getComDescricao() {
        return comDescricao;
    }

    public void setComDescricao(String comDescricao) {
        this.comDescricao = comDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComCompra)) {
            return false;
        }
        ComCompra other = (ComCompra) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.ComCompra[ comId=" + comId + " ]";
    }
    
}
