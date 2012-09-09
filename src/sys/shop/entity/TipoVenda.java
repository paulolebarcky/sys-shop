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
 * Representa a entidade relacionada ao tipo de venda.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "tiv_tipo_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVenda.findAll", query = "SELECT t FROM TipoVenda t"),
    @NamedQuery(name = "TipoVenda.findByTivId", query = "SELECT t FROM TipoVenda t WHERE t.tivId = :tivId"),
    @NamedQuery(name = "TipoVenda.findByTivNome", query = "SELECT t FROM TipoVenda t WHERE t.tivNome = :tivNome"),
    @NamedQuery(name = "TipoVenda.findByTivDtcadastro", query = "SELECT t FROM TipoVenda t WHERE t.tivDtcadastro = :tivDtcadastro"),
    @NamedQuery(name = "TipoVenda.findByTivStatus", query = "SELECT t FROM TipoVenda t WHERE t.tivStatus = :tivStatus"),
    @NamedQuery(name = "TipoVenda.findByTivDescricao", query = "SELECT t FROM TipoVenda t WHERE t.tivDescricao = :tivDescricao")})
public class TipoVenda implements Serializable {
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

    public TipoVenda() {
    }

    public TipoVenda(Integer tivId) {
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
        if (!(object instanceof TipoVenda)) {
            return false;
        }
        TipoVenda other = (TipoVenda) object;
        if ((this.tivId == null && other.tivId != null) || (this.tivId != null && !this.tivId.equals(other.tivId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.TipoVenda[ tivId=" + tivId + " ]";
    }
    
}
