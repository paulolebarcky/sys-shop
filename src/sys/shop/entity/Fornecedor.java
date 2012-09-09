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
 * Representa a entidade relacionada ao fornecedor.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "for_fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByForId", query = "SELECT f FROM Fornecedor f WHERE f.forId = :forId"),
    @NamedQuery(name = "Fornecedor.findByCidId", query = "SELECT f FROM Fornecedor f WHERE f.cidId = :cidId"),
    @NamedQuery(name = "Fornecedor.findByForNome", query = "SELECT f FROM Fornecedor f WHERE f.forNome = :forNome"),
    @NamedQuery(name = "Fornecedor.findByForCnpj", query = "SELECT f FROM Fornecedor f WHERE f.forCnpj = :forCnpj"),
    @NamedQuery(name = "Fornecedor.findByForEndereco", query = "SELECT f FROM Fornecedor f WHERE f.forEndereco = :forEndereco"),
    @NamedQuery(name = "Fornecedor.findByForTelefone", query = "SELECT f FROM Fornecedor f WHERE f.forTelefone = :forTelefone"),
    @NamedQuery(name = "Fornecedor.findByForCelular", query = "SELECT f FROM Fornecedor f WHERE f.forCelular = :forCelular"),
    @NamedQuery(name = "Fornecedor.findByForContato", query = "SELECT f FROM Fornecedor f WHERE f.forContato = :forContato"),
    @NamedQuery(name = "Fornecedor.findByForDescricao", query = "SELECT f FROM Fornecedor f WHERE f.forDescricao = :forDescricao"),
    @NamedQuery(name = "Fornecedor.findByForDtcadastro", query = "SELECT f FROM Fornecedor f WHERE f.forDtcadastro = :forDtcadastro"),
    @NamedQuery(name = "Fornecedor.findByForStatus", query = "SELECT f FROM Fornecedor f WHERE f.forStatus = :forStatus")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "for_id")
    private Integer forId;
    @Basic(optional = false)
    @Column(name = "cid_id")
    private int cidId;
    @Column(name = "for_nome")
    private String forNome;
    @Column(name = "for_cnpj")
    private String forCnpj;
    @Column(name = "for_endereco")
    private String forEndereco;
    @Column(name = "for_telefone")
    private String forTelefone;
    @Column(name = "for_celular")
    private String forCelular;
    @Column(name = "for_contato")
    private String forContato;
    @Column(name = "for_descricao")
    private String forDescricao;
    @Column(name = "for_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date forDtcadastro;
    @Column(name = "for_status")
    private Character forStatus;

    public Fornecedor() {
    }

    public Fornecedor(Integer forId) {
        this.forId = forId;
    }

    public Fornecedor(Integer forId, int cidId) {
        this.forId = forId;
        this.cidId = cidId;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
    }

    public int getCidId() {
        return cidId;
    }

    public void setCidId(int cidId) {
        this.cidId = cidId;
    }

    public String getForNome() {
        return forNome;
    }

    public void setForNome(String forNome) {
        this.forNome = forNome;
    }

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
    }

    public String getForEndereco() {
        return forEndereco;
    }

    public void setForEndereco(String forEndereco) {
        this.forEndereco = forEndereco;
    }

    public String getForTelefone() {
        return forTelefone;
    }

    public void setForTelefone(String forTelefone) {
        this.forTelefone = forTelefone;
    }

    public String getForCelular() {
        return forCelular;
    }

    public void setForCelular(String forCelular) {
        this.forCelular = forCelular;
    }

    public String getForContato() {
        return forContato;
    }

    public void setForContato(String forContato) {
        this.forContato = forContato;
    }

    public String getForDescricao() {
        return forDescricao;
    }

    public void setForDescricao(String forDescricao) {
        this.forDescricao = forDescricao;
    }

    public Date getForDtcadastro() {
        return forDtcadastro;
    }

    public void setForDtcadastro(Date forDtcadastro) {
        this.forDtcadastro = forDtcadastro;
    }

    public Character getForStatus() {
        return forStatus;
    }

    public void setForStatus(Character forStatus) {
        this.forStatus = forStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forId != null ? forId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.forId == null && other.forId != null) || (this.forId != null && !this.forId.equals(other.forId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.Fornecedor[ forId=" + forId + " ]";
    }
    
}
