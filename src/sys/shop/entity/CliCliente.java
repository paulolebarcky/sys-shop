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
@Table(name = "cli_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CliCliente.findAll", query = "SELECT c FROM CliCliente c"),
    @NamedQuery(name = "CliCliente.findByCliId", query = "SELECT c FROM CliCliente c WHERE c.cliId = :cliId"),
    @NamedQuery(name = "CliCliente.findByCidId", query = "SELECT c FROM CliCliente c WHERE c.cidId = :cidId"),
    @NamedQuery(name = "CliCliente.findByLojId", query = "SELECT c FROM CliCliente c WHERE c.lojId = :lojId"),
    @NamedQuery(name = "CliCliente.findByCliNome", query = "SELECT c FROM CliCliente c WHERE c.cliNome = :cliNome"),
    @NamedQuery(name = "CliCliente.findByCliRg", query = "SELECT c FROM CliCliente c WHERE c.cliRg = :cliRg"),
    @NamedQuery(name = "CliCliente.findByCliTelefone", query = "SELECT c FROM CliCliente c WHERE c.cliTelefone = :cliTelefone"),
    @NamedQuery(name = "CliCliente.findByCliCelular", query = "SELECT c FROM CliCliente c WHERE c.cliCelular = :cliCelular"),
    @NamedQuery(name = "CliCliente.findByCliEndereco", query = "SELECT c FROM CliCliente c WHERE c.cliEndereco = :cliEndereco"),
    @NamedQuery(name = "CliCliente.findByCliCpf", query = "SELECT c FROM CliCliente c WHERE c.cliCpf = :cliCpf"),
    @NamedQuery(name = "CliCliente.findByCliCnpj", query = "SELECT c FROM CliCliente c WHERE c.cliCnpj = :cliCnpj"),
    @NamedQuery(name = "CliCliente.findByCliDescricao", query = "SELECT c FROM CliCliente c WHERE c.cliDescricao = :cliDescricao"),
    @NamedQuery(name = "CliCliente.findByCliDtcadastro", query = "SELECT c FROM CliCliente c WHERE c.cliDtcadastro = :cliDtcadastro"),
    @NamedQuery(name = "CliCliente.findByCliStatus", query = "SELECT c FROM CliCliente c WHERE c.cliStatus = :cliStatus"),
    @NamedQuery(name = "CliCliente.findByCliDtnascimento", query = "SELECT c FROM CliCliente c WHERE c.cliDtnascimento = :cliDtnascimento")})
public class CliCliente implements Serializable {
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

    public CliCliente() {
    }

    public CliCliente(Integer cliId) {
        this.cliId = cliId;
    }

    public CliCliente(Integer cliId, int cidId, int lojId) {
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
        if (!(object instanceof CliCliente)) {
            return false;
        }
        CliCliente other = (CliCliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.CliCliente[ cliId=" + cliId + " ]";
    }
    
}
