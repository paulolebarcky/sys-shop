/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "est_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstEstado.findAll", query = "SELECT e FROM EstEstado e"),
    @NamedQuery(name = "EstEstado.findByEstId", query = "SELECT e FROM EstEstado e WHERE e.estId = :estId"),
    @NamedQuery(name = "EstEstado.findByEstNome", query = "SELECT e FROM EstEstado e WHERE e.estNome = :estNome"),
    @NamedQuery(name = "EstEstado.findByEstSigla", query = "SELECT e FROM EstEstado e WHERE e.estSigla = :estSigla")})
public class EstEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "est_id")
    private Integer estId;
    @Column(name = "est_nome")
    private String estNome;
    @Column(name = "est_sigla")
    private String estSigla;

    public EstEstado() {
    }

    public EstEstado(Integer estId) {
        this.estId = estId;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstNome() {
        return estNome;
    }

    public void setEstNome(String estNome) {
        this.estNome = estNome;
    }

    public String getEstSigla() {
        return estSigla;
    }

    public void setEstSigla(String estSigla) {
        this.estSigla = estSigla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstEstado)) {
            return false;
        }
        EstEstado other = (EstEstado) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.EstEstado[ estId=" + estId + " ]";
    }
    
}
