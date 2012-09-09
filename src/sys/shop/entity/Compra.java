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
 * Representa a entidade relacionada a compra.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "com_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByComId", query = "SELECT c FROM Compra c WHERE c.comId = :comId"),
    @NamedQuery(name = "Compra.findByForId", query = "SELECT c FROM Compra c WHERE c.forId = :forId"),
    @NamedQuery(name = "Compra.findByTivId", query = "SELECT c FROM Compra c WHERE c.tivId = :tivId"),
    @NamedQuery(name = "Compra.findByFopId", query = "SELECT c FROM Compra c WHERE c.fopId = :fopId"),
    @NamedQuery(name = "Compra.findByComValor", query = "SELECT c FROM Compra c WHERE c.comValor = :comValor"),
    @NamedQuery(name = "Compra.findByComData", query = "SELECT c FROM Compra c WHERE c.comData = :comData"),
    @NamedQuery(name = "Compra.findByComDescricao", query = "SELECT c FROM Compra c WHERE c.comDescricao = :comDescricao")})
public class Compra implements Serializable {
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

    public Compra() {
    }

    public Compra(Integer comId) {
        this.comId = comId;
    }

    public Compra(Integer comId, int forId, int tivId, int fopId) {
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
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.Compra[ comId=" + comId + " ]";
    }
    
}
