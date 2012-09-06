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
@Table(name = "tiv_tipo_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TivTipoVenda.findAll", query = "SELECT t FROM TivTipoVenda t"),
    @NamedQuery(name = "TivTipoVenda.findByTivId", query = "SELECT t FROM TivTipoVenda t WHERE t.tivId = :tivId"),
    @NamedQuery(name = "TivTipoVenda.findByTivNome", query = "SELECT t FROM TivTipoVenda t WHERE t.tivNome = :tivNome"),
    @NamedQuery(name = "TivTipoVenda.findByTivDtcadastro", query = "SELECT t FROM TivTipoVenda t WHERE t.tivDtcadastro = :tivDtcadastro"),
    @NamedQuery(name = "TivTipoVenda.findByTivStatus", query = "SELECT t FROM TivTipoVenda t WHERE t.tivStatus = :tivStatus"),
    @NamedQuery(name = "TivTipoVenda.findByTivDescricao", query = "SELECT t FROM TivTipoVenda t WHERE t.tivDescricao = :tivDescricao")})
public class TivTipoVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tiv_id")
    private Integer tivId;
    @Column(name = "tiv_nome")
    private String tivNome;
    @Column(name = "tiv_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date tivDtcadastro;
    @Column(name = "tiv_status")
    private Character tivStatus;
    @Column(name = "tiv_descricao")
    private String tivDescricao;

    public TivTipoVenda() {
    }

    public TivTipoVenda(Integer tivId) {
        this.tivId = tivId;
    }

    public Integer getTivId() {
        return tivId;
    }

    public void setTivId(Integer tivId) {
        this.tivId = tivId;
    }

    public String getTivNome() {
        return tivNome;
    }

    public void setTivNome(String tivNome) {
        this.tivNome = tivNome;
    }

    public Date getTivDtcadastro() {
        return tivDtcadastro;
    }

    public void setTivDtcadastro(Date tivDtcadastro) {
        this.tivDtcadastro = tivDtcadastro;
    }

    public Character getTivStatus() {
        return tivStatus;
    }

    public void setTivStatus(Character tivStatus) {
        this.tivStatus = tivStatus;
    }

    public String getTivDescricao() {
        return tivDescricao;
    }

    public void setTivDescricao(String tivDescricao) {
        this.tivDescricao = tivDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tivId != null ? tivId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TivTipoVenda)) {
            return false;
        }
        TivTipoVenda other = (TivTipoVenda) object;
        if ((this.tivId == null && other.tivId != null) || (this.tivId != null && !this.tivId.equals(other.tivId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.TivTipoVenda[ tivId=" + tivId + " ]";
    }
    
}
