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
 * Representa a entidade relacionada ao vendedor.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "ved_vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByVedId", query = "SELECT v FROM Vendedor v WHERE v.vedId = :vedId"),
    @NamedQuery(name = "Vendedor.findByCidId", query = "SELECT v FROM Vendedor v WHERE v.cidId = :cidId"),
    @NamedQuery(name = "Vendedor.findByLojId", query = "SELECT v FROM Vendedor v WHERE v.lojId = :lojId"),
    @NamedQuery(name = "Vendedor.findByVedNome", query = "SELECT v FROM Vendedor v WHERE v.vedNome = :vedNome"),
    @NamedQuery(name = "Vendedor.findByVedTelefone", query = "SELECT v FROM Vendedor v WHERE v.vedTelefone = :vedTelefone"),
    @NamedQuery(name = "Vendedor.findByVedCelular", query = "SELECT v FROM Vendedor v WHERE v.vedCelular = :vedCelular"),
    @NamedQuery(name = "Vendedor.findByVedCpf", query = "SELECT v FROM Vendedor v WHERE v.vedCpf = :vedCpf"),
    @NamedQuery(name = "Vendedor.findByVedEndereco", query = "SELECT v FROM Vendedor v WHERE v.vedEndereco = :vedEndereco"),
    @NamedQuery(name = "Vendedor.findByVedDtnascimento", query = "SELECT v FROM Vendedor v WHERE v.vedDtnascimento = :vedDtnascimento"),
    @NamedQuery(name = "Vendedor.findByVedDtcadastro", query = "SELECT v FROM Vendedor v WHERE v.vedDtcadastro = :vedDtcadastro"),
    @NamedQuery(name = "Vendedor.findByVedStatus", query = "SELECT v FROM Vendedor v WHERE v.vedStatus = :vedStatus")})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ved_id")
    private Integer vedId;
    @Basic(optional = false)
    @Column(name = "cid_id")
    private int cidId;
    @Basic(optional = false)
    @Column(name = "loj_id")
    private int lojId;
    @Column(name = "ved_nome")
    private String vedNome;
    @Column(name = "ved_telefone")
    private String vedTelefone;
    @Column(name = "ved_celular")
    private String vedCelular;
    @Column(name = "ved_cpf")
    private String vedCpf;
    @Column(name = "ved_endereco")
    private String vedEndereco;
    @Column(name = "ved_dtnascimento")
    @Temporal(TemporalType.DATE)
    private Date vedDtnascimento;
    @Column(name = "ved_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date vedDtcadastro;
    @Column(name = "ved_status")
    private Character vedStatus;

    public Vendedor() {
    }

    public Vendedor(Integer vedId) {
        this.vedId = vedId;
    }

    public Vendedor(Integer vedId, int cidId, int lojId) {
        this.vedId = vedId;
        this.cidId = cidId;
        this.lojId = lojId;
    }

    public Integer getVedId() {
        return vedId;
    }

    public void setVedId(Integer vedId) {
        this.vedId = vedId;
    }

    public int getCidId() {
        return cidId;
    }

    public void setCidId(int cidId) {
        this.cidId = cidId;
    }

    public int getLojId() {
        return lojId;
    }

    public void setLojId(int lojId) {
        this.lojId = lojId;
    }

    public String getVedNome() {
        return vedNome;
    }

    public void setVedNome(String vedNome) {
        this.vedNome = vedNome;
    }

    public String getVedTelefone() {
        return vedTelefone;
    }

    public void setVedTelefone(String vedTelefone) {
        this.vedTelefone = vedTelefone;
    }

    public String getVedCelular() {
        return vedCelular;
    }

    public void setVedCelular(String vedCelular) {
        this.vedCelular = vedCelular;
    }

    public String getVedCpf() {
        return vedCpf;
    }

    public void setVedCpf(String vedCpf) {
        this.vedCpf = vedCpf;
    }

    public String getVedEndereco() {
        return vedEndereco;
    }

    public void setVedEndereco(String vedEndereco) {
        this.vedEndereco = vedEndereco;
    }

    public Date getVedDtnascimento() {
        return vedDtnascimento;
    }

    public void setVedDtnascimento(Date vedDtnascimento) {
        this.vedDtnascimento = vedDtnascimento;
    }

    public Date getVedDtcadastro() {
        return vedDtcadastro;
    }

    public void setVedDtcadastro(Date vedDtcadastro) {
        this.vedDtcadastro = vedDtcadastro;
    }

    public Character getVedStatus() {
        return vedStatus;
    }

    public void setVedStatus(Character vedStatus) {
        this.vedStatus = vedStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vedId != null ? vedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.vedId == null && other.vedId != null) || (this.vedId != null && !this.vedId.equals(other.vedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.Vendedor[ vedId=" + vedId + " ]";
    }
    
}
