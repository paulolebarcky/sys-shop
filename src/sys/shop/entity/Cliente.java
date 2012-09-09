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
 * Representa a entidade relacionada a cliente.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "cli_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCliId", query = "SELECT c FROM Cliente c WHERE c.cliId = :cliId"),
    @NamedQuery(name = "Cliente.findByCidId", query = "SELECT c FROM Cliente c WHERE c.cidId = :cidId"),
    @NamedQuery(name = "Cliente.findByLojId", query = "SELECT c FROM Cliente c WHERE c.lojId = :lojId"),
    @NamedQuery(name = "Cliente.findByCliNome", query = "SELECT c FROM Cliente c WHERE c.cliNome = :cliNome"),
    @NamedQuery(name = "Cliente.findByCliRg", query = "SELECT c FROM Cliente c WHERE c.cliRg = :cliRg"),
    @NamedQuery(name = "Cliente.findByCliTelefone", query = "SELECT c FROM Cliente c WHERE c.cliTelefone = :cliTelefone"),
    @NamedQuery(name = "Cliente.findByCliCelular", query = "SELECT c FROM Cliente c WHERE c.cliCelular = :cliCelular"),
    @NamedQuery(name = "Cliente.findByCliEndereco", query = "SELECT c FROM Cliente c WHERE c.cliEndereco = :cliEndereco"),
    @NamedQuery(name = "Cliente.findByCliCpf", query = "SELECT c FROM Cliente c WHERE c.cliCpf = :cliCpf"),
    @NamedQuery(name = "Cliente.findByCliCnpj", query = "SELECT c FROM Cliente c WHERE c.cliCnpj = :cliCnpj"),
    @NamedQuery(name = "Cliente.findByCliDescricao", query = "SELECT c FROM Cliente c WHERE c.cliDescricao = :cliDescricao"),
    @NamedQuery(name = "Cliente.findByCliDtcadastro", query = "SELECT c FROM Cliente c WHERE c.cliDtcadastro = :cliDtcadastro"),
    @NamedQuery(name = "Cliente.findByCliStatus", query = "SELECT c FROM Cliente c WHERE c.cliStatus = :cliStatus"),
    @NamedQuery(name = "Cliente.findByCliDtnascimento", query = "SELECT c FROM Cliente c WHERE c.cliDtnascimento = :cliDtnascimento")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cli_id")
    private Integer cliId;
    @Basic(optional = false)
    @Column(name = "cid_id")
    private int cidId;
    @Basic(optional = false)
    @Column(name = "loj_id")
    private int lojId;
    @Column(name = "cli_nome")
    private String cliNome;
    @Column(name = "cli_rg")
    private String cliRg;
    @Column(name = "cli_telefone")
    private String cliTelefone;
    @Column(name = "cli_celular")
    private String cliCelular;
    @Column(name = "cli_endereco")
    private String cliEndereco;
    @Column(name = "cli_cpf")
    private String cliCpf;
    @Column(name = "cli_cnpj")
    private String cliCnpj;
    @Column(name = "cli_descricao")
    private String cliDescricao;
    @Column(name = "cli_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date cliDtcadastro;
    @Column(name = "cli_status")
    private Character cliStatus;
    @Column(name = "cli_dtnascimento")
    @Temporal(TemporalType.DATE)
    private Date cliDtnascimento;

    public Cliente() {
    }

    public Cliente(Integer cliId) {
        this.cliId = cliId;
    }

    public Cliente(Integer cliId, int cidId, int lojId) {
        this.cliId = cliId;
        this.cidId = cidId;
        this.lojId = lojId;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
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

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliRg() {
        return cliRg;
    }

    public void setCliRg(String cliRg) {
        this.cliRg = cliRg;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliEndereco() {
        return cliEndereco;
    }

    public void setCliEndereco(String cliEndereco) {
        this.cliEndereco = cliEndereco;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliCnpj() {
        return cliCnpj;
    }

    public void setCliCnpj(String cliCnpj) {
        this.cliCnpj = cliCnpj;
    }

    public String getCliDescricao() {
        return cliDescricao;
    }

    public void setCliDescricao(String cliDescricao) {
        this.cliDescricao = cliDescricao;
    }

    public Date getCliDtcadastro() {
        return cliDtcadastro;
    }

    public void setCliDtcadastro(Date cliDtcadastro) {
        this.cliDtcadastro = cliDtcadastro;
    }

    public Character getCliStatus() {
        return cliStatus;
    }

    public void setCliStatus(Character cliStatus) {
        this.cliStatus = cliStatus;
    }

    public Date getCliDtnascimento() {
        return cliDtnascimento;
    }

    public void setCliDtnascimento(Date cliDtnascimento) {
        this.cliDtnascimento = cliDtnascimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.Cliente[ cliId=" + cliId + " ]";
    }
    
}
