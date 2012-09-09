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
 * Representa a entidade relacionada a venda.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "ven_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByVenId", query = "SELECT v FROM Venda v WHERE v.venId = :venId"),
    @NamedQuery(name = "Venda.findByCliId", query = "SELECT v FROM Venda v WHERE v.cliId = :cliId"),
    @NamedQuery(name = "Venda.findByVedId", query = "SELECT v FROM Venda v WHERE v.vedId = :vedId"),
    @NamedQuery(name = "Venda.findByTivId", query = "SELECT v FROM Venda v WHERE v.tivId = :tivId"),
    @NamedQuery(name = "Venda.findByFopId", query = "SELECT v FROM Venda v WHERE v.fopId = :fopId"),
    @NamedQuery(name = "Venda.findByVenValor", query = "SELECT v FROM Venda v WHERE v.venValor = :venValor"),
    @NamedQuery(name = "Venda.findByVenStatus", query = "SELECT v FROM Venda v WHERE v.venStatus = :venStatus"),
    @NamedQuery(name = "Venda.findByVenData", query = "SELECT v FROM Venda v WHERE v.venData = :venData"),
    @NamedQuery(name = "Venda.findByVenDescricao", query = "SELECT v FROM Venda v WHERE v.venDescricao = :venDescricao")})
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ven_id")
    private Integer venId;
    @Basic(optional = false)
    @Column(name = "cli_id")
    private int cliId;
    @Basic(optional = false)
    @Column(name = "ved_id")
    private int vedId;
    @Basic(optional = false)
    @Column(name = "tiv_id")
    private int tivId;
    @Basic(optional = false)
    @Column(name = "fop_id")
    private int fopId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ven_valor")
    private Double venValor;
    @Column(name = "ven_status")
    private Character venStatus;
    @Column(name = "ven_data")
    @Temporal(TemporalType.DATE)
    private Date venData;
    @Column(name = "ven_descricao")
    private String venDescricao;

    public Venda() {
    }

    public Venda(Integer venId) {
        this.venId = venId;
    }

    public Venda(Integer venId, int cliId, int vedId, int tivId, int fopId) {
        this.venId = venId;
        this.cliId = cliId;
        this.vedId = vedId;
        this.tivId = tivId;
        this.fopId = fopId;
    }

    public Integer getVenId() {
        return venId;
    }

    public void setVenId(Integer venId) {
        this.venId = venId;
    }

    public int getCliId() {
        return cliId;
    }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    public int getVedId() {
        return vedId;
    }

    public void setVedId(int vedId) {
        this.vedId = vedId;
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

    public Double getVenValor() {
        return venValor;
    }

    public void setVenValor(Double venValor) {
        this.venValor = venValor;
    }

    public Character getVenStatus() {
        return venStatus;
    }

    public void setVenStatus(Character venStatus) {
        this.venStatus = venStatus;
    }

    public Date getVenData() {
        return venData;
    }

    public void setVenData(Date venData) {
        this.venData = venData;
    }

    public String getVenDescricao() {
        return venDescricao;
    }

    public void setVenDescricao(String venDescricao) {
        this.venDescricao = venDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venId != null ? venId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.venId == null && other.venId != null) || (this.venId != null && !this.venId.equals(other.venId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.Venda[ venId=" + venId + " ]";
    }
    
}
