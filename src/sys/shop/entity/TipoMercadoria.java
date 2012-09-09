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
 * Representa a entidade relacionada ao tipo de mercadoria.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "tim_tipo_mercadoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMercadoria.findAll", query = "SELECT t FROM TipoMercadoria t"),
    @NamedQuery(name = "TipoMercadoria.findByTimId", query = "SELECT t FROM TipoMercadoria t WHERE t.timId = :timId"),
    @NamedQuery(name = "TipoMercadoria.findByTimNome", query = "SELECT t FROM TipoMercadoria t WHERE t.timNome = :timNome"),
    @NamedQuery(name = "TipoMercadoria.findByTimSigla", query = "SELECT t FROM TipoMercadoria t WHERE t.timSigla = :timSigla"),
    @NamedQuery(name = "TipoMercadoria.findByTimDtcadastro", query = "SELECT t FROM TipoMercadoria t WHERE t.timDtcadastro = :timDtcadastro"),
    @NamedQuery(name = "TipoMercadoria.findByTimDescricao", query = "SELECT t FROM TipoMercadoria t WHERE t.timDescricao = :timDescricao"),
    @NamedQuery(name = "TipoMercadoria.findByTimStatus", query = "SELECT t FROM TipoMercadoria t WHERE t.timStatus = :timStatus")})
public class TipoMercadoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tim_id")
    private Integer timId;
    @Column(name = "tim_nome")
    private String timNome;
    @Column(name = "tim_sigla")
    private String timSigla;
    @Column(name = "tim_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date timDtcadastro;
    @Column(name = "tim_descricao")
    private String timDescricao;
    @Column(name = "tim_status")
    private Character timStatus;

    public TipoMercadoria() {
    }

    public TipoMercadoria(Integer timId) {
        this.timId = timId;
    }

    public Integer getTimId() {
        return timId;
    }

    public void setTimId(Integer timId) {
        this.timId = timId;
    }

    public String getTimNome() {
        return timNome;
    }

    public void setTimNome(String timNome) {
        this.timNome = timNome;
    }

    public String getTimSigla() {
        return timSigla;
    }

    public void setTimSigla(String timSigla) {
        this.timSigla = timSigla;
    }

    public Date getTimDtcadastro() {
        return timDtcadastro;
    }

    public void setTimDtcadastro(Date timDtcadastro) {
        this.timDtcadastro = timDtcadastro;
    }

    public String getTimDescricao() {
        return timDescricao;
    }

    public void setTimDescricao(String timDescricao) {
        this.timDescricao = timDescricao;
    }

    public Character getTimStatus() {
        return timStatus;
    }

    public void setTimStatus(Character timStatus) {
        this.timStatus = timStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timId != null ? timId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMercadoria)) {
            return false;
        }
        TipoMercadoria other = (TipoMercadoria) object;
        if ((this.timId == null && other.timId != null) || (this.timId != null && !this.timId.equals(other.timId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.TipoMercadoria[ timId=" + timId + " ]";
    }
    
}
