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
 * Representa a entidade relacionada a mercadoria.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "mer_mercadoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mercadoria.findAll", query = "SELECT m FROM Mercadoria m"),
    @NamedQuery(name = "Mercadoria.findByMerId", query = "SELECT m FROM Mercadoria m WHERE m.merId = :merId"),
    @NamedQuery(name = "Mercadoria.findByTimId", query = "SELECT m FROM Mercadoria m WHERE m.timId = :timId"),
    @NamedQuery(name = "Mercadoria.findByMerNome", query = "SELECT m FROM Mercadoria m WHERE m.merNome = :merNome"),
    @NamedQuery(name = "Mercadoria.findByMerDtcadastro", query = "SELECT m FROM Mercadoria m WHERE m.merDtcadastro = :merDtcadastro"),
    @NamedQuery(name = "Mercadoria.findByMerValor", query = "SELECT m FROM Mercadoria m WHERE m.merValor = :merValor"),
    @NamedQuery(name = "Mercadoria.findByMerQuantidade", query = "SELECT m FROM Mercadoria m WHERE m.merQuantidade = :merQuantidade")})
public class Mercadoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mer_id")
    private Integer merId;
    @Basic(optional = false)
    @Column(name = "tim_id")
    private int timId;
    @Column(name = "mer_nome")
    private String merNome;
    @Column(name = "mer_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date merDtcadastro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mer_valor")
    private Double merValor;
    @Column(name = "mer_quantidade")
    private Integer merQuantidade;

    public Mercadoria() {
    }

    public Mercadoria(Integer merId) {
        this.merId = merId;
    }

    public Mercadoria(Integer merId, int timId) {
        this.merId = merId;
        this.timId = timId;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public int getTimId() {
        return timId;
    }

    public void setTimId(int timId) {
        this.timId = timId;
    }

    public String getMerNome() {
        return merNome;
    }

    public void setMerNome(String merNome) {
        this.merNome = merNome;
    }

    public Date getMerDtcadastro() {
        return merDtcadastro;
    }

    public void setMerDtcadastro(Date merDtcadastro) {
        this.merDtcadastro = merDtcadastro;
    }

    public Double getMerValor() {
        return merValor;
    }

    public void setMerValor(Double merValor) {
        this.merValor = merValor;
    }

    public Integer getMerQuantidade() {
        return merQuantidade;
    }

    public void setMerQuantidade(Integer merQuantidade) {
        this.merQuantidade = merQuantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merId != null ? merId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mercadoria)) {
            return false;
        }
        Mercadoria other = (Mercadoria) object;
        if ((this.merId == null && other.merId != null) || (this.merId != null && !this.merId.equals(other.merId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.Mercadoria[ merId=" + merId + " ]";
    }
    
}
