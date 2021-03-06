package sys.shop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa a entidade relacionada a cidade.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "cid_cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByCidId", query = "SELECT c FROM Cidade c WHERE c.cidId = :cidId"),
    @NamedQuery(name = "Cidade.findByEstId", query = "SELECT c FROM Cidade c WHERE c.estId = :estId"),
    @NamedQuery(name = "Cidade.findByCidNome", query = "SELECT c FROM Cidade c WHERE c.cidNome = :cidNome")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "cidade", sequenceName = "s_cidade", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade" )
    @Basic(optional = false)
    @Column(name = "cid_id")
    private Integer cidId;
    
    @Basic(optional = false)
    @Column(name = "est_id")
    private int estId;
    
    @Column(name = "cid_nome")
    private String cidNome;

    public Cidade() {
    }

    public Cidade(Integer cidId) {
        this.cidId = cidId;
    }

    public Cidade(Integer cidId, int estId) {
        this.cidId = cidId;
        this.estId = estId;
    }

    public Integer getCidId() {
        return cidId;
    }

    public void setCidId(Integer cidId) {
        this.cidId = cidId;
    }

    public int getEstId() {
        return estId;
    }

    public void setEstId(int estId) {
        this.estId = estId;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidId != null ? cidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidId == null && other.cidId != null) || (this.cidId != null && !this.cidId.equals(other.cidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.Cidade[ cidId=" + cidId + " ]";
    }
    
}
