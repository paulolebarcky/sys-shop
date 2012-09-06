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
@Table(name = "ven_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VenVenda.findAll", query = "SELECT v FROM VenVenda v"),
    @NamedQuery(name = "VenVenda.findByVenId", query = "SELECT v FROM VenVenda v WHERE v.venId = :venId"),
    @NamedQuery(name = "VenVenda.findByCliId", query = "SELECT v FROM VenVenda v WHERE v.cliId = :cliId"),
    @NamedQuery(name = "VenVenda.findByVedId", query = "SELECT v FROM VenVenda v WHERE v.vedId = :vedId"),
    @NamedQuery(name = "VenVenda.findByTivId", query = "SELECT v FROM VenVenda v WHERE v.tivId = :tivId"),
    @NamedQuery(name = "VenVenda.findByFopId", query = "SELECT v FROM VenVenda v WHERE v.fopId = :fopId"),
    @NamedQuery(name = "VenVenda.findByVenValor", query = "SELECT v FROM VenVenda v WHERE v.venValor = :venValor"),
    @NamedQuery(name = "VenVenda.findByVenStatus", query = "SELECT v FROM VenVenda v WHERE v.venStatus = :venStatus"),
    @NamedQuery(name = "VenVenda.findByVenData", query = "SELECT v FROM VenVenda v WHERE v.venData = :venData"),
    @NamedQuery(name = "VenVenda.findByVenDescricao", query = "SELECT v FROM VenVenda v WHERE v.venDescricao = :venDescricao")})
public class VenVenda implements Serializable {
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

    public VenVenda() {
    }

    public VenVenda(Integer venId) {
        this.venId = venId;
    }

    public VenVenda(Integer venId, int cliId, int vedId, int tivId, int fopId) {
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
        if (!(object instanceof VenVenda)) {
            return false;
        }
        VenVenda other = (VenVenda) object;
        if ((this.venId == null && other.venId != null) || (this.venId != null && !this.venId.equals(other.venId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.VenVenda[ venId=" + venId + " ]";
    }
    
}
